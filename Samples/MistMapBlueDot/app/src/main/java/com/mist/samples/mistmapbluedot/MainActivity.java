package com.mist.samples.mistmapbluedot;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;

import com.mist.mstwayfindingkit.maps.JibestreamMap;
import com.mist.mstwayfindingkit.maps.MistMap;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        getSupportFragmentManager().beginTransaction().add(R.id.container, MistMap.newInstance("YOUR_SDK_SECRET"), "MistMap").commit();
    }

}




