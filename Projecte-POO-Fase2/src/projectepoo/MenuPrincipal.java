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
        op = op.toUpperCase();
        

        if("VISITANT".startsWith(op)){
            controlador.visitant();
        } else if("INICIA SESSIO".startsWith(op)){
            try{
                controlador.sessio();
            }catch(BlogException exception){
                IO.mostrarText(exception.getMessage());
            }
        } else if("REGISTRA'T".startsWith(op)){
            try{
                controlador.registre();
            }catch(BlogException exception){
                //IO.mostrarText("Notify: ");
                //exception.notify();
                //IO.mostrarText("getMessage: ");
                //IO.mostrarText(exception.getMessage());
                //IO.mostrarText("PrintStackTrace: ");
                exception.toString();
            }
        } else if("FI".startsWith(op)){
            IO.mostrarText("Adiós!");
            System.exit(0);
        } 
    }

    @Override
    public void mostraOpcions() {
        System.out.println("\nOpcions:\n\tvisitant\n\tinicia sessio\n\tregistra't\n\tfi");
    }
    
}
