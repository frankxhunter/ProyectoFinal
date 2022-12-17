package visual;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

import javax.swing.DefaultComboBoxModel;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JDialog;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.SwingConstants;
import javax.swing.border.EmptyBorder;
import javax.swing.border.LineBorder;
import javax.swing.border.TitledBorder;

import util.EmpresaTableModel;
import util.MetodosUtiles;
import clase.AgenciaEmpleadora;
import clase.Empresa;
import clase.Sector;
import excepcionesPropias.YaExisteExceptions;

import java.awt.event.FocusAdapter;
import java.awt.event.FocusEvent;

public class VisualEmpresa extends JDialog {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private final JPanel contentPanel = new JPanel();
	private JPanel panel;
	private JScrollPane scrollPane;
	private JTable table;
	private EmpresaTableModel tableModel;
	private JPanel panel_1;
	private JTextField txNombre;
	private JLabel label;
	private JLabel label_1;
	private JTextField txDireccion;
	private JLabel label_2;
	private JLabel label_3;
	private JTextField txTelefono;
	private JComboBox<String> coSector;
	private JButton btAgregar;
	private JButton btEliminar;
	private JButton btModificar;
	private JPanel panel_2;
	private JPanel panel_3;
	private JLabel lblListaDeEmpresas;
	private JButton button;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		try {
			VisualEmpresa dialog = new VisualEmpresa();
			dialog.setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
			dialog.setVisible(true);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	/**
	 * Create the dialog.
	 */
	public VisualEmpresa() {
		setUndecorated(true);
		setBounds(100, 100, 697, 491);
		getContentPane().setLayout(new BorderLayout());
		contentPanel.setBackground(new Color(158, 130, 116));
		contentPanel.setBorder(new EmptyBorder(5, 5, 5, 5));
		getContentPane().add(contentPanel, BorderLayout.CENTER);
		contentPanel.setLayout(null);
		contentPanel.add(getPanel_2());
		contentPanel.add(getPanel_3());
		tableModel.refresh(AgenciaEmpleadora.getInstancia().getListaEmpresas());
	}
	private JPanel getPanel() {
		if (panel == null) {
			panel = new JPanel();
			panel.setBounds(0, 143, 679, 294);
			panel.setBackground(Color.LIGHT_GRAY);
			panel.setBorder(new TitledBorder(new LineBorder(new Color(0, 0, 0), 2), "Listado de Empresas", TitledBorder.LEADING, TitledBorder.TOP,
					new Font("Tahoma", Font.PLAIN, 15), new Color(0, 0, 0)));
			panel.setLayout(null);
			panel.add(getScrollPane());
			panel.add(getBtModificar());
			panel.add(getBtEliminar());
		}
		return panel;
	}
	private JScrollPane getScrollPane() {
		if (scrollPane == null) {
			scrollPane = new JScrollPane();
			scrollPane.setBounds(10, 25, 643, 224);
			scrollPane.setViewportView(getTable());
		}
		return scrollPane;
	}
	private JTable getTable() {
		if (table == null) {
			table = new JTable();
			table.addMouseListener(new MouseAdapter() {
				@Override
				public void mousePressed(MouseEvent e) {
					rellenar();
					btModificar.setEnabled(true);
				}
			});
			tableModel=new EmpresaTableModel();
			table.setModel(tableModel);
			table.getTableHeader().setReorderingAllowed(false);
		}
		return table;
	}
	private JPanel getPanel_1() {
		if (panel_1 == null) {
			panel_1 = new JPanel();
			panel_1.setBounds(0, 0, 679, 132);
			panel_1.setBackground(Color.LIGHT_GRAY);
			panel_1.setLayout(null);
			panel_1.setBorder(new TitledBorder(new LineBorder(new Color(0, 0, 0), 2), "Datos de la Empresa", TitledBorder.LEADING, TitledBorder.TOP, 
					new Font("Tahoma", Font.PLAIN, 15), new Color(0, 0, 0)));
			panel_1.add(getTxNombre());
			panel_1.add(getLabel());
			panel_1.add(getLabel_1());
			panel_1.add(getTxDireccion());
			panel_1.add(getLabel_2());
			panel_1.add(getLabel_3());
			panel_1.add(getTxTelefono());
			panel_1.add(getCoSector());
			panel_1.add(getBtAgregar());
		}
		return panel_1;
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
			txNombre.setToolTipText("Nombre de la Empresa\r\n");
			txNombre.addKeyListener(new KeyAdapter() {
				@Override
				public void keyTyped(KeyEvent e) {
					MetodosUtiles.validacionJTextLetra(txNombre.getText().trim().length(), e);
						validar();
						txNombre.setBorder(null);
				}
			});
			txNombre.setColumns(10);
			txNombre.setBounds(111, 33, 212, 22);
		}
		return txNombre;
	}
	private JLabel getLabel() {
		if (label == null) {
			label = new JLabel("Nombre");
			label.setFont(new Font("Tahoma", Font.PLAIN, 13));
			label.setHorizontalAlignment(SwingConstants.RIGHT);
			label.setBounds(45, 36, 56, 16);
		}
		return label;
	}
	private JLabel getLabel_1() {
		if (label_1 == null) {
			label_1 = new JLabel("Direccion");
			label_1.setFont(new Font("Tahoma", Font.PLAIN, 13));
			label_1.setHorizontalAlignment(SwingConstants.RIGHT);
			label_1.setBounds(45, 67, 56, 14);
		}
		return label_1;
	}
	private JTextField getTxDireccion() {
		if (txDireccion == null) {
			txDireccion = new JTextField();
			txDireccion.addFocusListener(new FocusAdapter() {
				@Override
				public void focusLost(FocusEvent e) {
					if(txDireccion.getText().trim().length()==0)
						txDireccion.setBorder(new LineBorder(Color.RED, 2));
				}
			});
			txDireccion.setToolTipText("Direccion donde se encuentra ubicada la empresa");
			txDireccion.addKeyListener(new KeyAdapter() {
				@Override
				public void keyTyped(KeyEvent e) {
					MetodosUtiles.validacionJTextCharacter(txDireccion.getText().trim().length(), e);
					validar();
					txDireccion.setBorder(null);
					}
			});
			txDireccion.setColumns(10);
			txDireccion.setBounds(111, 64, 212, 20);
		}
		return txDireccion;
	}
	private JLabel getLabel_2() {
		if (label_2 == null) {
			label_2 = new JLabel("Telefono");
			label_2.setFont(new Font("Tahoma", Font.PLAIN, 13));
			label_2.setHorizontalAlignment(SwingConstants.RIGHT);
			label_2.setBounds(353, 37, 62, 14);
		}
		return label_2;
	}
	private JLabel getLabel_3() {
		if (label_3 == null) {
			label_3 = new JLabel("Sector");
			label_3.setFont(new Font("Tahoma", Font.PLAIN, 13));
			label_3.setHorizontalAlignment(SwingConstants.RIGHT);
			label_3.setBounds(369, 67, 46, 14);
		}
		return label_3;
	}
	private JTextField getTxTelefono() {
		if (txTelefono == null) {
			txTelefono = new JTextField();
			txTelefono.addFocusListener(new FocusAdapter() {
				@Override
				public void focusLost(FocusEvent e) {
					if(txTelefono.getText().trim().length()<8)
						txTelefono.setBorder(new LineBorder(Color.RED, 2));
				}
			});
			txTelefono.setToolTipText("El numero de telefeono, deben ser 8 digitos");
			txTelefono.addKeyListener(new KeyAdapter() {
				@Override
				public void keyTyped(KeyEvent e) {
				MetodosUtiles.validacionJTextNumero(txTelefono.getText().trim().length(), 8, e);
				}
				@Override
				public void keyReleased(KeyEvent e) {
					validar();
					txTelefono.setBorder(null);
					}
			});
			txTelefono.setColumns(10);
			txTelefono.setBounds(425, 34, 212, 20);
		}
		return txTelefono;
	}
	private JComboBox<String> getCoSector() {
		if (coSector == null) {
			coSector = new JComboBox<String>();
			coSector.setToolTipText("El sector al que pertenece la empresa");
			coSector.setModel(new DefaultComboBoxModel<String>(crearComboBox()));
			coSector.setBounds(425, 64, 212, 20);
		}
		return coSector;
	}
	private JButton getBtAgregar() {
		if (btAgregar == null) {
			btAgregar = new JButton("Agregar");
			btAgregar.setFocusable(false);
			btAgregar.setFont(new Font("Tahoma", Font.PLAIN, 13));
			btAgregar.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent arg0) {
					try{
					Empresa empresa= new Empresa(txNombre.getText().trim(),txDireccion.getText().trim(), txTelefono.getText().trim(),
							AgenciaEmpleadora.getInstancia().obtenerSector(coSector.getSelectedItem().toString().trim()));
					AgenciaEmpleadora.getInstancia().addEmpresa(empresa);
					tableModel.refresh(AgenciaEmpleadora.getInstancia().getListaEmpresas());
					limpiar();
					btAgregar.setEnabled(false);
					btModificar.setEnabled(false);
					}catch(YaExisteExceptions e){
						MetodosUtiles.mostrarMensaje(e);
					}
				}
			});
			btAgregar.setEnabled(false);
			btAgregar.setBounds(557, 95, 89, 23);
		}
		return btAgregar;
	}
	private JButton getBtEliminar() {
		if (btEliminar == null) {
			btEliminar = new JButton("Eliminar");
			btEliminar.setFocusable(false);
			btEliminar.setFont(new Font("Tahoma", Font.PLAIN, 13));
			btEliminar.setBounds(564, 260, 89, 23);
			btEliminar.setEnabled(false);
			btEliminar.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent arg0) {
					int pos=table.getSelectedRow();
					AgenciaEmpleadora.getInstancia().getListaEmpresas().remove(pos);
					tableModel.refresh(AgenciaEmpleadora.getInstancia().getListaEmpresas());
					btEliminar.setEnabled(false);

				}
			});
		}
		return btEliminar;
	}
	private JButton getBtModificar() {
		if (btModificar == null) {
			btModificar = new JButton("Modificar");
			btModificar.setFocusable(false);
			btModificar.setFont(new Font("Tahoma", Font.PLAIN, 13));
			btModificar.setBounds(465, 260, 89, 23);
			btModificar.setEnabled(false);
			btModificar.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent arg0) {
					Empresa empresa=new Empresa(txNombre.getText(),txDireccion.getText(), txTelefono.getText(),
							AgenciaEmpleadora.getInstancia().obtenerSector(coSector.getSelectedItem().toString()));
					int pos= table.getSelectedRow();
					AgenciaEmpleadora.getInstancia().getListaEmpresas().remove(pos);
					AgenciaEmpleadora.getInstancia().getListaEmpresas().add(pos, empresa);
					tableModel.refresh(AgenciaEmpleadora.getInstancia().getListaEmpresas());
					limpiar();
					btAgregar.setEnabled(false); 
					btModificar.setEnabled(false);
					btEliminar.setEnabled(false);
				}
			});
		}
		return btModificar;
	}
	private JPanel getPanel_2() {
		if (panel_2 == null) {
			panel_2 = new JPanel();
			panel_2.setBackground(new Color(158, 130, 116));
			panel_2.setBounds(10, 44, 699, 463);
			panel_2.setLayout(null);
			panel_2.add(getPanel_1());
			panel_2.add(getPanel());
		}
		return panel_2;
	}
	private JPanel getPanel_3() {
		if (panel_3 == null) {
			panel_3 = new JPanel();
			panel_3.setLayout(null);
			panel_3.setBackground(new Color(219, 219, 219));
			panel_3.setBounds(0, 0, 697, 33);
			panel_3.add(getLblListaDeEmpresas());
			panel_3.add(getButton_1());
		}
		return panel_3;
	}
	private JLabel getLblListaDeEmpresas() {
		if (lblListaDeEmpresas == null) {
			lblListaDeEmpresas = new JLabel("Lista de Empresas");
			lblListaDeEmpresas.setFont(new Font("Tahoma", Font.PLAIN, 22));
			lblListaDeEmpresas.setBounds(249, 0, 263, 33);
		}
		return lblListaDeEmpresas;
	}
	private JButton getButton_1() {
		if (button == null) {
			button = new JButton("X");
			button.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					dispose();
				}
			});
			button.setForeground(Color.WHITE);
			button.setFont(new Font("Tahoma", Font.PLAIN, 13));
			button.setFocusable(false);
			button.setBackground(Color.RED);
			button.setBounds(648, 0, 49, 33);
		}
		return button;
	}

	public void rellenar(){
		Empresa x= AgenciaEmpleadora.getInstancia().getListaEmpresas().get(table.getSelectedRow());
		txDireccion.setText(x.getDireccion());
		txNombre.setText(x.getNombre());
		txTelefono.setText(x.getTelefono());
		btAgregar.setEnabled(false);
		coSector.setSelectedItem(x.getSector().getNombre());
		btModificar.setEnabled(false);
		btEliminar.setEnabled(true);
	}

	public String[] crearComboBox(){
		String[] salida=new String[AgenciaEmpleadora.getInstancia().getlistaSector().size()];
		int pos=0;
		for(Sector x: AgenciaEmpleadora.getInstancia().getlistaSector())
			salida[pos++]=x.getNombre();
		return salida;
	}

	public void limpiar(){
		txNombre.setText("");
		txDireccion.setText("");
		txTelefono.setText("");
	}

	public void validar(){
		boolean x=false;
		if(!txNombre.getText().trim().isEmpty())
			if(!txDireccion.getText().trim().isEmpty())
				if(txTelefono.getText().trim().length()==8){
					btAgregar.setEnabled(true);
					if(table.getSelectedRow()!=-1)
					btModificar.setEnabled(true);
					x=true;
				}
		if(!x){
			btAgregar.setEnabled(false);
			btModificar.setEnabled(false);
		}
	}
}
