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

public class Visitant extends Usuari {

    public Visitant(Controlador contr) {
        super(contr);
        this.menu = new MenuVisitant(contr);
    }
}
