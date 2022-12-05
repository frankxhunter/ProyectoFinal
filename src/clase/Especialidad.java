package clase;

import java.util.ArrayList;

public class Especialidad {
	private String nombre;
	private ArrayList<Documento> listaDocumentos;

	public Especialidad(String nombre, ArrayList<Documento> listaDocumentos) {
		setNombre(nombre);
		setListaDocumentos(listaDocumentos);
	}
	public Especialidad() {
		nombre=null;
		listaDocumentos= new ArrayList<Documento>();
	}
	public void setListaDocumentos(ArrayList<Documento> listaDocumentos) {
		this.listaDocumentos = listaDocumentos;
	}
	public String getNombre() {
		return nombre;
	}
	public void setNombre(String nombre) {
		if(nombre.trim().length()>0)
			this.nombre = nombre;
		else 
			throw new IllegalArgumentException("No puede estar vacio");
	}
	public ArrayList<Documento> getListaDocumentos() {
		return listaDocumentos;
	}
	public void addDocumento(Documento doc){
		listaDocumentos.add(doc);
	}

}
