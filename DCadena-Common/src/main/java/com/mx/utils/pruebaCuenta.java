package com.mx.utils;

import java.util.Scanner;

public class pruebaCuenta {
	public static void main(String arg[]) {
		Cuenta saldo1 = new Cuenta(50);
		Cuenta saldo2 = new Cuenta(7.53);
		System.out.println("El saldo de la cuenta 1 es de: "
				+ saldo1.obtenerSaldo());
		System.out.println("El saldo de la cuenta 2 es de: "
				+ saldo2.obtenerSaldo());

		Scanner leer = new Scanner(System.in);

		System.out.println("Ingresa el nuevo abono para la cuenta 1: ");
		double montoIngresado = leer.nextDouble();
		saldo1.abonar(montoIngresado);

		System.out.println("Ingresa el nuevo abono para la cuenta 2: ");
		montoIngresado = leer.nextDouble();
		saldo2.abonar(montoIngresado);

		System.out.println("El saldo actual de la cuenta 1 es de: "
				+ saldo1.obtenerSaldo());
		System.out.println("El saldo actual de la cuenta 2 es de: "
				+ saldo2.obtenerSaldo() + "\n");

		double montoRetirado = 0;
		do {
			System.out
					.println("Ingresa el monto que desea retirar de la cuenta 1: ");
			montoRetirado = leer.nextDouble();

		} while (!saldo1.retirar(montoRetirado));

		do {
			System.out
					.println("Ingresa el monto que desea retirar de la cuenta 2: ");
			montoRetirado = leer.nextDouble();
		} while (!saldo2.retirar(montoRetirado));

		System.out.println("El saldo actual de la cuenta 1 es de: "
				+ saldo1.obtenerSaldo());
		System.out.println("El saldo actual de la cuenta 2 es de: "
				+ saldo2.obtenerSaldo());
	}
}

class Cuenta {
	private double saldo;

	public Cuenta(double monto) {
		if (monto > 0)
			saldo = monto;
		else
			saldo = 0;
	}

	public void abonar(double monto) {
		saldo = saldo + monto;
	}

	public boolean retirar(double monto) {

		if (monto > saldo) {
			System.out
					.println("Saldo Insuficiente. Ingresa una cantidad menor a tu saldo: ");
			return false;
		}
		saldo = saldo - monto;
		System.out.println("Se retiro Satisfactoriamente ");
		return true;
	}

	public double obtenerSaldo() {
		return saldo;
	}
}