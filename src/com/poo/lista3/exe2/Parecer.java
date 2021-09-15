package com.poo.lista3.exe2;

import java.time.LocalDate;

public class Parecer {
	private String nomeParecerista;
	private LocalDate data;
	private String conteudo;
	
	public Parecer(String nomeParecerista, LocalDate data, String conteudo) {
		this.nomeParecerista = nomeParecerista;
		this.data = data;
		this.conteudo = conteudo;
	}
	public String getNomeParecerista() {
		return nomeParecerista;
	}
	public void setNomeParecerista(String nomeParecerista) {
		this.nomeParecerista = nomeParecerista;
	}
	public LocalDate getData() {
		return data;
	}
	public void setData(LocalDate data) {
		this.data = data;
	}
	public String getConteudo() {
		return conteudo;
	}
	public void setConteudo(String conteudo) {
		this.conteudo = conteudo;
	}
}
