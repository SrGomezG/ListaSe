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
    //otros metodos

    public ListaDETT() {
    }
    
    public NodoDETT getCabeza() {
        return cabeza;
    }
    
    public void setCabeza(NodoDETT cabeza) {
        this.cabeza = cabeza;
    }
    
    public void adicionarNodoCircular(Nino dato) {
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
    
//    public void adicionarNodo(Nino dato) {
//        if (cabeza != null) {
//            NodoDETT temp = cabeza;
//            while (temp.getSiguiente() != null) {
//                temp = temp.getSiguiente();
//            }
//            //Estoy en el ultimo
//            //amarro niño nuevo ->
//            temp.setSiguiente(new NodoDETT(dato));
//            temp.getSiguiente().setAnterior(temp);
//        } //si no hay datos agrego a cabeza ->
//        else {
//            cabeza = new NodoDETT(dato);
//        }
//    }

    public int contarNodos() //cabeza
    {
        if (cabeza != null) {
            NodoDETT temp = cabeza;
            int cont = 1;
            while (temp.getSiguiente() != null) //Mientras el lazo este lleno
            {
                temp = temp.getSiguiente(); // Ayudante pase al siguiente niño
                cont++;
            }
            return cont;
        } else {
            return 0;
        }
    }
    
    public void adicionarAlInicioDETT(Nino dato) {
        if (cabeza != null) {
            NodoDETT temp = new NodoDETT(dato);
            temp.setSiguiente(cabeza);
            cabeza.setAnterior(temp);
            cabeza = temp;
        } else {
            cabeza = new NodoDETT(dato);
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
                NodoDETT temp = cabeza;
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
    
    public void eliminar(Nino dato) {
        if (cabeza != null) {
            NodoDETT temp = cabeza;
            while (temp.getDato().getId() != dato.getId()) {
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
    
    public Nino encontrarxPosicionDETT(int posicion) {
        if (cabeza != null) {
            NodoDETT temp = cabeza;
            int cont = 1;
            while (posicion != cont) {
                temp = temp.getSiguiente();
                cont++;
            }
            return temp.getDato();
        }
        return null;
    }
    
    public void invertir() {
        if (cabeza != null) {
            ListaDETT listaTemporal = new ListaDETT();
            NodoDETT temp = cabeza;
            while (temp != null) {
                listaTemporal.adicionarAlInicioDETT(temp.getDato());
                temp = temp.getSiguiente();
            }
            cabeza = listaTemporal.getCabeza();
        }
    }
    
    public void intercambiarExtremos() {
        
        if (cabeza != null) {
            NodoDETT temp = cabeza;
            while (temp.getSiguiente() != null) {
                temp = temp.getSiguiente();
            }
            Nino ninotemp = cabeza.getDato();
            cabeza.setDato(temp.getDato());
            temp.setDato(ninotemp);
        }
    }
    
    public void mostrarLista() {
        NodoDETT recorrer = cabeza;
        while (recorrer != null) {
            System.out.println("(" + recorrer.getDato() + ")");
            recorrer = recorrer.getSiguiente();
        }
    }
    
    public void filtrarMasculino() {
        if (cabeza != null) {
            ListaDETT listatemp = new ListaDETT();
            NodoDETT temp = cabeza;
            
            while (temp != null) {
                if (temp.getDato().getSexo() == "M") {
                    listatemp.adicionarAlInicioDETT(temp.getDato());
                } else {
                    listatemp.adicionarNodoCircular(temp.getDato());
                }
                temp = temp.getSiguiente();
            }
            cabeza = listatemp.getCabeza();
        } else {
            System.out.println("No hay niños para filtrar");
        }
    }
    
    public void filtrarFemenino() {
        if (cabeza != null) {
            ListaDETT listatemp = new ListaDETT();
            NodoDETT temp = cabeza;
            
            while (temp != null) {
                if (temp.getDato().getSexo() == "H") {
                    listatemp.adicionarAlInicioDETT(temp.getDato());
                } else {
                    listatemp.adicionarNodoCircular(temp.getDato());
                }
                temp = temp.getSiguiente();
            }
            cabeza = listatemp.getCabeza();
        } else {
            System.out.println("No hay niños para Filtrar");
        }
    }
    
    public void adicionarNodoPorPosicion(int posicionIngreso, Nino dato) {
        if (cabeza != null) {
            int cont = 1;
            if (posicionIngreso == cont) {
                adicionarAlInicioDETT(dato);
            } else {
                NodoDETT temp = cabeza;
                while (cont != posicionIngreso - 1 && temp.getSiguiente() != null) {
                    temp = temp.getSiguiente();
                    cont++;
                }
                if (temp.getSiguiente() == null) {
                    
                    adicionarNodoCircular(dato);
                } else {
                    NodoDETT temp1 = temp.getSiguiente();
                    temp.setSiguiente(new NodoDETT(dato));
                    temp.getSiguiente().setSiguiente(temp1);
                    temp1.setAnterior(temp.getSiguiente());
                    temp.getSiguiente().setAnterior(temp);
                }
            }
        } else {
            adicionarNodoCircular(dato);
            
        }

    }

    public void intercambiarPosiciones(int ninoUno, int ninoDos) {
        if (cabeza != null) {
            Nino temporalUno = encontrarxPosicionDETT(ninoUno);
            Nino temporalDos = encontrarxPosicionDETT(ninoDos);
            NodoDETT temp = cabeza;
            int cont = 1;
            if (ninoUno < ninoDos) {
                while (temp.getSiguiente() != null && cont != ninoUno) {
                    cont++;
                    temp = temp.getSiguiente();
                }
                if (cont == ninoUno) {
                    temp.setDato(temporalDos);
                }
                cont = 1;
                temp = cabeza;
                while (temp.getSiguiente() != null && cont != ninoDos) {
                    cont++;
                    temp = temp.getSiguiente();
                }
                if (cont == ninoDos) {
                    temp.setDato(temporalUno);
                }
            } else if (ninoUno > ninoDos) {
                while (temp.getSiguiente() != null && cont != ninoDos) {
                    cont++;
                    temp = temp.getSiguiente();
                }
                if (cont == ninoDos) {
                    temp.setDato(temporalUno);
                }
                cont = 1;
                temp = cabeza;
                while (temp.getSiguiente() != null && cont != ninoUno) {
                    cont++;
                    temp = temp.getSiguiente();
                }
                if (cont == ninoUno) {
                    temp.setDato(temporalDos);
                }
            }
        }
    }
    
}
