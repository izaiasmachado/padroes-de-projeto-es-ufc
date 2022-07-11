package test;

import static org.junit.Assert.*;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import main.Main;

public class testMain {
	
	@Before
	public void setUp() throws Exception {
	}

	@After
	public void tearDown() throws Exception {
	}

	@Test
	public void testeDeveriaRetornarHelloDaTransportadora() {
		assertEquals(Main.hello(), "Hello Transportadora");
	}
}
