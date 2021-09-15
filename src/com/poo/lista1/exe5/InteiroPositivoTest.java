package com.poo.lista1.exe5;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

class InteiroPositivoTest {

	@Test
	void testCalculaFatorial10() {
		InteiroPositivo inteiro = new InteiroPositivo();
		inteiro.setValor(10);
		assertEquals(3628800, inteiro.fatorialX());
	}
	
	@Test
	void testCalculaFatorial20() {
		InteiroPositivo inteiro = new InteiroPositivo();
		inteiro.setValor(20);
		assertEquals(2432902008176640000L, inteiro.fatorialX());
	}
	
	@Test
	void testIdentificaDivisores14() {
		InteiroPositivo inteiro = new InteiroPositivo();
		inteiro.setValor(14);
		assertEquals("Os divisores são 1, 2, 7, 14 e a quantidade de divisores é 4.", inteiro.divisoresInteiros());
	}
	
	@Test
	void testIdentificaDivisores18() {
		InteiroPositivo inteiro = new InteiroPositivo();
		inteiro.setValor(18);
		assertEquals("Os divisores são 1, 2, 3, 6, 9, 18 e a quantidade de divisores é 6.", inteiro.divisoresInteiros());
	}
	
	@Test
	void testFibonacci9() {
		InteiroPositivo inteiro = new InteiroPositivo();
		inteiro.setValor(9);
		int[] esperado = {1, 1, 2, 3, 5, 8, 13, 21, 34};
		assertArrayEquals(esperado, inteiro.fibonacci());
	}
	
	@Test
	void testFibonacci15() {
		InteiroPositivo inteiro = new InteiroPositivo();
		inteiro.setValor(15);
		int[] esperado = {1, 1, 2, 3, 5, 8, 13, 21, 34, 55, 89, 144, 233, 377, 610};
		assertArrayEquals(esperado, inteiro.fibonacci());
	}


}
