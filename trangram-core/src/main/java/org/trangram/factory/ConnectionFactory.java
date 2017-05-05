package org.trangram.factory;

import java.sql.Connection;
import java.sql.SQLException;

/**
 * project : org.trangram
 * author :  liyuqi
 * date : 2017-05-03 13:38
 */
public interface ConnectionFactory {
    Connection connect() throws SQLException;
}
