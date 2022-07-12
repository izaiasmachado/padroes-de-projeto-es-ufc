package main;

import java.util.UUID;
import java.util.stream.Stream;

public class Endereco implements InterfaceEndereco {
	public final UUID uuid = UUID.randomUUID();
	private String cep = "";
	private String numero = "";
	private String rua = "";
	private String bairro = "";
	private String cidade = "";
	private String uf = "";
	private String complemento = "";
	
	public Endereco () {
	}
	
	public String getCep() {
		return this.cep;
	}
	
	public void setCep(String cep) {
		if (!cep.matches("\\d{8}")) {
            throw new IllegalArgumentException("cep inválido");
        }
		
		this.cep = cep;			
	}
	
    public String getNumero() {
    	return this.numero;
	}

	public void setNumero(String numero) {
		try {
			Integer.parseInt(numero);
			this.numero = numero;		
		} catch (NumberFormatException e) {
			throw e;
		}
	}

	public String getRua() {
		return rua;
	}

	public void setRua(String rua) {
		this.rua = rua;
	}

	public String getBairro() {
		return this.bairro;
	}

	public void setBairro(String bairro) {
		this.bairro = bairro;
	}

	public String getCidade() {
		return this.cidade;
	}

	public void setCidade(String cidade) {
		this.cidade = cidade;
	}

	public String getUf() {
		return this.uf;
	}

	public void setUf(String uf) {
		String UFs[] = { "AC", "AL", "AP", "AM", "BA", "CE", "DF", "ES", "GO", "MA", "MS", "MT", "MG", "PA", "PB", "PR", "PE", "PI", "RJ", "RN", "RS", "RO", "RR", "SC", "SP", "SE", "TO" };
		boolean contains = java.util.Arrays.asList(UFs).indexOf(uf) != -1;

		if (!contains) {
            throw new IllegalArgumentException("UF inválido");
		}
	
		this.uf = uf;
	}

	public String getComplemento() {
		return this.complemento;
	}

	public void setComplemento(String complemento) {
		this.complemento = complemento;
	}

	public String toString() {
        return "Endereco {\n" +
                "\tuuid=\"" + uuid + "\"\n" +
                "\trua=\"" + rua + "\"\n" +
                "\tnumero=\"" + numero + "\"\n" +
                "\tcomplemento=\"" + complemento + "\"\n" +
                "\tbairro=\"" + bairro + "\"\n" +
                "\tcidade=\"" + cidade + "\"\n" +
                "\tcep=\"" + cep + "\"\n" +
                "\tUF=\"" + uf + "\"\n" +
                "}";
    }
}
