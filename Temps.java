/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package projectepoo;

import java.time.LocalDateTime;

/**
 *
 * @author gilbo
 */
public class Temps {
    String dia;
    String hora;
    public Temps(){
        this.dia = "";
        this.hora = "";
    }
    public Temps(java.lang.String temps){
        String [] diaihora = temps.split(" ");
        this.dia = diaihora[0];
        this.hora = diaihora[1];
    }
    public void ara(){
        this.dia = LocalDateTime.now().toString();
    }
    public int comparaDia(Temps altre){
        return (-1)*altre.dia.compareTo(this.dia);
    }
    public int comparaTemps(Temps altre){
        if(this.comparaDia(altre)!=0){
            return this.comparaDia(altre);
        }else {
            return this.hora.compareTo(altre.hora);
        }
    }
    public java.lang.String toString(){
        return this.dia + " " + this.hora;
    }
    
}
