package clase;

import java.util.ArrayList;

import excepcionesPropias.YaExisteExceptions;

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
	public void addCandidato(Candidato candidato)throws YaExisteExceptions{
		boolean encontrado=false;
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

}
