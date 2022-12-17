package visual;

import java.awt.CardLayout;
import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.ArrayList;
import java.util.Collections;

import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.border.LineBorder;
import javax.swing.border.TitledBorder;

import util.CandidatoEntrevistaTableModel;
import util.RegistroEntrevistasTableModel;
import clase.AgenciaEmpleadora;
import clase.Entrevista;

import com.toedter.calendar.JMonthChooser;
import com.toedter.calendar.JYearChooser;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.beans.PropertyChangeListener;
import java.beans.PropertyChangeEvent;
import java.awt.Font;
import javax.swing.SwingConstants;

public class VisualCalendario extends JDialog {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private RegistroEntrevistasTableModel tableModel=new RegistroEntrevistasTableModel();
	private CandidatoEntrevistaTableModel tableModel2= new CandidatoEntrevistaTableModel();
	private ArrayList<Entrevista> listaEntrevistas;
	private JPanel panel;
	private JPanel panel_1;
	private JPanel panel_2;
	private JPanel panel_3;
	private JLabel lblSeleccionaElAo;
	private JLabel lblSeleccionaElMes;
	private JYearChooser yearChooser;
	private JMonthChooser monthChooser;
	private JButton btnActualizar;
	private JScrollPane scrollPane;
	private JScrollPane scrollPane_1;
	private JTable table;
	private JTable table2;
	private JPanel panel_4;
	private JLabel lblTexto;
	private JButton button;
	private JPanel panel_5;
	private JButton btnEliminar;
	private JPanel panel_6;
	private JButton btnEliminar2;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		try {
			VisualCalendario dialog = new VisualCalendario();
			dialog.setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
			dialog.setVisible(true);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	/**
	 * Create the dialog.
	 */
	public VisualCalendario() {
		setUndecorated(true);
		setBounds(100, 100, 715, 437);
		getContentPane().setLayout(null);
		getContentPane().add(getPanel());
		getContentPane().add(getPanel_4());
	}
	private JPanel getPanel() {
		if (panel == null) {
			panel = new JPanel();
			panel.setBounds(0, 33, 715, 404);
			panel.setBackground(new Color(158, 130, 116));
			panel.setLayout(null);
			panel.add(getPanel_1());
			panel.add(getPanel_2());
			panel.add(getPanel_3());
		}
		return panel;
	}
	private JPanel getPanel_1() {
		if (panel_1 == null) {
			panel_1 = new JPanel();
			panel_1.setBackground(Color.LIGHT_GRAY);
			panel_1.setBorder(new TitledBorder(new LineBorder(new Color(0, 0, 0)), "Registro de entrevistas", TitledBorder.LEADING, TitledBorder.TOP, null, new Color(0, 0, 0)));
			panel_1.setBounds(10, 83, 361, 310);
			panel_1.setLayout(null);
			panel_1.add(getPanel_5());
			panel_1.add(getBtnEliminar());
		}
		return panel_1;
	}
	private JPanel getPanel_2() {
		if (panel_2 == null) {
			panel_2 = new JPanel();
			panel_2.setBackground(Color.LIGHT_GRAY);
			panel_2.setBorder(new TitledBorder(new LineBorder(new Color(0, 0, 0)), "Candidatos Citados ", TitledBorder.LEADING, TitledBorder.TOP, null, new Color(0, 0, 0)));
			panel_2.setBounds(381, 83, 324, 310);
			panel_2.setLayout(null);
			panel_2.add(getPanel_6());
			panel_2.add(getBtnEliminar2());
		}
		return panel_2;
	}
	private JPanel getPanel_3() {
		if (panel_3 == null) {
			panel_3 = new JPanel();
			panel_3.setBackground(Color.LIGHT_GRAY);
			panel_3.setBorder(new TitledBorder(new LineBorder(new Color(0, 0, 0)), "Seleccione la fecha ", TitledBorder.LEADING, TitledBorder.TOP,new Font("Tahoma", Font.PLAIN, 15), new Color(0, 0, 0)));
			panel_3.setBounds(10, 11, 695, 61);
			panel_3.setLayout(null);
			panel_3.add(getLblSeleccionaElAo());
			panel_3.add(getLblSeleccionaElMes());
			panel_3.add(getYearChooser());
			panel_3.add(getMonthChooser());
			panel_3.add(getBtnActualizar());
		}
		return panel_3;
	}
	private JLabel getLblSeleccionaElAo() {
		if (lblSeleccionaElAo == null) {
			lblSeleccionaElAo = new JLabel("Seleccione el a\u00F1o");
			lblSeleccionaElAo.setHorizontalAlignment(SwingConstants.RIGHT);
			lblSeleccionaElAo.setFont(new Font("Tahoma", Font.PLAIN, 15));
			lblSeleccionaElAo.setBounds(0, 24, 132, 14);
		}
		return lblSeleccionaElAo;
	}
	private JLabel getLblSeleccionaElMes() {
		if (lblSeleccionaElMes == null) {
			lblSeleccionaElMes = new JLabel("Seleccione el mes");
			lblSeleccionaElMes.setHorizontalAlignment(SwingConstants.RIGHT);
			lblSeleccionaElMes.setFont(new Font("Tahoma", Font.PLAIN, 15));
			lblSeleccionaElMes.setBounds(207, 24, 143, 14);
		}
		return lblSeleccionaElMes;
	}
	private JYearChooser getYearChooser() {
		if (yearChooser == null) {
			yearChooser = new JYearChooser();
			yearChooser.getSpinner().setLocation(0, 20);
			yearChooser.setBounds(138, 23, 50, 20);
		}
		return yearChooser;
	}
	private JMonthChooser getMonthChooser() {
		if (monthChooser == null) {
			monthChooser = new JMonthChooser();
			monthChooser.getComboBox().setLocation(3, 23);
			monthChooser.setBounds(360, 23, 108, 20);
		}
		return monthChooser;
	}
	private JButton getBtnActualizar() {
		if (btnActualizar == null) {
			btnActualizar = new JButton("Mostrar");
			btnActualizar.setFont(new Font("Tahoma", Font.PLAIN, 13));
			btnActualizar.setFocusable(false);
			btnActualizar.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					actualizar();
				}
			});
			btnActualizar.setBounds(520, 22, 100, 23);
		}
		return btnActualizar;
	}
	private JScrollPane getScrollPane() {
		if (scrollPane == null) {
			scrollPane = new JScrollPane();
			scrollPane.setViewportView(getTable());
		}
		return scrollPane;
	}
	private JScrollPane getScrollPane_1() {
		if (scrollPane_1 == null) {
			scrollPane_1 = new JScrollPane();
			scrollPane_1.setViewportView(getTable2());
		}
		return scrollPane_1;
	}
	private JTable getTable() {
		if (table == null) {
			table = new JTable();
			table.addMouseListener(new MouseAdapter() {
				@Override
				public void mousePressed(MouseEvent e) {
					tableModel2.refresh(listaEntrevistas.get(table.getSelectedRow()).getListaCandidatos());
					btnEliminar.setEnabled(true);
				}
			});
			table.setModel(tableModel);
		}
		return table;
	}
	private JTable getTable2() {
		if (table2 == null) {
			table2 = new JTable();
			table2.setModel(tableModel2);
		}
		return table2;
	}
	public void actualizar(){
		listaEntrevistas=AgenciaEmpleadora.getInstancia().obtenerEntrevista(yearChooser.getYear(),monthChooser.getMonth());
		Collections.sort(listaEntrevistas);
		tableModel.refresh(listaEntrevistas);
		tableModel2.setRowCount(0);
	}
	private JPanel getPanel_4() {
		if (panel_4 == null) {
			panel_4 = new JPanel();
			panel_4.setBounds(0, 0, 715, 33);
			panel_4.setLayout(null);
			panel_4.add(getLblTexto());
			panel_4.setBackground(new Color(219, 219, 219));
			panel_4.add(getButton());
		}
		return panel_4;
	}
	private JLabel getLblTexto() {
		if (lblTexto == null) {
			lblTexto = new JLabel("Calendario");
			lblTexto.setFont(new Font("Tahoma", Font.PLAIN, 22));
			lblTexto.setBounds(302, 0, 111, 33);
		}
		return lblTexto;
	}
	private JButton getButton() {
		if (button == null) {
			button = new JButton("X");
			button.setFocusable(false);
			button.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					dispose();
				}
			});
			button.setForeground(Color.WHITE);
			button.setFont(new Font("Tahoma", Font.PLAIN, 13));
			button.setBackground(Color.RED);
			button.setBounds(666, 0, 49, 33);
		}
		return button;
	}
	private JPanel getPanel_5() {
		if (panel_5 == null) {
			panel_5 = new JPanel();
			panel_5.setBounds(10, 21, 341, 245);
			panel_5.setLayout(new CardLayout(0, 0));
			panel_5.add(getScrollPane(), "name_313419936292098");
		}
		return panel_5;
	}
	private JButton getBtnEliminar() {
		if (btnEliminar == null) {
			btnEliminar = new JButton("Eliminar");
			btnEliminar.setEnabled(false);
			btnEliminar.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					eliminarEntrevista();
				}
			});
			btnEliminar.setFont(new Font("Tahoma", Font.PLAIN, 13));
			btnEliminar.setFocusable(false);
			btnEliminar.setBounds(251, 276, 100, 23);
		}
		return btnEliminar;
	}
	private JPanel getPanel_6() {
		if (panel_6 == null) {
			panel_6 = new JPanel();
			panel_6.setBounds(10, 22, 304, 245);
			panel_6.setLayout(new CardLayout(0, 0));
			panel_6.add(getScrollPane_1(), "name_313555207043068");
		}
		return panel_6;
	}
	private JButton getBtnEliminar2() {
		if (btnEliminar2 == null) {
			btnEliminar2 = new JButton("Eliminar");
			btnEliminar2.setEnabled(false);
			btnEliminar2.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					int posEntrevista=table.getSelectedRow();
					int posCandidato=table2.getSelectedRow();
					listaEntrevistas.get(posEntrevista).getOferta().getListaCandidatos().remove(listaEntrevistas.get(posEntrevista).getListaCandidatos().get(posCandidato));
					listaEntrevistas.get(posEntrevista).getListaCandidatos().remove(posCandidato);
					if(listaEntrevistas.get(posEntrevista).getListaCandidatos().size()==0){
						eliminarEntrevista();
					}
					tableModel2.refresh(listaEntrevistas.get(table.getSelectedRow()).getListaCandidatos());
					btnEliminar2.setEnabled(true);
				}
			});
			btnEliminar2.setFont(new Font("Tahoma", Font.PLAIN, 13));
			btnEliminar2.setFocusable(false);
			btnEliminar2.setBounds(214, 278, 100, 23);
		}
		return btnEliminar2;
	}
	public void eliminarEntrevista(){
		listaEntrevistas.get(table.getSelectedRow()).getOferta().getEmpresaPerteneciente().getListaEntrevistas()
		.remove(listaEntrevistas.get(table.getSelectedRow()));
		actualizar();
		btnEliminar.setEnabled(false);
	}
}
