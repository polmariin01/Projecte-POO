/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package projectepoo;

import java.util.HashSet;
import java.util.Set;

/**
 *
 * @author Usuari Fa: Pol
 */
public class Controlador {

    IO io;
    EntradesBlog entradesBlog;

    public Controlador() {
        this.entradesBlog = new EntradesBlog();
    }

    public void dates() {
        //estic fent, no tocar
    }

    public void eliminaEntrada(int num) {

        if (this.entradesBlog.Entrades.isEmpty()) {
            IO.mostrarText("Llista buida.\n");
        } else if (num >= this.entradesBlog.Entrades.size() || num < 0) {
            IO.mostrarText("Entrada no vàlida.\n");
        } else {
            Entrada e = this.entradesBlog.elimina(num);
            IO.mostrarText(e.toString());
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
        String d;
        int a;
        do {
            IO.mostrarText("Dia i hora? (aaaa-mm-dd< hh:mm:ss>, Return=Ara) ");
            d = IO.llegeixText();
            a = this.comprobarFormatData(d);
            if (a < 0) {
                IO.mostrarText("\nFormat de la data incorrecte.\n");
            }
        } while (a < 0);

        if (a == 1) {
            Temps temps = new Temps();
            temps.ara();
            d = temps.dia + " " + a;
        }

        e = new Entrada(t, ttx, d);
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

    private int comprobarFormatData(java.lang.String s) {
        java.lang.String[] hour;
        if (s.isBlank()) {
            return 0;
        }
        java.lang.String[] data = s.split(" ");
        if (data.length < 2) {
            if (data.length == 1) {
                hour = data[0].split(":");
                if (hour.length != 3) {
                    return -1;
                } else {
                    if (Integer.valueOf(hour[0]) < 0 || Integer.valueOf(hour[1]) < 0 || Integer.valueOf(hour[2]) < 0) {
                        return -1;
                    } else if (Integer.valueOf(hour[0]) >= 24 || Integer.valueOf(hour[1]) >= 60 || Integer.valueOf(hour[2]) >= 60) {
                        return -1;
                    } else {
                        return 1;
                    }
                }
            }
        }
        java.lang.String[] day = data[0].split("-");
        hour = data[1].split(":");
        if (day.length < 3 || hour.length < 3) {
            return -1;
        }

        int any = Integer.valueOf(day[0]), mes = Integer.valueOf(day[1]), dia = Integer.valueOf(day[2]);
        int hora = Integer.valueOf(hour[0]), min = Integer.valueOf(hour[1]), seg = Integer.valueOf(hour[2]);

        if (any < 0 || mes < 0 || dia < 0 || hora < 0 || min < 0 || seg < 0) {
            return -1;
        }

        if (any > 2020 || mes > 12 || dia > 31 || hora > 24 || min > 60 || seg > 60) {
            return -1;
        }

        return 2;
    }

}
