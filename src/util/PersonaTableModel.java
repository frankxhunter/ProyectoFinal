package util;

import java.util.ArrayList;

import javax.swing.table.DefaultTableModel;

import clase.*;

public class PersonaTableModel extends DefaultTableModel{
	private static final long serialVersionUID=1L;
	public PersonaTableModel(){
		String[] columnNames = {"","Carnet","Nombre", "Sexo","Direccion","Telefono","Nivel Escolar","Especialidad","Años de Experiencia","Rama"};
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
	public void refresh(ArrayList<Candidato> listCandidatos){
		this.setRowCount(0);
		for (Candidato x : listCandidatos) 
			this.addRow(new Object[]{false,x.getCarnet(),x.getNombre(),x.getSexo(),x.getDireccion(),x.getTelefono()
					,x.getNivelEscolaridad(),x.getEspecialidad(),x.getYearsExp(),x.getRama().getNombre()});
	}
}
