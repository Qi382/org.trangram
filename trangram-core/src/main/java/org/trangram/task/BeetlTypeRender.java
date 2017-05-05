package org.trangram.task;

import org.beetl.core.GroupTemplate;
import org.beetl.core.Template;
import org.trangram.config.SchemaContext;
import org.trangram.config.TableContext;
import org.trangram.config.TrangramContext;

import java.io.IOException;
import java.io.OutputStream;

/**
 * project : org.trangram
 * author :  liyuqi
 * date : 2017-05-04 13:53
 */
public class BeetlTypeRender implements TypeRender {

    private GroupTemplate groupTemplate = null;

    public GroupTemplate getGroupTemplate() {
        return groupTemplate;
    }

    public void setGroupTemplate(GroupTemplate groupTemplate) {
        this.groupTemplate = groupTemplate;
    }


    @Override
    public String render(TrangramContext context,
                         SchemaContext schemaContext,
                         TableContext tableContext, String tpl, OutputStream outputStream) throws IOException {
        Template template = getGroupTemplate().getTemplate(tpl);
        template.binding("ctx", context);
        template.binding("schema", schemaContext);
        template.binding("table", tableContext);
        template.binding("serialVersionUID"
                , (tableContext.getSchema().hashCode() * tableContext.getTableName().hashCode()) + "L");

        tableContext.apply();

        String content = template.render();

        outputStream.write(content.getBytes());

        return content;
    }


}
