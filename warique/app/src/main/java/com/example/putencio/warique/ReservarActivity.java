package com.example.putencio.warique;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.example.putencio.aplicacion.Configuracion;
import com.example.putencio.models.Reserva;


/**
 * Created by renzo on 17/12/15.
 */
public class ReservarActivity extends AppCompatActivity {

    private TextView lblTexto;
    private Button btnGuardar, btnAtras;
    private EditText txtNombre, txtMensaje;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_reservar);

        lblTexto = (TextView) findViewById(R.id.lblTexto);
        btnGuardar = (Button) findViewById(R.id.btnGuardar);
        btnAtras = (Button) findViewById(R.id.btnAtras);

        txtNombre = (EditText) findViewById(R.id.txtNombre);
        txtMensaje = (EditText) findViewById(R.id.txtMensaje);

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

               if (txtNombre.getText().toString().length() == 0) {
                    txtNombre.setError("Campo nombre es requerido");
                } else if (txtMensaje.getText().toString().length() == 0) {
                    txtMensaje.setError("Campo mensaje es requerido");
                } else {
                    Reserva reserva = new Reserva();
                    reserva.setNombre(txtNombre.getText().toString());
                    reserva.setMensaje(txtMensaje.getText().toString());
                    Configuracion.sentenciaSQL.insertaReserva(reserva);

                    txtNombre.setText("");
                    txtMensaje.setText("");
                    Toast.makeText(getApplicationContext(),
                            getResources().getString(R.string.mensaje_confirmacion),
                            Toast.LENGTH_SHORT).show();
                    Intent intent = new Intent(ReservarActivity.this, ReservacionActivity.class);
                    intent.putExtra("nombre", txtNombre.getText().toString());
                    startActivity(intent);
                }
            }
        });

    }
}
