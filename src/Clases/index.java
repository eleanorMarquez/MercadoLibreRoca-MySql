package Clases;

public class index extends javax.swing.JFrame {

    public index() {
        initComponents();
        super.setLocationRelativeTo(null);
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabel1 = new javax.swing.JLabel();
        jMenuBar1 = new javax.swing.JMenuBar();
        jMenu1 = new javax.swing.JMenu();
        JMI_Login = new javax.swing.JMenuItem();
        jMenuItem1 = new javax.swing.JMenuItem();
        jMenu3 = new javax.swing.JMenu();
        JMI_Exit = new javax.swing.JMenuItem();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setUndecorated(true);
        setResizable(false);

        jLabel1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/index.jpg"))); // NOI18N

        jMenuBar1.setBackground(new java.awt.Color(250, 250, 250));
        jMenuBar1.setBorder(null);
        jMenuBar1.setForeground(new java.awt.Color(255, 255, 255));

        jMenu1.setBackground(new java.awt.Color(250, 250, 250));
        jMenu1.setForeground(new java.awt.Color(0, 141, 167));
        jMenu1.setText("INGRESAR");
        jMenu1.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N

        JMI_Login.setBackground(new java.awt.Color(250, 250, 250));
        JMI_Login.setForeground(new java.awt.Color(0, 141, 167));
        JMI_Login.setText("Iniciar Sesión");
        JMI_Login.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                JMI_LoginActionPerformed(evt);
            }
        });
        jMenu1.add(JMI_Login);

        jMenuItem1.setForeground(new java.awt.Color(0, 141, 167));
        jMenuItem1.setText("Registrarse");
        jMenuItem1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItem1ActionPerformed(evt);
            }
        });
        jMenu1.add(jMenuItem1);

        jMenuBar1.add(jMenu1);

        jMenu3.setBackground(new java.awt.Color(250, 250, 250));
        jMenu3.setForeground(new java.awt.Color(0, 141, 167));
        jMenu3.setText("SALIR");
        jMenu3.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N

        JMI_Exit.setBackground(new java.awt.Color(250, 250, 250));
        JMI_Exit.setForeground(new java.awt.Color(0, 141, 167));
        JMI_Exit.setText("Salir");
        JMI_Exit.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                JMI_ExitActionPerformed(evt);
            }
        });
        jMenu3.add(JMI_Exit);

        jMenuBar1.add(jMenu3);

        setJMenuBar(jMenuBar1);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jLabel1)
                .addGap(0, 0, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jLabel1)
                .addGap(0, 0, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void JMI_ExitActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_JMI_ExitActionPerformed
        System.exit(0);
    }//GEN-LAST:event_JMI_ExitActionPerformed

    private void JMI_LoginActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_JMI_LoginActionPerformed
        login indice=new login();
        indice.setVisible(true);
        dispose();
    }//GEN-LAST:event_JMI_LoginActionPerformed

    private void jMenuItem1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItem1ActionPerformed
        registrar indice=new registrar();
        indice.setVisible(true);
        dispose();
    }//GEN-LAST:event_jMenuItem1ActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JMenuItem JMI_Exit;
    private javax.swing.JMenuItem JMI_Login;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JMenu jMenu1;
    private javax.swing.JMenu jMenu3;
    private javax.swing.JMenuBar jMenuBar1;
    private javax.swing.JMenuItem jMenuItem1;
    // End of variables declaration//GEN-END:variables
}
