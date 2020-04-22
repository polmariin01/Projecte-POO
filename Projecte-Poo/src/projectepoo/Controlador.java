/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package projectepoo;

/**
 *
 * @author Usuari Fa: Pol
 */
public class Controlador {

    public IO io;
    public EntradesBlog entradesBlog;

    public Controlador() {
        this.entradesBlog = new EntradesBlog();
    }

    public void dates() {
        java.lang.String data;
        java.lang.String[] actual = {"inicial", "final","00:00:00","23:59:59"}, dia;
        Temps[] t = {null,null};
        boolean be;
        for (int i = 0; i < 2; i++) {
            be = false;
            do {
                IO.mostrarText("Dia " + actual[i] + "? (aaaa-mm-dd) ");
                data = IO.llegeixText();
                dia = data.split("-");
                if (dia.length == 3) {
                    if (Integer.valueOf(dia[1]) > 0 && Integer.valueOf(dia[2]) > 0 && Integer.valueOf(dia[1]) <= 12 && Integer.valueOf(dia[2]) <= 31) {
                        t[i] = new Temps (data + actual[2+i]);
                        be = true;
                    }
                }
                if(!be){
                    IO.mostrarText("Entrada incorrecte.\n");
                }
            } while (!be);
        }
        IO.mostrarText(t[0].toString() + "\n" + t[1].toString());
        IO.mostrarText(this.entradesBlog.entreDates(t[0], t[1]));
    }

    public void eliminaEntrada(int num) {

        if (this.entradesBlog.Entrades.isEmpty()) {
            IO.mostrarText("Llista buida.\n");
        } else if (num < 0) {
            IO.mostrarText("Entrada no vàlida.\n");
        } else {
            Entrada e = this.entradesBlog.elimina(num);
            IO.mostrarText("Elimino " + e.toString());
        }
    }

    public void index() {
        IO.mostrarText("\nIndex {\n" + entradesBlog.index() + "}\n");
    }

    public void mostraEntrada(int num) {

        if (this.entradesBlog.Entrades.isEmpty()) {
            IO.mostrarText("Llista buida.\n");
        } else if (num >= this.entradesBlog.Entrades.size() || num < 0) {
            IO.mostrarText("Entrada no vàlida.\n");
        } else {
            Entrada e = this.entradesBlog.agafa(num);
            IO.mostrarText(e.toString());
        }
    }

    public void mostraEntrades() {
        for (int i = 0; i < this.entradesBlog.Entrades.size(); i++) {
            this.mostraEntrada(i);
            IO.mostrarText("\n");
        }
    }

    public void novaEntrada() {
        Entrada e;
        IO.mostrarText("Titol? ");
        String t = IO.llegeixText();
        IO.mostrarText("Text? ");
        String ttx = IO.llegeixText();
        String d, dia, hora;
        String[] text, dies, hores;
        int a = 0;

        do {
            IO.mostrarText("Dia i hora? (aaaa-mm-dd< hh:mm:ss>, Return=Ara) ");
            d = IO.llegeixText();

            Temps temps = new Temps();
            temps.ara();
            dia = temps.dia;
            hora = temps.hora;

            if (d.isBlank()) {
                a = 1;
            } else {
                text = d.split(" ");
                switch (text.length) {
                    case 2:
                        dies = text[0].split("-");
                        if (dies.length == 3) {
                            if (Integer.valueOf(dies[0]) > 0 && Integer.valueOf(dies[1]) > 0 && Integer.valueOf(dies[2]) > 0 && Integer.valueOf(dies[1]) <= 12 && Integer.valueOf(dies[2]) <= 31) {
                                dia = dies[0] + "-" + dies[1] + "-" + dies[2];
                            } else {
                                break;
                            }
                        } else {
                            break;
                        }
                        text[0] = text[1];
                    case 1:
                        hores = text[0].split(":");
                        if (hores.length == 3) {
                            if (Integer.valueOf(hores[0]) >= 0 && Integer.valueOf(hores[1]) >= 0 && Integer.valueOf(hores[2]) >= 0 && Integer.valueOf(hores[0]) < 24 && Integer.valueOf(hores[1]) < 60 && Integer.valueOf(hores[2]) < 60) {
                                hora = hores[0] + "-" + hores[1] + "-" + hores[2];
                                a = 1;
                            }
                        }
                        break;
                }
            }
            if (a == 0) {
                IO.mostrarText("Format de la data incorrecte.\n");
            }
        } while (a == 0);

        e = new Entrada(t, ttx, dia + " " + hora);
        this.entradesBlog.afageixOrdenat(e);
    }

    public void ordena() {
        java.lang.String criteri;
        do {
            IO.mostrarText("Criteri? (num/titol) ");
            criteri = IO.llegeixText();
            if (!criteri.equalsIgnoreCase("num") && !criteri.equalsIgnoreCase("titol")) {
                IO.mostrarText("Criteri incorrecte.");
            }
        } while (!criteri.equalsIgnoreCase("num") && !criteri.equalsIgnoreCase("titol"));

        this.entradesBlog.setCriteri(criteri.toLowerCase());
        this.entradesBlog.ordena();
    }
}
