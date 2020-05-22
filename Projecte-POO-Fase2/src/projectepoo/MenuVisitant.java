/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package projectepoo;

/**
 *
 * @author gilbo
 */
public class MenuVisitant extends Menu{

    public MenuVisitant(Controlador contr) {
        super(contr);
    }

    @Override
    public void executaOpcio(java.lang.String op) throws BlogException {
        java.lang.String com = op.toUpperCase();
        String[] parts = com.split(" ");
        

        if("LLISTAUSUARIS".startsWith(parts[0])){
            controlador.mostraUsuaris();
        } else if("MOSTRABLOG".startsWith(parts[0])){
            controlador.mostraBlog(parts[1]);
        }else if("FI".startsWith(com)){
            throw new BlogException();   //no ting clar que estigui be
        }
    }

    @Override
    public void mostraOpcions() {
        System.out.println("Opcions:\n\tllistaUsuaris\n\tmostraBlog nomUsuari\n\tfi\nIntrodueix una opcio:");
    }
    
}
