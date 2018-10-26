/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package SwingGenerico.Generico;

import SwingGenerico.Interfaces.PainelGenerico;
import com.google.gson.JsonObject;

/**
 *
 * @author Efraim
 */
public class SexoRadioPanel extends javax.swing.JPanel implements PainelGenerico{

    /**
     * Creates new form SexoRadioPanel
     */
    public SexoRadioPanel() {
        initComponents();
        sexoInvalidoLabel.setVisible(false);
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        buttonGroup1 = new javax.swing.ButtonGroup();
        Sexo = new javax.swing.JLabel();
        masculinoRadioButton = new javax.swing.JRadioButton();
        femininoRadioButton = new javax.swing.JRadioButton();
        sexoInvalidoLabel = new javax.swing.JLabel();

        Sexo.setText("Sexo:");

        buttonGroup1.add(masculinoRadioButton);
        masculinoRadioButton.setText("Masculino");
        masculinoRadioButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                masculinoRadioButtonActionPerformed(evt);
            }
        });

        buttonGroup1.add(femininoRadioButton);
        femininoRadioButton.setText("Feminino");
        femininoRadioButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                femininoRadioButtonActionPerformed(evt);
            }
        });

        sexoInvalidoLabel.setForeground(new java.awt.Color(255, 0, 0));
        sexoInvalidoLabel.setText("Sexo Inválido");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(Sexo)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(sexoInvalidoLabel)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(masculinoRadioButton)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(femininoRadioButton)))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(Sexo)
                    .addComponent(masculinoRadioButton)
                    .addComponent(femininoRadioButton))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(sexoInvalidoLabel)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
    }// </editor-fold>//GEN-END:initComponents

    private void masculinoRadioButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_masculinoRadioButtonActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_masculinoRadioButtonActionPerformed

    private void femininoRadioButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_femininoRadioButtonActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_femininoRadioButtonActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel Sexo;
    private javax.swing.ButtonGroup buttonGroup1;
    private javax.swing.JRadioButton femininoRadioButton;
    private javax.swing.JRadioButton masculinoRadioButton;
    private javax.swing.JLabel sexoInvalidoLabel;
    // End of variables declaration//GEN-END:variables

    @Override
    public String getNome() {
        return "Sexo";
    }

    @Override
    public boolean painelPreenchido() {
        if (masculinoRadioButton.isSelected() || femininoRadioButton.isSelected()) {
            sexoInvalidoLabel.setVisible(false);
            return true;
        }
        sexoInvalidoLabel.setVisible(true);
        return false;
    }

    @Override
    public void addInput(JsonObject jsonObj) {
        jsonObj.addProperty("Sexo", masculinoRadioButton.isSelected());
    }
}