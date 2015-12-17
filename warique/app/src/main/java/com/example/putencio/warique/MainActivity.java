package com.example.putencio.warique;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;


public class MainActivity extends AppCompatActivity {

    private Button btnReserva, btnEntrar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        btnReserva = (Button)findViewById(R.id.btnReserva);
        btnEntrar = (Button) findViewById(R.id.btnEntrar);
    }

    @Override
    protected void onResume() {
        super.onResume();

        btnEntrar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MainActivity.this, ListadoActivity.class);
                startActivity(intent);
            }
        });

        btnReserva.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MainActivity.this, ReservacionActivity.class);
                startActivity(intent);
            }
        });

    }
}
