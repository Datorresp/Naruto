/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ui;

import model.AlreadyExistsException;
import model.DoesntExistException;

/**
 *
 * @author diegoa.torres
 */
public class Main {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) throws DoesntExistException, AlreadyExistsException {
        
        Window w = new Window();
        w.drivingGame();
    }
    
}
