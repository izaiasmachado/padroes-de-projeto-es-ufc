import static org.junit.Assert.*;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

public class ListaPedidoTest {
	ListaPedido lista;
	@Before
	public void setUp() throws Exception {
		lista = ListaPedido.getInstance();
	}

	@After
	public void tearDown() throws Exception {
		lista.clear();
	}

	@Test
	public void singletonListaTest() {
		ListaPedido outraLista = ListaPedido.getInstance();
		assertEquals(lista, outraLista);
	}
	
	@Test
	public void pedidosSaoUnicosTest() {
		Pedido pedido = new Pedido();
		Pedido outroPedido = new Pedido();

		ListaPedido lista = ListaPedido.getInstance();
		lista.add(pedido);
		lista.add(pedido);
		lista.add(outroPedido);
		lista.add(pedido);
		
		int count = 0;		
		for (Pedido p : lista.read()) {
			count++;
		}
		System.out.println(count);
		assertTrue(count == 2);
	}
	
	@Test
	public void removePedidoTest() {
		Pedido pedido = new Pedido();
		Pedido outroPedido = new Pedido();

		ListaPedido lista = ListaPedido.getInstance();
		lista.add(pedido);
		lista.add(pedido);
		lista.add(outroPedido);
		lista.add(pedido);
		lista.remove(pedido);
		
		boolean found = false;
		for (Pedido p : lista.read()) {
			if (p == pedido) found = true;
		}
		
		assertFalse(found);
	}

}
