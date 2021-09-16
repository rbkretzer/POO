package com.poo.lista3.exe3;

import java.time.LocalDate;
import java.time.LocalTime;
import java.util.ArrayList;
import java.util.HashMap;

public class DataAgenda {
	
	private LocalDate data;
	private String efemeride;
	private HashMap<LocalTime, Compromisso> compromissos;
	
	public LocalDate getData() {
		return data;
	}
	
	public void setData(LocalDate data) {
		this.data = data;
	}
	
	public String getEfemeride() {
		return efemeride;
	}
	
	public void setEfemeride(String efemeride) {
		this.efemeride = efemeride;
	}
	
	public HashMap<LocalTime, Compromisso> getCompromissos() {
		return compromissos;
	}
	
	public int getTempoMedio() {
		int total = 0;
		for (Compromisso c : this.compromissos.values()) {
			total += c.getTempo();
		}
		return total / compromissos.size();
	}
	
	public boolean addCompromisso(Compromisso c) {
		if (c == null || this.compromissos.get(c.getHora()) != null) {
			return false;
		}
		this.compromissos.put(c.getHora(), c);
		return true;
	}

	public ArrayList<Compromisso> getCompromissosPrioridade(char prioridade) {
		ArrayList<Compromisso> compromissos = new ArrayList<>();
		for (Compromisso c : this.compromissos.values()) {
			if (c.getPrioridade() == prioridade) {
				compromissos.add(c);
			}
		}
		return compromissos;
	}
	
	public int getQtdCompromissosPrioridade(char prioridade) {
		int qtdCompromissos = 0;
		for (Compromisso c : this.compromissos.values()) {
			if (c.getPrioridade() == prioridade) {
				qtdCompromissos++;
			}
		}
		return qtdCompromissos;
	}
	
}
