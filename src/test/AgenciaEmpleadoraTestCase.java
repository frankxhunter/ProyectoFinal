package test;

import junit.framework.TestCase;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import clase.AgenciaEmpleadora;

public class AgenciaEmpleadoraTestCase extends TestCase {
	private AgenciaEmpleadora x;
	@Before
	public void setUp() throws Exception {
		x=AgenciaEmpleadora.getInstancia();
	}

	@After
	public void tearDown() throws Exception {
		x=null;
	}

	@Test
	public void test() {
		assertEquals(null, x.obtenerEntrevista(2023,2));
		

	}

}
