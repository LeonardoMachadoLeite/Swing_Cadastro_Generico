/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package SwingGenerico.Interfaces;

/**
 *
 * @author Efraim
 */
public interface ClasseGenerica {
    public String key(); // Returns the name of the atribute that is used as a key. Is used to find which generic component
    public String getKey();
    public Object getInstance();
    public String[] listar();
}
