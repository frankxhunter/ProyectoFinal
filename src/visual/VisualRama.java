package visual;

import java.awt.BorderLayout;
import java.awt.CardLayout;
import java.awt.Color;
import java.awt.FlowLayout;
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

import util.EspecialidadTableModel;
import clase.AgenciaEmpleadora;
import clase.Rama;
import javax.swing.JLabel;
import java.awt.Font;

public class VisualRama extends JDialog {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private final JPanel contentPanel = new JPanel();
	private EspecialidadTableModel tableModel;
	private JPanel panel;
	private JPanel panel_2;
	private JScrollPane scrollPane;
	private JTable table;
	private JButton btnNewButton;
	private JButton btnEliminar;
	private JButton btnModificar;
	private JPanel panel_1;
	private JLabel lblListaDeRamas;
	private JButton button;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		try {
			VisualRama dialog = new VisualRama();
			dialog.setVisible(true);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	/**
	 * Create the dialog.
	 */
	public VisualRama() {
		setUndecorated(true);
		setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
		setBounds(100, 100, 406, 514);
		getContentPane().setLayout(new BorderLayout());
		contentPanel.setBackground(new Color(158, 130, 116));
		contentPanel.setBorder(new EmptyBorder(5, 5, 5, 5));
		getContentPane().add(contentPanel, BorderLayout.CENTER);
		contentPanel.setLayout(null);
		contentPanel.add(getPanel());
		contentPanel.add(getPanel_1());
		{
			JPanel buttonPane = new JPanel();
			buttonPane.setLayout(new FlowLayout(FlowLayout.RIGHT));
			getContentPane().add(buttonPane, BorderLayout.SOUTH);
		}
		tableModel.refresh2(AgenciaEmpleadora.getInstancia().getlistaRama());
	} 
	private JPanel getPanel() {
		if (panel == null) {
			panel = new JPanel();
			panel.setBackground(Color.LIGHT_GRAY);
			panel.setBounds(10, 50, 383, 443);
			panel.setLayout(null);
			panel.add(getPanel_2());
			panel.add(getBtnNewButton());
			panel.add(getBtnEliminar());
			panel.add(getBtnModificar());
		}
		return panel;
	}
	private JPanel getPanel_2() {
		if (panel_2 == null) {
			panel_2 = new JPanel();
			panel_2.setBorder(new TitledBorder(new LineBorder(new Color(0, 0, 0)), "Lista de Ramas", TitledBorder.LEADING, TitledBorder.TOP,
					new Font("Tahoma", Font.PLAIN, 15), new Color(0, 0, 0)));
			panel_2.setBounds(10, 11, 363, 386);
			panel_2.setLayout(new CardLayout(0, 0));
			panel_2.add(getScrollPane(), "name_263002655977125");
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
					btnModificar.setEnabled(true);
				}
			});
			tableModel= new EspecialidadTableModel();
			table.setModel(tableModel);
			table.getTableHeader().setReorderingAllowed(false);
		}
		return table;
	}
	private JButton getBtnNewButton() {
		if (btnNewButton == null) {
			btnNewButton = new JButton("Agregar");
			btnNewButton.setFont(new Font("Tahoma", Font.PLAIN, 13));
			btnNewButton.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent arg0) {
				ModificarRama creacionRama=new ModificarRama(-1);
				dispose();
				creacionRama.setVisible(true);
				creacionRama.setModal(true);
				creacionRama.setLocationRelativeTo(null);
			
				}
			});
			btnNewButton.setBounds(20, 408, 89, 23);
		}
		return btnNewButton;
	}
	private JButton getBtnEliminar() {
		if (btnEliminar == null) {
			btnEliminar = new JButton("Eliminar");
			btnEliminar.setFont(new Font("Tahoma", Font.PLAIN, 13));
			btnEliminar.setEnabled(false);
			btnEliminar.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent arg0) {
					int pos=table.getSelectedRow();
					Rama rama=AgenciaEmpleadora.getInstancia().getlistaRama().get(pos);
					AgenciaEmpleadora.getInstancia().getListaEspecialidades().remove(rama);
					tableModel.refresh2(AgenciaEmpleadora.getInstancia().getlistaRama());
					btnEliminar.setEnabled(false);
					btnModificar.setEnabled(false);
				}
			});
			btnEliminar.setBounds(152, 408, 89, 23);
		}
		return btnEliminar;
	}
	private JButton getBtnModificar() {
		if (btnModificar == null) {
			btnModificar = new JButton("Modificar");
			btnModificar.setFont(new Font("Tahoma", Font.PLAIN, 13));
			btnModificar.setEnabled(false);
			btnModificar.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent arg0) {
					int pos=table.getSelectedRow();
					ModificarRama x= new ModificarRama(pos);
					dispose();
					x.setVisible(true);
					x.setModal(true);
					x.setLocationRelativeTo(null);
				}
			});
			btnModificar.setBounds(284, 408, 89, 23);
		}
		return btnModificar;
	}
	private JPanel getPanel_1() {
		if (panel_1 == null) {
			panel_1 = new JPanel();
			panel_1.setLayout(null);
			panel_1.setBackground(new Color(219, 219, 219));
			panel_1.setBounds(0, 0, 406, 33);
			panel_1.add(getLblListaDeRamas());
			panel_1.add(getButton());
		}
		return panel_1;
	}
	private JLabel getLblListaDeRamas() {
		if (lblListaDeRamas == null) {
			lblListaDeRamas = new JLabel("Lista de Ramas");
			lblListaDeRamas.setFont(new Font("Tahoma", Font.PLAIN, 22));
			lblListaDeRamas.setBounds(114, 0, 171, 33);
		}
		return lblListaDeRamas;
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
			button.setBounds(357, 0, 49, 33);
		}
		return button;
	}
}
