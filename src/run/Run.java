package run;

import java.awt.EventQueue;

import util.MetodosUtiles;
import visual.Login;
import clase.AgenciaEmpleadora;
import clase.Sector;

public class Run {
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					MetodosUtiles.RellenoAutomatico();
					AgenciaEmpleadora x=AgenciaEmpleadora.getInstancia();
					x.getListaCandidatos().get(0).CalcularEdadAproximada();
					if(x.getListaEspecialidades().get(20) instanceof Sector)
						System.out.println();
					Login window=new Login();
					window.setVisible(true);
					window.setLocationRelativeTo(null);
					
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}


}
