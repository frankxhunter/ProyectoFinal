package visual;

import java.awt.BorderLayout;
import java.awt.EventQueue;
import java.awt.Graphics;
import java.awt.Image;
import java.awt.Toolkit;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JMenuBar;
import javax.swing.JMenu;
import javax.swing.JMenuItem;

import clase.Documento;

import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.Window.Type;
import java.awt.Font;
import java.util.ArrayList;



public class VisualAgencia extends JFrame {

	private JPanel contentPane;
	private JMenuBar menuBar;
	private JMenu mnArchivo;
	private JMenu mnGestion;
	private JMenu mnReportes;
	private JMenuItem mntmSalir;
	private JMenu mnEmpresas;
	private JMenu mnCandidatos;
	private JMenu mnEspecialidades;
	private JMenuItem mntmCrearEmpresas;
	private JMenuItem mntmA;
	private JMenuItem mntmAgregarCandidatos;
	private JMenuItem mntmComprobarSectores;
	private JMenuItem mntmComprobarRamas;
	private JMenu mnEntrevistas;
	private JMenuItem mntmVerRegistroMensual;
	private JMenuItem mntmVerReportes;
	private JMenuItem mntmCerrar;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					VisualAgencia frame = new VisualAgencia();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	public VisualAgencia() {
		setUndecorated(true);
		setType(Type.UTILITY);
		setVisible(true);
		setFont(new Font("Tahoma", Font.PLAIN, 24));
		setTitle("Sistema de gesti\u00F3n de Candidatos");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 771, 467);
		setLocationRelativeTo(null);
		setExtendedState(JFrame.MAXIMIZED_BOTH);
		setJMenuBar(getMenuBar_1());
		contentPane = new JPanel(){
			public void paintComponent(Graphics g){
				Image img = Toolkit.getDefaultToolkit().getImage(VisualAgencia.class.getResource("/Imagen/fondo.jpg"));
				g.drawImage(img,0,0,this.getWidth(),this.getHeight(), this);
			}
			
		};
		
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
	}
	private JMenuBar getMenuBar_1() {
		if (menuBar == null) {
			menuBar = new JMenuBar();
			menuBar.add(getMnArchivo());
			menuBar.add(getMnGestion());
			menuBar.add(getMnReportes());
		}
		return menuBar;
	}
	private JMenu getMnArchivo() {
		if (mnArchivo == null) {
			mnArchivo = new JMenu("Archivo");
			mnArchivo.setFont(new Font("Tahoma", Font.PLAIN, 20));
			mnArchivo.add(getMntmCerrar());
			mnArchivo.add(getMntmSalir());
		}
		return mnArchivo;
	}
	private JMenu getMnGestion() {
		if (mnGestion == null) {
			mnGestion = new JMenu("Gestion");
			mnGestion.setFont(new Font("Tahoma", Font.PLAIN, 20));
			mnGestion.add(getMnEmpresas());
			mnGestion.add(getMnCandidatos());
			mnGestion.add(getMnEspecialidades());
			mnGestion.add(getMnEntrevistas());
		}
		return mnGestion;
	}
	private JMenu getMnReportes() {
		if (mnReportes == null) {
			mnReportes = new JMenu("Reportes");
			mnReportes.setFont(new Font("Tahoma", Font.PLAIN, 20));
			mnReportes.add(getMntmVerReportes());
		}
		return mnReportes;
	}
	private JMenuItem getMntmSalir() {
		if (mntmSalir == null) {
			mntmSalir = new JMenuItem("Cerrar Sesi\u00F3n");
			mntmSalir.setFont(new Font("Tahoma", Font.PLAIN, 17));
			mntmSalir.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					Login v = new Login();
					v.setVisible(true);
					dispose();
				}
			});
		}
		return mntmSalir;
	}
	private JMenu getMnEmpresas() {
		if (mnEmpresas == null) {
			mnEmpresas = new JMenu("Empresas");
			mnEmpresas.setFont(new Font("Tahoma", Font.PLAIN, 17));
			mnEmpresas.add(getMntmCrearEmpresas());
			mnEmpresas.add(getMntmA());
		}
		return mnEmpresas;
	}
	private JMenu getMnCandidatos() {
		if (mnCandidatos == null) {
			mnCandidatos = new JMenu("Candidatos");
			mnCandidatos.setFont(new Font("Tahoma", Font.PLAIN, 17));
			mnCandidatos.add(getMntmAgregarCandidatos());
		}
		return mnCandidatos;
	}
	private JMenu getMnEspecialidades() {
		if (mnEspecialidades == null) {
			mnEspecialidades = new JMenu("Especialidades");
			mnEspecialidades.setFont(new Font("Tahoma", Font.PLAIN, 17));
			mnEspecialidades.add(getMntmComprobarSectores());
			mnEspecialidades.add(getMntmComprobarRamas());
		}
		return mnEspecialidades;
	}
	private JMenuItem getMntmCrearEmpresas() {
		if (mntmCrearEmpresas == null) {
			mntmCrearEmpresas = new JMenuItem("Crear Empresas");
			mntmCrearEmpresas.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					VisualEmpresa v = new VisualEmpresa(); 
					v.setLocationRelativeTo(null);
					v.setModal(true);
					v.setVisible(true);
				
					
					
				}
			});
			mntmCrearEmpresas.setFont(new Font("Tahoma", Font.PLAIN, 16));
		}
		return mntmCrearEmpresas;
	}
	private JMenuItem getMntmA() {
		if (mntmA == null) {
			mntmA = new JMenuItem("A\u00F1adir Oferta");
			mntmA.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					VisualOferta v = new VisualOferta();
					v.setLocationRelativeTo(null);
					v.setModal(true);
					v.setVisible(true);
				}
			});
			mntmA.setFont(new Font("Tahoma", Font.PLAIN, 16));
		}
		return mntmA;
	}
	private JMenuItem getMntmAgregarCandidatos() {
		if (mntmAgregarCandidatos == null) {
			mntmAgregarCandidatos = new JMenuItem("Agregar Candidatos");
			mntmAgregarCandidatos.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					VisualCandidato v = new VisualCandidato();
					v.setLocationRelativeTo(null);
					v.setModal(true);
					v.setVisible(true);
				
				}
			});
			mntmAgregarCandidatos.setFont(new Font("Tahoma", Font.PLAIN, 16));
		}
		return mntmAgregarCandidatos;
	}
	private JMenuItem getMntmComprobarSectores() {
		if (mntmComprobarSectores == null) {
			mntmComprobarSectores = new JMenuItem("Comprobar Sectores");
			mntmComprobarSectores.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					VisualSector v = new VisualSector();
					v.setLocationRelativeTo(null);
					v.setModal(true);
					v.setVisible(true);
				
				}
			});
			mntmComprobarSectores.setFont(new Font("Tahoma", Font.PLAIN, 16));
		}
		return mntmComprobarSectores;
	}
	private JMenuItem getMntmComprobarRamas() {
		if (mntmComprobarRamas == null) {
			mntmComprobarRamas = new JMenuItem("Comprobar Ramas");
			mntmComprobarRamas.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					VisualRama v = new VisualRama();
					v.setLocationRelativeTo(null);
					v.setModal(true);
					v.setVisible(true);
				
				}
			});
			mntmComprobarRamas.setFont(new Font("Tahoma", Font.PLAIN, 16));
		}
		return mntmComprobarRamas;
	}
	private JMenu getMnEntrevistas() {
		if (mnEntrevistas == null) {
			mnEntrevistas = new JMenu("Entrevistas");
			mnEntrevistas.setFont(new Font("Tahoma", Font.PLAIN, 17));
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
					x.setLocationRelativeTo(null);
					x.setModal(true);
					x.setVisible(true);
				}
			});
			mntmVerRegistroMensual.setFont(new Font("Tahoma", Font.PLAIN, 16));
		}
		return mntmVerRegistroMensual;
	}
	private JMenuItem getMntmVerReportes() {
		if (mntmVerReportes == null) {
			mntmVerReportes = new JMenuItem("Ver Reportes");
			mntmVerReportes.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					VisualReportes x=new VisualReportes();
					x.setLocationRelativeTo(null);
					x.setModal(true);
					x.setVisible(true);
				}
			});
			mntmVerReportes.setFont(new Font("Tahoma", Font.PLAIN, 20));
		}
		return mntmVerReportes;
	}
	private JMenuItem getMntmCerrar() {
		if (mntmCerrar == null) {
			mntmCerrar = new JMenuItem("Cerrar Programa");
			mntmCerrar.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					System.exit(1);
				}
			});
			mntmCerrar.setFont(new Font("Tahoma", Font.PLAIN, 17));
		}
		return mntmCerrar;
	}
}
