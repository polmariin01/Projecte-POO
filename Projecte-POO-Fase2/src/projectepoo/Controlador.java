/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package projectepoo;

import java.util.HashMap;
import java.util.Map;

/**
 *
 * @authors Gil Boleda Feliu i Pol Marín Gargallo
 */

public class Controlador {

    public EntradesBlog entradesBlog;
    public Map<String,Registrat> registrats;
    public Usuari usuariActual;

    public Controlador() {
        this.entradesBlog = new EntradesBlog();
        registrats = new HashMap<>();
    }

    public void dates() {
        java.lang.String data;
        java.lang.String[] actual = {"inicial", "final"}, dia;
        Temps[] t = {null,null};
        Registrat usuari = (Registrat) this.usuariActual;
        boolean formatcorrecte, be;
        for (int i = 0; i < 2; i++) {
            be = false;
            do {
                IO.mostrarText("Dia " + actual[i] + "? (aaaa-mm-dd) ");
                data = IO.llegeixText();

                dia = data.split("-");                
                if (dia.length == 3) {
                    try{
                        Integer.parseInt(dia[0]);
                        Integer.parseInt(dia[1]);
                        Integer.parseInt(dia[2]);
                        formatcorrecte = true;
                    } catch (NumberFormatException nfe){
                        formatcorrecte = false;
                    }
                    if (formatcorrecte && Integer.parseInt(dia[1]) > 0 && Integer.parseInt(dia[2]) > 0 && Integer.parseInt(dia[1]) <= 12 && Integer.parseInt(dia[2]) <= 31) {    
                            data = (String.format("%04d",Integer.valueOf(dia[0])) + "-" +  String.format("%02d",Integer.valueOf(dia[1])) + "-" + String.format("%02d",Integer.valueOf(dia[2])));
                            t[i] = new Temps (data + " 00:00:00");
                             be = true;
                        }                
                }
                if(!be){
                    IO.mostrarText("Entrada incorrecte.\n");
                }
            } while (!be);
        }
        IO.mostrarText(t[0].toString() + "\n" + t[1].toString() + "\n");
        IO.mostrarText(usuari.blog.entreDates(t[0], t[1]));
    }

    public void eliminaEntrada(int num) {
        Registrat usuari = (Registrat) this.usuariActual;
        if (usuari.blog.Entrades.isEmpty()) {
            IO.mostrarText("Llista buida.\n");
        } else if (num < 0) {
            IO.mostrarText("Entrada no vàlida.\n");
        }
        
        Entrada e = usuari.blog.elimina(num);
        this.entradesBlog.elimina(num);

        if (e==null) {
            IO.mostrarText("No hi ha cap element amb aquesta id.\n");
        } else {
            IO.mostrarText("Elimino " + e.toString() + "\n");
        }
    }

    public void index() {
        Registrat usuari = (Registrat) this.usuariActual;
        IO.mostrarText("\nIndex {\n" + usuari.blog.index() + "}\n");
    }

    public void mostraEntrada(int num) {
        Registrat usuari = (Registrat) this.usuariActual;
        if (usuari.blog.Entrades.isEmpty()) {
            IO.mostrarText("Llista buida.\n");
        } else if (num >= usuari.blog.Entrades.size() || num < 0) {
            IO.mostrarText("Entrada no vàlida.\n");
        } else {
            Entrada e = usuari.blog.agafa(num);
            IO.mostrarText(e.toString());
        }
    }

    public void mostraEntrades() {
        Registrat usuari = (Registrat) this.usuariActual;
        for (int i = 0; i < usuari.blog.Entrades.size(); i++) {
            this.mostraEntrada(i);
            IO.mostrarText("\n");
        }
    }

