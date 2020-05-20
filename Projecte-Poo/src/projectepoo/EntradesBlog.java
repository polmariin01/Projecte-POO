/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package projectepoo;

import java.util.LinkedList;

/**
 *
 * @authors Gil Boleda Feliu i Pol Marín Gargallo
 */
public class EntradesBlog {

    private java.lang.String criteri;
    public LinkedList<Entrada> Entrades;

    public EntradesBlog() {
        this.criteri = "num";
        this.Entrades = new LinkedList<>();
    }

    public boolean setCriteri(java.lang.String criteri) {
        if (criteri.equals("num") || criteri.equals("titol")) {
            this.criteri = criteri;
            return true;
        } else {
            return false;
        }
    }

    public void afageixOrdenat(Entrada e) {
        int pos = 0;
        boolean afegit = false;
        if (Entrades.isEmpty()){
            Entrades.add(0,e);
        } else {
            for (Entrada ent : this.Entrades) {
                if (Entrada.compare(ent, e, this.criteri) > 0 && (!afegit)) {
                    pos++;
                }
                if (Entrada.compare(ent, e, this.criteri) <= 0) {
                    Entrades.add(pos, e);
                    afegit = true;
                }
            }
            if (!afegit) {
                Entrades.add(pos, e);
            }
        }
    }

    public Entrada agafa(int num) {
        return this.Entrades.get(num);
    }

    public Entrada elimina(int num) {
        int i = 0;
        for (Entrada Entrade : Entrades) {
            if (num == Entrade.getId()) {
                return this.Entrades.remove(i);
            }
            i++;
        }
        return null;

    }

    public void ordena() {
        Entrada auxiliar;
        int comp;
        for (int i = 0; i < this.Entrades.size(); i++) {
            for (int j = 1; j < this.Entrades.size() - i; j++) {
                comp = Entrada.compare(this.Entrades.get(j), this.Entrades.get(j - 1), this.criteri);
                if (comp < 0) {
                    auxiliar = this.Entrades.get(j);
                    this.Entrades.set(j, this.Entrades.get(j - 1));
                    this.Entrades.set(j - 1, auxiliar);
                }
            }
        }
    }

    public java.lang.String index() {
        java.lang.String tornar = "";
        this.ordena();
        for (int i = 0; i < this.Entrades.size(); i++) {
            tornar = tornar + "\t" + this.Entrades.get(i).getId() + " " + this.Entrades.get(i).getTitol() + "\n";
        }
        return tornar;
    }

    public java.lang.String entreDates(Temps inici, Temps fi) {
        java.lang.String tornar = "";
        this.ordena();
        for (int i = 0; i < this.Entrades.size(); i++) {
            if (this.Entrades.get(i).getQuan().comparaDia(inici) <= 0) {
                if (this.Entrades.get(i).getQuan().comparaDia(fi) >= 0) {
                    tornar = tornar + this.Entrades.get(i).getId() + " " + this.Entrades.get(i).getTitol() + "\n";
                }
            }
        }
        return tornar;
    }

    @Override
    public java.lang.String toString() {
        this.ordena();
        java.lang.String tornar = "";
        for (int i = 0; i < this.Entrades.size(); i++) {
            tornar = tornar + this.Entrades.get(i).getTitol() + "\n";
        }
        return tornar;
    }
}
