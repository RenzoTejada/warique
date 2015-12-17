package com.example.putencio.fragmentos;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;

import com.example.putencio.models.DetalleImagen;
import com.example.putencio.warique.ListadoActivity;
import com.example.putencio.warique.R;
import com.example.putencio.warique.ReservarActivity;
import com.facebook.drawee.view.SimpleDraweeView;

/**
 * Created by renzo on 17/12/15.
 */
public class DetalleFragmento extends Fragment {

    private SimpleDraweeView ivImagen;
    private TextView lblTitulo;
    private Button btnAbrir;

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View root = inflater.inflate(R.layout.fragmento_detalle, container, false);

        ivImagen = (SimpleDraweeView) root.findViewById(R.id.ivImagen);
        lblTitulo = (TextView) root.findViewById(R.id.lblTitulo);
        btnAbrir = (Button) root.findViewById(R.id.btnAbrir);

        return root;
    }

    @Override
    public void onResume() {
        super.onResume();

        Bundle bundle = getArguments();
        final int posicion = bundle.getInt("posicion");

        DetalleImagen item = ListadoActivity.lista.get(posicion);

        ivImagen.setImageURI(Uri.parse(item.getRutaImagen()));
        lblTitulo.setText(item.getTitulo());

        btnAbrir.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getActivity(), ReservarActivity.class);
                intent.putExtra("posicion", posicion);
                startActivity(intent);
            }
        });
    }
}
