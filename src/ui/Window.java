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
    
    
    private Scanner reader;
    
    private  ArrayList<Clan> c;

    public Window() throws DoesntExistException {
        
        reader = new Scanner(System.in);        
        c = new ArrayList<>();
        init();
    }
        
    public void addClan(Clan cl) {
        
         c.add(cl);

    }  
    
    public int initClan() throws DoesntExistException{
        
        int finalScore = 0;     
        
        try {
            
            System.out.println("Digite el nombre del Clan: ");
            String msj = reader.nextLine();
            
            for (int i = 0; i < c.size(); i++) {
            
                if (c.get(i).getName().equalsIgnoreCase(msj)) {
                    
                    finalScore = i;
                }                
            }
            
            if (c == null) {
                
                throw new DoesntExistException(" El clan no existe ");
            }
            
        } catch (InputMismatchException e) {
            
            System.out.println("Error: el clan no puede contener caracteres especiales");
        }
        
        return finalScore;
    }
    
    public void drivingGame() throws AlreadyExistsException, DoesntExistException{
        
        boolean salir = false;
        
        while (!salir) {
            
            int userInput = gameMenu();
            
            switch (userInput) {
                
                case 1:
                    
                    addClanF();
                    
                    break;
                    
                case 2:
                    
                    addCharacter();
                    
                    break;
                    
                case 3:
                    
                    addHability();
                    
                    break;
                    
                case 4:
                    
                    delateNinja();
                    
                    break;
                    
                case 5:
                    
                    delateHability();
                    
                    break;
                    
                case 6:
                    
                    updateNinja();
                    
                    break;
                    
                case 7:
                    
                    updateHability();
                    
                    break;
                    
                case 8:
                    
                    showOnlyNinjas();
                    
                    break;
                    
                case 9:
                    
                    showNinjaWithHabilities();
                    
                    break;
                    
                default:
                    
                    salir = true;
            }
        }
    }
    
    public int gameMenu(){
    
        System.out.println("Que deseas hacer ?");
        System.out.println("1. Añadir un clan ");
        System.out.println("2. Añadir un ninja ");
        System.out.println("3. Añadir una habilidad al ninja ");
        System.out.println("4. Borrar un ninja ");
        System.out.println("5. Borrar una habilidad ");
        System.out.println("6. Editar un ninja ");
        System.out.println("7. Editar una habilidad ");
        System.out.println("8. Mostrar Ninjas del clan ");
        System.out.println("9. Mostrar Habilidades con el ninja respectivo");
        System.out.println(". Salir ");

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
    
    public void addCharacter() throws DoesntExistException, AlreadyExistsException{
        
        Ninja ch = null;
        
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
                       
             ch = new Ninja(name, personality, power, cal, null, null, null);
            
            c.get(initClan()).addCharacter(ch);

            String rutaFichero = "ObjetosNinja.txt";         

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
   
    public Hability addHability()  throws DoesntExistException{
     
        Hability h = null;
        try {
            
            System.out.println('\n');
            System.out.println(" Digite el nombre de la habilidad ");
            
            String name = reader.nextLine();
            
            System.out.println('\n');
            System.out.println(" Digite el poder que conlleva ");
            
            int power = reader.nextInt();
            reader.nextLine();
            
            System.out.println('\n');
            System.out.println(" Digite el nombre del ninja ");
            
            String nameN = reader.nextLine();
            
            h = new Hability(name, power, null);
            
            c.get(initClan()).addHability(nameN, h);
            
            try {
                
            String rutaFichero = "ObjetosHability.txt";
                
            ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream(rutaFichero));
            ObjectInputStream ois = new ObjectInputStream(new FileInputStream(rutaFichero));

            oos.writeObject(h);
            oos.close();

            Hability readClient = (Hability) ois.readObject();
            ois.close();
                
            }catch (IOException ex) {

                System.out.println(ex.getMessage());
            }catch (ClassNotFoundException ex) {

                System.out.println(ex.getMessage());
            }
            
        } catch (InputMismatchException e) {
            
            System.out.println(e.getMessage());
        }
        
        return h;
    }
    
    public void addClanF() throws AlreadyExistsException, DoesntExistException{
        
        try {
            System.out.println('\n');
            System.out.println(" Digite el nombre del clan ");
            
            String name  = reader.nextLine();
            
            System.out.println("----------------------------EL CLAN NECESITA UN LIDER, ¡CREALO!-------------------------");
            
                        
            Clan cl = new Clan (name, addCharacter2());
            c.add(cl);
            
            try {
                
                String rutaFichero = "ObjetosClan.txt";

                ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream(rutaFichero));
                ObjectInputStream ois = new ObjectInputStream(new FileInputStream(rutaFichero));

                oos.writeObject(cl);
                oos.close();

                Clan readClient = (Clan) ois.readObject();
                ois.close();
                
            }catch (IOException ex) {

                System.out.println(ex.getMessage());
            }catch (ClassNotFoundException ex) {

                System.out.println(ex.getMessage());
            }
            
        } catch (InputMismatchException e) {
            
            System.out.println(e.getMessage());
        }
    }
    
    public void delateNinja() throws DoesntExistException{
        
        try {
            
            System.out.println('\n');
            System.out.println(" Digite el nombre del ninja a eliminar ");
            
            String name = reader.nextLine();
            
            c.get(initClan()).delateCharacter(name);
            
        } catch (InputMismatchException e) {
            
            System.out.println(e.getMessage());
        }
    }
    
    public void delateHability() throws DoesntExistException{
        
        try {
            
            System.out.println('\n');
            System.out.println(" Digite el nombre del ninja el cual pierde la habilidad ");
            
            String nameN = reader.nextLine();
            
            System.out.println('\n');
            System.out.println(" Digite el nombre de la habilidad ");            
            
            String nameH = reader.nextLine();
            
            c.get(initClan()).delateHability(nameN, nameH);
            
            
        } catch (InputMismatchException e) {
            
            System.out.println(e.getMessage());
        }
    }
    
    public void updateNinja() throws DoesntExistException{
        
        try {
            
            System.out.println('\n');
            System.out.println(" Digite el nombre del ninja a cambiar ");            
            
            String nameN = reader.nextLine();
            
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
            
            Ninja ch = new Ninja(name, personality, power, cal, null, null, null);
            
            c.get(initClan()).updateNinjaByName(nameN, ch);
            
        } catch (InputMismatchException e) {
            
            System.out.println(e.getMessage());
        }
    }
    
    public void updateHability() throws DoesntExistException{
     
        try {
            
            System.out.println('\n');
            System.out.println(" Digite el nombre del ninja a cambiar ");            
            
            String nameN = reader.nextLine();
            
            System.out.println('\n');
            System.out.println(" Digite el nombre de la habilidad ");            
            
            String nameH = reader.nextLine();
            
            System.out.println('\n');
            System.out.println(" Digite el nombre de la habilidad ");
            
            String name = reader.nextLine();
            
            System.out.println('\n');
            System.out.println(" Digite el poder que conlleva ");
            
            int power = reader.nextInt();
            reader.nextLine();
            
            Hability h = new Hability(name, power, null); 
            
            c.get(initClan()).updateHability(nameN, nameH, h);
            
        } catch (InputMismatchException e) {
            
            System.out.println(e.getMessage());
        }
    }
    
    public void showOnlyNinjas() throws DoesntExistException{
        
        System.out.println(c.get(initClan()).showInfoNinja()); 
    }
    
    public void showNinjaWithHabilities() throws DoesntExistException{
        
        System.out.println(c.get(initClan()).ShowInfoHability());
    }
    
    
    
    
    
    
    
    
    
    
    
    
    
        public Ninja addCharacter2() throws DoesntExistException, AlreadyExistsException{
        
        Ninja ch = null;
        
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
            
            System.out.println("----------------------EL PERSONAJE NECESITA POR LO MENOS UNA TECNICA ESPECIAL----------------------");
                       
             ch = new Ninja(name, personality, power, cal, null, null, addHability2());

            String rutaFichero = "ObjetosNinja.txt";         

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
        
        
        return ch;
    }
        
    public Hability addHability2()  throws DoesntExistException{
     
        Hability h = null;
        try {
            
            System.out.println('\n');
            System.out.println(" Digite el nombre de la habilidad ");
            
            String name = reader.nextLine();
            
            System.out.println('\n');
            System.out.println(" Digite el poder que conlleva ");
            
            int power = reader.nextInt();
            reader.nextLine();
            
            h = new Hability(name, power, null);
            
            try {
                
            String rutaFichero = "ObjetosHability.txt";
                
            ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream(rutaFichero));
            ObjectInputStream ois = new ObjectInputStream(new FileInputStream(rutaFichero));

            oos.writeObject(h);
            oos.close();

            Hability readClient = (Hability) ois.readObject();
            ois.close();
                
            }catch (IOException ex) {

                System.out.println(ex.getMessage());
            }catch (ClassNotFoundException ex) {

                System.out.println(ex.getMessage());
            }
            
        } catch (InputMismatchException e) {
            
            System.out.println(e.getMessage());
        }
        
        return h;
    }

    private void init() {
        
        Hability h = new Hability("jaja", 100, null);
        
        Calendar ca = new GregorianCalendar();                    
        int day = ca.get(Calendar.DAY_OF_MONTH);
        int month = ca.get(Calendar.MONTH + 1);
        int year = ca.get(Calendar.YEAR);    
        Calendar cal = new GregorianCalendar(year, month, day);
        
        Ninja n = new Ninja("Diego", "Guerrero", 1000, cal, null, null, h);
        
        Clan cl = new Clan ("Torres", n);
        addClan(cl);
    }
        
}
