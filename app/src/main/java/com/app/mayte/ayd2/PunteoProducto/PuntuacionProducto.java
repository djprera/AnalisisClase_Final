package com.app.mayte.ayd2.PunteoProducto;
import org.parceler.Parcel;

/**
 * Created by Diego Prera on 10/30/2017.
 */


public class PuntuacionProducto {

    private int codigo;
    private int puntuacion;

    public PuntuacionProducto(int codigo, int puntuacion){
        this.codigo = codigo;
        this.puntuacion = puntuacion;
    }

    public int getPuntuacion() {
        return puntuacion;
    }

    public int getCodigo() {
        return codigo;
    }
}
