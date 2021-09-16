package com.poo.lista3.exe3;

import java.time.LocalDate;
import java.util.HashMap;

public class Agenda {
	
	private HashMap<LocalDate,DataAgenda> datasAgenda;
	
	public Compromisso getMenorCompromisso() {
		if (datasAgenda.isEmpty()) {
			return null;
		}
		int menorTempo = Integer.MAX_VALUE;
		Compromisso menorCompromisso = null;
		for (DataAgenda da: this.datasAgenda.values()) {
			for (Compromisso c : da.getCompromissos().values()) {
				if (c.getTempo() < menorTempo) {
					menorCompromisso = c;
					menorTempo = c.getTempo();
				}
			}
		}
		return menorCompromisso;
	}
	
	public void addDataAgenda(DataAgenda dataAgenda) {
		if (dataAgenda != null && !dataFoiAdicionada(dataAgenda.getData())) {			
			this.datasAgenda.put(dataAgenda.getData(), dataAgenda);
		}
	}
	
	public boolean dataFoiAdicionada(LocalDate data) {
		return this.datasAgenda.get(data) != null;
	}

	public HashMap<LocalDate, DataAgenda> getDatasAgenda() {
		return datasAgenda;
	}

	public DataAgenda busca(LocalDate dataDigitada) {
		return datasAgenda.get(dataDigitada);
	}
	
}
