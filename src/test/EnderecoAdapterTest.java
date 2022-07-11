package test;

import static org.junit.Assert.*;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import main.Endereco;
import main.EnderecoAdapter;

public class EnderecoAdapterTest {
	EnderecoAdapter endereco;

	@Before
	public void setUp() throws Exception {
		this.endereco = new EnderecoAdapter();
	}

	@After
	public void tearDown() throws Exception {
	}

	@Test
	public void buscaCepTest() {
		
	}

}
