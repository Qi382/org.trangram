package org.trangram.factory;

import org.trangram.config.TrangramContext;
import org.trangram.types.Column;
import org.trangram.types.Table;

import java.sql.SQLException;
import java.util.List;

/**
 * project : org.trangram
 * author :  liyuqi
 * date : 2017-05-03 16:36
 */
public interface ColumnFactory {
    List<Column> setColumns(TrangramContext context,Table table) ;
}
