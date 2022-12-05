package clase;

import java.util.ArrayList;

public class Candidato {
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

	//	public Candidato(String carnet, String nombre, String sexo,
//			String direccion, String telefono, String nivelEscolaridad,
//			String especialidad, int yearsExp) {
//		setCarnet(carnet);
//		setNombre(nombre);
//		setSexo(sexo);
//		setDireccion(direccion);
//		setTelefono(telefono);
//		setNivelEscolaridad(nivelEscolaridad);
//		setEspecialidad(especialidad);
//		setYearsExp(yearsExp);
//		setYearsExp(yearsExp);
//		setRama(rama);
//	}
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
		if(rama.getNombre()==oferta.getRama().getNombre()){
			salida=true;
//		int i=0;
//		while(salida && i<oferta.getRama().getListaCondiciones().size()){
//			int j=0;
//			boolean condicion=false;
//			while(!condicion && j<documentos.size()){
//				if(oferta.getRama().getListaCondiciones().get(i).equals(documentos.get(j)))
//					condicion=true;
//				else
//					j++;
//			}
//			if(j==documentos.size())
//				salida=false;
//			else
//				i++;
//		}
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
	public void addDocumento(String documento){
		documentos.add(documento);
	}


}
