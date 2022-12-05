package run;

import java.awt.EventQueue;
import java.util.ArrayList;

import javax.swing.JFrame;

import util.MetodosUtiles;
import visual.Login;
import clase.AgenciaEmpleadora;
import clase.Candidato;
import clase.Documento;
import clase.Empresa;
import clase.Oferta;
import clase.Rama;
import clase.Sector;

public class Run {
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					MetodosUtiles.RellenoAutomatico();
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
