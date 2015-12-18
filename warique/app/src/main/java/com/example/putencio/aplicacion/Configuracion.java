package com.example.putencio.aplicacion;

import android.app.Application;

import com.facebook.drawee.backends.pipeline.Fresco;
import com.parse.Parse;

/**
 * Created by renzo on 16/12/15.
 */
public class Configuracion extends Application {

    @Override
    public void onCreate() {
        super.onCreate();
        Fresco.initialize(getApplicationContext());
        Parse.enableLocalDatastore(this);
        Parse.initialize(this);
    }
}
