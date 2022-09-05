package com.example.smartvacuumcleaner;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.StringRequest;
import com.android.volley.toolbox.Volley;

import org.json.JSONArray;
import org.json.JSONException;

import java.util.ArrayList;
import java.util.Objects;

public class LoginActivity extends AppCompatActivity {

    EditText nom_usuario, contrasena;
    Button btnlogin;
    RequestQueue requestQueue;
    static ArrayList<String> usuario= new ArrayList<>();
    JSONArray jsonArray;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);
        Objects.requireNonNull(getSupportActionBar()).hide();

        nom_usuario = (EditText)findViewById(R.id.nombreUsuarioID);
        contrasena = (EditText)findViewById(R.id.contrasenaID);
        btnlogin = findViewById(R.id.buttonIniciarSesion);

        btnlogin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                //validarUsuario("https://pst-pomodoroapp.000webhostapp.com/validar_usuario.php");
                iniciarSesion();
            }
        });
    }

    private void iniciarSesion() {
        requestQueue = Volley.newRequestQueue(this);
        String url = "https://pst-pomodoroapp.000webhostapp.com/inicio_sesion.php?nom_usuario="+nom_usuario.getText().toString();
        StringRequest stringRequest = new StringRequest(Request.Method.POST, url, new Response.Listener<String>(){

            @Override
            public void onResponse(String response) {
                try {
                    jsonArray = new JSONArray(response);
                    String idUsuario = jsonArray.getString(0);
                    String nombreUsu = jsonArray.getString(1);
                    String nombre = jsonArray.getString(2);
                    String apellido = jsonArray.getString(3);
                    String correo = jsonArray.getString(4);
                    String contra = jsonArray.getString(5);
                    if(contra.equals(contrasena.getText().toString())){
                        Toast.makeText(getApplicationContext(), "Bienvenid@ "+ nom_usuario.getText().toString(), Toast.LENGTH_SHORT).show();
                        Intent intent = new Intent(getApplicationContext(), MenuActivity.class);
                        intent.putExtra("id_usuario", idUsuario);
                        intent.putExtra("nom_usu", nombreUsu);
                        intent.putExtra("nombre", nombre);
                        intent.putExtra("apellido", apellido);
                        intent.putExtra("correo", correo);
                        startActivity(intent);
                        finish();
                    }
                    else{
                        Toast.makeText(getApplicationContext(), "Verifique su usuario o contraseña", Toast.LENGTH_SHORT).show();
                    }
                } catch (JSONException e) {
                    e.printStackTrace();
                    Toast.makeText(getApplicationContext(), "El usuario no existe", Toast.LENGTH_SHORT).show();
                }
            }
        }, new Response.ErrorListener(){

            @Override
            public void onErrorResponse(VolleyError error) {

            }
        }); requestQueue.add(stringRequest);

    }

    /**
    private void validarUsuario (String URL){
        StringRequest stringRequest = new StringRequest(Request.Method.POST, URL, new Response.Listener<String>() {
            @Override
            public void onResponse(String response) {
                if(!response.isEmpty()){
                    idUsuario("https://pst-pomodoroapp.000webhostapp.com/id_usuario.php?nom_usuario="+nom_usuario.getText()+"");
                }else{
                    Toast.makeText(getApplicationContext(), "Usuario o contraseña incorrecta.", Toast.LENGTH_SHORT).show();
                }
            }
        }, new Response.ErrorListener() {
            @Override
            public void onErrorResponse(VolleyError error) {
                Toast.makeText(getApplicationContext(), error.toString(), Toast.LENGTH_SHORT).show();
            }
        }){
            @Override
            protected Map<String, String> getParams() throws AuthFailureError {
                Map<String,String> parametros = new HashMap<String,String>();
                parametros.put("nom_usuario",nom_usuario.getText().toString());
                parametros.put("contrasenia",contrasena.getText().toString());
                return parametros;
            }
        };
        requestQueue = Volley.newRequestQueue(this);
        requestQueue.add(stringRequest);
    }
     */

    /**
    private void idUsuario(String URL){
        JsonArrayRequest jsonArrayRequest = new JsonArrayRequest(URL, new Response.Listener<JSONArray>() {

            @Override
            public void onResponse(JSONArray response) {
                JSONObject jsonObject;
                for (int i = 0; i < response.length(); i++) {
                        try {
                        jsonObject = response.getJSONObject(i);
                        String j = jsonObject.get("id_usuario").toString();
                        usuario.add(j);
                    } catch (JSONException e) {
                        Toast.makeText(getApplicationContext(), e.getMessage(), Toast.LENGTH_SHORT).show();
                    }
                }
                Intent intent = new Intent(getApplicationContext(), MenuActivity.class);
                intent.putExtra("id_usuario",usuario.get(0));
                startActivity(intent);
                finish();
            }
        }, new Response.ErrorListener() {
            @Override
            public void onErrorResponse(VolleyError error) {
                Toast.makeText(getApplicationContext(), "ERROR DE CONEXIÓN", Toast.LENGTH_SHORT).show();
            }
        }
        );

        jsonArrayRequest.setRetryPolicy(new RetryPolicy() {
            @Override
            public int getCurrentTimeout() {
                return 50000;
            }

            @Override
            public int getCurrentRetryCount() {
                return 50000;
            }

            @Override
            public void retry(VolleyError error) throws VolleyError {

            }
        });

        requestQueue = Volley.newRequestQueue(this);
        requestQueue.add(jsonArrayRequest);
    }
     */



    /**
     *
     * @param view
     * @throws InterruptedException
     * */

    /**public void iniciarSesion(View view) throws InterruptedException {
        Intent intent = new Intent(getApplicationContext(), MenuActivity.class);
        startActivity(intent);
        finish();
    }*/

    /**
     *
     * @param view
     * @throws InterruptedException
     */
    //public static ArrayList<Usuario> usuarios = new ArrayList<>();

    /**
    public void CargaDatos() throws IOException {
        String linea;
        InputStream is = this.getResources().openRawResource(R.raw.usuarios);
        BufferedReader reader = new BufferedReader(new InputStreamReader(is));
        if (is!= null){
            while((linea = reader.readLine())!=null){
                String[] datos = linea.split(";");
                Usuario user = new Usuario(datos[0],datos[1],datos[2],datos[3],datos[4]);
                usuarios.add(user);
            }
        }
        is.close();



    }
     */

    /**
    public void iniciarSesion(View view) throws InterruptedException, IOException {
        EditText et1 = (EditText) findViewById(R.id.nombreUsuarioID);
        EditText et2 = (EditText) findViewById(R.id.contrasenaID);


        String nombUsu = et1.getText().toString();
        String contra = et2.getText().toString();
        boolean b = false;
        CargaDatos();
        for (Usuario us : usuarios) {
            System.out.println(us.toString());
            if (et1.getText().toString().equals(us.getUsuario()) && et2.getText().toString().equals(us.getContrasenia())) {
                Toast.makeText(this, "Iniciando", Toast.LENGTH_LONG).show();
                b = true;
                Intent intent = new Intent(getApplicationContext(), MenuActivity.class).putExtra("nombUsu", nombUsu);
                startActivity(intent);
                finish();

            }

        }
        if (b == false){ Toast.makeText(this, "No existe este usuario o contraseña incorrecta", Toast.LENGTH_LONG).show();}
    }
     */


    public void crearCuenta(View view ) throws InterruptedException {
        Intent intent = new Intent(getApplicationContext(), CrearCuentaActivity.class);
        startActivity(intent);
        finish();
    }

    public void salir(View view){
        finish();
    }
}