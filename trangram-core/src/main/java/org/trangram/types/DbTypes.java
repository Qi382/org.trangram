package org.trangram.types;

import org.trangram.config.PropertyHolder;
import org.trangram.rules.Rule;

import java.util.List;

/**
 * project : org.trangram
 * author :  liyuqi
 * date : 2017-05-03 14:56
 */
public abstract class DbTypes extends PropertyHolder {

    public static final String TYPE_COLUMN = "_column_";
    public static final String TYPE_TABLE = "_table_";
    public static final String TYPE_SCHEMA = "_schema_";
    /**
     * 类型 , 如model,service
     */
    private String type;
    private List<Rule> rules = null;

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public List<Rule> getRules() {
        return rules;
    }

    public void setRules(List<Rule> rules) {
        this.rules = rules;
    }

    public void apply() {
        if (rules != null && rules.size() > 0) {
            for (Rule rule : rules) {
                rule.apply(this);
            }
        }
    }
}
