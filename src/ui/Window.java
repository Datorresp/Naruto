/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ui;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.*;
import model.*;

/**
 *
 * @author diegoa.torres
 */
public class Window {
    
    private Clan first;
    private Scanner reader;

    public Window() throws DoesntExistException {
        
        reader = new Scanner(System.in);
        String name = initClan();
        Clan c = new Clan(name);
        
    }
    
    public String initClan() throws DoesntExistException{
        
        String msj = "";
        String fin = "";
        Clan c = first;
        
        System.out.println("Digite el nombre del Clan: ");
        try {
            
            msj = reader.nextLine();
            
            while (c != null) {
                
                if (c.getName().equalsIgnoreCase(msj)) {
                    
                    fin = msj;
                }else{
                    
                    c = c.getNext();
                }
            }if (c == null) {
                
                throw new DoesntExistException(" El clan no existe ");
            }            
        } catch (InputMismatchException e) {
            
            System.out.println("Error: el clan no puede contener caracteres especiales");
        }
        
        return fin;
    }
    
    public void drivingGame(){
        
        boolean salir = false;
        
        while (!salir) {
            
            int userInput = gameMenu();
            
            switch (userInput) {
                
                case 1:
                    
                    
                    
                    break;
                default:
                    throw new AssertionError();
            }
        }
    }
    
    public int gameMenu(){
    
        System.out.println("Que deseas hacer ?");
        System.out.println("1. Añadir un ninja ");
        System.out.println("2. Añadir una habilidad al ninja ");
        System.out.println("3. Salir ");

        int valor = reader.nextInt();

        try {
        reader.nextLine();			

        }
        catch(InputMismatchException e) {

                System.out.println(" ERROR: RESPUESTA INVALIDA ");
                reader.nextLine();

        }
        catch(NoSuchElementException e1) {

                e1.printStackTrace();
                reader.nextLine();
        }
        return valor;        
    }
    
    public void addCharacter(){
        
        try{

            System.out.println('\n');
            System.out.println("Dijite el nombre del ninja");

            String name = reader.nextLine();
            
            System.out.println('\n');
            System.out.println("Dijite la personalidad del ninja");

            String personality = reader.nextLine();
            
            System.out.println('\n');
            System.out.println("Dijite el poder del ninja");

            int power = reader.nextInt();
            reader.nextLine();
            
            Calendar ca = new GregorianCalendar(); 
                    
            int day = ca.get(Calendar.DAY_OF_MONTH);
            int month = ca.get(Calendar.MONTH + 1);
            int year = ca.get(Calendar.YEAR);
            
            Calendar cal = new GregorianCalendar(year, month, day);
            
            Ninja ch = new Ninja(name, personality, power, cal);

            String rutaFichero = "Objetos.txt";         

        try{

            ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream(rutaFichero));
            ObjectInputStream ois = new ObjectInputStream(new FileInputStream(rutaFichero));

            oos.writeObject(ch);
            oos.close();

            Ninja readClient = (Ninja) ois.readObject();
            ois.close();

        }catch (IOException ex) {

            System.out.println(ex.getMessage());
        }catch (ClassNotFoundException ex) {

            System.out.println(ex.getMessage());
        }
        
        }catch (InputMismatchException ex) {

            System.out.println("Dato Erroneo vuelva a escribirlo");

            reader.nextLine();
        }
    }
    
    public String addClan(Clan c) throws AlreadyExistsException{
        
        String msj = " ";
        Clan cl = first;
        
        while (cl != null) {
            
          
            if (!cl.getName().equals(c.getName())) {
                
                if (cl.getNext() == null) {
                    
                    cl.setNext(c);
                    msj += "¡ Un Nuevo clan ha surgido !";
                    
                }else{
                    
                    cl = cl.getNext();
                }
                
            }else{
                
                throw new AlreadyExistsException("¡ No se aceptan duplicados !");
                
            }
        }
        
        return msj;       
    }
    
    
}
