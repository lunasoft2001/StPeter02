package at.ums.stpeter02.modelo;

import android.os.Parcel;
import android.os.Parcelable;
import android.util.Log;

import at.ums.stpeter02.ActividadPrincipal;

/**
 * Created by luna-aleixos on 07.04.2016.
 */
public class Tumbas implements Parcelable{
    private long ID;
    private String COD_TUMBA;
    private String NOMBRE;
    private String CEMENTERIO;
    private String CAMPO;
    private String FILA;
    private String NUMERO;




    public long getID() {
        return ID;
    }

    public void setID(long ID) {
        this.ID = ID;
    }

    public String getCOD_TUMBA() {
        return COD_TUMBA;
    }

    public void setCOD_TUMBA(String COD_TUMBA) {
        this.COD_TUMBA = COD_TUMBA;
    }

    public String getNOMBRE() {
        return NOMBRE;
    }

    public void setNOMBRE(String NOMBRE) {
        this.NOMBRE = NOMBRE;
    }

    public String getCEMENTERIO() {
        return CEMENTERIO;
    }

    public void setCEMENTERIO(String CEMENTERIO) {
        this.CEMENTERIO = CEMENTERIO;
    }

    public String getCAMPO() {
        return CAMPO;
    }

    public void setCAMPO(String CAMPO) {
        this.CAMPO = CAMPO;
    }

    public String getFILA() {
        return FILA;
    }

    public void setFILA(String FILA) {
        this.FILA = FILA;
    }

    public String getNUMERO() {
        return NUMERO;
    }

    public void setNUMERO(String NUMERO) {
        this.NUMERO = NUMERO;
    }

    @Override
    public String toString() {
        return COD_TUMBA + "\n" + NOMBRE;
    }



    public Tumbas() {
    }

    public Tumbas(Parcel in) {
        Log.i(ActividadPrincipal.LOGTAG, "Parcel constructor");

        ID = in.readLong();
        COD_TUMBA = in.readString();
        NOMBRE = in.readString();
        CEMENTERIO = in.readString();
        CAMPO = in.readString();
        FILA = in.readString();
        NUMERO = in.readString();

    }

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        Log.i(ActividadPrincipal.LOGTAG, "writeToParcel");

        dest.writeLong(ID);
        dest.writeString(COD_TUMBA);
        dest.writeString(NOMBRE);
        dest.writeString(CEMENTERIO);
        dest.writeString(CAMPO);
        dest.writeString(FILA);
        dest.writeString(NUMERO);
    }

    public static final Parcelable.Creator<Tumbas> CREATOR =
            new Parcelable.Creator<Tumbas>() {

                @Override
                public Tumbas createFromParcel(Parcel source) {
                    Log.i(ActividadPrincipal.LOGTAG, "createFromParcel");
                    return new Tumbas(source);
                }

                @Override
                public Tumbas[] newArray(int size) {
                    Log.i(ActividadPrincipal.LOGTAG, "newArray");
                    return new Tumbas[size];
                }
    };
}
