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
public class ListaDETT {

    private NodoDETT cabeza;
    private int totalNinos = 0;

    public ListaDETT() {

    }

    public NodoDETT getCabeza() {
        return cabeza;
    }

    public void setCabeza(NodoDETT cabeza) {
        this.cabeza = cabeza;
    }

    public int getTotalNinos() {
        return totalNinos;
    }

    public void setTotalNinos(int totalNinos) {
        this.totalNinos = totalNinos;
    }

    public void adicionarNodoCircularTT(Nino dato) {
        if (cabeza == null) {
            cabeza = new NodoDETT(dato);
            cabeza.setSiguiente(cabeza);
            cabeza.setAnterior(cabeza);
        } else {
            NodoDETT temp = new NodoDETT(dato);
            cabeza.getAnterior().setSiguiente(temp);
            temp.setSiguiente(cabeza);
            temp.setAnterior(cabeza.getAnterior());
            cabeza.setAnterior(temp);
        }
        totalNinos++;
    }

    public void adicionarNodoAlInicio(Nino dato) {
        if (cabeza == null) {
            cabeza = new NodoDETT(dato);
            cabeza.setSiguiente(cabeza);
            cabeza.setAnterior(cabeza);
        } else {
            NodoDETT temp = new NodoDETT(dato);
            cabeza.getAnterior().setSiguiente(temp);
            temp.setSiguiente(cabeza);
            temp.setAnterior(cabeza.getAnterior());
            cabeza.setAnterior(temp);
            cabeza = temp;
        }
        totalNinos++;
    }

    public void eliminarPosicion(Nino NinoEliminar) {
        if (cabeza != null) {
            NodoDETT temp = cabeza;
            while (temp.getDato().getId() != NinoEliminar.getId()) {
                temp = temp.getSiguiente();

            }
            if (temp == cabeza) {
                cabeza = temp.getSiguiente();
                cabeza.setAnterior(cabeza.getAnterior().getAnterior());
                cabeza.getAnterior().setSiguiente(cabeza);
            } else {
                temp.getSiguiente().setAnterior(temp.getAnterior());
                temp.getAnterior().setSiguiente(temp.getSiguiente());
            }
            totalNinos++;
        }
    }

    public void adicionarNodoEnPosicion(int posicionIngreso, Nino dato) {
        if (cabeza != null) {
            int cont = 1;
            NodoDETT temp = cabeza;
            if (posicionIngreso == cont) {
                adicionarNodoAlInicio(dato);
            } else {
                while (cont != posicionIngreso && temp.getSiguiente() != cabeza) {
                    temp = temp.getSiguiente();
                    cont++;
                }
                if (cont < posicionIngreso) {
                    adicionarNodoCircularTT(dato);
                } else {
                    NodoDETT temp1 = temp.getAnterior();
                    temp.setAnterior(new NodoDETT(dato));
                    temp.getAnterior().setAnterior(temp1);
                    temp1.setSiguiente(temp.getAnterior());
                    temp.getAnterior().setSiguiente(temp);
                }
            }
        } else {
            adicionarNodoCircularTT(dato);
        }
        totalNinos++;
    }
}
