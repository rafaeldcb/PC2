package br.com.prog2.bancodedados;

public class PessoaDTO {
	
	private Integer id;
	private String nome;
	private String rg;
	private String endereco;
	private String bairro;
	private String cidade;
	private String estado;
	private String cep;
	private String dataDeNascimento;
	
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	
	public String getNome() {
		return nome;
	}
	public void setNome(String nome) {
		this.nome = nome;
	}
	public String getRg() {
		return rg;
	}
	public void setRg(String rg) {
		this.rg = rg;
	}
	public String getEndereco() {
		return endereco;
	}
	public void setEndereco(String endereco) {
		this.endereco = endereco;
	}
	public String getBairro() {
		return bairro;
	}
	public void setBairro(String bairro) {
		this.bairro = bairro;
	}
	public String getCidade() {
		return cidade;
	}
	public void setCidade(String cidade) {
		this.cidade = cidade;
	}
	public String getEstado() {
		return estado;
	}
	public void setEstado(String estado) {
		this.estado = estado;
	}
	public String getCep() {
		return cep;
	}
	public void setCep(String cep) {
		this.cep = cep;
	}
	public String getDataDeNascimento() {
		return dataDeNascimento;
	}
	public void setDataDeNascimento(String dataDeNascimento) {
		this.dataDeNascimento = dataDeNascimento;
	}
	
	@Override
	public String toString() {
		
		return "Codigo do Cliente" + "                                        "  + "Nome" + "   "
				+ "                                   " + "RG"+"                            " + "Endereço" + "  "
						+ "                                                   "  + "Bairro" + "               "
								+ "                           "  + "Cidade"  + "                      "
										+ "            " + "Estado"  + "            " + "CEP" + "     "
												+ "         "  + "Data de Nascimento" + "\n" +
			"\n"+	id +"                                       | "+ nome + "      | " + rg + "    "
					+ "  | "  + endereco  + "      | " + bairro + "        "
							+ "          | "  + cidade + "                     "
									+ "      | "  + estado  + "          | " + cep + "    "
											+ "     | "  + dataDeNascimento + "\n";  
	}


}
