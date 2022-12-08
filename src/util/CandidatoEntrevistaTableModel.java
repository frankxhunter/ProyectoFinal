package util;

import java.util.ArrayList;

import javax.swing.table.DefaultTableModel;

import clase.*;

public class CandidatoEntrevistaTableModel extends DefaultTableModel{
	private static final long serialVersionUID=1L;
	public CandidatoEntrevistaTableModel(){
		String[] columnNames = {"Nombre y Apellidos","Carnet","Telefono"};
		this.setColumnIdentifiers(columnNames);
	}
	public boolean isCellEditable(int row, int column) {
		return false;
	}
	public void refresh(ArrayList<Candidato> arrayList){
		this.setRowCount(0);
		for (Candidato x : arrayList) 
			this.addRow(new Object[]{x.getNombre(),x.getCarnet(),x.getTelefono()});
	}

}
