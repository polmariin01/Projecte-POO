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

public abstract class Menu {
    protected Controlador controlador;

    public Menu(Controlador contr) {
        this.controlador = contr;
    }
    public void cicle(){
        java.lang.String opcio = "";
        do{
            try {
                this.mostraOpcions();
                opcio = this.demanaOpcio();
                if(opcio.isEmpty()){
                   IO.mostraError("Opcio incorrecta!\n");
                }else{
                   this.executaOpcio(opcio); 
                }
            } catch (BlogException be){
                IO.mostraError(be.getMessage());
            }
        } while (opcio.isEmpty() || !"FI".startsWith(opcio.toUpperCase()));
    }

    public java.lang.String demanaOpcio() {
        IO.mostrarText("\nIntrodueix una opció: ");
        return IO.llegeixText();
    }

    public abstract void executaOpcio(java.lang.String op) throws BlogException;

    public abstract void mostraOpcions();
}
