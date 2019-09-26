package com.mist.samples.jibemapnavigation;

import android.graphics.PointF;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;

import androidx.appcompat.app.AppCompatActivity;

import com.mist.mstwayfindingkit.listeners.NavigationUpdateCallback;
import com.mist.mstwayfindingkit.maps.JibestreamMap;
import com.mist.mstwayfindingkit.model.MSTArrivalResult;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {
    JibestreamMap map;
    Button navigate, stop;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        navigate = findViewById(R.id.navigate);
        stop = findViewById(R.id.stop);
        navigate.setOnClickListener(this);
        stop.setOnClickListener(this);
        map = JibestreamMap.newInstance("YOUR_SDK_SECRET");
        getSupportFragmentManager().beginTransaction().add(R.id.container, map, "Jmap").commit();
        map.disableTaponElement();// disable tap on navigation if you want to navigate programmatically and disallow user to tap,
    }

    @Override
    public void onClick(View v) {
        if (v.getId() == R.id.navigate) {
            navigate();
        } else if (v.getId() == R.id.stop) {
            stop();
        }
    }

    private void navigate() {
        // 2500 is used as random x,y coordinate, which is in pixels of map image used and then we are getting the nearest waypoint to draw the destination.
        if (map != null) {
            map.navigateSilentlyToDestination(map.getNearestWaypoint(new PointF(2500, 2500)), new NavigationUpdateCallback() {
                @Override
                public void navigatationUpdate(MSTArrivalResult mstArrivalResult) {
                    Log.i("Navigation Update", mstArrivalResult.toString());
                }
            });
        }
    }

    private void stop() {
        if (map != null) {
            map.stopNavigation();
        }
    }
}
