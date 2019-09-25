/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model;

import java.io.Serializable;
import java.util.Calendar;
import java.util.GregorianCalendar;

/**
 *
 * @author diegoa.torres
 */
public class Ninja implements Comparable<Ninja>, Serializable{
    
    private String name, personality;
    private int power;
    private Calendar ca;
    private int day;
    private int month;
    private int year;
    private Calendar creation= new GregorianCalendar(year, month, day);
    private Ninja next;
    private Ninja back;
    private Hability first;
    private static final long serialVersionUID = 8799656478674716639L;

    public Ninja(String name, String personality, int power, Calendar ca, Ninja next, Ninja back, Hability first) {
        this.name = name;
        this.personality = personality;
        this.power = power;
        this.ca = ca;
        this.next = next;
        this.back = back;
        this.first = first;
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

    public Ninja getNext() {
        return next;
    }

    public void setNext(Ninja next) {
        this.next = next;
    }     

    public Ninja getBack() {
        return back;
    }

    public void setBack(Ninja back) {
        this.back = back;
    }

    public Hability getFirst() {
        return first;
    }

    public void setFirst(Hability first) {
        this.first = first;
    }
    
    public String addHability(Hability h){
        
        String msj =" ";
        Hability a = first;
        
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
    
    public int habilityLength(){
        
        Hability actual = first;        
        int length = 0;
        
        while (actual != null) {
            
            actual = actual.getNext();
        }
        
        return length;
    }
    
    
    public String deleteHability(String namep) throws DoesntExistException{
        
        String msj = " ";
        
        if (first == null) {
            
            throw new DoesntExistException("¡" + namep + " No ha sido aprendida! ");
            
        }else if (namep.equals(first.getName())) {
            
            first = first.getNext();
            msj += "¡" + namep + "Ya no pertenece a: " +  name + "!";
            
        }       
        return msj;
    }
    
    public Hability locateHability(String namep) throws DoesntExistException{
        
        Hability actual = first;
        
        while (actual != null && !actual.getName().equals(namep)) {
            
            actual = actual.getNext();
            
        }if (actual == null) {
            
            throw new DoesntExistException("¡ El Personaje no exite en esta aldea !");
        }
        
       return actual;     
    }

    @Override
    public int compareTo(Ninja o) {
     
        return name.compareTo(o.getName());
    }
    
    public Hability locatePrevious(String namec) throws DoesntExistException{
        
        Hability lasst = null;
        Hability actual = first;
        
        while (actual != null && !actual.getName().equals(namec)) {
            
          lasst = actual;
          actual = actual.getNext();
        }if (actual == null) {
            
            throw new DoesntExistException("¡ El Personaje no exite en esta aldea !");
        }
   
        return actual != null ? lasst: null;
    }    

    @Override
    public String toString() {
        return "Ninja{" + "name=" + name + ", personality=" + personality + ", power=" + power + ", ca=" + ca + ", creation=" + creation + '}';
    }
    
    public String HabilityInfo(){
        
        String msj = " ";
        Hability actual = first;
        
        while (actual != null) {
            
            msj += actual.toString();
            actual = actual.getNext();
        }
        
        return msj;
    }
    
    public void updateHability(String name, Hability h) throws DoesntExistException{
        
        Hability last = locatePrevious(name);
        Hability actual = locateHability(name);
        last.setSiguiente(h);
        
        if (actual.getNext() != null) {
            
            actual.setSiguiente(actual.getNext());
            
        }                
    }
    
    public void sortHability(){
        
       Hability actual = first;
       Hability next = actual.getNext();
       Hability aux = null;
       
       while (actual != null && next != null) {
           
           if (actual.compareTo(next) > 0) {
               
               aux = actual;
               first = next;
               next.setSiguiente(actual);
           }else{
               
               actual = actual.getNext();
               next = next.getNext();
           }
       }        
    }
}   