import java.util.HashSet;

public final class ListaPedido {
	private HashSet<Pedido> lista;
	private static ListaPedido instance = null;

	private ListaPedido () {
		lista = new HashSet<Pedido>();
	}
	
	public static ListaPedido getInstance() {
		if (instance == null) {
			instance = new ListaPedido();
		}
		return instance;
	}
	
	public void add(Pedido pedido) {
		lista.add(pedido);
	}
	
	public HashSet<Pedido> read() {
		return this.lista;
	}
	
	public void remove(Pedido pedido) {
		this.lista.remove(pedido);
	} 
	
	public void clear() {
		this.lista.clear();
	}
}
