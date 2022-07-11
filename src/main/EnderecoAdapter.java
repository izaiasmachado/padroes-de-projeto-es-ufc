package main;

import java.io.BufferedReader;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.URL;
import java.net.URLConnection;
import java.util.Map;
import java.util.stream.Stream;

public class EnderecoAdapter extends Endereco {    
	public EnderecoAdapter() {
		
	}
	
	public void setCep(String cep) {
		super.setCep(cep);

		String json = this.buscarCep(cep);
		this.setDados(json);
	}
	
	private void setDados(String json) {		
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
	
    public String buscarCep(String cep) {
        String json;

        try {
            URL url = new URL("http://viacep.com.br/ws/" + cep + "/json");
            URLConnection urlConnection = url.openConnection();
            InputStream is = urlConnection.getInputStream();
            BufferedReader br = new BufferedReader(new InputStreamReader(is));

            StringBuilder jsonSb = new StringBuilder();

            Stream<String> lines = br.lines();
            lines.forEach(line -> jsonSb.append(line.trim()));
          
            json = jsonSb.toString();
            
        } catch (Exception e) {
            throw new RuntimeException(e);
        }

        return json;
    }	
}
