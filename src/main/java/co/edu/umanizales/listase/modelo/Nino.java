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
public class Nino implements Serializable {
    private String nombre;
    private String sexo;
    private byte id;
    
    public Nino(){
        
    }

    public Nino(String nombre, String sexo, byte id) {
        this.nombre = nombre;
        this.sexo = sexo;
        this.id = id;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getSexo() {
        return sexo;
    }

    public void setSexo(String sexo) {
        this.sexo = sexo;
    }

    public byte getId() {
        return id;
    }

    public void setId(byte id) {
        this.id = id;
    }

    @Override
    public String toString() {
        return "Nino{" + "nombre=" + nombre + ", sexo=" + sexo + ", id=" + id + '}';
    }

    
}
