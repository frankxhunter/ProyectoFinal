package clase;

import java.util.ArrayList;
import java.util.Date;

import excepcionesPropias.ElementosInsuficientesException;
import excepcionesPropias.YaExisteExceptions;

public class AgenciaEmpleadora {
	private ArrayList<Candidato> listaCandidatos;
	private ArrayList<Empresa> listaEmpresas;
	private ArrayList<Especialidad> listaEspecialidades;
	private static AgenciaEmpleadora instancia;


	public static AgenciaEmpleadora getInstancia( ){
		if(instancia==null)
			instancia=new AgenciaEmpleadora();
		return instancia;
	}
	private AgenciaEmpleadora( ){
		listaCandidatos=new ArrayList<Candidato>();
		listaEmpresas=new ArrayList<Empresa>();
		listaEspecialidades=new ArrayList<Especialidad>();
	}
	public ArrayList<Candidato> getListaCandidatos() {
		return listaCandidatos;
	}
	public ArrayList<Empresa> getListaEmpresas() {
		return listaEmpresas;
	}
	public Candidato buscarCandidato(String carnet){
		Candidato candidato=null;
		int i=0;
		while(candidato==null && i<listaCandidatos.size()){
			if(listaCandidatos.get(i).getCarnet().equals(carnet)){
				candidato=listaCandidatos.get(i);
			}
			i++;
		}
		return candidato;
	}
	public Empresa obtenerEmpresa(String nombre){
		int i=0;
		Empresa salida=null;
		while(salida==null && i<listaEmpresas.size())
			if(listaEmpresas.get(i).getNombre().equalsIgnoreCase(nombre))
				salida=listaEmpresas.get(i);
			else 
				i++;

		return salida;
	}
	public ArrayList<Especialidad> getListaEspecialidades(){
		return listaEspecialidades;
	}
	public ArrayList<Sector> getlistaSector(){
		ArrayList<Sector> listaSectores= new ArrayList<Sector>();
		for(Especialidad x: listaEspecialidades)
			if(x instanceof Sector)
				listaSectores.add((Sector)x);
		return listaSectores;

	}
	public ArrayList<Rama> getlistaRama(){
		ArrayList<Rama> listaRamas= new ArrayList<Rama>();
		for(Especialidad x: listaEspecialidades)
			if(x instanceof Rama)
				listaRamas.add((Rama)x);
		return listaRamas;

	}
	public Sector obtenerSector(String nombre){
		int i=0;
		Sector salida=null;
		while(salida==null && i<listaEspecialidades.size() ){
			if(listaEspecialidades.get(i) instanceof Sector)
				if(listaEspecialidades.get(i).getNombre().equalsIgnoreCase(nombre))
					salida=(Sector)listaEspecialidades.get(i);
			i++;
		}
		return salida;
	}
	public Rama obtenerRama(String nombre){
		int i=0;
		Rama salida=null;
		while(salida==null && i<listaEspecialidades.size() ){
			if(listaEspecialidades.get(i) instanceof Rama)
				if(listaEspecialidades.get(i).getNombre().equalsIgnoreCase(nombre))
					salida=(Rama)listaEspecialidades.get(i);
			i++;
		}
		return salida;
	}
	public void addEmpresa(Empresa empresa) throws YaExisteExceptions{
		boolean encontrado=false;
		int i=0;
		while(i<listaEmpresas.size() && !encontrado)
			if(listaEmpresas.get(i).getNombre().equalsIgnoreCase(empresa.getNombre()))
				encontrado=true;
			else i++;
		if(!encontrado)
			listaEmpresas.add(empresa);
		else
			throw new YaExisteExceptions("Ya existe la Empresa");
	}
	public void addSector(Sector sector) throws YaExisteExceptions{
		boolean encontrado=false;
		int i=0;
		while(i<listaEspecialidades.size() && !encontrado)
			if(listaEspecialidades.get(i) instanceof Sector)
				if(listaEspecialidades.get(i).getNombre().equalsIgnoreCase(sector.getNombre()))
					encontrado=true;
				else i++;
			else i++;
		if(!encontrado)
			listaEspecialidades.add(sector);
		else
			throw new YaExisteExceptions("El sector ya existe");
	}
	public void addRama(Rama rama) throws YaExisteExceptions{
		boolean encontrado=false;
		int i=0;
		while(i<listaEspecialidades.size() && !encontrado)
			if(listaEspecialidades.get(i) instanceof Rama)
				if(listaEspecialidades.get(i).getNombre().equalsIgnoreCase(rama.getNombre()))
					encontrado=true;
				else i++;
			else i++;
		if(!encontrado)
			listaEspecialidades.add(rama);
		else
			throw new YaExisteExceptions("Ya existe la Rama");
	}
	public void addCandidato(Candidato candidato)throws YaExisteExceptions, ElementosInsuficientesException{
		boolean encontrado=false;
		candidato.VerificarSiCumpleCondicionesRama();
		int i=0;
		while(i<listaCandidatos.size() && !encontrado)
			if(listaCandidatos.get(i).getCarnet().equalsIgnoreCase(candidato.getCarnet()))
				encontrado=true;
			else i++;
		if(!encontrado)
			listaCandidatos.add(candidato);
		else
			throw new YaExisteExceptions("Ya existe un Candidato con el mismo Carnet");
	}
	public ArrayList<Entrevista> obtenerEntrevista(int year, int month){
		ArrayList<Entrevista> out=new ArrayList<Entrevista>();
		for(Empresa x: listaEmpresas)
			out.addAll(x.obtenerEntrevista(year, month));
		return out;
	}
	public ArrayList<Candidato> devolverCandidatoSegunOferta(Oferta oferta){
		ArrayList<Candidato> out=new ArrayList<Candidato>();
		for(Candidato x: listaCandidatos)
			if(x.verificarSiCumpleOferta(oferta))
				out.add(x);
		return out;
	}
	public int PromedioEdadCandidatos(){
		int out=0;
		int cant=0;
		for(Candidato x:listaCandidatos){
			out+=x.CalcularEdadAproximada();
			cant++;
		}
		if(cant>0)
			out/=cant;
		return out;

	}
	public boolean verificarSiCandidatoTieneEntrevista(Candidato candidato, Date fecha){
		boolean out=false;
		int i=0;
		while(!out && i<listaEmpresas.size())
			if(listaEmpresas.get(i).verificaSiCandidatoTieneEntrevista(fecha, candidato))
				out=true;
			else
				i++;
		return out;

	}
	public void eliminarSector(Sector sector){
		listaEspecialidades.remove(sector);
		int i=0;
		while(i<listaEmpresas.size()){
		if(listaEmpresas.get(i).getSector().equals(sector))
			listaEmpresas.remove(i);
		else i++;
		}
	}
	public void eliminarRama(Rama rama){
		listaEspecialidades.remove(rama);
		int i=0;
		while(i<listaCandidatos.size())
			if(listaCandidatos.get(i).getRama().equals(rama))
				eliminarCandidato(listaCandidatos.get(i));
			else i++;
	}
	public void eliminarCandidato(Candidato candidato){
		listaCandidatos.remove(candidato);
		for(Empresa x: listaEmpresas)
			x.eliminarCandidato(candidato);
	}

}
