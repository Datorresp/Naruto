/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model;

import java.util.Calendar;
import java.util.GregorianCalendar;

/**
 *
 * @author diegoa.torres
 */
public class Character {
    
    private String name, personality;
    private int power;
    private Calendar ca;
    private int day;
    private int month;
    private int year;
    private Calendar creation= new GregorianCalendar(year, month, day);
    private Character next;
    private Character back;
    private Hability primero;

    public Character(String name, String personality, int power, Calendar ca) {
        this.name = name;
        this.personality = personality;
        this.power = power;
        this.ca = ca;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPersonality() {
        return personality;
    }

    public void setPersonality(String personality) {
        this.personality = personality;
    }

    public int getPower() {
        return power;
    }

    public void setPower(int power) {
        this.power = power;
    }

    public Calendar getCa() {
        return ca;
    }

    public void setCa(Calendar ca) {
        this.ca = ca;
    }

    public Calendar getCreation() {
        return creation;
    }

    public void setCreation(Calendar creation) {
        this.creation = creation;
    }

    public Character getNext() {
        return next;
    }

    public void setNext(Character next) {
        this.next = next;
    }     

    public Character getBack() {
        return back;
    }

    public void setC1(Character back) {
        this.back = back;
    }

    public Hability getPrimero() {
        return primero;
    }

    public void setPrimero(Hability primero) {
        this.primero = primero;
    }
    
    public String addHabilityToLast(Hability h){
        
        String msj =" ";
        Hability a = primero;
        
        while (a != null) {
            
            if (a.getNext() == null) {
                
                a.setSiguiente(h);
                msj += " ¡Nueva habilidad desbloqueada de: " + name + "!";
                
            }else{
                
                a = a.getNext();
            }
        }
        
        return msj;
    }

}
