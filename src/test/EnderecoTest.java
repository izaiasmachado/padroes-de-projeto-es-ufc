
package test;

import static org.junit.Assert.*;

import org.junit.After;
import org.junit.Before;
import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.ExpectedException;
import org.junit.runner.RunWith;
import main.*;


public class EnderecoTest {
	Endereco endereco;
	
	@Rule
	public final ExpectedException exception = ExpectedException.none();
	
	@Before
	public void setUp() throws Exception {
		this.endereco = new Endereco();
	}

	@After
	public void tearDown() throws Exception {
	}

	@Test
	public void cepInvalidoTest() {
	    exception.expect(IllegalArgumentException.class);
	    endereco.setCep("620");
	    assertTrue(endereco.getCep() == "");
	}
	
	@Test
	public void cepValidoTest() {
		String cep = "62011060";
	    
	    endereco.setCep(cep);
	    assertTrue(cep == endereco.getCep());
	}
	
	@Test
	public void ufInvalidoTest() {
	    exception.expect(IllegalArgumentException.class);
	    endereco.setUf("PP");
	    assertTrue(endereco.getUf() == "");
	}
	
	@Test
	public void ufValidoTest() {
		String uf = "CE";
	    
	    endereco.setUf(uf);
	    assertTrue(uf == endereco.getUf());
	}
	
	@Test
	public void numeroInvalidoTest() {
		exception.expect(NumberFormatException.class);
	    endereco.setNumero("123naoehnumero");
	    assertTrue(endereco.getNumero() == "");
	}
	
	@Test
	public void numeroValidoTest() {
		String numero = "123";
	    endereco.setNumero(numero);
	    assertTrue(endereco.getNumero() == numero);
	}
}
