package org.trangram.factory;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.trangram.config.TrangramContext;
import org.trangram.types.Table;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;

/**
 * project : org.trangram
 * author :  liyuqi
 * date : 2017-05-03 18:36
 */
public class MysqlTableFactory implements TableFactory {

    private final static Logger logger = LoggerFactory.getLogger(MysqlTableFactory.class);

    @Override
    public void setTable(TrangramContext context, Table table) {
        try (Connection connection = context.getConnectionFactory().connect()) {
            Statement cmd = connection.createStatement();
            String sql = String.format("select TABLE_COMMENT from tables " +
                    "where table_schema='%s' and  table_name ='%s' limit 1", table.getSchema(), table.getTableName());

            logger.info("获取表名备注|{}|{}", table.getSchema() + "." + table.getTableName(), sql);
            ResultSet rs = cmd.executeQuery(sql);

            if (rs != null && rs.next()) {
                table.setComment(rs.getString(1));
                logger.info("设置表名备注|{}|{}|{}", table.getSchema(), table.getTableName(), table.getComment());
            }
        } catch (Exception e) {
            logger.error("设置表格注释失败|{}|{}", table.getSchema(), table.getTableName(), e);
        }
    }
}
