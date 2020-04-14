/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package projectepoo;

/**
 *
 * @author gilbo
 */
public class Entrada {

    java.lang.String titol;
    java.lang.String text;
    Temps temps;
    int nEntrades = 0;
    int id;

    public Entrada(java.lang.String titol, java.lang.String text, java.lang.String temps) {
        this.titol = titol;
        this.text = text;
        this.temps = new Temps();
        if (temps.equals("")) {
            this.temps.ara();
        } else {
            String[] datahora = temps.split(" ");
            this.temps.dia = datahora[0];
            this.temps.hora = datahora[1];
        }
        
        this.id = nEntrades;
        nEntrades++;
    }

    public int getId() {
        return this.id;
    }

    public java.lang.String getTitol() {
        return this.titol;
    }

    public Temps getQuan() {
        return this.temps;
    }

    public static int compare(Entrada una, Entrada altra, java.lang.String criteri) {
        switch (criteri) {
            case "num":
                if (una.id > altra.id) {
                    return -1;
                }
                if (una.id < altra.id) {
                    return 1;
                } else {
                    return 0;
                }
                //repassar la part de criteri num pq esta fet amb pala
            case "titol":
                return una.titol.compareTo(altra.titol);
            default:
                return 0;
        }
    }

    @Override
    public java.lang.String toString() {
        return this.id + " " + this.titol + " " + this.text + " " + this.temps.toString();
    }

}
