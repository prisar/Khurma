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

        Button btnSeattle = (Button) findViewById(R.id.btnSeattle);
        btnSeattle.setOnClickListener((v) -> {
            if(mapReady){
                LatLng seattle = new LatLng(47.6204, -122.3491);
                CameraPosition cp = CameraPosition.builder().target(seattle).zoom(14).bearing((float) 112.5).tilt(65).build();
                mMap.animateCamera(CameraUpdateFactory.newCameraPosition(cp), 5000, null);
            }
        });

        Button btnTokyo = (Button) findViewById(R.id.btnTokyo);
        btnTokyo.setOnClickListener((v) -> {
            if(mapReady) {
                LatLng tokyo = new LatLng(40.7127, 74.0059);
                CameraPosition cp = CameraPosition.builder().target(tokyo).zoom(14).bearing((float) 112.5).tilt(65).build();
                mMap.animateCamera(CameraUpdateFactory.newCameraPosition(cp), 5000, null);
            }
        });

        Button btnDublin = (Button) findViewById(R.id.btnDublin);
        btnDublin.setOnClickListener((v) -> {
            if(mapReady){
                LatLng dublin = new LatLng(53.3478, 6.2597);
                CameraPosition cp = CameraPosition.builder().target(dublin).zoom(14).bearing((float) 112.5).tilt(65).build();
                mMap.animateCamera(CameraUpdateFactory.newCameraPosition(cp), 5000, null);
            }
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
        CameraPosition target = CameraPosition.builder().target(newYork).zoom(17).bearing((float) 112.5).tilt(65).build();
        mMap.moveCamera(CameraUpdateFactory.newCameraPosition(target));
        mMap.setMapType(GoogleMap.MAP_TYPE_SATELLITE);
    }
}
