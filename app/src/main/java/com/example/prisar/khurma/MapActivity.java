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

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_map);

        Button btnMap = (Button) findViewById(R.id.btnMap);
        btnMap.setOnClickListener((v) -> {
            if(mapReady)
                mMap.setMapType(GoogleMap.MAP_TYPE_NORMAL);
        });

        Button btnSatellite = (Button) findViewById(R.id.btnSatellite);
        btnSatellite.setOnClickListener((v) -> {
            if(mapReady)
                mMap.setMapType(GoogleMap.MAP_TYPE_SATELLITE);
        });

        Button btnHybrid = (Button) findViewById(R.id.btnHybrid);
        btnHybrid.setOnClickListener((v) -> {
            if(mapReady)
                mMap.setMapType(GoogleMap.MAP_TYPE_HYBRID);
        });

        MapFragment mapFragment = (MapFragment) getFragmentManager()
                .findFragmentById(R.id.mapOutput);
        mapFragment.getMapAsync(this);
    }

    @Override
    public void onMapReady(GoogleMap googleMap) {
        mapReady = true;
        mMap = googleMap;
        LatLng newYork = new LatLng(40.7484, -73.9857);
        CameraPosition target = CameraPosition.builder().target(newYork).zoom(17).tilt(65).build();
        mMap.moveCamera(CameraUpdateFactory.newCameraPosition(target));
    }
}
