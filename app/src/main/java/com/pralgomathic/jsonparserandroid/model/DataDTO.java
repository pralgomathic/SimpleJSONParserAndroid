package com.pralgomathic.jsonparserandroid.model;

import java.util.Map;

/**
 * Created by jumman on 3/13/18.
 */

public class DataDTO {
    private Long topicId;
    private String topicTitle;
    private Map<Long,DataDTO> topicListMap;

    public DataDTO(){
        super();
    }
    public Long getTopicId() {
        return topicId;
    }

    public void setTopicId(Long topicId) {
        this.topicId = topicId;
    }

    public String getTopicTitle() {
        return topicTitle;
    }

    public void setTopicTitle(String topicTitle) {
        this.topicTitle = topicTitle;
    }

    public Map<Long, DataDTO> getTopicListMap() {
        return topicListMap;
    }

    public void setTopicListMap(Map<Long, DataDTO> topicListMap) {
        this.topicListMap = topicListMap;
    }


}
