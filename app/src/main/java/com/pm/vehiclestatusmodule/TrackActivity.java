package com.pm.vehiclestatusmodule;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;

import com.google.android.gms.maps.CameraUpdateFactory;
import com.google.android.gms.maps.GoogleMap;
import com.google.android.gms.maps.OnMapReadyCallback;
import com.google.android.gms.maps.SupportMapFragment;
import com.google.android.gms.maps.model.CameraPosition;
import com.google.android.gms.maps.model.LatLng;
import com.google.android.gms.maps.model.MarkerOptions;

/**
 * Created by mahap on 03-Feb-18.
 */

public class TrackActivity extends AppCompatActivity implements OnMapReadyCallback {
    private GoogleMap googleMap;

    double latitude,longitude;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.fragment_track);
        try{
            latitude = Double.parseDouble(getIntent().getExtras().getString("lat"));
            longitude = Double.parseDouble(getIntent().getExtras().getString("long"));

        }catch (NullPointerException e){
            e.printStackTrace();
        }
        SupportMapFragment mapFragment =
                (SupportMapFragment) getSupportFragmentManager().findFragmentById(R.id.map);
        mapFragment.getMapAsync(this);
    }

    @Override
    public void onMapReady(GoogleMap gMap) {
        googleMap = gMap;

        LatLng loc = new LatLng(latitude,longitude);
        googleMap.addMarker(new MarkerOptions().position(loc).title("Vehicle Location"));

        CameraPosition cameraPosition = new CameraPosition.Builder().target(loc).zoom(12).build();
        googleMap.animateCamera(CameraUpdateFactory.newCameraPosition(cameraPosition));

    }
}
