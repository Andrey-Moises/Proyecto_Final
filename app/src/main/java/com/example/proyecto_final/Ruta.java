package com.example.proyecto_final;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.widget.Button;

public class Ruta extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_ruta);

        Intent GO = getIntent();

        Button  llegar = findViewById(R.id.button1),
                pedido = findViewById(R.id.button2);

        llegar.setOnClickListener(view ->
        {

            Intent GORute = new Intent(this, Llegar.class);
            startActivity(GORute);

        });

        pedido.setOnClickListener(view ->
        {

            Intent GORute = new Intent(this, Pedido.class);
            startActivity(GORute);

        });

    }
}