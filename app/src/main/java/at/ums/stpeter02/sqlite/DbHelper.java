package at.ums.stpeter02.sqlite;

import android.content.Context;

import com.readystatesoftware.sqliteasset.SQLiteAssetHelper;

/**
 * Created by luna-aleixos on 06.04.2016.
 * Controlador de la base de datos exporta la Base de datos que se encuentre en la carpeta assets
 */
public class DbHelper extends SQLiteAssetHelper {
    private static int version = 1;
    private static String nombreDb = "stPeter01.db";

    public DbHelper(Context contexto){super(contexto, nombreDb, null,version);}

    /**
     * Interface de las tablas para facilitar su entrada
     */
    interface Tablas{
        String TUMBAS = "tumbas";
        String TRABAJO_CABECERA = "trabajo_cabecera";
    }

    /**
     * Interface de las columnas para facilitar su entrada
     */

    interface ColumnasTumbas{
        String ID = "_id";
        String COD_TUMBA = "tum_IdGrab";
        String NOMBRE = "tum_nombre";
        String CEMENTERIO = "tum_cementerio";
        String CAMPO = "tum_campo";
        String FILA = "tum_fila";
        String NUMERO = "tum_numero";
    }

    interface ColumnasTrabajoCabecera{
        String ID = "_id";
        String DESCRIPCION_TRABAJO = "tr_cab_descripcion";
        String FECHA = "tr_cab_fecha";
        String COD_TRABAJO = "tr_cab_IdTrabajo";
        String TUMBA = "tr_cab_tumba";
    }


}
