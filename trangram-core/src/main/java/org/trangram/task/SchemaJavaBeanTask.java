package org.trangram.task;

import org.trangram.config.SchemaContext;
import org.trangram.config.TableContext;
import org.trangram.config.TrangramContext;

import java.io.IOException;
import java.io.OutputStream;

/**
 * project : org.trangram
 * author :  liyuqi
 * date : 2017-05-05 10:43
 */
public class SchemaJavaBeanTask extends JavaBeanTask {

    @Override
    public OutputStream getOutput(TrangramContext context, SchemaContext schemaContext, TableContext tableContext) throws IOException {
        return super.getOutput(context, schemaContext, tableContext);
    }
}
