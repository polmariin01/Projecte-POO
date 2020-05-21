/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package projectepoo;

import java.util.Scanner;

/**
 *
 * @author Usuari
 */
public abstract class Menu {
    protected Controlador controlador;

    public Menu(Controlador contr) {
        this.controlador = contr;
    }
    public void cicle () throws BlogException{
        String opcio;
        this.mostraOpcions();
        opcio = this.demanaOpcio();
        this.executaOpcio(opcio);
    }
    public java.lang.String demanaOpcio(){
        System.out.println("Introdueix una opció:");
        java.util.Scanner teclat = new Scanner(System.in);
        java.lang.String opcio = teclat.nextLine();
        return opcio;
    }
    public abstract void executaOpcio(java.lang.String op);
    public abstract void mostraOpcions();
}
