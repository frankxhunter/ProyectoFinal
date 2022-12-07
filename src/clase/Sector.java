package clase;

import java.util.ArrayList;

public class Sector extends Especialidad{

	public Sector(String nombre, ArrayList<Documento> listaCondiciones) {
		super(nombre, listaCondiciones);
	}
	public Sector(){
		super();
	}

	public Sector(String string) {
		super(string);
	}

}
