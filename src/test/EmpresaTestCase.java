package test;

import static org.junit.Assert.*;

import java.sql.Date;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import clase.Candidato;
import clase.Empresa;
import clase.Entrevista;
import clase.Oferta;
import excepcionesPropias.YaExisteExceptions;

public class EmpresaTestCase {
	private Empresa x;
	@Before
	public void setUp() throws Exception {
		x=new Empresa("Empresa", "23432", "234", null);


	}
	@After
	public void tearDown() throws Exception {
		x=null;
	}
	@Test
	public void testaddOferta(){
		x.getListaOfertas().add(new Oferta("1234", 222, 2, null, null));
		Oferta oferta = new Oferta("1234", 4, 5, null, null);
		Oferta oferta2 = new Oferta("2134", 4, 5, null, null);
		Oferta oferta3 = new Oferta("4321", 4, 5, null, null);
		try{
			//Todo bien
			x.addOferta(oferta3);
			//Todo bien
			x.addOferta(oferta2);
			//Lanza la exception
			x.addOferta(oferta);
			fail("Not yet implemented");

		}catch(YaExisteExceptions e){
		}
	}
	@SuppressWarnings("deprecation")
	@Test
	public void testVerificarSiCandidatoTieneEntrevista(){
		Entrevista entrevista=new Entrevista(new Date(123,1,21), null);
		Candidato candidato=new Candidato();
		entrevista.getListaCandidatos().add(candidato);
		x.getListaEntrevistas().add(entrevista);
		assertFalse(x.verificaSiCandidatoTieneEntrevista(new Date(123,2,21), candidato));
		assertTrue(x.verificaSiCandidatoTieneEntrevista(new Date(123,1,21), candidato));
		assertFalse(x.verificaSiCandidatoTieneEntrevista(new Date(123,2,21), new Candidato()));
		
	}
}
