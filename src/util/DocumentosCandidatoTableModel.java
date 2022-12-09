package util;

import java.util.ArrayList;

import javax.swing.table.DefaultTableModel;

public class DocumentosCandidatoTableModel extends DefaultTableModel{
	private static final long serialVersionUID=1L;
	public DocumentosCandidatoTableModel(){
		String[] columnNames = {"Documento"};
		this.setColumnIdentifiers(columnNames);
	}
	@Override
	public boolean isCellEditable(int row, int column) {
		return false;
	}
	
	
	public void refresh(ArrayList<String> documentList){
		this.setRowCount(0);
		for (String doc : documentList) 
			this.addRow(new Object[]{doc});
	}
}
