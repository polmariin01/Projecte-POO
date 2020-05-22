/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package projectepoo;

/**
 *
 * @authors Gil Boleda Feliu i Pol Marín Gargallo
 */

public class InterficieUsuari {
    public Controlador controlador;
    private Menu menu;

    public InterficieUsuari() {
        this.controlador = new Controlador();
        this.menu = new MenuPrincipal(this.controlador);
    }

    public void cicle() throws BlogException {
       this.menu.cicle();
    }

    public static void main(java.lang.String[] args) throws BlogException {
        InterficieUsuari interficie = new InterficieUsuari();
        IO.mostrarText("Hola!\n");
        while (true) {
            interficie.menu.cicle();
        }
    }
}