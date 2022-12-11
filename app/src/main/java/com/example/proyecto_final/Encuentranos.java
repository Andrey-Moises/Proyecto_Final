package com.example.proyecto_final;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;

import androidx.annotation.NonNull;
import com.google.android.gms.maps.CameraUpdateFactory;
import com.google.android.gms.maps.GoogleMap;
import com.google.android.gms.maps.OnMapReadyCallback;
import com.google.android.gms.maps.SupportMapFragment;
import com.google.android.gms.maps.model.LatLng;
import com.google.android.gms.maps.model.MarkerOptions;

public class Encuentranos extends AppCompatActivity implements OnMapReadyCallback
{

    GoogleMap mapa;

    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_encuentranos);

        Intent GO = getIntent();

        SupportMapFragment mapFragment = (SupportMapFragment) getSupportFragmentManager().findFragmentById(R.id.mapa);
        mapFragment.getMapAsync(this);

    }

    @Override
    public void onMapReady(@NonNull GoogleMap googleMap)
    {

        mapa = googleMap;
        LatLng unitec = new LatLng(19.545956791791628,-99.2408773456682);
        mapa.addMarker(new MarkerOptions().position(unitec).title("Restaurante Carmelias"));
        mapa.moveCamera(CameraUpdateFactory.newLatLng(unitec));
        mapa.animateCamera(CameraUpdateFactory.zoomTo(15));

    }
}
