package org.piggy.test.utils.service.compare.comparator;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.flipkart.zjsonpatch.JsonDiff;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

/**
 * @author chenhongfa
 * @date 2020/6/3
 */
@Component
public class JsonPatchComparator implements JsonComparator {

    private Logger logger = LoggerFactory.getLogger(JsonPatchComparator.class);

    @Autowired
    private ObjectMapper objectMapper;

    @Override
    public String compare(String sourceJson, String targetJson) {
        JsonNode sourceNode = null;
        try {
            sourceNode = objectMapper.readTree(sourceJson);
        } catch (JsonProcessingException e) {
            logger.error("解析sourceJson发生异常: {}", sourceJson, e);
            throw new RuntimeException(e);
        }
        JsonNode targetNode = null;
        try {
            targetNode = objectMapper.readTree(targetJson);
        } catch (JsonProcessingException e) {
            logger.error("解析targetJson发生异常: {}", sourceJson, e);
            throw new RuntimeException(e);
        }
        JsonNode patch = JsonDiff.asJson(sourceNode, targetNode);
        return patch.toString();
    }
}
