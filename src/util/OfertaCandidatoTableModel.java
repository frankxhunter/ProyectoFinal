package util;

import java.util.ArrayList;

import javax.swing.table.DefaultTableModel;

import clase.*;

public class OfertaCandidatoTableModel extends DefaultTableModel{
	private static final long serialVersionUID=1L;
	public OfertaCandidatoTableModel(){
		String[] columnNames = {"Numero de ID","Salario","Cantidad de Plazas","Rama","Empresa"};
		this.setColumnIdentifiers(columnNames);
	}
	public boolean isCellEditable(int row, int column) {
		return false;
	}
	public void refresh(ArrayList<Oferta> arrayList){
		this.setRowCount(0);
		for (Oferta x : arrayList) 
			this.addRow(new Object[]{x.getNumeroId(),x.getSalario(),x.getCantCandidatos(),x.getRama().getNombre(),
					x.getEmpresaPerteneciente().getNombre()});
	}

}