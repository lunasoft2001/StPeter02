package at.ums.stpeter02;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;

import at.ums.stpeter02.sqlite.DataSource;

public class ActividadPrincipal extends AppCompatActivity {

    public static final String LOGTAG ="StPeter02";

    DataSource mDataSource;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_actividad_principal);

        //Codigo para iniciar la Db
        mDataSource = new DataSource(this);
    }


    /**
     * metodos para controlar el flujo de la BD
     */

    @Override
    protected void onResume() {
        super.onResume();
        mDataSource.abrir();
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

    public void boton1(View v){
        Intent intento = new Intent(this, actividad1.class);
        startActivity(intento);

    }



}
