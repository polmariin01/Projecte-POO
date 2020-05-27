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
public class MenuVisitant extends Menu {

    public MenuVisitant(Controlador contr) {
        super(contr);
    }

    @Override
    public void executaOpcio(java.lang.String op) throws BlogException {
        String[] parts = op.split(" ");
        java.lang.String com = parts[0].toUpperCase();
        if ("LLISTAUSUARIS".startsWith(com)) {
                controlador.mostraUsuaris();
            } else if ("MOSTRABLOG".startsWith(com) && parts.length >= 1) {
                try {
                    controlador.mostraBlog(parts[1]);
                } catch (BlogException be) {
                    throw be;
                }
            }
    }

    @Override
    public void mostraOpcions() {
        System.out.println("Opcions:\n\tllistaUsuaris\n\tmostraBlog nomUsuari\n\tfi");
    }

}
