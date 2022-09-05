package com.example.pomodoro;

import androidx.appcompat.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import java.util.Objects;

public class CalendarioActivity extends AppCompatActivity {
    private String idUsuario;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_calendario);
        Objects.requireNonNull(getSupportActionBar()).hide();

        Bundle b = getIntent().getExtras();
        if(b == null) {
            idUsuario= "7";
        } else {
            idUsuario= b.getString("id_usuario");
        }
    }


    public void volver(View view){
        finish();
    }
}