package com.example.putencio.sqlite;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import com.example.putencio.utils.Contantes;

/**
 * Created by putencio on 18/12/15.
 */
public class ManagerOpenHelper extends SQLiteOpenHelper {
    public ManagerOpenHelper(Context context) {
        super(context, Contantes.DB_NAME, null, Contantes.DB_VERSION);
    }


    @Override
    public void onCreate(SQLiteDatabase db) {
        db.execSQL(Contantes.CREAR_RESERVA);
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {

    }
}
