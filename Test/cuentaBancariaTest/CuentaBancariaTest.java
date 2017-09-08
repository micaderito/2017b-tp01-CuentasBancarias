package cuentaBancariaTest;


import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import cuentaBancaria.CuentaBancaria;


public class CuentaBancariaTest {
	
	private CuentaBancaria cuentaOrigen;
	
	@Before
	public void antesDeCadaPrueba() {
		cuentaOrigen = new CuentaBancaria(1);
	}
	
	@Test
	public void queInicieEnCero() {
		Assert.assertEquals(0,cuentaOrigen.verSaldo(),0.0);
	}
	
	@Test
	public void queIngreseDinero() {
		cuentaOrigen.ingresarDinero(2500.50);
		Assert.assertEquals(2500.50, cuentaOrigen.verSaldo(),0.0);
	}
	
	@Test
	public void queRetireDineroYNoPueda() {
		cuentaOrigen.ingresarDinero(3015.50);
		cuentaOrigen.retirarDinero(4000);
		Assert.assertEquals(3015.50,cuentaOrigen.verSaldo(),0.0);
	}
	
	@Test
	public void queRetireDineroYPueda() {
		cuentaOrigen.ingresarDinero(5000.75);
		cuentaOrigen.retirarDinero(2000.75);
		Assert.assertEquals(3000, cuentaOrigen.verSaldo(),0.0);
	}
	
	@Test
	public void queTransfieraDineroYNoPueda() {
		cuentaOrigen.ingresarDinero(1000);
		CuentaBancaria cuentaDestino = new CuentaBancaria(2);
		cuentaOrigen.transferirMontoHacia(2500, cuentaDestino);
		Assert.assertEquals(1000, cuentaOrigen.verSaldo(),0.0);
		Assert.assertEquals(0, cuentaDestino.verSaldo(),0.0);
	}
	
	@Test
	public void queTransfieraDineroYPueda() {
		cuentaOrigen.ingresarDinero(10000);
		CuentaBancaria cuentaDestino = new CuentaBancaria(2);
		cuentaOrigen.transferirMontoHacia(6000, cuentaDestino);
		Assert.assertEquals(4000, cuentaOrigen.verSaldo(),0.0);
		Assert.assertEquals(6000, cuentaDestino.verSaldo(),0.0);
	}
	
	@Test
	public void queNoSeAutoTransfieraDinero() {
		cuentaOrigen.ingresarDinero(10000);
		Assert.assertEquals(false, cuentaOrigen.transferirMontoHacia(6000, cuentaOrigen));
	}
	
	@Test
	public void queNoIngreseSaldoNegativo() {
		cuentaOrigen.ingresarDinero(100);
		cuentaOrigen.ingresarDinero(-500);
		Assert.assertEquals(100, cuentaOrigen.verSaldo(),0.0);
	}
}
