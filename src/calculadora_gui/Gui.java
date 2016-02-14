package calculadora_gui;
import java.awt.EventQueue;
import javax.swing.border.Border;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.border.EmptyBorder;
import javax.swing.BorderFactory;
import javax.swing.JButton;
import javax.swing.JLabel;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.awt.BorderLayout;
import java.awt.Color;
import javax.swing.JOptionPane;
import java.awt.SystemColor;
import javax.swing.UIManager;
import javax.swing.border.EtchedBorder;

public class Gui extends JFrame {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private JPanel contentPane;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Gui frame = new Gui();
					
					frame.setVisible(true);
					
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}
	// Create calculation objects
	Calc calc= new Calc();
	reducetoechelon EqnSolver = new reducetoechelon();
	Cuadratica quadra= new Cuadratica();

	 // Create Key Listener
	KeyListener listener = new KeyListener()
	{
		@Override
		public void keyPressed(KeyEvent event) 
		{
			
		}
		@Override 
	public void keyReleased(KeyEvent event) 
		{
		    

		}

	@Override
	public void keyTyped(KeyEvent event) 
		{
		    
		    lbPantallaUpdater(""+ event.getKeyChar());
		    System.out.println("hola");
		}
	
	};
	
	/**
	 * Create the frame.
	 */
	private JLabel lbPantalla = new JLabel("");
		
		
	
	
	public void lbPantallaUpdater(String text){
		if(text=="CLS"){
			lbPantalla.setText("");
		}
		else lbPantalla.setText(lbPantalla.getText()+text);
	}
	public void lbPantallaResp(String text){
		lbPantalla.setText(text);
	}
	public String lbPantallaGetter(){
		String text = lbPantalla.getText();
		return text;
	}
	
	private	JButton btnNum0 = new JButton("0");
	private	JButton btnNum1 = new JButton("1");
	private	JButton btnNum2 = new JButton("2");
	private JButton btnNum3 = new JButton("3");
	private JButton btnNum4 = new JButton("4");
	private JButton btnNum5 = new JButton("5");
	private JButton btnNum6 = new JButton("6");
	private JButton btnNum7 = new JButton("7");
	private JButton btnNum8 = new JButton("8");
	private JButton btnNum9 = new JButton("9");
	private JButton btnResultado = new JButton("=");
	private JButton btnClear = new JButton("Clear");
	JButton btnSuma = new JButton("+");
	JButton btnResta = new JButton("-");
	JButton btnParIzq = new JButton("(");
	JButton btnParDer = new JButton(")");
	JButton btnPow = new JButton("^");
	JButton btnMult = new JButton("*");
	JButton btnDiv = new JButton("/");
	JButton btnMatrixM = new JButton("MatrixMode");
	JButton btnCos = new JButton("Cos");
	JButton btnArCos = new JButton("ArCos");
	JButton btnSen = new JButton("Sen");
	JButton btnArcSen = new JButton("ArcSen");
	JButton btnTan = new JButton("Tan");
	JButton btnLn = new JButton("Ln");
	JButton btnFact = new JButton("!");
	JButton btnCuadratica = new JButton("EQN SOLVER");
	Border border = BorderFactory.createEtchedBorder(1,Color.BLUE,Color.GRAY);
	
	
	
	
	
	
	
	public Gui() {
		
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 346);
		contentPane = new JPanel();
		contentPane.addKeyListener(listener);
		contentPane.requestFocus();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		contentPane.requestFocus();
		
		btnNum1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				lbPantallaUpdater("1");
				contentPane.requestFocus();
			}
		});
		
		btnNum2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				lbPantallaUpdater("2");
				contentPane.requestFocus();
			}
		});
		 
		btnNum3.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				lbPantallaUpdater("3");
				contentPane.requestFocus();
			}
		});
		
		btnNum4.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				lbPantallaUpdater("4");
				contentPane.requestFocus();
			}
		});
		
		btnNum5.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				lbPantallaUpdater("5");
				contentPane.requestFocus();
			}
		});
		
		btnNum6.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				lbPantallaUpdater("6");
				contentPane.requestFocus();
			}
		});
		
		btnNum7.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				lbPantallaUpdater("7");
				contentPane.requestFocus();
			}
		});
		
		btnNum8.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				lbPantallaUpdater("8");
				contentPane.requestFocus();
			}
		});
		
		btnNum9.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				lbPantallaUpdater("9");
				contentPane.requestFocus();
			}
		});
		
		btnNum0.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				lbPantallaUpdater("0");
				contentPane.requestFocus();
			}
		});
		
		btnResultado.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				lbPantallaResp(String.valueOf(calc.StringToCalculations(lbPantalla.getText())));
				contentPane.requestFocus();
			}
		});
		
		btnClear.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				lbPantallaUpdater("CLS");
				contentPane.requestFocus();
			}
		});
		
		btnSuma.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				lbPantallaUpdater("+");
				contentPane.requestFocus();
			}
		});
		btnResta.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				lbPantallaUpdater("-");
				contentPane.requestFocus();
			}
		});
		btnParIzq.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				lbPantallaUpdater("(");
				contentPane.requestFocus();
			}
		});
		btnParDer.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				lbPantallaUpdater(")");
				contentPane.requestFocus();
			}
		});
		btnPow.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				lbPantallaUpdater("^");
				contentPane.requestFocus();
			}
		});
		btnMult.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				lbPantallaUpdater("*");
				contentPane.requestFocus();
			}
		});
		btnDiv.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				lbPantallaUpdater("/");
				contentPane.requestFocus();
			}
		});
		btnMatrixM.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				EqnSolver.matrix();
				contentPane.requestFocus();
			}
		});
		btnCos.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				lbPantallaUpdater(String.valueOf(calc.cos(Double.parseDouble(JOptionPane.showInputDialog(null, "x=")))));
				contentPane.requestFocus();
				contentPane.requestFocus();
			}
		});
		btnArCos.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				lbPantallaUpdater(String.valueOf(calc.cos(Double.parseDouble(JOptionPane.showInputDialog(null, "x=")))));
				contentPane.requestFocus();
			}
		});
		btnSen.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				lbPantallaUpdater(String.valueOf(calc.sin(Double.parseDouble(JOptionPane.showInputDialog(null, "x=")))));
				contentPane.requestFocus();
			}
		});
		
		btnArcSen.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				lbPantallaUpdater(String.valueOf(calc.asin(Double.parseDouble(JOptionPane.showInputDialog(null, "x=")))));
				contentPane.requestFocus();
			}
		});
		btnTan.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				lbPantallaUpdater(String.valueOf(calc.tan(Double.parseDouble(JOptionPane.showInputDialog(null, "x=")))));
				contentPane.requestFocus();
			}
		});
		JButton btnArcTan = new JButton("ArcTan");
		btnArcTan.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				lbPantallaUpdater(String.valueOf(calc.atan(Double.parseDouble(JOptionPane.showInputDialog(null, "x=")))));
				contentPane.requestFocus();
			}
		});
		btnLn.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				lbPantallaUpdater(String.valueOf(calc.log(Double.parseDouble(JOptionPane.showInputDialog(null, "x=")))));
				contentPane.requestFocus();
			}
		});
		btnFact.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				lbPantallaUpdater(String.valueOf(calc.factorial(Integer.parseInt(JOptionPane.showInputDialog(null, "x=")))));
				contentPane.requestFocus();

			}
		});
		btnCuadratica.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				quadra.cuadratica();
				contentPane.requestFocus();
			}
		});
		btnNum3.setBounds(151, 179, 50, 25);
		contentPane.add(btnNum3);
		
		btnNum6.setBounds(151, 210, 50, 25);
		contentPane.add(btnNum6);
		
		btnNum5.setBounds(89, 210, 50, 25);
		contentPane.add(btnNum5);
		
		btnNum4.setBounds(27, 210, 50, 25);
		contentPane.add(btnNum4);
		
		btnNum7.setBounds(25, 240, 50, 25);
		contentPane.add(btnNum7);
		
		btnNum8.setBounds(151, 240, 50, 25);
		contentPane.add(btnNum8);
		
		btnNum9.setBounds(89, 240, 50, 25);
		contentPane.add(btnNum9);
		
		btnNum0.setBounds(89, 270, 50, 25);
		contentPane.add(btnNum0);
		
	
		
		btnNum1.setBounds(27, 179, 50, 25);
		contentPane.add(btnNum1);
		
		
		btnNum2.setBounds(89, 179, 50, 25);
		contentPane.add(btnNum2);
	
		
		
		btnResultado.setBounds(151, 270, 50, 25);
		contentPane.add(btnResultado);
		
		JButton btnBorrar = new JButton("<-");
		btnBorrar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				lbPantallaResp(lbPantalla.getText().substring(0,lbPantalla.getText().length()-1));
				contentPane.requestFocus();
			}
		});
		btnBorrar.setBounds(25, 270, 50, 25);
		contentPane.add(btnBorrar);
		
		
		btnPow.setBounds(290, 101, 50, 25);
		contentPane.add(btnPow);
		
		
		
		btnResta.setBounds(345, 77, 50, 25);
		contentPane.add(btnResta);
		
		
		
		
		
		btnDiv.setBounds(290, 126, 50, 25);
		contentPane.add(btnDiv);
		
		
		btnMult.setBounds(345, 101, 50, 25);
		contentPane.add(btnMult);
		
		
		btnCos.setBounds(213, 179, 75, 25);
		contentPane.add(btnCos);
		
		
		btnArcSen.setBounds(300, 210, 95, 25);
		contentPane.add(btnArcSen);
		
		
		btnLn.setBounds(285, 270, 55, 25);
		contentPane.add(btnLn);
		
		
		btnSen.setBounds(213, 210, 75, 25);
		contentPane.add(btnSen);
		
		JButton btnRaiz = new JButton("√");
		btnRaiz.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				contentPane.requestFocus();
			}
		});
		btnRaiz.setBounds(345, 126, 50, 25);
		contentPane.add(btnRaiz);
		
		
		btnArCos.setBounds(300, 179, 95, 25);
		contentPane.add(btnArCos);
		
		
		btnArcTan.setBounds(298, 240, 95, 25);
		contentPane.add(btnArcTan);
		
	
		btnFact.setBounds(345, 270, 50, 25);
		contentPane.add(btnFact);
		
	
		btnTan.setBounds(213, 240, 75, 25);
		contentPane.add(btnTan);
		
		JButton btnMod = new JButton("Mod");
		btnMod.setBounds(213, 270, 65, 25);
		contentPane.add(btnMod);
		lbPantalla.setBackground(UIManager.getColor("Button.light"));
		lbPantalla.setForeground(SystemColor.desktop);
		lbPantalla.setBorder(new EtchedBorder(EtchedBorder.LOWERED, UIManager.getColor("MenuBar.shadow"), new Color(128, 128, 128)));
		lbPantalla.setOpaque(true);
		
		lbPantalla.setBounds(27, 32, 370, 34);
		contentPane.add(lbPantalla);
		
	
		
		
		btnParIzq.setBounds(290, 152, 50, 25);
		contentPane.add(btnParIzq);
		
	
		btnParDer.setBounds(345, 152, 50, 25);
		contentPane.add(btnParDer);
		
		
		btnSuma.setBounds(290, 77, 50, 25);
		contentPane.add(btnSuma);
		
		btnClear.setBounds(22, 126, 117, 25);
		contentPane.add(btnClear);
		
		
		btnMatrixM.setBounds(151, 126, 117, 25);
		contentPane.add(btnMatrixM);
		
		
		btnCuadratica.setBounds(70, 152, 160, 25);
		contentPane.add(btnCuadratica);
		contentPane.requestFocus();
		JTextField field = new JTextField();
		field.addKeyListener(listener);
		contentPane.add(field);
		field.requestFocus();
		
		
		
	}
}
