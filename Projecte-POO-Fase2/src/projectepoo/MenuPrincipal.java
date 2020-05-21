/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package projectepoo;

/**
 *
 * @author Usuari
 */
public class MenuPrincipal extends Menu{

    public MenuPrincipal(Controlador contr) {
        super(contr);
    }
    @Override
    public void executaOpcio(String op) {
        
    }

    @Override
    public void mostraOpcions() {
        System.out.println("Opcions:\n\tvisitant\n\tinicia sessio\n\tregistra't\n\tfi\nIntrodueix una opció: ");
    }
    
}
