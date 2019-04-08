package Clases;

import java.awt.HeadlessException;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import javax.swing.Icon;
import javax.swing.ImageIcon;
import javax.swing.JOptionPane;


public class login extends javax.swing.JFrame {
    
    ConexionBD conexion= new ConexionBD();
    Connection Llamar= conexion.conexion();
    datos llamaruser=new datos();
    Icon login;
    
   
    public login() {
        initComponents();
        login=new ImageIcon("src/img/login1.png");
        super.setLocationRelativeTo(null);
        BTN_ingresar.requestFocus();
        //JPF_pass.
    }
    
    public void VerificarUser(){
        String passuser="";
        String passPassword="";
        passuser=JTF_user.getText();
        passPassword=JPF_pass.getText();
                
        if (!passuser.equals("")  && !passPassword.equals("")){            
            acceder(passuser, passPassword);            
        }else {
            JOptionPane.showMessageDialog(null," INGRESE SUS RESPECTIVAS CREDENCIALES ","Inicio de Sesion",0);
        }
    }    
    
    public void acceder(String usuario, String pass){
       
       String sql="SELECT id_usuario,nombres_usuario FROM usuarios WHERE correo_usuario='"+usuario+"' && password_usuario='"+pass+"'";
       String []dato = new String [2]; 
       try {
            Statement st = Llamar.createStatement();
            ResultSet rs = st.executeQuery(sql);
            while(rs.next()){
                dato[0]=rs.getString(1);
                dato[1]=rs.getString(2);
                if(Integer.parseInt(dato[0])>0){
                    llamaruser.setUser(Integer.parseInt(dato[0]));
                }else if(dato[0]==null){
                    llamaruser.setUser(0);
              }
            }
            if(rs.first()){
                JOptionPane.showMessageDialog(null," BIENVENID@ "+dato[1].toUpperCase(),"Inicio de Sesion",JOptionPane.INFORMATION_MESSAGE,login);
                productos admi=new productos();
                admi.setVisible(true);
                dispose(); 
            }else{
                JOptionPane.showMessageDialog(null,"Usuario y Contraseña lncorrectos", " DATOS INCORRECTOS ",2);               
                JTF_user.setText("");
                JPF_pass.setText("CONTRASEÑA");
                JTF_user.requestFocus();
            }
        }catch (HeadlessException | NumberFormatException | SQLException ex){
            JOptionPane.showMessageDialog(null,"ERROR!! al conectar a base de datos del usuario"+ex);
        }
    }
    

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabel1 = new javax.swing.JLabel();
        BTN_ingresar = new javax.swing.JButton();
        jLabel2 = new javax.swing.JLabel();
        JTF_user = new javax.swing.JTextField();
        JPF_pass = new javax.swing.JPasswordField();
        BTN_volver = new javax.swing.JButton();
        jLabel3 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setBackground(new java.awt.Color(255, 255, 255));
        setUndecorated(true);
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel1.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(99, 174, 189));
        jLabel1.setText("Usuario:");
        getContentPane().add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(53, 27, -1, -1));

        BTN_ingresar.setBackground(new java.awt.Color(0, 141, 167));
        BTN_ingresar.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        BTN_ingresar.setForeground(new java.awt.Color(255, 255, 255));
        BTN_ingresar.setText("INGRESAR");
        BTN_ingresar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                BTN_ingresarActionPerformed(evt);
            }
        });
        getContentPane().add(BTN_ingresar, new org.netbeans.lib.awtextra.AbsoluteConstraints(250, 119, -1, -1));

        jLabel2.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel2.setForeground(new java.awt.Color(99, 174, 189));
        jLabel2.setText("Contraseña:");
        getContentPane().add(jLabel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(25, 81, -1, -1));

        JTF_user.setForeground(new java.awt.Color(99, 174, 189));
        JTF_user.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        JTF_user.setText("correousuario@correo.com");
        JTF_user.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusGained(java.awt.event.FocusEvent evt) {
                JTF_userFocusGained(evt);
            }
            public void focusLost(java.awt.event.FocusEvent evt) {
                JTF_userFocusLost(evt);
            }
        });
        getContentPane().add(JTF_user, new org.netbeans.lib.awtextra.AbsoluteConstraints(128, 27, 231, -1));

        JPF_pass.setForeground(new java.awt.Color(99, 174, 189));
        JPF_pass.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        JPF_pass.setText("contraseña");
        JPF_pass.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusGained(java.awt.event.FocusEvent evt) {
                JPF_passFocusGained(evt);
            }
            public void focusLost(java.awt.event.FocusEvent evt) {
                JPF_passFocusLost(evt);
            }
        });
        getContentPane().add(JPF_pass, new org.netbeans.lib.awtextra.AbsoluteConstraints(128, 81, 231, -1));

        BTN_volver.setBackground(new java.awt.Color(0, 141, 167));
        BTN_volver.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        BTN_volver.setForeground(new java.awt.Color(255, 255, 255));
        BTN_volver.setText("VOLVER");
        BTN_volver.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                BTN_volverActionPerformed(evt);
            }
        });
        getContentPane().add(BTN_volver, new org.netbeans.lib.awtextra.AbsoluteConstraints(141, 119, -1, -1));

        jLabel3.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/login.jpg"))); // NOI18N
        getContentPane().add(jLabel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, -1, -1));

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void BTN_ingresarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_BTN_ingresarActionPerformed
        VerificarUser();
    }//GEN-LAST:event_BTN_ingresarActionPerformed

    private void BTN_volverActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_BTN_volverActionPerformed
        index indice=new index();
        indice.setVisible(true);
        dispose();
    }//GEN-LAST:event_BTN_volverActionPerformed

    private void JPF_passFocusGained(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_JPF_passFocusGained
        if(JPF_pass.getText().equalsIgnoreCase("CONTRASEÑA")){
           JPF_pass.setText("");        
        }
    }//GEN-LAST:event_JPF_passFocusGained

    private void JPF_passFocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_JPF_passFocusLost
       if(JPF_pass.getText().equalsIgnoreCase("")){
          JPF_pass.setText("CONTRASEÑA");     
        }
    }//GEN-LAST:event_JPF_passFocusLost

    private void JTF_userFocusGained(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_JTF_userFocusGained
       if(JTF_user.getText().equalsIgnoreCase("correousuario@correo.com")){
          JTF_user.setText("");           
        }
    }//GEN-LAST:event_JTF_userFocusGained

    private void JTF_userFocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_JTF_userFocusLost
        if(JTF_user.getText().equalsIgnoreCase("")){
           JTF_user.setText("correousuario@correo.com");           
        }
    }//GEN-LAST:event_JTF_userFocusLost


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton BTN_ingresar;
    private javax.swing.JButton BTN_volver;
    private javax.swing.JPasswordField JPF_pass;
    private javax.swing.JTextField JTF_user;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    // End of variables declaration//GEN-END:variables
}
