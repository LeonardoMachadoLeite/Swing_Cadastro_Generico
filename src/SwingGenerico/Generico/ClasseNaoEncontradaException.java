/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package SwingGenerico.Generico;

/**
 *
 * @author Efraim
 */
public class ClasseNaoEncontradaException extends Exception {

    /**
     * Creates a new instance of <code>ClasseNaoEncontradaException</code>
     * without detail message.
     */
    public ClasseNaoEncontradaException() {
        super("A classe passada como parâmetro não foi encontrada no banco de dados.");
    }

    /**
     * Constructs an instance of <code>ClasseNaoEncontradaException</code> with
     * the specified detail message.
     *
     * @param msg the detail message.
     */
    public ClasseNaoEncontradaException(String msg) {
        super(msg);
    }
}
