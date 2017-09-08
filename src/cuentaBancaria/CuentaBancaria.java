package cuentaBancaria;

public class CuentaBancaria {
	
	private double saldo;
	private int nroCuenta;
	
	public CuentaBancaria(int nroCuenta) {
		this.nroCuenta = nroCuenta;
		this.saldo = 0;
	}
	
	
	public double verSaldo() {
		return saldo;
	}
	
	public void ingresarDinero(double monto) {
		if(monto>0)
			this.saldo+=monto;
	}
	
	public void retirarDinero(double monto) {
		if(this.saldo>=monto)
			this.saldo-=monto;
	}
	
	public boolean transferirMontoHacia(double monto, CuentaBancaria cuentaDestino) {
		if(this.saldo>=monto && this.nroCuenta != cuentaDestino.nroCuenta) {
			this.saldo-=monto;
			cuentaDestino.saldo+=monto;
			return true;
		}
		return false;
	}	
		
}
