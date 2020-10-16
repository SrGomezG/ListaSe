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
public class ListaDE {
    
    private NodoDE cabeza;
    
    public ListaDE() {
    }
    
    public void adicionarNodo(Perro dato) {
        if (cabeza != null) {
            NodoDE temp = cabeza;
            
            while (temp.getSiguiente() != null) {
                temp = temp.getSiguiente();
            }
            
            temp.setSiguiente(new NodoDE(dato));
            temp.getSiguiente().setAnterior(temp);
        } else {
            cabeza = new NodoDE(dato);
        }
    }
    
    public void adicionarAlInicio(Perro dato) {
        if (cabeza != null) {
            NodoDE temp = new NodoDE(dato);
            temp.setSiguiente(cabeza);
            cabeza.setAnterior(temp);
            cabeza = temp;
        } else {
            cabeza = new NodoDE(dato);
        }
    }
    
    public void eliminarPorPosicion(int posicion) {
        if (cabeza != null) {
            if (posicion == 1) {
                cabeza = cabeza.getSiguiente();
                if (cabeza != null) {
                    cabeza.setAnterior(null);
                }
            } else {
                NodoDE temp = cabeza;
                int contador = 1;
                while (contador != posicion - 1) {
                    temp = temp.getSiguiente();
                    contador++;
                }
                temp.setSiguiente(temp.getSiguiente().getSiguiente());
                if (temp.getSiguiente() != null) {
                    temp.getSiguiente().setAnterior(temp);
                }
            }
        }
    }
    
    public void eliminar(Perro dato) {
        if (cabeza != null) {
            NodoDE temp = cabeza;
            while (temp.getDato().getNumero() != dato.getNumero()) {
                temp = temp.getSiguiente();
            }
            if (temp == cabeza) {
                cabeza = cabeza.getSiguiente();
                if (cabeza != null) {
                    cabeza.setAnterior(null);
                } else {
                    temp.getAnterior().setSiguiente(temp.getSiguiente());
                    if (temp.getSiguiente() != null) {
                        temp.getSiguiente().setAnterior(temp.getAnterior());
                    }
                }
            }
        }
    }
}
