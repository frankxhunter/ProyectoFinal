package visual;

import java.awt.CardLayout;
import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.SwingConstants;
import javax.swing.border.LineBorder;
import javax.swing.border.TitledBorder;

import util.DocumentosTableModel;
import util.MetodosUtiles;
import clase.AgenciaEmpleadora;
import clase.Documento;
import clase.Sector;
import excepcionesPropias.YaExisteExceptions;

public class ModificarSector extends JDialog {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private Sector sector;
	private int posicion;
	private JPanel panel;
	private JLabel lblNombreDelSector;
	private JTextField txNombre;
	private JPanel panel_1;
	private JLabel lblDocumentoParaAgregar;
	private JTextField txDocumento;
	private JButton btnAgregar;
	private JPanel panel_2;
	private JScrollPane scrollPane;
	private JTable table;
	private DocumentosTableModel tableModel;
	private JButton btnAceptar;
	private JButton btnCancelar;
	private JButton btnEliminar;
	private JButton btModificar;
	private JLabel label;
	private JPanel panel_3;
	private JLabel lblCreacinDeSector;
	private JButton button;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		try {
			ModificarSector dialog = new ModificarSector(-1);
			dialog.setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
			dialog.setVisible(true);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	/**
	 * Create the dialog.
	 */
	public ModificarSector(int pos) {
		setUndecorated(true);
		getContentPane().setBackground(new Color(158, 130, 116));
		setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
		setBounds(100, 100, 714, 542);
		getContentPane().setLayout(null);
		getContentPane().add(getPanel());
		getContentPane().add(getBtnAceptar());
		getContentPane().add(getBtnCancelar());
		getContentPane().add(getBtModificar());
		getContentPane().add(getPanel_3());
		if(pos!=-1){
			posicion=pos;
			sector=AgenciaEmpleadora.getInstancia().getlistaSector().get(posicion);
			establecer(sector);
			btnAceptar.setVisible(false);
			btModificar.setVisible(true);
		}
		else 
			sector= new Sector();
	}
	private JPanel getPanel() {
		if (panel == null) {
			panel = new JPanel();
			panel.setBackground(new Color(158, 130, 116));
			panel.setBorder(new TitledBorder(new LineBorder(new Color(0, 0, 0)), "Sector", TitledBorder.LEADING, TitledBorder.TOP, null, null));
			panel.setBounds(7, 45, 699, 458);
			panel.setLayout(null);
			panel.add(getLblNombreDelSector());
			panel.add(getTxNombre());
			panel.add(getPanel_1());
		}
		return panel;
	}
	private JLabel getLblNombreDelSector() {
		if (lblNombreDelSector == null) {
			lblNombreDelSector = new JLabel("Nombre del sector");
			lblNombreDelSector.setFont(new Font("Tahoma", Font.PLAIN, 15));
			lblNombreDelSector.setBounds(44, 35, 145, 14);
		}
		return lblNombreDelSector;
	}
	private JTextField getTxNombre() {
		if (txNombre == null) {
			txNombre = new JTextField();
			txNombre.addKeyListener(new KeyAdapter() {
				@Override
				public void keyReleased(KeyEvent arg0) {
					validar();
				}
				@Override
				public void keyTyped(KeyEvent e) {
				MetodosUtiles.validacionJTextLetra(txNombre.getText().trim().length(),e);}
			});
			txNombre.setBounds(189, 32, 106, 20);
			txNombre.setColumns(10);
		}
		return txNombre;
	}
	private JPanel getPanel_1() {
		if (panel_1 == null) {
			panel_1 = new JPanel();
			panel_1.setBackground(new Color(151, 119, 104));
			panel_1.setBorder(new TitledBorder(new LineBorder(new Color(0, 0, 0)), "Documentos Necesarios", TitledBorder.LEADING, TitledBorder.TOP, null, null));
			panel_1.setBounds(19, 65, 661, 374);
			panel_1.setLayout(null);
			panel_1.add(getLblDocumentoParaAgregar());
			panel_1.add(getTxDocumento());
			panel_1.add(getBtnAgregar());
			panel_1.add(getPanel_2());
			panel_1.add(getBtnEliminar());
			panel_1.add(getLabel());
		}
		return panel_1;
	}
	private JLabel getLblDocumentoParaAgregar() {
		if (lblDocumentoParaAgregar == null) {
			lblDocumentoParaAgregar = new JLabel("Documento para agregar");
			lblDocumentoParaAgregar.setFont(new Font("Tahoma", Font.PLAIN, 15));
			lblDocumentoParaAgregar.setHorizontalAlignment(SwingConstants.RIGHT);
			lblDocumentoParaAgregar.setBounds(-16, 30, 201, 17);
		}
		return lblDocumentoParaAgregar;
	}
	private JTextField getTxDocumento() {
		if (txDocumento == null) {
			txDocumento = new JTextField();
			txDocumento.addKeyListener(new KeyAdapter() {
				@Override
				public void keyTyped(KeyEvent e) {
					MetodosUtiles.validacionJTextCharacter(txDocumento.getText().trim().length(), e);
				}
			});
			txDocumento.addMouseListener(new MouseAdapter() {
				@Override
				public void mouseClicked(MouseEvent arg0) {
					label.setVisible(false);
				}
			});
			txDocumento.setBounds(215, 29, 206, 20);
			txDocumento.setColumns(10);
		}
		return txDocumento;
	}
	private JButton getBtnAgregar() {
		if (btnAgregar == null) {
			btnAgregar = new JButton("Agregar");
			btnAgregar.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent arg0) {
					if(txDocumento.getText().trim().length()>0){
						try{
					sector.addDocumento(new Documento(txDocumento.getText(),false));
					tableModel.refresh(sector.getListaDocumentos());
					txDocumento.setText("");
						}catch(YaExisteExceptions e){
							MetodosUtiles.mostrarMensaje(e);
						}
					}
					else{
						label.setVisible(true);
					}
				}
			});
			btnAgregar.setBounds(459, 29, 89, 23);
		}
		return btnAgregar;
	}
	private JPanel getPanel_2() {
		if (panel_2 == null) {
			panel_2 = new JPanel();
			panel_2.setBounds(10, 69, 641, 286);
			panel_2.setLayout(new CardLayout(0, 0));
			panel_2.add(getScrollPane(), "name_304077772251119");
		}
		return panel_2;
	}
	private JScrollPane getScrollPane() {
		if (scrollPane == null) {
			scrollPane = new JScrollPane();
			scrollPane.setViewportView(getTable());
		}
		return scrollPane;
	}
	private JTable getTable() {
		if (table == null) {
			table = new JTable();
			table.addMouseListener(new MouseAdapter() {
				@Override
				public void mousePressed(MouseEvent arg0) {
					btnEliminar.setEnabled(true);
				}
			});
			tableModel=new DocumentosTableModel();
			table.getTableHeader().setReorderingAllowed(false);
			table.setModel(tableModel);
		}
		return table;
	}

	private JButton getBtnAceptar() {
		if (btnAceptar == null) {
			btnAceptar = new JButton("Aceptar");
			btnAceptar.setEnabled(false);
			btnAceptar.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent arg0) {
					try{
					sector.setNombre(txNombre.getText());
					AgenciaEmpleadora.getInstancia().addSector(sector);
					VisualSector x= new VisualSector();
					dispose();
					x.setModal(true);
					x.setLocationRelativeTo(null);
					x.setVisible(true);
					}catch(YaExisteExceptions e){
						MetodosUtiles.mostrarMensaje(e);
					}
					
				}
			});
			btnAceptar.setBounds(492, 509, 89, 23);
		}
		return btnAceptar;
	}
	private JButton getBtnCancelar() {
		if (btnCancelar == null) {
			btnCancelar = new JButton("Cancelar");
			btnCancelar.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent arg0) {
					VisualSector x= new VisualSector();
					dispose();
					x.setModal(true);
					x.setLocationRelativeTo(null);
					x.setVisible(true);
					
				}
			});
			btnCancelar.setBounds(617, 509, 89, 23);
		}
		return btnCancelar;
	}
	private JButton getBtnEliminar() {
		if (btnEliminar == null) {
			btnEliminar = new JButton("Eliminar");
			btnEliminar.setEnabled(false);
			btnEliminar.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent arg0) {
					int pos=table.getSelectedRow();
					sector.getListaDocumentos().remove(pos);
					tableModel.refresh(sector.getListaDocumentos());
					btnEliminar.setEnabled(false);
				}
			});
			btnEliminar.setBounds(560, 29, 89, 23);
		}
		return btnEliminar;
	}
	public void establecer(Sector sector){
		txNombre.setText(sector.getNombre());
		this.sector.setNombre(sector.getNombre());
		tableModel.refresh(sector.getListaDocumentos());
	}
	private JButton getBtModificar() {
		if (btModificar == null) {
			btModificar = new JButton("Modificar");
			btModificar.setVisible(false);
			btModificar.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent arg0) {
					sector.setNombre(txNombre.getText());
					VisualSector x= new VisualSector();
					dispose();
					x.setModal(true);
					x.setLocationRelativeTo(null);
					x.setVisible(true);
				}
			});
			btModificar.setBounds(507, 509, 89, 23);
		}
		return btModificar;
	}
	public void validar(){
		if(txNombre.getText().trim().length()>0){
			btnAceptar.setEnabled(true);
			btModificar.setEnabled(true);
		}
		else{
			btnAceptar.setEnabled(false);
			btModificar.setEnabled(false);
		}
	}
	private JLabel getLabel() {
		if (label == null) {
			label = new JLabel("->");
			label.setBounds(197, 32, 17, 14);
			label.setVisible(true);
			label.setForeground(Color.RED);
			label.setFont(new Font("Tahoma", Font.BOLD, 12));
		}
		return label;
	}
	private JPanel getPanel_3() {
		if (panel_3 == null) {
			panel_3 = new JPanel();
			panel_3.setBounds(0, 0, 714, 32);
			panel_3.setLayout(null);
			panel_3.add(getLblCreacinDeSector());
			panel_3.add(getButton());
			panel_3.setBackground(new Color(219, 219, 219));
		}
		return panel_3;
	}
	private JLabel getLblCreacinDeSector() {
		if (lblCreacinDeSector == null) {
			lblCreacinDeSector = new JLabel("Creaci\u00F3n de Sector");
			lblCreacinDeSector.setFont(new Font("Tahoma", Font.PLAIN, 22));
			lblCreacinDeSector.setBounds(247, 0, 219, 31);
		}
		return lblCreacinDeSector;
	}
	private JButton getButton() {
		if (button == null) {
			button = new JButton("X");
			button.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					VisualSector y = new VisualSector();
					dispose();
					y.setVisible(true);
					y.setModal(true);
					y.setLocationRelativeTo(null);
				}
			});
			button.setForeground(Color.WHITE);
			button.setFont(new Font("Tahoma", Font.PLAIN, 13));
			button.setBackground(Color.RED);
			button.setBounds(665, 0, 49, 32);
		}
		return button;
	}
}
