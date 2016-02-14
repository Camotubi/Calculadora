package calculadora_gui;

import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;
public class Cuadratica {
public  void cuadratica() {
JTextField a = new JTextField(4);
JTextField b = new JTextField(4);
JTextField c= new JTextField(4);
double x1,x2,d,e,f;
JPanel myPanel = new JPanel();
myPanel.add(new JLabel("a:"));

myPanel.add(a);
myPanel.add(new JLabel("b:"));

myPanel.add(b);
myPanel.add(new JLabel("c:"));

myPanel.add(c);

float ec1 = JOptionPane.showConfirmDialog(null, myPanel, 
         "Intoduzca coeficientes de ecuacion", JOptionPane.OK_CANCEL_OPTION);
if (ec1 == JOptionPane.OK_OPTION ) {
	  d=Float.parseFloat(a.getText());
	   e=Float.parseFloat(b.getText());
	    f=Float.parseFloat(c.getText());
	x1= (-e+(Math.sqrt(((e*e)-4*d*f))))/(2*d);
	x2= (-e-(Math.sqrt(((e*e)-4*d*f))))/(2*d);
	JOptionPane.showMessageDialog(null,"x1= "+x1+'\n'+"x2= "+x2);
}

}}