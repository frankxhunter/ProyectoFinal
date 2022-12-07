package visual;


import java.awt.CardLayout;
import java.awt.Color;
import java.awt.EventQueue;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.Image;
import java.awt.Toolkit;
import java.awt.Window.Type;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JDialog;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JPanel;



public class VisualAgenciaEmpleadora {

	private VisualCandidato candidato;
	JFrame frmSistemaDeGestion;
	private JMenuBar menuBar;
	private JMenu mnArchivo;
	private JMenu mnGestion;
	private JMenu mnReportes;
	private JMenuItem mntmSalir;
	private JMenuItem mntmEmpresa;
	private JMenuItem mntmCandidatos;
	private JPanel panel;
	private JLabel lblEmpresaEmpleadora;
	private JMenu mnEmpresas;
	private JMenu mnCandidatos;
	private JMenu mmEspecialidad;
	private JMenuItem mntmComprobarSectores;
	private JMenuItem mntmAadirOferta;
	private JMenuItem mntmComprobarRamas;
	private JMenu mnEntrevistas;
	private JMenuItem mntmVerRegistroMensual;



	public JFrame getFrame() {
		return frmSistemaDeGestion;
	}

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					VisualAgenciaEmpleadora window = new VisualAgenciaEmpleadora();
					window.frmSistemaDeGestion.setLocationRelativeTo(null);
					window.frmSistemaDeGestion.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 */
	public VisualAgenciaEmpleadora() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frmSistemaDeGestion = new JFrame(){
		};
		frmSistemaDeGestion.setType(Type.UTILITY);
		
