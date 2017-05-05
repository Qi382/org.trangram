package org.trangram.types;

/**
 * project : org.trangram
 * author :  liyuqi
 * date : 2017-05-03 14:49
 */
public class Schema extends DbTypes {
    private String targetPackage;
    private String schema;
    private String comment;

    public String getTargetPackage() {
        return targetPackage;
    }

    public void setTargetPackage(String targetPackage) {
        this.targetPackage = targetPackage;
    }

    public String getSchema() {
        return schema;
    }

    public void setSchema(String schema) {
        this.schema = schema;
    }

    public String getComment() {
        return comment;
    }

    public void setComment(String comment) {
        this.comment = comment;
    }
}
