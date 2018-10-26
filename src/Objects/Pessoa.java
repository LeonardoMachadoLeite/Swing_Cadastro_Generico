/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Objects;

import SwingGenerico.Interfaces.ClasseGenerica;
import com.google.gson.JsonObject;
import com.j256.ormlite.field.DatabaseField;
import java.util.HashMap;

/**
 *
 * @author Efraim
 */
public class Pessoa implements ClasseGenerica{
    
    @DatabaseField
    public String nome;
    @DatabaseField(id = true)
    private String CPF;
    
    public Pessoa(JsonObject args) {
        this.nome = args.get("Nome").getAsString();
        this.CPF = args.get("CPF").getAsString();
    }
    public Pessoa(String nome, String CPF) {
        this.nome = nome;
        this.CPF = CPF;
    }
    public Pessoa() {}
    @Override
    public String toString() {
        return String.format("Pessoa(%s, %s)", this.nome, this.CPF);
    }

    @Override
    public String key() {
        return "Nome";
    }

    @Override
    public String getKey() {
        return this.nome;
    }

    @Override
    public Object getInstance() {
        return this;
    }

    @Override
    public String[] listar() {
        return new String[] {this.nome, this.CPF};
    }
}
