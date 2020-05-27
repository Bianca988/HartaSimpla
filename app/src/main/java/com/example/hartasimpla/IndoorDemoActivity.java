/* package com.example.hartasimpla;

import android.os.Bundle;
import android.view.View;

import androidx.appcompat.app.AppCompatActivity;

import com.google.android.gms.maps.CameraUpdateFactory;
import com.google.android.gms.maps.GoogleMap;
import com.google.android.gms.maps.OnMapReadyCallback;
import com.google.android.gms.maps.SupportMapFragment;
import com.google.android.gms.maps.model.LatLng;

public class IndoorDemoActivity extends AppCompatActivity implements OnMapReadyCallback {


    private GoogleMap Mmap;
    private boolean showLevelPicker = true;

    public void onCreate(Bundle savedInstance)
    {
        super.onCreate(savedInstance);
        setContentView(R.layout.indoor_demo);

        SupportMapFragment mapFragment = (SupportMapFragment) getSupportFragmentManager().findFragmentById(R.id.map);
        mapFragment.getMapAsync(this);
    }
    @Override
    public void onMapReady(GoogleMap googleMap) {

        Mmap = googleMap;

        Mmap.moveCamera(CameraUpdateFactory.newLatLngZoom(new LatLng(47.4,34.2),18));


    }

    public void onToggleLevelPicker(View view)
    {
        showLevelPicker = !showLevelPicker;
        Mmap.getUiSettings().setIndoorLevelPickerEnabled(showLevelPicker);

    }



}
*/