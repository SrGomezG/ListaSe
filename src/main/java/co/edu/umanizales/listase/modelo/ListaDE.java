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

    public NodoDE getCabeza() {
        return cabeza;
    }

    public void setCabeza(NodoDE cabeza) {
        this.cabeza = cabeza;
    }

    public int contarNodosDE() {
        if (cabeza != null) {
            NodoDE temp = cabeza;
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

    public void invertir() {
        if (cabeza != null) {
            ListaDE listaTemporal = new ListaDE();
            NodoDE temp = cabeza;
            while (temp != null) {
                listaTemporal.adicionarAlInicio(temp.getDato());
                temp = temp.getSiguiente();
                temp = temp.getAnterior();
            }
            cabeza = listaTemporal.getCabeza();
        }
    }

    public void intercambiarExtremos() {
        if (cabeza != null) {
            NodoDE temp = cabeza;
            while (temp.getSiguiente() != null && temp.getAnterior() != null) {
                temp = temp.getAnterior().getSiguiente();

            }
            Perro perrotemp = cabeza.getDato();
            cabeza.setDato(temp.getDato());
            temp.setDato(perrotemp);
        }
    }

    public Perro encontrarxPosicionDE(int posicion) {
        if (cabeza != null) {
            NodoDE temp = cabeza;
            int cont = 1;
            while (posicion != cont) {
                temp = temp.getSiguiente().getAnterior();
                cont++;
            }
            return temp.getDato();
        }
        return null;
    }

    public void borrarPerroPorId(int id) {
        if (cabeza != null) {
            if (cabeza.getDato().getNumero() == id) {
                NodoDE temp = cabeza.getSiguiente().getAnterior();
                cabeza = temp;
            } else {
                NodoDE recienteDE, temp1;
                recienteDE = cabeza;
                temp1 = cabeza.getSiguiente().getAnterior();

                while (temp1 != null && temp1.getDato().getNumero() != id) {
                    recienteDE = recienteDE.getSiguiente().getAnterior();
                    temp1 = temp1.getAnterior().getSiguiente();
                }
                if (temp1.getDato().getNumero() == id) {
                    recienteDE.setSiguiente(temp1.getSiguiente());
                    recienteDE.setAnterior(temp1.getAnterior());
                    temp1 = temp1.getAnterior();
                    temp1 = temp1.getSiguiente();
                }
            }
        } else {
            System.out.println("No hay dato para eliminar");
        }
    }
}
