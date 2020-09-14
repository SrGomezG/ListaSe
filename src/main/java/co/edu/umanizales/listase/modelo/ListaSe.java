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
public class ListaSe {

    private Nodo cabeza;

    public ListaSe() {
    }

    public Nodo getCabeza() {
        return cabeza;
    }

    public void setCabeza(Nodo cabeza) {
        this.cabeza = cabeza;
    }

    public void adicionarNodo(Perro dato) {
        if (cabeza == null) {
            cabeza = new Nodo(dato);
        } else {
            Nodo temp = cabeza;
            while (temp.getSiguiente() != null) {
                temp = temp.getSiguiente();
            }

            temp.setSiguiente(new Nodo(dato));
        }
    }

    public int contarNodos() {
        if (cabeza != null) {
            Nodo temp = cabeza;
            int cont = 1;
            while (temp.getSiguiente() != null) {
                temp = temp.getSiguiente();
                cont++;
            }
            return cont;
        } else {

        }
        return 0;
    }

    public void adicionarNodoAlInicio(Perro perro) {

        if (cabeza != null) {

            Nodo temp = new Nodo(perro);
            temp.setSiguiente(cabeza);
            cabeza = temp;
        } else {
            cabeza = new Nodo(perro);
        }
    }

    public void invertir() {
        if (cabeza != null) {
            ListaSe listaTemporal = new ListaSe();
            Nodo temp = cabeza;
            while (temp != null) {
                listaTemporal.adicionarNodoAlInicio(temp.getDato());
                temp = temp.getSiguiente();
            }
            cabeza = listaTemporal.getCabeza();
        }
    }

    public void intercambiarExtremos() {
        if (cabeza != null) {
            Nodo temp = cabeza;
            while (temp.getSiguiente() != null) {
                temp = temp.getSiguiente();
            }
            Perro perrotemp = cabeza.getDato();
            cabeza.setDato(temp.getDato());
            temp.setDato(perrotemp);
        }

    }

}
