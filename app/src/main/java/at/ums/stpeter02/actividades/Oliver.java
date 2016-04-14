package at.ums.stpeter02.actividades;

import android.app.Activity;
import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import at.ums.stpeter02.R;
import at.ums.stpeter02.modelo.Tumbas;
import at.ums.stpeter02.sqlite.DbHelper;
import at.ums.stpeter02.sqlite.OliverDataSource;


public class Oliver extends AppCompatActivity {

    OliverDataSource mOliverDataSource;
    public static final String LOGTAG ="StPeter02";


    private SQLiteDatabase db;

    private EditText txtId;
    private EditText txtCodigo;
    private EditText txtNombre;
    private EditText txtCementerio;
    private EditText txtCampo;
    private EditText txtFila;
    private EditText txtNumero;
    private TextView txtIdMaximo;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_oliver);


        //Obtenemos las referencias a los controles
        txtId = (EditText) findViewById(R.id.etIdTumbaOli);
        txtCodigo = (EditText) findViewById(R.id.etCodTumbaOli);
        txtNombre = (EditText) findViewById(R.id.etNombreTumbaOli);
        txtCementerio = (EditText) findViewById(R.id.etCementerioOli);
        txtCampo = (EditText) findViewById(R.id.etCampoOli);
        txtFila = (EditText) findViewById(R.id.etFilaOli);
        txtNumero = (EditText) findViewById(R.id.etNumeroOli);
        txtIdMaximo = (TextView) findViewById(R.id.tvIdMaximo);

        //Abrimos la BD en modo escritura

        mOliverDataSource = new OliverDataSource(this);
        mOliverDataSource.abrir();


        //Codigo para el onClicklistener
        findViewById(R.id.boton_cancelarOli).setOnClickListener(mGlobal_onClickListener);
        findViewById(R.id.boton_guardarOli).setOnClickListener(mGlobal_onClickListener);
        findViewById(R.id.btInsertar).setOnClickListener(mGlobal_onClickListener);
        findViewById(R.id.btActualizar).setOnClickListener(mGlobal_onClickListener);
        findViewById(R.id.btConsultar).setOnClickListener(mGlobal_onClickListener);
        findViewById(R.id.btEliminar).setOnClickListener(mGlobal_onClickListener);

    }

    //Intents para cualquier boton de la actividad
    final View.OnClickListener mGlobal_onClickListener = new View.OnClickListener() {
        @Override
        public void onClick(final View v) {
            switch (v.getId()) {
                case R.id.btInsertar:
                    Insertar();
                    break;
                case R.id.btActualizar:
                    Actualizar();
                    break;
                case R.id.btEliminar:
                    Eliminar();
                    break;
                case R.id.btConsultar:
                    //finish();
                    break;
            }

        }
    };


    public void Insertar() {

         //Recuperamos los campos de texto
        int id = Integer.parseInt(txtId.getText().toString());
        String codigo = txtCodigo.getText().toString();
        String nombre = txtNombre.getText().toString();
        String cementerio = txtCementerio.getText().toString();
        String campo = txtCampo.getText().toString();
        String fila = txtFila.getText().toString();
        String numero = txtNumero.getText().toString();

        //metodo insert
        ContentValues nuevoRegistro = new ContentValues();
        nuevoRegistro.put(DbHelper.ColumnasTumbas.ID,id);
        nuevoRegistro.put(DbHelper.ColumnasTumbas.COD_TUMBA, codigo);
        nuevoRegistro.put(DbHelper.ColumnasTumbas.NOMBRE, nombre);
        nuevoRegistro.put(DbHelper.ColumnasTumbas.CEMENTERIO, cementerio);
        nuevoRegistro.put(DbHelper.ColumnasTumbas.CAMPO, campo);
        nuevoRegistro.put(DbHelper.ColumnasTumbas.FILA, fila);
        nuevoRegistro.put(DbHelper.ColumnasTumbas.NUMERO, numero);

        db.insert(DbHelper.Tablas.TUMBAS,null,nuevoRegistro);



//        Tumbas tumba = new Tumbas();
//
//        tumba.setID(Integer.parseInt(txtId.getText().toString()));
//        tumba.setCOD_TUMBA(txtCodigo.getText().toString());
//        tumba.setNOMBRE(txtNombre.getText().toString());
//        tumba.setCEMENTERIO(txtCementerio.getText().toString());
//        tumba.setCAMPO(txtCampo.getText().toString());
//        tumba.setFILA(txtFila.getText().toString());
//        tumba.setNUMERO(txtNumero.getText().toString());
//
//        mOliverDataSource.insertarTumba(tumba);
//
//        Log.i(LOGTAG,"El valor del ID es " + tumba.getID());
    }


    public void Actualizar() {
        //Recuperamos los campos de texto
        int id = Integer.parseInt(txtId.getText().toString());
        String codigo = txtCodigo.getText().toString();
        String nombre = txtNombre.getText().toString();
        String cementerio = txtCementerio.getText().toString();
        String campo = txtCampo.getText().toString();
        String fila = txtFila.getText().toString();
        String numero = txtNumero.getText().toString();

        //metodo update
        ContentValues actualizarRegistro = new ContentValues();
        //actualizarRegistro.put(DbHelper.ColumnasTumbas.ID,id);
        actualizarRegistro.put(DbHelper.ColumnasTumbas.COD_TUMBA, codigo);
        actualizarRegistro.put(DbHelper.ColumnasTumbas.NOMBRE, nombre);
        actualizarRegistro.put(DbHelper.ColumnasTumbas.CEMENTERIO, cementerio);
        actualizarRegistro.put(DbHelper.ColumnasTumbas.CAMPO, campo);
        actualizarRegistro.put(DbHelper.ColumnasTumbas.FILA, fila);

        db.update(DbHelper.Tablas.TUMBAS, actualizarRegistro, DbHelper.ColumnasTumbas.ID + "=" + id, null);

    }


    public void Eliminar() {

        //Recuperamos los campos de texto
        int id = Integer.parseInt(txtId.getText().toString());

        //Metodo delete
        db.delete(DbHelper.Tablas.TUMBAS, DbHelper.ColumnasTumbas.ID + "=" + id, null);

    }

}
