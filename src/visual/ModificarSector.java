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

import javax.swing.JRadioButton;

import java.awt.event.FocusAdapter;
import java.awt.event.FocusEvent;

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
	private JPanel panel_3;
	private JLabel lblCreacinDeSector;
	private JButton button;
	private JRadioButton rdbtnObligatorio;

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
			panel.setBackground(Color.LIGHT_GRAY);
			panel.setBorder(new TitledBorder(new LineBorder(new Color(0, 0, 0)), "Sector", TitledBorder.LEADING, TitledBorder.TOP, new Font("Tahoma", Font.PLAIN, 15), null));
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
			txNombre.addFocusListener(new FocusAdapter() {
				@Override
				public void focusLost(FocusEvent e) {
					if(txNombre.getText().trim().length()==0)
						txNombre.setBorder(new LineBorder(Color.RED, 2));
				}
			});
			txNombre.addKeyListener(new KeyAdapter() {
				@Override
				public void keyReleased(KeyEvent arg0) {
					validar();
				}
				@Override
				public void keyTyped(KeyEvent e) {
					MetodosUtiles.validacionJTextLetra(txNombre.getText().trim().length(),e);
					txNombre.setBorder(null);
				}
			});
			txNombre.setBounds(189, 32, 106, 20);
			txNombre.setColumns(10);
		}
		return txNombre;
	}
	private JPanel getPanel_1() {
		if (panel_1 == null) {
			panel_1 = new JPanel();
			panel_1.setBackground(Color.LIGHT_GRAY);
			panel_1.setBorder(new TitledBorder(new LineBorder(new Color(0, 0, 0)), "Documentos Necesarios", TitledBorder.LEADING, TitledBorder.TOP, new Font("Tahoma", Font.PLAIN, 15), null));
			panel_1.setBounds(19, 65, 661, 374);
			panel_1.setLayout(null);
			panel_1.add(getLblDocumentoParaAgregar());
			panel_1.add(getTxDocumento());
			panel_1.add(getBtnAgregar());
			panel_1.add(getPanel_2());
			panel_1.add(getBtnEliminar());
			panel_1.add(getRdbtnObligatorio());
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
					txDocumento.setBorder(null);
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
			btnAgregar.setFocusable(false);
			btnAgregar.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent arg0) {
					if(txDocumento.getText().trim().length()>0){
						try{
							sector.addDocumento(new Documento(txDocumento.getText(),rdbtnObligatorio.isSelected()));
							tableModel.refresh(sector.getListaDocumentos());
							txDocumento.setText("");
							btnEliminar.setEnabled(false);
						}catch(YaExisteExceptions e){
							MetodosUtiles.mostrarMensaje(e);
						}
					}
					else{
						txDocumento.setBorder(new LineBorder(Color.RED, 2));
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
			panel_2.setBounds(10, 91, 641, 272);
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
			btnAceptar.setFocusable(false);
			btnAceptar.setEnabled(false);
			btnAceptar.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent arg0) {
					try{
						sector.setNombre(txNombre.getText());
						AgenciaEmpleadora.getInstancia().addSector(sector);
						cambiaPantalla();
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
			btnCancelar.setFocusable(false);
			btnCancelar.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent arg0) {
					cambiaPantalla();
				}
			});
			btnCancelar.setBounds(617, 509, 89, 23);
		}
		return btnCancelar;
	}
	private JButton getBtnEliminar() {
		if (btnEliminar == null) {
			btnEliminar = new JButton("Eliminar");
			btnEliminar.setFocusable(false);
			btnEliminar.setEnabled(false);
			btnEliminar.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent arg0) {
					int[] posiciones=table.getSelectedRows();
					int pos=0;
					for(int x: posiciones)
						sector.getListaDocumentos().remove(x-pos++);
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
		tableModel.refresh(sector.getListaDocumentos());
	}
	private JButton getBtModificar() {
		if (btModificar == null) {
			btModificar = new JButton("Modificar");
			btModificar.setFocusable(false);
			btModificar.setVisible(false);
			btModificar.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent arg0) {
					sector.setNombre(txNombre.getText());
					cambiaPantalla();
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
			button.setFocusable(false);
			button.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					cambiaPantalla();
				}
			});
			button.setForeground(Color.WHITE);
			button.setFont(new Font("Tahoma", Font.PLAIN, 13));
			button.setBackground(Color.RED);
			button.setBounds(665, 0, 49, 32);
		}
		return button;
	}
	private JRadioButton getRdbtnObligatorio() {
		if (rdbtnObligatorio == null) {
			rdbtnObligatorio = new JRadioButton("Obligatorio");
			rdbtnObligatorio.setBackground(Color.LIGHT_GRAY);
			rdbtnObligatorio.setFont(new Font("Tahoma", Font.PLAIN, 15));
			rdbtnObligatorio.setBounds(33, 61, 152, 23);
		}
		return rdbtnObligatorio;
	}
	public void cambiaPantalla(){
		VisualSector y= new VisualSector();
		dispose();
		y.setLocationRelativeTo(null);
		y.setModal(true);
		y.setVisible(true);
	}
}
