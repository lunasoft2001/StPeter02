package at.ums.stpeter02;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;

import at.ums.stpeter02.actividades.Oliver;
import at.ums.stpeter02.actividades.TumbasFormulario;
import at.ums.stpeter02.actividades.TumbasListaSimple;
import at.ums.stpeter02.sqlite.DataSource;


public class ActividadPrincipal extends AppCompatActivity {

    public static final String LOGTAG ="StPeter02";


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_actividad_principal);

        DataSource DS = new DataSource(getApplicationContext());
        long id = DS.idMaximo().getID();

        Log.i(LOGTAG, " El id Maximo es : " + id);
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
