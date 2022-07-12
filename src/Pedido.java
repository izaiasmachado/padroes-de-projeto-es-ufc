import java.util.UUID;

public class Pedido {
	public final UUID uuid = UUID.randomUUID();
	Endereco origem = null;
	Endereco destino = null;
	String dimensoes = "";
	String peso = "";
	String descricao = "";
	EstadoPedido estado;
	
	public Endereco getOrigem() {
		return origem;
	}
	
	public void setOrigem(Endereco origem) {
		this.origem = origem;
	}
	
	public Endereco getDestino() {
		return destino;
	}
	
	public void setDestino(Endereco destino) {
		this.destino = destino;
	}
	
	public String getDimensoes() {
		return dimensoes;
	}
	
	public void setDimensoes(String dimensoes) {
		this.dimensoes = dimensoes;
	}
	
	public String getPeso() {
		return peso;
	}
	
	public void setPeso(String peso) {
		this.peso = peso;
	}
	
	public String getDescricao() {
		return descricao;
	}
	
	public void setDescricao(String descricao) {
		this.descricao = descricao;
	}
	
	public EstadoPedido getEstado() {
		return this.estado;
	}
	
	public void proximoEstado() {
		estado = estado.proximoEstado();
	}
	
	public void estadoAnterior() {
		estado = estado.estadoAnterior();
	}
	
	public String toString() {
        return "Pedido {\n" +
                "\tuuid=\"" + uuid + "\"\n" +
                "\tdescricao=\"" + descricao + "\"\n" +
                "\tdimensoes=\"" + dimensoes + "\"\n" +
                "\tpeso =\"" + peso + "\"\n" +
                "}";
    }
}
