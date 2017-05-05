package org.trangram.rules;

import org.trangram.types.DbTypes;

/**
 * 获取到对象时根据规则过滤
 * project : org.trangram
 * author :  liyuqi
 * date : 2017-05-03 14:51
 */
public interface Rule {

    /**
     * 过滤对象
     *
     * @param types types
     */
    void apply(DbTypes types);

}
