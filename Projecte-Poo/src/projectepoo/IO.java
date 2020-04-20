/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package projectepoo;

import java.util.Scanner;

/**
 *
 * @author Usuari
 * Fa: Gil
 */
public class IO {
    
    public static java.util.Scanner teclat = new Scanner(System.in);;
    
    public static java.lang.String llegeixText(){
        return teclat.nextLine();
    }
    
    public static void mostrarText(java.lang.String text){
        System.out.print(text);
    }
}
