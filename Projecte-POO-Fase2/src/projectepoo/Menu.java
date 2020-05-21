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

    public void cicle() throws BlogException {
        String opcio;
        this.mostraOpcions();
        opcio = this.demanaOpcio();
        this.executaOpcio(opcio);
    }

    public java.lang.String demanaOpcio() {
        IO.mostrarText("\nIntrodueix una opció: ");
        return IO.llegeixText();
    }

    public abstract void executaOpcio(java.lang.String op) throws BlogException;

    public abstract void mostraOpcions();
}
