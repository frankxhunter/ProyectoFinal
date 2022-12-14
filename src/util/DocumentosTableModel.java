package util;

import java.util.ArrayList;

import javax.swing.table.DefaultTableModel;

import clase.Documento;

public class DocumentosTableModel extends DefaultTableModel{
	private static final long serialVersionUID=1L;
	public DocumentosTableModel(){
		String[] columnNames = {"Documento","Obligatorio"};
		this.setColumnIdentifiers(columnNames);
	}
	@Override
	public boolean isCellEditable(int row, int column) {
		return false;
	}
	@Override
	public Class<?> getColumnClass(int columnIndex) {
		// TODO Auto-generated method stub
		if( columnIndex==1)
			return	Boolean.class;
		return super.getColumnClass(columnIndex);
	}
	public void refresh(ArrayList<Documento> documentList){
		this.setRowCount(0);
		for (Documento documentos : documentList) 
			this.addRow(new Object[]{documentos.getDocumento(),documentos.getObligatorio()});
	}

}
