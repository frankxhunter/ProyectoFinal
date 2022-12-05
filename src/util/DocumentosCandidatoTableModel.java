package util;

import java.util.ArrayList;

import javax.swing.table.DefaultTableModel;

public class DocumentosCandidatoTableModel extends DefaultTableModel{
	private static final long serialVersionUID=1L;
	public DocumentosCandidatoTableModel(){
		String[] columnNames = {"","Documento"};
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
		if(columnIndex==0 || columnIndex==2)
			return	Boolean.class;
		return super.getColumnClass(columnIndex);
	}
	public void refresh(ArrayList<String> documentList){
		this.setRowCount(0);
		for (String doc : documentList) 
			this.addRow(new Object[]{false,doc});
	}
}
