package org.trangram.resolve;

import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

/**
 * project : org.trangram
 * author :  liyuqi
 * date : 2017-05-03 14:12
 */
public abstract class AbstractJavaTypeResolver implements JavaTypeResolver {

    private Map<String, String> typeMapping = new ConcurrentHashMap<>();

    public AbstractJavaTypeResolver() {
        init();
    }

    protected abstract void init();

    @Override
    public void addResolver(String jdbcType, String javaType) {
        typeMapping.put(jdbcType, javaType);
    }

    @Override
    public String resolve(String jdbcType) {
        return typeMapping.get(jdbcType);
    }
}
