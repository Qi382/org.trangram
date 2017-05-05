package org.trangram.factory;

import org.apache.commons.lang3.StringUtils;
import org.trangram.config.JDBCConnectionConfiguration;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

/**
 * project : org.trangram
 * author :  liyuqi
 * date : 2017-05-03 13:39
 */
public class SimpleConnectonFactory implements ConnectionFactory {

    private boolean initialized = false;
    private JDBCConnectionConfiguration jdbcConnectionConfiguration;

    public JDBCConnectionConfiguration getJdbcConnectionConfiguration() {
        return jdbcConnectionConfiguration;
    }

    public void setJdbcConnectionConfiguration(JDBCConnectionConfiguration jdbcConnectionConfiguration) {
        this.jdbcConnectionConfiguration = jdbcConnectionConfiguration;
    }

    @Override
    public synchronized Connection connect() throws SQLException {
        final JDBCConnectionConfiguration config = getJdbcConnectionConfiguration();
        if (!initialized) {
            if (config == null) {
                throw new IllegalArgumentException("参数错误,需要JDBC连接配置");
            }

            if (StringUtils.isBlank(config.getConnectionURL()) || StringUtils.isBlank(config.getDriverClass())) {
                throw new IllegalArgumentException("参数错误,JDBC连接配置错误,url或driver为空");
            }


            try {
                Class.forName(config.getDriverClass());
            } catch (ClassNotFoundException e) {
                throw new IllegalArgumentException("参数错误,无法加载JDBC", e);
            }

            initialized = true;
        }

        Connection connection = DriverManager.getConnection(config.getConnectionURL(), config.getUserId(), config.getPassword());

        return connection;
    }
}
