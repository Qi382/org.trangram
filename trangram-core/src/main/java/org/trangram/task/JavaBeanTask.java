package org.trangram.task;

import org.apache.commons.lang3.StringUtils;
import org.trangram.config.SchemaContext;
import org.trangram.config.TableContext;
import org.trangram.config.TrangramContext;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStream;

/**
 * project : org.trangram
 * author :  liyuqi
 * date : 2017-05-03 15:22
 */
public class JavaBeanTask extends AbstractTask {

    private String targetPackage;

    public String getTargetPackage() {
        return targetPackage;
    }

    public void setTargetPackage(String targetPackage) {
        this.targetPackage = targetPackage;
    }

    @Override
    public OutputStream getOutput(TrangramContext context, SchemaContext schemaContext, TableContext tableContext) throws IOException {

        String path = getTargetPath(context, schemaContext);

        String rootPackage = context.getTargetPackage();
        if (StringUtils.isNotBlank(schemaContext.getTargetPackage())) {
            rootPackage = rootPackage + "." + schemaContext.getTargetPackage();
        }

        if (StringUtils.isNotBlank(getTargetPackage())) {
            rootPackage = rootPackage + "." + getTargetPackage();
        }

        tableContext.addProperty("package", rootPackage);

        File dir = new File(path);
        if (!dir.exists()) {
            dir.mkdirs();
        }

        File file = new File(path + File.separator + getRenderFileName(tableContext));

        return new FileOutputStream(file, false);
    }



    protected String getRenderFileName(TableContext tableContext) {
        return getPrefix() + tableContext.getDomainObjectName() + getSuffix();
    }
}
