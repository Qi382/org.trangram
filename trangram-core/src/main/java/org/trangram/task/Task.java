package org.trangram.task;

import org.trangram.config.SchemaContext;
import org.trangram.config.TableContext;
import org.trangram.config.TrangramContext;

/**
 * project : org.trangram
 * author :  liyuqi
 * date : 2017-05-03 15:26
 */
public interface Task {

    TypeRender getTypeRender();

    void doTask(TrangramContext context, SchemaContext schemaContext, TableContext tableContext);
}
