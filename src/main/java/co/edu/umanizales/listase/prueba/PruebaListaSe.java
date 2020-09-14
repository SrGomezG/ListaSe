/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package co.edu.umanizales.listase.prueba;

import co.edu.umanizales.listase.modelo.ListaSe;
import co.edu.umanizales.listase.modelo.Perro;
import java.util.List;

/**
 *
 * @author tsuyo
 */
public class PruebaListaSe {
    public static void main(String... args)
    {
        ListaSe listaPerros= new ListaSe();
        Perro lulu = new Perro("Lulú", (byte) 1, (byte) 9);
        listaPerros.adicionarNodo(lulu);
        
        Perro firulais = new Perro("Firulais", (byte) 2, (byte) 4);
        listaPerros.adicionarNodo(firulais);
        
        Perro pastor = new Perro("Tobby", (byte) 3, (byte) 6);
        listaPerros.adicionarNodo(pastor);
        
        System.out.println("Finalizado");
    }
}
