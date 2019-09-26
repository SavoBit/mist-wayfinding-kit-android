package com.mist.samples.jibemapbluedot;

import android.os.Bundle;

import androidx.appcompat.app.AppCompatActivity;

import com.mist.mstwayfindingkit.maps.JibestreamMap;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        getSupportFragmentManager().beginTransaction().add(R.id.container, JibestreamMap.newInstance("YOUR_SDK_SECRET"), "Jmap").commit();
    }

}
