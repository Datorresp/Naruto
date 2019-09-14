/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model;

/**
 *
 * @author diegoa.torres
 */
public class Hability {
    
    private String name;
    private int power;
    private Hability next;

    public Hability(String name, int power) {
        this.name = name;
        this.power = power;
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
}
