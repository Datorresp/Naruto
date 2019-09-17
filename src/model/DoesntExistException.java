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
public class DoesntExistException extends Exception {

    /**
     * Creates a new instance of <code>DoesntExistException</code> without
     * detail message.
     */
    public DoesntExistException() {
    }

    /**
     * Constructs an instance of <code>DoesntExistException</code> with the
     * specified detail message.
     *
     * @param msg the detail message.
     */
    public DoesntExistException(String msg) {
        super(msg);
    }
}
