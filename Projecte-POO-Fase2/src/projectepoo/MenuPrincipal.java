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
public class MenuPrincipal extends Menu {

    public MenuPrincipal(Controlador contr) {
        super(contr);
    }

    @Override
    public void executaOpcio(String op) throws BlogException{
        op = op.toUpperCase();

        try {
            if ("VISITANT".startsWith(op)) {
                controlador.visitant();
            } else if ("INICIA SESSIO".startsWith(op)) {
                controlador.sessio();
            } else if ("REGISTRA'T".startsWith(op)) {
                controlador.registre();
            } else if ("FI".startsWith(op)) {
                IO.mostrarText("Adiós!");
                System.exit(0);
            } else {
                throw new BlogException("Opció incorrecta!");
            }
        } catch (BlogException be){
            throw be;
        }
    }

    @Override
    public void mostraOpcions() {
        System.out.println("\nOpcions:\n\tvisitant\n\tinicia sessio\n\tregistra't\n\tfi");
    }

}
