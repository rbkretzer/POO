package com.poo.lista2.exe1;

public class Contribuinte {
	
	private String nome;
	private String cpf;
	private String uf;
	private double rendaAnual;
	
	public Contribuinte(String nome, String cpf, String uf, double rendaAnual) {
		this.nome = nome;
		this.cpf = cpf;
		this.uf = uf;
		this.rendaAnual = rendaAnual;
	}
	
	public Contribuinte() {
		
	}
	
	public String getNome() {
		return this.nome;
	}
	
	public String getCpf() {
		return this.cpf;
	}
	
	public String getUf() {
		return this.uf;
	}
	
	public double getRendaAnual() {
		return this.rendaAnual;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public void setCpf(String cpf) {
		this.cpf = cpf;
	}

	public void setUf(String uf) {
		if (uf.equals("SC") || uf.equals("PR") || uf.equals("RS"))
			this.uf = uf;
	}

	public void setRendaAnual(double rendaAnual) {
		if (rendaAnual <= 0) {
			return;
		}
		this.rendaAnual = rendaAnual;
	}
	
	public double getImpostoAPagar() {
		return this.rendaAnual * this.getAliquota();
	}
	
	private double getAliquota() {
		double aliquota = 0;
		if (this.rendaAnual > 35000) {
			aliquota = 0.3;
		} else if (this.rendaAnual > 25000) {
			aliquota = 0.275;
		} else if (this.rendaAnual > 9000) {
			aliquota = 0.15;
		} else if (this.rendaAnual > 4000) {
			aliquota = 0.058;
		}
		
		return aliquota;
	}
}
