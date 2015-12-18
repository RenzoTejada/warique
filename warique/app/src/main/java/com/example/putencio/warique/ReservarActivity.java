package com.example.putencio.warique;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.parse.ParseObject;

/**
 * Created by renzo on 17/12/15.
 */
public class ReservarActivity extends AppCompatActivity {

    private TextView lblTexto;
    private Button btnGuardar, btnAtras;
    private EditText txtNombre, txtFecha;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_reservar);

        lblTexto = (TextView) findViewById(R.id.lblTexto);
        btnGuardar = (Button) findViewById(R.id.btnGuardar);
        btnAtras = (Button) findViewById(R.id.btnAtras);

        txtNombre = (EditText) findViewById(R.id.txtNombre);
        txtFecha = (EditText) findViewById(R.id.txtFecha);

        int posicion = getIntent().getIntExtra("posicion", -1);
        lblTexto.setText("" + posicion);
    }

    @Override
    protected void onResume() {
        super.onResume();

        btnAtras.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();
            }
        });

        btnGuardar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                if (txtNombre.getText().toString().trim().length() > 0 &&
                        txtFecha.getText().toString().trim().length() > 0) {

                    ParseObject testObject = new ParseObject("TestObject");
                    testObject.put("nombre", txtNombre.getText().toString());
                    testObject.put("fecha", txtFecha.getText().toString());
                    testObject.put("posicion", lblTexto.getText().toString());
                    testObject.saveInBackground();
                    Toast.makeText(getApplicationContext(),
                            getResources().getString(R.string.mensaje_confirmacion),
                            Toast.LENGTH_SHORT).show();
                    Intent intent = new Intent(ReservarActivity.this, ReservacionActivity.class);
                    intent.putExtra("nombre", txtNombre.getText().toString());
                    startActivity(intent);
                }else {
                    //Si no se han ingresado todos los campos se mostrará un mensaje de validación
                    Toast.makeText(getApplicationContext(),
                            getResources().getString(R.string.mensaje_validacion),
                            Toast.LENGTH_SHORT).show();
                }

            }
        });

    }
}
