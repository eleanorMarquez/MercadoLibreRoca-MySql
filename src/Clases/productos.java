
package Clases;

import com.mysql.jdbc.Statement;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Timestamp;
import java.util.Date;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.Icon;
import javax.swing.ImageIcon;
import javax.swing.JOptionPane;


public class productos extends javax.swing.JFrame {
    Icon logout; // Variable para la imagen del cierre de sesion.
    
    ConexionBD conexion= new ConexionBD();////// llamandio base de datos
    Connection Llamar= conexion.conexion();///// llamandio base de datos 
    
    datos llamaruser=new datos();
    
    int sum,res,con,sum1,res1,con1;///  variables para el evento de agregar o quitar.
    int sum2,res2,con2,sum3,res3,con3;//variables para el evento de agregar o quitar.
    int sum4,res4,con4,sum5,res5,con5;//variables para el evento de agregar o quitar.
    int sum6,res6,con6,sum7,res7,con7;//variables para el evento de agregar o quitar.
    int sum8,res8,con8,sum9,res9,con9;//variables para el evento de agregar o quitar.
    int sum10,res10,con10,sum11,res11,con11;//variables para el evento de agregar o quitar.
    int sum12,res12,con12,sum13,res13,con13;
    int sum14,res14,con14,sum15,res15,con15;
    int sum16,res16,con16,sum17,res17,con17;
    int sum18,res18,con18;
    int id_facturaAI;
    java.util.Date fecha = new Date();
    ImpFactura enviar=new ImpFactura();
    

    public productos() {
        System.out.println("id_usuario "+llamaruser.getUser());
        initComponents();
        super.setLocationRelativeTo(null);
        System.out.println("id_usuario "+llamaruser.getUser());
        logout=new ImageIcon("src/img/logout1.png");
        mostarcantidad();
        mostarPrecio();
        iniciar();
        btnDescontar1.setEnabled(false);
        btnDescontar2.setEnabled(false);
        btnDescontar3.setEnabled(false);
        btnDescontar4.setEnabled(false);
        btnDescontar5.setEnabled(false);
        btnDescontar6.setEnabled(false);
        btnDescontar7.setEnabled(false);
        btnDescontar8.setEnabled(false);
        btnDescontar9.setEnabled(false);
        btnDescontar10.setEnabled(false);
        btnDescontar11.setEnabled(false);
        btnDescontar12.setEnabled(false);
        btnDescontar13.setEnabled(false);
        btnDescontar14.setEnabled(false);
        btnDescontar15.setEnabled(false);
        btnDescontar16.setEnabled(false);
        btnDescontar17.setEnabled(false);
        btnDescontar18.setEnabled(false);
        //[980, 624] tamaño
    }
    
    
    public void iniciar(){
        if(lbCanIphone.getText().equals("0") && lbCanP20.getText().equals("0") && lbCanAsus.getText().equals("0") && lbCanHP.getText().equals("0") && lbCanLgTv.getText().equals("0") && lbCanSamTv.getText().equals("0") && 
           lbCanTiida.getText().equals("0") && lbCanSwift.getText().equals("0") && lbCanHightower.getText().equals("0") && lbCanSpark.getText().equals("0") && lbCanHonda.getText().equals("0") && lbCanYamaha.getText().equals("0")&&
           lbCanEstufa1.getText().equals("0") && lbCanEstufa2.getText().equals("0") && lbCanLavadora1.getText().equals("0") && lbCanLavadora2.getText().equals("0") && lbCanNevera1.getText().equals("0") && lbCanNevera2.getText().equals("0")) {
            JOptionPane.showMessageDialog(null," NO HAY PRODUCTOS DISPONIBLES PARA LA VENTA ");
            JMI_comprar.setEnabled(false);            
            btnAgregar1.setEnabled(false);
            btnAgregar2.setEnabled(false);
            btnAgregar3.setEnabled(false);
            btnAgregar4.setEnabled(false);
            btnAgregar5.setEnabled(false);
            btnAgregar6.setEnabled(false);
            btnAgregar7.setEnabled(false);
            btnAgregar8.setEnabled(false);
            btnAgregar9.setEnabled(false);
            btnAgregar10.setEnabled(false);
            btnAgregar11.setEnabled(false);
            btnAgregar12.setEnabled(false);
            btnAgregar13.setEnabled(false);
            btnAgregar14.setEnabled(false);
            btnAgregar15.setEnabled(false);
            btnAgregar16.setEnabled(false);
            btnAgregar17.setEnabled(false);
            btnAgregar18.setEnabled(false);
        }else{
            if(lbCanIphone.getText().equals("0")){
                btnAgregar1.setEnabled(false);
            }if(lbCanP20.getText().equals("0")){
                btnAgregar2.setEnabled(false);
            }if(lbCanAsus.getText().equals("0")){
                btnAgregar3.setEnabled(false);
            }if(lbCanHP.getText().equals("0")){
                btnAgregar4.setEnabled(false);
            }if(lbCanLgTv.getText().equals("0")){
                btnAgregar5.setEnabled(false);
            }if(lbCanSamTv.getText().equals("0")){
                btnAgregar6.setEnabled(false);
            }if(lbCanTiida.getText().equals("0")){
                btnAgregar7.setEnabled(false);
            }if(lbCanSwift.getText().equals("0")){
                btnAgregar8.setEnabled(false);
            }if(lbCanHightower.getText().equals("0")){
                btnAgregar9.setEnabled(false);
            }if(lbCanSpark.getText().equals("0")){
                btnAgregar10.setEnabled(false);
            }if(lbCanHonda.getText().equals("0")){
                btnAgregar11.setEnabled(false);
            }if(lbCanYamaha.getText().equals("0")){
                btnAgregar12.setEnabled(false);
            }if(lbCanEstufa1.getText().equals("0")){
                btnAgregar13.setEnabled(false);
            }if(lbCanEstufa2.getText().equals("0")){
                btnAgregar14.setEnabled(false);
            }if(lbCanLavadora1.getText().equals("0")){
                btnAgregar15.setEnabled(false);
            }if(lbCanLavadora2.getText().equals("0")){
                btnAgregar16.setEnabled(false);
            }if(lbCanNevera1.getText().equals("0")){
                btnAgregar17.setEnabled(false);
            }if(lbCanNevera2.getText().equals("0")){
                btnAgregar18.setEnabled(false);
            }
        }        
    }
    
    public void VenderCelular1(){        
        try {
        java.sql.PreparedStatement pst = Llamar.prepareStatement("UPDATE articulo SET cantidad_articulo='"+lbCanIphone.getText()+"' WHERE id_articulo='"+111+"'");
        pst.executeUpdate();
        } catch (SQLException e) {
            System.out.print(e.getMessage());
        }
    }
    public void VenderCelular2(){
        try {
        java.sql.PreparedStatement pst = Llamar.prepareStatement("UPDATE articulo SET cantidad_articulo='"+lbCanP20.getText()+"' WHERE id_articulo='"+112+"'");
        pst.executeUpdate();
        } catch (SQLException e) {
            System.out.print(e.getMessage());
        }
    }
    public void VenderLaptop1(){
        try {
        java.sql.PreparedStatement pst = Llamar.prepareStatement("UPDATE articulo SET cantidad_articulo='"+lbCanAsus.getText()+"' WHERE id_articulo='"+121+"'");
        pst.executeUpdate();
        } catch (SQLException e) {
            System.out.print(e.getMessage());
        }
    }
    public void VenderLaptop2(){
        try {
        java.sql.PreparedStatement pst = Llamar.prepareStatement("UPDATE articulo SET cantidad_articulo='"+lbCanHP.getText()+"' WHERE id_articulo='"+122+"'");
        pst.executeUpdate();
        } catch (SQLException e) {
            System.out.print(e.getMessage());
        }
    }
    public void VenderTv1(){
        try {
        java.sql.PreparedStatement pst = Llamar.prepareStatement("UPDATE articulo SET cantidad_articulo='"+lbCanLgTv.getText()+"' WHERE id_articulo='"+131+"'");
        pst.executeUpdate();
        } catch (SQLException e) {
            System.out.print(e.getMessage());
        }
    }
    public void VenderTv2(){
        try {
        java.sql.PreparedStatement pst = Llamar.prepareStatement("UPDATE articulo SET cantidad_articulo='"+lbCanSamTv.getText()+"' WHERE id_articulo='"+132+"'");
        pst.executeUpdate();
        } catch (SQLException e) {
            System.out.print(e.getMessage());
        }
    }
    public void VenderCarro1(){
        try {
        java.sql.PreparedStatement pst = Llamar.prepareStatement("UPDATE articulo SET cantidad_articulo='"+lbCanTiida.getText()+"' WHERE id_articulo='"+211+"'");
        pst.executeUpdate();
        } catch (SQLException e) {
            System.out.print(e.getMessage());
        }
    }
    public void VenderCarro2(){
        try {
        java.sql.PreparedStatement pst = Llamar.prepareStatement("UPDATE articulo SET cantidad_articulo='"+lbCanSwift.getText()+"' WHERE id_articulo='"+212+"'");
        pst.executeUpdate();
        } catch (SQLException e) {
            System.out.print(e.getMessage());
        }
    }
    public void VenderCicla1(){
        try {
        java.sql.PreparedStatement pst = Llamar.prepareStatement("UPDATE articulo SET cantidad_articulo='"+lbCanHightower.getText()+"' WHERE id_articulo='"+221+"'");
        pst.executeUpdate();
        } catch (SQLException e) {
            System.out.print(e.getMessage());
        }
    }
    public void VenderCicla2(){
        try {
        java.sql.PreparedStatement pst = Llamar.prepareStatement("UPDATE articulo SET cantidad_articulo='"+lbCanSpark.getText()+"' WHERE id_articulo='"+222+"'");
        pst.executeUpdate();
        } catch (SQLException e) {
            System.out.print(e.getMessage());
        }
    }
    public void VenderHonda(){
        try {
        java.sql.PreparedStatement pst = Llamar.prepareStatement("UPDATE articulo SET cantidad_articulo='"+lbCanHonda.getText()+"' WHERE id_articulo='"+231+"'");
        pst.executeUpdate();
        } catch (SQLException e) {
            System.out.print(e.getMessage());
        }
    }
    public void VenderYamaha(){
        try {
        java.sql.PreparedStatement pst = Llamar.prepareStatement("UPDATE articulo SET cantidad_articulo='"+lbCanYamaha.getText()+"' WHERE id_articulo='"+232+"'");
        pst.executeUpdate();
        } catch (SQLException e) {
            System.out.print(e.getMessage());
        }
    }
    public void VenderEstufa1(){
        try {
        java.sql.PreparedStatement pst = Llamar.prepareStatement("UPDATE articulo SET cantidad_articulo='"+lbCanEstufa1.getText()+"' WHERE id_articulo='"+311+"'");
        pst.executeUpdate();
        } catch (SQLException e) {
            System.out.print(e.getMessage());
        }
    }
    public void VenderEstufa2(){
        try {
        java.sql.PreparedStatement pst = Llamar.prepareStatement("UPDATE articulo SET cantidad_articulo='"+lbCanEstufa2.getText()+"' WHERE id_articulo='"+312+"'");
        pst.executeUpdate();
        } catch (SQLException e) {
            System.out.print(e.getMessage());
        }
    }    
    public void VenderLavadora1(){
        try {
        java.sql.PreparedStatement pst = Llamar.prepareStatement("UPDATE articulo SET cantidad_articulo='"+lbCanNevera1.getText()+"' WHERE id_articulo='"+321+"'");
        pst.executeUpdate();
        } catch (SQLException e) {
            System.out.print(e.getMessage());
        }
    }
    public void VenderLavadora2(){
        try {
        java.sql.PreparedStatement pst = Llamar.prepareStatement("UPDATE articulo SET cantidad_articulo='"+lbCanNevera2.getText()+"' WHERE id_articulo='"+322+"'");
        pst.executeUpdate();
        } catch (SQLException e) {
            System.out.print(e.getMessage());
        }
    }
    public void VenderNevera1(){
        try {
        java.sql.PreparedStatement pst = Llamar.prepareStatement("UPDATE articulo SET cantidad_articulo='"+lbCanLavadora1.getText()+"' WHERE id_articulo='"+331+"'");
        pst.executeUpdate();
        } catch (SQLException e) {
            System.out.print(e.getMessage());
        }
    }
    public void VenderNevera2(){
        try {
        java.sql.PreparedStatement pst = Llamar.prepareStatement("UPDATE articulo SET cantidad_articulo='"+lbCanLavadora2.getText()+"' WHERE id_articulo='"+332+"'");
        pst.executeUpdate();
        } catch (SQLException e) {
            System.out.print(e.getMessage());
        }
    }
    
