package com.example.pomodoro;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import java.util.Objects;

public class ComenzarRutinaActivity extends AppCompatActivity {
    private String idUsuario;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_comenzar_rutina);
        Objects.requireNonNull(getSupportActionBar()).hide();

        Bundle b = getIntent().getExtras();
        if(b == null) {
            idUsuario= "7";
        } else {
            idUsuario= b.getString("id_usuario");
        }
    }

    public void nuevaRutina(View view){
        Intent intent = new Intent(getApplicationContext(), NuevaRutinaActivity.class);
        intent.putExtra("id_usuario",idUsuario);
        startActivity(intent);
        finish();
    }

    public void volver(View view){
        finish();
    }
}