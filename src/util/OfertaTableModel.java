package util;

import java.util.ArrayList;

import javax.swing.table.DefaultTableModel;

import clase.*;

public class OfertaTableModel extends DefaultTableModel{
	private static final long serialVersionUID=1L;
	public OfertaTableModel(){
		String[] columnNames = {"","Numero de ID","Salario","Cantidad de Plazas","Rama"};
		this.setColumnIdentifiers(columnNames);
	}
	public boolean isCellEditable(int row, int column) {
		if(column==0)
			return true;
		return false;
	}
	@Override
	public Class<?> getColumnClass(int columnIndex) {
		if(columnIndex==0)
			return	Boolean.class;
		return super.getColumnClass(columnIndex);
	}
	public void refresh(ArrayList<Oferta> arrayList){
		this.setRowCount(0);
		for (Oferta x : arrayList) 
			this.addRow(new Object[]{false,x.getNumeroId(),x.getSalario(),x.getCantCandidatos(),x.getRama().getNombre()});
	}

}
