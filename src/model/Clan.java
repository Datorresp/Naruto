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
public class Clan implements Serializable{
    
    private String name;
    private Clan next;
    private Clan back;
    private Character first;

    public Clan(String name) {
        this.name = name;
    }

    public Character getFirst() {
        return first;
    }

    public void setFirst(Character first) {
        this.first = first;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }  

    public Clan getNext() {
        return next;
    }

    public void setNext(Clan next) {
        this.next = next;
    }

    public Clan getBack() {
        return back;
    }

    public void setBack(Clan back) {
        this.back = back;
    }
    
    
    
    public String addCharacter(Character c) throws AlreadyExistsException{
        
        String msj = " ";
        Character h = first;
        
        while (h != null) {
            
            if (!h.getName().equals(c.getName())) {
                
            
                if (h.getNext() == null) {

                    h.setNext(h);
                    msj += " ¡Ha entrado un nuevo personaje al clan: " + name + "!";
                }
            }else{
                
                throw new AlreadyExistsException("¡ No se aceptan duplicados !");
            }
        }
        
        return msj;
    }
    
    public int lengthCharacter(){
        
        Character actual = first;
        int length = 0;
        
        while (actual != null) {
            
            length++;
            actual = actual.getNext();
        }
        
        return length;
    }
    
    public Character locateCharacter(String namec) throws DoesntExistException{
        
        Character actual = first;
        
        while (actual!= null && !actual.getName().equals(namec)) {
            
            actual = actual.getNext();
        }
        if (actual == null) {
            
            throw new DoesntExistException("¡ El Personaje no exite en esta aldea !");
        }
       
        return actual;
    }
    
    public Character locatePrevious(String namec){
        
        Character lasst = null;
        Character actual = first;
        
        while (actual != null && !actual.getName().equals(namec)) {
            
          lasst = actual;
          actual = actual.getNext();
        }
   
        return actual != null ? lasst: null;
    }
    
    public Character locateLast(){
        
     Character actual = first;
     
        if (actual != null) {
            
            while (actual.getNext() != null) {
                
                actual = actual.getNext();
            }
        }
     
     return actual;
    }
    
    public String delateCharacter(String namec) throws DoesntExistException{
        
        String msj = " ";
       
        
        if (first ==  null) {
            
            throw new DoesntExistException("!" + namec + " Ya no pertenece a esta aldea ¡");
        }else if (namec.equals(first.getName())) {
            
            first = first.getNext();
            msj += " !Se ha expulsado a: " + namec + " de la aldea¡";
        }else{
         
            Character lasst = locatePrevious(namec);
            
            if (lasst == null) {
                
                throw new DoesntExistException("!" + namec + " Ya no pertenece a esta aldea ¡");
            }
        }
        
        return msj;
    }
    
    public void characterSortByName(){
        
        Character actual = first.getNext();
        
        while (actual.compareTo(actual.getBack()) < 0) {
            
            first = actual.getBack();
            
        }
    }
}
