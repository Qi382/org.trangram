package org.trangram.types;

/**
 * project : org.trangram
 * author :  liyuqi
 * date : 2017-05-03 14:38
 */
public class Column extends DbTypes {
    private String jdbcType;
    private String columnName;
    private String javaType;
    private String javaProperty;
    private String javaMethod;


    private boolean nullable;

    private boolean identity;

    private String comment;

    private String defaultValue;

    public String getColumnName() {
        return columnName;
    }

    public void setColumnName(String columnName) {
        this.columnName = columnName;
    }

    public String getJavaProperty() {
        return javaProperty;
    }

    public void setJavaProperty(String javaProperty) {
        this.javaProperty = javaProperty;
    }

    public String getJavaMethod() {
        return javaMethod;
    }

    public void setJavaMethod(String javaMethod) {
        this.javaMethod = javaMethod;
    }

    public String getJdbcType() {
        return jdbcType;
    }

    public void setJdbcType(String jdbcType) {
        this.jdbcType = jdbcType;
    }

    public String getJavaType() {
        return javaType;
    }

    public void setJavaType(String javaType) {
        this.javaType = javaType;
    }

    public boolean getNullable() {
        return nullable;
    }

    public void setNullable(boolean nullable) {
        this.nullable = nullable;
    }

    public boolean getIdentity() {
        return identity;
    }

    public void setIdentity(boolean identity) {
        this.identity = identity;
    }

    public String getComment() {
        return comment;
    }

    public void setComment(String comment) {
        this.comment = comment;
    }

    public String getDefaultValue() {
        return defaultValue;
    }

    public void setDefaultValue(String defaultValue) {
        this.defaultValue = defaultValue;
    }

    @Override
    public String toString() {
        final StringBuilder sb = new StringBuilder("Column{");
        sb.append("columnName='").append(columnName).append('\'');
        sb.append("|javaProperty='").append(javaProperty).append('\'');
        sb.append("|jdbcType='").append(jdbcType).append('\'');
        sb.append("|javaType='").append(javaType).append('\'');
        sb.append("|nullable=").append(nullable);
        sb.append("|identity=").append(identity);
        sb.append("|comment='").append(comment).append('\'');
        sb.append("|defaultValue='").append(defaultValue).append('\'');
        sb.append('}');
        return sb.toString();
    }
}
