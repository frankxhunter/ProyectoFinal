package test;

import static org.junit.Assert.*;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import clase.Candidato;
import clase.Oferta;
import excepcionesPropias.YaExisteExceptions;

public class OfertaTestCase {
	private Oferta x;
	@Before
	public void setUp() throws Exception {
		x=new Oferta("23145", 23, 43, null, null);


	}
	@After
	public void tearDown() throws Exception {
		x=null;
	}
	@Test
	public void testAddCandidato(){
		Candidato candidato=new Candidato();
		candidato.setCarnet("575");
		Candidato candidato2=new Candidato();
		candidato2.setCarnet("789");
		Candidato candidato3=new Candidato();
		candidato3.setCarnet("123");
		x.getListaCandidatos().add(candidato);
		try{
			//Todo bien
			x.addCandidato(candidato);
			//Todo bien
			x.addCandidato(candidato2);
			//Todo bien
			x.addCandidato(candidato3);
			//Se lanza la exception
			x.addCandidato(candidato);
			fail("Not yet implemented");
		}catch(YaExisteExceptions e){
		}
	}
	@Test
	public void testgetID(){
		String id="23145";
		String id2="23165";
		String id3="23175";
		assertEquals(id, x.getNumeroId());
		assertNotEquals(id2, x.getNumeroId());
		assertNotEquals(id3, x.getNumeroId());
	}
	@Test
	public void testOferta(){
		try{
		Oferta oferta = new Oferta("12345", 234, 2, null,null);
		Oferta oferta2 = new Oferta(null, 234, 2, null,null);
		fail("Not yet implemented");
		}catch(IllegalArgumentException e){
			
		}
	}
}