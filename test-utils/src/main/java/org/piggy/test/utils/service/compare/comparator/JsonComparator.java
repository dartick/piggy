package org.piggy.test.utils.service.compare.comparator;

/**
 * @author chenhongfa
 * @date 2020/6/3
 */
public interface JsonComparator {

    /**
     * 比对json字符串
     *
     * @param sourceJson
     * @param targetJson
     * @return 比对结果
     */
    String compare(String sourceJson, String targetJson);
}
