package org.trangram.types;

import java.util.List;

/**
 * 联合主键
 * project : org.trangram
 * author :  liyuqi
 * date : 2017-05-03 15:48
 */
public class IdentityKey {
    private List<String> columns;

    public List<String> getColumns() {
        return columns;
    }

    public void setColumns(List<String> columns) {
        this.columns = columns;
    }
}
