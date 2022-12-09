package test;

import static org.junit.Assert.fail;
import junit.framework.TestCase;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import util.MetodosUtiles;
import clase.AgenciaEmpleadora;
import clase.Candidato;
import clase.Empresa;
import clase.Rama;
import excepcionesPropias.YaExisteExceptions;

public class AgenciaEmpleadoraTestCase extends TestCase {
	private AgenciaEmpleadora x;
	@Before
	public void setUp() throws Exception {
		AgenciaEmpleadora.CrearInstancia("Agencia Cubana");
		x=AgenciaEmpleadora.getInstancia();
	}
	
	public void testBuscarCand(){
		String id1=null;
		String id2="21321";
		String id3 ="34567";
		Candidato candidato= new Candidato(id2, "1", "1", "1", "1", "1", "1", 10, new Rama());
		x.getListaCandidatos().add(candidato);
		assertEquals(null, x.buscarCandidato(id1));
		assertEquals(candidato, x.buscarCandidato(id2));
		assertEquals(null, x.buscarCandidato(id3));
	}
	public void testAddEmpresa(){
		x.getListaEmpresas().add(new Empresa("Empresa1", "23423432", "45345678", null));
		Empresa empresa1=new Empresa("Empresa1", "234", "23432432", null);
		Empresa empresa2=new Empresa("Empresa2", "234354", "234324", null);
		Empresa empresa3=new Empresa("Empresa3", "2324", "2343243232", null);
		try{
			x.addEmpresa(empresa2);
			//Todo bien
			x.addEmpresa(empresa3);
			//Todo bien
			x.addEmpresa(empresa1);
			//Aqui lanza la exception
			fail("Not yet implemented");
		}catch(YaExisteExceptions e){
			
		}
	}

	@After
	public void tearDown() throws Exception {
		x=null;
	}


}
