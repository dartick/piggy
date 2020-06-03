package org.piggy.test.utils.service.compare.query;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import org.apache.http.util.EntityUtils;
import org.elasticsearch.client.Request;
import org.elasticsearch.client.Response;
import org.elasticsearch.client.RestClient;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.io.IOException;

/**
 * @author chenhongfa
 * @date 2020/6/3
 */
@Component
public class EsQuery implements DataQuery {

    private Logger logger = LoggerFactory.getLogger(EsQuery.class);

    @Autowired
    private RestClient restClient;

    @Override
    public String queryBySqlForMap(String sql) {
        String[] methodAndEndpoint = sql.split(" ");
        String method = methodAndEndpoint[0];
        String endpoint = methodAndEndpoint[1];
        Request request = new Request(method, endpoint);
        try {
            Response response = restClient.performRequest(request);
            String responseBody = EntityUtils.toString(response.getEntity());
            JSONObject jsonObject = JSON.parseObject(responseBody);
            JSONObject sourceJsonObject = jsonObject.getJSONObject("_source");
            return sourceJsonObject.toJSONString();
        } catch (IOException e) {
            logger.error("查询es发生异常： {}", sql, e);
            return "";
        }
    }
}
