package com.anunciosapp.models;


import java.io.Serializable;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.validation.constraints.NotEmpty;

/** Classe que representa a tabela anúncio */
@Entity
public class Anuncio implements Serializable{
	
	private static final long serialVersionUID = 1L;
	
	@Id
	//@GeneratedValue(strategy= GenerationType.AUTO)
	@GeneratedValue
	private long codigo;

	@NotEmpty
	private String nome;
	@NotEmpty
	private String cliente;
	@NotEmpty
	private String dataInicio;
	@NotEmpty
	private String dataTermino;
	@NotEmpty
	private String investimentoDia;
	
	public long getCodigo() {
		return codigo;
	}
	public void setCodigo(long codigo) {
		this.codigo = codigo;
	}
	public String getNome() {
		return nome;
	}
	public void setNome(String nome) {
		this.nome = nome;
	}
	public String getCliente() {
		return cliente;
	}
	public void setCliente(String cliente) {
		this.cliente = cliente;
	}
	public String getDataInicio() {
		return dataInicio;
	}
	public void setDataInicio(String dataInicio) {
		this.dataInicio = dataInicio;
	}
	public String getDataTermino() {
		return dataTermino;
	}
	public void setDataTermino(String dataTermino) {
		this.dataTermino = dataTermino;
	}
	public String getInvestimentoDia() {
		return investimentoDia;
	}
	public void setInvestimentoDia(String investimentoDia) {
		this.investimentoDia = investimentoDia;
	}


	
	
	
	
}
