package com.example.proyecto_final;

import androidx.annotation.RequiresApi;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.graphics.Color;
import android.os.Build;
import android.os.Bundle;
import android.widget.Button;

public class MainActivity extends AppCompatActivity {

    @RequiresApi(api = Build.VERSION_CODES.O)
    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        // MENU

        Button  goMenu      = findViewById(R.id.goMenu),
                goAboutUs   = findViewById(R.id.goaboutUs),
                goContact   = findViewById(R.id.goapointments),
                goFindUs    = findViewById(R.id.gofindus),
                goAgend     = findViewById(R.id.goContact),
                goVideo     = findViewById(R.id.goVideo);

        // Funcion botones

        goMenu.setOnClickListener(view ->
        {

            Intent GO = new Intent(this, Menu.class);
            startActivity(GO);

        });

        goAboutUs.setOnClickListener(view ->
        {

            Intent GO = new Intent(this, Nosotros.class);
            startActivity(GO);

        });

        goContact.setOnClickListener(view ->
        {

            Intent GO = new Intent(this, Contacto.class);
            startActivity(GO);

        });

        goFindUs.setOnClickListener(view ->
        {

            Intent GO = new Intent(this, Encuentranos.class);
            startActivity(GO);

        });

        goAgend.setOnClickListener(view ->
        {

            Intent GO = new Intent(this, Agendar.class);
            startActivity(GO);

        });

        goVideo.setOnClickListener(view ->
        {

            Intent GO = new Intent(this, Video.class);
            startActivity(GO);

        });


    }
}