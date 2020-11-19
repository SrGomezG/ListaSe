/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package co.edu.umanizales.listase.modelo;

import java.io.Serializable;

/**
 *
 * @author tsuyo
 */
public class NinoOportunidad implements Serializable {

    private Nino nino;
    private int oportunidad;

    public NinoOportunidad() {

    }

    public NinoOportunidad(Nino nino, int oportunidad) {
        this.nino = nino;
        this.oportunidad = oportunidad;
    }

    public Nino getNino() {
        return nino;
    }

    public void setNino(Nino nino) {
        this.nino = nino;
    }

    public int getOportunidad() {
        return oportunidad;
    }

    public void setOportunidad(int oportunidad) {
        this.oportunidad = oportunidad;
    }

}
