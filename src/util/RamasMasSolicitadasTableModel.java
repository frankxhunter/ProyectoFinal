package util;

import java.util.ArrayList;
import java.util.Collections;

import javax.swing.table.DefaultTableModel;

import clase.*;

public class RamasMasSolicitadasTableModel extends DefaultTableModel{
	private static final long serialVersionUID=1L;
	public RamasMasSolicitadasTableModel(){
		String[] columnNames = {"Rama","Veces que fue Solicitada"};
		this.setColumnIdentifiers(columnNames);
	}
	public boolean isCellEditable(int row, int column) {
		return false;
	}
	public void refresh(ArrayList<Rama> list){
		this.setRowCount(0);
		Collections.sort(list);
		for (Rama x : list) 
			this.addRow(new Object[]{x.getNombre(),x.contarSolicitudes()});
	}

}
