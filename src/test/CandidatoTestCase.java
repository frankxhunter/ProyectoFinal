package test;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;
import static org.junit.Assert.fail;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import clase.Candidato;
import clase.Oferta;
import clase.Rama;
import excepcionesPropias.YaExisteExceptions;

public class CandidatoTestCase {
    private Candidato  x;
    private Rama rama;
	@Before
	public void setUp() throws Exception {
		 rama=new Rama("Limpieza");
		x= new Candidato("897", "1", "1", "1", "1", "1", "1", 10, rama);
		x.addDocumento("Carnet ID");

	}
	@After
	public void tearDown() throws Exception {
		x=null;
	}

	@Test
	public void testAddDocumeto() {
		try{
		String documento1="Carnet ID";
		String documento2="Pasaporte";
		 x.addDocumento(documento2);
	    x.addDocumento(documento1);
		fail("Not yet implemented");

		}catch(YaExisteExceptions e){			
		}
	}
	@Test
	public void testVerificarSiCumpleOferta(){
		//Prueba de Condiciones
		Oferta oferta=new Oferta("12345", 1000, 2, rama, null);
		Oferta oferta2=new Oferta("123", 33333, 1, new Rama("hola"), null);
		Oferta oferta3=new Oferta("12345", 1000, 2, rama, null);
		oferta3.getListaCandidatos().add(x);

		assertFalse(x.verificarSiCumpleOferta(oferta2));
		assertTrue(x.verificarSiCumpleOferta(oferta));
		assertFalse(x.verificarSiCumpleOferta(oferta3));
	}
	@Test
	public void testCandidato(){
		try {
			//Todo bien
			Candidato candidato1= new Candidato("12345678910", "Juan", "Masculino", "calle14",
					"5465357", "12 grado", "Ninguna", 3, null);
			//Se lanza exception
			Candidato candidato2= new Candidato("12345678910", null, "Masculino", "calle14",
					"5465357", "12 grado", "Ninguna", 3, null);
			fail("Not yet implemented");
		}catch(IllegalArgumentException e){
			
		}
	}

}
