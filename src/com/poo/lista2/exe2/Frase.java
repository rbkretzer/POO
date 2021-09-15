package com.poo.lista2.exe2;

public class Frase {
	
	public Frase(String frase) {
		super();
		this.frase = frase;
	}

	private String frase;

	public String getFrase() {
		return frase;
	}

	public void setFrase(String frase) {
		this.frase = frase;
	}
	
	public String[] separarFrase() {
		return this.frase.split(" ");
	}
	
}
