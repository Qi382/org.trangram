package org.trangram.resolve;

/**
 * project : org.trangram
 * author :  liyuqi
 * date : 2017-05-03 14:18
 */
public class ProviededJavaTypeResolver extends AbstractJavaTypeResolver {

    public ProviededJavaTypeResolver() {
        super();
    }

    @Override
    protected void init() {
        addResolver("varchar", "String");
        addResolver("char", "String");
        addResolver("longtext", "String");
        addResolver("text", "String");
        addResolver("unsigned int", "Long");
        addResolver("int", "Integer");
        addResolver("tinyint", "Integer");
        addResolver("mediumint", "Integer");
        addResolver("bigint", "java.math.BigInteger");
        addResolver("bit", "Boolean");
        addResolver("float", "Float");
        addResolver("double", "Double");
        addResolver("decimal", "java.math.BigDecimal");
        addResolver("date", "java.sql.Date");
        addResolver("time", "java.sql.Time");
        addResolver("datetime", "java.sql.Timestamp");
        addResolver("timestamp", "java.sql.Timestamp");
        addResolver("blob", "byte[]");
    }
}
