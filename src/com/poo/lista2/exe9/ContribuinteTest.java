package com.poo.lista2.exe9;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

import com.poo.lista2.exe1.Contribuinte;

class ContribuinteTest {

	@Test
	void testGetImpostoAPagar0() {
		Contribuinte c = new Contribuinte();
		c.setRendaAnual(3000);
		double imposto = c.getImpostoAPagar();
		assertEquals(0, imposto);
	}

	@Test
	void testGetImpostoAPagar522() {
		Contribuinte c = new Contribuinte();
		c.setRendaAnual(9000);
		double imposto = c.getImpostoAPagar();
		assertEquals(522, imposto);
	}
	
	@Test
	void testGetImpostoAPagar1500() {
		Contribuinte c = new Contribuinte();
		c.setRendaAnual(10000);
		double imposto = c.getImpostoAPagar();
		assertEquals(1500, imposto);
	}
	
	@Test
	void testGetImpostoAPagar9600() {
		Contribuinte c = new Contribuinte();
		c.setRendaAnual(34911.73);
		double imposto = c.getImpostoAPagar();
		assertEquals(9600.72, imposto, 0.009);
	}
	
	@Test
	void testSetRendaAnualNegativa() {
		Contribuinte c = new Contribuinte();
		c.setRendaAnual(-818.50);
		assertEquals(0, c.getRendaAnual());
	}
	
	@Test
	void testSetUfSC() {
		Contribuinte c = new Contribuinte();
		c.setUf("SC");
		assertEquals("SC", c.getUf());
	}
	
	@Test
	void testSetUfRS() {
		Contribuinte c = new Contribuinte();
		c.setUf("RS");
		assertEquals("RS", c.getUf());
	}
	
	@Test
	void testSetUfPR() {
		Contribuinte c = new Contribuinte();
		c.setUf("PR");
		assertEquals("PR", c.getUf());
	}
	
	@Test
	void testSetUfSP() {
		Contribuinte c = new Contribuinte();
		c.setUf("SP");
		assertEquals(null, c.getUf());
	}
	
	@Test
	void testSetUfRJ() {
		Contribuinte c = new Contribuinte();
		c.setUf("RJ");
		assertEquals(null, c.getUf());
	}

}
