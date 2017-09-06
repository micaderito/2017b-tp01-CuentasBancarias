package cuentaBancaria;

public class CuentaBancaria {
	
	private double saldo;
	private int nroCuenta;
	
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
		if(this.saldo>=monto)
			this.saldo-=monto;
	}
	
	public boolean transferirMontoHacia(double monto, CuentaBancaria cuentaDestino) {
		if(this.saldo>=monto) {
			this.saldo-=monto;
			cuentaDestino.saldo+=monto;
			return true;
		}
		return false;
	}
	
	
	
	
		
}
