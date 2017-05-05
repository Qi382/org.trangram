package org.trangram.resolve;

import org.trangram.config.SchemaContext;
import org.trangram.config.TableContext;
import org.trangram.config.TrangramContext;

/**
 * project : org.trangram
 * author :  liyuqi
 * date : 2017-05-05 10:33
 */
public interface NameResolver {
    /**
     * 根据当前context生成名称
     *
     * @param placeholder   key
     * @param context       context
     * @param schemaContext schema
     * @param tableContext  table
     * @return
     */
    String resolve(String placeholder, TrangramContext context, SchemaContext schemaContext, TableContext tableContext);
}
