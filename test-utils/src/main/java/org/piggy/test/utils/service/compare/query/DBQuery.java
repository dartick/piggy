package org.piggy.test.utils.service.compare.query;

import com.alibaba.fastjson.JSON;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.ColumnMapRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.Map;

/**
 * @author chenhongfa
 * @date 2020/6/2
 */
@Component
public class DBQuery implements DataQuery {

    @Autowired
    private JdbcTemplate jdbcTemplate;

    @Override
    public String queryBySqlForMap(String sql) {
        List<Map<String, Object>> result = jdbcTemplate.query(sql, new ColumnMapRowMapper());
        return JSON.toJSONString(result);
    }
}
