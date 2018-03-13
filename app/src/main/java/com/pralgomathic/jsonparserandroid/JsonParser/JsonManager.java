package com.pralgomathic.jsonparserandroid.JsonParser;

import android.os.AsyncTask;

import com.pralgomathic.jsonparserandroid.model.DataDTO;

/**
 * Created by jumman on 3/13/18.
 */


public class JsonManager extends AsyncTask<String, Void, Void> {
    private DataDTO dataDTO;
    private JsonListLoaded listener;

    public JsonManager(JsonListLoaded listener) {
        this.listener = listener;
    }

    @Override
    protected Void doInBackground(String... url) {
        try {
            JsonListBuilder dataJson = new JsonListBuilder(url[0]);
            dataDTO = dataJson.getTopicList();
        } catch (Exception e) {
            e.printStackTrace();
        }
        if (dataDTO == null) {
            dataDTO = new DataDTO();
        }
        return null;
    }

    @Override
    protected void onPostExecute(Void result) {
        super.onPostExecute(result);
        listener.onJsonListLoaded(dataDTO);
    }

    @Override
    protected void onPreExecute() {
        super.onPreExecute();
    }
}