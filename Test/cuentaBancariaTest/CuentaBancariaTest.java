package cuentaBancariaTest;


import org.junit.Assert;
import org.junit.Test;

import cuentaBancaria.CuentaBancaria;


public class CuentaBancariaTest {
	
	@Test
	public void queInicieEnCero() {
		CuentaBancaria cb = new CuentaBancaria();
		Assert.assertEquals(0,cb.verSaldo(),0.0);
	}
	
	@Test
	public void queIngreseDinero() {
		CuentaBancaria cb = new CuentaBancaria();
		cb.ingresarDinero(2500.50);
		Assert.assertEquals(2500.50, cb.verSaldo(),0.0);
	}
	
	@Test
	public void queRetireDinero() {
		CuentaBancaria cb = new CuentaBancaria();
		cb.ingresarDinero(3015.50);
		cb.retirarDinero(4000);
		Assert.assertEquals(3015.50,cb.verSaldo(),0.0);
	}
}
