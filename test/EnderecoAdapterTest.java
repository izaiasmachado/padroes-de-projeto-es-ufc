import static org.junit.Assert.*;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

public class EnderecoAdapterTest {
	ViaCep service;
	EnderecoAdapter endereco;
	
	@Before
	public void setUp() throws Exception {
		this.endereco = new EnderecoAdapter();
	}

	@After
	public void tearDown() throws Exception {
	}
	
	@Test
	public void setDadosTest() throws Exception {
		String json = "{\"cep\": \"98802-630\",\"logradouro\": \"Rua Daltro Filho\",\"complemento\": \"de 1821/1822 ao fim\",\"bairro\": \"Centro\",\"localidade\": \"Santo Ângelo\",\"uf\": \"RS\",\"ibge\": \"4317509\",\"gia\": \"\",\"ddd\": \"55\",\"siafi\": \"8853\"}";
		// WhiteBox invoke deveria ser utilizado aqui
		endereco.setDados(json);
		assertEquals(endereco.getRua(), "Rua Daltro Filho");
		assertEquals(endereco.getNumero(), "");
		assertEquals(endereco.getComplemento(), "");
		assertEquals(endereco.getBairro(), "Centro");
		assertEquals(endereco.getCidade(), "Santo Ângelo");
		assertEquals(endereco.getCep(), "");
		assertEquals(endereco.getUf(), "RS");
	}
}