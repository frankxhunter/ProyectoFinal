package run;

import java.awt.EventQueue;
import java.util.ArrayList;

import util.MetodosUtiles;
import visual.Login;
import clase.AgenciaEmpleadora;
import clase.Entrevista;

public class Run {
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					MetodosUtiles.RellenoAutomatico();
					ArrayList<Entrevista> x=AgenciaEmpleadora.getInstancia().obtenerEntrevista(0, 0);
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
