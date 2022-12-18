package visual;

import java.awt.CardLayout;
import java.awt.Color;
import java.awt.Font;
import java.awt.SystemColor;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.ArrayList;
import java.util.Collections;

import javax.swing.DefaultComboBoxModel;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JDialog;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JSpinner;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.SpinnerNumberModel;
import javax.swing.SwingConstants;
import javax.swing.border.LineBorder;
import javax.swing.border.TitledBorder;

import util.CandidatoEntrevistaTableModel;
import util.MetodosUtiles;
import util.OfertaTableModel;
import clase.AgenciaEmpleadora;
import clase.Candidato;
import clase.Empresa;
import clase.Oferta;
import clase.Rama;
import excepcionesPropias.YaExisteExceptions;

public class VisualOferta extends JDialog {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private JPanel panel;
	private JLabel lblSeleccioneLaEmpresa;
	private JComboBox<String> coEmpresa;
	private JPanel panel_1;
	private JScrollPane scrollPane;
	private JButton btnCancelar;
	private JButton btnModificar;
	private JButton btnAgregar;
	private JTable table;
	private OfertaTableModel tableModel=new OfertaTableModel();
	private CandidatoEntrevistaTableModel tableModel2=new CandidatoEntrevistaTableModel();
	private JPanel panel_2;
	private JLabel lblNewLabel;
	private JTextField txID;
	private JLabel lblSalario;
	private JSpinner spSalario;
	private JLabel lblCantidadDePlazas;
	private JSpinner spCantidad;
	private JButton btnEliminar;
	private Empresa empresa;
	private ArrayList<Candidato> lista;
	private JLabel lblRama;
	private JComboBox<String> coRama;
	private JButton button;
	private JPanel panel_3;
	private JButton btnProgramarEntrevista;
	private JPanel panel_4;
	private JScrollPane scrollPane_1;
	private JTable table_1;
	private JPanel panel_5;
	private JLabel lblOfertas;
	private JButton button_1;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		try {
			VisualOferta dialog = new VisualOferta();
			dialog.setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
			dialog.setVisible(true);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	/**
	 * Create the dialog.
	 */
	public VisualOferta() {
		setUndecorated(true);
		getContentPane().setBackground(new Color(158, 130, 116));
		setBounds(100, 100, 1044, 402);
		getContentPane().setLayout(null);
		getContentPane().add(getPanel());
		getContentPane().add(getPanel_3());
		getContentPane().add(getPanel_5());
		if(AgenciaEmpleadora.getInstancia().getListaEmpresas().get(0)!=null){
		empresa=AgenciaEmpleadora.getInstancia().getListaEmpresas().get(0);
		tableModel.refresh(empresa.getListaOfertas());
		}

	}
	private JPanel getPanel() {
		if (panel == null) {
			panel = new JPanel();
			panel.setBackground(Color.LIGHT_GRAY);
			panel.setBorder(new TitledBorder(new LineBorder(new Color(0, 0, 0)), "Control de Ofertas", TitledBorder.LEADING, TitledBorder.TOP, 
					new Font("Tahoma", Font.PLAIN, 15), new Color(0, 0, 0)));
			panel.setBounds(10, 50, 711, 341);
			panel.setLayout(null);
			panel.add(getLblSeleccioneLaEmpresa());
			panel.add(getCoEmpresa());
			panel.add(getPanel_1());
			panel.add(getBtnModificar());
			panel.add(getPanel_2());
			panel.add(getBtnEliminar());
		}
		return panel;
	}
	private JLabel getLblSeleccioneLaEmpresa() {
		if (lblSeleccioneLaEmpresa == null) {
			lblSeleccioneLaEmpresa = new JLabel("Seleccione la Empresa");
			lblSeleccioneLaEmpresa.setHorizontalAlignment(SwingConstants.RIGHT);
			lblSeleccioneLaEmpresa.setFont(new Font("Tahoma", Font.PLAIN, 13));
			lblSeleccioneLaEmpresa.setBounds(10, 23, 169, 14);
		}
		return lblSeleccioneLaEmpresa;
	}
	private JComboBox<String> getCoEmpresa() {
		if (coEmpresa == null) {
			coEmpresa = new JComboBox<String>();
			coEmpresa.addItemListener(new ItemListener() {
				public void itemStateChanged(ItemEvent e) {
					empresa= AgenciaEmpleadora.getInstancia().obtenerEmpresa(coEmpresa.getSelectedItem().toString());
					tableModel.refresh(empresa.getListaOfertas());
				}
			});
			coEmpresa.setModel(new DefaultComboBoxModel<String>(obtenerEmpresas()));
			coEmpresa.setBounds(189, 20, 131, 20);
		}
		return coEmpresa;
	}
	private JPanel getPanel_1() {
		if (panel_1 == null) {
			panel_1 = new JPanel();
			panel_1.setBorder(new TitledBorder(new LineBorder(new Color(0, 0, 0)), "Lista de Ofertas", TitledBorder.LEADING, TitledBorder.TOP, new Font("Tahoma", Font.PLAIN, 15), null));
			panel_1.setBounds(330, 11, 371, 285);
			panel_1.setLayout(new CardLayout(0, 0));
			panel_1.add(getScrollPane(), "name_485070499566889");
		}
		return panel_1;
	}
	private JScrollPane getScrollPane() {
		if (scrollPane == null) {
			scrollPane = new JScrollPane();
			scrollPane.setViewportView(getTable());
		}
		return scrollPane;
	}
	private JButton getBtnCancelar() {
		if (btnCancelar == null) {
			btnCancelar = new JButton("Cancelar");
			btnCancelar.setFont(new Font("Tahoma", Font.PLAIN, 13));
			btnCancelar.setFocusable(false);
			btnCancelar.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					dispose();
				}
			});
			btnCancelar.setBounds(212, 202, 89, 23);
		}
		return btnCancelar;
	}
	private JButton getBtnModificar() {
		if (btnModificar == null) {
			btnModificar = new JButton("Modificar");
			btnModificar.setFont(new Font("Tahoma", Font.PLAIN, 13));
			btnModificar.setFocusable(false);
			btnModificar.setEnabled(false);
			btnModificar.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					Oferta oferta1=empresa.getListaOfertas().get(table.getSelectedRow());
					oferta1.setSalario(Integer.parseInt(spSalario.getValue().toString()));
					oferta1.setNumeroId(txID.getText());
					oferta1.setCantCandidatos(Integer.parseInt(spCantidad.getValue().toString()));
					oferta1.setRama(AgenciaEmpleadora.getInstancia().obtenerRama(coRama.getSelectedItem().toString()));
					tableModel.refresh(empresa.getListaOfertas());
					limpiar();
					btnModificar.setEnabled(false);
					btnEliminar.setEnabled(false);
					tableModel2.setRowCount(0);
				}
			});
			btnModificar.setBounds(513, 307, 89, 23);
		}
		return btnModificar;
	}
	private JButton getBtnAgregar() {
		if (btnAgregar == null) {
			btnAgregar = new JButton("Agregar");
			btnAgregar.setFont(new Font("Tahoma", Font.PLAIN, 13));
			btnAgregar.setFocusable(false);
			btnAgregar.setEnabled(false);
			btnAgregar.setBounds(114, 202, 89, 23);
			btnAgregar.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					try{
					Oferta  oferta=new Oferta(txID.getText(), Integer.parseInt(spSalario.getValue().toString()),
							Integer.parseInt(spCantidad.getValue().toString()), 
							AgenciaEmpleadora.getInstancia().obtenerRama(coRama.getSelectedItem().toString()),empresa);
					empresa.addOferta(oferta);;
					tableModel.refresh(empresa.getListaOfertas());
					limpiar();		
					btnAgregar.setEnabled(false);
					btnModificar.setEnabled(false);
					tableModel2.setRowCount(0);
					}catch(YaExisteExceptions d){
						MetodosUtiles.mostrarMensaje(d);
					}
				}
			});
		}
		return btnAgregar;
	}
	private JTable getTable() {
		if (table == null) {
			table = new JTable();
			table.addMouseListener(new MouseAdapter() {
				@Override
				public void mousePressed(MouseEvent e) {
					rellenar();
					Oferta oferta=empresa.getListaOfertas().get(table.getSelectedRow());
					lista=AgenciaEmpleadora.getInstancia().devolverCandidatoSegunOferta(oferta);
					Collections.sort(lista);
					tableModel2.refresh(lista);
				}
			});
			table.setModel(tableModel);
			table.getTableHeader().setReorderingAllowed(false);
		}
		return table;
	}
	private JPanel getPanel_2() {
		if (panel_2 == null) {
			panel_2 = new JPanel();
			panel_2.setBorder(new TitledBorder(new LineBorder(new Color(0, 0, 0)), "A\u00F1adir Ofertas", TitledBorder.LEADING, TitledBorder.TOP, new Font("Tahoma", Font.PLAIN, 15), null));
			panel_2.setBounds(10, 48, 311, 248);
			panel_2.setLayout(null);
			panel_2.add(getLblNewLabel());
			panel_2.add(getTxID());
			panel_2.add(getLblSalario());
			panel_2.add(getSpSalario());
			panel_2.add(getLblCantidadDePlazas());
			panel_2.add(getSpCantidad());
			panel_2.add(getBtnAgregar());
			panel_2.add(getBtnCancelar());
			panel_2.add(getLblRama());
			panel_2.add(getCoRama());
			panel_2.add(getButton());
		}
		return panel_2;
	}
	private JLabel getLblNewLabel() {
		if (lblNewLabel == null) {
			lblNewLabel = new JLabel("Numero de ID");
			lblNewLabel.setHorizontalAlignment(SwingConstants.RIGHT);
			lblNewLabel.setFont(new Font("Tahoma", Font.PLAIN, 13));
			lblNewLabel.setBounds(25, 32, 79, 14);
		}
		return lblNewLabel;
	}
	private JTextField getTxID() {
		if (txID == null) {
			txID = new JTextField();
			txID.setToolTipText("Numero de identificacion de la oferta, este numero es unico para cada oferta, se recomienda utlizar el peque\u00F1o boton para generar un ID");
			txID.addKeyListener(new KeyAdapter() {
				@Override
				public void keyReleased(KeyEvent e) {
					if(txID.getText().trim().length()==5){
						btnAgregar.setEnabled(true);
						if(table.getSelectedRow()!=-1)
						btnModificar.setEnabled(true);
					}else{
						btnAgregar.setEnabled(false);
						btnModificar.setEnabled(false);
					}
				}
				@Override
				public void keyTyped(KeyEvent e) {
					MetodosUtiles.validacionJTextNumero(txID.getText().length(), 5, e);
				}
			});
			txID.setBounds(114, 29, 160, 20);
			txID.setColumns(10);
		}
		return txID;
	}
	private JLabel getLblSalario() {
		if (lblSalario == null) {
			lblSalario = new JLabel("Salario");
			lblSalario.setHorizontalAlignment(SwingConstants.RIGHT);
			lblSalario.setFont(new Font("Tahoma", Font.PLAIN, 13));
			lblSalario.setBounds(58, 75, 46, 14);
		}
		return lblSalario;
	}
	private JSpinner getSpSalario() {
		if (spSalario == null) {
			spSalario = new JSpinner();
			spSalario.setModel(new SpinnerNumberModel(100, 100, 30000, 50));
			spSalario.setBounds(114, 72, 160, 20);
		}
		return spSalario;
	}
	private JLabel getLblCantidadDePlazas() {
		if (lblCantidadDePlazas == null) {
			lblCantidadDePlazas = new JLabel(" Plazas");
			lblCantidadDePlazas.setHorizontalAlignment(SwingConstants.RIGHT);
			lblCantidadDePlazas.setFont(new Font("Tahoma", Font.PLAIN, 13));
			lblCantidadDePlazas.setBounds(4, 119, 100, 14);
		}
		return lblCantidadDePlazas;
	}
	private JSpinner getSpCantidad() {
		if (spCantidad == null) {
			spCantidad = new JSpinner();
			spCantidad.setModel(new SpinnerNumberModel(1, 1, 100, 1));
			spCantidad.setBounds(114, 116, 160, 20);
		}
		return spCantidad;
	}
	private JButton getBtnEliminar() {
		if (btnEliminar == null) {
			btnEliminar = new JButton("Eliminar");
			btnEliminar.setFont(new Font("Tahoma", Font.PLAIN, 13));
			btnEliminar.setFocusable(false);
			btnEliminar.setEnabled(false);
			btnEliminar.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					int pos=table.getSelectedRow();
					empresa.getListaOfertas().remove(pos);
					tableModel.refresh(empresa.getListaOfertas());
					btnEliminar.setEnabled(false);
					btnModificar.setEnabled(false);
					tableModel2.setRowCount(0);
				}
			});
			btnEliminar.setBounds(612, 307, 89, 23);
		}
		return btnEliminar;
	}
	private JLabel getLblRama() {
		if (lblRama == null) {
			lblRama = new JLabel("Rama");
			lblRama.setHorizontalAlignment(SwingConstants.RIGHT);
			lblRama.setFont(new Font("Tahoma", Font.PLAIN, 13));
			lblRama.setBounds(58, 162, 46, 14);
		}
		return lblRama;
	}
	private JComboBox<String> getCoRama() {
		if (coRama == null) {
			coRama = new JComboBox<String>();
			coRama.setModel(new DefaultComboBoxModel<String>(crearComboBox()));
			coRama.setBounds(114, 159, 160, 20);
		}
		return coRama;
	}
	private JButton getButton() {
		if (button == null) {
			button = new JButton("");
			button.setBackground(SystemColor.textHighlight);
			button.setHorizontalTextPosition(SwingConstants.CENTER);
			button.setIcon(null);
			button.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					boolean encontrado;
					String id;
					do{
						encontrado=false;
						int value=(int)(Math.random()*10000+10000);
						id=""+value;
						for(Empresa x: AgenciaEmpleadora.getInstancia().getListaEmpresas())
							for(Oferta y: x.getListaOfertas())
								if(y.getNumeroId().equalsIgnoreCase(id))
									encontrado=true;
						
					}while(encontrado);
					txID.setText(id);
					btnAgregar.setEnabled(true);
					btnModificar.setEnabled(false);
					btnEliminar.setEnabled(false);
				}
			});
			button.setFont(new Font("Tahoma", Font.PLAIN, 1));
			button.setBounds(284, 29, 17, 17);
		}
		return button;
	}
	private JPanel getPanel_3() {
		if (panel_3 == null) {
			panel_3 = new JPanel();
			panel_3.setBackground(Color.LIGHT_GRAY);
			panel_3.setBorder(new TitledBorder(new LineBorder(new Color(0, 0, 0)), "Candidatos disponibles",
					TitledBorder.LEADING, TitledBorder.TOP, new Font("Tahoma", Font.PLAIN, 15), new Color(0, 0, 0)));
			panel_3.setBounds(731, 50, 299, 341);
			panel_3.setLayout(null);
			panel_3.add(getBtnProgramarEntrevista());
			panel_3.add(getPanel_4());
		}
		return panel_3;
	}
	private JButton getBtnProgramarEntrevista() {
		if (btnProgramarEntrevista == null) {
			btnProgramarEntrevista = new JButton("Programar Entrevista");
			btnProgramarEntrevista.setFont(new Font("Tahoma", Font.PLAIN, 13));
			btnProgramarEntrevista.setFocusable(false);
			btnProgramarEntrevista.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					Oferta oferta=empresa.getListaOfertas().get(table.getSelectedRow());
					Candidato candidato=lista.get(table_1.getSelectedRow());
					VisualEntrevista x=new VisualEntrevista(candidato, oferta,getThis());
					tableModel2.setRowCount(0);
					getThis().setVisible(false);
					x.setLocationRelativeTo(null);
					x.setModal(true);
					x.setVisible(true);
					
					
				}
			});
			btnProgramarEntrevista.setEnabled(false);
			btnProgramarEntrevista.setBounds(62, 307, 188, 23);
		}
		return btnProgramarEntrevista;
	}
	private JPanel getPanel_4() {
		if (panel_4 == null) {
			panel_4 = new JPanel();
			panel_4.setBounds(10, 21, 279, 271);
			panel_4.setLayout(new CardLayout(0, 0));
			panel_4.add(getScrollPane_1(), "name_564395980841573");
		}
		return panel_4;
	}
	private JScrollPane getScrollPane_1() {
		if (scrollPane_1 == null) {
			scrollPane_1 = new JScrollPane();
			scrollPane_1.setViewportView(getTable_1());
		}
		return scrollPane_1;
	}
	private JTable getTable_1() {
		if (table_1 == null) {
			table_1 = new JTable();
			table_1.addMouseListener(new MouseAdapter() {
				@Override
				public void mousePressed(MouseEvent e) {
					btnProgramarEntrevista.setEnabled(true);
				}
			});
			table_1.setModel(tableModel2);
		}
		return table_1;
	}
	private JPanel getPanel_5() {
		if (panel_5 == null) {
			panel_5 = new JPanel();
			panel_5.setLayout(null);
			panel_5.setBackground(new Color(219, 219, 219));
			panel_5.setBounds(0, 0, 1097, 33);
			panel_5.add(getLblOfertas());
			panel_5.add(getButton_1());
		}
		return panel_5;
	}
	private JLabel getLblOfertas() {
		if (lblOfertas == null) {
			lblOfertas = new JLabel("Ofertas");
			lblOfertas.setFont(new Font("Tahoma", Font.PLAIN, 22));
			lblOfertas.setBounds(520, 0, 171, 33);
		}
		return lblOfertas;
	}
	private JButton getButton_1() {
		if (button_1 == null) {
			button_1 = new JButton("X");
			button_1.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					dispose();
				}
			});
			button_1.setForeground(Color.WHITE);
			button_1.setFont(new Font("Tahoma", Font.PLAIN, 13));
			button_1.setFocusable(false);
			button_1.setBackground(Color.RED);
			button_1.setBounds(994, 0, 49, 33);
		}
		return button_1;
	}

	public JDialog getThis(){
		return this;
	}

	public void limpiar(){
		txID.setText("");
		spCantidad.setValue(1);
		spSalario.setValue(100);
	}

	public String[] obtenerEmpresas(){
		String[]salida= new String[AgenciaEmpleadora.getInstancia().getListaEmpresas().size()];
		int pos=0;
		for(Empresa x: AgenciaEmpleadora.getInstancia().getListaEmpresas())
			salida[pos++]=x.getNombre();
		return salida;
	}

	public String[] crearComboBox(){
		String[] salida=new String[AgenciaEmpleadora.getInstancia().getlistaRama().size()];
		int pos=0;
		for(Rama x: AgenciaEmpleadora.getInstancia().getlistaRama())
			salida[pos++]=x.getNombre();
		return salida;
	}

	public void rellenar(){
		Oferta oferta=empresa.getListaOfertas().get(table.getSelectedRow());
		txID.setText(oferta.getNumeroId());
		spCantidad.setValue(oferta.getCantCandidatos());
		spSalario.setValue((int)oferta.getSalario());
		coRama.setSelectedItem(oferta.getRama().getNombre());
		btnModificar.setEnabled(true);
		btnEliminar.setEnabled(true);
	}
}
