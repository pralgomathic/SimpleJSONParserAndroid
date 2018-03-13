package com.pralgomathic.jsonparserandroid;

import android.app.ProgressDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import com.pralgomathic.jsonparserandroid.JsonParser.JsonListLoaded;
import com.pralgomathic.jsonparserandroid.JsonParser.JsonManager;
import com.pralgomathic.jsonparserandroid.model.DataDTO;
import com.pralgomathic.jsonparserandroid.utils.Constants;

public class MainActivity extends AppCompatActivity implements JsonListLoaded{

    private static final String TAG = "MainActivity";
    private ProgressDialog progressBar;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        progressBar = ProgressDialog.show(this, "Topic Loading", "Please Wait...");
        progressBar.setCancelable(true);
        loadData();
    }
    private void loadData() {

        JsonManager jsonManager = new JsonManager(this);
        jsonManager.execute(Constants.BASE_URL);
    }
    @Override
    public void onJsonListLoaded(DataDTO dataDTO) {
        try {
            Constants.debugLog(TAG, " topic id  " + dataDTO.getTopicId());
            Constants.debugLog(TAG, " topic title " + dataDTO.getTopicTitle());
            Constants.debugLog(TAG, "Total List " + dataDTO.getTopicListMap().size());
            if (progressBar.isShowing()) {
                progressBar.dismiss();
            }

        }catch (Exception ex){
            Constants.errorLog(TAG, "" + ex.toString());
        }

    }
}
