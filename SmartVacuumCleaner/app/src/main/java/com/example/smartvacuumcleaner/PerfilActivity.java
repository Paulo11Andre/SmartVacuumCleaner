package com.example.smartvacuumcleaner;

import android.os.Bundle;
import androidx.appcompat.app.AppCompatActivity;
import android.view.View;
import android.widget.TextView;

import java.util.Objects;

public class PerfilActivity extends AppCompatActivity {
    private String idUsuario;
    private String nombreUsu;
    private String nombre;
    private String apellido;
    private String correo;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_perfil);
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

        TextView tvNombreUsu= (TextView)findViewById(R.id.idNombreUsuarioPerfil);
        tvNombreUsu.setText(nombreUsu);

        TextView tvNombreU= (TextView)findViewById(R.id.idNombrePerfil);
        tvNombreU.setText(nombre);

        TextView tvApellido= (TextView)findViewById(R.id.idApellidoPerfil);
        tvApellido.setText(apellido);

        TextView tvCorreo= (TextView)findViewById(R.id.idCorreoPerfil);
        tvCorreo.setText(correo);

    }

    public void volver(View view){
        finish();
    }
}