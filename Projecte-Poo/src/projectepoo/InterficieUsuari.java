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
public class InterficieUsuari {

    public Controlador controlador;

    public InterficieUsuari() {
        this.controlador = new Controlador();
    }

    public void cicle() {
        java.lang.String opcio;
        this.mostraOpcions();
        opcio = IO.llegeixText();
        this.executaOpcio(opcio);
    }

    public void executaOpcio(java.lang.String op) {
        java.lang.String com[] = op.split(" ");
        com[0] = com[0].toUpperCase();

        switch (com[0]) {
            case "INDEX":
            case "INDE":
            case "IND":
            case "IN":
            case "I":
                controlador.index();
                break;

            case "MOSTRA":
            case "MOSTR":
            case "MOST":
            case "MOS":
            case "MO":
            case "M":
                if (com.length == 2 && Integer.valueOf(com[1]) >= 0) {
                    IO.mostrarText("\n");
                    controlador.mostraEntrada(Integer.valueOf(com[1]));
                    IO.mostrarText("\n");
                } else {
                    IO.mostrarText("Entrada incorrecte.\n");
                }
                break;
            case "NOVA":
            case "NOV":
            case "NO":
            case "N":
                controlador.novaEntrada();
                break;
            case "ELIMINA":
            case "ELIMIN":
            case "ELIMI":
            case "ELIM":
            case "ELI":
            case "EL":
            case "E":
                if (com.length == 2 && Integer.valueOf(com[1]) >= 0) {
                    controlador.eliminaEntrada(Integer.valueOf(com[1]));
                } else {
                    IO.mostrarText("Entrada incorrecte.\n");
                }
                break;
            case "ORDENA":
            case "ORDEN":
            case "ORDE":
            case "ORD":
            case "OR":
            case "O":
                controlador.ordena();
                break;
            case "DATES":
            case "DATE":
            case "DAT":
            case "DA":
            case "D":
                controlador.dates();
                break;
            case "TOTES":
            case "TOTE":
            case "TOT":
            case "TO":
            case "T":
                controlador.mostraEntrades();
                break;
            case "FI":
            case "F":
                IO.mostrarText("Adiós!");
                System.exit(0);
                break;
            default:
                IO.mostrarText("El text introduit no coincideix amb cap opcio.\n");
        }

    }

    public static void main(java.lang.String[] args) {
        InterficieUsuari interficie = new InterficieUsuari();
        IO.mostrarText("Hola!\n");
        while (1==1) {
            interficie.cicle();
        }
    }

    public void mostraOpcions() {
        IO.mostrarText("\nOpcions: \n\n\tIndex\n\tMostra <num>\n\tNova\n\t"
                + "Elimina <num>\n\tOrdena\n\tDates\n\t"
                + "Totes\n\tFi\n\nIntrodueix una opció: ");
    }
}
