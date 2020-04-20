/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package projectepoo;

import java.util.Scanner;

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
        this.io = new IO();
    }
    
    public void cicle(){
        java.lang.String opcio;
        Scanner lector = new Scanner(System.in);
        this.mostraOpcions();
        opcio = lector.nextLine();
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
                throw Illegal­Argument­Exception("");
        }
        
    }
    
    public static void main(java.lang.String[] args){
        InterficieUsuari interficie = new InterficieUsuari();
        interficie.cicle();
    }
    
    public void mostraOpcions(){
        System.out.println("Opcions:");
        System.out.println();
        System.out.println("    Index");
        System.out.println("    Mostra <num>");
        System.out.println("    Nova");        
        System.out.println("    Elimina <num>");
        System.out.println("    Ordena");
        System.out.println("    Dates <inici> <fi>");
        System.out.println("    Totes");
        System.out.println("    Fi");
        System.out.println();
        System.out.println("Introdueix una opció: ");
    }
}
