package com.example.putencio.warique;

import android.content.Intent;
import android.os.Bundle;
import android.os.PersistableBundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.AdapterView;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.TextView;

import com.example.putencio.adapters.ListaAdapter;
import com.example.putencio.aplicacion.Configuracion;
import com.example.putencio.models.Reserva;

import java.util.ArrayList;

/**
 * Created by renzo on 16/12/15.
 */
public class ReservacionActivity extends AppCompatActivity {

    private EditText txtNombre, txtMensaje;
    private Button btnSalir,btnActualizar,btnEliminar,btnGuardar;
    private ListView lvLista;
    private ListaAdapter adapter;
    ArrayList<Reserva> lista = new ArrayList<>();

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_reservacion);

        txtNombre = (EditText) findViewById(R.id.txtNombre);
        txtMensaje = (EditText) findViewById(R.id.txtMensaje);

        btnSalir = (Button) findViewById(R.id.btnSalir);
        btnActualizar = (Button) findViewById(R.id.btnActualizar);
        btnGuardar = (Button) findViewById(R.id.btnGuardar);
        btnEliminar = (Button) findViewById(R.id.btnEliminar);
        lvLista = (ListView) findViewById(R.id.lvLista);
        listar();
    }

    private void listar() {

        lista = Configuracion.sentenciaSQL.listarTodo();

        adapter = new ListaAdapter(getApplicationContext(), lista);
        lvLista.setAdapter(adapter);
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

        lvLista.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                btnActualizar.setVisibility(View.VISIBLE);
                btnEliminar.setVisibility(View.VISIBLE);

                Reserva reserva = lista.get(position);
                btnActualizar.setTag(reserva.getId());

                txtNombre.setText(reserva.getNombre());
                txtMensaje.setText(reserva.getMensaje());


            }
        });

        btnActualizar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                btnActualizar.setVisibility(View.INVISIBLE);
                btnEliminar.setVisibility(View.INVISIBLE);
                btnGuardar.setVisibility(View.VISIBLE);
                txtNombre.setVisibility(View.VISIBLE);
                txtMensaje.setVisibility(View.VISIBLE);
                int id = (Integer) btnActualizar.getTag();
                btnGuardar.setTag(id);
            }
        });

        btnGuardar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                int id = (Integer) btnGuardar.getTag();
                Reserva reserva = new Reserva();
                reserva.setNombre(txtNombre.getText().toString());
                reserva.setMensaje(txtMensaje.getText().toString());
                reserva.setId(id);

                Configuracion.sentenciaSQL.actualizaReserva(reserva);

                txtNombre.setText("");
                txtMensaje.setText("");
                btnActualizar.setVisibility(View.INVISIBLE);
                btnEliminar.setVisibility(View.INVISIBLE);
                btnGuardar.setVisibility(View.INVISIBLE);
                txtNombre.setVisibility(View.INVISIBLE);
                txtMensaje.setVisibility(View.INVISIBLE);
                listar();
            }
        });

        btnEliminar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                int id = (Integer) btnActualizar.getTag();

                Configuracion.sentenciaSQL.eliminaReserva(id);
                btnActualizar.setVisibility(View.INVISIBLE);
                btnEliminar.setVisibility(View.INVISIBLE);
                listar();
            }
        });

    }
}
