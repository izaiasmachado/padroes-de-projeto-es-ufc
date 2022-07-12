public enum EstadoPedido {
	Admitido {
		public EstadoPedido proximoEstado() {
			return Carregamento;
		}
		public EstadoPedido estadoAnterior() {
			return Admitido;
		}
	},
	Carregamento {
		public EstadoPedido proximoEstado() {
			return Transporte;
		}
		public EstadoPedido estadoAnterior() {
			return Admitido;
		}
	},
	Transporte {
		public EstadoPedido proximoEstado() {
			return Entregue;
		}
		public EstadoPedido estadoAnterior() {
			return Carregamento;
		}
	},
	Entregue {
		public EstadoPedido proximoEstado() {
			return Entregue;
		}
		public EstadoPedido estadoAnterior() {
			return Transporte;
		}
	};
	
    public abstract EstadoPedido proximoEstado();
    public abstract EstadoPedido estadoAnterior();
}