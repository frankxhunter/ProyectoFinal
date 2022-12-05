package util;

import java.util.ArrayList;

import javax.swing.table.DefaultTableModel;

import clase.*;

public class EmpresaTableModel extends DefaultTableModel{
	private static final long serialVersionUID=1L;
	public EmpresaTableModel(){
		String[] columnNames = {"","Nombre","Direccion","Telefono","Sector"};
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
	public void refresh(ArrayList<Empresa> listEmpresas){
		this.setRowCount(0);
		for (Empresa emp : listEmpresas) 
			this.addRow(new Object[]{false,emp.getNombre(),emp.getDireccion(),emp.getTelefono(),emp.getSector().getNombre()});
	}


}
