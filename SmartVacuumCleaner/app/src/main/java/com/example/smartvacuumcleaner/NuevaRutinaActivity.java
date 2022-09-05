package com.example.smartvacuumcleaner;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

import com.android.volley.AuthFailureError;
import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.StringRequest;
import com.android.volley.toolbox.Volley;

import java.util.HashMap;
import java.util.Map;
import java.util.Objects;

public class NuevaRutinaActivity extends AppCompatActivity {

    private EditText etNombrePomodoro, etNumeroIntervalos, etMinutosTrabajo, etMinutosDescanso;
    private String detalles;
    private String idUsuario;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_nueva_rutina);
        Objects.requireNonNull(getSupportActionBar()).hide();

        etNombrePomodoro = (EditText) findViewById(R.id.idNombreNuevoPomodoro);
        etNumeroIntervalos = (EditText) findViewById(R.id.idIntervalosNuevoPomodoro);
        etMinutosTrabajo = (EditText) findViewById(R.id.idTrabajoNuevoPomodoro);
        etMinutosDescanso = (EditText) findViewById(R.id.idDescansoNuevoPomodoro);

        Bundle b = getIntent().getExtras();
        if(b == null) {
            idUsuario= "7";
        } else {
            idUsuario= b.getString("id_usuario");
        }

        //TextView tvTiempoTotal= (TextView)findViewById(R.id.idTiempoTotal);
        //int minutosTrabajoTotal = (Integer.parseInt(etNumeroIntervalos.getText().toString())) * (Integer.parseInt(etMinutosTrabajo.getText().toString()));
        //int minutosDescansoTotal = ((Integer.parseInt(etNumeroIntervalos.getText().toString())) - 1) * (Integer.parseInt(etMinutosDescanso.getText().toString()));
        //int minutosTotales = minutosTrabajoTotal + minutosDescansoTotal;
        //String mensajeTiempoTotal = "El Pomodoro " + etNombrePomodoro.getText().toString() + " tendrá una duración total de " + String.valueOf(minutosTotales) + " minutos.";
        //tvTiempoTotal.setText(mensajeTiempoTotal);

    }

    public void crearRutina(View view){
        int numeroIntervalos = ((Integer.parseInt(etNumeroIntervalos.getText().toString()))*2)-1;
        String minutosTrabajo = etMinutosTrabajo.getText().toString();
        String minutosDescanso = etMinutosDescanso.getText().toString();
        detalles = "";

        for (int i=0; i<numeroIntervalos; i++){
            if(i==numeroIntervalos-1){
                detalles = detalles.concat(minutosTrabajo);
            }else{
                if(i%2 == 0){
                    detalles = detalles.concat(minutosTrabajo+"-");
                }else{
                    detalles = detalles.concat(minutosDescanso+"-");
                }
            }
        }

        ejecutarServicio("https://pst-pomodoroapp.000webhostapp.com/anadir_pomodoro.php/");
    }


    private void ejecutarServicio(String URL){

        StringRequest stringRequest = new StringRequest(Request.Method.POST, URL, new Response.Listener<String>() {

            @Override
            public void onResponse(String response) {
                Toast.makeText(getApplicationContext(), "Pomodoro agregado", Toast.LENGTH_SHORT).show();
                finish();
            }
        }, new Response.ErrorListener() {
            @Override
            public void onErrorResponse(VolleyError error) {
                Toast.makeText(getApplicationContext(), "Error al crear el Pomodoro", Toast.LENGTH_SHORT).show();
            }
        }
        ) {

            @Override
            protected Map<String, String> getParams() throws AuthFailureError {
                Map<String, String> params = new HashMap<>();

                params.put("nom_pomodoro", etNombrePomodoro.getText().toString());
                params.put("detalles", detalles);
                params.put("id_usuario", idUsuario);

                return params;
            }
        };
        RequestQueue requestQueue = Volley.newRequestQueue(this);
        requestQueue.add(stringRequest);
    }

    public void volver(View view){
        finish();
    }
}