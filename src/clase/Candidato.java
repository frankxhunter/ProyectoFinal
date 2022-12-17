package clase;

import java.util.ArrayList;
import java.util.Date;

import excepcionesPropias.ElementosInsuficientesException;
import excepcionesPropias.YaExisteExceptions;

public class Candidato implements Comparable<Candidato>{
	private String carnet;
	private String nombre;
	private String sexo;
	private String direccion;
	private String telefono;
	private String nivelEscolaridad;
	private String especialidad;
	private int yearsExp;
	private ArrayList<String> documentos;
	private Rama rama;

	public Candidato(String carnet, String nombre, String sexo,
			String direccion, String telefono, String nivelEscolaridad,
			String especialidad, int yearsExp, Rama rama) {
		setCarnet(carnet);
		setNombre(nombre);
		setSexo(sexo);
		setDireccion(direccion);
		setTelefono(telefono);
		setNivelEscolaridad(nivelEscolaridad);
		setEspecialidad(especialidad);
		setYearsExp(yearsExp);
		setYearsExp(yearsExp);
		setRama(rama);
		documentos = new ArrayList<String>();
	}

	public Candidato() {
		documentos = new ArrayList<String>();
	}
	public String getCarnet() {
		return carnet;
	}
	public void setCarnet(String carnet) {
		if(carnet!=null)
			this.carnet = carnet;
		else 
			throw new IllegalArgumentException("No puede estar vacio");
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
	public String getSexo() {
		return sexo;
	}
	public void setSexo(String sexo) {
		if(sexo!=null)
			this.sexo = sexo;
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
	public String getNivelEscolaridad() {
		return nivelEscolaridad;
	}
	public void setNivelEscolaridad(String nivelEscolaridad) {
		if(nivelEscolaridad!=null)
			this.nivelEscolaridad = nivelEscolaridad;
		else 
			throw new IllegalArgumentException("No puede estar vacio");
	}
	public String getEspecialidad() {
		return especialidad;
	}
	public void setEspecialidad(String especialidad) {
		if(especialidad!=null)
			this.especialidad = especialidad;
		else 
			throw new IllegalArgumentException("No puede estar vacio");
	}
	public int getYearsExp() {
		return yearsExp;
	}
	public void setYearsExp(int yearsExp) {
		if(yearsExp>0&&yearsExp<80)
			this.yearsExp=yearsExp;
		else 
			throw new IllegalArgumentException("El valor esta fuera de rango");
	}
	public ArrayList<String> getDocumentos() {
		return documentos;
	}
	public void setDocumentos(ArrayList<String> documentos) {
		boolean valido=true;
		int i=0;
		while(i<documentos.size()&& valido){
			if(documentos.get(i)==null){
				throw new IllegalArgumentException("no puede estar vacio");
			}
			else 
				i++;
		}
		if(valido)
			this.documentos=documentos;
	}
	public Rama getRama() {
		return rama;
	}
	public void setRama(Rama rama) {
		this.rama = rama;
	}
	public boolean verificarSiCumpleOferta(Oferta oferta){
		boolean salida=false;
		if(rama.getNombre().equalsIgnoreCase(oferta.getRama().getNombre())){
			salida=true;
			int i=0;
			while(i<oferta.getListaCandidatos().size() && salida)
				if(oferta.getListaCandidatos().get(i).equals(this))
					salida=false;
				else i++;
		}
		return salida;
	}

	public ArrayList<Oferta> DevolverListaDeOfertasDisponibles(ArrayList<Empresa> lista){
		ArrayList<Oferta> salida= new ArrayList<Oferta>();
		for(Empresa y: lista)
			for(Oferta x: y.getListaOfertas())
				if(verificarSiCumpleOferta(x))
					salida.add(x);
		return salida;
	}
	public void addDocumento(String documento) throws YaExisteExceptions{
		boolean encontrado=false;
		int i=0;
		while(i<documentos.size() && !encontrado)
			if(documentos.get(i).equalsIgnoreCase(documento))
				encontrado=true;
			else 
				i++;
		if(!encontrado)
			documentos.add(documento);
		else
			throw new YaExisteExceptions("Ya existe");
	}
	public int compareTo(Candidato o) {
		int out=0;
		int x=o.getYearsExp()+o.getDocumentos().size();
		int y=documentos.size()+yearsExp;
		if(y>x)
			out=-1;
		else if(y<x)
			out=1;
		return out;
	}
	@SuppressWarnings("deprecation")
	public int CalcularEdadAproximada(){
		Date hoy=new Date();
		int year=1900+hoy.getYear();
		int out=Integer.parseInt(carnet.substring(0, 2));
		if(out>0 && out<30)
			out+=2000;
		else if(out>=30&& out<99)
			out+=1900;
		out=year-out;
		return out;
	}
	public void VerificarSiCumpleCondicionesRama() throws ElementosInsuficientesException{
		ArrayList<String> faltantes=new ArrayList<String>();
		for(Documento x: rama.getListaDocumentos()){
			if(x.getObligatorio()){
				boolean encontrado=false;
				int i=0;
				while(!encontrado && i<documentos.size())
					if(x.getDocumento().equalsIgnoreCase(documentos.get(i)))
						encontrado=true;
					else i++;
				if(!encontrado)
					faltantes.add(x.getDocumento());
			}
		}
		
		if(faltantes.size()>0){
			String mensaje="";
			for(String z: faltantes)
				mensaje+=z+"\n";
			throw new ElementosInsuficientesException(mensaje);
		}

	}
	public String VerificarSiCumpleCondicionesSector(Sector sector){
		String message="";
		for(Documento x: sector.getListaDocumentos()){
			boolean encontrado=false;
			int i=0;
			while(i<documentos.size()&& !encontrado)
				if(documentos.get(i).equalsIgnoreCase(x.getDocumento()))
					encontrado=true;
				else i++;
			if(!encontrado)
				message+=x.getDocumento()+"\n";
		}
		return message;
	}
}