    public void novaEntrada() {
        Entrada e;
        Registrat usuari = (Registrat) this.usuariActual;        
        IO.mostrarText("Titol? ");
        String t = IO.llegeixText();
        IO.mostrarText("Text? ");
        String ttx = IO.llegeixText();
        String d, dia, hora;
        String[] text, dies, time;
        int a = 0;

        do {
            IO.mostrarText("Dia i hora? (aaaa-mm-dd< hh:mm:ss>, Return=Ara) ");
            d = IO.llegeixText();

            Temps temps = new Temps();
            temps.ara();
            dia = temps.toString().split(" ")[0];
            hora = temps.toString().split(" ")[1];
            boolean format;

            if (d.isBlank()) {
                a = 1;
            } else {
                text = d.split(" ");
                switch (text.length) {
                    case 2:
                        dies = text[0].split("-");
                        if (dies.length == 3) {
                            try{
                                Integer.parseInt(dies[0]);
                                Integer.parseInt(dies[1]);
                                Integer.parseInt(dies[2]);
                                format = true;
                            } catch (NumberFormatException nfe){
                                format = false;
                            }
                            if (format && Integer.valueOf(dies[0]) > 0 && Integer.valueOf(dies[1]) > 0 && Integer.valueOf(dies[2]) > 0 && Integer.valueOf(dies[1]) <= 12 && Integer.valueOf(dies[2]) <= 31) {
                                dia = (String.format("%04d",Integer.valueOf(dies[0])) + "-" +  String.format("%02d",Integer.valueOf(dies[1])) + "-" + String.format("%02d",Integer.valueOf(dies[2])));
                            } else {
                                break;
                            }
                        } else {
                            break;
                        }
                        text[0] = text[1];
                    case 1:
                        time = text[0].split(":");
                        if (time.length == 3) {
                            try{
                                Integer.parseInt(time[0]);
                                Integer.parseInt(time[1]);
                                Integer.parseInt(time[2]);
                                format = true;
                            } catch (NumberFormatException nfe){
                                format = false;
                            }
                            if (format && Integer.valueOf(time[0]) >= 0 && Integer.valueOf(time[1]) >= 0 && Integer.valueOf(time[2]) >= 0 && Integer.valueOf(time[0]) < 24 && Integer.valueOf(time[1]) < 60 && Integer.valueOf(time[2]) < 60) {
                                hora = (String.format("%02d",Integer.valueOf(time[0])) + ":" +  String.format("%02d",Integer.valueOf(time[1])) + ":" + String.format("%02d",Integer.valueOf(time[2])));
                                a = 1;
                            }
                        } else if (time.length==1){
                            time = text[0].split("-");
                            if (time.length == 3){
                                try{
                                    Integer.parseInt(time[0]);
                                    Integer.parseInt(time[1]);
                                    Integer.parseInt(time[2]);
                                    format = true;
                                } catch (NumberFormatException nfe){
                                    format = false;
                                }
                                if (format && Integer.valueOf(time[0]) >= 0 && Integer.valueOf(time[1]) >= 0 && Integer.valueOf(time[2]) >= 0 && Integer.valueOf(time[1]) <= 12 && Integer.valueOf(time[2]) <= 31) {
                                    dia = (String.format("%04d",Integer.valueOf(time[0])) + ":" +  String.format("%02d",Integer.valueOf(time[1])) + ":" + String.format("%02d",Integer.valueOf(time[2])));
                                    a = 1;
                                }
                            }
                        }
                    break;
                }
            }
            if (a == 0) {
                IO.mostrarText("Format de la data incorrecte.\n");
            }
        } while (a == 0);

        e = new Entrada(t, ttx, dia + " " + hora);
        this.entradesBlog.afageixOrdenat(e);
        usuari.blog.afageixOrdenat(e);
    }

    public void ordena() {
        Registrat usuari = (Registrat) this.usuariActual;
        java.lang.String criteri;
        do {
            IO.mostrarText("Criteri? (num/titol) ");
            criteri = IO.llegeixText();
            if (!criteri.equalsIgnoreCase("num") && !criteri.equalsIgnoreCase("titol")) {
                IO.mostrarText("Criteri incorrecte. ");
            }
        } while (!criteri.equalsIgnoreCase("num") && !criteri.equalsIgnoreCase("titol"));

        usuari.blog.setCriteri(criteri.toLowerCase());
        usuari.blog.ordena();
    }
    
    public void visitant(){
        this.usuariActual = new Visitant(this);        
        this.usuariActual.getMenu().cicle();
    }
    
    public void sessio() throws BlogException{
        java.lang.String us, pass;
        IO.mostrarText("Usuari? ");
        us = IO.llegeixText();
        IO.mostrarText("Password? ");
        pass = IO.llegeixText();
        
        if (!this.registrats.containsKey(us) || !this.registrats.get(us).verificaPassword(pass)){
            throw new BlogException("Usuari o password incorrecte!\n");
        }
        Registrat actual = this.registrats.get(us);
        this.usuariActual = actual;
        this.usuariActual.getMenu().cicle();
    }
    
    public void registre() throws BlogException{
        java.lang.String nom, pass, pass2;
        IO.mostrarText("Alta usuari:\nNom Usuari? ");
        nom = IO.llegeixText();

        IO.mostrarText("Password? ");
        pass = IO.llegeixText();
        IO.mostrarText("Repeteix el password: ");
        pass2 =IO.llegeixText();
        if (!pass.equals(pass2)){
            throw new BlogException("Password incorrecte!");
        }
        this.registrats.put(nom, new Registrat(this,nom,pass));
    }
    
    public void mostraUsuaris(){
        if (this.registrats.isEmpty()){
            IO.mostrarText("No hi ha cap usuari.\n");
        } else {
            StringBuilder users = new StringBuilder("[");
            this.registrats.forEach((nom,usuari) -> users.append(nom).append(" ,"));
            users.replace(users.length()-2, users.length()-1, "]\n");
            String a[] = users.toString().split(",");
            IO.mostrarText(a[0]+","+a[1]);
        }
    }
    
    public void mostraBlog(java.lang.String nom) throws BlogException {
        if (this.registrats.containsKey(nom)){
            Registrat user = this.registrats.get(nom);            
            IO.mostrarText(user.blog.toString());
        } else {
            throw new BlogException("Usuari desconegut!");
        }
        
    }
}
