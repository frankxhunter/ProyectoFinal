package visual;

import java.awt.BorderLayout;
import java.awt.FlowLayout;

import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JTabbedPane;

import util.MetodosUtiles;
import util.PromedioSalarioTableModel;
import util.RamasMasSolicitadasTableModel;

import javax.swing.JScrollPane;

import java.awt.CardLayout;

import javax.swing.JTable;

import clase.AgenciaEmpleadora;
import javax.swing.JLabel;
import java.awt.Font;
import java.awt.GridBagLayout;
import java.awt.GridBagConstraints;
import java.awt.Insets;
import java.awt.Color;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class VisualReportes extends JDialog {
	private JTabbedPane tabbedPane;
	private JPanel panel;
	private JPanel panel_1;
	private JPanel panel_2;
	private PromedioSalarioTableModel tableModel=new PromedioSalarioTableModel();
	private RamasMasSolicitadasTableModel tableModel2=new RamasMasSolicitadasTableModel();
	private JPanel panel_3;
	private JScrollPane scrollPane;
	private JTable table;
	private JPanel panel_4;
	private JScrollPane scrollPane_1;
	private JTable table_1;
	private JPanel panel_5;
	private JLabel lblPromedioDeEdades;
	private JLabel lblNewLabel;
	private JLabel lblGupoPoblacional;
	private JPanel panel_6;
	private JLabel lblReportes;
	private JButton button;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		try {
			VisualReportes dialog = new VisualReportes();
			dialog.setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
			dialog.setVisible(true);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	/**
	 * Create the dialog.
	 */
	public VisualReportes() {
		getContentPane().setBackground(new Color(151, 119, 104));
		setBackground(Color.LIGHT_GRAY);
		setUndecorated(true);
		setBounds(100, 100, 517, 321);
		getContentPane().setLayout(null);
		getContentPane().add(getTabbedPane());
		getContentPane().add(getPanel_6());
	}
	private JTabbedPane getTabbedPane() {
		if (tabbedPane == null) {
			tabbedPane = new JTabbedPane(JTabbedPane.TOP);
			tabbedPane.setFont(new Font("Tahoma", Font.PLAIN, 13));
			tabbedPane.setBackground(Color.LIGHT_GRAY);
			tabbedPane.setBounds(10, 50, 495, 260);
			tabbedPane.addTab("Promedio de Salarios", null, getPanel(), null);
			tabbedPane.addTab("Ramas mas Solicitadas", null, getPanel_1(), null);
			tabbedPane.addTab("Promedio de Edad", null, getPanel_2(), null);
		}
		return tabbedPane;
	}
	private JPanel getPanel() {
		if (panel == null) {
			panel = new JPanel();
			panel.setBackground(Color.LIGHT_GRAY);
			panel.setLayout(null);
			panel.add(getPanel_3());
		}
		return panel;
	}
	private JPanel getPanel_1() {
		if (panel_1 == null) {
			panel_1 = new JPanel();
			panel_1.setBackground(Color.LIGHT_GRAY);
			panel_1.setLayout(null);
			panel_1.add(getPanel_4());
		}
		return panel_1;
	}
	private JPanel getPanel_2() {
		if (panel_2 == null) {
			panel_2 = new JPanel();
			panel_2.setBackground(Color.LIGHT_GRAY);
			panel_2.setLayout(null);
			panel_2.add(getPanel_5());
		}
		return panel_2;
	}
	private JPanel getPanel_3() {
		if (panel_3 == null) {
			panel_3 = new JPanel();
			panel_3.setBounds(10, 11, 470, 210);
			panel_3.setLayout(new CardLayout(0, 0));
			panel_3.add(getScrollPane_1(), "name_574426469018640");
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
			table.setModel(tableModel);
			tableModel.refresh(AgenciaEmpleadora.getInstancia().getListaEmpresas());
		}
		return table;
	}
	private JPanel getPanel_4() {
		if (panel_4 == null) {
			panel_4 = new JPanel();
			panel_4.setBounds(10, 11, 470, 210);
			panel_4.setLayout(new CardLayout(0, 0));
			panel_4.add(getScrollPane_1_1(), "name_612456947472980");
		}
		return panel_4;
	}
	private JScrollPane getScrollPane_1_1() {
		if (scrollPane_1 == null) {
			scrollPane_1 = new JScrollPane();
			scrollPane_1.setViewportView(getTable_1_1());
		}
		return scrollPane_1;
	}
	private JTable getTable_1_1() {
		if (table_1 == null) {
			table_1 = new JTable();
			table_1.setModel(tableModel2);
			tableModel2.refresh(AgenciaEmpleadora.getInstancia().getlistaRama());
		}
		return table_1;
	}
	private JPanel getPanel_5() {
		if (panel_5 == null) {
			panel_5 = new JPanel();
			panel_5.setBackground(Color.LIGHT_GRAY);
			panel_5.setBounds(10, 11, 470, 210);
			panel_5.setLayout(null);
			panel_5.add(getLblPromedioDeEdades());
			panel_5.add(getLblNewLabel());
			panel_5.add(getLblGupoPoblacional());
		}
		return panel_5;
	}
	private JLabel getLblPromedioDeEdades() {
		if (lblPromedioDeEdades == null) {
			lblPromedioDeEdades = new JLabel("Promedio de edad de los Candiddatos que se presentan en la Agencia");
			lblPromedioDeEdades.setFont(new Font("Tahoma", Font.PLAIN, 14));
			lblPromedioDeEdades.setBounds(0, 0, 460, 38);
		}
		return lblPromedioDeEdades;
	}
	private JLabel getLblNewLabel() {
		if (lblNewLabel == null) {
			String Mostrar="Promedio: "+ AgenciaEmpleadora.getInstancia().PromedioEdadCandidatos()+" años";
			lblNewLabel = new JLabel(Mostrar);
			lblNewLabel.setBounds(36, 63, 187, 66);
			lblNewLabel.setFont(new Font("Roboto", Font.BOLD, 18));
		}
		return lblNewLabel;
	}
	private JLabel getLblGupoPoblacional() {
		if (lblGupoPoblacional == null) {
			lblGupoPoblacional = new JLabel("Gupo poblacional: "+grupoPoblacional());
			lblGupoPoblacional.setFont(new Font("Roboto", Font.BOLD, 18));
			lblGupoPoblacional.setBounds(36, 140, 408, 66);
		}
		return lblGupoPoblacional;
	}
	public String grupoPoblacional(){
		int edad=AgenciaEmpleadora.getInstancia().PromedioEdadCandidatos();
		String salida="";
		if(edad<30)
			salida="Jovenes";
		else if(edad<60)
			salida="Adultos";
		else 
			salida="3ra Edad";
		return salida;
	}
	private JPanel getPanel_6() {
		if (panel_6 == null) {
			panel_6 = new JPanel();
			panel_6.setLayout(null);
			panel_6.setBackground(new Color(219, 219, 219));
			panel_6.setBounds(0, 0, 517, 33);
			panel_6.add(getLblReportes());
			panel_6.add(getButton());
		}
		return panel_6;
	}
	private JLabel getLblReportes() {
		if (lblReportes == null) {
			lblReportes = new JLabel("Reportes");
			lblReportes.setFont(new Font("Tahoma", Font.PLAIN, 22));
			lblReportes.setBounds(175, 0, 185, 33);
		}
		return lblReportes;
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
			button.setBounds(468, 0, 49, 33);
		}
		return button;
	}
}
