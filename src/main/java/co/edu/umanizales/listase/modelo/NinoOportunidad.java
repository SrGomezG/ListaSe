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
public class NinoOportunidad extends Nino implements Serializable {

    private byte oportunidades;
    private Nino dato2;

    public NinoOportunidad() {

    }

    public NinoOportunidad(byte oportunidades, Nino dato2) {
        this.oportunidades = oportunidades;
        this.dato2 = dato2;
    }

    public NinoOportunidad(byte oportunidades, Nino dato2, String nombre, String sexo, byte id) {
        super(nombre, sexo, id);
        this.oportunidades = oportunidades;
        this.dato2 = dato2;
    }

    public byte getOportunidades() {
        return oportunidades;
    }

    public void setOportunidades(byte oportunidades) {
        this.oportunidades = oportunidades;
    }

    public Nino getDato2() {
        return dato2;
    }

    public void setDato2(Nino dato2) {
        this.dato2 = dato2;
    }

    @Override
    public String toString() {
        return "NinoOportunidad{" + "oportunidades=" + oportunidades + ", dato2=" + dato2 + '}';
    }

   
}
