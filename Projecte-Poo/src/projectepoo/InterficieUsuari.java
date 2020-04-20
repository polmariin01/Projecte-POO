/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package projectepoo;

/**
 *
 * @author Usuari
 * Fa: Pol
 */
public class InterficieUsuari {
    
    Controlador controlador;
    IO io;
    
    public InterficieUsuari(){
        this.controlador = new Controlador();
    }
    
    public void cicle(){
        java.lang.String opcio;
        this.mostraOpcions();
        opcio = IO.llegeixText();
        this.executaOpcio(opcio);
    }
    
    public void executaOpcio(java.lang.String op){
        java.lang.String com[] = op.split("");
        com[0] = com[0].toUpperCase();
        
        switch(com[0]){
            case "INDEX":
            case "I":
                controlador.index();
                break;
            case "MOSTRA":
            case "M":
                controlador.mostraEntrada(Integer.valueOf(com[1]));
                break;
            case "NOVA":
            case "N":
                controlador.novaEntrada();
                break;
            case "ELIMINA":
            case "E":
                controlador.eliminaEntrada(Integer.valueOf(com[1]));
                break;
            case "ORDENA":
            case "O":
                controlador.ordena();
                break;
            case "DATES":
            case "D":
                controlador.dates();
                break;
            case "TOTES":
            case "T":
                controlador.mostraEntrades();
                break;
            case "FI":
            case "F":
                break;
            default:
                throw new Illegal­Argument­Exception("El text introduit no coincideix amb cap opcio");
        }
        
    }
    
    public static void main(java.lang.String[] args){
        InterficieUsuari interficie = new InterficieUsuari();
        while (1==1){
            interficie.cicle();
        }
    }
    
    public void mostraOpcions(){
        IO.mostrarText("\nOpcions: \n\n\tIndex\n\tMostra <num>\n\tNova\n\t"
                + "Elimina <num>\n\tOrdena\n\tDates <inici> <fi>\n\t"
                + "Totes\n\tFi\n\nIntrodueix una opció: ");
    }
}
