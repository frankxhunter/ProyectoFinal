package util;

import java.util.ArrayList;

import javax.swing.table.DefaultTableModel;

import clase.*;

public class EspecialidadTableModel extends DefaultTableModel{
	private static final long serialVersionUID=1L;
	public EspecialidadTableModel(){
		String[] columnNames = {"","Nombre"};
		this.setColumnIdentifiers(columnNames);
	}
	@Override
	public boolean isCellEditable(int row, int column) {
		// TODO Auto-generated method stub
		if(column==0)
			return true;
		return false;
	}
	@Override
	public Class<?> getColumnClass(int columnIndex) {
		// TODO Auto-generated method stub
		if(columnIndex==0 )
			return	Boolean.class;
		return super.getColumnClass(columnIndex);
	}
	public void refresh(ArrayList<Sector> arrayList){
		this.setRowCount(0);
		for (Sector x : arrayList) 
			this.addRow(new Object[]{false,x.getNombre()});
	}
	public void refresh2(ArrayList<Rama> arrayList){
		this.setRowCount(0);
		for (Rama x : arrayList) 
			this.addRow(new Object[]{false,x.getNombre()});
	}

	public void eliminar(int pos){
		removeRow(pos);
	}

}
