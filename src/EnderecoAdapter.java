import java.util.Map;

public class EnderecoAdapter extends Endereco {    
	public EnderecoAdapter() {
		
	}
	
	public void setCep(String cep) {
		super.setCep(cep);
		String json = ViaCep.buscarCep(cep);
		this.setDados(json);
	}
	
	public void setDados(String json) {		
        Map<String,String> mapa = Util.fromJsonToMap(json);
        
        String rua = mapa.get("logradouro");
        String bairro = mapa.get("bairro");
        String cidade = mapa.get("localidade");
        String uf = mapa.get("uf");
        
        this.setRua(rua);
        this.setBairro(bairro);
        this.setCidade(cidade);
        this.setUf(uf);
    }
}
