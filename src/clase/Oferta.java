package clase;

import java.util.ArrayList;

import excepcionesPropias.YaExisteExceptions;

public class Oferta {
	private String numeroId;
	private float salario;
	private int cantCandidatos;
	private ArrayList<Candidato> listaCandidatos;
	private Rama rama;
	private Empresa EmpresaPerteneciente;
	
	
	
	

	public Oferta() {
		listaCandidatos=new ArrayList<Candidato>();
	}
	public Empresa getEmpresaPerteneciente() {
		return EmpresaPerteneciente;
	}
	public void setEmpresaPerteneciente(Empresa empresaPerteneciente) {
		EmpresaPerteneciente = empresaPerteneciente;
	}
	public Oferta(String numeroId, float salario, int cantCandidatos, Rama rama,Empresa empresa) {
		setNumeroId(numeroId);
		setSalario(salario);
		setCantCandidatos(cantCandidatos);
		setRama(rama);
		setEmpresaPerteneciente(empresa);
		listaCandidatos=new ArrayList<Candidato>();
	}
	public String getNumeroId() {
		return numeroId;
	}
	public void setNumeroId(String numeroId) {
		if(numeroId!=null)
			this.numeroId = numeroId;
		else 
			throw new IllegalArgumentException("No puede estar vacio");
	}
	public float getSalario() {
		return salario;
	}
	public void setSalario(float salario) {
		if(salario>0 && salario<1000000)
			this.salario=salario;
		else 
			throw new IllegalArgumentException("El valor esta fuera de rango");
	}
	public void setCantCandidatos(int cantCandidatos) {
		if(cantCandidatos>0 && cantCandidatos<100)
			this.cantCandidatos=cantCandidatos;
		else 
			throw new IllegalArgumentException("El valor esta fuera de rango");
	}
	public int getCantCandidatos() {
		return cantCandidatos;
	}
	public ArrayList<Candidato> getListaCandidatos() {
		return listaCandidatos;
	}
	public void setListaCandidatos(ArrayList<Candidato> listaCandidatos) {
		this.listaCandidatos = listaCandidatos;
	}
	public Rama getRama() {
		return rama;
	}
	public void setRama(Rama rama) {
		this.rama = rama;
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
			throw new YaExisteExceptions("Este Candidato ya esta en esta Oferta");
	}
	
	
	
	
}
