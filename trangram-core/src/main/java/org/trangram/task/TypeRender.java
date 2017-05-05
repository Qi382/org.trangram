package org.trangram.task;

import org.trangram.config.SchemaContext;
import org.trangram.config.TableContext;
import org.trangram.config.TrangramContext;

import java.io.IOException;
import java.io.OutputStream;

/**
 * project : org.trangram
 * author :  liyuqi
 * date : 2017-05-03 15:02
 */
public interface TypeRender {
    /**
     * 渲染对象
     *
     * @param context      context
     * @param schemaContext schemaContext
     * @param tableContext tableContext
     * @param tpl          模板位置
     * @param outputStream 输出
     * @return 渲染结果
     */
    String render(TrangramContext context, SchemaContext schemaContext, TableContext tableContext, String tpl, OutputStream outputStream) throws IOException;
}
