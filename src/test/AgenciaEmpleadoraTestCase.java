package test;

import junit.framework.TestCase;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import util.MetodosUtiles;
import clase.AgenciaEmpleadora;
import clase.Candidato;
import clase.Rama;

public class AgenciaEmpleadoraTestCase extends TestCase {
	private AgenciaEmpleadora x;
	@Before
	public void setUp() throws Exception {
		x= AgenciaEmpleadora.CrearInstancia("lkasjflksa");
		x=AgenciaEmpleadora.getInstancia();
	}
	
	public void testBuscarCand(){
		String id1=null;
		String id2="21321";
		String id3 ="34567";
		Candidato candidato= new Candidato(id2, "1", "1", "1", "1", "1", "1", 10, new Rama());
		x.addCandidato(candidato);
		assertEquals(null, x.buscarCandidato(id1));
		assertEquals(candidato, x.buscarCandidato(id2));
		assertEquals(null, x.buscarCandidato(id3));
	}

	@After
	public void tearDown() throws Exception {
		x=null;
	}


}
