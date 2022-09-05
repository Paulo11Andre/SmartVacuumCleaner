package com.example.pomodoro;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import android.app.DownloadManager;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

import com.android.volley.AuthFailureError;
import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.JsonArrayRequest;
import com.android.volley.toolbox.StringRequest;
import com.android.volley.toolbox.Volley;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
import java.util.Objects;

public class CrearCuentaActivity extends AppCompatActivity {
    private EditText etNombre, etApellido, etNombreUsuario,etContrasenia,etEMail;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_crear_cuenta);
        Objects.requireNonNull(getSupportActionBar()).hide();
        etNombre = (EditText) findViewById(R.id.crearNombreID);
        etApellido = (EditText) findViewById(R.id.crearApellidoID);
        etNombreUsuario = (EditText) findViewById(R.id.crearNombreUsuarioID);
        etContrasenia = (EditText) findViewById(R.id.crearContrasenaID);
        etEMail = (EditText) findViewById(R.id.crearEMailID);
    }

    public void crearCuenta(View view){
            ejecutarServicio("https://pst-pomodoroapp.000webhostapp.com/anadir_usuario.php/");
        }

    private void ejecutarServicio(String URL){

        StringRequest stringRequest = new StringRequest(Request.Method.POST, URL, new Response.Listener<String>() {

            @Override
            public void onResponse(String response) {
                Toast.makeText(getApplicationContext(), "Usuario agregado", Toast.LENGTH_SHORT).show();
                Intent intent = new Intent(getApplicationContext(), LoginActivity.class);
                startActivity(intent);
                finish();
            }
        }, new Response.ErrorListener() {
                    @Override
                    public void onErrorResponse(VolleyError error) {
                        Toast.makeText(getApplicationContext(), "Error al crear el usuario", Toast.LENGTH_SHORT).show();
                    }
                }
        ) {
            
            @Override
            protected Map<String, String> getParams() throws AuthFailureError {
                Map<String, String> params = new HashMap<>();

                params.put("nom_usuario", etNombreUsuario.getText().toString());
                params.put("nombre", etNombre.getText().toString());
                params.put("apellido", etApellido.getText().toString());
                params.put("correo", etEMail.getText().toString());
                params.put("contraseña", etContrasenia.getText().toString());

                return params;
            }
        };
        RequestQueue requestQueue = Volley.newRequestQueue(this);
        requestQueue.add(stringRequest);
    }
    public void volver(View view){
        Intent intent = new Intent(getApplicationContext(), LoginActivity.class);
        startActivity(intent);
        finish();
    }
}