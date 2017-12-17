package com.example.pritimays.khurma;

import android.location.Location;
import android.support.v7.app.ActionBar;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;

import com.google.android.gms.common.ConnectionResult;
import com.google.android.gms.common.api.GoogleApiClient;
import com.google.android.gms.location.LocationListener;
import com.google.android.gms.location.LocationRequest;
import com.google.android.gms.location.LocationServices;

public class MainActivity extends AppCompatActivity implements GoogleApiClient.ConnectionCallbacks, GoogleApiClient.OnConnectionFailedListener, LocationListener {

    private final String LOG_TAG = "TestApp";
    private TextView txtOutput, txtOutput2;
    private GoogleApiClient mGoogleApiClient;
    private LocationRequest mLocationRequest;
    private LocationListener mLocationListener;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        mGoogleApiClient = new GoogleApiClient.Builder(this)
                .addApi(LocationServices.API)
                .addConnectionCallbacks(this)
                .addOnConnectionFailedListener(this)
                .build();

        txtOutput = (TextView) findViewById(R.id.textOutput);
        txtOutput2 = (TextView) findViewById(R.id.textOutput2);
    }

    @Override
    public void onConnectionSuspended(int i) {

        Log.i(LOG_TAG, "GoogleAppClient connection suspended");
    }

    @Override
    public void onConnectionFailed(ConnectionResult connectionResult) {

        Log.i(LOG_TAG, "GoogleAppClient connection failed");
    }

    @Override
    protected void onStart(){
        super.onStart();

        //Connect the client
        mGoogleApiClient.connect();
    }

    @Override
    protected void onStop(){

        //Disconnect the client
        mGoogleApiClient.disconnect();

        super.onStop();
    }


    @Override
    public void onConnected(Bundle bundle){
        //1. create a Location Request called mLocationRequest
        mLocationRequest = LocationRequest.create();
        //2. set it's priority to high accuracy
        mLocationRequest.setPriority(LocationRequest.PRIORITY_HIGH_ACCURACY);
        //3. set it's update every second (1000 ms)
        mLocationRequest.setInterval(1000);
        //4. Call requestLocationUpdates in the API with this request
        LocationServices.FusedLocationApi.requestLocationUpdates(mGoogleApiClient, mLocationRequest, this);
    }

    public void onLocationChanged(Location location) {
        Log.i(LOG_TAG, location.toString());
        txtOutput.setText(Double.toString(location.getLatitude()));
        txtOutput2.setText(Double.toString(location.getLongitude()));
    }
}
