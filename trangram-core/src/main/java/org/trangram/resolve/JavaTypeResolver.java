package org.trangram.resolve;

/**
 * project : org.trangram
 * author :  liyuqi
 * date : 2017-05-03 14:05
 */
public interface JavaTypeResolver {
    void addResolver(String jdbcType, String javaType);

    String resolve(String jdbcType);
}
