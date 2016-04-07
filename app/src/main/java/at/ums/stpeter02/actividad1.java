package at.ums.stpeter02;

import android.content.Context;
import android.content.DialogInterface;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;

import at.ums.stpeter02.modelo.Tumbas;
import at.ums.stpeter02.sqlite.DataSource;

public class actividad1 extends AppCompatActivity {

    public static final String LOGTAG ="StPeter02";
    DataSource mDataSource;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_actividad1);


        //Codigo para iniciar la Db
        mDataSource = new DataSource(this);
        mDataSource.abrir();
//        CrearDatos();


        //Codigo para el onClicklistener
        findViewById(R.id.buttonIngresar).setOnClickListener(mGlobal_onClickListener);
    }



    //Intents para cualquier boton de la actividad
    final View.OnClickListener mGlobal_onClickListener = new View.OnClickListener() {
        @Override
        public void onClick(final View v) {
            switch (v.getId()) {
                case R.id.buttonIngresar:
                    CrearDatos();
                break;
            }

        }
    };


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

    public void CrearDatos(){
        Tumbas tumba = new Tumbas();

        tumba.setID(6);
        tumba.setCOD_TUMBA("P 06-01-01");
        tumba.setNOMBRE("Tumba 6");
        tumba.setCEMENTERIO("St. Peter");
        tumba.setCAMPO("06");
        tumba.setFILA("01");
        tumba.setNUMERO("01");

        mDataSource.crear(tumba);

        Log.i(LOGTAG,"El valor del ID es " + tumba.getID());
    }

}
