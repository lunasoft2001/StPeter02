package at.ums.stpeter02.actividades;

import android.app.ListActivity;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import java.util.List;

import at.ums.stpeter02.R;
import at.ums.stpeter02.modelo.Tumbas;
import at.ums.stpeter02.sqlite.DataSource;
import at.ums.stpeter02.sqlite.DbHelper;
import at.ums.stpeter02.sqlite.TumbasDataSource;

public class TumbasListaSimple extends ListActivity {

    /**
     * Definición de Variables
     */

    public static final String LOGTAG ="StPeter02";
    TumbasDataSource mTumbasDataSource;
    private List<Tumbas> tumbas;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_tumbas_lista_simple);

        mTumbasDataSource = new TumbasDataSource(this);
        mTumbasDataSource.abrir();


        tumbas = mTumbasDataSource.verListadoTumbas();



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

    @Override
    protected void onListItemClick(ListView l, View v, int position, long id) {
        super.onListItemClick(l, v, position, id);

       visualizar(id);
    }

    private void visualizar(long id){
        Intent i = new Intent(TumbasListaSimple.this, VerTumbas.class);
        i.putExtra(DbHelper.ColumnasTumbas.ID, id);
        Log.i(LOGTAG, "Id num al hacer click: " + id );

        startActivity(i);
    }

}

