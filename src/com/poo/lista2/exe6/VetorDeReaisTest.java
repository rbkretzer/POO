package com.poo.lista2.exe6;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNull;

import org.junit.jupiter.api.Test;

class VetorDeReaisTest {

	@Test
	void testDivisaoVetoresTamanhoDiferente() {
		VetorDeReais vetor1 = new VetorDeReais(3);
		vetor1.addValor(2, 0);
		vetor1.addValor(-1, 1);
		vetor1.addValor(3.5, 2);
		VetorDeReais vetor2 = new VetorDeReais(1);
		vetor2.addValor(3, 0);
		assertNull(vetor1.divide(vetor2));
	}
	
	@Test
	void testDivisaoVetores() {
		VetorDeReais vetor1 = new VetorDeReais(3);
		vetor1.addValor(2, 0);
		vetor1.addValor(-1, 1);
		vetor1.addValor(3.5, 2);
		VetorDeReais vetor2 = new VetorDeReais(3);
		vetor2.addValor(3, 0);
		vetor2.addValor(2, 1);
		vetor2.addValor(1, 2);
		VetorDeReais vetorDivisao = vetor1.divide(vetor2);
		assertEquals(0.666666, vetorDivisao.getValor(0), 0.00009);
		assertEquals(-0.5, vetorDivisao.getValor(1));
		assertEquals(3.5, vetorDivisao.getValor(2));
	}
}
