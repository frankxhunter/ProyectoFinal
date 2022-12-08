package clase;

import java.util.ArrayList;

public class Rama extends Especialidad implements Comparable<Rama>{

	public Rama(String nombre, ArrayList<Documento> listaCondiciones) {
		super(nombre, listaCondiciones);
	}
	public Rama(){
		super();
	}
	public Rama(String string) {
		super(string);
	}
	public int contarSolicitudes(){
		int cant=0;
		for(Candidato x: AgenciaEmpleadora.getInstancia().getListaCandidatos())
			if(x.getRama().equals(this))
				cant++;
		return cant;
	}
	public int compareTo(Rama o) {
		int out=0;
		if(contarSolicitudes()<o.contarSolicitudes())
			out=1;
		else if(contarSolicitudes()>o.contarSolicitudes())
			out=-1;
		return out;
	}

}
