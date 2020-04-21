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

    IO io;
    EntradesBlog entradesBlog;

    public Controlador() {
        this.entradesBlog = new EntradesBlog();
    }

    public void dates() {
        //estic fent, no tocar

        java.lang.String data1, data2, anyi, anyf, mesi, mesf, diai, diaf;
        java.lang.String[] datai, dataf;
        /*
        IO.mostrarText("Dia inicial? (aaaa-mm-dd) ");
        data1 = IO.llegeixText();
        datai = data1.split("-");
        anyi= datai[0];
        mesi = datai[2];
        diai = datai[3];
        IO.mostrarText("Dia final? (aaaa-mm-dd) ");
        data2 = IO.llegeixText();
        dataf = data2.split("");
        anyi= dataf[0];
        mesi = dataf[2];
        diai = dataf[3];
        
        for (int i=0; i<this.entradesBlog.Entrades.size(); i++){
            if()
        }
         */
        IO.mostrarText("Dia inicial? (aaaa-mm-dd) ");
        data1 = IO.llegeixText();
        IO.mostrarText("Dia final? (aaaa-mm-dd) ");
        data2 = IO.llegeixText();

        for (int i = 0; i < this.entradesBlog.Entrades.size(); i++) {
            if (data1.compareTo(this.entradesBlog.Entrades.get(i).temps.toString())<0 &&
                    + (data2.compareTo(this.entradesBlog.Entrades.get(i).temps.toString()))> 0) {
                IO.mostrarText(this.entradesBlog.Entrades.get(i).toString() + "\n");
            }
        }
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
        } else if(a == 3){
            d = d + " 00:00:00";
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
        java.lang.String[] time;
        if (s.isBlank()) {
            return 0;
        }
        java.lang.String[] data = s.split(" ");
        if (data.length < 2) {
            if (data.length == 1) {
                time = data[0].split(":");
                if (time.length == 3) {
                    if (Integer.valueOf(time[0]) < 0 || Integer.valueOf(time[1]) < 0 || Integer.valueOf(time[2]) < 0) {
                        return -1;
                    } else if (Integer.valueOf(time[0]) >= 24 || Integer.valueOf(time[1]) >= 60 || Integer.valueOf(time[2]) >= 60) {
                        return -1;
                    } else {
                        return 1;
                    }
                } else {
                    time = data[0].split("-");
                    if (time.length == 3) {
                        if (Integer.valueOf(time[0]) < 0 || Integer.valueOf(time[1]) < 0 || Integer.valueOf(time[2]) < 0) {
                            return -1;
                        } else if (Integer.valueOf(time[1]) > 12 || Integer.valueOf(time[2]) > 31) {
                            return -1;
                        } else {
                            return 3;
                        }
                    }
                return -1;
                }
            }
        }
        java.lang.String[] day = data[0].split("-");
        time = data[1].split(":");
        if (day.length < 3 || time.length < 3) {
            return -1;
        }

        int any = Integer.valueOf(day[0]), mes = Integer.valueOf(day[1]), dia = Integer.valueOf(day[2]);
        int hora = Integer.valueOf(time[0]), min = Integer.valueOf(time[1]), seg = Integer.valueOf(time[2]);

        if (any < 0 || mes < 0 || dia < 0 || hora < 0 || min < 0 || seg < 0) {
            return -1;
        }

        if (any > 2020 || mes > 12 || dia > 31 || hora > 24 || min > 60 || seg > 60) {
            return -1;
        }

        return 2;
    }

}
