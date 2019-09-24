    /*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model;

import java.io.Serializable;

/**
 *
 * @author diegoa.torres
 */
public class Hability implements Comparable<Hability>, Serializable{
    
    private String name;
    private int power;
    private Hability next;
    private static final long serialVersionUID = 799656478674716638L;

    public Hability(String name, int power, Hability next) {
        this.name = name;
        this.power = power;
        this.next = next;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getPower() {
        return power;
    }

    public void setPower(int power) {
        this.power = power;
    }   

    public Hability getNext() {
        return next;
    }

    public void setSiguiente(Hability next) {
        this.next = next;
    }   

    @Override
    public int compareTo(Hability o) {
        return next.compareTo(o);
    }
    
    public int compareToName(Hability h){
        
        return name.compareTo(h.getName());
    }
    
    public int compareToPower(Hability o){
        
        return power-o.getPower();
    }

    @Override
    public String toString() {
        return "Hability{" + "name=" + name + ", power=" + power + '}';
    }
}
