package visual;

import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.Image;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JTextField;
import javax.swing.border.LineBorder;
import javax.swing.border.TitledBorder;

public class Login extends JDialog {
	private static final long serialVersionUID = 1L;
	private JPanel panel;
	private JPanel panel_1;
	private JTextField Tusuario;
	private JLabel error1;
	private JButton btnIS;
	private JLabel error2;
	private JPasswordField passwordF;
	private JButton btnX;
	private JLabel lblBienvenido;
	private JPanel panel_2;
	private JPanel panel_3;
	private JButton btnNewButton;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		try {
			Login dialog = new Login();
			dialog.setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
			dialog.setVisible(true);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	/**
	 * Create the dialog.
	 */
	public Login() {
		setUndecorated(true);
		 setUndecorated(true);
		 setBounds(100, 100, 961, 600);
		 setLocationRelativeTo(null);
		 setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
		 getContentPane().setLayout(null);
		 getContentPane().add(getPanel());
		 getContentPane().add(getPanel_1());
		 setVisible(true);	
		Tusuario.requestFocusInWindow();
	}
	private JPanel getPanel() {
		if (panel == null) {
			panel = new JPanel(){
				/**
				 * 
				 */
				private static final long serialVersionUID = 1L;

				public void paintComponent(Graphics g){
					Image img= Toolkit.getDefaultToolkit().getImage(Login.class.getResource("/Imagen/imagenp.png"));
					g.drawImage(img, 0, 0, this.getWidth(), this.getHeight(), this);
				}
			};
			
			panel.setBounds(0, 0, 469, 600);
		}
		return panel;
	}
	private JPanel getPanel_1() {
		if (panel_1 == null) {
			panel_1 = new JPanel();
			panel_1.setForeground(Color.BLACK);
			panel_1.setBounds(468, 0, 492, 600);
			panel_1.setBackground(new Color(237, 234, 229));
			panel_1.setLayout(null);
			panel_1.add(getError1());
			panel_1.add(getBtnIS());
			panel_1.add(getError2());
			panel_1.add(getBtnX());
			panel_1.add(getLblBienvenido());
			panel_1.add(getPanel_2());
			panel_1.add(getPanel_3_1());
		}
		return panel_1;
	}
	private JTextField getTusuario() {
		if (Tusuario == null) {
			Tusuario = new JTextField();
			Tusuario.addKeyListener(new KeyAdapter() {
				@Override
				public void keyReleased(KeyEvent e) {
					if(e.getExtendedKeyCode()==KeyEvent.VK_0)
						siguiente();
					
					if(e.getExtendedKeyCode()== KeyEvent.VK_ENTER){
						enter();
					}
				
				}
			});
			Tusuario.setBackground(new Color(237, 234, 229));
			Tusuario.setBounds(12, 17, 255, 28);
			Tusuario.setForeground(Color.BLACK);
			Tusuario.setFont(new Font("Tahoma", Font.PLAIN, 14));
			Tusuario.setBorder(null);
			Tusuario.addMouseListener(new MouseAdapter() {
				@Override
				public void mousePressed(MouseEvent e) {
					Tusuario.setText("");
					error1.setVisible(false);
					error2.setVisible(false);
				}
			});
			Tusuario.setColumns(10);
		}
		return Tusuario;
	}
	private JLabel getError1() {
		if (error1 == null) {
			error1 = new JLabel("Nombre de usuario incorrecto");
			error1.setFont(new Font("Tahoma", Font.PLAIN, 20));
			error1.setForeground(Color.RED);
			error1.setBounds(124, 414, 282, 16);
			error1.setVisible(false);
		}
		return error1;
	}
	private JButton getBtnIS() {
		if (btnIS == null) {
			btnIS = new JButton("Iniciar sesion");
			btnIS.setFont(new Font("Tahoma", Font.PLAIN, 18));
			btnIS.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					validaeUyC();
				}
			});
			btnIS.setBounds(167, 476, 160, 45);
			btnIS.setBackground(new Color(158, 130, 116));
			
		}
		return btnIS;
	}

	private JLabel getError2() {
		if (error2 == null) {
			error2 = new JLabel("Contrase\u00F1a incorrecta");
			error2.setFont(new Font("Tahoma", Font.PLAIN, 20));
			error2.setForeground(Color.RED);
			error2.setBounds(155, 435, 207, 16);
			error2.setVisible(false);
		}
		return error2;
	}
	private JPasswordField getPasswordF() {
		if (passwordF == null) {
			passwordF = new JPasswordField();
			passwordF.setEchoChar('*');
			passwordF.addKeyListener(new KeyAdapter() {
				@Override
				public void keyReleased(KeyEvent e) {
					if(e.getExtendedKeyCode() == KeyEvent.VK_ENTER)
					validaeUyC();
				}
	
			});
			passwordF.setBackground(new Color(237, 234, 229));
			passwordF.setBounds(12, 17, 253, 28);
			passwordF.setBorder(null);
			passwordF.setForeground(Color.BLACK);
			passwordF.addMouseListener(new MouseAdapter() {
				@Override
				public void mousePressed(MouseEvent e) {
					error1.setVisible(false);
					error2.setVisible(false);
					
				}
			});
		}
		return passwordF;
	}
	
	private boolean validaUsuario(String usuario){
		boolean result = false;
		if(usuario.equalsIgnoreCase("Lisy")|| usuario.equalsIgnoreCase("Frank"))
			result = true;
		return result;
	}
	private boolean validaContrasenna(String password){
		boolean result = false;
		if(password.equalsIgnoreCase("2415"))
			result = true;
		return result;
	}
	
	public void siguiente(){
		dispose();
	    VisualAgencia v = new VisualAgencia();
	    
	    v.setVisible(true);
	    
	}
	private JButton getBtnX() {
		if (btnX == null) {
			btnX = new JButton("X");
			btnX.setForeground(new Color(255, 255, 255));
			btnX.addMouseListener(new MouseAdapter() {
				@Override
				public void mouseExited(MouseEvent e) {
					btnX.setBackground(new Color(237, 234, 229));
				}
				@Override
				public void mouseEntered(MouseEvent e) {
					btnX.setBackground(Color.RED);
				}
				
			});
			
			btnX.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					System.exit(0);
				}
			});
			btnX.setFocusPainted(false);
			btnX.setBackground(new Color(237, 234, 229));
			btnX.setFont(new Font("Tahoma", Font.PLAIN, 16));
			btnX.setBounds(422, 0, 69, 33);
		}
		return btnX;
	}
	private JLabel getLblBienvenido() {
		if (lblBienvenido == null) {
			lblBienvenido = new JLabel("\u00A1 Bienvenido !");
			lblBienvenido.setFont(new Font("Tahoma", Font.PLAIN, 58));
			lblBienvenido.setBounds(60, 91, 372, 64);
		}
		return lblBienvenido;
	}
	private JPanel getPanel_2() {
		if (panel_2 == null) {
			panel_2 = new JPanel();
			panel_2.setBackground(new Color(237, 234, 229));
			panel_2.setBorder(new TitledBorder(new LineBorder(new Color(0, 0, 0)), "Nombre de usuario", TitledBorder.LEADING, TitledBorder.TOP, new Font("Tahoma", Font.PLAIN, 15), new Color(0, 0, 0)));
			panel_2.setBounds(88, 233, 318, 54);
			panel_2.setLayout(null);
			panel_2.add(getTusuario());
		}
		return panel_2;
	}
	private JPanel getPanel_3_1() {
		if (panel_3 == null) {
			panel_3 = new JPanel();
			panel_3.setBackground(new Color(237, 234, 229));
			panel_3.setBorder(new TitledBorder(new LineBorder(new Color(0, 0, 0)), "Contrase\u00F1a", TitledBorder.LEADING, TitledBorder.TOP, new Font("Tahoma", Font.PLAIN, 15), null));
			panel_3.setBounds(88, 300, 318, 54);
			panel_3.setLayout(null);
			panel_3.add(getPasswordF());
			panel_3.add(getBtnNewButton());
		}
		return panel_3;
	}
	
	public void enter(){
		if(getTusuario().getText().trim().length()>0){
			error2.setVisible(false);
		    passwordF.setText("");
			passwordF.requestFocusInWindow();
		}else
			error1.setVisible(true);	
	}
	
	public void validaeUyC(){
		String usuario = Tusuario.getText();
		@SuppressWarnings("deprecation")
		String password = passwordF.getText();
		boolean valido = validaUsuario(usuario);
		boolean result = validaContrasenna(password);
		
		if(valido && result){
			siguiente();
		}
		else if(!valido && !result){
			error1.setVisible(true);
			error2.setVisible(true);
		}
		else if(! valido){
			error1.setVisible(true);
		}
		else if(!result){
			error2.setVisible(true);
		}
	}
	private JButton getBtnNewButton() {
		if (btnNewButton == null) {
			btnNewButton = new JButton("");
			btnNewButton.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
				}
			});
			btnNewButton.setPressedIcon(new ImageIcon("C:\\UNIVERSIDAD\\DPOO\\DPOO\\AgenciaEmpleado_ProyectoFinal\\Invisible_32px.png"));
			btnNewButton.setBounds(275, 17, 33, 23);
			btnNewButton.setBackground(new Color(237, 234, 229));
			btnNewButton.setIcon(new ImageIcon("C:\\UNIVERSIDAD\\DPOO\\DPOO\\AgenciaEmpleado_ProyectoFinal\\Eye_32px.png"));
			btnNewButton.setBorder(null);
			btnNewButton.addMouseListener(new MouseAdapter() {
				@Override
				public void mousePressed(MouseEvent e) {
					passwordF.setEchoChar((char)0);
				}
				@Override
				public void mouseReleased(MouseEvent e) {
					passwordF.setEchoChar('*');
					passwordF.requestFocusInWindow();
				}
			});
		}
		return btnNewButton;
	}

}
