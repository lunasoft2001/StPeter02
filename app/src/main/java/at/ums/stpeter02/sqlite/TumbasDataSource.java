package at.ums.stpeter02.sqlite;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.support.annotation.NonNull;
import android.util.Log;

import java.util.ArrayList;
import java.util.List;

import at.ums.stpeter02.modelo.Tumbas;

/**
 * Created by luna-aleixos on 08.04.2016.
 * Va a controlar los CRUD de la tabla Tumbas
 */

public class TumbasDataSource {

    public static final String LOGTAG ="StPeter02";
    DbHelper ayudaDb;
    SQLiteDatabase db;

    public static final String[] todasColumnasTumbas= {
            DbHelper.ColumnasTumbas.ID,
            DbHelper.ColumnasTumbas.COD_TUMBA,
            DbHelper.ColumnasTumbas.NOMBRE,
            DbHelper.ColumnasTumbas.CEMENTERIO,
            DbHelper.ColumnasTumbas.CAMPO,
            DbHelper.ColumnasTumbas.FILA,
            DbHelper.ColumnasTumbas.NUMERO
    };


    public TumbasDataSource(Context context){
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


    public Tumbas crear(Tumbas tumbas){

        ContentValues valores = new ContentValues();

        valores.put(DbHelper.ColumnasTumbas.ID, tumbas.getID());
        valores.put(DbHelper.ColumnasTumbas.COD_TUMBA, tumbas.getCOD_TUMBA());
        valores.put(DbHelper.ColumnasTumbas.NOMBRE, tumbas.getNOMBRE());
        valores.put(DbHelper.ColumnasTumbas.CEMENTERIO, tumbas.getCEMENTERIO());
        valores.put(DbHelper.ColumnasTumbas.CAMPO, tumbas.getCAMPO());
        valores.put(DbHelper.ColumnasTumbas.FILA, tumbas.getFILA());
        valores.put(DbHelper.ColumnasTumbas.NUMERO, tumbas.getNUMERO());

        long idInsertado = db.insert(DbHelper.Tablas.TUMBAS, null, valores);
        tumbas.setID(idInsertado);

        return tumbas;
    }

    public List<Tumbas> verListadoTumbasFiltrado(String filtrado, String ordenado) {

        Cursor cursor = db.query(DbHelper.Tablas.TUMBAS, todasColumnasTumbas, filtrado, null, null, null, ordenado);
        Log.i(LOGTAG, " Contiene: " + cursor.getCount() + " Filas ");
        List<Tumbas> listaTumbas = CursorALista(cursor);
        return listaTumbas;
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



    public List<Tumbas> verListadoTumbas() {


        Cursor cursor = db.query(DbHelper.Tablas.TUMBAS, todasColumnasTumbas, null, null, null, null, null);
        Log.i(LOGTAG, " Contiene: " + cursor.getCount() + " Filas ");
        List<Tumbas> listaTumbas = CursorALista(cursor);
        return listaTumbas;
    }

    //Es un metodo extraido de verListadoTumbas que se repite en cada método de query
    @NonNull
    private List<Tumbas> CursorALista(Cursor cursor) {
        List<Tumbas> listaTumbas = new ArrayList<Tumbas>();
        while (cursor.moveToNext()) {
            Tumbas tumbas = new Tumbas();
            tumbas.setID(cursor.getLong(cursor.getColumnIndex(DbHelper.ColumnasTumbas.ID)));
            tumbas.setCOD_TUMBA(cursor.getString(cursor.getColumnIndex(DbHelper.ColumnasTumbas.COD_TUMBA)));
            tumbas.setNOMBRE(cursor.getString(cursor.getColumnIndex(DbHelper.ColumnasTumbas.NOMBRE)));
            tumbas.setCEMENTERIO(cursor.getString(cursor.getColumnIndex(DbHelper.ColumnasTumbas.CEMENTERIO)));
            tumbas.setCAMPO(cursor.getString(cursor.getColumnIndex(DbHelper.ColumnasTumbas.CAMPO)));
            tumbas.setFILA(cursor.getString(cursor.getColumnIndex(DbHelper.ColumnasTumbas.FILA)));
            tumbas.setNUMERO(cursor.getString(cursor.getColumnIndex(DbHelper.ColumnasTumbas.NUMERO)));

            listaTumbas.add(tumbas);

        }
        return listaTumbas;
    }



    public Cursor recuperarRegistro(long id){

        String condicion = DbHelper.ColumnasTumbas.ID + "=" + id;

        Cursor cursor = db.query(DbHelper.Tablas.TUMBAS,todasColumnasTumbas, condicion,null,null,null,null, null);
        if (cursor != null) {
            cursor.moveToFirst();
        }

        Log.i(LOGTAG, " Contiene: " + cursor.getCount() + " Filas  --- Id num: " + id );



        return cursor;

    }

}
