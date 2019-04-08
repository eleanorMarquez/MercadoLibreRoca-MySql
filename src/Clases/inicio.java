package Clases;

import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

public class inicio extends javax.swing.JFrame {
    private Timer tiempo;
    private ActionListener action;

    public inicio() {
        initComponents();
        barraB.setBackground(Color.red);
        setLocationRelativeTo(null);
        Barra();
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        barraB = new javax.swing.JProgressBar();
        jLabel2 = new javax.swing.JLabel();
        jLabel1 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setBackground(new java.awt.Color(250, 250, 250));
        setUndecorated(true);
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        barraB.setBackground(new java.awt.Color(102, 255, 102));
        barraB.setBorderPainted(false);
        getContentPane().add(barraB, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 250, 400, 25));

        jLabel2.setFont(new java.awt.Font("Tahoma", 0, 10)); // NOI18N
        jLabel2.setForeground(new java.awt.Color(99, 174, 189));
        jLabel2.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel2.setText("Version 1.0   Copyright © 2018  MercadoLibre-Roca All Right Reserved");
        getContentPane().add(jLabel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 280, 400, -1));

        jLabel1.setBackground(new java.awt.Color(20, 240, 240));
        jLabel1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/logoinicio.png"))); // NOI18N
        jLabel1.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        getContentPane().add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(83, 0, 290, 240));

        jLabel3.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/fondoinico.jpg"))); // NOI18N
        getContentPane().add(jLabel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, -1, -1));

        pack();
    }// </editor-fold>//GEN-END:initComponents

    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(inicio.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(inicio.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(inicio.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(inicio.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new inicio().setVisible(true);
            }
        });
    }
    
    private void Barra() {
        action = new ActionListener(){
            @Override
            public void actionPerformed(ActionEvent e) {
         
                if (barraB.getValue()<100){
                barraB.setValue(barraB.getValue()+10);
                }
                
                else {                
                    tiempo.stop();
                    Diseño_Bienvenido();                
                }            
            }
            private void Diseño_Bienvenido() {

              index indice=new index();
              indice.setVisible(true);
              dispose();

            }
        }; 
        tiempo = new Timer(350,action);
        tiempo.start();
    }  

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JProgressBar barraB;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    // End of variables declaration//GEN-END:variables
}
