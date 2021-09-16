package com.poo.lista3.exe3;

import java.time.LocalTime;

public class Compromisso {
	
	private LocalTime hora;
	private String descricao;
	private int tempo;
	private char prioridade;
	
	public Compromisso(LocalTime hora, String descricao, int tempo, char prioridade) {
		this.hora = hora;
		this.descricao = descricao;
		this.tempo = tempo;
		this.prioridade = prioridade;
	}
	
	public LocalTime getHora() {
		return hora;
	}
	
	public void setHora(LocalTime hora) {
		this.hora = hora;
	}
	
	public String getDescricao() {
		return descricao;
	}
	
	public void setDescricao(String descricao) {
		this.descricao = descricao;
	}
	
	public int getTempo() {
		return tempo;
	}
	
	public void setTempo(int tempo) {
		this.tempo = tempo;
	}
	
	public char getPrioridade() {
		return prioridade;
	}
	
	public void setPrioridade(char prioridade) {
		this.prioridade = prioridade;
	}

	public String exibir() {
		return "-------Compromisso " + this.hora + "-------"
				+ "\nDescrição: " + this.descricao
				+ "\nTempo: " + this.tempo
				+ "\nPrioridade: " + this.prioridade;
	}
	
}
