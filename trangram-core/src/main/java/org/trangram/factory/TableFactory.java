package org.trangram.factory;

import org.trangram.config.TrangramContext;
import org.trangram.types.Table;

/**
 * project : org.trangram
 * author :  liyuqi
 * date : 2017-05-03 18:35
 */
public interface TableFactory {
    void setTable(TrangramContext context, Table table);
}
