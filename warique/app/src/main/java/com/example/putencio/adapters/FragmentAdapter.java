package com.example.putencio.adapters;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;

import com.example.putencio.fragmentos.DetalleFragmento;
import com.example.putencio.warique.ListadoActivity;

/**
 * Created by renzo on 17/12/15.
 */
public class FragmentAdapter extends FragmentPagerAdapter {

    public FragmentAdapter(FragmentManager fm) {
        super(fm);
    }

    //Donde creamos la vista
    @Override
    public Fragment getItem(int position) {
        //Crear un fragmento
        DetalleFragmento fragmento = new DetalleFragmento();
        //Creano un bundle
        Bundle bundle = new Bundle();
        //Cargando los datos que llegaran al fragmento
        bundle.putInt("posicion", position);
        //Añadimos los datos al fragmento
        fragmento.setArguments(bundle);
        //Retornamos el fragmento
        return fragmento;
    }

    //
    @Override
    public int getCount() {
        return ListadoActivity.lista.size();
    }
}
