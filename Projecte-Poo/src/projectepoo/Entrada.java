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

    private final java.lang.String titol;
    private final java.lang.String text;
    private final Temps temps;
    private static int nEntrades = 0;
    private final int id;

    public Entrada(java.lang.String titol, java.lang.String text, java.lang.String temps) {
        this.titol = titol;
        this.text = text;
        if (temps.isBlank()) {
            this.temps = new Temps();
            this.temps.ara();
        } else {
            this.temps = new Temps(temps);
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
                return Integer.compare(una.id, altra.id);
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
