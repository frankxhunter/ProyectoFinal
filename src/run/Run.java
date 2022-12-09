package run;

import java.awt.EventQueue;

import util.MetodosUtiles;
import visual.Login;

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
