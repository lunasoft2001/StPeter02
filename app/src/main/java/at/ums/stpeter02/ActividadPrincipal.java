package at.ums.stpeter02;

import android.content.Intent;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

import at.ums.stpeter02.actividades.Oliver;
import at.ums.stpeter02.actividades.TumbasFormulario;
import at.ums.stpeter02.actividades.TumbasListaSimple;
import at.ums.stpeter02.sqlite.DataSource;
import at.ums.stpeter02.sqlite.DbHelper;

public class ActividadPrincipal extends AppCompatActivity {

    public static final String LOGTAG ="StPeter02";

    DataSource mDataSource;

    SQLiteDatabase db;

    private TextView mIdMaximo;

    private Cursor mCursor;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_actividad_principal);




        //Codigo para iniciar la Db
        mDataSource = new DataSource(this);

        //verIdMax2();

    }


    public void verIdMax2(){
        Cursor c = db.rawQuery("SELECT Max(_id) As _id, tum_IdGrab, tum_nombre From Tumbas",null);

        //Recorremos resultados para mostrarlos en pantalla
        mIdMaximo.setText("");
        if(c.moveToFirst()){
            do{
                String valor = c.getString(0);

                mIdMaximo.append(valor);
            }while(c.moveToNext());
        }

    }

    

    /**
     * metodos para controlar el flujo de la BD
     */

    @Override
    protected void onResume() {
        super.onResume();
        mDataSource.abrir();
        mDataSource.verIdMaximo();
    }

    @Override
    protected void onPause() {
        super.onPause();
        mDataSource.cerrar();
    }

    /**
     * metodos para abrir las distintas actividades
     *
     */

    public void botonListaTumbas(View v){
        Intent intento = new Intent(this, TumbasListaSimple.class);
        startActivity(intento);

    }

    public void botonAccion2(View v){
        Intent intento = new Intent(this, TumbasFormulario.class);
        startActivity(intento);

    }

    public void botonOliver(View v){
        Intent intento = new Intent(this, Oliver.class);
        startActivity(intento);

    }

}
