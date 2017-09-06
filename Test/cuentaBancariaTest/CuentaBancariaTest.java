package cuentaBancariaTest;


import org.junit.Assert;
import org.junit.Test;

import cuentaBancaria.CuentaBancaria;


public class CuentaBancariaTest {
	
	@Test
	public void queInicieEnCero() {
		CuentaBancaria cb = new CuentaBancaria(1,0);
		Assert.assertEquals(0,cb.verSaldo(),0.0);
	}
	
	@Test
	public void queIngreseDinero() {
		CuentaBancaria cb = new CuentaBancaria(1,0);
		cb.ingresarDinero(2500.50);
		Assert.assertEquals(2500.50, cb.verSaldo(),0.0);
	}
	
	@Test
	public void queRetireDineroYNoPueda() {
		CuentaBancaria cb = new CuentaBancaria(1,3015.50);
		cb.retirarDinero(4000);
		Assert.assertEquals(3015.50,cb.verSaldo(),0.0);
	}
	
	@Test
	public void queRetireDineroYPueda() {
		CuentaBancaria cb = new CuentaBancaria(1,5000.75);
		cb.retirarDinero(2000.75);
		Assert.assertEquals(3000, cb.verSaldo(),0.0);
	}
	
	@Test
	public void queTransfieraDineroYNoPueda() {
		CuentaBancaria cb = new CuentaBancaria(1,1000);
		CuentaBancaria cb2 = new CuentaBancaria(2,0);
		cb.transferirMontoHacia(2500, cb2);
		Assert.assertEquals(1000, cb.verSaldo(),0.0);
		Assert.assertEquals(0, cb2.verSaldo(),0.0);
	}
	
	@Test
	public void queTransfieraDineroYPueda() {
		CuentaBancaria cb = new CuentaBancaria(1,10000);
		CuentaBancaria cb2 = new CuentaBancaria(2,0);
		cb.transferirMontoHacia(6000, cb2);
		Assert.assertEquals(4000, cb.verSaldo(),0.0);
		Assert.assertEquals(6000, cb2.verSaldo(),0.0);
	}
	
	@Test
	public void queNoSeAutoTransfieraDinero() {
		CuentaBancaria cb = new CuentaBancaria(1,10000);
		Assert.assertEquals(false, cb.transferirMontoHacia(6000, cb));
	}
}
