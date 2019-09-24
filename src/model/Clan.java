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
    private Ninja first;
    private static final long serialVersionUID = 8799656478674716638L;

    public Clan(String name, Ninja first) {
        this.name = name;
        this.first = first;
    }

    public Ninja getFirst() {
        return first;
    }

    public void setFirst(Ninja first) {
        this.first = first;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    } 
    
    public String addCharacter(Ninja c) throws AlreadyExistsException{
        
        String msj = " ";
        Ninja h = first;
        System.out.println("Prueba");
        
        while (h != null) {
            
            if (!h.getName().equals(c.getName())) {
                
            
                if (h.getNext() == null) {

                    h.setNext(h);
                    msj += " ¡Ha entrado un nuevo personaje al clan: " + name + "!";
                    System.out.println("PRUEBAAAAAAAAAAAAAAA");
                }else{
                    
                    h = h.getNext();
                }
            }else{
                
                throw new AlreadyExistsException("¡ No se aceptan duplicados !");
            }
        }
        
        return msj;
    }
    
    public int lengthCharacter(){
        
        Ninja actual = first;
        int length = 0;
        
        while (actual != null) {
            
            length++;
            actual = actual.getNext();
        }
        
        return length;
    }
    
    public Ninja locateCharacter(String namec) throws DoesntExistException{
        
        Ninja actual = first;
        
        while (actual!= null && !actual.getName().equals(namec)) {
            
            actual = actual.getNext();
        }
        if (actual == null) {
            
            throw new DoesntExistException("¡ El Personaje no exite en esta aldea !");
        }
       
        return actual;
    }
    
    public Ninja locatePrevious(String namec){
        
        Ninja lasst = null;
        Ninja actual = first;
        
        while (actual != null && !actual.getName().equals(namec)) {
            
          lasst = actual;
          actual = actual.getNext();
        }
   
        return actual != null ? lasst: null;
    }
    
    public Ninja locateLast(){
        
     Ninja actual = first;
     
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
         
            Ninja lasst = locatePrevious(namec);
            
            if (lasst == null) {
                
                throw new DoesntExistException("!" + namec + " Ya no pertenece a esta aldea ¡");
            }
         }
        
        return msj;
    }
    
    public void addHability(String namec, Hability c) throws DoesntExistException{
        
        Ninja actual = locateCharacter(namec);
        
        actual.addHability(c);

    }
    
    public void updateNinjaByName(String name, Ninja n) throws DoesntExistException{
        
        Ninja last = locatePrevious(name);
        Ninja actual = locateCharacter(name);
        last.setNext(n);
        actual.setBack(last);
        
        if (actual.getNext() != null) {
            
            actual.setNext(actual.getNext());
            
        }        
    }
    
    public void delateHability(String nameN, String nameH) throws DoesntExistException{
        
        Ninja actual = locateCharacter(nameN);
        actual.deleteHability(nameH);       
    }
    
   public String showInfoNinja(){
       
       Ninja actual = first;
       String msj = " "; 
       
       while (actual != null) {
           
           msj += actual.toString();
           msj += '\n';
           actual = actual.getNext();
           
       }
       
       return msj;
   }
   
   public void updateHability(String nameN, String nameH, Hability h) throws DoesntExistException{
    
       Ninja actual = locateCharacter(nameN);
       
       actual.updateHability(nameH, h);
   }
   
   public String ShowInfoHability(){
       
       Ninja actual = first;
       String msj = " ";
       
       
       while (actual != null) {
           
           msj += actual.toString() + "----------------" + actual.HabilityInfo();
           msj += '\n';
           actual = actual.getNext();
           
       }
       
       return msj;
   }
}
