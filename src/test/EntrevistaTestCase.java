package test;

import static org.junit.Assert.*;

import java.sql.Date;

import org.junit.*;

import clase.Candidato;
import clase.Entrevista;
import excepcionesPropias.YaExisteExceptions;

public class EntrevistaTestCase {
	private Entrevista x;
	@Before
	public void setUp() throws Exception {
		x=new Entrevista(new Date(123, 2, 12), null);


	}
	@After
	public void tearDown() throws Exception {
		x=null;
	}
	@Test
	public void testAddCandidato(){
		Candidato candidato=new Candidato();
		candidato.setCarnet("1234");
		Candidato candidato2=new Candidato();
		candidato2.setCarnet("122234");
		Candidato candidato3=new Candidato();
		candidato3.setCarnet("32323");
		Candidato candidato4=new Candidato();
		candidato4.setCarnet("6452");
		x.getListaCandidatos().add(candidato4);
		try{
			//Todo bien
			x.addCandidato(candidato);
			//Todo bien
			x.addCandidato(candidato2);
			//Todo bien
			x.addCandidato(candidato3);
			//Se lanza la exception
			x.addCandidato(candidato4);
			fail("Not yet implemented");
		}catch(YaExisteExceptions e){
		}
	}
	@SuppressWarnings("deprecation")
	@Test
	public void testMismoDia(){
		Date d=new Date(123, 2, 12);
		Date d2=new Date(124, 2, 12);
		Date d3=new Date(123, 3, 12);
		Date d4=new Date(123, 2, 13);
		assertFalse(x.mismoDia(d4));
		assertFalse(x.mismoDia(d3));
		assertFalse(x.mismoDia(d2));
		assertTrue(x.mismoDia(d));
		
		
	}
}