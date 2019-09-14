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
public class Clan {
    
    private String name;
    private Clan next;
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
    
    public String addCharacter(Character c){
        
        String msj = " ";
        Character h = first;
        
        while (h != null) {
            
            if (h.getNext() == null) {
                
                h.setNext(h);
                msj += " ¡Ha entrado un nuevo personaje al clan: " + name + "!";
            }
        }
        
        return msj;
    }
}
