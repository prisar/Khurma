package com.example.prisar.khurma;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.Button;

import com.google.android.gms.maps.CameraUpdateFactory;
import com.google.android.gms.maps.GoogleMap;
import com.google.android.gms.maps.MapFragment;
import com.google.android.gms.maps.OnMapReadyCallback;
import com.google.android.gms.maps.model.BitmapDescriptorFactory;
import com.google.android.gms.maps.model.CameraPosition;
import com.google.android.gms.maps.model.LatLng;
import com.google.android.gms.maps.model.Marker;
import com.google.android.gms.maps.model.MarkerOptions;
import com.google.android.gms.maps.model.PolylineOptions;

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


    LatLng renton;
    LatLng kirland;
    LatLng everett;
    LatLng lynnwood;
    LatLng montlake;
    LatLng kent;
    LatLng showare;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_map);

        renton = new LatLng(47.489805, -122.120502);

        kirland = new LatLng(47.7301986, -122.1768858);

        everett = new LatLng(47.978748, -122.202001);

        lynnwood = new LatLng(47.819533, -122.32288);

        montlake = new LatLng(47.7973733, -122.3281771);

        kent = new LatLng(47.385938, -122.258212);

        showare = new LatLng(47.38702, -122.23986);

        MapFragment mapFragment = (MapFragment) getFragmentManager()
                .findFragmentById(R.id.mapOutput);
        mapFragment.getMapAsync(this);
    }

    @Override
    public void onMapReady(GoogleMap googleMap) {
        mapReady = true;
        mMap = googleMap;
        mMap.setMapType(GoogleMap.MAP_TYPE_NORMAL);
        flyTo(SEATTLE);

        mMap.addPolyline(new PolylineOptions().geodesic(true).add(renton)
                .add(kirland)
                .add(everett)
                .add(lynnwood)
                .add(montlake)
                .add(kent)
                .add(showare)
                .add(renton));
    }

    public void flyTo(CameraPosition target) {
        mMap.animateCamera(CameraUpdateFactory.newCameraPosition(target), 10000, null);
    }
}
