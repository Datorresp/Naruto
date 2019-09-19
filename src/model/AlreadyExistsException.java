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
public class AlreadyExistsException extends Exception {

    /**
     * Creates a new instance of <code>AlreadyExistsException</code> without
     * detail message.
     */
    public AlreadyExistsException() {
    }

    /**
     * Constructs an instance of <code>AlreadyExistsException</code> with the
     * specified detail message.
     *
     * @param msg the detail message.
     */
    public AlreadyExistsException(String msg) {
        super(msg);
    }
}
