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
import javax.swing.JToolBar;
import javax.swing.JMenuBar;
import javax.swing.JMenu;
import javax.swing.JMenuItem;
import javax.swing.JSeparator;
import javax.swing.Box;
import javax.swing.JLayeredPane;
import javax.swing.border.BevelBorder;

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
					 try 
					    { 
					        UIManager.setLookAndFeel("com.sun.java.swing.plaf.windows.WindowsLookAndFeel"); 
					    } 
					    catch(Exception e){ 
					    }
					Gui frame = new Gui();
					
					frame.setVisible(true);
					frame.setSize(400,400);

					
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
		}
	
	};
	
	/**
	 * Create the frame.
	 */
	private JLabel lbPantalla = new JLabel("");
	public void lbPantallaUpdater(String text)
	{
		if(text=="CLS")
		{
			lbPantalla.setText("");
		}
		else lbPantalla.setText(lbPantalla.getText()+text);
	}
	public void lbPantallaResp(String text)
	{
		lbPantalla.setText(text);
	}
	public String lbPantallaGetter()
	{
		return lbPantalla.getText();
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
	private JButton btnSuma = new JButton("+");
	private JButton btnResta = new JButton("-");
	private JButton btnParIzq = new JButton("(");
	private JButton btnParDer = new JButton(")");
	private JButton btnPow = new JButton("^");
	private JButton btnMult = new JButton("*");
	private JButton btnDiv = new JButton("/");
	private JButton btnCos = new JButton("Cos");
	private JButton btnArCos = new JButton("ArCos");
	private JButton btnSen = new JButton("Sen");
	private JButton btnArcSen = new JButton("ArcSen");
	private JButton btnTan = new JButton("Tan");
	private JButton btnLn = new JButton("Ln");
	private JButton btnFact = new JButton("!");
	private JButton btnBorrar = new JButton("<-");
	private JButton btnArcTan = new JButton("ArcTan");
	private JButton btnMod = new JButton("Mod");
	private JButton btnRaiz = new JButton("√");
	private JTextField field = new JTextField();
	Border border = BorderFactory.createEtchedBorder(1,Color.BLUE,Color.GRAY);
	private final JPanel panel_1 = new JPanel();
	private final JPanel panel_2 = new JPanel();

	
	
	
	
	
	public Gui() {
		
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 434, 353);
		contentPane = new JPanel();
		contentPane.addKeyListener(listener);
		contentPane.requestFocus();
		
		JMenuBar menuBar = new JMenuBar();
		setJMenuBar(menuBar);
		
		JMenu mnMode = new JMenu("Mode");
		menuBar.add(mnMode);
		
		JMenuItem mntmEqnSolver = new JMenuItem("Eqn Solver");
		mntmEqnSolver.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				quadra.cuadratica();
				contentPane.requestFocus();
			}
		});
		mnMode.add(mntmEqnSolver);
		
		JMenuItem mntmMatrix = new JMenuItem("Matrix");
		mntmMatrix.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				EqnSolver.matrix();
				contentPane.requestFocus();
			}
		});
		mnMode.add(mntmMatrix);
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		contentPane.requestFocus();
		
		btnClear.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				lbPantallaUpdater("CLS");
				contentPane.requestFocus();
			}
		});
		lbPantalla.setBackground(UIManager.getColor("Button.light"));
		lbPantalla.setForeground(SystemColor.desktop);
		lbPantalla.setBorder(new EtchedBorder(EtchedBorder.LOWERED, UIManager.getColor("MenuBar.shadow"), new Color(128, 128, 128)));
		lbPantalla.setOpaque(true);
		
		lbPantalla.setBounds(27, 11, 370, 34);
		contentPane.add(lbPantalla);
		
		btnClear.setBounds(27, 106, 100, 25);
		contentPane.add(btnClear);
		contentPane.requestFocus();
		
		field.addKeyListener(listener);
		contentPane.add(field);
		
		JSeparator separator = new JSeparator();
		separator.setBounds(29, 131, 183, 0);
		contentPane.add(separator);
		
		JPanel panel = new JPanel();
		panel.setBorder(new EtchedBorder(EtchedBorder.LOWERED, null, null));
		panel.setBounds(27, 142, 149, 190);
		contentPane.add(panel);
		panel.add(btnNum1);
		
		btnNum1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				lbPantallaUpdater("1");
				contentPane.requestFocus();
			}
		});
		panel.add(btnNum2);
		
		btnNum2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				lbPantallaUpdater("2");
				contentPane.requestFocus();
			}
		});
		panel.add(btnNum3);
		
		btnNum3.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				lbPantallaUpdater("3");
				contentPane.requestFocus();
			}
		});
		panel.add(btnNum4);
		
		btnNum4.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				lbPantallaUpdater("4");
				contentPane.requestFocus();
			}
		});
		panel.add(btnNum5);
		
		btnNum5.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				lbPantallaUpdater("5");
				contentPane.requestFocus();
			}
		});
		panel.add(btnNum6);
		
		btnNum6.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				lbPantallaUpdater("6");
				contentPane.requestFocus();
			}
		});
		panel.add(btnNum7);
		
		btnNum7.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				lbPantallaUpdater("7");
				contentPane.requestFocus();
			}
		});
		panel.add(btnNum8);
		
		btnNum8.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				lbPantallaUpdater("8");
				contentPane.requestFocus();
			}
		});
		panel.add(btnNum9);
		
		btnNum9.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				lbPantallaUpdater("9");
				contentPane.requestFocus();
			}
		});
		panel.add(btnBorrar);
		
		btnBorrar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				lbPantallaResp(lbPantalla.getText().substring(0,lbPantalla.getText().length()-1));
				contentPane.requestFocus();
			}
		});
		panel.add(btnNum0);
		panel.add(btnResultado);
		panel_1.setBorder(new EtchedBorder(EtchedBorder.LOWERED, null, null));
		panel_1.setBounds(27, 56, 370, 80);
		
		contentPane.add(panel_1);
		panel_1.add(btnSuma);

		panel_1.add(btnResta);
		panel_1.add(btnMult);
		btnMult.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				lbPantallaUpdater("*");
				contentPane.requestFocus();
			}
		});
		panel_1.add(btnPow);
		panel_1.add(btnDiv);
		panel_1.add(btnRaiz);
		panel_1.add(btnParIzq);
		panel_1.add(btnParDer);
		panel_1.add(btnClear);
		panel_2.setBorder(new EtchedBorder(EtchedBorder.LOWERED, null, null));
		panel_2.setBounds(186, 142, 194, 190);
		
		contentPane.add(panel_2);
		panel_2.add(btnCos);
		panel_2.add(btnSen);
		btnSen.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				lbPantallaUpdater("Sin(");
				contentPane.requestFocus();
			}
		});
		panel_2.add(btnTan);
		btnTan.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				lbPantallaUpdater("Tan(");
				contentPane.requestFocus();
			}
		});
		panel_2.add(btnArCos);
		btnArCos.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				lbPantallaUpdater(String.valueOf(calc.cos(Double.parseDouble(JOptionPane.showInputDialog(null, "x=")))));
				contentPane.requestFocus();
			}
		});
		panel_2.add(btnArcSen);
		
		btnArcSen.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				lbPantallaUpdater(String.valueOf(calc.asin(Double.parseDouble(JOptionPane.showInputDialog(null, "x=")))));
				contentPane.requestFocus();
			}
		});
		panel_2.add(btnArcTan);
		
		btnArcTan.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				lbPantallaUpdater(String.valueOf(calc.atan(Double.parseDouble(JOptionPane.showInputDialog(null, "x=")))));
				contentPane.requestFocus();
			}
		});
		panel_2.add(btnLn);
		btnLn.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				lbPantallaUpdater(String.valueOf(calc.log(Double.parseDouble(JOptionPane.showInputDialog(null, "x=")))));
				contentPane.requestFocus();
			}
		});
		
		JButton btnLog = new JButton("Log");
		panel_2.add(btnLog);
		panel_2.add(btnMod);
		panel_2.add(btnFact);
		btnFact.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				lbPantallaUpdater(String.valueOf(calc.factorial(Integer.parseInt(JOptionPane.showInputDialog(null, "x=")))));
				contentPane.requestFocus();

			}
		});
		btnCos.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				lbPantallaUpdater("Cos(");
				contentPane.requestFocus();
				contentPane.requestFocus();
			}
		});
		btnParDer.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				lbPantallaUpdater(")");
				contentPane.requestFocus();
			}
		});
		btnParIzq.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				lbPantallaUpdater("(");
				contentPane.requestFocus();
			}
		});
		
		
		btnRaiz.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				contentPane.requestFocus();
			}
		});
		btnDiv.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				lbPantallaUpdater("/");
				contentPane.requestFocus();
			}
		});
		btnPow.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				lbPantallaUpdater("^");
				contentPane.requestFocus();
			}
		});
		btnResta.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				lbPantallaUpdater("-");
				contentPane.requestFocus();
			}
		});
		
		btnSuma.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				lbPantallaUpdater("+");
				contentPane.requestFocus();
			}
		});
		
		btnResultado.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				lbPantallaResp(String.valueOf(calc.StringToCalculations(lbPantalla.getText())));
				contentPane.requestFocus();
			}
		});
		
		btnNum0.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				lbPantallaUpdater("0");
				contentPane.requestFocus();
			}
		});
		field.requestFocus();

		
		
	}
}
