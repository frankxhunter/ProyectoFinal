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
	private JTextField textField;
	private JTextField textField_1;

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
		setBounds(100, 100, 612, 416);
		getContentPane().setLayout(null);
		getContentPane().add(getPanel());
	}
	private JPanel getPanel() {
		if (panel == null) {
			panel = new JPanel();
			panel.setBounds(0, 0, 596, 377);
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
			panel_1.setBorder(new TitledBorder(new LineBorder(new Color(0, 0, 0)), "Registro de entrevistas", TitledBorder.LEADING, TitledBorder.TOP, null, new Color(0, 0, 0)));
			panel_1.setBounds(10, 105, 324, 261);
			panel_1.setLayout(new CardLayout(0, 0));
			panel_1.add(getScrollPane(), "name_48977222191014");
		}
		return panel_1;
	}
	private JPanel getPanel_2() {
		if (panel_2 == null) {
			panel_2 = new JPanel();
			panel_2.setBorder(new TitledBorder(new LineBorder(new Color(0, 0, 0)), "Candidatos Citados ", TitledBorder.LEADING, TitledBorder.TOP, null, new Color(0, 0, 0)));
			panel_2.setBounds(341, 105, 245, 261);
			panel_2.setLayout(new CardLayout(0, 0));
			panel_2.add(getScrollPane_1(), "name_48985439277083");
		}
		return panel_2;
	}
	private JPanel getPanel_3() {
		if (panel_3 == null) {
			panel_3 = new JPanel();
			panel_3.setBorder(new TitledBorder(new LineBorder(new Color(0, 0, 0)), "Selecciona la fecha ", TitledBorder.LEADING, TitledBorder.TOP, null, new Color(0, 0, 0)));
			panel_3.setBounds(10, 11, 576, 83);
			panel_3.setLayout(null);
			panel_3.add(getLblSeleccionaElAo());
			panel_3.add(getLblSeleccionaElMes());
			panel_3.add(getYearChooser());
			panel_3.add(getMonthChooser());
			panel_3.add(getBtnActualizar());
			panel_3.add(getTextField());
			panel_3.add(getTextField_1());
		}
		return panel_3;
	}
	private JLabel getLblSeleccionaElAo() {
		if (lblSeleccionaElAo == null) {
			lblSeleccionaElAo = new JLabel("Selecciona el a\u00F1o");
			lblSeleccionaElAo.setBounds(10, 22, 100, 14);
		}
		return lblSeleccionaElAo;
	}
	private JLabel getLblSeleccionaElMes() {
		if (lblSeleccionaElMes == null) {
			lblSeleccionaElMes = new JLabel("Selecciona el mes");
			lblSeleccionaElMes.setBounds(10, 58, 100, 14);
		}
		return lblSeleccionaElMes;
	}
	private JYearChooser getYearChooser() {
		if (yearChooser == null) {
			yearChooser = new JYearChooser();
			yearChooser.setBounds(125, 22, 47, 20);
		}
		return yearChooser;
	}
	private JMonthChooser getMonthChooser() {
		if (monthChooser == null) {
			monthChooser = new JMonthChooser();
			monthChooser.setBounds(120, 52, 108, 20);
		}
		return monthChooser;
	}
	private JButton getBtnActualizar() {
		if (btnActualizar == null) {
			btnActualizar = new JButton("Actualizar");
			btnActualizar.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
//					listaEntrevistas=AgenciaEmpleadora.getInstancia().obtenerEntrevista(yearChooser.getYear(),Integer.parseInt( textField.getText()));
					listaEntrevistas=AgenciaEmpleadora.getInstancia().obtenerEntrevista(0,0);
					
//					Collections.sort(listaEntrevistas);
					tableModel.refresh(listaEntrevistas);
					tableModel2.setRowCount(0);
				}
			});
			btnActualizar.setBounds(250, 52, 100, 23);
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
	private JTextField getTextField() {
		if (textField == null) {
			textField = new JTextField();
			textField.setBounds(410, 19, 86, 20);
			textField.setColumns(10);
		}
		return textField;
	}
	private JTextField getTextField_1() {
		if (textField_1 == null) {
			textField_1 = new JTextField();
			textField_1.setBounds(410, 50, 86, 20);
			textField_1.setColumns(10);
		}
		return textField_1;
	}
}
