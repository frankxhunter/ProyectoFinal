package clase;

import java.util.ArrayList;

import excepcionesPropias.YaExisteExceptions;

public abstract class Especialidad {
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
	public Especialidad(String string) {
		setNombre(string);
		listaDocumentos= new ArrayList<Documento>();
	}
	public void setListaDocumentos(ArrayList<Documento> listaDocumentos) {
		this.listaDocumentos = listaDocumentos;
	}
	public String getNombre() {
		return nombre;
	}
	public void setNombre(String nombre) {
		if(nombre!=null)
			if(nombre.trim().length()>0)
				this.nombre = nombre;
			else 
				throw new IllegalArgumentException("No puede estar vacio");
		else 
			throw new IllegalArgumentException("No puede estar vacio");
	}
	public ArrayList<Documento> getListaDocumentos() {
		return listaDocumentos;
	}
	public void addDocumento(Documento documento) throws YaExisteExceptions{
		boolean encontrado=false;
		int i=0;
		while(i<listaDocumentos.size() && !encontrado)
			if(listaDocumentos.get(i).getDocumento().equalsIgnoreCase(documento.getDocumento()))
				encontrado=true;
			else 
				i++;
		if(!encontrado)
			listaDocumentos.add(documento);
		else
			throw new YaExisteExceptions("Ya existe");
	}

}
