package clase;

import java.util.ArrayList;

public class AgenciaEmpleadora {
	private String nombre;
	private ArrayList<Candidato> listaCandidatos;
	private ArrayList<Empresa> listaEmpresas;
	private ArrayList<Especialidad> listaEspecialidades;
	private static AgenciaEmpleadora instancia;


	public static AgenciaEmpleadora CrearInstancia(String nombre){
		if(instancia==null)
			instancia=new AgenciaEmpleadora(nombre);
		return instancia;
	}
	public static AgenciaEmpleadora getInstancia(){
		return instancia;
	}

	private AgenciaEmpleadora(String nombre){
		setNombre(nombre);
		listaCandidatos=new ArrayList<Candidato>();
		listaEmpresas=new ArrayList<Empresa>();
		listaEspecialidades=new ArrayList<Especialidad>();
	}
	public String getNombre() {
		return nombre;
	}
	public void setNombre(String nombre) {
		this.nombre = nombre;
	}
	public ArrayList<Candidato> getListaCandidatos() {
		return listaCandidatos;
	}
	public void setListaCandidatosDisponibles(ArrayList<Candidato> listaCandidatos) {
		this.listaCandidatos = listaCandidatos;
	}
	public ArrayList<Empresa> getListaEmpresas() {
		return listaEmpresas;
	}
	public void setListaEmpresas(ArrayList<Empresa> listaEmpresas) {
		this.listaEmpresas = listaEmpresas;
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

	
	
	//Metodos de la lista de especialidades
	public void agregar(Especialidad x){
		listaEspecialidades.add(x);
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
	public void validarSiExiste(Sector sector){
		for(Especialidad x: listaEspecialidades){
			if(x instanceof Sector)
				if(x.getNombre().equalsIgnoreCase(sector.getNombre()))
					throw new IllegalArgumentException("Error");
			
		}
	}
	public Sector obtenerSector(String nombre){
		int i=0;
		Sector salida=null;
		while(salida==null && i<listaEspecialidades.size() ){
			if(listaEspecialidades.get(i) instanceof Sector)
			if(listaEspecialidades.get(i).getNombre().equalsIgnoreCase(nombre))
				salida=(Sector) listaEspecialidades.get(i);
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
				salida=(Rama) listaEspecialidades.get(i);
			i++;
		}
		return salida;
	}
	public void addEmpresa(String nombre, String direccion, String telefono, Sector sector){
		listaEmpresas.add(new Empresa(nombre, direccion, telefono, sector));
	}
	public void addSector(String nombre, ArrayList<Documento> listaCondiciones){
		listaEspecialidades.add(new Sector(nombre, listaCondiciones));
	}
	public void addRama(String nombre, ArrayList<Documento> listaCondiciones){
		listaEspecialidades.add(new Rama(nombre, listaCondiciones));
	}
	public void addCandidato(Candidato candidato){
		listaCandidatos.add(candidato);
	}
	public ArrayList<Entrevista> obtenerEntrevista(int year, int month){
		ArrayList<Entrevista> out=new ArrayList<Entrevista>();
		for(Empresa x:listaEmpresas)
			out.addAll(x.obtenerEntrevista(year,month));
		return out;
	}

}