		frmSistemaDeGestion.setTitle("Sistema de gestion de Candidatos ");
		frmSistemaDeGestion.setBounds(0, 0, 0, 0);
		frmSistemaDeGestion.setExtendedState(JFrame.MAXIMIZED_BOTH);
		frmSistemaDeGestion.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frmSistemaDeGestion.setJMenuBar(getMenuBar());
		frmSistemaDeGestion.getContentPane().setLayout(new CardLayout(0, 0));
		frmSistemaDeGestion.getContentPane().add(getPanel(), "name_139749508509964");
	}
	private JMenuBar getMenuBar() {
		if (menuBar == null) {
			menuBar = new JMenuBar();
			menuBar.setFont(new Font("Segoe UI", Font.PLAIN, 26));
			menuBar.add(getMnArchivo());
			menuBar.add(getMnGestion());
			menuBar.add(getMnReportes());
		}
		return menuBar;
	}
	private JMenu getMnArchivo() {
		if (mnArchivo == null) {
			mnArchivo = new JMenu("Archivo");
			mnArchivo.setFont(new Font("Segoe UI", Font.PLAIN, 18));
			mnArchivo.add(getMntmSalir());
		}
		return mnArchivo;
	}
	private JMenu getMnGestion() {
		if (mnGestion == null) {
			mnGestion = new JMenu("Gestion");
			mnGestion.setFont(new Font("Segoe UI", Font.PLAIN, 18));
			mnGestion.add(getMnEmpresas());
			mnGestion.add(getMnCandidatos());
			mnGestion.add(getMmEspecialidad());
			mnGestion.add(getMnEntrevistas());
		}
		return mnGestion;
	}
	private JMenu getMnReportes() {
		if (mnReportes == null) {
			mnReportes = new JMenu("Reportes");
			mnReportes.setFont(new Font("Segoe UI", Font.PLAIN, 18));
		}
		return mnReportes;
	}
	private JMenuItem getMntmSalir() {
		if (mntmSalir == null) {
			mntmSalir = new JMenuItem("Salir");
			mntmSalir.setFont(new Font("Segoe UI", Font.PLAIN, 18));
			mntmSalir.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent arg0) {
					System.exit(0);
				}
			});
		}
		return mntmSalir;
	}
	private JMenuItem getMntmEmpresa() {
		if (mntmEmpresa == null) {
			mntmEmpresa = new JMenuItem("Crear Empresas");
			mntmEmpresa.setFont(new Font("Segoe UI", Font.PLAIN, 18));
			mntmEmpresa.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					VisualEmpresa empresa= new VisualEmpresa ();
					empresa.setModal(true);
					empresa.setLocationRelativeTo(null);
					empresa.setVisible(true);
				}
			});
		}
		return mntmEmpresa;
	}
	private JMenuItem getMntmCandidatos() {
		if (mntmCandidatos == null) {
			mntmCandidatos = new JMenuItem("Agregar Candidatos");
			mntmCandidatos.setFont(new Font("Segoe UI", Font.PLAIN, 18));
			mntmCandidatos.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent arg0) {
					candidato=new VisualCandidato();
					candidato.setModal(true);
					candidato.setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
					candidato.setLocationRelativeTo(null);
					candidato.setVisible(true);					
				}
			});
		}
		return mntmCandidatos;
	}
	private JPanel getPanel() {
		if (panel == null) {
			panel = new JPanel(){
				public void  paintComponent( Graphics e){

					Image img = Toolkit.getDefaultToolkit().getImage(Login.class.getResource("/Imagen/prueba1.jpg"));
					e.drawImage(img, 0, 0, this.getWidth(), this.getHeight(), this);
				}
			};
			panel.setLayout(null);
			panel.add(getLblEmpresaEmpleadora());

		}
		return panel;
	}
	private JLabel getLblEmpresaEmpleadora() {
		if (lblEmpresaEmpleadora == null) {
			lblEmpresaEmpleadora = new JLabel("Agencia Empleadora");
			lblEmpresaEmpleadora.setBounds(454, -11, 955, 227);
			lblEmpresaEmpleadora.setForeground(Color.WHITE);
			lblEmpresaEmpleadora.setFont(new Font("Roboto Black", Font.BOLD, 70));
		}
		return lblEmpresaEmpleadora;
	}
	private JMenu getMnEmpresas() {
		if (mnEmpresas == null) {
			mnEmpresas = new JMenu("Empresas");
			mnEmpresas.setFont(new Font("Segoe UI", Font.PLAIN, 18));
			mnEmpresas.add(getMntmEmpresa());
			mnEmpresas.add(getMntmAadirOferta());
		}
		return mnEmpresas;
	}
	private JMenu getMnCandidatos() {
		if (mnCandidatos == null) {
			mnCandidatos = new JMenu("Candidatos");
			mnCandidatos.setFont(new Font("Segoe UI", Font.PLAIN, 18));
			mnCandidatos.add(getMntmCandidatos());
		}
		return mnCandidatos;
	}
	private JMenu getMmEspecialidad() {
		if (mmEspecialidad == null) {
			mmEspecialidad = new JMenu("Especialidades");
			mmEspecialidad.setFont(new Font("Segoe UI", Font.PLAIN, 18));
			mmEspecialidad.add(getMntmComprobarSectores());
			mmEspecialidad.add(getMntmComprobarRamas());
		}
		return mmEspecialidad;
	}
	private JMenuItem getMntmComprobarSectores() {
		if (mntmComprobarSectores == null) {
			mntmComprobarSectores = new JMenuItem("Comprobar Sectores");
			mntmComprobarSectores.setFont(new Font("Segoe UI", Font.PLAIN, 18));
			mntmComprobarSectores.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent arg0) {
					VisualSector x=new VisualSector();
					x.setModal(true);
					x.setLocationRelativeTo(null);
					x.setVisible(true);
				}
			});
		}
		return mntmComprobarSectores;
	}
	private JMenuItem getMntmAadirOferta() {
		if (mntmAadirOferta == null) {
			mntmAadirOferta = new JMenuItem("A\u00F1adir Oferta");
			mntmAadirOferta.setFont(new Font("Segoe UI", Font.PLAIN, 18));
			mntmAadirOferta.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					VisualOferta x= new VisualOferta();
					x.setVisible(true);
					x.setModal(true);
					x.setLocationRelativeTo(null);
				}
			});
		}
		return mntmAadirOferta;
	}
	private JMenuItem getMntmComprobarRamas() {
		if (mntmComprobarRamas == null) {
			mntmComprobarRamas = new JMenuItem("Comprobar Ramas");
			mntmComprobarRamas.setFont(new Font("Segoe UI", Font.PLAIN, 18));
			mntmComprobarRamas.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					VisualRama x=new VisualRama();
					x.setVisible(true);
					x.setModal(true);
					x.setLocationRelativeTo(null);
				}
			});
		}
		return mntmComprobarRamas;
	}
	private JMenu getMnEntrevistas() {
		if (mnEntrevistas == null) {
			mnEntrevistas = new JMenu("Entrevistas");
			mnEntrevistas.setFont(new Font("Segoe UI", Font.PLAIN, 18));
			mnEntrevistas.add(getMntmVerRegistroMensual());
		}
		return mnEntrevistas;
	}
	private JMenuItem getMntmVerRegistroMensual() {
		if (mntmVerRegistroMensual == null) {
			mntmVerRegistroMensual = new JMenuItem("Ver registro mensual");
			mntmVerRegistroMensual.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					VisualCalendario x=new VisualCalendario();
					x.setVisible(true);
					x.setLocationRelativeTo(null);
					x.setModal(true);
				}
			});
			mntmVerRegistroMensual.setFont(new Font("Segoe UI", Font.PLAIN, 18));
		}
		return mntmVerRegistroMensual;
	}
}
