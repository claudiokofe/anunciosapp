package com.anunciosapp.models;


/** Classe para representar o Relatorio na tela */
public class Relatorio {

	private Anuncio anuncio;
	
	private String valorAlcance;
	private String totalCliques;
	private String totalCompartilhamentos;
	private String investimentoTotal ;
	
	
	public Anuncio getAnuncio() {
		return anuncio;
	}
	public void setAnuncio(Anuncio anuncio) {
		this.anuncio = anuncio;
	}
	public String getValorAlcance() {
		return valorAlcance;
	}
	public void setValorAlcance(String valorAlcance) {
		this.valorAlcance = valorAlcance;
	}
	public String getTotalCliques() {
		return totalCliques;
	}
	public void setTotalCliques(String totalCliques) {
		this.totalCliques = totalCliques;
	}
	public String getTotalCompartilhamentos() {
		return totalCompartilhamentos;
	}
	public void setTotalCompartilhamentos(String totalCompartilhamentos) {
		this.totalCompartilhamentos = totalCompartilhamentos;
	}
	public String getInvestimentoTotal() {
		return investimentoTotal;
	}
	public void setInvestimentoTotal(String investimentoTotal) {
		this.investimentoTotal = investimentoTotal;
	}
	
	
}
