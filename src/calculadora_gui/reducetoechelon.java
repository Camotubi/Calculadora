package calculadora_gui;
import javax.swing.Box;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;
public class reducetoechelon {
	public  void matrix() {
		String grado = String.valueOf(
				(JOptionPane.showInputDialog(null, "Escoja la cantidad de variables","Linear Equation Mode",
				JOptionPane.INFORMATION_MESSAGE,null, new Object[]{ "2", "3"}, "2"
				)));
		int grado1=Integer.parseInt(grado) ;
		 
		if (grado1==2){
		float [][] matriz2;
			matriz2= new float [2][3];
			JTextField a = new JTextField(4);
		      JTextField b = new JTextField(4);
		      JTextField c= new JTextField(4);
		      JTextField d = new JTextField(4);
		      JTextField e = new JTextField(4);
		      JTextField f = new JTextField(4);


		      JPanel myPanel = new JPanel();
		      myPanel.add(new JLabel("a:"));
		      myPanel.add(a);
		      myPanel.add(Box.createHorizontalStrut(15)); // a spacer
		      myPanel.add(new JLabel("b:"));
		      myPanel.add(b);
		      myPanel.add(new JLabel("c:"));
		      myPanel.add(c);
		  
		     float ec1 = JOptionPane.showConfirmDialog(null, myPanel, 
		               "Intoduzca primera ecuacion", JOptionPane.OK_CANCEL_OPTION);
		     
		      JPanel myPanel2 = new JPanel();
		      myPanel2.add(new JLabel("d:"));
		      myPanel2.add(d);
		      myPanel2.add(Box.createHorizontalStrut(15)); 
		      myPanel2.add(new JLabel("e:"));
		      myPanel2.add(e);
		      myPanel2.add(new JLabel("f:"));
		      myPanel2.add(f);
		  
		      int ec2 = JOptionPane.showConfirmDialog(null, myPanel2, 
		               "Intoduzca segunda ecuacion", JOptionPane.OK_CANCEL_OPTION);
		      if (ec1 == JOptionPane.OK_OPTION && ec2 == JOptionPane.OK_OPTION) {
		    matriz2[0][0]=Float.parseFloat(a.getText());
		    matriz2[0][1]=Float.parseFloat(b.getText());
		    matriz2[0][2]=Float.parseFloat(c.getText());
		    matriz2[1][0]=Float.parseFloat(d.getText());
		    matriz2[1][1]=Float.parseFloat(e.getText());
		    matriz2[1][2]=Float.parseFloat(f.getText());
		      }
		     
		      if(matriz2[0][0] !=1){
		    	  
		    	  matriz2[0][1]= matriz2[0][1]*(1/ matriz2[0][0]);
		    	  matriz2[0][2]= matriz2[0][2]*(1/ matriz2[0][0]);
		    	  matriz2[0][0]= matriz2[0][0]*(1/ matriz2[0][0]);
		    	  }
		    	  if(matriz2[1][0]!=0){
		    		  matriz2[1][1]= matriz2[1][1]-(matriz2[1][0]*matriz2[0][1]);
		    		  matriz2[1][2]= matriz2[1][2]-(matriz2[1][0]*matriz2[0][2]);
		    		  matriz2[1][0]= matriz2[1][0]-(matriz2[1][0]*matriz2[0][0]);
		    	  }
		    	  if(matriz2[1][1] !=1 ){
			    	  matriz2[1][2]= matriz2[1][2]*(1/ matriz2[1][1]);
			    	  matriz2[1][1]= 1;}
		    	  if(matriz2[0][1]!=0){
		    		  
		    		  matriz2[0][2]=matriz2[0][2]-(matriz2[0][1]*matriz2[1][2]);
		    				  matriz2[0][1]=0;
		    	  }
			    	  
		      JOptionPane.showMessageDialog(null,"x1= "+matriz2[0][2]+"    x2= "+matriz2[1][2]);
		      System.out.println(matriz2[0][0]+" "+ matriz2[0][1]+" "+ matriz2[0][2]);
		      System.out.println(matriz2[1][0]+" "+ matriz2[1][1]+" "+ matriz2[1][2]);
		
		}
		if (grado1==3){
			float [][] matriz2;
				matriz2= new float [3][4];
				JTextField a = new JTextField(5);
			      JTextField b = new JTextField(5);
			      JTextField c= new JTextField(5);
			      JTextField d = new JTextField(5);
			      JTextField e = new JTextField(5);
			      JTextField f = new JTextField(5);
			      JTextField g = new JTextField(5);
			      JTextField h = new JTextField(5);
			      JTextField i = new JTextField(5);
			      JTextField j = new JTextField(5);
			      JTextField k = new JTextField(5);
			      JTextField l = new JTextField(5);


			      JPanel myPanel = new JPanel();
			      myPanel.add(new JLabel("a:"));
			      myPanel.add(a);
			      myPanel.add(Box.createHorizontalStrut(15)); // a spacer
			      myPanel.add(new JLabel("b:"));
			      myPanel.add(b);
			      myPanel.add(new JLabel("c:"));
			      myPanel.add(c);
			      myPanel.add(new JLabel("d:"));
			      myPanel.add(d);
			     float ec1 = JOptionPane.showConfirmDialog(null, myPanel, 
			               "Intoduzca primera ecuacion", JOptionPane.OK_CANCEL_OPTION);
			     
			      JPanel myPanel2 = new JPanel();
			      myPanel2.add(Box.createHorizontalStrut(15)); 
			      myPanel2.add(new JLabel("e:"));
			      myPanel2.add(e);
			      myPanel2.add(new JLabel("f:"));
			      myPanel2.add(f);
			      myPanel2.add(new JLabel("g:"));
			      myPanel2.add(g);
			      myPanel2.add(new JLabel("h:"));
			      myPanel2.add(h);
			  
			      int ec2 = JOptionPane.showConfirmDialog(null, myPanel2, 
			               "Intoduzca segunda ecuacion", JOptionPane.OK_CANCEL_OPTION);
			      JPanel myPanel3 = new JPanel();
			      myPanel3.add(new JLabel("i:"));
			      myPanel3.add(i);
			      myPanel3.add(Box.createHorizontalStrut(15)); 
			      myPanel3.add(new JLabel("j:"));
			      myPanel3.add(j);
			      myPanel3.add(new JLabel("k:"));
			      myPanel3.add(k);
			      myPanel3.add(new JLabel("l:"));
			      myPanel3.add(l);
			  
			      int ec3 = JOptionPane.showConfirmDialog(null, myPanel3, 
			               "Intoduzca tercera ecuacion", JOptionPane.OK_CANCEL_OPTION);
			      if (ec1 == JOptionPane.OK_OPTION && ec2 == JOptionPane.OK_OPTION && ec3 == JOptionPane.OK_OPTION) {
			    matriz2[0][0]=Float.parseFloat(a.getText());
			    matriz2[0][1]=Float.parseFloat(b.getText());
			    matriz2[0][2]=Float.parseFloat(c.getText());
			    matriz2[0][3]=Float.parseFloat(d.getText());
			    matriz2[1][0]=Float.parseFloat(e.getText());
			    matriz2[1][1]=Float.parseFloat(f.getText());
			    matriz2[1][2]=Float.parseFloat(g.getText());
			    matriz2[1][3]=Float.parseFloat(h.getText());
			    matriz2[2][0]=Float.parseFloat(i.getText());
			    matriz2[2][1]=Float.parseFloat(j.getText());
			    matriz2[2][2]=Float.parseFloat(k.getText());
			    matriz2[2][3]=Float.parseFloat(l.getText());
			    
			      }
			     
			      if(matriz2[0][0] !=1){
			    	  
			    	  matriz2[0][1]= matriz2[0][1]*(1/ matriz2[0][0]);
			    	  matriz2[0][2]= matriz2[0][2]*(1/ matriz2[0][0]); 
			    	  matriz2[0][3]= matriz2[0][3]*(1/ matriz2[0][0]);
			    	  matriz2[0][0]= matriz2[0][0]*(1/ matriz2[0][0]);
			    	  }
			    	  if(matriz2[1][0]!=0){
			    		  matriz2[1][1]= matriz2[1][1]-(matriz2[1][0]*matriz2[0][1]);
			    		  matriz2[1][2]= matriz2[1][2]-(matriz2[1][0]*matriz2[0][2]);
			    		  matriz2[1][3]= matriz2[1][3]-(matriz2[1][0]*matriz2[0][3]);
			    		  matriz2[1][0]= matriz2[1][0]-(matriz2[1][0]*matriz2[0][0]);
			    	  }
			    	  if(matriz2[2][0]!=0){
			    		  matriz2[2][1]= matriz2[2][1]-(matriz2[2][0]*matriz2[0][1]);
			    		  matriz2[2][2]= matriz2[2][2]-(matriz2[2][0]*matriz2[0][2]);
			    		  matriz2[2][3]= matriz2[2][3]-(matriz2[2][0]*matriz2[0][3]);
			    		  matriz2[2][0]= matriz2[2][0]-(matriz2[2][0]*matriz2[0][0]);
			    	  }
			    	  if(matriz2[1][1] !=1 ){
				    	  matriz2[1][2]= matriz2[1][2]*(1/ matriz2[1][1]);
				    	  matriz2[1][3]= matriz2[1][3]*(1/ matriz2[1][1]);
				    	  matriz2[1][1]= 1;}
			    	  if(matriz2[2][1]!=0){
			    		  
			    		  matriz2[2][2]=matriz2[2][2]-(matriz2[2][1]*matriz2[1][2]);
			    		  matriz2[2][3]=matriz2[2][3]-(matriz2[2][1]*matriz2[1][3]);
			    				  matriz2[2][1]=0;
			    	  }
			    	  if(matriz2[2][2] !=1 ){
				    	  matriz2[2][3]= matriz2[2][3]*(1/ matriz2[2][2]);
				    	  matriz2[2][2] =1;
				    	  }
                      if(matriz2[1][2]!=0){
			    		  matriz2[1][3]=matriz2[1][3]-(matriz2[1][2]*matriz2[2][3]);
			    				  matriz2[1][2]=0;}
                      if(matriz2[0][2]!=0){
			    		  matriz2[0][3]=matriz2[0][3]-(matriz2[0][2]*matriz2[2][3]);
			    				  matriz2[0][2]=0;}
                      if(matriz2[0][1]!=0){
			    		  matriz2[0][3]=matriz2[0][3]-(matriz2[0][1]*matriz2[1][3]);
			    				  matriz2[0][1]=0;}
			    				  
				    	  
                      JOptionPane.showMessageDialog(null,"x1= "+matriz2[0][3]+"    x2= "+matriz2[1][3]+"    x3="+matriz2[2][3]);
			      System.out.println(matriz2[0][0]+" "+ matriz2[0][1]+" "+ matriz2[0][2]+" "+ matriz2[0][3]);
			      System.out.println(matriz2[1][0]+" "+ matriz2[1][1]+" "+ matriz2[1][2]+" "+ matriz2[1][3]);
			      System.out.println(matriz2[2][0]+" "+ matriz2[2][1]+" "+ matriz2[2][2]+" "+ matriz2[2][3]);
			
			}
		
		
	
	}
	}


