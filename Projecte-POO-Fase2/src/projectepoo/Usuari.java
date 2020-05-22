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

public abstract class Usuari {
    protected Controlador contr;
    protected Menu menu;

    public Usuari(Controlador contr) {
        this.contr = contr;
        this.menu = null;
    }

    public Menu getMenu() {
        return this.menu;
    }
}
