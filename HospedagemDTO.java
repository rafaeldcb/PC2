package br.com.prog2.bancodedados;

public class HospedagemDTO {

	private Integer id_hospedagem;
	private Integer id_chale;
	private String estado;
	private String dataInicio;
	private String dataFinal;
	private Integer qtdPessoas;
	private Integer desconto;
	private Double valorFinal;
	private Integer diarias; 
	
	
	public Integer getId_hospedagem() {
		return id_hospedagem;
	}
	public void setId_hospedagem(Integer id_hospedagem) {
		this.id_hospedagem = id_hospedagem;
	}
	public Integer getId_chale() {
		return id_chale;
	}
	public void setId_chale(Integer id_chale) {
		this.id_chale = id_chale;
	}
	public Integer getDiarias() {
		return diarias;
	}
	public void setDiarias(Integer diarias) {
		this.diarias = diarias;
	}
	public String getEstado() {
		return estado;
	}
	public void setEstado(String estado) {
		this.estado = estado;
	}
	public String getDataInicio() {
		return dataInicio;
	}
	public void setDataInicio(String dataInicio) {
		this.dataInicio = dataInicio;
	}
	public String getDataFinal() {
		return dataFinal;
	}
	public void setDataFinal(String dataFinal) {
		this.dataFinal = dataFinal;
	}
	public Integer getQtdPessoas() {
		return qtdPessoas;
	}
	public void setQtdPessoas(Integer qtdPessoas) {
		this.qtdPessoas = qtdPessoas;
	}
	public Integer getDesconto() {
		return desconto;
	}
	public void setDesconto(Integer desconto) {
		this.desconto = desconto;
	}
	public Double getValorFinal() {
		return valorFinal;
	}
	public void setValorFinal(Double valorFinal) {
		this.valorFinal = valorFinal;
	}
	
}
