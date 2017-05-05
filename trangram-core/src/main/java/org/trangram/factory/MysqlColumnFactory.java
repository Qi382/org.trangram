package org.trangram.factory;

import org.apache.commons.lang3.StringUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.trangram.resolve.JavaTypeResolver;
import org.trangram.config.TrangramContext;
import org.trangram.types.Column;
import org.trangram.types.DbTypes;
import org.trangram.types.Table;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.LinkedList;
import java.util.List;

/**
 * project : org.trangram
 * author :  liyuqi
 * date : 2017-05-03 16:37
 */
public class MysqlColumnFactory implements ColumnFactory {

    private final static Logger logger = LoggerFactory.getLogger(MysqlColumnFactory.class);

    private JavaTypeResolver typeResolver;

    public JavaTypeResolver getTypeResolver() {
        return typeResolver;
    }

    public void setTypeResolver(JavaTypeResolver typeResolver) {
        this.typeResolver = typeResolver;
    }

    @Override
    public List<Column> setColumns(TrangramContext context, Table table) {

        try (Connection connection = context.getConnectionFactory().connect()) {
            String sql = String.format("select COLUMN_NAME,COLUMN_DEFAULT ,IS_NULLABLE ,DATA_TYPE, COLUMN_TYPE ,COLUMN_KEY ,COLUMN_COMMENT " +
                            " from COLUMNS where table_schema='%s' and TABLE_NAME ='%s' order by ORDINAL_POSITION"
                    , table.getSchema(), table.getTableName());

            Statement cmd = connection.createStatement();
            logger.info("获取列的详细信息|MySql|{}|{}", table.getSchema(), table.getTableName());
            ResultSet rs = cmd.executeQuery(sql);

            List<Column> columnInstances = new LinkedList<>();

            while (rs.next()) {
                Column columnInstance = new Column();
                columnInstance.setType(DbTypes.TYPE_COLUMN);

                //region 设置字段属性
                columnInstance.setColumnName(rs.getString("COLUMN_NAME"));
                columnInstance.setDefaultValue(rs.getString("COLUMN_DEFAULT"));
                columnInstance.setNullable("YES".equalsIgnoreCase(rs.getString("IS_NULLABLE")));
                columnInstance.setJdbcType(rs.getString("DATA_TYPE"));
                columnInstance.setIdentity("PRI".equals(rs.getString("COLUMN_KEY")));
                columnInstance.setComment(rs.getString("COLUMN_COMMENT"));

                //java
                columnInstance.setJavaProperty(rs.getString("COLUMN_NAME"));
                columnInstance.setJavaMethod(StringUtils.capitalize(columnInstance.getJavaProperty()));
                columnInstance.setJavaType(typeResolver.resolve(columnInstance.getJdbcType()));

                //endregion

                logger.info("设置字段{}", columnInstance);

                columnInstances.add(columnInstance);
            }

            return columnInstances;

        } catch (SQLException e) {
            logger.error("生成Column错误|{}|{}", table.getSchema(), table.getTableName(), e);
        }

        return null;
    }
}
