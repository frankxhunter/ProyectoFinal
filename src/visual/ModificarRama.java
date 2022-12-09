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
import clase.Rama;

import javax.swing.UIManager;

import excepcionesPropias.YaExisteExceptions;
import javax.swing.JRadioButton;

public class ModificarRama extends JDialog {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private Rama rama;
	private int posicion;
	private JPanel panel;
	private JLabel lblNombreDelaRama;
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
	private JButton btnX;
	private JScrollPane scrollPane_1;
	private JPanel panel_4;
	private JLabel lblCreacinDeRama;
	private JRadioButton radioButton;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		try {
			ModificarRama dialog = new ModificarRama(-1);
			dialog.setDefaultCloseOperation(JDialog.HIDE_ON_CLOSE);
			dialog.setVisible(true);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	/**
	 * Create the dialog.
	 */
	public ModificarRama(int pos) {
		getContentPane().setForeground(Color.WHITE);
		setUndecorated(true);
		setDefaultCloseOperation(JDialog.HIDE_ON_CLOSE);
		getContentPane().setBackground(new Color(158, 130, 116));
		setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
		setBounds(100, 100, 714, 542);
		getContentPane().setLayout(null);
		getContentPane().add(getScrollPane_1());
		getContentPane().add(getPanel_4());
		getContentPane().add(getPanel());
		getContentPane().add(getBtModificar());
		getContentPane().add(getBtnCancelar());
		getContentPane().add(getBtnAceptar());
		if(pos!=-1){
			posicion=pos;
			rama=AgenciaEmpleadora.getInstancia().getlistaRama().get(posicion);
			establecer(rama);
			btnAceptar.setVisible(false);
			btModificar.setVisible(true);
		}
		else 
			rama= new Rama();
	}
	private JPanel getPanel() {
		if (panel == null) {
			panel = new JPanel();
			panel.setBounds(7, 45, 699, 458);
			panel.setBackground(Color.LIGHT_GRAY);
			panel.setBorder(new TitledBorder(new LineBorder(new Color(0, 0, 0)), "Rama", TitledBorder.LEADING, TitledBorder.TOP, null, new Color(0, 0, 0)));
			panel.setLayout(null);
			panel.add(getLblNombreDelaRama());
			panel.add(getTxNombre());
			panel.add(getPanel_1());
		}
		return panel;
	}
	private JLabel getLblNombreDelaRama() {
		if (lblNombreDelaRama == null) {
			lblNombreDelaRama = new JLabel("Nombre de la Rama");
			lblNombreDelaRama.setFont(new Font("Tahoma", Font.PLAIN, 15));
			lblNombreDelaRama.setBounds(44, 35, 145, 14);
		}
		return lblNombreDelaRama;
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
					MetodosUtiles.validacionJTextLetra(txNombre.getText().trim().length(), e);
				}
			});
			txNombre.setBounds(189, 32, 116, 20);
			txNombre.setColumns(10);
		}
		return txNombre;
	}
	private JPanel getPanel_1() {
		if (panel_1 == null) {
			panel_1 = new JPanel();
			panel_1.setBackground(Color.LIGHT_GRAY);
			panel_1.setBorder(new TitledBorder(new LineBorder(new Color(0, 0, 0)), "Documentos Necesarios", TitledBorder.LEADING, TitledBorder.TOP, null, null));
			panel_1.setBounds(19, 65, 661, 374);
			panel_1.setLayout(null);
			panel_1.add(getLblDocumentoParaAgregar());
			panel_1.add(getTxDocumento());
			panel_1.add(getBtnAgregar());
			panel_1.add(getPanel_2());
			panel_1.add(getBtnEliminar());
			panel_1.add(getLabel());
			panel_1.add(getRadioButton());
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
					MetodosUtiles.validacionJTextCharacter(txDocumento.getText().trim().length(), e);}
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
					try {
						if(txDocumento.getText().trim().length()>0){

							rama.addDocumento(new Documento(txDocumento.getText(),radioButton.isSelected()));

							tableModel.refresh(rama.getListaDocumentos());
							txDocumento.setText("");
						}
						else{
							label.setVisible(true);
						}
					} catch (YaExisteExceptions e) {
						MetodosUtiles.mostrarMensaje(e);
					}
				}
			});
			btnAgregar.setBounds(459, 28, 89, 23);
		}
		return btnAgregar;
	}
	private JPanel getPanel_2() {
		if (panel_2 == null) {
			panel_2 = new JPanel();
			panel_2.setBounds(10, 94, 641, 261);
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
			btnAceptar.setBounds(493, 509, 89, 23);
			btnAceptar.setEnabled(false);
			btnAceptar.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent arg0) {
					rama.setNombre(txNombre.getText());
					AgenciaEmpleadora.getInstancia().getListaEspecialidades().add(rama);
					VisualRama x= new VisualRama();
					dispose();
					x.setVisible(true);
					x.setModal(true);
					x.setLocationRelativeTo(null);
				}
			});
		}
		return btnAceptar;
	}
	private JButton getBtnCancelar() {
		if (btnCancelar == null) {
			btnCancelar = new JButton("Cancelar");
			btnCancelar.setBounds(617, 509, 89, 23);
			btnCancelar.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent arg0) {
					VisualRama y= new VisualRama();
					dispose();
					y.setVisible(true);
					y.setModal(true);
					y.setLocationRelativeTo(null);
				}
			});
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
					rama.getListaDocumentos().remove(pos);
					tableModel.refresh(rama.getListaDocumentos());
					btnEliminar.setEnabled(false);
				}
			});
			btnEliminar.setBounds(560, 28, 89, 23);
		}
		return btnEliminar;
	}
	public void establecer(Rama rama){
		txNombre.setText(rama.getNombre());
		this.rama.setNombre(rama.getNombre());
		tableModel.refresh(rama.getListaDocumentos());
	}
	private JButton getBtModificar() {
		if (btModificar == null) {
			btModificar = new JButton("Modificar");
			btModificar.setBounds(507, 509, 89, 23);
			btModificar.setVisible(false);
			btModificar.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent arg0) {
					rama.setNombre(txNombre.getText());
					VisualRama y= new VisualRama();
					dispose();
					y.setVisible(true);
					y.setModal(true);
					y.setLocationRelativeTo(null);
				}
			});
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
			label.setVisible(true);
			label.setForeground(Color.RED);
			label.setFont(new Font("Tahoma", Font.BOLD, 12));
			label.setBounds(197, 32, 17, 14);
		}
		return label;
	}
	private JButton getBtnX() {
		if (btnX == null) {
			btnX = new JButton("X");
			btnX.setFocusable(false);
			btnX.setBounds(665, 0, 49, 32);
			btnX.setForeground(Color.WHITE);
			btnX.setBackground(Color.RED);
			btnX.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					VisualRama y= new VisualRama();
					dispose();
					y.setVisible(true);
					y.setModal(true);
					y.setLocationRelativeTo(null);
				}
			});
			btnX.setFont(new Font("Tahoma", Font.PLAIN, 13));
		}
		return btnX;
	}
	private JScrollPane getScrollPane_1() {
		if (scrollPane_1 == null) {
			scrollPane_1 = new JScrollPane();
			scrollPane_1.setBounds(22, 29, 2, 2);
		}
		return scrollPane_1;
	}
	private JPanel getPanel_4() {
		if (panel_4 == null) {
			panel_4 = new JPanel();
			panel_4.setBackground(new Color(219, 219, 219));
			panel_4.setBounds(0, 0, 714, 32);
			panel_4.setLayout(null);
			panel_4.add(getLblCreacinDeRama());
			panel_4.add(getBtnX());
		}
		return panel_4;
	}
	private JLabel getLblCreacinDeRama() {
		if (lblCreacinDeRama == null) {
			lblCreacinDeRama = new JLabel("Creaci\u00F3n de Rama");
			lblCreacinDeRama.setBounds(265, 5, 183, 21);
			lblCreacinDeRama.setFont(new Font("Tahoma", Font.PLAIN, 22));
		}
		return lblCreacinDeRama;
	}
	private JRadioButton getRadioButton() {
		if (radioButton == null) {
			radioButton = new JRadioButton("Obligatorio");
			radioButton.setFont(new Font("Tahoma", Font.PLAIN, 15));
			radioButton.setBackground(Color.LIGHT_GRAY);
			radioButton.setBounds(33, 64, 152, 23);
		}
		return radioButton;
	}
}
