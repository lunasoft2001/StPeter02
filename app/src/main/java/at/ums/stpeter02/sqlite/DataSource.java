package at.ums.stpeter02.sqlite;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.util.Log;
import android.view.View;

import java.util.ArrayList;
import java.util.List;

import at.ums.stpeter02.modelo.Tumbas;

/**
 * Created by luna-aleixos on 08.04.2016.
 * Va a controlar los CRUD de la tabla Tumbas
 */

public class DataSource {

    public static final String LOGTAG ="StPeter02";
    DbHelper ayudaDb;
    SQLiteDatabase db;



    public DataSource(Context context){

        ayudaDb = new DbHelper(context);

    }

    public void abrir(){
        Log.i(LOGTAG,"DB abierta");
        db = ayudaDb.getWritableDatabase();
    }

    public void cerrar(){
        Log.i(LOGTAG,"DB cerrada");
        ayudaDb.close();
    }


    public List<Tumbas> verIdMaximo(){
        Cursor cursor = db.rawQuery("SELECT Max(_id) As _id, tum_IdGrab, tum_nombre From Tumbas",null);

        List<Tumbas> listaTumbas = new ArrayList<Tumbas>();
        while (cursor.moveToNext()) {
            Tumbas tumbas = new Tumbas();
            tumbas.setID(cursor.getLong(cursor.getColumnIndex(DbHelper.ColumnasTumbas.ID)));
            tumbas.setCOD_TUMBA(cursor.getString(cursor.getColumnIndex(DbHelper.ColumnasTumbas.COD_TUMBA)));
            tumbas.setNOMBRE(cursor.getString(cursor.getColumnIndex(DbHelper.ColumnasTumbas.NOMBRE)));
            listaTumbas.add(tumbas);
        }


        return listaTumbas;
    }



}
