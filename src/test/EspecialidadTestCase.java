package test;

import static org.junit.Assert.fail;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import clase.Especialidad;
import clase.Rama;
import clase.Sector;

public class EspecialidadTestCase {
	@Before
	public void setUp() throws Exception {
	}
	@After
	public void tearDown() throws Exception {
	}

	@Test
	public void testEntrevistaRama(){
		try{
			Especialidad rama1= new Rama("Limpieza");
			Especialidad rama2= new Rama(null);
			fail("Not yet implemented");
		}catch(IllegalArgumentException e){
		}
	}
	@Test
	public void testEntrevistaSector(){
		try{
			Especialidad sector= new Sector("Transporte");
			Especialidad sector2= new Sector(null);
			fail("Not yet implemented");
		}catch(IllegalArgumentException e){
		}
	}
}