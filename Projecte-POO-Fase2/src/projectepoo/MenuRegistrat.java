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
        Registrat regis = (Registrat) this.controlador.usuariActual;
                
        if ("INDEX".startsWith(com[0])) {
            this.controlador.index();
        } else if ("MOSTRAR".startsWith(com[0])) {
            if (com.length == 2 && Integer.valueOf(com[1]) >= 0) {
                IO.mostrarText("\n");
                //controlador.usuariActual.contr.mostraEntrada(Integer.valueOf(com[1]));
                this.controlador.mostraEntrada(Integer.valueOf(com[1]));
                IO.mostrarText("\n");
            } else {
                IO.mostrarText("Entrada incorrecte.\n");
            }

        } else if ("NOVA".startsWith(com[0])) {
//            controlador.usuariActual.contr.novaEntrada();
            this.controlador.novaEntrada();

        } else if ("ELIMINA".startsWith(com[0])) {
            if (com.length == 2 && Integer.valueOf(com[1]) >= 0) {
//                controlador.usuariActual.contr.eliminaEntrada(Integer.valueOf(com[1]));
                this.controlador.eliminaEntrada(Integer.valueOf(com[1]));
            } else {
                IO.mostrarText("Entrada incorrecte.\n");
            }

        } else if ("ORDENA".startsWith(com[0])) {
//            controlador.usuariActual.contr.ordena();
            this.controlador.ordena();

        } else if ("DATES".startsWith(com[0])) {
//            controlador.usuariActual.contr.dates();
            this.controlador.dates();

        } else if ("TOTES".startsWith(com[0])) {
//            controlador.usuariActual.contr.mostraEntrades();
            this.controlador.mostraEntrades();

        } else {
            throw new BlogException("Opció incorrecta");
        }
    }

    @Override
    public void mostraOpcions() {
        IO.mostrarText("\nOpcions: \n\n\tIndex\n\tMostra <num>\n\tNova\n\t"
                + "Elimina <num>\n\tOrdena\n\tDates\n\t"
                + "Totes\n\tFi\n");
    }

}
