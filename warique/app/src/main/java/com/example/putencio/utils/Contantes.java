package com.example.putencio.utils;

/**
 * Created by putencio on 18/12/15.
 */
public class Contantes {
    public static final String DB_NAME = "warique.db";
    public static final int DB_VERSION = 1;

    public static final String TB_RESERVA = "tb_reserva";

    public static final String C_ID = "id";
    public static final String C_NOMBRE = "nombre";
    public static final String C_MENSAJE = "mensaje";

    public static final String CREAR_RESERVA = "create table " + TB_RESERVA + "(" +
            C_ID + " integer primary key autoincrement," + C_NOMBRE + " text," +
            C_MENSAJE + " text)";

}
