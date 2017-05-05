package org.trangram.config;

import java.util.Properties;

/**
 * project : org.trangram
 * author :  liyuqi
 * date : 2017-05-03 13:24
 */
public abstract class PropertyHolder {
    private Properties ext;

    public PropertyHolder() {
        ext = new Properties();
    }

    public void addProperty(String name, String value) {
        ext.setProperty(name, value);
    }

    public String getProperty(String name) {
        return ext.get(name).toString();
    }

    public void setExt(Properties ext) {
        this.ext = ext;
    }

    public Properties getExt() {
        return ext;
    }
}
