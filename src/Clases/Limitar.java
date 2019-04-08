package Clases;
import javax.swing.JOptionPane;
import javax.swing.text.AttributeSet;
import javax.swing.text.BadLocationException;
import javax.swing.text.PlainDocument;

class Limitar extends PlainDocument {
    private int limite;
        
    public Limitar(int i){
        super();//llamando la superclase
        this.limite=i;
    }
    //con este metodo ya no sera posible ingresar mas de N numeros.
    public void insertString(int compesación, String str, AttributeSet attr) throws BadLocationException{
        if (str==null)return;
        if ((getLength()+str.length())<= limite){
            //enviando al string recortado
            super.insertString(compesación, str, attr);   
            
        }else{
            JOptionPane.showMessageDialog(null,"Limite de caracteres superados");
        }
    }    
}
