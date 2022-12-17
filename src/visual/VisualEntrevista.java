package visual;

import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.text.SimpleDateFormat;
import java.util.Date;

import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.border.LineBorder;
import javax.swing.border.TitledBorder;

import clase.AgenciaEmpleadora;
import clase.Candidato;
import clase.Entrevista;
import clase.Oferta;

import com.toedter.calendar.JCalendar;

public class VisualEntrevista extends JDialog {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private JPanel panel; 
	private Candidato candidato;
	private Oferta oferta;
	private JDialog pantalla;
	private JCalendar calendar;
	private JButton btnAgregar;
	private JButton btnCancelar;
	private JPanel panel_1;
	private JLabel lblEntrevista;
	private JButton button;
	private JLabel lblCandidato;
	private JLabel lblEmpresa;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		try {
			VisualEntrevista dialog = new VisualEntrevista(null, null,null);
			dialog.setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
			dialog.setVisible(true);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	/**
	 * Create the dialog.
	 * @param jDialog 
	 */
	public VisualEntrevista(Candidato candidato, Oferta oferta, JDialog jDialog) {
		getContentPane().setBackground(new Color(158, 130, 116));
		setUndecorated(true);
		this.candidato=candidato;
		this.oferta=oferta;
		pantalla=jDialog;
		setBounds(100, 100, 484, 369);
		getContentPane().setLayout(null);
		getContentPane().add(getPanel());
		getContentPane().add(getPanel_1());
	}
	private JPanel getPanel() {
		if (panel == null) {
			panel = new JPanel();
			panel.setBorder(new TitledBorder(new LineBorder(new Color(0, 0, 0)), "Fecha de la Entrevista", 
					TitledBorder.LEADING, TitledBorder.TOP, new Font("Tahoma", Font.PLAIN, 15), new Color(0, 0, 0)));
			panel.setBackground(Color.LIGHT_GRAY);
			panel.setBounds(10, 44, 462, 313);
			panel.setLayout(null);
			panel.add(getCalendar());
			panel.add(getBtnAgregar());
			panel.add(getBtnCancelar());
			panel.add(getLblCandidato());
			panel.add(getLblEmpresa());
		}
		return panel;
	}
	private JCalendar getCalendar() {
		if (calendar == null) {
			calendar = new JCalendar();
			calendar.getDayChooser().setWeekOfYearVisible(false);
			calendar.setBounds(10, 95, 442, 175);
			calendar.getDayChooser().setMinSelectableDate(new Date());

		}
		return calendar;
	}
	private JButton getBtnAgregar() {
		if (btnAgregar == null) {
			btnAgregar = new JButton("Agregar");
			btnAgregar.setFont(new Font("Tahoma", Font.PLAIN, 13));
			btnAgregar.addActionListener(new ActionListener() {
				@SuppressWarnings("deprecation")
				public void actionPerformed(ActionEvent e) {
					Date fecha=new Date(calendar.getDate().getYear(), calendar.getDate().getMonth(), calendar.getDate().getDate());
					if(!AgenciaEmpleadora.getInstancia().verificarSiCandidatoTieneEntrevista(candidato, fecha)){
					if(oferta.getEmpresaPerteneciente().buscarEntrevistaPorFecha(fecha,oferta)==null){
						Entrevista x=new Entrevista(fecha, oferta);
						x.getListaCandidatos().add(candidato);
						oferta.getEmpresaPerteneciente().getListaEntrevistas().add(x);
					}else{
						oferta.getEmpresaPerteneciente().buscarEntrevistaPorFecha(fecha,oferta)
						.getListaCandidatos().add(candidato);
					}
					oferta.getListaCandidatos().add(candidato);
					SimpleDateFormat formatter = new SimpleDateFormat("dd/MM/yyyy");
					String message="La entrevista del candidato "+candidato.getNombre()+" con la empresa "
					+oferta.getEmpresaPerteneciente().getNombre()+"\n para el dia "+formatter.format(calendar.getDate())+" se ha realizado"
							+ " correctamente.";
					JOptionPane.showMessageDialog(null,message );
					cambiaPantalla();
					
					}else{
						JOptionPane.showMessageDialog(null, "Error: El candidato ya tiene una entrevista ese dia");
					}
						
				}
			});
			btnAgregar.setBounds(259, 281, 89, 23);
		}
		return btnAgregar;
	}
	private JButton getBtnCancelar() {
		if (btnCancelar == null) {
			btnCancelar = new JButton("Cancelar");
			btnCancelar.setFont(new Font("Tahoma", Font.PLAIN, 13));
			btnCancelar.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					cambiaPantalla();
				}
			});
			btnCancelar.setBounds(358, 281, 89, 23);
		}
		return btnCancelar;
	}
	public void cambiaPantalla(){
		
		dispose();
		pantalla.setModal(true);
		pantalla.setVisible(true);
	}
	private JPanel getPanel_1() {
		if (panel_1 == null) {
			panel_1 = new JPanel();
			panel_1.setLayout(null);
			panel_1.setBackground(new Color(219, 219, 219));
			panel_1.setBounds(0, 0, 482, 33);
			panel_1.add(getLblEntrevista());
			panel_1.add(getButton());
		}
		return panel_1;
	}
	private JLabel getLblEntrevista() {
		if (lblEntrevista == null) {
			lblEntrevista = new JLabel("Entrevista");
			lblEntrevista.setFont(new Font("Tahoma", Font.PLAIN, 22));
			lblEntrevista.setBounds(180, 0, 171, 33);
		}
		return lblEntrevista;
	}
	private JButton getButton() {
		if (button == null) {
			button = new JButton("X");
			button.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					cambiaPantalla();
				}
			});
			button.setForeground(Color.WHITE);
			button.setFont(new Font("Tahoma", Font.PLAIN, 13));
			button.setFocusable(false);
			button.setBackground(Color.RED);
			button.setBounds(433, 0, 49, 33);
		}
		return button;
	}
	private JLabel getLblCandidato() {
		if (lblCandidato == null) {
			lblCandidato = new JLabel("Candidato: "+ candidato.getNombre());
			lblCandidato.setFont(new Font("Tahoma", Font.PLAIN, 13));
			lblCandidato.setBounds(10, 28, 393, 14);
		}
		return lblCandidato;
	}
	private JLabel getLblEmpresa() {
		if (lblEmpresa == null) {
			lblEmpresa = new JLabel("Empresa: "+oferta.getEmpresaPerteneciente().getNombre() );
			lblEmpresa.setFont(new Font("Tahoma", Font.PLAIN, 13));
			lblEmpresa.setBounds(10, 60, 393, 14);
		}
		return lblEmpresa;
	}
}
