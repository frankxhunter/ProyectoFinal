package util;

import java.util.ArrayList;
import java.util.Collections;

import javax.swing.table.DefaultTableModel;

import clase.*;

public class PromedioSalarioTableModel extends DefaultTableModel{
	private static final long serialVersionUID=1L;
	public PromedioSalarioTableModel(){
		String[] columnNames = {"Empresa","Promedio de Salario"};
		this.setColumnIdentifiers(columnNames);
	}
	public boolean isCellEditable(int row, int column) {
		return false;
	}
	public void refresh(ArrayList<Empresa> list){
		this.setRowCount(0);
		Collections.sort(list);
		for (Empresa x : list) 
			this.addRow(new Object[]{x.getNombre(),x.promedioSalario()});
	}

}
