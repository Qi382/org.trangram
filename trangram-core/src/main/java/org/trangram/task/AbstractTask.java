package org.trangram.task;

import org.apache.commons.lang3.StringUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.trangram.config.SchemaContext;
import org.trangram.config.TableContext;
import org.trangram.config.TrangramContext;

import java.io.File;
import java.io.IOException;
import java.io.OutputStream;

/**
 * project : org.trangram
 * author :  liyuqi
 * date : 2017-05-03 18:46
 */
public abstract class AbstractTask implements Task {

    private final static Logger logger = LoggerFactory.getLogger(AbstractTask.class);

    private TypeRender typeRender;
    private String targetDir = "";
    private String template;
    private String prefix = "";
    private String suffix = "";

    public void setTemplate(String template) {
        this.template = template;
    }

    /**
     * 获得模板地址
     *
     * @return 模板地址
     */
    public String getTemplate() {
        return template;
    }


    public String getPrefix() {
        return prefix;
    }

    public void setPrefix(String prefix) {
        this.prefix = prefix;
    }

    public String getSuffix() {
        return suffix;
    }

    public void setSuffix(String suffix) {
        this.suffix = suffix;
    }

    @Override
    public TypeRender getTypeRender() {
        return typeRender;
    }

    public void setTypeRender(TypeRender typeRender) {
        this.typeRender = typeRender;
    }


    public String getTargetDir() {
        return targetDir;
    }

    public void setTargetDir(String targetDir) {
        this.targetDir = targetDir;
    }

    /**
     * 获得输出流
     *
     * @return 输出流
     */
    public abstract OutputStream getOutput(TrangramContext context, SchemaContext schemaContext, TableContext tableContext) throws IOException;

    @Override
    public void doTask(TrangramContext context, SchemaContext schemaContext, TableContext tableContext) {
        TypeRender render = getTypeRender();

        try {
            render.render(context, schemaContext, tableContext, getTemplate(), getOutput(context, schemaContext, tableContext));
        } catch (IOException e) {
            logger.error("渲染错误|{}|{}", tableContext.getSchema(), tableContext.getTableName(), e);
        }
    }

    protected String getTargetPath(TrangramContext context, SchemaContext schemaContext) {
        String rootDir = context.getDestination();

        if (StringUtils.isNotBlank(schemaContext.getDestination())) {
            rootDir = rootDir + File.separator + schemaContext.getDestination();
        }

        String path = rootDir;

        if (StringUtils.isNotBlank(getTargetDir())) {
            path += (File.separator + getTargetDir());
        }

        return path;
    }
}
