package at.ums.stpeter02.actividades;

import android.app.ListActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import java.util.List;

import at.ums.stpeter02.R;
import at.ums.stpeter02.modelo.Tumbas;
import at.ums.stpeter02.sqlite.DataSource;
import at.ums.stpeter02.sqlite.TumbasDataSource;

public class TumbasListaSimple extends ListActivity {

    /**
     * Definición de Variables
     */

    TumbasDataSource mTumbasDataSource;
    private List<Tumbas> tumbas;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_tumbas_lista_simple);

        mTumbasDataSource = new TumbasDataSource(this);
        mTumbasDataSource.abrir();


        //tumbas = mTumbasDataSource.verListadoTumbas();
        tumbas = mTumbasDataSource.verIdMaximo();



        RefrescarPantalla();

    }

    public void RefrescarPantalla(){
        ArrayAdapter<Tumbas> adapter = new ArrayAdapter<Tumbas>(this, android.R.layout.simple_expandable_list_item_1, tumbas);
        setListAdapter(adapter);
    }

    @Override
    protected void onResume() {
        super.onResume();
        mTumbasDataSource.abrir();
    }

    @Override
    protected void onPause() {
        super.onPause();
        mTumbasDataSource.cerrar();
    }


}

