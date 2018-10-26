/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package SwingGenerico.Generico;

import SwingGenerico.Interfaces.PainelGenerico;
import SwingGenerico.Interfaces.ClasseGenerica;
import java.util.LinkedList;
import java.util.Queue;

/**
 *
 * @author Efraim
 */
public class PaineisGenericos {
    
    private final Class classe;
    private Queue<PainelGenerico> paineis;
    
    //Constructor
    public PaineisGenericos(Class classe) {
        this.classe = classe;
        this.paineis = new LinkedList<>();
    }
    
    //Getters and Setters
    public Class getClasse() {
        return classe;
    }

    public Queue<PainelGenerico> getPaineis() {
        return paineis;
    }
    
    //Method to test if panel with the same name is already contained
    public boolean hasPanelNamed(String name) {
        for (PainelGenerico i : this.paineis) {
            if (i.getNome().equals(name)) {
                return true;
            }
        }
        return false;
    }
    
    //Methods to add the generic panels
    public boolean addTextField(String nome) {
        if (!this.hasPanelNamed(nome)) {
            this.paineis.add(new CadastrarPainelGenerico(nome));
            return true;
        }
        return false;
    }
    public boolean addFormattedTextField(String nome) {
        if (!this.hasPanelNamed(nome)) {
            this.paineis.add(new CadastrarPainelFormatadoGenerico(nome));
            return true;
        }
        return false;
    }
    public boolean addFormattedTextField(String nome, String mascara, boolean mascaraLength) {
        if (!this.hasPanelNamed(nome)) {
            this.paineis.add(new CadastrarPainelFormatadoGenerico(nome, mascara, mascaraLength));
            return true;
        }
        return false;
    }
    public boolean addDropBoxGenerico(String nome, Class classe) throws ClasseNaoEncontradaException {
        if (!this.hasPanelNamed(nome)) {
            this.paineis.add(new DropBoxGenerico(nome, classe));
            return true;
        }
        return false;
    }
    public boolean addDropBoxGenerico(String nome, String[] listaOpcoes) {
        if (!this.hasPanelNamed(nome)) {
            this.paineis.add(new DropBoxGenerico(nome, listaOpcoes));
            return true;
        }
        return false;
    }
    public boolean addSexoRadioButton() {
        if (!this.hasPanelNamed("Sexo")) {
            this.paineis.add(new SexoRadioPanel());
            return true;
        }
        return false;
    }
}
