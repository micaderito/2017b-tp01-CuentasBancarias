package cuentaBancaria;

public class CuentaBancaria {
	
	private double saldo;
	
	public CuentaBancaria() {
		saldo = 0;
	}
	
	public CuentaBancaria(double saldo) {
		this.saldo=saldo;
	}
	
	
	public double verSaldo() {
		return saldo;
	}
	
	public void ingresarDinero(double monto) {
		this.saldo+=monto;
	}
	
	public void retirarDinero(double monto) {
		this.saldo-=monto;
	}
	
	public void transferirMontoHacia(double monto, CuentaBancaria cuentaDestino) {
			this.saldo-=monto;
			cuentaDestino.saldo+=monto;
	}
	
	
	
	
		
}
