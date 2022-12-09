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

import javax.swing.DefaultComboBoxModel;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JDialog;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JSpinner;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.SpinnerNumberModel;
import javax.swing.SwingConstants;
import javax.swing.border.LineBorder;
import javax.swing.border.TitledBorder;

import util.DocumentosCandidatoTableModel;
import util.MetodosUtiles;
import clase.AgenciaEmpleadora;
import clase.Candidato;
import clase.Rama;
import excepcionesPropias.ElementosInsuficientesException;
import excepcionesPropias.YaExisteExceptions;

public class VisualModificaCandidato extends JDialog {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private DocumentosCandidatoTableModel tableModel=new DocumentosCandidatoTableModel();
	private Candidato candidato;
	private int position;
	private JPanel panel;
	private JPanel panel_1;
	private JLabel label;
	private JTextField txNombre;
	private JLabel label_1;
	private JTextField txCarnet;
	private JLabel label_2;
	private JComboBox  coSexo;
	private JLabel label_3;
	private JTextField txDireccion;
	private JTextField txTelefono;
	private JLabel label_4;
	private JComboBox  coRama;
	private JLabel label_5;
	private JSpinner spAnnos;
	private JTextField txEspecialidad;
	private JLabel label_6;
	private JLabel label_7;
	private JTextField txNivelEscolar;
	private JLabel label_8;
	private JButton btnAceptar;
	private JButton btnCancelar;
	private DefaultComboBoxModel  defaultComboBoxModel;
	private JPanel panel_2;
	private JPanel panel_3;
	private JScrollPane scrollPane;
	private JTable table;
	private JLabel lblDocumento;
	private JTextField txDocumento;
	private JButton btnAgregar;
	private JButton btnEliminar;
	private JPanel panel_4;
	private JLabel lblCandidato;
	private JButton button;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		try {
			VisualModificaCandidato dialog = new VisualModificaCandidato(-1);
			dialog.setVisible(true);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	/**
	 * Create the dialog.
	 */
	public VisualModificaCandidato(int pos) {
		getContentPane().setBackground(new Color(158, 130, 116));
		setUndecorated(true);
		setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
		setTitle("Agregar Candidatos");
		setBounds(100, 100, 678, 539);
		getContentPane().setLayout(null);
		getContentPane().add(getPanel());
		getContentPane().add(getPanel_4());
		setLocationRelativeTo(null);
		position=pos;
		if(pos!=-1){
			candidato=AgenciaEmpleadora.getInstancia().getListaCandidatos().get(pos);
			btnAceptar.setEnabled(true);
			establecer(candidato);
		}
		else
			candidato= new Candidato();

	}
	private JPanel getPanel() {
		if (panel == null) {
			panel = new JPanel();
			panel.setBackground(new Color(158, 130, 116));
			panel.setBounds(0, 34, 678, 505);
			panel.setLayout(null);
			panel.add(getPanel_1());
			panel.add(getPanel_2());
			panel.add(getBtnCancelar());
			panel.add(getBtnAceptar());
		}
		return panel;
	}
	private JPanel getPanel_1() {
		if (panel_1 == null) {
			panel_1 = new JPanel();
			panel_1.setBackground(Color.LIGHT_GRAY);
			panel_1.setBounds(10, 11, 295, 448);
			panel_1.setLayout(null);
			panel_1.setBorder(new TitledBorder(new LineBorder(new Color(0, 0, 0), 1), "Datos del Candidato", TitledBorder.LEFT, TitledBorder.TOP, 
					new Font("Tahoma", Font.PLAIN, 15), new Color(0, 0, 0)));
			panel_1.add(getLabel());
			panel_1.add(getTxNombre());
			panel_1.add(getLabel_1());
			panel_1.add(getTxCarnet());
			panel_1.add(getLabel_2());
			panel_1.add(getCoSexo());
			panel_1.add(getLabel_3());
			panel_1.add(getTxDireccion());
			panel_1.add(getTxTelefono());
			panel_1.add(getLabel_4());
			panel_1.add(getCoRama());
			panel_1.add(getLabel_5());
			panel_1.add(getSpAnnos());
			panel_1.add(getTxEspecialidad());
			panel_1.add(getLabel_6());
			panel_1.add(getLabel_7());
			panel_1.add(getTxNivelEscolar());
			panel_1.add(getLabel_8());

		}
		return panel_1;
	}
	private JLabel getLabel() {
		if (label == null) {
			label = new JLabel("Carnet");
			label.setHorizontalAlignment(SwingConstants.RIGHT);
			label.setForeground(Color.BLACK);
			label.setFont(new Font("Tahoma", Font.PLAIN, 13));
			label.setBounds(80, 76, 60, 14);
		}
		return label;
	}
	private JTextField getTxNombre() {
		if (txNombre == null) {
			txNombre = new JTextField();
			txNombre.addKeyListener(new KeyAdapter() {
				@Override
				public void keyTyped(KeyEvent e) {
					MetodosUtiles.validacionJTextLetra(txNombre.getText().length(), e);
					validar();
				}
			});
			txNombre.setColumns(10);
			txNombre.setBounds(150, 28, 135, 20);
		}
		return txNombre;
	}
	private JLabel getLabel_1() {
		if (label_1 == null) {
			label_1 = new JLabel("Nombre y Apelllidos");
			label_1.setHorizontalAlignment(SwingConstants.RIGHT);
			label_1.setForeground(Color.BLACK);
			label_1.setFont(new Font("Tahoma", Font.PLAIN, 13));
			label_1.setBounds(10, 28, 130, 14);
		}
		return label_1;
	}
	private JTextField getTxCarnet() {
		if (txCarnet == null) {
			txCarnet = new JTextField();
			txCarnet.addKeyListener(new KeyAdapter() {
				@Override
				public void keyTyped(KeyEvent e) {
					MetodosUtiles.validacionJTextNumero(txCarnet.getText().length(), 11, e);
					
				}
				public void keyReleased(KeyEvent e){
					validar();
				}
			});
			txCarnet.setColumns(10);
			txCarnet.setBounds(150, 76, 135, 20);
		}
		return txCarnet;
	}
	private JLabel getLabel_2() {
		if (label_2 == null) {
			label_2 = new JLabel("Sexo");
			label_2.setHorizontalAlignment(SwingConstants.RIGHT);
			label_2.setForeground(Color.BLACK);
			label_2.setFont(new Font("Tahoma", Font.PLAIN, 13));
			label_2.setBounds(90, 124, 50, 14);
		}
		return label_2;
	}
	private JComboBox  getCoSexo() {
		if (coSexo == null) {
			coSexo = new JComboBox();
			coSexo.setBounds(150, 124, 135, 20);
			Object[] sexos = new Object[2];
			sexos[0]="Masculino";
			sexos[1]="Femenino";
			this.defaultComboBoxModel=new DefaultComboBoxModel(sexos);
			this.coSexo.setModel(defaultComboBoxModel);
		}
		return coSexo;
	}
	private JLabel getLabel_3() {
		if (label_3 == null) {
			label_3 = new JLabel("Direccion");
			label_3.setHorizontalAlignment(SwingConstants.RIGHT);
			label_3.setForeground(Color.BLACK);
			label_3.setFont(new Font("Tahoma", Font.PLAIN, 13));
			label_3.setBounds(68, 172, 72, 14);
		}
		return label_3;
	}
	private JTextField getTxDireccion() {
		if (txDireccion == null) {
			txDireccion = new JTextField();
			txDireccion.addKeyListener(new KeyAdapter() {
				@Override
				public void keyTyped(KeyEvent e) {
					MetodosUtiles.validacionJTextCharacter(txDireccion.getText().length(), e);
					validar();
				}
			});
			txDireccion.setColumns(10);
			txDireccion.setBounds(150, 172, 135, 20);
		}
		return txDireccion;
	}
	private JTextField getTxTelefono() {
		if (txTelefono == null) {
			txTelefono = new JTextField();
			txTelefono.addKeyListener(new KeyAdapter() {
				@Override
				public void keyTyped(KeyEvent e) {
					MetodosUtiles.validacionJTextNumero(txTelefono.getText().length(), 8, e);
				}
				@Override
				public void keyReleased(KeyEvent e){
					validar();
				}
			});
			txTelefono.setColumns(10);
			txTelefono.setBounds(150, 268, 135, 20);
		}
		return txTelefono;
	}
	private JLabel getLabel_4() {
		if (label_4 == null) {
			label_4 = new JLabel("Rama de interes");
			label_4.setHorizontalAlignment(SwingConstants.RIGHT);
			label_4.setForeground(Color.BLACK);
			label_4.setFont(new Font("Tahoma", Font.PLAIN, 13));
			label_4.setBounds(10, 220, 130, 14);
		}
		return label_4;
	}
	private JComboBox  getCoRama() {
		if (coRama == null) {
			coRama = new JComboBox ();
			coRama.setModel(new DefaultComboBoxModel (crearComboBox()));
			coRama.setBounds(150, 220, 135, 20);
		}
		return coRama;
	}
	private JLabel getLabel_5() {
		if (label_5 == null) {
			label_5 = new JLabel("A\u00F1os de Experiencia");
			label_5.setHorizontalAlignment(SwingConstants.RIGHT);
			label_5.setForeground(Color.BLACK);
			label_5.setFont(new Font("Tahoma", Font.PLAIN, 13));
			label_5.setBounds(0, 412, 140, 14);
		}
		return label_5;
	}
	private JSpinner getSpAnnos() {
		if (spAnnos == null) {
			spAnnos = new JSpinner();
			spAnnos.setModel(new SpinnerNumberModel(0, 0, 60, 1));
			spAnnos.setBounds(150, 412, 135, 20);
		}
		return spAnnos;
	}
	private JTextField getTxEspecialidad() {
		if (txEspecialidad == null) {
			txEspecialidad = new JTextField();
			txEspecialidad.addKeyListener(new KeyAdapter() {
				@Override
				public void keyTyped(KeyEvent e) {
					MetodosUtiles.validacionJTextCharacter(txEspecialidad.getText().length(), e);
					validar();
				}
			});
			txEspecialidad.setColumns(10);
			txEspecialidad.setBounds(150, 364, 135, 20);
		}
		return txEspecialidad;
	}
	private JLabel getLabel_6() {
		if (label_6 == null) {
			label_6 = new JLabel("Especialidad");
			label_6.setHorizontalAlignment(SwingConstants.RIGHT);
			label_6.setForeground(Color.BLACK);
			label_6.setFont(new Font("Tahoma", Font.PLAIN, 13));
			label_6.setBounds(54, 364, 86, 14);
		}
		return label_6;
	}
	private JLabel getLabel_7() {
		if (label_7 == null) {
			label_7 = new JLabel("Nivel Escolar");
			label_7.setHorizontalAlignment(SwingConstants.RIGHT);
			label_7.setForeground(Color.BLACK);
			label_7.setFont(new Font("Tahoma", Font.PLAIN, 13));
			label_7.setBounds(54, 316, 86, 14);
		}
		return label_7;
	}
	private JTextField getTxNivelEscolar() {
		if (txNivelEscolar == null) {
			txNivelEscolar = new JTextField();
			txNivelEscolar.addKeyListener(new KeyAdapter() {
				@Override
				public void keyTyped(KeyEvent e) {
					MetodosUtiles.validacionJTextCharacter(txNivelEscolar.getText().length(), e);
					validar();
				}
			});
			txNivelEscolar.setColumns(10);
			txNivelEscolar.setBounds(150, 316, 135, 20);
		}
		return txNivelEscolar;
	}
	private JLabel getLabel_8() {
		if (label_8 == null) {
			label_8 = new JLabel("Telefono");
			label_8.setHorizontalAlignment(SwingConstants.RIGHT);
			label_8.setForeground(Color.BLACK);
			label_8.setFont(new Font("Tahoma", Font.PLAIN, 13));
			label_8.setBounds(78, 268, 60, 14);
		}
		return label_8;
	}
	private JButton getBtnAceptar() {
		if (btnAceptar == null) {
			btnAceptar = new JButton("Aceptar");
			btnAceptar.setFont(new Font("Tahoma", Font.PLAIN, 13));
			btnAceptar.setFocusable(false);
			btnAceptar.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					try{
					candidato.setCarnet(txCarnet.getText().trim());
					candidato.setNombre(txNombre.getText().trim());
					candidato.setDireccion(txDireccion.getText().trim());
					candidato.setTelefono(txTelefono.getText().trim());
					candidato.setNivelEscolaridad(txNivelEscolar.getText().trim());
					candidato.setEspecialidad(txEspecialidad.getText().trim());
					candidato.setSexo(coSexo.getSelectedItem().toString().trim());
					candidato.setRama(AgenciaEmpleadora.getInstancia().obtenerRama(coRama.getSelectedItem().toString()));
					candidato.setYearsExp(Integer.parseInt(spAnnos.getValue().toString()));
					if(position==-1)
						AgenciaEmpleadora.getInstancia().addCandidato(candidato);
					siguientePantalla();	
					}catch(YaExisteExceptions e2){
						MetodosUtiles.mostrarMensaje(e2);
					} catch (ElementosInsuficientesException e1) {
						MetodosUtiles.mostrarMensaje(e1);
					}
				}
			});
			btnAceptar.setBounds(479, 470, 89, 23);
			btnAceptar.setEnabled(false);
		}
		return btnAceptar;
	}
	private JButton getBtnCancelar() {
		if (btnCancelar == null) {
			btnCancelar = new JButton("Cancelar");
			btnCancelar.setFont(new Font("Tahoma", Font.PLAIN, 13));
			btnCancelar.setFocusable(false);
			btnCancelar.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					siguientePantalla();
					
				}
			});
			btnCancelar.setBounds(578, 470, 89, 23);
		}
		return btnCancelar;
	}

	private JPanel getPanel_2() {
		if (panel_2 == null) {
			panel_2 = new JPanel();
			panel_2.setBorder(new TitledBorder(new LineBorder(new Color(0, 0, 0)), "Documentos", TitledBorder.LEADING, TitledBorder.TOP, 
					new Font("Tahoma", Font.PLAIN, 15), new Color(0, 0, 0)));
			panel_2.setBackground(Color.LIGHT_GRAY);
			panel_2.setBounds(315, 11, 352, 448);
			panel_2.setLayout(null);
			panel_2.add(getPanel_3());
			panel_2.add(getLblDocumento());
			panel_2.add(getTxDocumento());
			panel_2.add(getBtnAgregar());
			panel_2.add(getBtnEliminar());
		}
		return panel_2;
	}
	private JPanel getPanel_3() {
		if (panel_3 == null) {
			panel_3 = new JPanel();
			panel_3.setBounds(10, 51, 325, 357);
			panel_3.setLayout(new CardLayout(0, 0));
			panel_3.add(getScrollPane_1(), "name_330922921481698");
		}
		return panel_3;
	}
	private JScrollPane getScrollPane_1() {
		if (scrollPane == null) {
			scrollPane = new JScrollPane();
			scrollPane.setViewportView(getTable_1());
		}
		return scrollPane;
	}
	private JTable getTable_1() {
		if (table == null) {
			table = new JTable();
			table.addMouseListener(new MouseAdapter() {
				@Override
				public void mousePressed(MouseEvent e) {
					btnEliminar.setEnabled(true);
				}
			});
			table.setBackground(Color.LIGHT_GRAY);
			table.setModel(tableModel);
			table.getTableHeader().setReorderingAllowed(false);
		}
		return table;
	}
	private JLabel getLblDocumento() {
		if (lblDocumento == null) {
			lblDocumento = new JLabel("Documento");
			lblDocumento.setFont(new Font("Tahoma", Font.PLAIN, 13));
			lblDocumento.setBounds(10, 21, 66, 14);
		}
		return lblDocumento;
	}
	private JTextField getTxDocumento() {
		if (txDocumento == null) {
			txDocumento = new JTextField();
			txDocumento.addKeyListener(new KeyAdapter() {
				@Override
				public void keyTyped(KeyEvent e) {
					MetodosUtiles.validacionJTextCharacter(txDocumento.getText().length(), e);
				}
			});
			txDocumento.setBounds(86, 18, 150, 20);
			txDocumento.setColumns(10);
		}
		return txDocumento;
	}
	private JButton getBtnAgregar() {
		if (btnAgregar == null) {
			btnAgregar = new JButton("Agregar");
			btnAgregar.setFont(new Font("Tahoma", Font.PLAIN, 13));
			btnAgregar.setFocusable(false);
			btnAgregar.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					if(txDocumento.getText().trim().length()>0){
						try{
						candidato.addDocumento(txDocumento.getText().trim());
						tableModel.refresh(candidato.getDocumentos());
						txDocumento.setText("");
						btnEliminar.setEnabled(false);
						}catch(YaExisteExceptions y){
						JOptionPane.showMessageDialog(null, y.getMessage());
						}
					}
					
				}
			});
			btnAgregar.setBounds(246, 17, 89, 23);
		}
		return btnAgregar;
	}
	private JButton getBtnEliminar() {
		if (btnEliminar == null) {
			btnEliminar = new JButton("Eliminar");
			btnEliminar.setFont(new Font("Tahoma", Font.PLAIN, 13));
			btnEliminar.setFocusable(false);
			btnEliminar.setEnabled(false);
			btnEliminar.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					candidato.getDocumentos().remove(table.getSelectedRow());
					tableModel.refresh(candidato.getDocumentos());
					btnEliminar.setEnabled(false);
				}
			});
			btnEliminar.setBounds(246, 414, 89, 23);
		}
		return btnEliminar;
	}
	//Funciones a utilzar
	public String[] crearComboBox(){
		String[] salida=new String[AgenciaEmpleadora.getInstancia().getlistaRama().size()];
		int pos=0;
		for(Rama x: AgenciaEmpleadora.getInstancia().getlistaRama())
			salida[pos++]=x.getNombre();
		return salida;
	}
	public void limpiar(){
		txCarnet.setText("");
		txNombre.setText("");
		txDireccion.setText("");
		txEspecialidad.setText("");
		txNivelEscolar.setText("");
		txTelefono.setText("");
		spAnnos.setValue(0);
	}
	public void validar(){
		boolean x=false;
		if(txNombre.getText().trim().length()>0)
			if(txCarnet.getText().trim().length()==11)
				if(txDireccion.getText().trim().length()>0)
					if(txTelefono.getText().trim().length()==8)
						if(txEspecialidad.getText().trim().length()>0)
							if(txNivelEscolar.getText().trim().length()>0)
								if(Integer.parseInt(spAnnos.getValue().toString())>=0){
									btnAceptar.setEnabled(true);
									x=true;
								}
		if(!x){
			btnAceptar.setEnabled(false);
		}
	}
	
	
	public void establecer(Candidato candidato){
		txNombre.setText(candidato.getNombre());
		txCarnet.setText(candidato.getCarnet());
		txDireccion.setText(candidato.getDireccion());
		txEspecialidad.setText(candidato.getEspecialidad());
		txNivelEscolar.setText(candidato.getNivelEscolaridad());
		txTelefono.setText(candidato.getTelefono());
		spAnnos.setValue(candidato.getYearsExp());
		coSexo.setSelectedItem(candidato.getSexo());
		coRama.setSelectedItem(candidato.getRama().getNombre());
		tableModel.refresh(candidato.getDocumentos());
	}
	public void siguientePantalla(){
		VisualCandidato x= new VisualCandidato();
		dispose();
		x.setVisible(true);
		x.setLocationRelativeTo(null);
		x.setModal(true);
	}
	private JPanel getPanel_4() {
		if (panel_4 == null) {
			panel_4 = new JPanel();
			panel_4.setLayout(null);
			panel_4.setBackground(new Color(219, 219, 219));
			panel_4.setBounds(0, 0, 678, 33);
			panel_4.add(getLblCandidato());
			panel_4.add(getButton());
		}
		return panel_4;
	}
	private JLabel getLblCandidato() {
		if (lblCandidato == null) {
			lblCandidato = new JLabel("Candidato");
			lblCandidato.setFont(new Font("Tahoma", Font.PLAIN, 22));
			lblCandidato.setBounds(256, 0, 171, 33);
		}
		return lblCandidato;
	}
	private JButton getButton() {
		if (button == null) {
			button = new JButton("X");
			button.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					siguientePantalla();
				}
			});
			button.setForeground(Color.WHITE);
			button.setFont(new Font("Tahoma", Font.PLAIN, 13));
			button.setFocusable(false);
			button.setBackground(Color.RED);
			button.setBounds(629, 0, 49, 33);
		}
		return button;
	}
}
