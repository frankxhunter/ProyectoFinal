package clase;

import java.util.ArrayList;
import java.util.Date;

import excepcionesPropias.YaExisteExceptions;

public class Entrevista implements Comparable<Entrevista> {
	private Date fecha; //Dia de la entrevista
	private ArrayList<Candidato> listaCandidatos;
	private Oferta oferta;
	
	public Entrevista(Date fecha,Candidato candidato,Oferta oferta){
		setFecha(fecha);
		listaCandidatos = new ArrayList<Candidato>();
		listaCandidatos.add(candidato);
		setOferta(oferta);
	}
	public Entrevista(Date Fecha,Oferta oferta){
		setFecha(Fecha);
		setOferta(oferta);
		listaCandidatos= new ArrayList<Candidato>();
	}
	public Oferta getOferta() {
		return oferta;
	}
	public void setOferta(Oferta oferta) {
		this.oferta = oferta;
	}
	public Date getFecha() {
		return fecha;
	}
	public void setFecha(Date fecha) {
		this.fecha = fecha;
	}
	public ArrayList<Candidato> getListaCandidatos() {
		return listaCandidatos;
	}
	public void setListaCandidatos(ArrayList<Candidato> listaCandidatos) {
		this.listaCandidatos = listaCandidatos;
	}
	@SuppressWarnings("deprecation")
	public int compareTo(Entrevista o) {
		int out=0;
		if(o.getFecha().getDate()>fecha.getDate())
			out=-1;
		else if(o.getFecha().getDate()<fecha.getDate())
			out=1;
		return out;
	}
	@SuppressWarnings("deprecation")
	public boolean mismoDia(Entrevista e){
		boolean out=false;
		if(fecha.getYear()==e.getFecha().getYear())
			if(fecha.getMonth()==e.getFecha().getMonth())
				if(fecha.getDate()==e.getFecha().getDate())
					out=true;
		return out;
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
			throw new YaExisteExceptions("Este Candidato ya esta en esta entrevista");
	}
	
	


}
