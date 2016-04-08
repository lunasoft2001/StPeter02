package at.ums.stpeter02.sqlite;

import android.content.ContentValues;
import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.util.Log;
import android.view.View;

import at.ums.stpeter02.modelo.Tumbas;

/**
 * Created by luna-aleixos on 06.04.2016.
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


}
