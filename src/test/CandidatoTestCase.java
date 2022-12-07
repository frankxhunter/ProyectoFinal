package test;

import static org.junit.Assert.*;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import clase.Candidato;
import clase.Rama;
import excepcionesPropias.YaExisteExceptions;

public class CandidatoTestCase {
    private Candidato  x;
	@Before
	public void setUp() throws Exception {
		x= new Candidato("897", "1", "1", "1", "1", "1", "1", 10, new Rama());
		x.addDocumento("La pinga");

	}

	@After
	public void tearDown() throws Exception {
		x=null;
	}

	@Test
	public void test() {
		try{
		String documento1="La pinga";
	    x.addDocumento(documento1);
		fail("Not yet implemented");

		}catch(YaExisteExceptions e){			
//		   assertEquals(e.getMessage(), e.getMessage());
		}
	}

}
