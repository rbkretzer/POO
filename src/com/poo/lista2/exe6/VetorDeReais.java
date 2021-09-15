package com.poo.lista2.exe6;

public class VetorDeReais {
	private double[] vetorReais;
	
	public VetorDeReais(int tamanhoVetor) {
		this.vetorReais = new double[tamanhoVetor];
	}
	
	public double[] getVetor() {
		return this.vetorReais;
	}
	
	public void addValor(double valor, int pos) {
		if (pos < this.vetorReais.length) {
			this.vetorReais[pos] = valor;
		}
	}
	
	public int countPairs() {
		int count = 0;
		for (int i = 0; i < this.vetorReais.length; i++) {
			String valorTexto = Double.toString(this.vetorReais[i]);
			int inteiro = Integer.parseInt(valorTexto.substring(0, valorTexto.indexOf(".")));
			if (inteiro % 2 == 0) count++;
		}
		return count;
	}
	
	public int getTamanho() {
		return this.vetorReais.length;
	}
	
	double temp;
	
	public VetorDeReais divide(VetorDeReais outro) {
		if (this.getTamanho() != outro.getTamanho()) {
			return null;
		}
		VetorDeReais vetorNovo = new VetorDeReais(this.getTamanho());
		for (int i = 0; i < this.vetorReais.length; i++) {
			temp = this.vetorReais[i] / outro.getValor(i);
			
			vetorNovo.addValor(temp, i);
		}
		return vetorNovo;
	}
	
	public double getValor(int pos) {
		return this.vetorReais[pos];
	}
	
	public double multiplicaVetores(VetorDeReais outro) {
		int tamanhoMenorVetor;
		int tamanhoVetor = this.vetorReais.length;
		int tamanhoOutroVetor = outro.getTamanho();
		if (tamanhoVetor >= tamanhoOutroVetor) {
			tamanhoMenorVetor = tamanhoOutroVetor;
		} else {
			tamanhoMenorVetor = tamanhoVetor;
		}
		
		double total = 0;
		int posOutroVetor = tamanhoVetor - 1;
		for (int i = 0; i < tamanhoMenorVetor; i++) {
			total += this.vetorReais[i] * outro.getValor(posOutroVetor);
			posOutroVetor--;
		}
		
		return total;
	}
	
	public void inverte() {
		double[] vetorInverso = new double[this.vetorReais.length];
		for (int i = 0; i < vetorInverso.length; i++) {
			vetorInverso[vetorInverso.length - i - 1] = this.vetorReais[i];
		}
		this.vetorReais = vetorInverso;
	}

	public String getValues() {
		String valores = "[ ";
		
		for (int i = 0; i < this.vetorReais.length; i++) {
			valores += this.vetorReais[i] + ", ";
		}
		return valores.substring(0, valores.lastIndexOf(",")) + " ]";
	}
	
	public double getMaiorDiferencaConsecutivo() {
		double diferenca = 0;
		double maiorDiferenca = 0;
		for (int i = 1; i < this.vetorReais.length; i++) {
			diferenca = Math.abs(this.vetorReais[i] - this.vetorReais[i - 1]);
			if (diferenca > maiorDiferenca) {
				maiorDiferenca = diferenca;
			}
		}
		
		return maiorDiferenca;
	}
}
