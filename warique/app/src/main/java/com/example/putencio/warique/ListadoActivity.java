package com.example.putencio.warique;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.Button;
import android.widget.GridView;

import com.example.putencio.adapters.GrillaAdapter;
import com.example.putencio.models.DetalleImagen;

import java.util.ArrayList;

public class ListadoActivity extends AppCompatActivity {

    private Button btnAtras;

    private GridView gvGrilla;
    public static ArrayList<DetalleImagen> lista = new ArrayList<>();
    private GrillaAdapter adapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_listado);

        btnAtras = (Button)findViewById(R.id.btnAtras);
        gvGrilla = (GridView) findViewById(R.id.gvGrilla);

        for (int i = 101; i < 111; i++) {
            lista.add(new DetalleImagen(lista.size(),
                    "http://renzotejada.com/android/image/restaurant" + i + ".png",
                    "Titulo " + i));
        }
        adapter = new GrillaAdapter(getApplicationContext(), lista);
        gvGrilla.setAdapter(adapter);
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

        gvGrilla.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                Intent intent = new Intent(ListadoActivity.this, DetalleActivity.class);

                Bundle bundle = new Bundle();
                bundle.putInt("posicion", position);
                intent.putExtras(bundle);

                startActivity(intent);
            }
        });
    }
}
