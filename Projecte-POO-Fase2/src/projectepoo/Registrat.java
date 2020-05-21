/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package projectepoo;

/**
 *
 * @author Usuari
 */
public class Registrat extends Usuari{
    private java.lang.String nomUsuari;
    private java.lang.String password;
    public EntradesBlog blog;
    
    public Registrat(Controlador contr, java.lang.String nom, java.lang.String passwd){
        super(contr);
        this.nomUsuari = nom;
        this.password = passwd;
        this.menu = new MenuRegistrat(this.contr);
    }
    
    public void afageixEntrada(Entrada e){
        blog.afageixOrdenat(e);
    }
    
    public EntradesBlog getBlog(){
        return blog;
    }
    
    public boolean verificaPassword(java.lang.String pass){
        return (pass.equals(this.password));
    }
}
