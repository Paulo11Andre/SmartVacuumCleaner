package com.example.smartvacuumcleaner;

import androidx.appcompat.app.AppCompatActivity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import java.util.Objects;

public class MenuActivity extends AppCompatActivity {
    private String idUsuario;
    private String nombreUsu;
    private String nombre;
    private String apellido;
    private String correo;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_menu);
        Objects.requireNonNull(getSupportActionBar()).hide();

        Bundle b = getIntent().getExtras();
        nombreUsu = b.getString("nom_usu");
        nombre = b.getString("nombre");
        apellido = b.getString("apellido");
        correo = b.getString("correo");
        if(b == null) {
            idUsuario= "7";
        } else {
            idUsuario= b.getString("id_usuario");
        }

    }

    public void salir(View view){
        finish();
    }

    public void comenzarRutina(View view){
        Intent intent = new Intent(getApplicationContext(), ComenzarRutinaActivity.class);
        intent.putExtra("id_usuario",idUsuario);
        startActivity(intent);
    }

    public void editarRutinas(View view) throws InterruptedException {
        Intent intent = new Intent(getApplicationContext(), EditarRutinasActivity.class);
        intent.putExtra("id_usuario",idUsuario);
        startActivity(intent);
    }

    public void calendario(View view) throws InterruptedException {
        Intent intent = new Intent(getApplicationContext(), CalendarioActivity.class);
        intent.putExtra("id_usuario",idUsuario);
        startActivity(intent);
    }

    public void perfil(View view) throws InterruptedException {
        Intent intent = new Intent(getApplicationContext(), PerfilActivity.class);
        intent.putExtra("id_usuario",idUsuario);
        intent.putExtra("nom_usu", nombreUsu);
        intent.putExtra("nombre", nombre);
        intent.putExtra("apellido", apellido);
        intent.putExtra("correo", correo);
        startActivity(intent);
    }

    public void configuracion(View view) throws InterruptedException {
        Intent intent = new Intent(getApplicationContext(), ConfiguracionActivity.class);
        intent.putExtra("id_usuario",idUsuario);
        startActivity(intent);
    }


}