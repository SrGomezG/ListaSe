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

    public void adicionarNodoDE(Perro dato) {
        if (cabeza != null) {
            NodoDE temp = cabeza;
            while (temp.getSiguiente() != null) {
                temp = temp.getSiguiente();
            }
            //Estoy en el ultimo
            //amarro perro nuevo ->
            temp.setSiguiente(new NodoDE(dato));
            temp.getSiguiente().setAnterior(temp);
        } //si no hay datos agrego a cabeza ->
        else {
            cabeza = new NodoDE(dato);
        }
    }

    public void adicionarAlInicioDE(Perro dato) {
        if (cabeza != null) {
            NodoDE temp = new NodoDE(dato);
            temp.setSiguiente(cabeza);
            cabeza.setAnterior(temp);
            cabeza = temp;
        } else {
            cabeza = new NodoDE(dato);
        }
    }

    public void eliminarPorPosicionDE(int posicion) {
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

    public void eliminarDE(Perro dato) {
        if (cabeza != null) {
            NodoDE temp = cabeza;
            while (temp.getDato().getNumero() != dato.getNumero()) {
                temp = temp.getSiguiente();
            }
            if (temp == cabeza) {
                cabeza = cabeza.getSiguiente();
                if (cabeza != null) {
                    cabeza.setAnterior(null);
                }
            } else {
                temp.getAnterior().setSiguiente(temp.getSiguiente());
                if (temp.getSiguiente() != null) {
                    temp.getSiguiente().setAnterior(temp.getAnterior());

                }
            }
        }

    }

    public void invertirDE() {
        if (cabeza != null) {
            ListaDE listaTemporal = new ListaDE();
            NodoDE temp = cabeza;
            while (temp != null) {
                listaTemporal.adicionarAlInicioDE(temp.getDato());
                temp = temp.getSiguiente();
            }
            cabeza = listaTemporal.getCabeza();
        }
    }

    public void intercambiarExtremosDE() {
        if (cabeza != null) {
            NodoDE temp = cabeza;
            while (temp.getSiguiente() != null) {
                temp = temp.getSiguiente();

            }
            Perro perrotemp = cabeza.getDato();
            cabeza.setDato(temp.getDato());
            temp.setDato(perrotemp);
        }
    }

    public void mostrarLista() {
        NodoDE recorrer = cabeza;
        while (recorrer != null) {
            System.out.println("(" + recorrer.getDato() + ")");
            recorrer = recorrer.getSiguiente();
        }
    }

    public Perro encontrarxPosicionDE(int posicion) {
        if (cabeza != null) {
            NodoDE temp = cabeza;
            int cont = 1;
            while (posicion != cont) {
                temp = temp.getSiguiente();
                cont++;
            }
            return temp.getDato();
        }
        return null;
    }

    public void borrarPerroPorIdDE(int id) {
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

    public void adicionarNodoPorPosicion(int posicionIngreso, Perro dato) {
        if (cabeza != null) {
            int cont = 1;
            if (posicionIngreso == cont) {
                adicionarAlInicioDE(dato);
            } else {
                NodoDE temp = cabeza;
                while (cont != posicionIngreso - 1 && temp.getSiguiente() != null) {
                    temp = temp.getSiguiente();
                    cont++;
                }
                if (temp.getSiguiente() == null) {

                    adicionarNodoDE(dato);
                } else {
                    NodoDE temp1 = temp.getSiguiente();
                    temp.setSiguiente(new NodoDE(dato));
                    temp.getSiguiente().setSiguiente(temp1);
                    temp1.setAnterior(temp.getSiguiente());
                    temp.getSiguiente().setAnterior(temp);
                }
            }
        } else {
            adicionarNodoDE(dato);
        }

    }

    public void intercambiarPosiciones(int perroUno, int perroDos) {
        if (cabeza != null) {
            Perro temporalUno = encontrarxPosicionDE(perroUno);
            Perro temporalDos = encontrarxPosicionDE(perroDos);
            NodoDE temp = cabeza;
            int cont = 1;
            if (perroUno < perroDos) {
                while (temp.getSiguiente() != null && cont != perroUno) {
                    cont++;
                    temp = temp.getSiguiente();
                }
                if (cont == perroUno) {
                    temp.setDato(temporalDos);
                }
                cont = 1;
                temp = cabeza;
                while (temp.getSiguiente() != null && cont != perroDos) {
                    cont++;
                    temp = temp.getSiguiente();
                }
                if (cont == perroDos) {
                    temp.setDato(temporalUno);
                }
            } else if (perroUno > perroDos) {
                while (temp.getSiguiente() != null && cont != perroDos) {
                    cont++;
                    temp = temp.getSiguiente();
                }
                if (cont == perroDos) {
                    temp.setDato(temporalUno);
                }
                cont = 1;
                temp = cabeza;
                while (temp.getSiguiente() != null && cont != perroUno) {
                    cont++;
                    temp = temp.getSiguiente();
                }
                if (cont == perroUno) {
                    temp.setDato(temporalDos);
                }
            }
        }
    }
}
