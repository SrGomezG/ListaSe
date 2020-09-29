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
    public Perro encontrarxPosicion(int posicion){
        if(cabeza!=null){
            Nodo temp= cabeza;
            int cont=1;
            while (posicion!=cont) {                
                temp = temp.getSiguiente();
                cont++;
            }
            return temp.getDato();
        }
        return null;
    }
    
    public void borrarPorPerroId(int id) {
        if (cabeza != null) {
            if (cabeza.getDato().getNumero() == id){
                Nodo temp = cabeza.getSiguiente();
                cabeza = temp;
            } else{
                Nodo reciente, temp1;
                reciente = cabeza;
                temp1 = cabeza.getSiguiente();
                
                while (temp1 != null && temp1.getDato().getNumero() != id){
                    reciente = reciente.getSiguiente();
                    temp1 = temp1.getSiguiente();
                }
                if (temp1.getDato().getNumero() == id){
                    reciente.setSiguiente(temp1.getSiguiente());
                    temp1 = reciente.getSiguiente();
                }
            }
        }else {
                    System.out.println("No hay dato para eliminar");
                    }
    }
}
