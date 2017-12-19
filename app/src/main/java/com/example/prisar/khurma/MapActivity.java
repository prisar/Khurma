package com.example.prisar.khurma;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.Button;

import com.google.android.gms.maps.CameraUpdateFactory;
import com.google.android.gms.maps.GoogleMap;
import com.google.android.gms.maps.MapFragment;
import com.google.android.gms.maps.OnMapReadyCallback;
import com.google.android.gms.maps.model.CameraPosition;
import com.google.android.gms.maps.model.LatLng;

public class MapActivity extends AppCompatActivity implements OnMapReadyCallback {

    private GoogleMap mMap;
    private boolean mapReady = false;

    static final LatLng newYork = new LatLng(40.7484, -73.9857);
    static final LatLng seattle = new LatLng(47.6204, -122.3491);
    static final LatLng tokyo = new LatLng(40.7127, 74.0059);
    static final LatLng dublin = new LatLng(53.3478, 6.2597);

    static final CameraPosition NEWYORK = CameraPosition.builder()
            .target(newYork)
            .zoom(21)
            .bearing(0)
            .tilt(45)
            .build();

    static final CameraPosition SEATTLE = CameraPosition.builder()
            .target(seattle)
            .zoom(17)
            .bearing(0)
            .tilt(45)
            .build();

    static final CameraPosition TOKYO = CameraPosition.builder()
            .target(tokyo)
            .zoom(17)
            .bearing(90)
            .tilt(45)
            .build();

    static final CameraPosition DUBLIN = CameraPosition.builder()
            .target(dublin)
            .zoom(17)
            .bearing(90)
            .tilt(45)
            .build();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_map);

        Button btnSeattle = (Button) findViewById(R.id.btnSeattle);
        btnSeattle.setOnClickListener((v) -> {
            if(mapReady)
                flyTo(SEATTLE);
        });

        Button btnTokyo = (Button) findViewById(R.id.btnTokyo);
        btnTokyo.setOnClickListener((v) -> {
            if(mapReady)
                flyTo(TOKYO);
        });

        Button btnDublin = (Button) findViewById(R.id.btnDublin);
        btnDublin.setOnClickListener((v) -> {
            if(mapReady)
                flyTo(DUBLIN);
        });

        MapFragment mapFragment = (MapFragment) getFragmentManager()
                .findFragmentById(R.id.mapOutput);
        mapFragment.getMapAsync(this);
    }

    @Override
    public void onMapReady(GoogleMap googleMap) {
        mapReady = true;
        mMap = googleMap;
        mMap.setMapType(GoogleMap.MAP_TYPE_SATELLITE);
        flyTo(NEWYORK);
    }

    public void flyTo(CameraPosition target) {
        mMap.animateCamera(CameraUpdateFactory.newCameraPosition(target), 10000, null);
    }
}
