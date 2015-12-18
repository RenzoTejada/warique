package com.example.putencio.adapters;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

import com.example.putencio.models.Reserva;
import com.example.putencio.warique.R;

import java.util.ArrayList;

/**
 * Created by putencio on 18/12/15.
 */
public class ListaAdapter extends BaseAdapter {
    private Context context;
    private ArrayList<Reserva> lista;

    public ListaAdapter(Context context, ArrayList<Reserva> lista) {
        this.context = context;
        this.lista = lista;
    }

    public int getCount() {
        return lista.size();
    }

    @Override
    public Object getItem(int position) {
        return lista.get(position);
    }

    @Override
    public long getItemId(int position) {
        return lista.get(position).getId();
    }

    static class ViewHolder {
        TextView lblNombre, lblMensaje;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        ViewHolder viewHolder = null;
        if (convertView == null) {
            convertView = LayoutInflater.from(context).inflate(R.layout.item, parent, false);

            viewHolder = new ViewHolder();
            viewHolder.lblNombre = (TextView) convertView.findViewById(R.id.lblNombre);
            viewHolder.lblMensaje = (TextView) convertView.findViewById(R.id.lblMensaje);

            convertView.setTag(viewHolder);
        }
        viewHolder = (ViewHolder) convertView.getTag();

        Reserva item = (Reserva) getItem(position);

        viewHolder.lblNombre.setText(item.getNombre());
        viewHolder.lblMensaje.setText(item.getMensaje());
        return convertView;
    }
}
