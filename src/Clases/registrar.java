
package Clases;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.text.DateFormat;
import javax.swing.JOptionPane;


public class registrar extends javax.swing.JFrame {
    
    ConexionBD conexion= new ConexionBD();
    Connection Llamar= conexion.conexion();
    
    DateFormat calendario=DateFormat.getDateInstance();
    String FechaN;
    int ID_Auto;

  
    public registrar() {
        initComponents();
        super.setLocationRelativeTo(null);
    }
    
    public void Verificar(){
         
        if(jtf_nombre.getText().isEmpty() ||  jtf_apelligo.getText().isEmpty() || jtf_celular.getText().isEmpty() || jtf_ciudad.getText().isEmpty() ||  jtf_correo.getText().isEmpty() || jtf_direccion.getText().isEmpty() ||  jtf_pass.getText().isEmpty() || JCB_sexo.getSelectedItem().toString().equals("Seleccione")) {
            JOptionPane.showMessageDialog(null, "No Debes Dejar Campos Vacios", "ERROR", 0);
        }if(jDC_fechaNacido.getDate()==null){
            JOptionPane.showMessageDialog(null, "No Debes Dejar Campos Vacios", "ERROR", 0);                
        }else{         
        GuardarUser();        
        }
    }
    
    public void GuardarUser(){
        FechaN=calendario.format(jDC_fechaNacido.getDate());
        try {
            
            PreparedStatement pst = (PreparedStatement) Llamar.prepareStatement("INSERT INTO usuarios(id_usuario, nombres_usuario,apellidos_usuario,fechaN_usuario, sexo_usuario, correo_usuario, celular_usuario, ciudad_usuario, direccion_usuario, password_usuario) VALUES(?,?,?,?,?,?,?,?,?,?)");
            pst.setInt(1, Integer.parseInt(jtf_Identificacion.getText()));
            pst.setString(2, jtf_nombre.getText());
            pst.setString(3, jtf_apelligo.getText());
            pst.setString(4, FechaN);
            pst.setString(5, JCB_sexo.getSelectedItem().toString());
            pst.setString(6, jtf_correo.getText());
            pst.setString(7, jtf_celular.getText());
            pst.setString(8, jtf_ciudad.getText());
            pst.setString(9, jtf_direccion.getText());
            pst.setString(10, jtf_pass.getText());
            pst.executeUpdate();
            JOptionPane.showMessageDialog(null,"El USUARO fue creado exitosamente\nel correo que ingreso sera su 'USUARIO'");
            limpiar();
            login indice=new login();
            indice.setVisible(true);
            dispose();
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null,"No se puede guardar el usuario");
            limpiar();
        }        
    }
    
    public void limpiar(){
        jtf_Identificacion.setText("");
        jtf_nombre.setText("");
        jtf_apelligo.setText("");
        jDC_fechaNacido.setDate(null);
        JCB_sexo.setSelectedIndex(0);
        jtf_correo.setText("");
        jtf_celular.setText("");
        jtf_ciudad.setText("");
        jtf_direccion.setText("");
        jtf_pass.setText("");
        
    }

    
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabel1 = new javax.swing.JLabel();
        jButton1 = new javax.swing.JButton();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();
        jtf_nombre = new javax.swing.JTextField();
        jtf_apelligo = new javax.swing.JTextField();
        jtf_correo = new javax.swing.JTextField();
        jtf_celular = new javax.swing.JTextField();
        jtf_ciudad = new javax.swing.JTextField();
        jtf_direccion = new javax.swing.JTextField();
        jtf_pass = new javax.swing.JTextField();
        jLabel8 = new javax.swing.JLabel();
        jButton2 = new javax.swing.JButton();
        jLabel9 = new javax.swing.JLabel();
        jDC_fechaNacido = new org.netbeans.modules.form.InvalidComponent();
        jLabel10 = new javax.swing.JLabel();
        JCB_sexo = new javax.swing.JComboBox<>();
        jLabel11 = new javax.swing.JLabel();
        jtf_Identificacion = new javax.swing.JTextField();
        jLabel12 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setUndecorated(true);
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel1.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(0, 141, 167));
        jLabel1.setText("Nombres:");
        getContentPane().add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(49, 120, -1, -1));

        jButton1.setText("CREAR CUENTA");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });
        getContentPane().add(jButton1, new org.netbeans.lib.awtextra.AbsoluteConstraints(321, 446, -1, -1));

        jLabel2.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabel2.setForeground(new java.awt.Color(0, 141, 167));
        jLabel2.setText("Apellidos:");
        getContentPane().add(jLabel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(49, 158, -1, -1));

        jLabel3.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabel3.setForeground(new java.awt.Color(0, 141, 167));
        jLabel3.setText("Correo:");
        getContentPane().add(jLabel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(49, 272, -1, -1));

        jLabel4.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabel4.setForeground(new java.awt.Color(0, 141, 167));
        jLabel4.setText("Celular:");
        getContentPane().add(jLabel4, new org.netbeans.lib.awtextra.AbsoluteConstraints(247, 241, 50, -1));

        jLabel5.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabel5.setForeground(new java.awt.Color(0, 141, 167));
        jLabel5.setText("Ciudad:");
        getContentPane().add(jLabel5, new org.netbeans.lib.awtextra.AbsoluteConstraints(49, 313, -1, -1));

        jLabel6.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabel6.setForeground(new java.awt.Color(0, 141, 167));
        jLabel6.setText("Direccion:");
        getContentPane().add(jLabel6, new org.netbeans.lib.awtextra.AbsoluteConstraints(49, 351, -1, -1));

        jLabel7.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabel7.setForeground(new java.awt.Color(0, 141, 167));
        jLabel7.setText("Contraseña:");
        getContentPane().add(jLabel7, new org.netbeans.lib.awtextra.AbsoluteConstraints(49, 389, -1, -1));

        jtf_nombre.setForeground(new java.awt.Color(0, 141, 167));
        jtf_nombre.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                jtf_nombreKeyTyped(evt);
            }
        });
        getContentPane().add(jtf_nombre, new org.netbeans.lib.awtextra.AbsoluteConstraints(130, 120, 300, -1));

        jtf_apelligo.setForeground(new java.awt.Color(0, 141, 167));
        jtf_apelligo.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                jtf_apelligoKeyTyped(evt);
            }
        });
        getContentPane().add(jtf_apelligo, new org.netbeans.lib.awtextra.AbsoluteConstraints(130, 158, 300, -1));

        jtf_correo.setForeground(new java.awt.Color(0, 141, 167));
        getContentPane().add(jtf_correo, new org.netbeans.lib.awtextra.AbsoluteConstraints(130, 272, 300, -1));

        jtf_celular.setForeground(new java.awt.Color(0, 141, 167));
        jtf_celular.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                jtf_celularKeyTyped(evt);
            }
        });
        getContentPane().add(jtf_celular, new org.netbeans.lib.awtextra.AbsoluteConstraints(300, 241, 130, -1));

        jtf_ciudad.setForeground(new java.awt.Color(0, 141, 167));
        jtf_ciudad.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                jtf_ciudadKeyTyped(evt);
            }
        });
        getContentPane().add(jtf_ciudad, new org.netbeans.lib.awtextra.AbsoluteConstraints(130, 313, 300, -1));

        jtf_direccion.setForeground(new java.awt.Color(0, 141, 167));
        getContentPane().add(jtf_direccion, new org.netbeans.lib.awtextra.AbsoluteConstraints(130, 351, 300, -1));

        jtf_pass.setForeground(new java.awt.Color(0, 141, 167));
        jtf_pass.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                jtf_passKeyTyped(evt);
            }
        });
        getContentPane().add(jtf_pass, new org.netbeans.lib.awtextra.AbsoluteConstraints(130, 389, 300, -1));

        jLabel8.setFont(new java.awt.Font("Tahoma", 1, 24)); // NOI18N
        jLabel8.setForeground(new java.awt.Color(0, 141, 167));
        jLabel8.setText("Completa tus datos");
        getContentPane().add(jLabel8, new org.netbeans.lib.awtextra.AbsoluteConstraints(130, 11, -1, -1));

        jButton2.setText("VOLVER");
        jButton2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton2ActionPerformed(evt);
            }
        });
        getContentPane().add(jButton2, new org.netbeans.lib.awtextra.AbsoluteConstraints(49, 446, -1, -1));

        jLabel9.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabel9.setForeground(new java.awt.Color(0, 141, 167));
        jLabel9.setText("Fecha de nacimiento:");
        getContentPane().add(jLabel9, new org.netbeans.lib.awtextra.AbsoluteConstraints(49, 199, -1, -1));
        getContentPane().add(jDC_fechaNacido, new org.netbeans.lib.awtextra.AbsoluteConstraints(197, 196, 233, -1));

        jLabel10.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabel10.setForeground(new java.awt.Color(0, 141, 167));
        jLabel10.setText("Genero:");
        getContentPane().add(jLabel10, new org.netbeans.lib.awtextra.AbsoluteConstraints(49, 241, -1, -1));

        JCB_sexo.setForeground(new java.awt.Color(0, 141, 167));
        JCB_sexo.setMaximumRowCount(3);
        JCB_sexo.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Seleccione", "Hombre", "Mujer", " " }));
        JCB_sexo.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
        getContentPane().add(JCB_sexo, new org.netbeans.lib.awtextra.AbsoluteConstraints(130, 241, 110, -1));

        jLabel11.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabel11.setForeground(new java.awt.Color(0, 141, 167));
        jLabel11.setText("Identificacion:");
        getContentPane().add(jLabel11, new org.netbeans.lib.awtextra.AbsoluteConstraints(49, 82, -1, -1));

        jtf_Identificacion.setForeground(new java.awt.Color(0, 141, 167));
        jtf_Identificacion.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                jtf_IdentificacionKeyTyped(evt);
            }
        });
        getContentPane().add(jtf_Identificacion, new org.netbeans.lib.awtextra.AbsoluteConstraints(151, 82, 279, -1));

        jLabel12.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/FRegistrar.jpg"))); // NOI18N
        getContentPane().add(jLabel12, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, -1, 490));

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        Verificar();
    }//GEN-LAST:event_jButton1ActionPerformed

    private void jButton2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton2ActionPerformed
        index indice=new index();
        indice.setVisible(true);
        dispose();
    }//GEN-LAST:event_jButton2ActionPerformed

    private void jtf_IdentificacionKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_jtf_IdentificacionKeyTyped
        char c=evt.getKeyChar();
        if(Character.isLetter(c)){
            getToolkit().beep();
            evt.consume();
            JOptionPane.showMessageDialog(null, "INGRESA SOLO NUMEROS", "ERROR", 0);
        }
    }//GEN-LAST:event_jtf_IdentificacionKeyTyped

    private void jtf_nombreKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_jtf_nombreKeyTyped
        char c=evt.getKeyChar();
        if(Character.isDigit(c)){
            getToolkit().beep();
            evt.consume();
            JOptionPane.showMessageDialog(null, "INGRESA SOLO LETRAS", "ERROR", 0);
        }
    }//GEN-LAST:event_jtf_nombreKeyTyped

    private void jtf_apelligoKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_jtf_apelligoKeyTyped
        char c=evt.getKeyChar();
        if(Character.isDigit(c)){
            getToolkit().beep();
            evt.consume();
            JOptionPane.showMessageDialog(null, "INGRESA SOLO LETRAS", "ERROR", 0);
        }
    }//GEN-LAST:event_jtf_apelligoKeyTyped

    private void jtf_celularKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_jtf_celularKeyTyped
        char c=evt.getKeyChar();
        if(Character.isLetter(c)){
            getToolkit().beep();
            evt.consume();
            JOptionPane.showMessageDialog(null, "INGRESA SOLO NUMEROS", "ERROR", 0);
        }
    }//GEN-LAST:event_jtf_celularKeyTyped

    private void jtf_ciudadKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_jtf_ciudadKeyTyped
        char c=evt.getKeyChar();
        if(Character.isDigit(c)){
            getToolkit().beep();
            evt.consume();
            JOptionPane.showMessageDialog(null, "INGRESA SOLO LETRAS", "ERROR", 0);
        }
    }//GEN-LAST:event_jtf_ciudadKeyTyped

    private void jtf_passKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_jtf_passKeyTyped
        char c=evt.getKeyChar();
        if(Character.isLetter(c)){
            getToolkit().beep();
            evt.consume();
            JOptionPane.showMessageDialog(null, "INGRESA SOLO NUMEROS", "ERROR", 0);
        }
    }//GEN-LAST:event_jtf_passKeyTyped

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JComboBox<String> JCB_sexo;
    private javax.swing.JButton jButton1;
    private javax.swing.JButton jButton2;
    private org.netbeans.modules.form.InvalidComponent jDC_fechaNacido;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel12;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JTextField jtf_Identificacion;
    private javax.swing.JTextField jtf_apelligo;
    private javax.swing.JTextField jtf_celular;
    private javax.swing.JTextField jtf_ciudad;
    private javax.swing.JTextField jtf_correo;
    private javax.swing.JTextField jtf_direccion;
    private javax.swing.JTextField jtf_nombre;
    private javax.swing.JTextField jtf_pass;
    // End of variables declaration//GEN-END:variables
}
