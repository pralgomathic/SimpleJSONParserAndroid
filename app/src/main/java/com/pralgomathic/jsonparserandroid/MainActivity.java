package com.pralgomathic.jsonparserandroid;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import com.pralgomathic.jsonparserandroid.JsonParser.JsonListLoaded;
import com.pralgomathic.jsonparserandroid.model.DataDTO;

public class MainActivity extends AppCompatActivity implements JsonListLoaded{


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    @Override
    public void onJsonListLoaded(DataDTO dataDTO) {

    }
}
