package clase;

import java.util.ArrayList;
import java.util.Date;

import excepcionesPropias.YaExisteExceptions;

public class Empresa {
	private String nombre;
	private String direccion;
	private String telefono;
	private Sector sector;
	private ArrayList<Entrevista> listaEntrevistas;
	private ArrayList<Oferta> listaOfertas;


	public Sector getSector() {
		return sector;
	}
	public void setSector(Sector sector) {
		this.sector = sector;
	}
	public ArrayList<Entrevista> getListaEntrevistas() {
		return listaEntrevistas;
	}
	public void setListaEntrevistas(ArrayList<Entrevista> listaEntrevistas) {
		this.listaEntrevistas = listaEntrevistas;
	}
	public ArrayList<Oferta> getListaOfertas() {
		return listaOfertas;
	}
	public void setListaOfertas(ArrayList<Oferta> listaOfertas) {
		this.listaOfertas = listaOfertas;
	}




	public Empresa(String nombre, String direccion, String telefono, Sector sector) {
		setNombre(nombre);
		setDireccion(direccion);
		setTelefono(telefono);
		setSector(sector);
		listaEntrevistas=new ArrayList<Entrevista>();
		listaOfertas=new ArrayList<Oferta>();
	}
	public String getNombre() {
		return nombre;
	}
	public void setNombre(String nombre) {
		if(nombre!=null)
			this.nombre = nombre;
		else 
			throw new IllegalArgumentException("No puede estar vacio");
	}
	public String getDireccion() {
		return direccion;
	}
	public void setDireccion(String direccion) {
		if(direccion!=null)
			this.direccion = direccion;
		else 
			throw new IllegalArgumentException("No puede estar vacio");
	}
	public String getTelefono() {
		return telefono;
	}
	public void setTelefono(String telefono) {
		if(telefono!=null)
			this.telefono = telefono;
		else 
			throw new IllegalArgumentException("No puede estar vacio");
	}
	public boolean verificaSiCandidatoTieneEntrevista(Date fecha,Candidato candidato){
		boolean salida=false;
		int i=0;
		boolean dia=false;
		while(i<listaEntrevistas.size()&& !dia){
			if(listaEntrevistas.get(i).getFecha().equals(fecha)){
				dia=true;
				int j=0;
				while(j<listaEntrevistas.get(i).getListaCandidatos().size() && !salida)
					if(listaEntrevistas.get(i).getListaCandidatos().get(j).equals(candidato))
						salida=true;
					else
						j++;
			}
			else 
				i++;
		}
		return salida;
	}
	public void eliminarOferta(int posicion){
		listaOfertas.remove(posicion);
	}
	public Entrevista buscarEntrevistaPorFecha(Date fecha,Oferta oferta){
		Entrevista salida=null;
		int i=0;
		while(i<listaEntrevistas.size() && salida==null)
			if(listaEntrevistas.get(i).getOferta().getNumeroId().equalsIgnoreCase(oferta.getNumeroId()))
				if(listaEntrevistas.get(i).getFecha().compareTo(fecha)==0)
					salida=listaEntrevistas.get(i);
				else 
					i++;
		return salida;
	}
	public void addOferta(Oferta oferta) throws YaExisteExceptions{
		boolean encontrado = false;
		int i=0;
		while(i<listaOfertas.size()&& !encontrado)
			if(listaOfertas.get(i).getNumeroId().equalsIgnoreCase(oferta.getNumeroId()))
				encontrado=true;
			else i++;
		if(!encontrado)
			listaOfertas.add(oferta);
		else 
			throw new YaExisteExceptions("Ya existe una oferta con el mismo numero de identificacion");
	}
	public void addEntrevista(Entrevista entrevista) throws YaExisteExceptions {
		boolean encontrado= false;
		int i=0;
		while(i<listaEntrevistas.size()&& !encontrado)
			if(listaEntrevistas.get(i).mismoDia(entrevista))
				encontrado=true;
			else i++;
		if(!encontrado)
			listaEntrevistas.add(entrevista);
		else
			listaEntrevistas.get(i).addCandidato(entrevista.getListaCandidatos().get(0));
	}
	@SuppressWarnings("deprecation")
	public ArrayList<Entrevista> obtenerEntrevista(int year, int month) {
		ArrayList<Entrevista> out=new ArrayList<Entrevista>();
		for(Entrevista x: listaEntrevistas)
			if(x.getFecha().getYear()==year-1900 && x.getFecha().getMonth()==month)
				out.add(x);
		return out;
	}
}