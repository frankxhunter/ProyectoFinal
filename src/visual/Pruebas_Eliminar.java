package visual;

import java.awt.Color;
import java.util.Date;

import javax.swing.JDialog;
import javax.swing.JPanel;
import javax.swing.border.TitledBorder;

import com.toedter.calendar.JCalendar;

public class Pruebas_Eliminar extends JDialog {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private JPanel panel;
	private JCalendar calendar;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		try {
			Pruebas_Eliminar dialog = new Pruebas_Eliminar();
			dialog.setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
			dialog.setVisible(true);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	/**
	 * Create the dialog.
	 */
	public Pruebas_Eliminar() {
		setFocusTraversalPolicyProvider(false);
		setFocusCycleRoot(false);
		setBackground(Color.WHITE);
		setBounds(100, 100, 646, 459);
		getContentPane().setLayout(null);
		getContentPane().add(getPanel());
	}
	private JPanel getPanel() {
		if (panel == null) {
			panel = new JPanel();
			panel.setBackground(Color.WHITE);
			panel.setBounds(0, 0, 630, 420);
			panel.setLayout(null);
			panel.add(getCalendar());
		}
		return panel;
	}
	private JCalendar getCalendar() {
		if (calendar == null) {
			calendar = new JCalendar();
			calendar.setWeekOfYearVisible(false);
			calendar.setForeground(Color.BLACK);
			calendar.setDecorationBackgroundColor(Color.LIGHT_GRAY);
			calendar.setBorder(new TitledBorder(null, "Seleccionar Fecha", TitledBorder.LEADING, TitledBorder.TOP, null, null));
			calendar.setBackground(Color.GRAY);
			calendar.setBounds(49, 11, 448, 403);
			calendar.getDayChooser().setMinSelectableDate(new Date());
		}
		return calendar;
	}
}
