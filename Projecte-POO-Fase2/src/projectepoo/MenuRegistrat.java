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
public class MenuRegistrat extends Menu {

    public MenuRegistrat(Controlador contr) {
        super(contr);
    }

    @Override
    public void executaOpcio(String op) throws BlogException {
        java.lang.String com[] = op.split(" ");
        com[0] = com[0].toUpperCase();

        if ("INDEX".startsWith(com[0])) {
            controlador.index();
        } else if ("MOSTRAR".startsWith(com[0])) {
            if (com.length == 2 && Integer.valueOf(com[1]) >= 0) {
                IO.mostrarText("\n");
                controlador.mostraEntrada(Integer.valueOf(com[1]));
                IO.mostrarText("\n");
            } else {
                IO.mostrarText("Entrada incorrecte.\n");
            }

        } else if ("NOVA".startsWith(com[0])) {
            controlador.novaEntrada();

        } else if ("ELIMINA".startsWith(com[0])) {
            if (com.length == 2 && Integer.valueOf(com[1]) >= 0) {
                controlador.eliminaEntrada(Integer.valueOf(com[1]));
            } else {
                IO.mostrarText("Entrada incorrecte.\n");
            }

        } else if ("ORDENA".startsWith(com[0])) {
            controlador.ordena();

        } else if ("DATES".startsWith(com[0])) {
            controlador.dates();

        } else if ("TOTES".startsWith(com[0])) {
            controlador.mostraEntrades();

        } else if ("FI".startsWith(com[0])) {
            IO.mostrarText("sortir del menu registrat");
            throw new BlogException();

        } else {
            IO.mostrarText("El text introduit no coincideix amb cap opcio.\n");
        }
    }

    @Override
    public void mostraOpcions() {
        IO.mostrarText("\nOpcions: \n\n\tIndex\n\tMostra <num>\n\tNova\n\t"
                + "Elimina <num>\n\tOrdena\n\tDates\n\t"
                + "Totes\n\tFi");
    }

}
