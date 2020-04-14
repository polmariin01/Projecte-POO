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
   
    
    public static void main (String[] args){
        Entrada e1 = new Entrada("Entrada 1","Aquest es el text de la entrada 1","2020-01-01 00:00:00");
        Entrada e2 = new Entrada("Titol entrada 2","Aquest es el text de la entrada 2","2022-02-12 12:02:12");
        Entrada e3 = new Entrada("Titol entrada 3","Aquest es el text de la entrada 3","2024-02-12 12:02:12");
        EntradesBlog Entrades = new EntradesBlog();
        Entrades.afageixOrdenat(e2);
        Entrades.afageixOrdenat(e3);
        Entrades.afageixOrdenat(e1);
        System.out.println(Entrades.index());
       
        System.out.println(Entrades.toString());
        //java.lang.String a = Entrades.entreDates(inici,fi);
        
        
        
        
        /*System.out.println("Id: "+e1.getId());
        System.out.println("Titol: "+e1.getTitol());
        System.out.println("Temps: "+e1.getQuan());
        System.out.println();
        System.out.println("Id: "+e2.getId());
        System.out.println("Titol: "+e2.getTitol());
        System.out.println("Temps: "+e2.getQuan());
        int a = Entrada.compare(e1,e2,"num");
        int b = Entrada.compare(e1,e2,"titol");
        int c = Entrada.compare(e1,e2,"vaina");
        System.out.println(a+"  "+b+"  "+c);*/
        
    }
    
}
