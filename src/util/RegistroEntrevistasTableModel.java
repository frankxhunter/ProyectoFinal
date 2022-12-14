package util;

import java.text.SimpleDateFormat;
import java.util.ArrayList;

import javax.swing.table.DefaultTableModel;

import clase.*;

public class RegistroEntrevistasTableModel extends DefaultTableModel{
	private static final long serialVersionUID=1L;
	public RegistroEntrevistasTableModel(){
		String[] columnNames = {"Fecha","Empresa","Oferta ID","Rama"};
		this.setColumnIdentifiers(columnNames);
	}
	public boolean isCellEditable(int row, int column) {
		return false;
	}
	public void refresh(ArrayList<Entrevista> list){
		this.setRowCount(0);
		for (Entrevista x : list){
			SimpleDateFormat formatter = new SimpleDateFormat("dd/MM/yyyy");
			this.addRow(new Object[]{formatter.format(x.getFecha()),x.getOferta().getEmpresaPerteneciente().getNombre(),x.getOferta().getNumeroId(),
					x.getOferta().getRama().getNombre()});
		}
	}

}
