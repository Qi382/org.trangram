package org.trangram.types;

/**
 * project : org.trangram
 * author :  liyuqi
 * date : 2017-05-03 14:46
 */
public class Table extends DbTypes {

    private String schema;

    private String tableName;

    private String domainObjectName;

    //如果别名不为空,则使用别名
    private String alias;

    private String comment;

    public String getSchema() {
        return schema;
    }

    public void setSchema(String schema) {
        this.schema = schema;
    }

    public String getTableName() {
        return tableName;
    }

    public void setTableName(String tableName) {
        this.tableName = tableName;
    }

    public String getDomainObjectName() {
        return domainObjectName;
    }

    public void setDomainObjectName(String domainObjectName) {
        this.domainObjectName = domainObjectName;
    }

    public String getAlias() {
        return alias;
    }

    public void setAlias(String alias) {
        this.alias = alias;
    }

    public String getComment() {
        return comment;
    }

    public void setComment(String comment) {
        this.comment = comment;
    }
}
