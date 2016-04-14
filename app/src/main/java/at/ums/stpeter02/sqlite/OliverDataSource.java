package at.ums.stpeter02.sqlite;

import android.content.ContentValues;
import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.util.Log;

import at.ums.stpeter02.modelo.Tumbas;

/**
 * Created by luna-aleixos on 14.04.2016.
 * Va a controlar los CRUD de la tabla Tumbas a traves de la actividad Oliver
 */

public class OliverDataSource {

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

    public OliverDataSource (Context context){
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


    public Tumbas insertarTumba (Tumbas tumbas){

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




//        //Recuperamos los campos de texto
//        int id = Integer.parseInt(txtId.getText().toString());
//        String codigo = txtCodigo.getText().toString();
//        String nombre = txtNombre.getText().toString();
//        String cementerio = txtCementerio.getText().toString();
//        String campo = txtCampo.getText().toString();
//        String fila = txtFila.getText().toString();
//        String numero = txtNumero.getText().toString();
//
//        //metodo insert
//        ContentValues nuevoRegistro = new ContentValues();
//        nuevoRegistro.put(DbHelper.ColumnasTumbas.ID,id);
//        nuevoRegistro.put(DbHelper.ColumnasTumbas.COD_TUMBA, codigo);
//        nuevoRegistro.put(DbHelper.ColumnasTumbas.NOMBRE, nombre);
//        nuevoRegistro.put(DbHelper.ColumnasTumbas.CEMENTERIO, cementerio);
//        nuevoRegistro.put(DbHelper.ColumnasTumbas.CAMPO, campo);
//        nuevoRegistro.put(DbHelper.ColumnasTumbas.FILA, fila);
//        nuevoRegistro.put(DbHelper.ColumnasTumbas.NUMERO, numero);
//
//        db.insert(DbHelper.Tablas.TUMBAS,null,nuevoRegistro);

    }
}
