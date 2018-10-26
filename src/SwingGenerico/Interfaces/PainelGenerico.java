package SwingGenerico.Interfaces;

import com.google.gson.JsonObject;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author Efraim
 */
public interface PainelGenerico {
    public String getNome();
    public boolean painelPreenchido();
    public void addInput(JsonObject jsonObj);
}
