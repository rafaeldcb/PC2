package br.com.prog2.bancodedados;

public class ChaleDTO {
	private Integer id_chale;
	private String localizacao;
	private Integer capacidade;
	private Double valorAltaTemporada;
	private Double valorBaixaTemporada;
	
	
	public Integer getCapacidade() {
		return capacidade;
	}
	public void setCapacidade(Integer capacidade) {
		this.capacidade = capacidade;
	}
	public Integer getId_chale() {
		return id_chale;
	}
	public void setId_chale(Integer id_chale) {
		this.id_chale = id_chale;
	}
	public String getLocalizacao() {
		return localizacao;
	}
	public void setLocalizacao(String localizacao) {
		this.localizacao = localizacao;
	}
	public Double getValorAltaTemporada() {
		return valorAltaTemporada;
	}
	public void setValorAltaTemporada(Double valorAltaTemporada) {
		this.valorAltaTemporada = valorAltaTemporada;
	}
	public Double getValorBaixaTemporada() {
		return valorBaixaTemporada;
	}
	public void setValorBaixaTemporada(Double valorBaixaTemporada) {
		this.valorBaixaTemporada = valorBaixaTemporada;
	}

}
