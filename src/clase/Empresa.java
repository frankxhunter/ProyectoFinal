package clase;

import java.util.ArrayList;
import java.util.Date;

import excepcionesPropias.YaExisteExceptions;

public class Empresa implements Comparable<Empresa>{
	private String nombre;
	private String direccion;
	private String telefono;
	private Sector sector;
	private ArrayList<Entrevista> listaEntrevistas;
	private ArrayList<Oferta> listaOfertas;


	public Empresa(String nombre, String direccion, String telefono, Sector sector) {
		setNombre(nombre);
		setDireccion(direccion);
		setTelefono(telefono);
		setSector(sector);
		listaEntrevistas=new ArrayList<Entrevista>();
		listaOfertas=new ArrayList<Oferta>();
	}
	public Sector getSector() {
		return sector;
	}
	public ArrayList<Entrevista> getListaEntrevistas() {
		return listaEntrevistas;
	}
	public ArrayList<Oferta> getListaOfertas() {
		return listaOfertas;
	}
	public String getNombre() {
		return nombre;
	}
	public String getDireccion() {
		return direccion;
	}
	public String getTelefono() {
		return telefono;
	}
	public void setSector(Sector sector) {
		this.sector = sector;
	}
	public void setNombre(String nombre) {
		if(nombre!=null)
			this.nombre = nombre;
		else 
			throw new IllegalArgumentException("No puede estar vacio");
	}
	public void setDireccion(String direccion) {
		if(direccion!=null)
			this.direccion = direccion;
		else 
			throw new IllegalArgumentException("No puede estar vacio");
	}
	public void setTelefono(String telefono) {
		if(telefono!=null)
			this.telefono = telefono;
		else 
			throw new IllegalArgumentException("No puede estar vacio");
	}
	public Entrevista buscarEntrevistaPorFecha(Date fecha,Oferta oferta){
		Entrevista salida=null;
		int i=0;
		while(i<listaEntrevistas.size() && salida==null)
			if(listaEntrevistas.get(i).getOferta().getNumeroId().equalsIgnoreCase(oferta.getNumeroId()))
				if(listaEntrevistas.get(i).mismoDia(fecha))
					salida=listaEntrevistas.get(i);
				else 
					i++;
		return salida;
	}
	public void addOferta(Oferta oferta) throws YaExisteExceptions{
		boolean encontrado = false;
		int i=0;
		while(i<listaOfertas.size()&& !encontrado)
			if(listaOfertas.get(i).getNumeroId().
					equalsIgnoreCase(oferta.getNumeroId()))
				encontrado=true;
			else i++;
		if(!encontrado)
			listaOfertas.add(oferta);
		else 
			throw new YaExisteExceptions("Ya existe una "
					+ "oferta con el mismo numero de identificacion");
	}
	public void addEntrevista(Entrevista entrevista) throws YaExisteExceptions {
		boolean encontrado= false;
		int i=0;
		while(i<listaEntrevistas.size()&& !encontrado)
			if(listaEntrevistas.get(i).mismoDia(entrevista.getFecha()))
				encontrado=true;
			else i++;
		if(!encontrado)
			listaEntrevistas.add(entrevista);
		else
			listaEntrevistas.get(i).addCandidato(entrevista.getListaCandidatos().get(0));
	}
	public boolean verificaSiCandidatoTieneEntrevista(Date fecha,
			Candidato candidato){
		boolean salida=false;
		int i=0;
		boolean dia=false;
		while(i<listaEntrevistas.size()&& !dia){
			if(listaEntrevistas.get(i).mismoDia(fecha)){
				dia=true;
				int j=0;
				while(j<listaEntrevistas.get(i).getListaCandidatos().
						size() && !salida)
					if(listaEntrevistas.get(i).getListaCandidatos().
							get(j).equals(candidato))
						salida=true;
					else
						j++;
			}
			else 
				i++;
		}
		return salida;
	}
	@SuppressWarnings("deprecation")
	public ArrayList<Entrevista> obtenerEntrevista(int year, int month) {
		ArrayList<Entrevista> out=new ArrayList<Entrevista>();
		for(Entrevista x: listaEntrevistas)
			if(x.getFecha().getYear()==year-1900 && x.getFecha().getMonth()==month)
				out.add(x);
		return out;
	}
	public float promedioSalario(){
		float out=0;
		int cant=0;
		for(Oferta x: listaOfertas){
			out+=x.getSalario();
			cant++;
		}
		if(cant>0)
			out/=cant;
		return out;
	}
	public int compareTo(Empresa o) {
		int out=0;
		if(o.promedioSalario()>promedioSalario())
			out=1;
		else if(o.promedioSalario()<promedioSalario())
			out=-1;
		return out;
	}
	public void eliminarCandidato(Candidato candidato){
		for(Oferta x:listaOfertas)
			x.getListaCandidatos().remove(candidato);
		int i=0;
		while(i<listaEntrevistas.size()){
			listaEntrevistas.get(i).getListaCandidatos().remove(candidato);
			if(listaEntrevistas.get(i).getListaCandidatos().size()==0)
				listaEntrevistas.remove(i);
			else i++;
		}
	}
	public void eliminarOferta(Oferta oferta){
		listaOfertas.remove(oferta);
		int i=0;
		while(i<listaEntrevistas.size())
			if(listaEntrevistas.get(i).getOferta().equals(oferta))
				listaEntrevistas.remove(i);
			else i++;
	}
	public void eliminarOfertra(Rama rama){
		int i=0;
		while(i<listaOfertas.size())
			if(listaOfertas.get(i).getRama().equals(rama))
				eliminarOferta(listaOfertas.get(i));
			else i++;
	}
}
