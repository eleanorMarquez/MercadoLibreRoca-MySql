
package Clases;

import com.itextpdf.text.Document;
import com.itextpdf.text.Paragraph;
import com.itextpdf.text.Font;
import com.itextpdf.text.pdf.PdfWriter;
import com.mysql.jdbc.Statement;
import java.io.File;
import java.io.FileOutputStream;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import javax.swing.JFileChooser;
import javax.swing.JOptionPane;

public class RFactura extends javax.swing.JDialog {
    ConexionBD conexion= new ConexionBD();////// llamandio base de datos
    Connection Llamar= conexion.conexion();///// llamandio base de datos 
    
   Font fuente = new Font();
   ImpFactura traer;
    public RFactura(productos miCompra, boolean modal) {
        super(miCompra, modal);
        traer=new ImpFactura();
        initComponents();
        super.setLocationRelativeTo(null);
        iniciar();
        btnImprimir.setEnabled(false);
    }
    
     void iniciar(){               
        txtFactura.setText(traer.getFACTURA());
    }     
     void limpiar(){
        txtFactura.setText("");
        txtRuta.setText("");
        btnImprimir.setEnabled(false);
     }
     void Salir(){
        traer.setFACTURA( ">>No guardo factura para exportar<<");        
        this.dispose();
     }
     
    public void llamarTablaFinal(int idusuario,int idfactura){
        String []factura = new String [10];
        String SQL="SELECT f.id_factura,f.total_factura,u.nombres_usuario,u.apellidos_usuario,u.id_usuario,a.nombre_articulo,a.perecio_artuculo,a.marca_articulo,dtf.cantidad_detalle,dtf.totalcomproducto_detalle FROM detalle_factura AS dtf INNER JOIN articulo AS a ON dtf.id_articulo = a.id_articulo INNER JOIN factura AS f ON dtf.id_factura = f.id_factura INNER JOIN usuario AS u ON f.id_usuario = f.id_usuario WHERE dtf.id_factura = '"+idusuario+"' AND u.id_usuario = '"+idfactura+"'";
        String []datos = new String [10];
            try {
                Statement st = (Statement) Llamar.createStatement();
                ResultSet rs = st.executeQuery(SQL);
                String id_factura="";
                String total_factura="";
                String nombreuser="";
                String apellidouser="";
                String id_usuario="";
                String nombre_articulo="";
                String precio_articulo="";
                String marca_articulo="";
                String cantidad_detalle="";
                String totalComPro="";
                while(rs.next()){
                    datos[0]=rs.getString(1);
                    datos[1]=rs.getString(2);
                    datos[2]=rs.getString(3);
                    datos[3]=rs.getString(4);
                    datos[4]=rs.getString(5);
                    datos[5]=rs.getString(6);
                    datos[6]=rs.getString(7);
                    datos[7]=rs.getString(8);
                    datos[8]=rs.getString(9);
                    datos[9]=rs.getString(10);
                    if(datos[0]!=""){
                        id_factura=datos[0];
                        total_factura=datos[1];
                        nombreuser=datos[2];
                        apellidouser=datos[3];
                        id_usuario=datos[4];
                        nombre_articulo=datos[5];
                        precio_articulo=datos[6];
                        marca_articulo=datos[7];
                        cantidad_detalle=datos[8];
                        totalComPro=datos[9];
                        factura[0]=""+id_factura + total_factura + nombreuser + apellidouser + id_usuario + nombre_articulo + precio_articulo + cantidad_detalle + marca_articulo + totalComPro+"\n";
                    }else if(datos[0]==null){
                        factura[0]="";
                    }
                }
            } catch (SQLException e) {
                JOptionPane.showMessageDialog(null,"Error al llamar llamarTablaFinal "+e);
            }
        
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabel1 = new javax.swing.JLabel();
        txtRuta = new javax.swing.JTextField();
        btnBuscarR = new javax.swing.JButton();
        jScrollPane1 = new javax.swing.JScrollPane();
        txtFactura = new javax.swing.JTextArea();
        btnImprimir = new javax.swing.JButton();
        jLabel2 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setTitle("FACTURA");
        setBackground(new java.awt.Color(0, 153, 153));
        setUndecorated(true);
        setResizable(false);
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel1.setFont(new java.awt.Font("Tahoma", 1, 24)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(0, 141, 167));
        jLabel1.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel1.setText("REPORTE FACTURA");
        getContentPane().add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(210, 10, -1, -1));
        getContentPane().add(txtRuta, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 60, 630, -1));

        btnBuscarR.setBackground(new java.awt.Color(255, 255, 255));
        btnBuscarR.setForeground(new java.awt.Color(0, 102, 102));
        btnBuscarR.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/disquete.png"))); // NOI18N
        btnBuscarR.setText("  Guardar Factura En >>");
        btnBuscarR.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnBuscarRActionPerformed(evt);
            }
        });
        getContentPane().add(btnBuscarR, new org.netbeans.lib.awtextra.AbsoluteConstraints(460, 92, 180, -1));

        txtFactura.setEditable(false);
        txtFactura.setColumns(20);
        txtFactura.setFont(new java.awt.Font("Arial", 0, 10)); // NOI18N
        txtFactura.setRows(5);
        jScrollPane1.setViewportView(txtFactura);

        getContentPane().add(jScrollPane1, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 135, 630, 272));

        btnImprimir.setBackground(new java.awt.Color(255, 255, 255));
        btnImprimir.setForeground(new java.awt.Color(0, 153, 153));
        btnImprimir.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/impresora.png"))); // NOI18N
        btnImprimir.setText("  Imprimir");
        btnImprimir.setToolTipText("");
        btnImprimir.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnImprimirActionPerformed(evt);
            }
        });
        getContentPane().add(btnImprimir, new org.netbeans.lib.awtextra.AbsoluteConstraints(527, 418, 113, -1));

        jLabel2.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/PrintFac.JPG"))); // NOI18N
        getContentPane().add(jLabel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, -1, -1));

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btnBuscarRActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnBuscarRActionPerformed
        
        JOptionPane.showMessageDialog(null,"Selecciona la carpeta en la cual vas a guardar la factura"
                                         + "\n y digita el nombre de la factura a guardar"," AYUDA ",-1);
        JFileChooser dialogo=new JFileChooser();
        int option= dialogo.showSaveDialog(this);
        if(option==JFileChooser.APPROVE_OPTION){
            File archivo=dialogo.getSelectedFile();
            txtRuta.setText(archivo.toString());
            btnImprimir.setEnabled(true);
        }
    }//GEN-LAST:event_btnBuscarRActionPerformed

    private void btnImprimirActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnImprimirActionPerformed

        String ruta=txtRuta.getText();
        String factura=txtFactura.getText();

        try {
            FileOutputStream archivo=new FileOutputStream(ruta+".pdf");
            Document doc=new Document();
            PdfWriter.getInstance(doc, archivo);
            fuente.setSize(10);
            doc.open();
            doc.add(new Paragraph(factura,fuente));
            doc.close();
            limpiar();
            Salir();

        } catch (Exception e) {
            JOptionPane.showMessageDialog(null,"ERROR"+ e);
        }
    }//GEN-LAST:event_btnImprimirActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnBuscarR;
    private javax.swing.JButton btnImprimir;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JScrollPane jScrollPane1;
    public static javax.swing.JTextArea txtFactura;
    public static javax.swing.JTextField txtRuta;
    // End of variables declaration//GEN-END:variables

  
}
