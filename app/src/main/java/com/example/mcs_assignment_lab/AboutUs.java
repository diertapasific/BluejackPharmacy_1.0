package com.example.mcs_assignment_lab;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.MenuItem;

import com.google.android.gms.maps.CameraUpdateFactory;
import com.google.android.gms.maps.GoogleMap;
import com.google.android.gms.maps.SupportMapFragment;
import com.google.android.gms.maps.OnMapReadyCallback;
import com.google.android.gms.maps.model.LatLng;
import com.google.android.gms.maps.model.MarkerOptions;

public class AboutUs extends AppCompatActivity implements  OnMapReadyCallback{

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_about_us);

        SupportMapFragment mapFragment = (SupportMapFragment) getSupportFragmentManager().findFragmentById(R.id.maps);
        mapFragment.getMapAsync(this);

        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
    }

    public boolean onOptionsItemSelected(MenuItem item){
        Intent myIntent = new Intent(getApplicationContext(), HomeActivity.class);
        startActivity(myIntent);
        return true;
    }

    @Override
    public void onMapReady(@NonNull GoogleMap googleMap) {
                LatLng binusAnggrek = new LatLng(-6.201935, 106.781525);
        googleMap.addMarker(new MarkerOptions()
                .position(binusAnggrek)
                .title("Marker in BINUS Anggrek"));
        googleMap.moveCamera(CameraUpdateFactory.newLatLng(binusAnggrek));
    }
}