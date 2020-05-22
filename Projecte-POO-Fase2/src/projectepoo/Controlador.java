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
        Entrada e1 = new Entrada("t1","tx1","2020-05-15 08:42:00");
        Entrada e2 = new Entrada("t2","tx2","2019-05-15 08:42:00");
        Entrada e3 = new Entrada("t3","tx3","2018-05-15 08:42:00");
        this.entradesBlog.afageixOrdenat(e1);
        this.entradesBlog.afageixOrdenat(e2);
        this.entradesBlog.afageixOrdenat(e3);
        
    }

    public void dates() {
        java.lang.String data;
        java.lang.String[] actual = {"inicial", "final"}, dia;
        Temps[] t = {null,null};
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
        IO.mostrarText(this.entradesBlog.entreDates(t[0], t[1]));
    }

    public void eliminaEntrada(int num) {

        if (this.entradesBlog.Entrades.isEmpty()) {
            IO.mostrarText("Llista buida.\n");
        } else if (num < 0) {
            IO.mostrarText("Entrada no vàlida.\n");
        }
        
        Entrada e = this.entradesBlog.elimina(num);

        if (e==null) {
            IO.mostrarText("No hi ha cap element amb aquesta id.\n");
        } else {
            IO.mostrarText("Elimino " + e.toString() + "\n");
        }
    }

    public void index() {
        IO.mostrarText("\nIndex {\n" + entradesBlog.index() + "}\n");
    }

    public void mostraEntrada(int num) {

        if (this.entradesBlog.Entrades.isEmpty()) {
            IO.mostrarText("Llista buida.\n");
        } else if (num >= this.entradesBlog.Entrades.size() || num < 0) {
            IO.mostrarText("Entrada no vàlida.\n");
        } else {
            Entrada e = this.entradesBlog.agafa(num);
            IO.mostrarText(e.toString());
        }
    }

    public void mostraEntrades() {
        for (int i = 0; i < this.entradesBlog.Entrades.size(); i++) {
            this.mostraEntrada(i);
            IO.mostrarText("\n");
        }
    }

    public void novaEntrada() {
        Entrada e;
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
    }

    public void ordena() {
        java.lang.String criteri;
        do {
            IO.mostrarText("Criteri? (num/titol) ");
            criteri = IO.llegeixText();
            if (!criteri.equalsIgnoreCase("num") && !criteri.equalsIgnoreCase("titol")) {
                IO.mostrarText("Criteri incorrecte. ");
            }
        } while (!criteri.equalsIgnoreCase("num") && !criteri.equalsIgnoreCase("titol"));

        this.entradesBlog.setCriteri(criteri.toLowerCase());
        this.entradesBlog.ordena();
    }
    
    public void visitant(){
        try{
            while (1==1){
                this.usuariActual = new Visitant(this);        
                this.usuariActual.menu.cicle();
            }
        } catch(BlogException be){}
    }
    
    public void sessio() throws BlogException{
        java.lang.String us, pass;
        IO.mostrarText("Usuari? ");
        us = IO.llegeixText();
        IO.mostrarText("Password? ");
        pass = IO.llegeixText();
        
        Registrat user = this.registrats.get(us);
        
        if (user == null || !user.verificaPassword(pass)){
            throw new BlogException("Usuari o password incorrecte!\n");
        }
        this.usuariActual = user;
        try {
            while (1==1){
            user.getMenu().cicle();
            }
        } catch (BlogException be ){
            IO.mostrarText("has sortit del menú registrat");
        }

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
            throw new BlogException("Password incorrecte!\n");
        }
        this.registrats.put(nom, new Registrat(this,nom,pass));
    }
    
    public void mostraUsuaris(){
        if (this.registrats.isEmpty()){
            IO.mostrarText("No hi ha cap usuari.\n");
        } else {
            IO.mostrarText("[");
            this.registrats.forEach((nom,usuari) -> IO.mostrarText(nom + " ,"));
            IO.mostrarText("]\n");
        }
    }
    
    public void mostraBlog(java.lang.String nom) throws BlogException {
        Registrat user = this.registrats.get(nom);
        
        if (user == null) {
            throw new BlogException();
        }    
        user.blog.toString();
        //IO.mostrarText("mostrasioin del blog del pana este\n");
    }
}
