package com.pralgomathic.jsonparserandroid.JsonParser;

import com.pralgomathic.jsonparserandroid.model.DataDTO;
import com.pralgomathic.jsonparserandroid.utils.Constants;

import org.json.JSONArray;
import org.json.JSONObject;

import java.util.Collections;
import java.util.LinkedHashMap;
import java.util.Map;

/**
 * Created by jumman on 3/13/18.
 */


public class JsonListBuilder {

    private final String TOPIC_LIST = "list";
    private final String TOPIC_ID = "id";
    private final String TOPIC_TITLE = "title";

    private String jsonUrl;

    public JsonListBuilder(String jsonUrl) {
        this.jsonUrl = jsonUrl;
    }

    public DataDTO getTopicList() {
        DataDTO dataDto = new DataDTO();
        JsonParser jsonParser;
        Map<Long, DataDTO> topicListMap = Collections.synchronizedMap(new LinkedHashMap<Long, DataDTO>());

        JSONObject jsonObject;
        try {
            jsonParser = new JsonParser();
            jsonObject = jsonParser.getJSONFromUrl(jsonUrl);
            JSONArray jsonArray = jsonObject.getJSONArray(TOPIC_LIST);
            Constants.debugLog("JsonListBuilder", jsonObject.toString());
            for (int i = 0; i < jsonArray.length(); i++) {
                JSONObject jsonArrayJSONObject = jsonArray.getJSONObject(i);
                DataDTO dataDtoTwo = new DataDTO();
                dataDtoTwo.setTopicId(jsonArrayJSONObject.getLong(TOPIC_ID));
                dataDtoTwo.setTopicTitle(jsonArrayJSONObject.getString(TOPIC_TITLE));

                if (topicListMap != null) {
                    topicListMap.put(jsonArrayJSONObject.getLong(TOPIC_ID), dataDtoTwo);
                }
            }
            Constants.debugLog("JsonListBuilder", "Total List " + topicListMap.size());
            dataDto.setTopicListMap(topicListMap);

        } catch (Exception ex) {
            ex.printStackTrace();
        }
        return dataDto;
    }

}