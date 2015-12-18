package com.example.putencio.sqlite;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;

import com.example.putencio.models.Reserva;
import com.example.putencio.utils.Contantes;

import java.util.ArrayList;

/**
 * Created by putencio on 18/12/15.
 */
public class SentenciaSQL {
    private ManagerOpenHelper conexion;

    public SentenciaSQL(Context context) {
        conexion = new ManagerOpenHelper(context);
    }

    public void insertaReserva(Reserva reserva) {
        SQLiteDatabase db = conexion.getWritableDatabase();

        ContentValues contentValues = new ContentValues();
        contentValues.put(Contantes.C_NOMBRE, reserva.getNombre());
        contentValues.put(Contantes.C_MENSAJE, reserva.getMensaje());

        db.insert(Contantes.TB_RESERVA, null, contentValues);
    }

    public ArrayList<Reserva> listarTodo() {
        SQLiteDatabase db = conexion.getReadableDatabase();
        Cursor cursor = db.rawQuery(
                "select * from " + Contantes.TB_RESERVA,
                null
        );

        ArrayList<Reserva> lista = new ArrayList<>();

        if (cursor != null) {
            if (cursor.moveToFirst()) {
                do {
                    Reserva reserva = new Reserva();
                    reserva.setId(cursor.getInt(cursor.getColumnIndex(Contantes.C_ID)));
                    reserva.setNombre(cursor.getString(cursor.getColumnIndex(Contantes.C_NOMBRE)));
                    reserva.setMensaje(cursor.getString(cursor.getColumnIndex(Contantes.C_MENSAJE)));

                    lista.add(reserva);
                } while (cursor.moveToNext());
            }
        }
        return lista;
    }

    public void actualizaReserva(Reserva reserva) {
        SQLiteDatabase db = conexion.getWritableDatabase();

        ContentValues contentValues = new ContentValues();
        contentValues.put(Contantes.C_NOMBRE, reserva.getNombre());
        contentValues.put(Contantes.C_MENSAJE, reserva.getMensaje());

        db.update(Contantes.TB_RESERVA, contentValues, Contantes.C_ID + "=?", new String[]{Integer.toString(reserva.getId())});
    }

    public void eliminaReserva(int id) {
        SQLiteDatabase db = conexion.getWritableDatabase();

        db.delete(Contantes.TB_RESERVA, Contantes.C_ID + "=?", new String[]{Integer.toString(id)});
    }

}
