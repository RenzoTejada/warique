package com.example.putencio.warique;

import android.content.Intent;
import android.os.Bundle;
import android.os.PersistableBundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

/**
 * Created by renzo on 16/12/15.
 */
public class ReservacionActivity extends AppCompatActivity {
    private TextView lblNombre;
    private Button btnAtras, btnSalir;
    private String nombre;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_reservacion);

        lblNombre = (TextView) findViewById(R.id.lblNombre);
        btnAtras = (Button) findViewById(R.id.btnAtras);
        btnSalir = (Button) findViewById(R.id.btnSalir);
    }

    @Override
    protected void onResume() {
        super.onResume();

        btnSalir.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(ReservacionActivity.this, MainActivity.class);
                startActivity(intent);
            }
        });

    }
}
