/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package co.edu.umanizales.listase.modelo;

/**
 *
 * @author tsuyo
 */
public class NodoDETT {
    
    private Nino dato;
    private NodoDETT siguiente;
    private NodoDETT anterior;

    public NodoDETT(Nino dato) {
        this.dato = dato;
    }

    public Nino getDato() {
        return dato;
    }

    public void setDato(Nino dato) {
        this.dato = dato;
    }

    public NodoDETT getSiguiente() {
        return siguiente;
    }

    public void setSiguiente(NodoDETT siguiente) {
        this.siguiente = siguiente;
    }

    public NodoDETT getAnterior() {
        return anterior;
    }

    public void setAnterior(NodoDETT anterior) {
        this.anterior = anterior;
    }
    
    
}
