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
        IO.mostrarText("Dia i hora? ");        
        String d = IO.llegeixText();        //Falta posar 'ARA' i control d'errors en el format de la data
        
        e = new Entrada(t,ttx,d);
        this.entradesBlog.afageixOrdenat(e);
    }
    
    public void ordena(){
        this.entradesBlog.ordena();
    }
}
