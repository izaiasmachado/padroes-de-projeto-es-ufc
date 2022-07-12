import static org.junit.Assert.*;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

public class EstadoPedidoTest {
	EstadoPedido estado;

	@Before
	public void setUp() throws Exception {
	}

	@After
	public void tearDown() throws Exception {
	}
	
	@Test
	public void testAdmitido() {
		estado = EstadoPedido.Admitido;
		estado = estado.proximoEstado();
		assertEquals(estado, EstadoPedido.Carregamento);
		
		estado = EstadoPedido.Admitido;
		estado = estado.estadoAnterior();
		assertEquals(estado, EstadoPedido.Admitido);
	}
	
	@Test
	public void testCarregamento() {
		estado = EstadoPedido.Carregamento;
		estado = estado.proximoEstado();
		assertEquals(estado, EstadoPedido.Transporte);
		
		estado = EstadoPedido.Carregamento;
		estado = estado.estadoAnterior();
		assertEquals(estado, EstadoPedido.Admitido);
	}
	
	@Test
	public void testTransporte() {
		estado = EstadoPedido.Transporte;
		estado = estado.proximoEstado();
		assertEquals(estado, EstadoPedido.Entregue);
		
		estado = EstadoPedido.Transporte;
		estado = estado.estadoAnterior();
		assertEquals(estado, EstadoPedido.Carregamento);
	}
	
	@Test
	public void testEntregue() {
		estado = EstadoPedido.Entregue;
		estado = estado.proximoEstado();
		assertEquals(estado, EstadoPedido.Entregue);
		
		estado = EstadoPedido.Entregue;
		estado = estado.estadoAnterior();
		assertEquals(estado, EstadoPedido.Transporte);
	}
}
