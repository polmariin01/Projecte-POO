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
public class Mainproves {

    public static void main(String[] args) {
        Entrada e1 = new Entrada("Entrada 1", "Aquest es el text de la entrada 1", "2020-01-01 00:00:00");
        Entrada e2 = new Entrada("Titol entrada 2", "Aquest es el text de la entrada 2", "2022-02-12 12:02:12");
        Entrada e3 = new Entrada("Titol entrada 3", "Aquest es el text de la entrada 3", "2024-02-12 12:02:12");
        EntradesBlog Entrades = new EntradesBlog();
        Entrades.afageixOrdenat(e2);
        Entrades.afageixOrdenat(e3);
        Entrades.afageixOrdenat(e1);
        Temps inici = new Temps("2020-01-01 00:00:00");
        Temps fi = new Temps("2024-02-12 12:02:12");
        System.out.println(Entrades.entreDates(inici, fi));
        
        
    }

}
