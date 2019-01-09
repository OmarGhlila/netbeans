/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package essai.Exception;

/**
 *
 * @author Omar Ghlila
 */
public class ExceptionError extends Exception {

    /**
     * Creates a new instance of <code>ExceptionError</code> without detail
     * message.
     */
    public ExceptionError() {
    }

    /**
     * Constructs an instance of <code>ExceptionError</code> with the specified
     * detail message.
     *
     * @param msg the detail message.
     */
    public ExceptionError(String msg) {
        super(msg);
    }
}
