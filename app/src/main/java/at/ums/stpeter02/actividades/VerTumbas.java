package at.ums.stpeter02.actividades;

import android.content.Intent;
import android.database.Cursor;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.EditText;

import at.ums.stpeter02.R;
import at.ums.stpeter02.modelo.Tumbas;
import at.ums.stpeter02.sqlite.DbHelper;
import at.ums.stpeter02.sqlite.TumbasDataSource;

public class VerTumbas extends AppCompatActivity {

    public static final String LOGTAG ="StPeter02";
    TumbasDataSource mTumbasDataSource;
    private Cursor cursor;
    private long idRegistro;

    //variables para obtener los valores de los campos
    private EditText id;
    private EditText cod_tumba;
    private EditText nombre;
    private EditText cementerio;
    private EditText campo;
    private EditText fila;
    private EditText numero;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_tumbas_formulario);

        Intent intent = getIntent();
        Bundle extra = intent.getExtras();

        if (extra == null) return;

        // Asociamos los elementos de la vista a las variables
        id = (EditText) findViewById(R.id.etIdTumba);
        cod_tumba = (EditText) findViewById(R.id.etCodTumbaOli);
        nombre = (EditText) findViewById(R.id.etNombreTumbaOli);
        cementerio = (EditText) findViewById(R.id.etCementerioOli);
        campo = (EditText) findViewById(R.id.etCampoOli);
        fila = (EditText) findViewById(R.id.etFilaOli);
        numero = (EditText) findViewById(R.id.etNumeroOli);

        //Codigo para el onClicklistener
        findViewById(R.id.boton_cancelarOli).setOnClickListener(mGlobal_onClickListener);
        findViewById(R.id.boton_guardarOli).setOnClickListener(mGlobal_onClickListener);



        //Codigo para iniciar la Db
        mTumbasDataSource = new TumbasDataSource(this);
        mTumbasDataSource.abrir();
        if (extra.containsKey(DbHelper.ColumnasTumbas.ID)){
            idRegistro = extra.getLong(DbHelper.ColumnasTumbas.ID);

            Log.i(LOGTAG, "Id num: " + idRegistro );
            consultar(idRegistro);
        }


    }

    //Intents para cualquier boton de la actividad
    final View.OnClickListener mGlobal_onClickListener = new View.OnClickListener() {
        @Override
        public void onClick(final View v) {
            switch (v.getId()) {
                case R.id.boton_guardarOli:
                    InsertarDatos();
                    break;
                case R.id.boton_cancelarOli:
                    finish();
                    break;
            }

        }
    };

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


    public void InsertarDatos(){
        Tumbas tumba = new Tumbas();

        tumba.setID(Integer.parseInt(id.getText().toString()));
        tumba.setCOD_TUMBA(cod_tumba.getText().toString());
        tumba.setNOMBRE(nombre.getText().toString());
        tumba.setCEMENTERIO(cementerio.getText().toString());
        tumba.setCAMPO(campo.getText().toString());
        tumba.setFILA(fila.getText().toString());
        tumba.setNUMERO(numero.getText().toString());

        mTumbasDataSource.crear(tumba);

        Log.i(LOGTAG,"El valor del ID es " + tumba.getID());
    }


    private void consultar(long id){
        cursor = mTumbasDataSource.recuperarRegistro(id);
        nombre.setText(cursor.getString(cursor.getColumnIndex(DbHelper.ColumnasTumbas.NOMBRE)));

    }


}
