package com.example.putencio.warique;

import android.os.Bundle;
import android.support.v4.app.FragmentActivity;
import android.support.v4.view.ViewPager;

import com.example.putencio.adapters.FragmentAdapter;
import com.example.putencio.animaciones.ZoomOutPageTransformer;

/**
 * Created by renzo on 17/12/15.
 */
public class DetalleActivity extends FragmentActivity {

    ViewPager viewPager;
    FragmentAdapter fragmentAdapter;

    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_detalle);

        viewPager = (ViewPager) findViewById(R.id.vpImagenes);
        viewPager.setPageTransformer(true, new ZoomOutPageTransformer());
    }

    @Override
    protected void onResume() {
        super.onResume();
        Bundle bundle = getIntent().getExtras();
        int posicion = bundle.getInt("posicion");
        //Creamos nuestro adapter
        fragmentAdapter = new FragmentAdapter(getSupportFragmentManager());
        viewPager.setAdapter(fragmentAdapter);
        //Cambiando la posición o el foco a el item que tenemos o hemos seleccionado
        viewPager.setCurrentItem(posicion);
    }

}
