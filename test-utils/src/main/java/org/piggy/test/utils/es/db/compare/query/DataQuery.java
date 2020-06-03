package org.piggy.test.utils.es.db.compare.query;

/**
 * @author chenhongfa
 * @date 2020/6/3
 */
public interface DataQuery {

    /**
     * 通过sql语句查询
     *
     * @param sql
     * @return
     */
    String queryBySqlForMap(String sql);
}
