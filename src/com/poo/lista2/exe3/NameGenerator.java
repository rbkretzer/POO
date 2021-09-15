package com.poo.lista2.exe3;

public class NameGenerator {

	public  static String generateStarWarsName(String[] entrada) {
		String[] nomePessoa = entrada[0].split(" ");
		String nome = nomePessoa[nomePessoa.length - 1].substring(0, 3).concat(nomePessoa[0].substring(0, 2).toLowerCase());
		String sobrenome = entrada[1].substring(0, 2).concat(entrada[2].substring(0, 2).toLowerCase());
		return nome.concat(" ").concat(sobrenome);
	}

}
