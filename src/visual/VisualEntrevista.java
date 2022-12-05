package visual;

import java.util.Date;

import javax.swing.JDialog;
import javax.swing.JPanel;

import clase.Candidato;
import clase.Entrevista;
import clase.Oferta;

import javax.swing.JLabel;

import com.toedter.calendar.JCalendar;

import javax.swing.JButton;

import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class VisualEntrevista extends JDialog {
	private JPanel panel; 
	private Candidato candidato;
	private Oferta oferta;
	private JCalendar calendar;
	private JButton btnAgregar;
	private JButton btnCancelar;
	private JLabel lblInformacion;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		try {
			VisualEntrevista dialog = new VisualEntrevista(null, null);
			dialog.setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
			dialog.setVisible(true);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	/**
	 * Create the dialog.
	 */
	public VisualEntrevista(Candidato candidato, Oferta oferta) {
		this.candidato=candidato;
		this.oferta=oferta;
		setBounds(100, 100, 478, 324);
		getContentPane().setLayout(null);
		getContentPane().add(getPanel());
	}
	private JPanel getPanel() {
		if (panel == null) {
			panel = new JPanel();
			panel.setBounds(0, 0, 462, 285);
			panel.setLayout(null);
			panel.add(getCalendar());
			panel.add(getBtnAgregar());
			panel.add(getBtnCancelar());
			panel.add(getLblInformacion());
		}
		return panel;
	}
	private JCalendar getCalendar() {
		if (calendar == null) {
			calendar = new JCalendar();
			calendar.getDayChooser().setWeekOfYearVisible(false);
			calendar.setBounds(10, 68, 442, 175);
			calendar.getDayChooser().setMinSelectableDate(new Date());

		}
		return calendar;
	}
	private JButton getBtnAgregar() {
		if (btnAgregar == null) {
			btnAgregar = new JButton("Agregar");
			btnAgregar.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					if(oferta.getEmpresaPerteneciente().buscarEntrevistaPorFecha(calendar.getDate(),oferta)==null){
						Entrevista x=new Entrevista(calendar.getDate(), oferta);
						x.getListaCandidatos().add(candidato);
						oferta.getEmpresaPerteneciente().getListaEntrevistas().add(x);
					}else{
						oferta.getEmpresaPerteneciente().buscarEntrevistaPorFecha(calendar.getDate(),oferta)
						.getListaCandidatos().add(candidato);
					}
					cambiaPantalla();
				}
			});
			btnAgregar.setBounds(260, 251, 89, 23);
		}
		return btnAgregar;
	}
	private JButton getBtnCancelar() {
		if (btnCancelar == null) {
			btnCancelar = new JButton("Cancelar");
			btnCancelar.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					cambiaPantalla();
				}
			});
			btnCancelar.setBounds(359, 251, 89, 23);
		}
		return btnCancelar;
	}
	public void cambiaPantalla(){
		VisualCandidato x=new VisualCandidato();
		x.setVisible(true);
		dispose();
		x.setModal(true);
		x.setLocationRelativeTo(null);
	}
	private JLabel getLblInformacion() {
		if (lblInformacion == null) {
			lblInformacion = new JLabel("Introduzca la fecha de la entrevista del candidato "+candidato.getNombre()
					+" con la empresa "+oferta.getEmpresaPerteneciente().getNombre()+"para la oferta de"+oferta.getRama().getNombre());
			lblInformacion.setBounds(10, 11, 442, 46);
		}
		return lblInformacion;
	}
}
