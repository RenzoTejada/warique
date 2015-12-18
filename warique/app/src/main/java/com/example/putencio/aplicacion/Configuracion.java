package com.example.putencio.aplicacion;

import android.app.Application;

import com.example.putencio.sqlite.SentenciaSQL;
import com.facebook.drawee.backends.pipeline.Fresco;

/**
 * Created by renzo on 16/12/15.
 */
public class Configuracion extends Application {
    public static SentenciaSQL sentenciaSQL;

    @Override
    public void onCreate() {
        super.onCreate();
        Fresco.initialize(getApplicationContext());
        sentenciaSQL = new SentenciaSQL(getApplicationContext());
    }
}
