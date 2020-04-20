/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package projectepoo;

/**
 *
 * @author Usuari
 * Fa: Pol
 */
public class Controlador {
    
    IO io;
    EntradesBlog entradesBlog;
    
    public Controlador(){
        this.entradesBlog = new EntradesBlog();
    }
        
    public void dates(){
        
    }
    
    public void eliminaEntrada(int num){
        this.mostraEntrada(num);
        this.entradesBlog.elimina(num);
    }
    
    public void index(){
        IO.mostrarText("Index {\n " + entradesBlog.index() + "\n} \n");
    }
    
    public void mostraEntrada(int num){
        Entrada e = this.entradesBlog.agafa(num);
        IO.mostrarText(e.toString());
    }
    
    public void mostraEntrades(){
        
        for (int i = 0; i<this.entradesBlog.Entrades.size();i++){
            this.mostraEntrada(i);
        }
    }
    
    public void novaEntrada(){
        Entrada e;
        IO.mostrarText("Titol? ");
        String t = IO.llegeixText();
        IO.mostrarText("Text? ");       
        String ttx = IO.llegeixText();
        String d;
        do{
            IO.mostrarText("Dia i hora? ");
            d = IO.llegeixText();        //Falta posar 'ARA' i control d'errors en el format de la data
            if (!this.comprobarFormatData(d)){
                if (d.equalsIgnoreCase("ara")){
                    d=" ";
                } else {
                    IO.mostrarText("\nFormat de la data incorrecte.\n");
                }
            }
        } while (!this.comprobarFormatData(d) && !d.equals(" "));
        
        e = new Entrada(t,ttx,d);
        this.entradesBlog.afageixOrdenat(e);
    }
    
    public void ordena(){
        this.entradesBlog.ordena();
    }

    private boolean comprobarFormatData(java.lang.String s){
        java.lang.String[] data = s.split(" ");
        if (data.length < 2){
            return false;
        }
        java.lang.String[] day = data[0].split("-"), hour = data[1].split(":");
        if (day.length < 3 || hour. length<3){
            return false;
        }
        
        int any = Integer.valueOf(day[0]), mes = Integer.valueOf(day[1]), dia = Integer.valueOf(day[2]);
        int hora = Integer.valueOf(hour[0]), min = Integer.valueOf(hour[1]), seg = Integer.valueOf(hour[2]);
        
        if (any<0 || mes<0 || dia<0 || hora<0 || min<0 || seg<0 ){
            return false;
        }
        
        if (any>2020 || mes>12 || dia>31 || hora>24 || min>60 || seg>60 ){
            return false;
        }
        
        return true;
    }
}
