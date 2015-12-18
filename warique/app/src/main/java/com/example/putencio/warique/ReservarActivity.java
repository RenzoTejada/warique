package com.example.putencio.warique;

import android.os.Bundle;
import android.os.PersistableBundle;
import android.support.v7.app.AppCompatActivity;
import android.widget.Button;
import android.widget.TextView;

/**
 * Created by renzo on 17/12/15.
 */
public class ReservarActivity extends AppCompatActivity {

    private TextView lblTexto;
    private Button button;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_reservar);

        lblTexto = (TextView) findViewById(R.id.lblTexto);

        int posicion = getIntent().getIntExtra("posicion", -1);
        lblTexto.setText("Posición->" + posicion);
    }


}
