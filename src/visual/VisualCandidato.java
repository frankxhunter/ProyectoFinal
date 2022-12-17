package visual;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.border.EmptyBorder;
import javax.swing.border.LineBorder;
import javax.swing.border.TitledBorder;

import util.MetodosUtiles;
import util.OfertaCandidatoTableModel;
import util.PersonaTableModel;
import clase.AgenciaEmpleadora;
import clase.Candidato;
import clase.Oferta;
import clase.Rama;

import javax.swing.JLabel;

public class VisualCandidato extends JDialog {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private final JPanel contentPanel = new JPanel();
	private JPanel panel_1;
	private JScrollPane scrollPane;
	private JButton btModificar;
	private JButton btEliminar;
	private PersonaTableModel tableModel=new PersonaTableModel() ;
	private OfertaCandidatoTableModel tableModel2=new OfertaCandidatoTableModel();
	private JPanel panel_2;
	private JTable table;
	private JButton btnAgregar;
	private JPanel panel;
	private JScrollPane scrollPane_1;
	private JButton btnProgramarEntrevista;
	private JTable table_1;
	private JPanel panel_3;
	private JLabel lblListaDeCandidatos;
	private JButton button;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		try {
			VisualCandidato dialog = new VisualCandidato();
			dialog.setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
			dialog.setVisible(true);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	/**
	 * Create the dialog.
	 */
	public VisualCandidato() {
		setUndecorated(true);
		setBounds(100, 100, 1051, 463);
		getContentPane().setLayout(new BorderLayout());
		contentPanel.setBackground(new Color(0, 0, 0));
		contentPanel.setForeground(new Color(0, 0, 0));
		contentPanel.setBorder(new EmptyBorder(5, 5, 5, 5));
		getContentPane().add(contentPanel, BorderLayout.CENTER);
		contentPanel.setLayout(null);
		contentPanel.add(getPanel_2());
		{
			JPanel buttonPane = new JPanel();
			buttonPane.setBackground(new Color(153, 255, 255));
			getContentPane().add(buttonPane, BorderLayout.SOUTH);
			buttonPane.setLayout(null);
		}
		tableModel.refresh(AgenciaEmpleadora.getInstancia().getListaCandidatos());
	}
	private JPanel getPanel_1() {
		if (panel_1 == null) {
			panel_1 = new JPanel();
			panel_1.setBounds(10, 58, 664, 393);
			panel_1.setBackground(Color.LIGHT_GRAY);
			panel_1.setLayout(null);
			panel_1.setBorder(new TitledBorder(new LineBorder(new Color(0, 0, 0)), "Listado de Candidatos", TitledBorder.LEFT, TitledBorder.TOP, new Font("Tahoma", Font.PLAIN, 15), new Color(0, 0, 0)));
			panel_1.add(getScrollPane());
			panel_1.add(getBtModificar());
			panel_1.add(getBtEliminar());
			panel_1.add(getBtnAgregar());
		}
		return panel_1;
	}
	private JScrollPane getScrollPane() {
		if (scrollPane == null) {
			scrollPane = new JScrollPane();
			scrollPane.setBounds(10, 23, 644, 315);
			scrollPane.setViewportView(getTable());
			scrollPane.setViewportView(getTable());
		}
		return scrollPane;
	}
	private JButton getBtModificar() {
		if (btModificar == null) {
			btModificar = new JButton("Modificar");
			btModificar.setFont(new Font("Tahoma", Font.PLAIN, 13));
			btModificar.setEnabled(false);
			btModificar.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent arg0) {
					VisualModificaCandidato x=new VisualModificaCandidato(table.getSelectedRow());
					dispose();
					x.setVisible(true);
					x.setModal(true);
					x.setLocationRelativeTo(null);
				}
			});
			btModificar.setBounds(446, 349, 99, 23);
		}
		return btModificar;
	}
	private JButton getBtEliminar() {
		if (btEliminar == null) {
			btEliminar = new JButton("Eliminar");
			btEliminar.setEnabled(false);
			btEliminar.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent arg0) {
					int pos=table.getSelectedRow();
					tableModel.removeRow(pos);
					AgenciaEmpleadora.getInstancia().getListaCandidatos().remove(pos);
					btEliminar.setEnabled(false);
					btModificar.setEnabled(false);
					tableModel2.setRowCount(0);
					btnProgramarEntrevista.setEnabled(false);
				}
			});
			btEliminar.setFont(new Font("Tahoma", Font.PLAIN, 13));
			btEliminar.setBounds(555, 349, 99, 23);
		}
		return btEliminar;
	}
	private JPanel getPanel_2() {
		if (panel_2 == null) {
			panel_2 = new JPanel();
			panel_2.setBounds(0, 0, 1051, 462);
			panel_2.setBackground(new Color(158, 130, 116));
			panel_2.setLayout(null);
			panel_2.add(getPanel_1());
			panel_2.add(getPanel());
			panel_2.add(getPanel_3());
		}
		return panel_2;
	}
	private JTable getTable() {
		if (table == null) {
			table = new JTable();
			table.addMouseListener(new MouseAdapter() {
				@Override
				public void mousePressed(MouseEvent arg0) {
					btEliminar.setEnabled(true);
					btModificar.setEnabled(true);
					tableModel2.refresh(AgenciaEmpleadora.getInstancia().getListaCandidatos().get
							(table.getSelectedRow()).DevolverListaDeOfertasDisponibles(AgenciaEmpleadora.getInstancia
									().getListaEmpresas()));
					btnProgramarEntrevista.setEnabled(false);
				}
			});
			tableModel=new PersonaTableModel();
			table.getTableHeader().setReorderingAllowed(false);
			table.setModel(tableModel);
		}
		return table;
	}
	public String[] crearComboBox(){
		String[] salida=new String[AgenciaEmpleadora.getInstancia().getlistaRama().size()];
		int pos=0;
		for(Rama x: AgenciaEmpleadora.getInstancia().getlistaRama())
			salida[pos++]=x.getNombre();
		return salida;
	}
	private JButton getBtnAgregar() {
		if (btnAgregar == null) {
			btnAgregar = new JButton("Agregar");
			btnAgregar.setFont(new Font("Tahoma", Font.PLAIN, 13));
			btnAgregar.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					VisualModificaCandidato x=new VisualModificaCandidato(-1);
					dispose();
					x.setModal(true);
					x.setLocationRelativeTo(null);
					x.setVisible(true);
				}
			});
			btnAgregar.setBounds(337, 349, 99, 23);
		}
		return btnAgregar;
	}
	public PersonaTableModel getTableModel(){
		return tableModel;
	}
	private JPanel getPanel() {
		if (panel == null) {
			panel = new JPanel();
			panel.setBorder(new TitledBorder(new LineBorder(new Color(0, 0, 0)), "Ofertas Disponibles", TitledBorder.LEADING, TitledBorder.TOP, new Font("Tahoma", Font.PLAIN, 15), new Color(0, 0, 0)));
			panel.setBackground(Color.LIGHT_GRAY);
			panel.setBounds(684, 58, 357, 393);
			panel.setLayout(null);
			panel.add(getScrollPane_1());
			panel.add(getBtnProgramarEntrevista());
		}
		return panel;
	}
	private JScrollPane getScrollPane_1() {
		if (scrollPane_1 == null) {
			scrollPane_1 = new JScrollPane();
			scrollPane_1.setBounds(10, 24, 337, 309);
			scrollPane_1.setViewportView(getTable_1());
		}
		return scrollPane_1;
	}
	private JButton getBtnProgramarEntrevista() {
		if (btnProgramarEntrevista == null) {
			btnProgramarEntrevista = new JButton("Programar Entrevista");
			btnProgramarEntrevista.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					Candidato candidato=AgenciaEmpleadora.getInstancia().getListaCandidatos().get(table.getSelectedRow());
					Oferta oferta=candidato.DevolverListaDeOfertasDisponibles(AgenciaEmpleadora.getInstancia().
							getListaEmpresas()).get(table_1.getSelectedRow());
					if(MetodosUtiles.mostrarMesajeDeSector(candidato, oferta.getEmpresaPerteneciente().getSector())){
						VisualEntrevista x=new VisualEntrevista(candidato,oferta,getThis());
						tableModel2.setRowCount(0);
						getThis().setVisible(false);
						x.setLocationRelativeTo(null);
						x.setModal(true);
						x.setVisible(true);
					}
				}
			});
			btnProgramarEntrevista.setEnabled(false);
			btnProgramarEntrevista.setFont(new Font("Tahoma", Font.PLAIN, 13));
			btnProgramarEntrevista.setBounds(71, 344, 216, 23);
		}
		return btnProgramarEntrevista;
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
			table.getTableHeader().setReorderingAllowed(false);
		}
		return table_1;
	}
	public JDialog getThis(){
		return this;
	}
	private JPanel getPanel_3() {
		if (panel_3 == null) {
			panel_3 = new JPanel();
			panel_3.setLayout(null);
			panel_3.setBackground(new Color(219, 219, 219));
			panel_3.setBounds(0, 0, 1051, 33);
			panel_3.add(getLblListaDeCandidatos());
			panel_3.add(getButton());
		}
		return panel_3;
	}
	private JLabel getLblListaDeCandidatos() {
		if (lblListaDeCandidatos == null) {
			lblListaDeCandidatos = new JLabel("Lista de Candidatos");
			lblListaDeCandidatos.setFont(new Font("Tahoma", Font.PLAIN, 22));
			lblListaDeCandidatos.setBounds(440, 0, 316, 33);
		}
		return lblListaDeCandidatos;
	}
	private JButton getButton() {
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
			button.setBounds(1002, 0, 49, 33);
		}
		return button;
	}
}

