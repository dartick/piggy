package org.piggy.test.utils.controller;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.piggy.test.utils.es.db.compare.comparator.JsonPatchComparator;
import org.piggy.test.utils.es.db.compare.model.CompareQTO;
import org.piggy.test.utils.es.db.compare.query.DBQuery;
import org.piggy.test.utils.es.db.compare.query.EsQuery;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author chenhongfa
 * @date 2020/6/3
 */
@RestController
@RequestMapping("/compare")
@Api(description = "比对模块")
public class CompareController {

    @Autowired
    private DBQuery dbQuery;

    @Autowired
    private EsQuery esQuery;

    @Autowired
    private JsonPatchComparator jsonPatchComparator;

    @PostMapping("/by/sql")
    @ApiOperation("通过sql查询比对结果")
    public String compareBySql(@RequestBody CompareQTO compareQTO) {
        String sourceJson = dbQuery.queryBySqlForMap(compareQTO.getDbSql());
        String targetJson = esQuery.queryBySqlForMap(compareQTO.getEsSql());
        return jsonPatchComparator.compare(sourceJson, targetJson);
    }
}
