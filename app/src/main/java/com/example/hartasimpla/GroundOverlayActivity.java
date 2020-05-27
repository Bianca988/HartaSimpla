package com.example.hartasimpla;

import android.os.Bundle;
import android.view.View;
import android.widget.CheckBox;
import android.widget.SeekBar;
import android.widget.SeekBar.OnSeekBarChangeListener;
import androidx.appcompat.app.AppCompatActivity;

import com.google.android.gms.maps.CameraUpdateFactory;
import com.google.android.gms.maps.GoogleMap;
import com.google.android.gms.maps.OnMapReadyCallback;
import com.google.android.gms.maps.SupportMapFragment;
import com.google.android.gms.maps.model.BitmapDescriptor;
import com.google.android.gms.maps.model.BitmapDescriptorFactory;
import com.google.android.gms.maps.model.GroundOverlay;
import com.google.android.gms.maps.model.GroundOverlayOptions;
import com.google.android.gms.maps.model.LatLng;

import java.util.ArrayList;
import java.util.List;


public class GroundOverlayActivity extends AppCompatActivity implements SeekBar.OnSeekBarChangeListener, OnMapReadyCallback, GoogleMap.OnGroundOverlayClickListener {

    private final List<BitmapDescriptor> images = new ArrayList<BitmapDescriptor>();
    private static final LatLng Locatie = new LatLng(47.6860868,22.04794064);
    private GroundOverlay groundOverlay;
    private GroundOverlay groundOverlayRotated;
    private SeekBar seekBar;
    private static final LatLng Near_Locatie = new LatLng(Locatie.latitude - 0.001 , Locatie.longitude - 0.025);
    private static final int Transp = 100;
    private int currententry = 0 ;


    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.ground_overlay_demo);

        seekBar = findViewById(R.id.seekBar);
        seekBar.setMax(100);
        seekBar.setProgress(0);

        SupportMapFragment mapFragment = (SupportMapFragment) getSupportFragmentManager().findFragmentById(R.id.map);

        mapFragment.getMapAsync(this);

    }
    @Override
    public void onProgressChanged(SeekBar seekBar, int i, boolean b) {

        if(groundOverlay != null)
        {
            groundOverlay.setTransparency((float) i/ (float) Transp);
        }


    }
    public void switchImage(View view)
    {
        currententry = (currententry + 1 ) % images.size();
        groundOverlay.setImage(images.get(currententry));
    }

    @Override
    public void onStartTrackingTouch(SeekBar seekBar) {

    }

    @Override
    public void onStopTrackingTouch(SeekBar seekBar) {

    }

    @Override
    public void onGroundOverlayClick(com.google.android.gms.maps.model.GroundOverlay groundOverlay) {

        groundOverlayRotated.setTransparency(0.5f - groundOverlayRotated.getTransparency());

    }

    @Override
    public void onMapReady(GoogleMap googleMap) {

        googleMap.setOnGroundOverlayClickListener(this);

        googleMap.moveCamera(CameraUpdateFactory.newLatLngZoom(Locatie,11));

        images.clear();
        images.add(BitmapDescriptorFactory.fromResource(R.drawable.exemplu2));
        images.add(BitmapDescriptorFactory.fromResource(R.drawable.exemplu2));

        groundOverlayRotated = googleMap.addGroundOverlay(new GroundOverlayOptions()
        .image(images.get(1)).anchor(0,1)
        .position(Near_Locatie,4300f , 3025f)
        .bearing(30)
        .clickable(((CheckBox)findViewById(R.id.toggleClickability)).isChecked()));


        groundOverlay = googleMap.addGroundOverlay(new GroundOverlayOptions()
        .image(images.get(0)).anchor(0,1)
        .position(Locatie,8600f,6500f));

        seekBar.setOnSeekBarChangeListener(this);

       // Override the default content description on the view, for accessibility mode.
        // Ideally this string would be localised.

        googleMap.setContentDescription("Hello .Hope It's working");
    }

    public void toggleClickability(View view) {
        if(groundOverlayRotated != null)
        {
            groundOverlayRotated.setClickable(((CheckBox) view).isChecked());
        }
    }
}