    public void mostarcantidad(){
        String iphonex="SELECT cantidad_articulo FROM articulo WHERE id_articulo='"+111+"'";    
        String []datos = new String [1];
        try {
            Statement st = (Statement) Llamar.createStatement();
            ResultSet rs = st.executeQuery(iphonex);
            String iphone="";
            while(rs.next()){
                datos[0]=rs.getString(1);
                if(Integer.parseInt(datos[0])>0){
                    iphone=datos[0];
                    lbCanIphone.setText(""+iphone);
                }else if(datos[0]==null){
                    lbCanIphone.setText("0");
                }
            }
            
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null,"Error al llamar cantidad "+e);
        }
        ///////////////////////////////////////////////////////////////////////
        String p20pro="SELECT cantidad_articulo FROM articulo WHERE id_articulo='"+112+"'"; 
        String []datos1 = new String [1];
        try {
            Statement st = (Statement) Llamar.createStatement();
            ResultSet rs = st.executeQuery(p20pro);
            String P20="";
            while(rs.next()){
                datos1[0]=rs.getString(1);
                if(Integer.parseInt(datos1[0])>0){
                    P20=datos1[0];
                    lbCanP20.setText(""+P20);
                }else if(datos1[0]==null){
                    lbCanP20.setText("0");
                }
            }
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null,"Error al llamar cantidad "+e);
        }
        ///////////////////////////////////////////////////////////////////////
        String comasus="SELECT cantidad_articulo FROM articulo WHERE id_articulo='"+121+"'"; 
        String []datos2 = new String [1];
        try {
            Statement st = (Statement) Llamar.createStatement();
            ResultSet rs = st.executeQuery(comasus);
            String asus="";
            while(rs.next()){
                datos2[0]=rs.getString(1);
                if(Integer.parseInt(datos2[0])>0){
                    asus=datos2[0];
                    lbCanAsus.setText(""+asus);
                }else if(datos2[0]==null){
                    lbCanAsus.setText("0");
                }
            }
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null,"Error al llamar cantidad "+e);
        }
        ///////////////////////////////////////////////////////////////////////
        String comhp="SELECT cantidad_articulo FROM articulo WHERE id_articulo='"+122+"'"; 
        String []datos3 = new String [1];
        try {
            Statement st = (Statement) Llamar.createStatement();
            ResultSet rs = st.executeQuery(comhp);
            String hp="";
            while(rs.next()){
                datos3[0]=rs.getString(1);
                if(Integer.parseInt(datos3[0])>0){
                    hp=datos3[0];
                    lbCanHP.setText(""+hp);
                }else if(datos3[0]==null){
                    lbCanHP.setText("0");
                }
            }
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null,"Error al llamar cantidad "+e);
        }
        ///////////////////////////////////////////////////////////////////////
        String tvlg="SELECT cantidad_articulo FROM articulo WHERE id_articulo='"+131+"'"; 
        String []datos4 = new String [1];
        try {
            Statement st = (Statement) Llamar.createStatement();
            ResultSet rs = st.executeQuery(tvlg);
            String lgtv="";
            while(rs.next()){
                datos4[0]=rs.getString(1);
                if(Integer.parseInt(datos4[0])>0){
                    lgtv=datos4[0];
                    lbCanLgTv.setText(""+lgtv);
                }else if(datos4[0]==null){
                    lbCanLgTv.setText("0");
                }
            }
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null,"Error al llamar cantidad "+e);
        }
        ///////////////////////////////////////////////////////////////////////
        String tvsams="SELECT cantidad_articulo FROM articulo WHERE id_articulo='"+132+"'"; 
        String []datos5 = new String [1];
        try {
            Statement st = (Statement) Llamar.createStatement();
            ResultSet rs = st.executeQuery(tvsams);
            String samtv="";
            while(rs.next()){
                datos5[0]=rs.getString(1);
                if(Integer.parseInt(datos5[0])>0){
                    samtv=datos5[0];
                    lbCanSamTv.setText(""+samtv);
                }else if(datos5[0]==null){
                    lbCanSamTv.setText("0");
                }
            }
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null,"Error al llamar cantidad "+e);
        }
        ////////////////////////////// VEHICULOS ///////////////////////////////
        String carrotiida="SELECT cantidad_articulo FROM articulo WHERE id_articulo='"+211+"'"; 
        String []datos6 = new String [1];
        try {
            Statement st = (Statement) Llamar.createStatement();
            ResultSet rs = st.executeQuery(carrotiida);
            String tiida="";
            while(rs.next()){
                datos6[0]=rs.getString(1);
                if(Integer.parseInt(datos6[0])>0){
                    tiida=datos6[0];
                    lbCanTiida.setText(""+tiida);
                }else if(datos6[0]==null){
                    lbCanTiida.setText("0");
                }
            }
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null,"Error al llamar cantidad "+e);
        }
        ///////////////////////////////////////////////////////////////////////
        String carroswift="SELECT cantidad_articulo FROM articulo WHERE id_articulo='"+212+"'"; 
        String []datos7 = new String [1];
        try {
            Statement st = (Statement) Llamar.createStatement();
            ResultSet rs = st.executeQuery(carroswift);
            String swift="";
            while(rs.next()){
                datos7[0]=rs.getString(1);
                if(Integer.parseInt(datos7[0])>0){
                    swift=datos7[0];
                    lbCanSwift.setText(""+swift);
                }else if(datos7[0]==null){
                    lbCanSwift.setText("0");
                }
            }
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null,"Error al llamar cantidad "+e);
        }
        ///////////////////////////////////////////////////////////////////////
        String ciclahight="SELECT cantidad_articulo FROM articulo WHERE id_articulo='"+221+"'"; 
        String []datos8 = new String [1];
        try {
            Statement st = (Statement) Llamar.createStatement();
            ResultSet rs = st.executeQuery(ciclahight);
            String High="";
            while(rs.next()){
                datos8[0]=rs.getString(1);
                if(Integer.parseInt(datos8[0])>0){
                    High=datos8[0];
                    lbCanHightower.setText(""+High);
                }else if(datos8[0]==null){
                    lbCanHightower.setText("0");
                }
            }
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null,"Error al llamar cantidad "+e);
        }
        ///////////////////////////////////////////////////////////////////////
        String ciclaspark="SELECT cantidad_articulo FROM articulo WHERE id_articulo='"+222+"'"; 
        String []datos9 = new String [1];
        try {
            Statement st = (Statement) Llamar.createStatement();
            ResultSet rs = st.executeQuery(ciclaspark);
            String spark="";
            while(rs.next()){
                datos9[0]=rs.getString(1);
                if(Integer.parseInt(datos9[0])>0){
                    spark=datos9[0];
                    lbCanSpark.setText(""+spark);
                }else if(datos9[0]==null){
                    lbCanSpark.setText("0");
                }
            }
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null,"Error al llamar cantidad "+e);
        }
        ///////////////////////////////////////////////////////////////////////
        String motohonda="SELECT cantidad_articulo FROM articulo WHERE id_articulo='"+231+"'"; 
        String []datos10 = new String [1];
        try {
            Statement st = (Statement) Llamar.createStatement();
            ResultSet rs = st.executeQuery(motohonda);
            String crf="";
            while(rs.next()){
                datos10[0]=rs.getString(1);
                if(Integer.parseInt(datos10[0])>0){
                    crf=datos10[0];
                    lbCanHonda.setText(""+crf);
                }else if(datos10[0]==null){
                    lbCanHonda.setText("0");
                }
            }
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null,"Error al llamar cantidad "+e);
        }
        ///////////////////////////////////////////////////////////////////////
        String motoyamaha="SELECT cantidad_articulo FROM articulo WHERE id_articulo='"+232+"' "; 
        String []datos11 = new String [1];
        try {
            Statement st = (Statement) Llamar.createStatement();
            ResultSet rs = st.executeQuery(motoyamaha);
            String xtz="";
            while(rs.next()){
                datos11[0]=rs.getString(1);
                if(Integer.parseInt(datos11[0])>0){
                    xtz=datos11[0];
                    lbCanYamaha.setText(""+xtz);
                }else if(datos11[0]==null){
                    lbCanYamaha.setText("0");
                }
            }
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null,"Error al llamar cantidad "+e);
        }
        ////////////////////////////// HOGAR ///////////////////////////////
        String estufa1="SELECT cantidad_articulo FROM articulo WHERE id_articulo='"+311+"'"; 
        String []datos12 = new String [1];
        try {
            Statement st = (Statement) Llamar.createStatement();
            ResultSet rs = st.executeQuery(estufa1);
            String estufakob="";
            while(rs.next()){
                datos12[0]=rs.getString(1);
                if(Integer.parseInt(datos12[0])>0){
                    estufakob=datos12[0];
                    lbCanEstufa1.setText(""+estufakob);
                }else if(datos12[0]==null){
                    lbCanEstufa1.setText("0");
                }
            }
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null,"Error al llamar cantidad "+e);
        }
        ///////////////////////////////////////////////////////////////////////
        String estufa2="SELECT cantidad_articulo FROM articulo WHERE id_articulo='"+312+"'"; 
        String []datos13 = new String [1];
        try {
            Statement st = (Statement) Llamar.createStatement();
            ResultSet rs = st.executeQuery(estufa2);
            String estufaabba="";
            while(rs.next()){
                datos13[0]=rs.getString(1);
                if(Integer.parseInt(datos13[0])>0){
                    estufaabba=datos13[0];
                    lbCanEstufa2.setText(""+estufaabba);
                }else if(datos13[0]==null){
                    lbCanEstufa2.setText("0");
                }
            }
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null,"Error al llamar cantidad "+e);
        }
        ///////////////////////////////////////////////////////////////////////
        String lavadora1="SELECT cantidad_articulo FROM articulo WHERE id_articulo='"+321+"'"; 
        String []datos14 = new String [1];
        try {
            Statement st = (Statement) Llamar.createStatement();
            ResultSet rs = st.executeQuery(lavadora1);
            String lavadoralg="";
            while(rs.next()){
                datos14[0]=rs.getString(1);
                if(Integer.parseInt(datos14[0])>0){
                    lavadoralg=datos14[0];
                    lbCanLavadora1.setText(""+lavadoralg);
                }else if(datos14[0]==null){
                    lbCanLavadora1.setText("0");
                }
            }
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null,"Error al llamar cantidad "+e);
        }
        ///////////////////////////////////////////////////////////////////////
        String lavadora2="SELECT cantidad_articulo FROM articulo WHERE id_articulo='"+322+"'"; 
        String []datos15 = new String [1];
        try {
            Statement st = (Statement) Llamar.createStatement();
            ResultSet rs = st.executeQuery(lavadora2);
            String lavadorasam="";
            while(rs.next()){
                datos15[0]=rs.getString(1);
                if(Integer.parseInt(datos15[0])>0){
                    lavadorasam=datos15[0];
                    lbCanLavadora2.setText(""+lavadorasam);
                }else if(datos15[0]==null){
                    lbCanLavadora2.setText("0");
                }
            }
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null,"Error al llamar cantidad "+e);
        }
        ///////////////////////////////////////////////////////////////////////
        String nuevera1="SELECT cantidad_articulo FROM articulo WHERE id_articulo='"+331+"'"; 
        String []datos16 = new String [1];
        try {
            Statement st = (Statement) Llamar.createStatement();
            ResultSet rs = st.executeQuery(nuevera1);
            String nueveralg="";
            while(rs.next()){
                datos16[0]=rs.getString(1);
                if(Integer.parseInt(datos16[0])>0){
                    nueveralg=datos16[0];
                    lbCanNevera1.setText(""+nueveralg);
                }else if(datos16[0]==null){
                    lbCanNevera1.setText("0");
                }
            }
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null,"Error al llamar cantidad "+e);
        }
        ///////////////////////////////////////////////////////////////////////
        String nuevera2="SELECT cantidad_articulo FROM articulo WHERE id_articulo='"+332+"' "; 
        String []datos17 = new String [1];
        try {
            Statement st = (Statement) Llamar.createStatement();
            ResultSet rs = st.executeQuery(nuevera2);
            String nueverasams="";
            while(rs.next()){
                datos17[0]=rs.getString(1);
                if(Integer.parseInt(datos17[0])>0){
                    nueverasams=datos17[0];
                    lbCanNevera2.setText(""+nueverasams);
                }else if(datos17[0]==null){
                    lbCanNevera2.setText("0");
                }
            }
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null,"Error al llamar cantidad "+e);
        }
    }
    public void mostarPrecio(){
        String iphonex="SELECT precio_articulo FROM articulo WHERE id_articulo='"+111+"'";    
        String []datos = new String [1];
        try {
            Statement st = (Statement) Llamar.createStatement();
            ResultSet rs = st.executeQuery(iphonex);
            String iphone="";
            while(rs.next()){
                datos[0]=rs.getString(1);
                if(Integer.parseInt(datos[0])>0){
                    iphone=datos[0];
                    jlPrecio1.setText(""+iphone);
                }else if(datos[0]==null){
                    jlPrecio1.setText("0");
                }
            }
            
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null,"Error al llamar cantidad "+e);
        }
        ///////////////////////////////////////////////////////////////////////
        String p20pro="SELECT precio_articulo FROM articulo WHERE id_articulo='"+112+"'"; 
        String []datos1 = new String [1];
        try {
            Statement st = (Statement) Llamar.createStatement();
            ResultSet rs = st.executeQuery(p20pro);
            String P20="";
            while(rs.next()){
                datos1[0]=rs.getString(1);
                if(Integer.parseInt(datos1[0])>0){
                    P20=datos1[0];
                    jlPrecio2.setText(""+P20);
                }else if(datos1[0]==null){
                    jlPrecio2.setText("0");
                }
            }
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null,"Error al llamar cantidad "+e);
        }
        ///////////////////////////////////////////////////////////////////////
        String comasus="SELECT precio_articulo FROM articulo WHERE id_articulo='"+121+"'"; 
        String []datos2 = new String [1];
        try {
            Statement st = (Statement) Llamar.createStatement();
            ResultSet rs = st.executeQuery(comasus);
            String asus="";
            while(rs.next()){
                datos2[0]=rs.getString(1);
                if(Integer.parseInt(datos2[0])>0){
                    asus=datos2[0];
                    jlPrecio3.setText(""+asus);
                }else if(datos2[0]==null){
                    jlPrecio3.setText("0");
                }
            }
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null,"Error al llamar cantidad "+e);
        }
        ///////////////////////////////////////////////////////////////////////
        String comhp="SELECT precio_articulo FROM articulo WHERE id_articulo='"+122+"'"; 
        String []datos3 = new String [1];
        try {
            Statement st = (Statement) Llamar.createStatement();
            ResultSet rs = st.executeQuery(comhp);
            String hp="";
            while(rs.next()){
                datos3[0]=rs.getString(1);
                if(Integer.parseInt(datos3[0])>0){
                    hp=datos3[0];
                    jlPrecio4.setText(""+hp);
                }else if(datos3[0]==null){
                    jlPrecio4.setText("0");
                }
            }
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null,"Error al llamar cantidad "+e);
        }
        ///////////////////////////////////////////////////////////////////////
        String tvlg="SELECT precio_articulo FROM articulo WHERE id_articulo='"+131+"'"; 
        String []datos4 = new String [1];
        try {
            Statement st = (Statement) Llamar.createStatement();
            ResultSet rs = st.executeQuery(tvlg);
            String lgtv="";
            while(rs.next()){
                datos4[0]=rs.getString(1);
                if(Integer.parseInt(datos4[0])>0){
                    lgtv=datos4[0];
                    jlPrecio5.setText(""+lgtv);
                }else if(datos4[0]==null){
                    jlPrecio5.setText("0");
                }
            }
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null,"Error al llamar cantidad "+e);
        }
        ///////////////////////////////////////////////////////////////////////
        String tvsams="SELECT precio_articulo FROM articulo WHERE id_articulo='"+132+"'"; 
        String []datos5 = new String [1];
        try {
            Statement st = (Statement) Llamar.createStatement();
            ResultSet rs = st.executeQuery(tvsams);
            String samtv="";
            while(rs.next()){
                datos5[0]=rs.getString(1);
                if(Integer.parseInt(datos5[0])>0){
                    samtv=datos5[0];
                    jlPrecio6.setText(""+samtv);
                }else if(datos5[0]==null){
                    jlPrecio6.setText("0");
                }
            }
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null,"Error al llamar cantidad "+e);
        }
        ////////////////////////////// VEHICULOS ///////////////////////////////
        String carrotiida="SELECT precio_articulo FROM articulo WHERE id_articulo='"+211+"'"; 
        String []datos6 = new String [1];
        try {
            Statement st = (Statement) Llamar.createStatement();
            ResultSet rs = st.executeQuery(carrotiida);
            String tiida="";
            while(rs.next()){
                datos6[0]=rs.getString(1);
                if(Integer.parseInt(datos6[0])>0){
                    tiida=datos6[0];
                    jlPrecio7.setText(""+tiida);
                }else if(datos6[0]==null){
                    jlPrecio7.setText("0");
                }
            }
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null,"Error al llamar cantidad "+e);
        }
        ///////////////////////////////////////////////////////////////////////
        String carroswift="SELECT precio_articulo FROM articulo WHERE id_articulo='"+212+"'"; 
        String []datos7 = new String [1];
        try {
            Statement st = (Statement) Llamar.createStatement();
            ResultSet rs = st.executeQuery(carroswift);
            String swift="";
            while(rs.next()){
                datos7[0]=rs.getString(1);
                if(Integer.parseInt(datos7[0])>0){
                    swift=datos7[0];
                    jlPrecio8.setText(""+swift);
                }else if(datos7[0]==null){
                    jlPrecio8.setText("0");
                }
            }
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null,"Error al llamar cantidad "+e);
        }
        ///////////////////////////////////////////////////////////////////////
        String ciclahight="SELECT precio_articulo FROM articulo WHERE id_articulo='"+221+"'"; 
        String []datos8 = new String [1];
        try {
            Statement st = (Statement) Llamar.createStatement();
            ResultSet rs = st.executeQuery(ciclahight);
            String High="";
            while(rs.next()){
                datos8[0]=rs.getString(1);
                if(Integer.parseInt(datos8[0])>0){
                    High=datos8[0];
                    jlPrecio9.setText(""+High);
                }else if(datos8[0]==null){
                    jlPrecio9.setText("0");
                }
            }
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null,"Error al llamar cantidad "+e);
        }
        ///////////////////////////////////////////////////////////////////////
        String ciclaspark="SELECT precio_articulo FROM articulo WHERE id_articulo='"+222+"'"; 
        String []datos9 = new String [1];
        try {
            Statement st = (Statement) Llamar.createStatement();
            ResultSet rs = st.executeQuery(ciclaspark);
            String spark="";
            while(rs.next()){
                datos9[0]=rs.getString(1);
                if(Integer.parseInt(datos9[0])>0){
                    spark=datos9[0];
                    jlPrecio10.setText(""+spark);
                }else if(datos9[0]==null){
                    jlPrecio10.setText("0");
                }
            }
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null,"Error al llamar cantidad "+e);
        }
        ///////////////////////////////////////////////////////////////////////
        String motohonda="SELECT precio_articulo FROM articulo WHERE id_articulo='"+231+"'"; 
        String []datos10 = new String [1];
        try {
            Statement st = (Statement) Llamar.createStatement();
            ResultSet rs = st.executeQuery(motohonda);
            String crf="";
            while(rs.next()){
                datos10[0]=rs.getString(1);
                if(Integer.parseInt(datos10[0])>0){
                    crf=datos10[0];
                    jlPrecio11.setText(""+crf);
                }else if(datos10[0]==null){
                    jlPrecio11.setText("0");
                }
            }
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null,"Error al llamar cantidad "+e);
        }
        ///////////////////////////////////////////////////////////////////////
        String motoyamaha="SELECT precio_articulo FROM articulo WHERE id_articulo='"+232+"' "; 
        String []datos11 = new String [1];
        try {
            Statement st = (Statement) Llamar.createStatement();
            ResultSet rs = st.executeQuery(motoyamaha);
            String xtz="";
            while(rs.next()){
                datos11[0]=rs.getString(1);
                if(Integer.parseInt(datos11[0])>0){
                    xtz=datos11[0];
                    jlPrecio12.setText(""+xtz);
                }else if(datos11[0]==null){
                    jlPrecio12.setText("0");
                }
            }
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null,"Error al llamar cantidad "+e);
        }
        ////////////////////////////// HOGAR ///////////////////////////////
        String estufa1="SELECT precio_articulo FROM articulo WHERE id_articulo='"+311+"'"; 
        String []datos12 = new String [1];
        try {
            Statement st = (Statement) Llamar.createStatement();
            ResultSet rs = st.executeQuery(estufa1);
            String estufakob="";
            while(rs.next()){
                datos12[0]=rs.getString(1);
                if(Integer.parseInt(datos12[0])>0){
                    estufakob=datos12[0];
                    jlPrecio13.setText(""+estufakob);
                }else if(datos12[0]==null){
                    jlPrecio13.setText("0");
                }
            }
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null,"Error al llamar cantidad "+e);
        }
        ///////////////////////////////////////////////////////////////////////
        String estufa2="SELECT precio_articulo FROM articulo WHERE id_articulo='"+312+"'"; 
        String []datos13 = new String [1];
        try {
            Statement st = (Statement) Llamar.createStatement();
            ResultSet rs = st.executeQuery(estufa2);
            String estufaabba="";
            while(rs.next()){
                datos13[0]=rs.getString(1);
                if(Integer.parseInt(datos13[0])>0){
                    estufaabba=datos13[0];
                    jlPrecio14.setText(""+estufaabba);
                }else if(datos13[0]==null){
                    jlPrecio14.setText("0");
                }
            }
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null,"Error al llamar cantidad "+e);
        }
        ///////////////////////////////////////////////////////////////////////
        String lavadora1="SELECT precio_articulo FROM articulo WHERE id_articulo='"+321+"'"; 
        String []datos14 = new String [1];
        try {
            Statement st = (Statement) Llamar.createStatement();
            ResultSet rs = st.executeQuery(lavadora1);
            String lavadoralg="";
            while(rs.next()){
                datos14[0]=rs.getString(1);
                if(Integer.parseInt(datos14[0])>0){
                    lavadoralg=datos14[0];
                    jlPrecio15.setText(""+lavadoralg);
                }else if(datos14[0]==null){
                    jlPrecio15.setText("0");
                }
            }
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null,"Error al llamar cantidad "+e);
        }
        ///////////////////////////////////////////////////////////////////////
        String lavadora2="SELECT precio_articulo FROM articulo WHERE id_articulo='"+322+"'"; 
        String []datos15 = new String [1];
        try {
            Statement st = (Statement) Llamar.createStatement();
            ResultSet rs = st.executeQuery(lavadora2);
            String lavadorasam="";
            while(rs.next()){
                datos15[0]=rs.getString(1);
                if(Integer.parseInt(datos15[0])>0){
                    lavadorasam=datos15[0];
                    jlPrecio16.setText(""+lavadorasam);
                }else if(datos15[0]==null){
                    jlPrecio16.setText("0");
                }
            }
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null,"Error al llamar cantidad "+e);
        }
        ///////////////////////////////////////////////////////////////////////
        String nuevera1="SELECT precio_articulo FROM articulo WHERE id_articulo='"+331+"'"; 
        String []datos16 = new String [1];
        try {
            Statement st = (Statement) Llamar.createStatement();
            ResultSet rs = st.executeQuery(nuevera1);
            String nueveralg="";
            while(rs.next()){
                datos16[0]=rs.getString(1);
                if(Integer.parseInt(datos16[0])>0){
                    nueveralg=datos16[0];
                    jlPrecio17.setText(""+nueveralg);
                }else if(datos16[0]==null){
                    jlPrecio17.setText("0");
                }
            }
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null,"Error al llamar cantidad "+e);
        }
        ///////////////////////////////////////////////////////////////////////
        String nuevera2="SELECT precio_articulo FROM articulo WHERE id_articulo='"+332+"' "; 
        String []datos17 = new String [1];
        try {
            Statement st = (Statement) Llamar.createStatement();
            ResultSet rs = st.executeQuery(nuevera2);
            String nueverasams="";
            while(rs.next()){
                datos17[0]=rs.getString(1);
                if(Integer.parseInt(datos17[0])>0){
                    nueverasams=datos17[0];
                    jlPrecio18.setText(""+nueverasams);
                }else if(datos17[0]==null){
                    jlPrecio18.setText("0");
                }
            }
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null,"Error al llamar cantidad "+e);
        }
    }
    
    public void limpiar(){
        btnDescontar1.setEnabled(false);
        btnDescontar2.setEnabled(false);
        btnDescontar3.setEnabled(false);
        btnDescontar4.setEnabled(false);
        btnDescontar5.setEnabled(false);        
        btnDescontar6.setEnabled(false);
        btnDescontar7.setEnabled(false);
        btnDescontar8.setEnabled(false);
        btnDescontar9.setEnabled(false);
        btnDescontar10.setEnabled(false);
        btnDescontar11.setEnabled(false); 
        btnDescontar12.setEnabled(false);
        btnDescontar13.setEnabled(false); 
        btnDescontar14.setEnabled(false);
        btnDescontar15.setEnabled(false); 
        btnDescontar16.setEnabled(false);
        btnDescontar17.setEnabled(false); 
        btnDescontar18.setEnabled(false); 
        
        lbCanComIphone.setText("0");
        lbCanComP20.setText("0");
        lbCanComAsus.setText("0");
        lbCanComHP.setText("0");
        lbCanComLgTv.setText("0");
        lbCanComSamTv.setText("0");
        lbCanComTiida.setText("0");
        lbCanComSwift.setText("0");
        lbCanComHightower.setText("0");
        lbCanComSpark.setText("0");
        lbCanComHonda.setText("0");
        lbCanComYamaha.setText("0");
        lbCanComEstufa1.setText("0");
        lbCanComEstufa2.setText("0");
        lbCanComLavadora1.setText("0");
        lbCanComLavadora2.setText("0");
        lbCanComNevera1.setText("0");
        lbCanComNevera2.setText("0");
        
        sum=0;res=0;con=0;sum1=0;res1=0;con1=0;
        sum2=0;res2=0;con2=0;sum3=0;res3=0;con3=0;
        sum4=0;res4=0;con4=0;sum5=0;res5=0;con5=0;
        sum6=0;res6=0;con6=0;sum7=0;res7=0;con7=0;
        sum8=0;res8=0;con8=0;sum9=0;res9=0;con9=0;
        sum10=0;res10=0;con10=0;sum11=0;res11=0;con11=0;
        sum12=0;res12=0;con12=0;sum13=0;res13=0;con13=0;
        sum14=0;res14=0;con14=0;sum15=0;res15=0;con15=0;
        sum16=0;res16=0;con16=0;sum17=0;res17=0;con17=0;
        sum18=0;res18=0;con18=0;
    }
    
    public void pasar(){
       
       int confirmacion=JOptionPane.showConfirmDialog(null,"Quieres Imprimir el Recibo?");
       if(confirmacion==1 || confirmacion==2){
           enviar.setFACTURA( ">>No guardo factura para exportar<<");
       }else{
            productos miCompra=new productos();
            RFactura factura =new RFactura( miCompra, true);
            factura.setVisible(true);
       }
    }
    
    public void enviarFactura(){
        
        int Precio1=Integer.parseInt(jlPrecio1.getText())*Integer.parseInt(lbCanComIphone.getText()); 
        int Precio2=Integer.parseInt(jlPrecio2.getText())*Integer.parseInt(lbCanComP20.getText());
        int Precio3=Integer.parseInt(jlPrecio3.getText())*Integer.parseInt(lbCanComAsus.getText());
        int Precio4=Integer.parseInt(jlPrecio4.getText())*Integer.parseInt(lbCanComHP.getText());
        int Precio5=Integer.parseInt(jlPrecio5.getText())*Integer.parseInt(lbCanComLgTv.getText()); 
        int Precio6=Integer.parseInt(jlPrecio6.getText())*Integer.parseInt(lbCanComSamTv.getText());
        int Precio7=Integer.parseInt(jlPrecio7.getText())*Integer.parseInt(lbCanComTiida.getText());
        int Precio8=Integer.parseInt(jlPrecio8.getText())*Integer.parseInt(lbCanComSwift.getText()); 
        int Precio9=Integer.parseInt(jlPrecio9.getText())*Integer.parseInt(lbCanComHightower.getText());
        int Precio10=Integer.parseInt(jlPrecio10.getText())*Integer.parseInt(lbCanComSpark.getText());
        int Precio11=Integer.parseInt(jlPrecio11.getText())*Integer.parseInt(lbCanComHonda.getText()); 
        int Precio12=Integer.parseInt(jlPrecio12.getText())*Integer.parseInt(lbCanComYamaha.getText()); 
        int Precio13=Integer.parseInt(jlPrecio13.getText())*Integer.parseInt(lbCanComEstufa1.getText()); 
        int Precio14=Integer.parseInt(jlPrecio14.getText())*Integer.parseInt(lbCanComEstufa2.getText());
        int Precio15=Integer.parseInt(jlPrecio15.getText())*Integer.parseInt(lbCanComLavadora1.getText()); 
        int Precio16=Integer.parseInt(jlPrecio16.getText())*Integer.parseInt(lbCanComLavadora2.getText());
        int Precio17=Integer.parseInt(jlPrecio17.getText())*Integer.parseInt(lbCanComNevera1.getText()); 
        int Precio18=Integer.parseInt(jlPrecio18.getText())*Integer.parseInt(lbCanComNevera2.getText()); 
        int PrecioT=Precio1+Precio2+Precio11+Precio3+Precio4+Precio5+Precio6+Precio7+Precio8+Precio9+Precio10+Precio11+
            Precio12+Precio13+Precio14+Precio15+Precio16+Precio17+Precio18;
        Timestamp timestamp = new Timestamp(fecha.getTime());
        
        String SQLFac="select max(id_factura) from factura";        
          int ID=0;
        try {
           java.sql.Statement stF = Llamar.createStatement();
           ResultSet rsF=stF.executeQuery(SQLFac);
            while(rsF.next())
            {              
                 ID=rsF.getInt(1);
            }
           
            if(ID==0){
                id_facturaAI=1111;
            }
            else
            {
                id_facturaAI=(ID+1);                
            }
        } catch (SQLException ex) {
            Logger.getLogger(registrar.class.getName()).log(Level.SEVERE, null, ex);
        }
        try {
            
            PreparedStatement pst = (PreparedStatement) Llamar.prepareStatement("INSERT INTO factura(id_factura, id_usuario, fecha_factura, total_factura) VALUES(?,?,?,?)");
            pst.setInt(1, id_facturaAI);
            pst.setInt(2, llamaruser.getUser());
            pst.setTimestamp(3,  timestamp);
            pst.setInt(4, PrecioT);
            pst.executeUpdate();

        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null,"No se puede generar factura"+ex);
        } 
        
    }
    
    public void enviarDetalleF(int id_articulo, int id_factura,int cantidad,int precio){
        String SQLDFac="select max(	id_detallefactura) from detalle_factura";        
            int ID=0;
            int id_DfacturaAI=0;
            try {
               java.sql.Statement stF = Llamar.createStatement();
               ResultSet rsF=stF.executeQuery(SQLDFac);
                
                while(rsF.next())
                {              
                     ID=rsF.getInt(1);
                }

                if(ID==0){
                    id_DfacturaAI=111111;
                }
                else
                {
                    id_DfacturaAI=(ID+1);                
                }
            } catch (SQLException ex) {
                Logger.getLogger(registrar.class.getName()).log(Level.SEVERE, null, ex);
            }
            try {

                PreparedStatement pst = (PreparedStatement) Llamar.prepareStatement("INSERT INTO detalle_factura(id_detallefactura, id_articulo, id_factura, cantidad_detalle, totalcomproducto_detalle) VALUES(?,?,?,?,?)");
                pst.setInt(1, id_DfacturaAI);
                pst.setInt(2, id_articulo);
                pst.setInt(3, id_factura);
                pst.setInt(4, cantidad);
                pst.setInt(5, precio);
                pst.executeUpdate();
            } catch (SQLException ex) {
                JOptionPane.showMessageDialog(null,"No se puede generar DetallleFactura"+ex);
                System.out.println("error : "+ex);
            }
    }
    
    
    public void factura(){
        
        enviarFactura();
        
        String []factura = new String [18];
        int Precio1=0, Precio2=0, Precio3=0, Precio4=0, Precio5=0, Precio6=0,
            Precio7=0, Precio8=0, Precio9=0 ,Precio10=0, Precio11=0, Precio12=0,
            Precio13=0, Precio14=0, Precio15=0 ,Precio16=0, Precio17=0, Precio18=0;
        
        if(lbCanComIphone.getText().equals("0")){
            factura[0]="";
        }else{
            Precio1=Integer.parseInt(jlPrecio1.getText())*Integer.parseInt(lbCanComIphone.getText()); 
            String SQL="SELECT nombre_articulo,marca_articulo,categoria_articulo,precio_articulo FROM articulo WHERE id_articulo='"+111+"'";    
            String []datos = new String [4];
            try {
                Statement st = (Statement) Llamar.createStatement();
                ResultSet rs = st.executeQuery(SQL);
                String nombre="";
                String marca="";
                String categoria="";
                String precio="";
                while(rs.next()){
                    datos[0]=rs.getString(1);
                    datos[1]=rs.getString(2);
                    datos[2]=rs.getString(3);
                    datos[3]=rs.getString(4);
                    if(datos[0]!=""){
                        nombre=datos[0];
                        marca=datos[1];
                        categoria=datos[2];
                        precio=datos[3];
                        factura[0]="          "+lbCanComIphone.getText() + "                                   "+nombre+"                       "+marca+"                        "+precio+"                            "+Precio1+"\n";
                    }else if(datos[0]==null){
                        factura[0]="";
                    }
                }
            } catch (SQLException e) {
                JOptionPane.showMessageDialog(null,"Error al llamar cantidad "+e);
            }
           
            enviarDetalleF(111, id_facturaAI, Integer.parseInt(lbCanComIphone.getText()), Precio1);          
        }if(lbCanComP20.getText().equals("0")){
            factura[1]="";
        }else{
            Precio2=Integer.parseInt(jlPrecio2.getText())*Integer.parseInt(lbCanComP20.getText());
            String SQL="SELECT nombre_articulo,marca_articulo,categoria_articulo,precio_articulo FROM articulo WHERE id_articulo='"+112+"'";    
            String []datos = new String [5];
            try {                
                Statement st = (Statement) Llamar.createStatement();
                ResultSet rs = st.executeQuery(SQL);
                String nombre="";
                String marca="";
                String categoria="";
                String precio="";
                while(rs.next()){
                    datos[0]=rs.getString(1);
                    datos[1]=rs.getString(2);
                    datos[2]=rs.getString(3);
                    datos[3]=rs.getString(4);
                    if(datos[0]!=""){
                        nombre=datos[0];
                        marca=datos[1];
                        categoria=datos[2];
                        precio=datos[3];
                        factura[1]="          "+lbCanComP20.getText() + "                                   "+nombre+"                       "+marca+"                      "+precio+"                            "+Precio2+"\n";
                    }else if(datos[0]==null){
                        factura[1]="";
                    }
                }
            } catch (SQLException e) {
                JOptionPane.showMessageDialog(null,"Error al llamar cantidad "+e);
            }
                        
            enviarDetalleF(112, id_facturaAI, Integer.parseInt(lbCanComP20.getText()), Precio2);
        }if(lbCanComAsus.getText().equals("0")){
            factura[2]="";
        }else{
            Precio3=Integer.parseInt(jlPrecio3.getText())*Integer.parseInt(lbCanComAsus.getText()); 
            String SQL="SELECT nombre_articulo,marca_articulo,categoria_articulo,precio_articulo FROM articulo WHERE id_articulo='"+121+"'";    
            String []datos = new String [4];
            try {
                Statement st = (Statement) Llamar.createStatement();
                ResultSet rs = st.executeQuery(SQL);
                String nombre="";
                String marca="";
                String categoria="";
                String precio="";
                while(rs.next()){
                    datos[0]=rs.getString(1);
                    datos[1]=rs.getString(2);
                    datos[2]=rs.getString(3);
                    datos[3]=rs.getString(4);
                    if(datos[0]!=""){
                        nombre=datos[0];
                        marca=datos[1];
                        categoria=datos[2];
                        precio=datos[3];
                        factura[2]="          "+lbCanComAsus.getText() + "                               "+nombre+"                      "+marca+"                         "+precio+"                            "+Precio3+"\n";
                    }else if(datos[0]==null){
                        factura[2]="";
                    }
                }
            } catch (SQLException e) {
                JOptionPane.showMessageDialog(null,"Error al llamar cantidad "+e);
            }
               
            enviarDetalleF(121, id_facturaAI, Integer.parseInt(lbCanComAsus.getText()), Precio3);
        }if(lbCanComHP.getText().equals("0")){
            factura[3]="";
        }else{
            Precio4=Integer.parseInt(jlPrecio4.getText())*Integer.parseInt(lbCanComHP.getText());
            String SQL="SELECT nombre_articulo,marca_articulo,categoria_articulo,precio_articulo FROM articulo WHERE id_articulo='"+122+"'";    
            String []datos = new String [4];
            try {
                Statement st = (Statement) Llamar.createStatement();
                ResultSet rs = st.executeQuery(SQL);
                String nombre="";
                String marca="";
                String categoria="";
                String precio="";
                while(rs.next()){
                    datos[0]=rs.getString(1);
                    datos[1]=rs.getString(2);
                    datos[2]=rs.getString(3);
                    datos[3]=rs.getString(4);
                    if(datos[0]!=""){
                        nombre=datos[0];
                        marca=datos[1];
                        categoria=datos[2];
                        precio=datos[3];
                        factura[3]="          "+lbCanComHP.getText() + "                               "+nombre+"                        "+marca+"                          "+precio+"                            "+Precio4+"\n";
                    }else if(datos[0]==null){
                        factura[3]="";
                    }
                }
            } catch (SQLException e) {
                JOptionPane.showMessageDialog(null,"Error al llamar cantidad "+e);
            }
              
            enviarDetalleF(122, id_facturaAI, Integer.parseInt(lbCanComHP.getText()), Precio4);
        }if(lbCanComLgTv.getText().equals("0")){
            factura[4]="";
        }else{
            Precio5=Integer.parseInt(jlPrecio5.getText())*Integer.parseInt(lbCanComLgTv.getText());
            String SQL="SELECT nombre_articulo,marca_articulo,categoria_articulo,precio_articulo FROM articulo WHERE id_articulo='"+131+"'";    
            String []datos = new String [4];
            try {
                Statement st = (Statement) Llamar.createStatement();
                ResultSet rs = st.executeQuery(SQL);
                String nombre="";
                String marca="";
                String categoria="";
                String precio="";
                while(rs.next()){
                    datos[0]=rs.getString(1);
                    datos[1]=rs.getString(2);
                    datos[2]=rs.getString(3);
                    datos[3]=rs.getString(4);
                    if(datos[0]!=""){
                        nombre=datos[0];
                        marca=datos[1];
                        categoria=datos[2];
                        precio=datos[3];
                        factura[4]="          "+lbCanComLgTv.getText() + "                          "+nombre+"                   "+marca+"                          "+precio+"                            "+Precio5+"\n";
                    }else if(datos[0]==null){
                        factura[4]="";
                    }
                }
            } catch (SQLException e) {
                JOptionPane.showMessageDialog(null,"Error al llamar cantidad "+e);
            }
            
            enviarDetalleF(131, id_facturaAI, Integer.parseInt(lbCanComLgTv.getText()), Precio5);
        }if(lbCanComSamTv.getText().equals("0")){
            factura[5]="";
        }else{
            Precio6=Integer.parseInt(jlPrecio6.getText())*Integer.parseInt(lbCanComSamTv.getText());
            String SQL="SELECT nombre_articulo,marca_articulo,categoria_articulo,precio_articulo FROM articulo WHERE id_articulo='"+132+"'";    
            String []datos = new String [4];
            try {
                Statement st = (Statement) Llamar.createStatement();
                ResultSet rs = st.executeQuery(SQL);
                String nombre="";
                String marca="";
                String categoria="";
                String precio="";
                while(rs.next()){
                    datos[0]=rs.getString(1);
                    datos[1]=rs.getString(2);
                    datos[2]=rs.getString(3);
                    datos[3]=rs.getString(4);
                    if(datos[0]!=""){
                        nombre=datos[0];
                        marca=datos[1];
                        categoria=datos[2];
                        precio=datos[3];
                        factura[5]="          "+lbCanComSamTv.getText() + "                          "+nombre+"              "+marca+"                    "+precio+"                            "+Precio6+"\n";
                    }else if(datos[0]==null){
                        factura[5]="";
                    }
                }
            } catch (SQLException e) {
                JOptionPane.showMessageDialog(null,"Error al llamar cantidad "+e);
            }
            
            enviarDetalleF(132, id_facturaAI, Integer.parseInt(lbCanComSamTv.getText()), Precio6);
        }if(lbCanComTiida.getText().equals("0")){
            factura[6]="";
        }else{
            Precio7=Integer.parseInt(jlPrecio7.getText())*Integer.parseInt(lbCanComTiida.getText()); 
            String SQL="SELECT nombre_articulo,marca_articulo,categoria_articulo,precio_articulo FROM articulo WHERE id_articulo='"+211+"'";    
            String []datos = new String [4];
            try {
                Statement st = (Statement) Llamar.createStatement();
                ResultSet rs = st.executeQuery(SQL);
                String nombre="";
                String marca="";
                String categoria="";
                String precio="";
                while(rs.next()){
                    datos[0]=rs.getString(1);
                    datos[1]=rs.getString(2);
                    datos[2]=rs.getString(3);
                    datos[3]=rs.getString(4);
                    if(datos[0]!=""){
                        nombre=datos[0];
                        marca=datos[1];
                        categoria=datos[2];
                        precio=datos[3];
                        factura[6]="          "+lbCanComTiida.getText() + "                                 "+nombre+"                      "+marca+"                      "+precio+"                           "+Precio7+"\n";
                    }else if(datos[0]==null){
                        factura[6]="";
                    }
                }
            } catch (SQLException e) {
                JOptionPane.showMessageDialog(null,"Error al llamar cantidad "+e);
            }
            
            enviarDetalleF(211, id_facturaAI, Integer.parseInt(lbCanComTiida.getText()), Precio7);
        }if(lbCanComSwift.getText().equals("0")){
            factura[7]="";
        }else{
            Precio8=Integer.parseInt(jlPrecio8.getText())*Integer.parseInt(lbCanComSwift.getText()); 
            String SQL="SELECT nombre_articulo,marca_articulo,categoria_articulo,precio_articulo FROM articulo WHERE id_articulo='"+212+"'";    
            String []datos = new String [4];
            try {
                Statement st = (Statement) Llamar.createStatement();
                ResultSet rs = st.executeQuery(SQL);
                String nombre="";
                String marca="";
                String categoria="";
                String precio="";
                while(rs.next()){
                    datos[0]=rs.getString(1);
                    datos[1]=rs.getString(2);
                    datos[2]=rs.getString(3);
                    datos[3]=rs.getString(4);
                    if(datos[0]!=""){
                        nombre=datos[0];
                        marca=datos[1];
                        categoria=datos[2];
                        precio=datos[3];
                        factura[7]="          "+lbCanComSwift.getText() + "                                 "+nombre+"                      "+marca+"                      "+precio+"                           "+Precio8+"\n";
                    }else if(datos[0]==null){
                        factura[7]="";
                    }
                }
            } catch (SQLException e) {
                JOptionPane.showMessageDialog(null,"Error al llamar cantidad "+e);
            }
            
            enviarDetalleF(212, id_facturaAI, Integer.parseInt(lbCanComSwift.getText()), Precio8);
        }if(lbCanComHightower.getText().equals("0")){
            factura[8]="";
        }else{
            Precio9=Integer.parseInt(jlPrecio9.getText())*Integer.parseInt(lbCanComHightower.getText());
            String SQL="SELECT nombre_articulo,marca_articulo,categoria_articulo,precio_articulo FROM articulo WHERE id_articulo='"+221+"'";    
            String []datos = new String [4];
            try {
                Statement st = (Statement) Llamar.createStatement();
                ResultSet rs = st.executeQuery(SQL);
                String nombre="";
                String marca="";
                String categoria="";
                String precio="";
                while(rs.next()){
                    datos[0]=rs.getString(1);
                    datos[1]=rs.getString(2);
                    datos[2]=rs.getString(3);
                    datos[3]=rs.getString(4);
                    if(datos[0]!=""){
                        nombre=datos[0];
                        marca=datos[1];
                        categoria=datos[2];
                        precio=datos[3];
                        factura[8]="          "+lbCanComHightower.getText() + "                             "+nombre+"                 "+marca+"                  "+precio+"                           "+Precio9+"\n";
                    }else if(datos[0]==null){
                        factura[8]="";
                    }
                }
            } catch (SQLException e) {
                JOptionPane.showMessageDialog(null,"Error al llamar cantidad "+e);
            }
            
            enviarDetalleF(221, id_facturaAI, Integer.parseInt(lbCanComHightower.getText()), Precio9);
        }if(lbCanComSpark.getText().equals("0")){
            factura[9]="";
        }else{
            Precio10=Integer.parseInt(jlPrecio10.getText())*Integer.parseInt(lbCanComSpark.getText());
            String SQL="SELECT nombre_articulo,marca_articulo,categoria_articulo,precio_articulo FROM articulo WHERE id_articulo='"+222+"'";    
            String []datos = new String [4];
            try {
                Statement st = (Statement) Llamar.createStatement();
                ResultSet rs = st.executeQuery(SQL);
                String nombre="";
                String marca="";
                String categoria="";
                String precio="";
                while(rs.next()){
                    datos[0]=rs.getString(1);
                    datos[1]=rs.getString(2);
                    datos[2]=rs.getString(3);
                    datos[3]=rs.getString(4);
                    if(datos[0]!=""){
                        nombre=datos[0];
                        marca=datos[1];
                        categoria=datos[2];
                        precio=datos[3];
                        factura[9]="          "+lbCanComSpark.getText() + "                          "+nombre+"                "+marca+"                       "+precio+"                           "+Precio10+"\n";
                    }else if(datos[0]==null){
                        factura[9]="";
                    }
                }
            } catch (SQLException e) {
                JOptionPane.showMessageDialog(null,"Error al llamar cantidad "+e);
            }
            
            enviarDetalleF(222, id_facturaAI, Integer.parseInt(lbCanComSpark.getText()), Precio10);
        }if(lbCanComHonda.getText().equals("0")){
            factura[10]="";
        }else{
            Precio11=Integer.parseInt(jlPrecio11.getText())*Integer.parseInt(lbCanComHonda.getText()); 
            String SQL="SELECT nombre_articulo,marca_articulo,categoria_articulo,precio_articulo FROM articulo WHERE id_articulo='"+231+"'";    
            String []datos = new String [4];
            try {
                Statement st = (Statement) Llamar.createStatement();
                ResultSet rs = st.executeQuery(SQL);
                String nombre="";
                String marca="";
                String categoria="";
                String precio="";
                while(rs.next()){
                    datos[0]=rs.getString(1);
                    datos[1]=rs.getString(2);
                    datos[2]=rs.getString(3);
                    datos[3]=rs.getString(4);
                    if(datos[0]!=""){
                        nombre=datos[0];
                        marca=datos[1];
                        categoria=datos[2];
                        precio=datos[3];
                        factura[10]="          "+lbCanComHonda.getText() + "                        "+nombre+"              "+marca+"                     "+precio+"                           "+Precio11+"\n";
                    }else if(datos[0]==null){
                        factura[10]="";
                    }
                }
            } catch (SQLException e) {
                JOptionPane.showMessageDialog(null,"Error al llamar cantidad "+e);
            }
            
            enviarDetalleF(231, id_facturaAI, Integer.parseInt(lbCanComHonda.getText()), Precio11);
        }if(lbCanComYamaha.getText().equals("0")){
            factura[11]="";
        }else{
            Precio12=Integer.parseInt(jlPrecio12.getText())*Integer.parseInt(lbCanComYamaha.getText());
            String SQL="SELECT nombre_articulo,marca_articulo,categoria_articulo,precio_articulo FROM articulo WHERE id_articulo='"+232+"'";    
            String []datos = new String [4];
            try {
                Statement st = (Statement) Llamar.createStatement();
                ResultSet rs = st.executeQuery(SQL);
                String nombre="";
                String marca="";
                String categoria="";
                String precio="";
                while(rs.next()){
                    datos[0]=rs.getString(1);
                    datos[1]=rs.getString(2);
                    datos[2]=rs.getString(3);
                    datos[3]=rs.getString(4);
                    if(datos[0]!=""){
                        nombre=datos[0];
                        marca=datos[1];
                        categoria=datos[2];
                        precio=datos[3];
                        factura[11]="          "+lbCanComYamaha.getText() + "                          "+nombre+"              "+marca+"                    "+precio+"                           "+Precio12+"\n";
                    }else if(datos[0]==null){
                        factura[11]="";
                    }
                }
            } catch (SQLException e) {
                JOptionPane.showMessageDialog(null,"Error al llamar cantidad "+e);
            }
            
            enviarDetalleF(232, id_facturaAI, Integer.parseInt(lbCanComYamaha.getText()), Precio12);
        }if(lbCanComEstufa1.getText().equals("0")){
            factura[12]="";
        }else{
            Precio13=Integer.parseInt(jlPrecio13.getText())*Integer.parseInt(lbCanComEstufa1.getText());
            String SQL="SELECT nombre_articulo,marca_articulo,categoria_articulo,precio_articulo FROM articulo WHERE id_articulo='"+311+"'";    
            String []datos = new String [4];
            try {
                Statement st = (Statement) Llamar.createStatement();
                ResultSet rs = st.executeQuery(SQL);
                String nombre="";
                String marca="";
                String categoria="";
                String precio="";
                while(rs.next()){
                    datos[0]=rs.getString(1);
                    datos[1]=rs.getString(2);
                    datos[2]=rs.getString(3);
                    datos[3]=rs.getString(4);
                    if(datos[0]!=""){
                        nombre=datos[0];
                        marca=datos[1];
                        categoria=datos[2];
                        precio=datos[3];
                        factura[12]="          "+lbCanComEstufa1.getText() + "                            "+nombre+"                "+marca+"                    "+precio+"                            "+Precio13+"\n";
                    }else if(datos[0]==null){
                        factura[12]="";
                    }
                }
            } catch (SQLException e) {
                JOptionPane.showMessageDialog(null,"Error al llamar cantidad "+e);
            }
            
            enviarDetalleF(311, id_facturaAI, Integer.parseInt(lbCanComEstufa1.getText()), Precio13);
        }if(lbCanComEstufa2.getText().equals("0")){
            factura[13]="";
        }else{
            Precio14=Integer.parseInt(jlPrecio14.getText())*Integer.parseInt(lbCanComEstufa2.getText());
            String SQL="SELECT nombre_articulo,marca_articulo,categoria_articulo,precio_articulo FROM articulo WHERE id_articulo='"+312+"'";    
            String []datos = new String [4];
            try {
                Statement st = (Statement) Llamar.createStatement();
                ResultSet rs = st.executeQuery(SQL);
                String nombre="";
                String marca="";
                String categoria="";
                String precio="";
                while(rs.next()){
                    datos[0]=rs.getString(1);
                    datos[1]=rs.getString(2);
                    datos[2]=rs.getString(3);
                    datos[3]=rs.getString(4);
                    if(datos[0]!=""){
                        nombre=datos[0];
                        marca=datos[1];
                        categoria=datos[2];
                        precio=datos[3];
                        factura[13]="          "+lbCanComEstufa2.getText() + "                           "+nombre+"                 "+marca+"                       "+precio+"                            "+Precio14+"\n";
                    }else if(datos[0]==null){
                        factura[13]="";
                    }
                }
            } catch (SQLException e) {
                JOptionPane.showMessageDialog(null,"Error al llamar cantidad "+e);
            }
            
            enviarDetalleF(312, id_facturaAI, Integer.parseInt(lbCanComEstufa2.getText()), Precio14);
        }if(lbCanComLavadora1.getText().equals("0")){
            factura[14]="";
        }else{
            Precio15=Integer.parseInt(jlPrecio15.getText())*Integer.parseInt(lbCanComLavadora1.getText());
            String SQL="SELECT nombre_articulo,marca_articulo,categoria_articulo,precio_articulo FROM articulo WHERE id_articulo='"+321+"'";    
            String []datos = new String [4];
            try {
                Statement st = (Statement) Llamar.createStatement();
                ResultSet rs = st.executeQuery(SQL);
                String nombre="";
                String marca="";
                String categoria="";
                String precio="";
                while(rs.next()){
                    datos[0]=rs.getString(1);
                    datos[1]=rs.getString(2);
                    datos[2]=rs.getString(3);
                    datos[3]=rs.getString(4);
                    if(datos[0]!=""){
                        nombre=datos[0];
                        marca=datos[1];
                        categoria=datos[2];
                        precio=datos[3];
                        factura[14]="          "+lbCanComLavadora1.getText() + "                          "+nombre+"                "+marca+"                          "+precio+"                            "+Precio15+"\n";
                    }else if(datos[0]==null){
                        factura[14]="";
                    }
                }
            } catch (SQLException e) {
                JOptionPane.showMessageDialog(null,"Error al llamar cantidad "+e);
            }
            
            enviarDetalleF(321, id_facturaAI, Integer.parseInt(lbCanComLavadora1.getText()), Precio15);
        }if(lbCanComLavadora2.getText().equals("0")){
            factura[15]="";
        }else{
            Precio16=Integer.parseInt(jlPrecio16.getText())*Integer.parseInt(lbCanComLavadora2.getText());
            String SQL="SELECT nombre_articulo,marca_articulo,categoria_articulo,precio_articulo FROM articulo WHERE id_articulo='"+322+"'";    
            String []datos = new String [4];
            try {
                Statement st = (Statement) Llamar.createStatement();
                ResultSet rs = st.executeQuery(SQL);
                String nombre="";
                String marca="";
                String categoria="";
                String precio="";
                while(rs.next()){
                    datos[0]=rs.getString(1);
                    datos[1]=rs.getString(2);
                    datos[2]=rs.getString(3);
                    datos[3]=rs.getString(4);
                    if(datos[0]!=""){
                        nombre=datos[0];
                        marca=datos[1];
                        categoria=datos[2];
                        precio=datos[3];
                        factura[15]="          "+lbCanComLavadora2.getText() + "                            "+nombre+"             "+marca+"                   "+precio+"                            "+Precio16+"\n";
                    }else if(datos[0]==null){
                        factura[15]="";
                    }
                }
            } catch (SQLException e) {
                JOptionPane.showMessageDialog(null,"Error al llamar cantidad "+e);
            }
            
            enviarDetalleF(322, id_facturaAI, Integer.parseInt(lbCanComLavadora2.getText()), Precio16);
        }if(lbCanComNevera1.getText().equals("0")){
            factura[16]="";
        }else{
            Precio17=Integer.parseInt(jlPrecio17.getText())*Integer.parseInt(lbCanComNevera1.getText());
            String SQL="SELECT nombre_articulo,marca_articulo,categoria_articulo,precio_articulo FROM articulo WHERE id_articulo='"+331+"'";    
            String []datos = new String [4];
            try {
                Statement st = (Statement) Llamar.createStatement();
                ResultSet rs = st.executeQuery(SQL);
                String nombre="";
                String marca="";
                String categoria="";
                String precio="";
                while(rs.next()){
                    datos[0]=rs.getString(1);
                    datos[1]=rs.getString(2);
                    datos[2]=rs.getString(3);
                    datos[3]=rs.getString(4);
                    if(datos[0]!=""){
                        nombre=datos[0];
                        marca=datos[1];
                        categoria=datos[2];
                        precio=datos[3];
                        factura[16]="          "+lbCanComNevera1.getText() + "                            "+nombre+"                 "+marca+"                         "+precio+"                            "+Precio17+"\n";
                    }else if(datos[0]==null){
                        factura[16]="";
                    }
                }
            } catch (SQLException e) {
                JOptionPane.showMessageDialog(null,"Error al llamar cantidad "+e);
            }
            
            enviarDetalleF(331, id_facturaAI, Integer.parseInt(lbCanComNevera1.getText()), Precio17);
        }if(lbCanComNevera2.getText().equals("0")){
            factura[17]="";
        }else{
            Precio18=Integer.parseInt(jlPrecio18.getText())*Integer.parseInt(lbCanComNevera2.getText());            
            String SQL="SELECT nombre_articulo,marca_articulo,categoria_articulo,precio_articulo FROM articulo WHERE id_articulo='"+332+"'";    
            String []datos = new String [4];
            try {
                Statement st = (Statement) Llamar.createStatement();
                ResultSet rs = st.executeQuery(SQL);
                String nombre="";
                String marca="";
                String categoria="";
                String precio="";
                while(rs.next()){
                    datos[0]=rs.getString(1);
                    datos[1]=rs.getString(2);
                    datos[2]=rs.getString(3);
                    datos[3]=rs.getString(4);
                    if(datos[0]!=""){
                        nombre=datos[0];
                        marca=datos[1];
                        categoria=datos[2];
                        precio=datos[3];
                        factura[17]="          "+lbCanComNevera2.getText() + "                    "+nombre+"      "+marca+"                     "+precio+"                            "+Precio18+"\n";
                    }else if(datos[0]==null){
                        factura[17]="";
                    }
                }
            } catch (SQLException e) {
                JOptionPane.showMessageDialog(null,"Error al llamar cantidad "+e);
            }
            
            enviarDetalleF(332, id_facturaAI, Integer.parseInt(lbCanComNevera2.getText()), Precio18);
        }        
        
        int PrecioT=Precio1+Precio2+Precio11+Precio3+Precio4+Precio5+Precio6+Precio7+Precio8+Precio9+Precio10+Precio11+
            Precio12+Precio13+Precio14+Precio15+Precio16+Precio17+Precio18;
        
        JOptionPane.showMessageDialog(null,"                                                                        ***  MERCADOLIBRE ROCA  ***\n\n"+
        "                                                                            ---  Productos Comprados ---    \n\n"+
                
        "     CANTIDAD                    ARTICULO                    MARCA                    PRECIO Unit                    PRECIO TOTAL\n" 
        +factura[0]+factura[1]+factura[2]+factura[3]+factura[4]+factura[5] +factura[6]+factura[7]+factura[8]+factura[9]+factura[10]
        +factura[11]+factura[12]+factura[13]+factura[14]+factura[15]+factura[16]+factura[17]+                
                "\n________________________________________________________________________________________"+
                "\n  --------------------------------------------------------------------------------------------------------------- Precio Total : $"+PrecioT+
                "\n\n  --------------------------------------------------------------------------------------------------------------- N° Factura :: "+id_facturaAI,"             >>>>>> FACTURA <<<<<<      ",-1);
        
        
        enviar.setFACTURA("                                                                        ***  MERCADOLIBRE ROCA  ***\n\n"+
        "                                                                            ---  Productos Comprados ---    \n\n"+
                
        "     CANTIDAD                    ARTICULO                    MARCA                    PRECIO Unit                    PRECIO TOTAL\n" 
        + factura[0]+factura[1]+factura[2]+factura[3]+factura[4]+factura[5]+factura[6]+factura[7]+factura[8]+factura[9]+factura[10]+factura[11]+factura[12]+factura[13]+factura[14]+factura[15]+factura[16]+factura[17]+
                "\n________________________________________________________________________________________"+
                "\n  --------------------------------------------------------------------------------------------------------------- Precio Total : $"+PrecioT+                
                "\n\n  --------------------------------------------------------------------------------------------------------------- N° Factura :: "+id_facturaAI);
        
    }
    
    public void Verificar(){        
        if(lbCanComIphone.getText().equals("0") && lbCanComP20.getText().equals("0") && lbCanComAsus.getText().equals("0") && lbCanComHP.getText().equals("0") && lbCanComLgTv.getText().equals("0") && lbCanComSamTv.getText().equals("0") && 
           lbCanComTiida.getText().equals("0") && lbCanComSwift.getText().equals("0") && lbCanComHightower.getText().equals("0") && lbCanComSpark.getText().equals("0") && lbCanComHonda.getText().equals("0") && lbCanComYamaha.getText().equals("0") &&
           lbCanComEstufa1.getText().equals("0") && lbCanComEstufa2.getText().equals("0") && lbCanComLavadora1.getText().equals("0") && lbCanComLavadora2.getText().equals("0") && lbCanComNevera1.getText().equals("0") && lbCanComNevera2.getText().equals("0")) {
            JOptionPane.showMessageDialog(null, "DEBES AÑADIR ALGUN PRODUCTO A LA VENTA", "ERROR", 0);
        }else {            
            VenderCelular1();
            VenderCelular2();
            VenderLaptop1();
            VenderLaptop2();
            VenderTv1();
            VenderTv2();
            VenderCarro1();
            VenderCarro2();
            VenderCicla1();
            VenderCicla2();
            VenderHonda();
            VenderYamaha();
            VenderEstufa1();//
            VenderEstufa2();
            VenderLavadora1();
            VenderLavadora2();
            VenderNevera1();
            VenderNevera2();            
            factura();
            pasar();
            limpiar();
            mostarcantidad();
            iniciar();
        }
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jTabbedPane1 = new javax.swing.JTabbedPane();
        TECNOLOGIA = new javax.swing.JPanel();
        jLabel4 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        jlPrecio1 = new javax.swing.JLabel();
        lbCanIphone = new javax.swing.JLabel();
        lbCanComIphone = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();
        jLabel14 = new javax.swing.JLabel();
        jLabel15 = new javax.swing.JLabel();
        lbCanP20 = new javax.swing.JLabel();
        lbCanComP20 = new javax.swing.JLabel();
        jlPrecio2 = new javax.swing.JLabel();
        lbCanAsus = new javax.swing.JLabel();
        jLabel17 = new javax.swing.JLabel();
        jLabel18 = new javax.swing.JLabel();
        jlPrecio3 = new javax.swing.JLabel();
        jLabel20 = new javax.swing.JLabel();
        lbCanComAsus = new javax.swing.JLabel();
        jLabel21 = new javax.swing.JLabel();
        jLabel22 = new javax.swing.JLabel();
        jLabel23 = new javax.swing.JLabel();
        lbCanHP = new javax.swing.JLabel();
        lbCanComHP = new javax.swing.JLabel();
        jlPrecio4 = new javax.swing.JLabel();
        jLabel25 = new javax.swing.JLabel();
        lbCanComLgTv = new javax.swing.JLabel();
        jlPrecio5 = new javax.swing.JLabel();
        lbCanLgTv = new javax.swing.JLabel();
        jLabel27 = new javax.swing.JLabel();
        jLabel28 = new javax.swing.JLabel();
        jLabel29 = new javax.swing.JLabel();
        jLabel30 = new javax.swing.JLabel();
        jLabel31 = new javax.swing.JLabel();
        lbCanSamTv = new javax.swing.JLabel();
        jlPrecio6 = new javax.swing.JLabel();
        lbCanComSamTv = new javax.swing.JLabel();
        btnAgregar1 = new javax.swing.JButton();
        btnAgregar2 = new javax.swing.JButton();
        btnAgregar3 = new javax.swing.JButton();
        btnAgregar4 = new javax.swing.JButton();
        btnAgregar5 = new javax.swing.JButton();
        btnAgregar6 = new javax.swing.JButton();
        btnDescontar1 = new javax.swing.JButton();
        btnDescontar2 = new javax.swing.JButton();
        btnDescontar3 = new javax.swing.JButton();
        btnDescontar4 = new javax.swing.JButton();
        btnDescontar5 = new javax.swing.JButton();
        btnDescontar6 = new javax.swing.JButton();
        jLabel124 = new javax.swing.JLabel();
        jLabel128 = new javax.swing.JLabel();
        jLabel129 = new javax.swing.JLabel();
        jLabel130 = new javax.swing.JLabel();
        jLabel131 = new javax.swing.JLabel();
        jLabel132 = new javax.swing.JLabel();
        jLabel133 = new javax.swing.JLabel();
        jLabel134 = new javax.swing.JLabel();
        jLabel135 = new javax.swing.JLabel();
        jLabel136 = new javax.swing.JLabel();
        jLabel137 = new javax.swing.JLabel();
        jLabel138 = new javax.swing.JLabel();
        Fondo1 = new javax.swing.JLabel();
        AUTOMOTO = new javax.swing.JPanel();
        jLabel9 = new javax.swing.JLabel();
        btnAgregar7 = new javax.swing.JButton();
        btnDescontar7 = new javax.swing.JButton();
        lbCanComTiida = new javax.swing.JLabel();
        jlPrecio7 = new javax.swing.JLabel();
        lbCanTiida = new javax.swing.JLabel();
        jLabel11 = new javax.swing.JLabel();
        jLabel12 = new javax.swing.JLabel();
        btnDescontar8 = new javax.swing.JButton();
        lbCanComSwift = new javax.swing.JLabel();
        jLabel13 = new javax.swing.JLabel();
        lbCanSwift = new javax.swing.JLabel();
        jLabel33 = new javax.swing.JLabel();
        jlPrecio8 = new javax.swing.JLabel();
        jLabel35 = new javax.swing.JLabel();
        btnAgregar8 = new javax.swing.JButton();
        jLabel36 = new javax.swing.JLabel();
        jLabel37 = new javax.swing.JLabel();
        lbCanComHightower = new javax.swing.JLabel();
        jlPrecio9 = new javax.swing.JLabel();
        jLabel39 = new javax.swing.JLabel();
        btnDescontar9 = new javax.swing.JButton();
        btnAgregar9 = new javax.swing.JButton();
        lbCanHightower = new javax.swing.JLabel();
        jLabel40 = new javax.swing.JLabel();
        btnAgregar10 = new javax.swing.JButton();
        btnDescontar10 = new javax.swing.JButton();
        lbCanComSpark = new javax.swing.JLabel();
        jlPrecio10 = new javax.swing.JLabel();
        lbCanSpark = new javax.swing.JLabel();
        jLabel42 = new javax.swing.JLabel();
        jLabel43 = new javax.swing.JLabel();
        jLabel44 = new javax.swing.JLabel();
        btnAgregar11 = new javax.swing.JButton();
        btnDescontar11 = new javax.swing.JButton();
        lbCanComHonda = new javax.swing.JLabel();
        jlPrecio11 = new javax.swing.JLabel();
        lbCanHonda = new javax.swing.JLabel();
        jLabel46 = new javax.swing.JLabel();
        jLabel47 = new javax.swing.JLabel();
        jLabel48 = new javax.swing.JLabel();
        btnAgregar12 = new javax.swing.JButton();
        btnDescontar12 = new javax.swing.JButton();
        lbCanComYamaha = new javax.swing.JLabel();
        jlPrecio12 = new javax.swing.JLabel();
        lbCanYamaha = new javax.swing.JLabel();
        jLabel50 = new javax.swing.JLabel();
        jLabel51 = new javax.swing.JLabel();
        jLabel115 = new javax.swing.JLabel();
        jLabel116 = new javax.swing.JLabel();
        jLabel117 = new javax.swing.JLabel();
        jLabel118 = new javax.swing.JLabel();
        jLabel119 = new javax.swing.JLabel();
        jLabel120 = new javax.swing.JLabel();
        jLabel121 = new javax.swing.JLabel();
        jLabel122 = new javax.swing.JLabel();
        jLabel123 = new javax.swing.JLabel();
        jLabel125 = new javax.swing.JLabel();
        jLabel126 = new javax.swing.JLabel();
        jLabel127 = new javax.swing.JLabel();
        fondo2 = new javax.swing.JLabel();
        HOGAR = new javax.swing.JPanel();
        jLabel77 = new javax.swing.JLabel();
        lbCanComEstufa1 = new javax.swing.JLabel();
        jlPrecio13 = new javax.swing.JLabel();
        lbCanEstufa1 = new javax.swing.JLabel();
        jLabel79 = new javax.swing.JLabel();
        jLabel80 = new javax.swing.JLabel();
        lbCanEstufa2 = new javax.swing.JLabel();
        jlPrecio14 = new javax.swing.JLabel();
        jLabel82 = new javax.swing.JLabel();
        jLabel83 = new javax.swing.JLabel();
        lbCanComEstufa2 = new javax.swing.JLabel();
        jLabel84 = new javax.swing.JLabel();
        lbCanComLavadora1 = new javax.swing.JLabel();
        jlPrecio15 = new javax.swing.JLabel();
        lbCanLavadora1 = new javax.swing.JLabel();
        jLabel86 = new javax.swing.JLabel();
        jLabel87 = new javax.swing.JLabel();
        jLabel88 = new javax.swing.JLabel();
        jLabel89 = new javax.swing.JLabel();
        lbCanComLavadora2 = new javax.swing.JLabel();
        jlPrecio16 = new javax.swing.JLabel();
        lbCanLavadora2 = new javax.swing.JLabel();
        jLabel91 = new javax.swing.JLabel();
        jLabel92 = new javax.swing.JLabel();
        jLabel93 = new javax.swing.JLabel();
        lbCanComNevera1 = new javax.swing.JLabel();
        jlPrecio17 = new javax.swing.JLabel();
        lbCanNevera1 = new javax.swing.JLabel();
        jLabel95 = new javax.swing.JLabel();
        jLabel96 = new javax.swing.JLabel();
        jLabel97 = new javax.swing.JLabel();
        btnAgregar13 = new javax.swing.JButton();
        btnAgregar14 = new javax.swing.JButton();
        btnAgregar15 = new javax.swing.JButton();
        btnAgregar16 = new javax.swing.JButton();
        btnAgregar17 = new javax.swing.JButton();
        btnAgregar18 = new javax.swing.JButton();
        btnDescontar13 = new javax.swing.JButton();
        btnDescontar14 = new javax.swing.JButton();
        btnDescontar15 = new javax.swing.JButton();
        btnDescontar16 = new javax.swing.JButton();
        btnDescontar17 = new javax.swing.JButton();
        btnDescontar18 = new javax.swing.JButton();
        lbCanComNevera2 = new javax.swing.JLabel();
        jlPrecio18 = new javax.swing.JLabel();
        lbCanNevera2 = new javax.swing.JLabel();
        jLabel99 = new javax.swing.JLabel();
        jLabel100 = new javax.swing.JLabel();
        jLabel101 = new javax.swing.JLabel();
        jLabel102 = new javax.swing.JLabel();
        jLabel103 = new javax.swing.JLabel();
        jLabel104 = new javax.swing.JLabel();
        jLabel105 = new javax.swing.JLabel();
        jLabel106 = new javax.swing.JLabel();
        jLabel107 = new javax.swing.JLabel();
        jLabel108 = new javax.swing.JLabel();
        jLabel109 = new javax.swing.JLabel();
        jLabel110 = new javax.swing.JLabel();
        jLabel111 = new javax.swing.JLabel();
        jLabel112 = new javax.swing.JLabel();
        fondo3 = new javax.swing.JLabel();
        jMenuBar1 = new javax.swing.JMenuBar();
        jMenu1 = new javax.swing.JMenu();
        JMI_comprar = new javax.swing.JMenuItem();
        jMenu2 = new javax.swing.JMenu();
        jMenuItem1 = new javax.swing.JMenuItem();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setUndecorated(true);

        jTabbedPane1.setForeground(new java.awt.Color(0, 102, 102));
        jTabbedPane1.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N

        TECNOLOGIA.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel4.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel4.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/tecnologia/celular_iphonex2.jpg"))); // NOI18N
        jLabel4.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        TECNOLOGIA.add(jLabel4, new org.netbeans.lib.awtextra.AbsoluteConstraints(45, 80, -1, -1));

        jLabel5.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel5.setText("IPHONE X");
        TECNOLOGIA.add(jLabel5, new org.netbeans.lib.awtextra.AbsoluteConstraints(187, 91, 127, -1));

        jLabel6.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel6.setText("APPLE");
        TECNOLOGIA.add(jLabel6, new org.netbeans.lib.awtextra.AbsoluteConstraints(197, 116, 104, -1));

        jlPrecio1.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jlPrecio1.setText("0000000");
        TECNOLOGIA.add(jlPrecio1, new org.netbeans.lib.awtextra.AbsoluteConstraints(222, 187, 58, -1));

        lbCanIphone.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lbCanIphone.setText("0");
        lbCanIphone.setBorder(javax.swing.BorderFactory.createTitledBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)), "Cantidad Disponible", javax.swing.border.TitledBorder.CENTER, javax.swing.border.TitledBorder.DEFAULT_POSITION));
        TECNOLOGIA.add(lbCanIphone, new org.netbeans.lib.awtextra.AbsoluteConstraints(187, 141, 127, -1));

        lbCanComIphone.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lbCanComIphone.setText("0");
        lbCanComIphone.setBorder(javax.swing.BorderFactory.createTitledBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)), "Cantidad a Comprar"));
        TECNOLOGIA.add(lbCanComIphone, new org.netbeans.lib.awtextra.AbsoluteConstraints(189, 208, 140, 45));

        jLabel7.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel7.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/tecnologia/celular_p20.jpg"))); // NOI18N
        jLabel7.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        TECNOLOGIA.add(jLabel7, new org.netbeans.lib.awtextra.AbsoluteConstraints(353, 80, -1, -1));

        jLabel14.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel14.setText("P 20 PRO");
        TECNOLOGIA.add(jLabel14, new org.netbeans.lib.awtextra.AbsoluteConstraints(495, 91, 127, -1));

        jLabel15.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel15.setText("HUAWEI");
        TECNOLOGIA.add(jLabel15, new org.netbeans.lib.awtextra.AbsoluteConstraints(505, 116, 103, -1));

        lbCanP20.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lbCanP20.setText("0");
        lbCanP20.setBorder(javax.swing.BorderFactory.createTitledBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)), "Cantidad Disponible", javax.swing.border.TitledBorder.CENTER, javax.swing.border.TitledBorder.DEFAULT_POSITION));
        TECNOLOGIA.add(lbCanP20, new org.netbeans.lib.awtextra.AbsoluteConstraints(495, 141, 127, -1));

        lbCanComP20.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lbCanComP20.setText("0");
        lbCanComP20.setBorder(javax.swing.BorderFactory.createTitledBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)), "Cantidad a Comprar"));
        TECNOLOGIA.add(lbCanComP20, new org.netbeans.lib.awtextra.AbsoluteConstraints(497, 208, 140, 45));

        jlPrecio2.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jlPrecio2.setText("0000000");
        TECNOLOGIA.add(jlPrecio2, new org.netbeans.lib.awtextra.AbsoluteConstraints(532, 188, 58, -1));

        lbCanAsus.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lbCanAsus.setText("0");
        lbCanAsus.setBorder(javax.swing.BorderFactory.createTitledBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)), "Cantidad Disponible", javax.swing.border.TitledBorder.CENTER, javax.swing.border.TitledBorder.DEFAULT_POSITION));
        TECNOLOGIA.add(lbCanAsus, new org.netbeans.lib.awtextra.AbsoluteConstraints(797, 141, 127, -1));

        jLabel17.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel17.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/tecnologia/laptop_asus.jpg"))); // NOI18N
        jLabel17.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        TECNOLOGIA.add(jLabel17, new org.netbeans.lib.awtextra.AbsoluteConstraints(655, 80, -1, -1));

        jLabel18.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel18.setText("ASUS");
        TECNOLOGIA.add(jLabel18, new org.netbeans.lib.awtextra.AbsoluteConstraints(807, 116, 103, -1));

        jlPrecio3.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jlPrecio3.setText("0000000");
        TECNOLOGIA.add(jlPrecio3, new org.netbeans.lib.awtextra.AbsoluteConstraints(837, 187, 58, -1));

        jLabel20.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel20.setText("LAPTOP 14LS");
        TECNOLOGIA.add(jLabel20, new org.netbeans.lib.awtextra.AbsoluteConstraints(797, 91, 127, -1));

        lbCanComAsus.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lbCanComAsus.setText("0");
        lbCanComAsus.setBorder(javax.swing.BorderFactory.createTitledBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)), "Cantidad a Comprar"));
        TECNOLOGIA.add(lbCanComAsus, new org.netbeans.lib.awtextra.AbsoluteConstraints(799, 208, 140, 45));

        jLabel21.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel21.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/tecnologia/laptop_hp.jpg"))); // NOI18N
        jLabel21.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        TECNOLOGIA.add(jLabel21, new org.netbeans.lib.awtextra.AbsoluteConstraints(45, 353, -1, -1));

        jLabel22.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel22.setText("LAPTOP 1000");
        TECNOLOGIA.add(jLabel22, new org.netbeans.lib.awtextra.AbsoluteConstraints(187, 364, 122, -1));

        jLabel23.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel23.setText("HP");
        TECNOLOGIA.add(jLabel23, new org.netbeans.lib.awtextra.AbsoluteConstraints(197, 389, 103, -1));

        lbCanHP.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lbCanHP.setText("0");
        lbCanHP.setBorder(javax.swing.BorderFactory.createTitledBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)), "Cantidad Disponible", javax.swing.border.TitledBorder.CENTER, javax.swing.border.TitledBorder.DEFAULT_POSITION));
        TECNOLOGIA.add(lbCanHP, new org.netbeans.lib.awtextra.AbsoluteConstraints(187, 414, 127, -1));

        lbCanComHP.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lbCanComHP.setText("0");
        lbCanComHP.setBorder(javax.swing.BorderFactory.createTitledBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)), "Cantidad a Comprar"));
        TECNOLOGIA.add(lbCanComHP, new org.netbeans.lib.awtextra.AbsoluteConstraints(189, 481, 140, 45));

        jlPrecio4.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jlPrecio4.setText("0000000");
        TECNOLOGIA.add(jlPrecio4, new org.netbeans.lib.awtextra.AbsoluteConstraints(227, 460, 58, -1));

        jLabel25.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel25.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/tecnologia/tv_lg.jpg"))); // NOI18N
        jLabel25.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        TECNOLOGIA.add(jLabel25, new org.netbeans.lib.awtextra.AbsoluteConstraints(353, 353, -1, -1));

        lbCanComLgTv.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lbCanComLgTv.setText("0");
        lbCanComLgTv.setBorder(javax.swing.BorderFactory.createTitledBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)), "Cantidad a Comprar"));
        TECNOLOGIA.add(lbCanComLgTv, new org.netbeans.lib.awtextra.AbsoluteConstraints(497, 481, 140, 45));

        jlPrecio5.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jlPrecio5.setText("0000000");
        TECNOLOGIA.add(jlPrecio5, new org.netbeans.lib.awtextra.AbsoluteConstraints(535, 460, 58, -1));

        lbCanLgTv.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lbCanLgTv.setText("0");
        lbCanLgTv.setBorder(javax.swing.BorderFactory.createTitledBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)), "Cantidad Disponible", javax.swing.border.TitledBorder.CENTER, javax.swing.border.TitledBorder.DEFAULT_POSITION));
        TECNOLOGIA.add(lbCanLgTv, new org.netbeans.lib.awtextra.AbsoluteConstraints(495, 414, 127, -1));

        jLabel27.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel27.setText("LG");
        TECNOLOGIA.add(jLabel27, new org.netbeans.lib.awtextra.AbsoluteConstraints(505, 389, 102, -1));

        jLabel28.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel28.setText("TELEVISOR Smart TV");
        TECNOLOGIA.add(jLabel28, new org.netbeans.lib.awtextra.AbsoluteConstraints(495, 364, 127, -1));

        jLabel29.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel29.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/tecnologia/tv_sams.jpg"))); // NOI18N
        jLabel29.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        TECNOLOGIA.add(jLabel29, new org.netbeans.lib.awtextra.AbsoluteConstraints(655, 353, -1, -1));

        jLabel30.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel30.setText("TELEVISOR Smart TV");
        TECNOLOGIA.add(jLabel30, new org.netbeans.lib.awtextra.AbsoluteConstraints(797, 364, 124, -1));

        jLabel31.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel31.setText("SAMSUNG");
        TECNOLOGIA.add(jLabel31, new org.netbeans.lib.awtextra.AbsoluteConstraints(807, 389, 102, -1));

        lbCanSamTv.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lbCanSamTv.setText("0");
        lbCanSamTv.setBorder(javax.swing.BorderFactory.createTitledBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)), "Cantidad Disponible", javax.swing.border.TitledBorder.CENTER, javax.swing.border.TitledBorder.DEFAULT_POSITION));
        TECNOLOGIA.add(lbCanSamTv, new org.netbeans.lib.awtextra.AbsoluteConstraints(797, 414, 127, -1));

        jlPrecio6.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jlPrecio6.setText("0000000");
        TECNOLOGIA.add(jlPrecio6, new org.netbeans.lib.awtextra.AbsoluteConstraints(837, 460, 58, -1));

        lbCanComSamTv.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lbCanComSamTv.setText("0");
        lbCanComSamTv.setBorder(javax.swing.BorderFactory.createTitledBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)), "Cantidad a Comprar"));
        TECNOLOGIA.add(lbCanComSamTv, new org.netbeans.lib.awtextra.AbsoluteConstraints(799, 481, 140, 45));

        btnAgregar1.setText("Agregar");
        btnAgregar1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnAgregar1ActionPerformed(evt);
            }
        });
        TECNOLOGIA.add(btnAgregar1, new org.netbeans.lib.awtextra.AbsoluteConstraints(45, 230, -1, -1));

        btnAgregar2.setText("Agregar");
        btnAgregar2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnAgregar2ActionPerformed(evt);
            }
        });
        TECNOLOGIA.add(btnAgregar2, new org.netbeans.lib.awtextra.AbsoluteConstraints(353, 230, -1, -1));

        btnAgregar3.setText("Agregar");
        btnAgregar3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnAgregar3ActionPerformed(evt);
            }
        });
        TECNOLOGIA.add(btnAgregar3, new org.netbeans.lib.awtextra.AbsoluteConstraints(655, 230, -1, -1));

        btnAgregar4.setText("Agregar");
        btnAgregar4.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnAgregar4ActionPerformed(evt);
            }
        });
        TECNOLOGIA.add(btnAgregar4, new org.netbeans.lib.awtextra.AbsoluteConstraints(45, 503, -1, -1));

        btnAgregar5.setText("Agregar");
        btnAgregar5.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnAgregar5ActionPerformed(evt);
            }
        });
        TECNOLOGIA.add(btnAgregar5, new org.netbeans.lib.awtextra.AbsoluteConstraints(353, 503, -1, -1));

        btnAgregar6.setText("Agregar");
        btnAgregar6.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnAgregar6ActionPerformed(evt);
            }
        });
        TECNOLOGIA.add(btnAgregar6, new org.netbeans.lib.awtextra.AbsoluteConstraints(655, 503, -1, -1));

        btnDescontar1.setText("Quitar");
        btnDescontar1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnDescontar1ActionPerformed(evt);
            }
        });
        TECNOLOGIA.add(btnDescontar1, new org.netbeans.lib.awtextra.AbsoluteConstraints(122, 230, -1, -1));

        btnDescontar2.setText("Quitar");
        btnDescontar2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnDescontar2ActionPerformed(evt);
            }
        });
        TECNOLOGIA.add(btnDescontar2, new org.netbeans.lib.awtextra.AbsoluteConstraints(430, 230, -1, -1));

        btnDescontar3.setText("Quitar");
        btnDescontar3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnDescontar3ActionPerformed(evt);
            }
        });
        TECNOLOGIA.add(btnDescontar3, new org.netbeans.lib.awtextra.AbsoluteConstraints(732, 230, -1, -1));

        btnDescontar4.setText("Quitar");
        btnDescontar4.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnDescontar4ActionPerformed(evt);
            }
        });
        TECNOLOGIA.add(btnDescontar4, new org.netbeans.lib.awtextra.AbsoluteConstraints(122, 503, -1, -1));

        btnDescontar5.setText("Quitar");
        btnDescontar5.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnDescontar5ActionPerformed(evt);
            }
        });
        TECNOLOGIA.add(btnDescontar5, new org.netbeans.lib.awtextra.AbsoluteConstraints(430, 503, -1, -1));

        btnDescontar6.setText("Quitar");
        btnDescontar6.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnDescontar6ActionPerformed(evt);
            }
        });
        TECNOLOGIA.add(btnDescontar6, new org.netbeans.lib.awtextra.AbsoluteConstraints(732, 503, -1, -1));

        jLabel124.setText(" $ ");
        TECNOLOGIA.add(jLabel124, new org.netbeans.lib.awtextra.AbsoluteConstraints(204, 187, -1, -1));

        jLabel128.setText("c/u");
        TECNOLOGIA.add(jLabel128, new org.netbeans.lib.awtextra.AbsoluteConstraints(286, 187, -1, -1));

        jLabel129.setText(" $ ");
        TECNOLOGIA.add(jLabel129, new org.netbeans.lib.awtextra.AbsoluteConstraints(514, 188, -1, -1));

        jLabel130.setText(" $ ");
        TECNOLOGIA.add(jLabel130, new org.netbeans.lib.awtextra.AbsoluteConstraints(819, 187, -1, -1));

        jLabel131.setText(" $ ");
        TECNOLOGIA.add(jLabel131, new org.netbeans.lib.awtextra.AbsoluteConstraints(209, 460, -1, -1));

        jLabel132.setText(" $ ");
        TECNOLOGIA.add(jLabel132, new org.netbeans.lib.awtextra.AbsoluteConstraints(517, 460, -1, -1));

        jLabel133.setText(" $ ");
        TECNOLOGIA.add(jLabel133, new org.netbeans.lib.awtextra.AbsoluteConstraints(819, 460, -1, -1));

        jLabel134.setText("c/u");
        TECNOLOGIA.add(jLabel134, new org.netbeans.lib.awtextra.AbsoluteConstraints(596, 188, -1, -1));

        jLabel135.setText("c/u");
        TECNOLOGIA.add(jLabel135, new org.netbeans.lib.awtextra.AbsoluteConstraints(901, 187, -1, -1));

        jLabel136.setText("c/u");
        TECNOLOGIA.add(jLabel136, new org.netbeans.lib.awtextra.AbsoluteConstraints(291, 460, -1, -1));

        jLabel137.setText("c/u");
        TECNOLOGIA.add(jLabel137, new org.netbeans.lib.awtextra.AbsoluteConstraints(599, 460, -1, -1));

        jLabel138.setText("c/u");
        TECNOLOGIA.add(jLabel138, new org.netbeans.lib.awtextra.AbsoluteConstraints(901, 460, -1, -1));

        Fondo1.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        Fondo1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/fondo2.jpg"))); // NOI18N
        TECNOLOGIA.add(Fondo1, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 980, -1));

        jTabbedPane1.addTab("TECNOLOGIA", TECNOLOGIA);

        AUTOMOTO.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel9.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel9.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/auto_moto/Auto_nissan.jpg"))); // NOI18N
        jLabel9.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        AUTOMOTO.add(jLabel9, new org.netbeans.lib.awtextra.AbsoluteConstraints(43, 83, -1, -1));

        btnAgregar7.setText("Agregar");
        btnAgregar7.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnAgregar7ActionPerformed(evt);
            }
        });
        AUTOMOTO.add(btnAgregar7, new org.netbeans.lib.awtextra.AbsoluteConstraints(43, 233, -1, -1));

        btnDescontar7.setText("Quitar");
        btnDescontar7.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnDescontar7ActionPerformed(evt);
            }
        });
        AUTOMOTO.add(btnDescontar7, new org.netbeans.lib.awtextra.AbsoluteConstraints(120, 233, -1, -1));

        lbCanComTiida.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lbCanComTiida.setText("0");
        lbCanComTiida.setBorder(javax.swing.BorderFactory.createTitledBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)), "Cantidad a Comprar"));
        AUTOMOTO.add(lbCanComTiida, new org.netbeans.lib.awtextra.AbsoluteConstraints(187, 211, 140, 45));

        jlPrecio7.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jlPrecio7.setText("0000000");
        AUTOMOTO.add(jlPrecio7, new org.netbeans.lib.awtextra.AbsoluteConstraints(225, 190, 58, -1));

        lbCanTiida.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lbCanTiida.setText("0");
        lbCanTiida.setBorder(javax.swing.BorderFactory.createTitledBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)), "Cantidad Disponible", javax.swing.border.TitledBorder.CENTER, javax.swing.border.TitledBorder.DEFAULT_POSITION));
        AUTOMOTO.add(lbCanTiida, new org.netbeans.lib.awtextra.AbsoluteConstraints(185, 144, 127, -1));

        jLabel11.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel11.setText("NISSAN");
        AUTOMOTO.add(jLabel11, new org.netbeans.lib.awtextra.AbsoluteConstraints(195, 119, 105, -1));

        jLabel12.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel12.setText("TIIDA");
        AUTOMOTO.add(jLabel12, new org.netbeans.lib.awtextra.AbsoluteConstraints(185, 94, 127, -1));

        btnDescontar8.setText("Quitar");
        btnDescontar8.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnDescontar8ActionPerformed(evt);
            }
        });
        AUTOMOTO.add(btnDescontar8, new org.netbeans.lib.awtextra.AbsoluteConstraints(432, 233, -1, -1));

        lbCanComSwift.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lbCanComSwift.setText("0");
        lbCanComSwift.setBorder(javax.swing.BorderFactory.createTitledBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)), "Cantidad a Comprar"));
        AUTOMOTO.add(lbCanComSwift, new org.netbeans.lib.awtextra.AbsoluteConstraints(499, 211, 140, 45));

        jLabel13.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel13.setText("SWIFT");
        AUTOMOTO.add(jLabel13, new org.netbeans.lib.awtextra.AbsoluteConstraints(497, 94, 127, -1));

        lbCanSwift.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lbCanSwift.setText("0");
        lbCanSwift.setBorder(javax.swing.BorderFactory.createTitledBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)), "Cantidad Disponible", javax.swing.border.TitledBorder.CENTER, javax.swing.border.TitledBorder.DEFAULT_POSITION));
        AUTOMOTO.add(lbCanSwift, new org.netbeans.lib.awtextra.AbsoluteConstraints(497, 144, 127, -1));

        jLabel33.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel33.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/auto_moto/auto_suzuki.jpg"))); // NOI18N
        jLabel33.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        AUTOMOTO.add(jLabel33, new org.netbeans.lib.awtextra.AbsoluteConstraints(355, 83, -1, -1));

        jlPrecio8.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jlPrecio8.setText("0000000");
        AUTOMOTO.add(jlPrecio8, new org.netbeans.lib.awtextra.AbsoluteConstraints(537, 190, 58, -1));

        jLabel35.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel35.setText("SUZUKI");
        AUTOMOTO.add(jLabel35, new org.netbeans.lib.awtextra.AbsoluteConstraints(507, 119, 103, -1));

        btnAgregar8.setText("Agregar");
        btnAgregar8.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnAgregar8ActionPerformed(evt);
            }
        });
        AUTOMOTO.add(btnAgregar8, new org.netbeans.lib.awtextra.AbsoluteConstraints(355, 233, -1, -1));

        jLabel36.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel36.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/auto_moto/cicla_SantaCruz.jpg"))); // NOI18N
        jLabel36.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        AUTOMOTO.add(jLabel36, new org.netbeans.lib.awtextra.AbsoluteConstraints(662, 83, -1, -1));

        jLabel37.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel37.setText("HIGHTOWER");
        AUTOMOTO.add(jLabel37, new org.netbeans.lib.awtextra.AbsoluteConstraints(804, 94, 127, -1));

        lbCanComHightower.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lbCanComHightower.setText("0");
        lbCanComHightower.setBorder(javax.swing.BorderFactory.createTitledBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)), "Cantidad a Comprar"));
        AUTOMOTO.add(lbCanComHightower, new org.netbeans.lib.awtextra.AbsoluteConstraints(806, 211, 140, 45));

        jlPrecio9.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jlPrecio9.setText("0000000");
        AUTOMOTO.add(jlPrecio9, new org.netbeans.lib.awtextra.AbsoluteConstraints(844, 190, 58, -1));

        jLabel39.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel39.setText("SANTA CRUZ");
        AUTOMOTO.add(jLabel39, new org.netbeans.lib.awtextra.AbsoluteConstraints(804, 119, 127, -1));

        btnDescontar9.setText("Quitar");
        btnDescontar9.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnDescontar9ActionPerformed(evt);
            }
        });
        AUTOMOTO.add(btnDescontar9, new org.netbeans.lib.awtextra.AbsoluteConstraints(739, 233, -1, -1));

        btnAgregar9.setText("Agregar");
        btnAgregar9.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnAgregar9ActionPerformed(evt);
            }
        });
        AUTOMOTO.add(btnAgregar9, new org.netbeans.lib.awtextra.AbsoluteConstraints(662, 233, -1, -1));

        lbCanHightower.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lbCanHightower.setText("0");
        lbCanHightower.setBorder(javax.swing.BorderFactory.createTitledBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)), "Cantidad Disponible", javax.swing.border.TitledBorder.CENTER, javax.swing.border.TitledBorder.DEFAULT_POSITION));
        AUTOMOTO.add(lbCanHightower, new org.netbeans.lib.awtextra.AbsoluteConstraints(804, 144, 127, -1));

        jLabel40.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel40.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/auto_moto/cicla_Scott.jpg"))); // NOI18N
        jLabel40.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        AUTOMOTO.add(jLabel40, new org.netbeans.lib.awtextra.AbsoluteConstraints(43, 356, -1, -1));

        btnAgregar10.setText("Agregar");
        btnAgregar10.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnAgregar10ActionPerformed(evt);
            }
        });
        AUTOMOTO.add(btnAgregar10, new org.netbeans.lib.awtextra.AbsoluteConstraints(43, 506, -1, -1));

        btnDescontar10.setText("Quitar");
        btnDescontar10.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnDescontar10ActionPerformed(evt);
            }
        });
        AUTOMOTO.add(btnDescontar10, new org.netbeans.lib.awtextra.AbsoluteConstraints(120, 506, -1, -1));

        lbCanComSpark.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lbCanComSpark.setText("0");
        lbCanComSpark.setBorder(javax.swing.BorderFactory.createTitledBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)), "Cantidad a Comprar"));
        AUTOMOTO.add(lbCanComSpark, new org.netbeans.lib.awtextra.AbsoluteConstraints(187, 484, 140, 45));

        jlPrecio10.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jlPrecio10.setText("0000000");
        AUTOMOTO.add(jlPrecio10, new org.netbeans.lib.awtextra.AbsoluteConstraints(225, 463, 58, -1));

        lbCanSpark.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lbCanSpark.setText("0");
        lbCanSpark.setBorder(javax.swing.BorderFactory.createTitledBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)), "Cantidad Disponible", javax.swing.border.TitledBorder.CENTER, javax.swing.border.TitledBorder.DEFAULT_POSITION));
        AUTOMOTO.add(lbCanSpark, new org.netbeans.lib.awtextra.AbsoluteConstraints(185, 417, 127, -1));

        jLabel42.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel42.setText("SCOTT");
        AUTOMOTO.add(jLabel42, new org.netbeans.lib.awtextra.AbsoluteConstraints(195, 392, 103, -1));

        jLabel43.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel43.setText("SPARK 700 PLUS");
        AUTOMOTO.add(jLabel43, new org.netbeans.lib.awtextra.AbsoluteConstraints(185, 367, 127, -1));

        jLabel44.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel44.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/auto_moto/moto_honda.jpg"))); // NOI18N
        jLabel44.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        AUTOMOTO.add(jLabel44, new org.netbeans.lib.awtextra.AbsoluteConstraints(355, 356, -1, -1));

        btnAgregar11.setText("Agregar");
        btnAgregar11.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnAgregar11ActionPerformed(evt);
            }
        });
        AUTOMOTO.add(btnAgregar11, new org.netbeans.lib.awtextra.AbsoluteConstraints(355, 506, -1, -1));

        btnDescontar11.setText("Quitar");
        btnDescontar11.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnDescontar11ActionPerformed(evt);
            }
        });
        AUTOMOTO.add(btnDescontar11, new org.netbeans.lib.awtextra.AbsoluteConstraints(432, 506, -1, -1));

        lbCanComHonda.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lbCanComHonda.setText("0");
        lbCanComHonda.setBorder(javax.swing.BorderFactory.createTitledBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)), "Cantidad a Comprar"));
        AUTOMOTO.add(lbCanComHonda, new org.netbeans.lib.awtextra.AbsoluteConstraints(499, 484, 140, 45));

        jlPrecio11.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jlPrecio11.setText("0000000");
        AUTOMOTO.add(jlPrecio11, new org.netbeans.lib.awtextra.AbsoluteConstraints(537, 463, 58, -1));

        lbCanHonda.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lbCanHonda.setText("0");
        lbCanHonda.setBorder(javax.swing.BorderFactory.createTitledBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)), "Cantidad Disponible", javax.swing.border.TitledBorder.CENTER, javax.swing.border.TitledBorder.DEFAULT_POSITION));
        AUTOMOTO.add(lbCanHonda, new org.netbeans.lib.awtextra.AbsoluteConstraints(497, 417, 127, -1));

        jLabel46.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel46.setText("HONDA");
        AUTOMOTO.add(jLabel46, new org.netbeans.lib.awtextra.AbsoluteConstraints(507, 392, 102, -1));

        jLabel47.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel47.setText("CRF 250R");
        AUTOMOTO.add(jLabel47, new org.netbeans.lib.awtextra.AbsoluteConstraints(497, 367, 127, -1));

        jLabel48.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel48.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/auto_moto/moto_yamaha.jpg"))); // NOI18N
        jLabel48.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        AUTOMOTO.add(jLabel48, new org.netbeans.lib.awtextra.AbsoluteConstraints(659, 356, -1, -1));

        btnAgregar12.setText("Agregar");
        btnAgregar12.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnAgregar12ActionPerformed(evt);
            }
        });
        AUTOMOTO.add(btnAgregar12, new org.netbeans.lib.awtextra.AbsoluteConstraints(659, 506, -1, -1));

        btnDescontar12.setText("Quitar");
        btnDescontar12.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnDescontar12ActionPerformed(evt);
            }
        });
        AUTOMOTO.add(btnDescontar12, new org.netbeans.lib.awtextra.AbsoluteConstraints(736, 506, -1, -1));

        lbCanComYamaha.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lbCanComYamaha.setText("0");
        lbCanComYamaha.setBorder(javax.swing.BorderFactory.createTitledBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)), "Cantidad a Comprar"));
        AUTOMOTO.add(lbCanComYamaha, new org.netbeans.lib.awtextra.AbsoluteConstraints(803, 484, 140, 45));

        jlPrecio12.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jlPrecio12.setText("0000000");
        AUTOMOTO.add(jlPrecio12, new org.netbeans.lib.awtextra.AbsoluteConstraints(841, 463, 58, -1));

        lbCanYamaha.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lbCanYamaha.setText("0");
        lbCanYamaha.setBorder(javax.swing.BorderFactory.createTitledBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)), "Cantidad Disponible", javax.swing.border.TitledBorder.CENTER, javax.swing.border.TitledBorder.DEFAULT_POSITION));
        AUTOMOTO.add(lbCanYamaha, new org.netbeans.lib.awtextra.AbsoluteConstraints(801, 417, 127, -1));

        jLabel50.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel50.setText("YAMAHA");
        AUTOMOTO.add(jLabel50, new org.netbeans.lib.awtextra.AbsoluteConstraints(811, 392, 103, -1));

        jLabel51.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel51.setText("XTZ 125");
        AUTOMOTO.add(jLabel51, new org.netbeans.lib.awtextra.AbsoluteConstraints(801, 367, 127, -1));

        jLabel115.setText(" $ ");
        AUTOMOTO.add(jLabel115, new org.netbeans.lib.awtextra.AbsoluteConstraints(207, 190, -1, -1));

        jLabel116.setText(" $ ");
        AUTOMOTO.add(jLabel116, new org.netbeans.lib.awtextra.AbsoluteConstraints(519, 190, -1, -1));

        jLabel117.setText(" $ ");
        AUTOMOTO.add(jLabel117, new org.netbeans.lib.awtextra.AbsoluteConstraints(826, 190, -1, -1));

        jLabel118.setText(" $ ");
        AUTOMOTO.add(jLabel118, new org.netbeans.lib.awtextra.AbsoluteConstraints(207, 463, -1, -1));

        jLabel119.setText(" $ ");
        AUTOMOTO.add(jLabel119, new org.netbeans.lib.awtextra.AbsoluteConstraints(519, 463, -1, -1));

        jLabel120.setText(" $ ");
        AUTOMOTO.add(jLabel120, new org.netbeans.lib.awtextra.AbsoluteConstraints(823, 463, -1, -1));

        jLabel121.setText("c/u");
        AUTOMOTO.add(jLabel121, new org.netbeans.lib.awtextra.AbsoluteConstraints(289, 190, -1, -1));

        jLabel122.setText("c/u");
        AUTOMOTO.add(jLabel122, new org.netbeans.lib.awtextra.AbsoluteConstraints(601, 190, -1, -1));

        jLabel123.setText("c/u");
        AUTOMOTO.add(jLabel123, new org.netbeans.lib.awtextra.AbsoluteConstraints(908, 190, -1, -1));

        jLabel125.setText("c/u");
        AUTOMOTO.add(jLabel125, new org.netbeans.lib.awtextra.AbsoluteConstraints(289, 463, -1, -1));

        jLabel126.setText("c/u");
        AUTOMOTO.add(jLabel126, new org.netbeans.lib.awtextra.AbsoluteConstraints(601, 463, -1, -1));

        jLabel127.setText("c/u");
        AUTOMOTO.add(jLabel127, new org.netbeans.lib.awtextra.AbsoluteConstraints(905, 463, -1, -1));

        fondo2.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        fondo2.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/fondo2.jpg"))); // NOI18N
        AUTOMOTO.add(fondo2, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 980, 610));

        jTabbedPane1.addTab("VEHICULOS", AUTOMOTO);

        HOGAR.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel77.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel77.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/hogar/estufa_Koblenz.jpg"))); // NOI18N
        jLabel77.setBorder(new javax.swing.border.LineBorder(new java.awt.Color(0, 0, 0), 1, true));
        HOGAR.add(jLabel77, new org.netbeans.lib.awtextra.AbsoluteConstraints(46, 79, -1, -1));

        lbCanComEstufa1.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lbCanComEstufa1.setText("0");
        lbCanComEstufa1.setBorder(javax.swing.BorderFactory.createTitledBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)), "Cantidad a Comprar"));
        HOGAR.add(lbCanComEstufa1, new org.netbeans.lib.awtextra.AbsoluteConstraints(190, 207, 130, 45));

        jlPrecio13.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jlPrecio13.setText("0000000");
        HOGAR.add(jlPrecio13, new org.netbeans.lib.awtextra.AbsoluteConstraints(223, 186, 58, -1));

        lbCanEstufa1.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lbCanEstufa1.setText("0");
        lbCanEstufa1.setBorder(javax.swing.BorderFactory.createTitledBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)), "Cantidad Disponible", javax.swing.border.TitledBorder.CENTER, javax.swing.border.TitledBorder.DEFAULT_POSITION));
        HOGAR.add(lbCanEstufa1, new org.netbeans.lib.awtextra.AbsoluteConstraints(188, 140, 127, -1));

        jLabel79.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel79.setText("KOBLENZ");
        HOGAR.add(jLabel79, new org.netbeans.lib.awtextra.AbsoluteConstraints(198, 115, 96, -1));

        jLabel80.setFont(new java.awt.Font("Tahoma", 0, 10)); // NOI18N
        jLabel80.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel80.setText("ESTUFA GAS NATURAL");
        HOGAR.add(jLabel80, new org.netbeans.lib.awtextra.AbsoluteConstraints(188, 90, 127, -1));

        lbCanEstufa2.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lbCanEstufa2.setText("0");
        lbCanEstufa2.setBorder(javax.swing.BorderFactory.createTitledBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)), "Cantidad Disponible", javax.swing.border.TitledBorder.CENTER, javax.swing.border.TitledBorder.DEFAULT_POSITION));
        HOGAR.add(lbCanEstufa2, new org.netbeans.lib.awtextra.AbsoluteConstraints(492, 140, 127, -1));

        jlPrecio14.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jlPrecio14.setText("0000000");
        HOGAR.add(jlPrecio14, new org.netbeans.lib.awtextra.AbsoluteConstraints(532, 186, 58, -1));

        jLabel82.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel82.setText("ABBA");
        HOGAR.add(jLabel82, new org.netbeans.lib.awtextra.AbsoluteConstraints(502, 115, 95, -1));

        jLabel83.setFont(new java.awt.Font("Tahoma", 0, 10)); // NOI18N
        jLabel83.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel83.setText("ESTUFA DE EMPOTRAR");
        HOGAR.add(jLabel83, new org.netbeans.lib.awtextra.AbsoluteConstraints(492, 90, 127, -1));

        lbCanComEstufa2.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lbCanComEstufa2.setText("0");
        lbCanComEstufa2.setBorder(javax.swing.BorderFactory.createTitledBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)), "Cantidad a Comprar"));
        HOGAR.add(lbCanComEstufa2, new org.netbeans.lib.awtextra.AbsoluteConstraints(494, 207, 140, 45));

        jLabel84.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel84.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/hogar/estufa_abba.jpg"))); // NOI18N
        jLabel84.setBorder(new javax.swing.border.LineBorder(new java.awt.Color(0, 0, 0), 1, true));
        HOGAR.add(jLabel84, new org.netbeans.lib.awtextra.AbsoluteConstraints(350, 79, -1, -1));

        lbCanComLavadora1.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lbCanComLavadora1.setText("0");
        lbCanComLavadora1.setBorder(javax.swing.BorderFactory.createTitledBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)), "Cantidad a Comprar"));
        HOGAR.add(lbCanComLavadora1, new org.netbeans.lib.awtextra.AbsoluteConstraints(811, 207, 140, 45));

        jlPrecio15.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jlPrecio15.setText("0000000");
        HOGAR.add(jlPrecio15, new org.netbeans.lib.awtextra.AbsoluteConstraints(849, 186, 58, -1));

        lbCanLavadora1.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lbCanLavadora1.setText("0");
        lbCanLavadora1.setBorder(javax.swing.BorderFactory.createTitledBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)), "Cantidad Disponible", javax.swing.border.TitledBorder.CENTER, javax.swing.border.TitledBorder.DEFAULT_POSITION));
        HOGAR.add(lbCanLavadora1, new org.netbeans.lib.awtextra.AbsoluteConstraints(809, 140, 127, -1));

        jLabel86.setFont(new java.awt.Font("Tahoma", 0, 10)); // NOI18N
        jLabel86.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel86.setText("LAVADORA Smart 16Kg");
        HOGAR.add(jLabel86, new org.netbeans.lib.awtextra.AbsoluteConstraints(809, 90, 126, -1));

        jLabel87.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel87.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/hogar/lavadora_sams.jpg"))); // NOI18N
        jLabel87.setBorder(new javax.swing.border.LineBorder(new java.awt.Color(0, 0, 0), 1, true));
        HOGAR.add(jLabel87, new org.netbeans.lib.awtextra.AbsoluteConstraints(667, 79, -1, -1));

        jLabel88.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel88.setText("LG");
        HOGAR.add(jLabel88, new org.netbeans.lib.awtextra.AbsoluteConstraints(819, 115, 99, -1));

        jLabel89.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel89.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/hogar/lavadora_whirlpool.jpg"))); // NOI18N
        jLabel89.setBorder(new javax.swing.border.LineBorder(new java.awt.Color(0, 0, 0), 1, true));
        HOGAR.add(jLabel89, new org.netbeans.lib.awtextra.AbsoluteConstraints(46, 351, -1, -1));

        lbCanComLavadora2.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lbCanComLavadora2.setText("0");
        lbCanComLavadora2.setBorder(javax.swing.BorderFactory.createTitledBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)), "Cantidad a Comprar"));
        HOGAR.add(lbCanComLavadora2, new org.netbeans.lib.awtextra.AbsoluteConstraints(190, 479, 140, 45));

        jlPrecio16.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jlPrecio16.setText("0000000");
        HOGAR.add(jlPrecio16, new org.netbeans.lib.awtextra.AbsoluteConstraints(228, 458, 58, -1));

        lbCanLavadora2.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lbCanLavadora2.setText("0");
        lbCanLavadora2.setBorder(javax.swing.BorderFactory.createTitledBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)), "Cantidad Disponible", javax.swing.border.TitledBorder.CENTER, javax.swing.border.TitledBorder.DEFAULT_POSITION));
        HOGAR.add(lbCanLavadora2, new org.netbeans.lib.awtextra.AbsoluteConstraints(188, 412, 127, -1));

        jLabel91.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel91.setText("WHIRLPOOL");
        HOGAR.add(jLabel91, new org.netbeans.lib.awtextra.AbsoluteConstraints(198, 387, 99, -1));

        jLabel92.setFont(new java.awt.Font("Tahoma", 0, 10)); // NOI18N
        jLabel92.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel92.setText(" LAVADORA SILVER 8KG");
        HOGAR.add(jLabel92, new org.netbeans.lib.awtextra.AbsoluteConstraints(188, 362, 127, -1));

        jLabel93.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel93.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/hogar/nevera_lg.jpg"))); // NOI18N
        jLabel93.setBorder(new javax.swing.border.LineBorder(new java.awt.Color(0, 0, 0), 1, true));
        HOGAR.add(jLabel93, new org.netbeans.lib.awtextra.AbsoluteConstraints(350, 351, -1, -1));

        lbCanComNevera1.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lbCanComNevera1.setText("0");
        lbCanComNevera1.setBorder(javax.swing.BorderFactory.createTitledBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)), "Cantidad a Comprar"));
        HOGAR.add(lbCanComNevera1, new org.netbeans.lib.awtextra.AbsoluteConstraints(494, 479, 140, 45));

        jlPrecio17.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jlPrecio17.setText("0000000");
        HOGAR.add(jlPrecio17, new org.netbeans.lib.awtextra.AbsoluteConstraints(532, 458, 58, -1));

        lbCanNevera1.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lbCanNevera1.setText("0");
        lbCanNevera1.setBorder(javax.swing.BorderFactory.createTitledBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)), "Cantidad Disponible", javax.swing.border.TitledBorder.CENTER, javax.swing.border.TitledBorder.DEFAULT_POSITION));
        HOGAR.add(lbCanNevera1, new org.netbeans.lib.awtextra.AbsoluteConstraints(492, 412, 127, -1));

        jLabel95.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel95.setText("LG");
        HOGAR.add(jLabel95, new org.netbeans.lib.awtextra.AbsoluteConstraints(502, 387, 99, -1));

        jLabel96.setFont(new java.awt.Font("Tahoma", 0, 10)); // NOI18N
        jLabel96.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel96.setText("NEVERA  SILVER 437 Lts");
        HOGAR.add(jLabel96, new org.netbeans.lib.awtextra.AbsoluteConstraints(492, 367, 127, -1));

        jLabel97.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel97.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/hogar/nevera_sams.jpg"))); // NOI18N
        jLabel97.setBorder(new javax.swing.border.LineBorder(new java.awt.Color(0, 0, 0), 1, true));
        HOGAR.add(jLabel97, new org.netbeans.lib.awtextra.AbsoluteConstraints(667, 351, -1, -1));

        btnAgregar13.setText("Agregar");
        btnAgregar13.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnAgregar13ActionPerformed(evt);
            }
        });
        HOGAR.add(btnAgregar13, new org.netbeans.lib.awtextra.AbsoluteConstraints(46, 229, -1, -1));

        btnAgregar14.setText("Agregar");
        btnAgregar14.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnAgregar14ActionPerformed(evt);
            }
        });
        HOGAR.add(btnAgregar14, new org.netbeans.lib.awtextra.AbsoluteConstraints(350, 229, -1, -1));

        btnAgregar15.setText("Agregar");
        btnAgregar15.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnAgregar15ActionPerformed(evt);
            }
        });
        HOGAR.add(btnAgregar15, new org.netbeans.lib.awtextra.AbsoluteConstraints(667, 229, -1, -1));

        btnAgregar16.setText("Agregar");
        btnAgregar16.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnAgregar16ActionPerformed(evt);
            }
        });
        HOGAR.add(btnAgregar16, new org.netbeans.lib.awtextra.AbsoluteConstraints(46, 501, -1, -1));

        btnAgregar17.setText("Agregar");
        btnAgregar17.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnAgregar17ActionPerformed(evt);
            }
        });
        HOGAR.add(btnAgregar17, new org.netbeans.lib.awtextra.AbsoluteConstraints(350, 501, -1, -1));

        btnAgregar18.setText("Agregar");
        btnAgregar18.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnAgregar18ActionPerformed(evt);
            }
        });
        HOGAR.add(btnAgregar18, new org.netbeans.lib.awtextra.AbsoluteConstraints(667, 501, -1, -1));

        btnDescontar13.setText("Quitar");
        btnDescontar13.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnDescontar13ActionPerformed(evt);
            }
        });
        HOGAR.add(btnDescontar13, new org.netbeans.lib.awtextra.AbsoluteConstraints(123, 229, -1, -1));

        btnDescontar14.setText("Quitar");
        btnDescontar14.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnDescontar14ActionPerformed(evt);
            }
        });
        HOGAR.add(btnDescontar14, new org.netbeans.lib.awtextra.AbsoluteConstraints(427, 229, -1, -1));

        btnDescontar15.setText("Quitar");
        btnDescontar15.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnDescontar15ActionPerformed(evt);
            }
        });
        HOGAR.add(btnDescontar15, new org.netbeans.lib.awtextra.AbsoluteConstraints(744, 229, -1, -1));

        btnDescontar16.setText("Quitar");
        btnDescontar16.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnDescontar16ActionPerformed(evt);
            }
        });
        HOGAR.add(btnDescontar16, new org.netbeans.lib.awtextra.AbsoluteConstraints(123, 501, -1, -1));

        btnDescontar17.setText("Quitar");
        btnDescontar17.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnDescontar17ActionPerformed(evt);
            }
        });
        HOGAR.add(btnDescontar17, new org.netbeans.lib.awtextra.AbsoluteConstraints(427, 501, -1, -1));

        btnDescontar18.setText("Quitar");
        btnDescontar18.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnDescontar18ActionPerformed(evt);
            }
        });
        HOGAR.add(btnDescontar18, new org.netbeans.lib.awtextra.AbsoluteConstraints(744, 501, -1, -1));

        lbCanComNevera2.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lbCanComNevera2.setText("0");
        lbCanComNevera2.setBorder(javax.swing.BorderFactory.createTitledBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)), "Cantidad a Comprar"));
        HOGAR.add(lbCanComNevera2, new org.netbeans.lib.awtextra.AbsoluteConstraints(811, 479, 140, 45));

        jlPrecio18.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jlPrecio18.setText("0000000");
        HOGAR.add(jlPrecio18, new org.netbeans.lib.awtextra.AbsoluteConstraints(849, 458, 58, -1));

        lbCanNevera2.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lbCanNevera2.setText("0");
        lbCanNevera2.setBorder(javax.swing.BorderFactory.createTitledBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)), "Cantidad Disponible", javax.swing.border.TitledBorder.CENTER, javax.swing.border.TitledBorder.DEFAULT_POSITION));
        HOGAR.add(lbCanNevera2, new org.netbeans.lib.awtextra.AbsoluteConstraints(809, 412, 127, -1));

        jLabel99.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel99.setText("SAMSUNG");
        HOGAR.add(jLabel99, new org.netbeans.lib.awtextra.AbsoluteConstraints(819, 387, 100, -1));

        jLabel100.setFont(new java.awt.Font("Tahoma", 0, 10)); // NOI18N
        jLabel100.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel100.setText("FRENCH DOOR 582 Lts ");
        HOGAR.add(jLabel100, new org.netbeans.lib.awtextra.AbsoluteConstraints(809, 362, 127, -1));

        jLabel101.setText("$");
        HOGAR.add(jLabel101, new org.netbeans.lib.awtextra.AbsoluteConstraints(211, 186, -1, -1));

        jLabel102.setText("$");
        HOGAR.add(jLabel102, new org.netbeans.lib.awtextra.AbsoluteConstraints(520, 186, -1, -1));

        jLabel103.setText("$");
        HOGAR.add(jLabel103, new org.netbeans.lib.awtextra.AbsoluteConstraints(837, 186, -1, -1));

        jLabel104.setText("$");
        HOGAR.add(jLabel104, new org.netbeans.lib.awtextra.AbsoluteConstraints(216, 458, -1, -1));

        jLabel105.setText("$");
        HOGAR.add(jLabel105, new org.netbeans.lib.awtextra.AbsoluteConstraints(520, 458, -1, -1));

        jLabel106.setText("$");
        HOGAR.add(jLabel106, new org.netbeans.lib.awtextra.AbsoluteConstraints(837, 458, -1, -1));

        jLabel107.setText("c/u");
        HOGAR.add(jLabel107, new org.netbeans.lib.awtextra.AbsoluteConstraints(287, 186, -1, -1));

        jLabel108.setText("c/u");
        HOGAR.add(jLabel108, new org.netbeans.lib.awtextra.AbsoluteConstraints(596, 186, -1, -1));

        jLabel109.setText("c/u");
        HOGAR.add(jLabel109, new org.netbeans.lib.awtextra.AbsoluteConstraints(913, 186, -1, -1));

        jLabel110.setText("c/u");
        HOGAR.add(jLabel110, new org.netbeans.lib.awtextra.AbsoluteConstraints(292, 458, -1, -1));

        jLabel111.setText("c/u");
        HOGAR.add(jLabel111, new org.netbeans.lib.awtextra.AbsoluteConstraints(596, 458, -1, -1));

        jLabel112.setText("c/u");
        HOGAR.add(jLabel112, new org.netbeans.lib.awtextra.AbsoluteConstraints(913, 458, -1, -1));

        fondo3.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        fondo3.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/fondo2.jpg"))); // NOI18N
        HOGAR.add(fondo3, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, -1, 610));

        jTabbedPane1.addTab("HOGAR", HOGAR);

        jMenu1.setForeground(new java.awt.Color(0, 141, 167));
        jMenu1.setText("OPCIONES");
        jMenu1.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N

        JMI_comprar.setForeground(new java.awt.Color(0, 141, 167));
        JMI_comprar.setText("Realizar La Compra");
        JMI_comprar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                JMI_comprarActionPerformed(evt);
            }
        });
        jMenu1.add(JMI_comprar);

        jMenuBar1.add(jMenu1);

        jMenu2.setForeground(new java.awt.Color(0, 141, 167));
        jMenu2.setText("SALIR");
        jMenu2.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N

        jMenuItem1.setForeground(new java.awt.Color(0, 141, 167));
        jMenuItem1.setText("Cerrar Sesión");
        jMenuItem1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItem1ActionPerformed(evt);
            }
        });
        jMenu2.add(jMenuItem1);

        jMenuBar1.add(jMenu2);

        setJMenuBar(jMenuBar1);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jTabbedPane1)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jTabbedPane1)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void JMI_comprarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_JMI_comprarActionPerformed
        
       int confirmacion=JOptionPane.showConfirmDialog(null,"Quieres Efectuar la Compra");
       if(confirmacion==1 || confirmacion==2){
           System.out.println("entro al if");
           limpiar();
           mostarcantidad();
           
       }else{
            System.out.println("entro al else");
            Verificar();
       }
    }//GEN-LAST:event_JMI_comprarActionPerformed

    private void btnAgregar1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnAgregar1ActionPerformed
        btnDescontar1.setEnabled(true);       
        res=Integer.parseInt(lbCanIphone.getText());
        if (res>0) {
            res=res-1;
            lbCanIphone.setText(""+res);
            sum=sum+1;
            lbCanComIphone.setText(""+sum);
        }if (res<=0) {
            btnAgregar1.setEnabled(false);
        }
    }//GEN-LAST:event_btnAgregar1ActionPerformed

    private void btnAgregar2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnAgregar2ActionPerformed
       btnDescontar2.setEnabled(true);       
        res1=Integer.parseInt(lbCanP20.getText());
        if (res1>0) {
            res1=res1-1;
            lbCanP20.setText(""+res1);
            sum1=sum1+1;
            lbCanComP20.setText(""+sum1);
        }if (res1<=0) {
            btnAgregar2.setEnabled(false);
        }
    }//GEN-LAST:event_btnAgregar2ActionPerformed

    private void btnAgregar3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnAgregar3ActionPerformed
        btnDescontar3.setEnabled(true);       
        res2=Integer.parseInt(lbCanAsus.getText());
        if (res2>0) {
            res2=res2-1;
            lbCanAsus.setText(""+res2);
            sum2=sum2+1;
            lbCanComAsus.setText(""+sum2);
        }if (res2<=0) {
            btnAgregar3.setEnabled(false);
        }
    }//GEN-LAST:event_btnAgregar3ActionPerformed

    private void btnAgregar4ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnAgregar4ActionPerformed
        btnDescontar4.setEnabled(true);       
        res3=Integer.parseInt(lbCanHP.getText());
        if (res3>0) {
            res3=res3-1;
            lbCanHP.setText(""+res3);
            sum3=sum3+1;
            lbCanComHP.setText(""+sum3);
        }if (res3<=0) {
            btnAgregar4.setEnabled(false);
        }
    }//GEN-LAST:event_btnAgregar4ActionPerformed

    private void btnAgregar5ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnAgregar5ActionPerformed
        btnDescontar5.setEnabled(true);       
        res4=Integer.parseInt(lbCanLgTv.getText());
        if (res4>0) {
            res4=res4-1;
            lbCanLgTv.setText(""+res4);
            sum4=sum4+1;
            lbCanComLgTv.setText(""+sum4);
        }if (res4<=0) {
            btnAgregar5.setEnabled(false);
        }
    }//GEN-LAST:event_btnAgregar5ActionPerformed

    private void btnAgregar6ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnAgregar6ActionPerformed
        btnDescontar6.setEnabled(true);       
        res5=Integer.parseInt(lbCanSamTv.getText());
        if (res5>0) {
            res5=res5-1;
            lbCanSamTv.setText(""+res5);
            sum5=sum5+1;
            lbCanComSamTv.setText(""+sum5);
        }if (res5<=0) {
            btnAgregar6.setEnabled(false);
        }
    }//GEN-LAST:event_btnAgregar6ActionPerformed

    private void btnAgregar7ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnAgregar7ActionPerformed
        btnDescontar7.setEnabled(true);       
        res6=Integer.parseInt(lbCanTiida.getText());
        if (res6>0) {
            res6=res6-1;
            lbCanTiida.setText(""+res6);
            sum6=sum6+1;
            lbCanComTiida.setText(""+sum6);
        }if (res6<=0) {
            btnAgregar7.setEnabled(false);
        }
    }//GEN-LAST:event_btnAgregar7ActionPerformed

    private void btnAgregar8ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnAgregar8ActionPerformed
        btnDescontar8.setEnabled(true);       
        res7=Integer.parseInt(lbCanSwift.getText());
        if (res7>0) {
            res7=res7-1;
            lbCanSwift.setText(""+res7);
            sum7=sum7+1;
            lbCanComSwift.setText(""+sum7);
        }if (res7<=0) {
            btnAgregar8.setEnabled(false);
        }
    }//GEN-LAST:event_btnAgregar8ActionPerformed

    private void btnAgregar9ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnAgregar9ActionPerformed
        btnDescontar9.setEnabled(true);       
        res8=Integer.parseInt(lbCanHightower.getText());
        if (res8>0) {
            res8=res8-1;
            lbCanHightower.setText(""+res8);
            sum8=sum8+1;
            lbCanComHightower.setText(""+sum8);
        }if (res8<=0) {
            btnAgregar9.setEnabled(false);
        }
    }//GEN-LAST:event_btnAgregar9ActionPerformed

    private void btnAgregar10ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnAgregar10ActionPerformed
        btnDescontar10.setEnabled(true);       
        res9=Integer.parseInt(lbCanSpark.getText());
        if (res9>0) {
            res9=res9-1;
            lbCanSpark.setText(""+res9);
            sum9=sum9+1;
            lbCanComSpark.setText(""+sum9);
        }if (res9<=0) {
            btnAgregar10.setEnabled(false);
        }
    }//GEN-LAST:event_btnAgregar10ActionPerformed

    private void btnAgregar11ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnAgregar11ActionPerformed
        btnDescontar11.setEnabled(true);       
        res10=Integer.parseInt(lbCanHonda.getText());
        if (res10>0) {
            res10=res10-1;
            lbCanHonda.setText(""+res10);
            sum10=sum10+1;
            lbCanComHonda.setText(""+sum10);
        }if (res10<=0) {
            btnAgregar11.setEnabled(false);
        }
    }//GEN-LAST:event_btnAgregar11ActionPerformed

    private void btnAgregar12ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnAgregar12ActionPerformed
        btnDescontar12.setEnabled(true);       
        res11=Integer.parseInt(lbCanYamaha.getText());
        if (res11>0) {
            res11=res11-1;
            lbCanYamaha.setText(""+res11);
            sum11=sum11+1;
            lbCanComYamaha.setText(""+sum11);
        }if (res11<=0) {
            btnAgregar12.setEnabled(false);
        }
    }//GEN-LAST:event_btnAgregar12ActionPerformed

    private void btnAgregar13ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnAgregar13ActionPerformed
        btnDescontar13.setEnabled(true);       
        res12=Integer.parseInt(lbCanEstufa1.getText());
        if (res12>0) {
            res12=res12-1;
            lbCanEstufa1.setText(""+res12);
            sum12=sum12+1;
            lbCanComEstufa1.setText(""+sum12);
        }if (res12<=0) {
            btnAgregar13.setEnabled(false);
        }
    }//GEN-LAST:event_btnAgregar13ActionPerformed

    private void btnAgregar14ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnAgregar14ActionPerformed
        btnDescontar14.setEnabled(true);       
        res13=Integer.parseInt(lbCanEstufa2.getText());
        if (res13>0) {
            res13=res13-1;
            lbCanEstufa2.setText(""+res13);
            sum13=sum13+1;
            lbCanComEstufa2.setText(""+sum13);
        }if (res13<=0) {
            btnAgregar14.setEnabled(false);
        }
    }//GEN-LAST:event_btnAgregar14ActionPerformed

    private void btnAgregar15ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnAgregar15ActionPerformed
        btnDescontar15.setEnabled(true);       
        res14=Integer.parseInt(lbCanLavadora1.getText());
        if (res14>0) {
            res14=res14-1;
            lbCanLavadora1.setText(""+res14);
            sum14=sum14+1;
            lbCanComLavadora1.setText(""+sum14);
        }if (res14<=0) {
            btnAgregar15.setEnabled(false);
        }
    }//GEN-LAST:event_btnAgregar15ActionPerformed

    private void btnAgregar16ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnAgregar16ActionPerformed
        btnDescontar16.setEnabled(true);       
        res15=Integer.parseInt(lbCanLavadora2.getText());
        if (res15>0) {
            res15=res15-1;
            lbCanLavadora2.setText(""+res15);
            sum15=sum15+1;
            lbCanComLavadora2.setText(""+sum15);
        }if (res15<=0) {
            btnAgregar16.setEnabled(false);
        }
    }//GEN-LAST:event_btnAgregar16ActionPerformed

    private void btnAgregar17ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnAgregar17ActionPerformed
        btnDescontar17.setEnabled(true);       
        res16=Integer.parseInt(lbCanNevera1.getText());
        if (res16>0) {
            res16=res16-1;
            lbCanNevera1.setText(""+res16);
            sum16=sum16+1;
            lbCanComNevera1.setText(""+sum16);
        }if (res16<=0) {
            btnAgregar17.setEnabled(false);
        }
    }//GEN-LAST:event_btnAgregar17ActionPerformed

    private void btnAgregar18ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnAgregar18ActionPerformed
        btnDescontar18.setEnabled(true);       
        res17=Integer.parseInt(lbCanNevera2.getText());
        if (res17>0) {
            res17=res17-1;
            lbCanNevera2.setText(""+res17);
            sum17=sum17+1;
            lbCanComNevera2.setText(""+sum17);
        }if (res17<=0) {
            btnAgregar18.setEnabled(false);
        }
    }//GEN-LAST:event_btnAgregar18ActionPerformed

    private void btnDescontar1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnDescontar1ActionPerformed
        btnAgregar1.setEnabled(true);        
        con=Integer.parseInt(lbCanComIphone.getText());
        if (con>0) {
            sum=sum-1;
            lbCanComIphone.setText(""+sum);            
            res=res+1;
            lbCanIphone.setText(""+res);            
        }if (con<=1) {
            btnDescontar1.setEnabled(false);
        }
    }//GEN-LAST:event_btnDescontar1ActionPerformed

    private void btnDescontar2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnDescontar2ActionPerformed
        btnAgregar2.setEnabled(true);        
        con1=Integer.parseInt(lbCanComP20.getText());
        if (con1>0) {
            sum1=sum1-1;
            lbCanComP20.setText(""+sum1);            
            res1=res1+1;
            lbCanP20.setText(""+res1);            
        }if (con1<=1) {
            btnDescontar2.setEnabled(false);
        }
    }//GEN-LAST:event_btnDescontar2ActionPerformed

    private void btnDescontar3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnDescontar3ActionPerformed
        btnAgregar3.setEnabled(true);        
        con2=Integer.parseInt(lbCanComAsus.getText());
        if (con2>0) {
            sum2=sum2-1;
            lbCanComAsus.setText(""+sum2);            
            res2=res2+1;
            lbCanAsus.setText(""+res2);            
        }if (con2<=1) {
            btnDescontar3.setEnabled(false);
        }
    }//GEN-LAST:event_btnDescontar3ActionPerformed

    private void btnDescontar4ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnDescontar4ActionPerformed
        btnAgregar4.setEnabled(true);        
        con3=Integer.parseInt(lbCanComHP.getText());
        if (con3>0) {
            sum3=sum3-1;
            lbCanComHP.setText(""+sum3);            
            res3=res3+1;
            lbCanHP.setText(""+res3);            
        }if (con3<=1) {
            btnDescontar4.setEnabled(false);
        }
    }//GEN-LAST:event_btnDescontar4ActionPerformed

    private void btnDescontar5ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnDescontar5ActionPerformed
        btnAgregar5.setEnabled(true);        
        con4=Integer.parseInt(lbCanComLgTv.getText());
        if (con4>0) {
            sum4=sum4-1;
            lbCanComLgTv.setText(""+sum4);            
            res4=res4+1;
            lbCanLgTv.setText(""+res4);            
        }if (con4<=1) {
            btnDescontar5.setEnabled(false);
        }
    }//GEN-LAST:event_btnDescontar5ActionPerformed

    private void btnDescontar6ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnDescontar6ActionPerformed
        btnAgregar6.setEnabled(true);        
        con5=Integer.parseInt(lbCanComSamTv.getText());
        if (con5>0) {
            sum5=sum5-1;
            lbCanComSamTv.setText(""+sum5);            
            res5=res5+1;
            lbCanSamTv.setText(""+res5);            
        }if (con5<=1) {
            btnDescontar6.setEnabled(false);
        }
    }//GEN-LAST:event_btnDescontar6ActionPerformed

    private void btnDescontar7ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnDescontar7ActionPerformed
        btnAgregar7.setEnabled(true);        
        con6=Integer.parseInt(lbCanComTiida.getText());
        if (con6>0) {
            sum6=sum6-1;
            lbCanComTiida.setText(""+sum6);            
            res6=res6+1;
            lbCanTiida.setText(""+res6);            
        }if (con6<=1) {
            btnDescontar7.setEnabled(false);
        }
    }//GEN-LAST:event_btnDescontar7ActionPerformed

    private void btnDescontar8ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnDescontar8ActionPerformed
        btnAgregar8.setEnabled(true);        
        con7=Integer.parseInt(lbCanComSwift.getText());
        if (con7>0) {
            sum7=sum7-1;
            lbCanComSwift.setText(""+sum7);            
            res7=res7+1;
            lbCanSwift.setText(""+res7);            
        }if (con7<=1) {
            btnDescontar8.setEnabled(false);
        }
    }//GEN-LAST:event_btnDescontar8ActionPerformed

    private void btnDescontar9ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnDescontar9ActionPerformed
        btnAgregar9.setEnabled(true);        
        con8=Integer.parseInt(lbCanComHightower.getText());
        if (con8>0) {
            sum8=sum8-1;
            lbCanComHightower.setText(""+sum8);            
            res8=res8+1;
            lbCanHightower.setText(""+res8);            
        }if (con8<=1) {
            btnDescontar9.setEnabled(false);
        }
    }//GEN-LAST:event_btnDescontar9ActionPerformed

    private void btnDescontar10ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnDescontar10ActionPerformed
        btnAgregar10.setEnabled(true);        
        con9=Integer.parseInt(lbCanComSpark.getText());
        if (con>0) {
            sum9=sum9-1;
            lbCanComSpark.setText(""+sum9);            
            res9=res9+1;
            lbCanSpark.setText(""+res9);            
        }if (con9<=1) {
            btnDescontar10.setEnabled(false);
        }
    }//GEN-LAST:event_btnDescontar10ActionPerformed

    private void btnDescontar11ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnDescontar11ActionPerformed
        btnAgregar11.setEnabled(true);        
        con10=Integer.parseInt(lbCanComHonda.getText());
        if (con10>0) {
            sum10=sum10-1;
            lbCanComHonda.setText(""+sum10);            
            res10=res10+1;
            lbCanHonda.setText(""+res10);            
        }if (con10<=1) {
            btnDescontar11.setEnabled(false);
        }
    }//GEN-LAST:event_btnDescontar11ActionPerformed

    private void btnDescontar12ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnDescontar12ActionPerformed
        btnAgregar12.setEnabled(true);        
        con11=Integer.parseInt(lbCanComYamaha.getText());
        if (con11>0) {
            sum11=sum11-1;
            lbCanComYamaha.setText(""+sum11);            
            res11=res11+1;
            lbCanYamaha.setText(""+res11);            
        }if (con11<=1) {
            btnDescontar12.setEnabled(false);
        }
    }//GEN-LAST:event_btnDescontar12ActionPerformed

    private void btnDescontar13ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnDescontar13ActionPerformed
        btnAgregar13.setEnabled(true);        
        con12=Integer.parseInt(lbCanComEstufa1.getText());
        if (con12>0) {
            sum12=sum12-1;
            lbCanComEstufa1.setText(""+sum12);            
            res12=res12+1;
            lbCanEstufa1.setText(""+res12);            
        }if (con12<=1) {
            btnDescontar13.setEnabled(false);
        }
    }//GEN-LAST:event_btnDescontar13ActionPerformed

    private void btnDescontar14ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnDescontar14ActionPerformed
        btnAgregar14.setEnabled(true);        
        con13=Integer.parseInt(lbCanComEstufa2.getText());
        if (con13>0) {
            sum13=sum13-1;
            lbCanComEstufa2.setText(""+sum13);            
            res13=res13+1;
            lbCanEstufa2.setText(""+res13);            
        }if (con13<=1) {
            btnDescontar14.setEnabled(false);
        }
    }//GEN-LAST:event_btnDescontar14ActionPerformed

    private void btnDescontar15ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnDescontar15ActionPerformed
        btnAgregar15.setEnabled(true);        
         con14=Integer.parseInt(lbCanComLavadora1.getText());
         if (con14>0) {
             sum14=sum14-1;
             lbCanComLavadora1.setText(""+sum14);            
             res14=res14+1;
             lbCanLavadora1.setText(""+res14);            
         }if (con14<=1) {
             btnDescontar15.setEnabled(false);
         }
    }//GEN-LAST:event_btnDescontar15ActionPerformed

    private void btnDescontar16ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnDescontar16ActionPerformed
        btnAgregar16.setEnabled(true);        
        con15=Integer.parseInt(lbCanComLavadora2.getText());
        if (con15>0) {
            sum15=sum15-1;
            lbCanComLavadora2.setText(""+sum15);            
            res15=res15+1;
            lbCanLavadora2.setText(""+res15);            
        }if (con15<=1) {
            btnDescontar16.setEnabled(false);
        }
    }//GEN-LAST:event_btnDescontar16ActionPerformed

    private void btnDescontar17ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnDescontar17ActionPerformed
        btnAgregar17.setEnabled(true);        
         con16=Integer.parseInt(lbCanComNevera1.getText());
         if (con16>0) {
             sum16=sum16-1;
             lbCanComNevera1.setText(""+sum16);            
             res16=res16+1;
             lbCanNevera1.setText(""+res16);            
         }if (con16<=1) {
             btnDescontar17.setEnabled(false);
         }
    }//GEN-LAST:event_btnDescontar17ActionPerformed

    private void btnDescontar18ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnDescontar18ActionPerformed
        btnAgregar18.setEnabled(true);        
        con17=Integer.parseInt(lbCanComNevera2.getText());
        if (con17>0) {
            sum17=sum17-1;
            lbCanComNevera2.setText(""+sum17);            
            res17=res17+1;
            lbCanNevera2.setText(""+res17);            
        }if (con17<=1) {
            btnDescontar18.setEnabled(false);
        }
    }//GEN-LAST:event_btnDescontar18ActionPerformed

    private void jMenuItem1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItem1ActionPerformed
       JOptionPane.showMessageDialog(null," VUELVE PRONTO ","Cierre de Sesion",JOptionPane.INFORMATION_MESSAGE,logout);
       index indice=new index();
       indice.setVisible(true);
       dispose();
    }//GEN-LAST:event_jMenuItem1ActionPerformed
   
    

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JPanel AUTOMOTO;
    private javax.swing.JLabel Fondo1;
    private javax.swing.JPanel HOGAR;
    private javax.swing.JMenuItem JMI_comprar;
    private javax.swing.JPanel TECNOLOGIA;
    private javax.swing.JButton btnAgregar1;
    private javax.swing.JButton btnAgregar10;
    private javax.swing.JButton btnAgregar11;
    private javax.swing.JButton btnAgregar12;
    private javax.swing.JButton btnAgregar13;
    private javax.swing.JButton btnAgregar14;
    private javax.swing.JButton btnAgregar15;
    private javax.swing.JButton btnAgregar16;
    private javax.swing.JButton btnAgregar17;
    private javax.swing.JButton btnAgregar18;
    private javax.swing.JButton btnAgregar2;
    private javax.swing.JButton btnAgregar3;
    private javax.swing.JButton btnAgregar4;
    private javax.swing.JButton btnAgregar5;
    private javax.swing.JButton btnAgregar6;
    private javax.swing.JButton btnAgregar7;
    private javax.swing.JButton btnAgregar8;
    private javax.swing.JButton btnAgregar9;
    private javax.swing.JButton btnDescontar1;
    private javax.swing.JButton btnDescontar10;
    private javax.swing.JButton btnDescontar11;
    private javax.swing.JButton btnDescontar12;
    private javax.swing.JButton btnDescontar13;
    private javax.swing.JButton btnDescontar14;
    private javax.swing.JButton btnDescontar15;
    private javax.swing.JButton btnDescontar16;
    private javax.swing.JButton btnDescontar17;
    private javax.swing.JButton btnDescontar18;
    private javax.swing.JButton btnDescontar2;
    private javax.swing.JButton btnDescontar3;
    private javax.swing.JButton btnDescontar4;
    private javax.swing.JButton btnDescontar5;
    private javax.swing.JButton btnDescontar6;
    private javax.swing.JButton btnDescontar7;
    private javax.swing.JButton btnDescontar8;
    private javax.swing.JButton btnDescontar9;
    private javax.swing.JLabel fondo2;
    private javax.swing.JLabel fondo3;
    private javax.swing.JLabel jLabel100;
    private javax.swing.JLabel jLabel101;
    private javax.swing.JLabel jLabel102;
    private javax.swing.JLabel jLabel103;
    private javax.swing.JLabel jLabel104;
    private javax.swing.JLabel jLabel105;
    private javax.swing.JLabel jLabel106;
    private javax.swing.JLabel jLabel107;
    private javax.swing.JLabel jLabel108;
    private javax.swing.JLabel jLabel109;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel110;
    private javax.swing.JLabel jLabel111;
    private javax.swing.JLabel jLabel112;
    private javax.swing.JLabel jLabel115;
    private javax.swing.JLabel jLabel116;
    private javax.swing.JLabel jLabel117;
    private javax.swing.JLabel jLabel118;
    private javax.swing.JLabel jLabel119;
    private javax.swing.JLabel jLabel12;
    private javax.swing.JLabel jLabel120;
    private javax.swing.JLabel jLabel121;
    private javax.swing.JLabel jLabel122;
    private javax.swing.JLabel jLabel123;
    private javax.swing.JLabel jLabel124;
    private javax.swing.JLabel jLabel125;
    private javax.swing.JLabel jLabel126;
    private javax.swing.JLabel jLabel127;
    private javax.swing.JLabel jLabel128;
    private javax.swing.JLabel jLabel129;
    private javax.swing.JLabel jLabel13;
    private javax.swing.JLabel jLabel130;
    private javax.swing.JLabel jLabel131;
    private javax.swing.JLabel jLabel132;
    private javax.swing.JLabel jLabel133;
    private javax.swing.JLabel jLabel134;
    private javax.swing.JLabel jLabel135;
    private javax.swing.JLabel jLabel136;
    private javax.swing.JLabel jLabel137;
    private javax.swing.JLabel jLabel138;
    private javax.swing.JLabel jLabel14;
    private javax.swing.JLabel jLabel15;
    private javax.swing.JLabel jLabel17;
    private javax.swing.JLabel jLabel18;
    private javax.swing.JLabel jLabel20;
    private javax.swing.JLabel jLabel21;
    private javax.swing.JLabel jLabel22;
    private javax.swing.JLabel jLabel23;
    private javax.swing.JLabel jLabel25;
    private javax.swing.JLabel jLabel27;
    private javax.swing.JLabel jLabel28;
    private javax.swing.JLabel jLabel29;
    private javax.swing.JLabel jLabel30;
    private javax.swing.JLabel jLabel31;
    private javax.swing.JLabel jLabel33;
    private javax.swing.JLabel jLabel35;
    private javax.swing.JLabel jLabel36;
    private javax.swing.JLabel jLabel37;
    private javax.swing.JLabel jLabel39;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel40;
    private javax.swing.JLabel jLabel42;
    private javax.swing.JLabel jLabel43;
    private javax.swing.JLabel jLabel44;
    private javax.swing.JLabel jLabel46;
    private javax.swing.JLabel jLabel47;
    private javax.swing.JLabel jLabel48;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel50;
    private javax.swing.JLabel jLabel51;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel77;
    private javax.swing.JLabel jLabel79;
    private javax.swing.JLabel jLabel80;
    private javax.swing.JLabel jLabel82;
    private javax.swing.JLabel jLabel83;
    private javax.swing.JLabel jLabel84;
    private javax.swing.JLabel jLabel86;
    private javax.swing.JLabel jLabel87;
    private javax.swing.JLabel jLabel88;
    private javax.swing.JLabel jLabel89;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JLabel jLabel91;
    private javax.swing.JLabel jLabel92;
    private javax.swing.JLabel jLabel93;
    private javax.swing.JLabel jLabel95;
    private javax.swing.JLabel jLabel96;
    private javax.swing.JLabel jLabel97;
    private javax.swing.JLabel jLabel99;
    private javax.swing.JMenu jMenu1;
    private javax.swing.JMenu jMenu2;
    private javax.swing.JMenuBar jMenuBar1;
    private javax.swing.JMenuItem jMenuItem1;
    private javax.swing.JTabbedPane jTabbedPane1;
    private javax.swing.JLabel jlPrecio1;
    private javax.swing.JLabel jlPrecio10;
    private javax.swing.JLabel jlPrecio11;
    private javax.swing.JLabel jlPrecio12;
    private javax.swing.JLabel jlPrecio13;
    private javax.swing.JLabel jlPrecio14;
    private javax.swing.JLabel jlPrecio15;
    private javax.swing.JLabel jlPrecio16;
    private javax.swing.JLabel jlPrecio17;
    private javax.swing.JLabel jlPrecio18;
    private javax.swing.JLabel jlPrecio2;
    private javax.swing.JLabel jlPrecio3;
    private javax.swing.JLabel jlPrecio4;
    private javax.swing.JLabel jlPrecio5;
    private javax.swing.JLabel jlPrecio6;
    private javax.swing.JLabel jlPrecio7;
    private javax.swing.JLabel jlPrecio8;
    private javax.swing.JLabel jlPrecio9;
    private javax.swing.JLabel lbCanAsus;
    private javax.swing.JLabel lbCanComAsus;
    private javax.swing.JLabel lbCanComEstufa1;
    private javax.swing.JLabel lbCanComEstufa2;
    private javax.swing.JLabel lbCanComHP;
    private javax.swing.JLabel lbCanComHightower;
    private javax.swing.JLabel lbCanComHonda;
    private javax.swing.JLabel lbCanComIphone;
    private javax.swing.JLabel lbCanComLavadora1;
    private javax.swing.JLabel lbCanComLavadora2;
    private javax.swing.JLabel lbCanComLgTv;
    private javax.swing.JLabel lbCanComNevera1;
    private javax.swing.JLabel lbCanComNevera2;
    private javax.swing.JLabel lbCanComP20;
    private javax.swing.JLabel lbCanComSamTv;
    private javax.swing.JLabel lbCanComSpark;
    private javax.swing.JLabel lbCanComSwift;
    private javax.swing.JLabel lbCanComTiida;
    private javax.swing.JLabel lbCanComYamaha;
    private javax.swing.JLabel lbCanEstufa1;
    private javax.swing.JLabel lbCanEstufa2;
    private javax.swing.JLabel lbCanHP;
    private javax.swing.JLabel lbCanHightower;
    private javax.swing.JLabel lbCanHonda;
    private javax.swing.JLabel lbCanIphone;
    private javax.swing.JLabel lbCanLavadora1;
    private javax.swing.JLabel lbCanLavadora2;
    private javax.swing.JLabel lbCanLgTv;
    private javax.swing.JLabel lbCanNevera1;
    private javax.swing.JLabel lbCanNevera2;
    private javax.swing.JLabel lbCanP20;
    private javax.swing.JLabel lbCanSamTv;
    private javax.swing.JLabel lbCanSpark;
    private javax.swing.JLabel lbCanSwift;
    private javax.swing.JLabel lbCanTiida;
    private javax.swing.JLabel lbCanYamaha;
    // End of variables declaration//GEN-END:variables
}
