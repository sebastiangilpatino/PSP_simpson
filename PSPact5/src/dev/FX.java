package dev;

import org.apache.commons.math3.special.Gamma;

public class FX implements ICalc {
//clase donde van casi todos los calculos

	private double num_seg; // debe ser par
	private double E; // error
	private double dof; // grados de libertad
	private double x; // x que brinda el usuario
	private double w; // w que se calcula.
	private double exponente;;

	public FX(double x, double data_dof, double error, double num_seg) { // condiciones iniciales
		this.x = x;
		dof = data_dof;
		this.num_seg = num_seg;
		w = x / num_seg;
		E = error;
		exponente = -1 * ((data_dof + 1) / 2);
	}

	public double getNum_seg() {
		return num_seg;
	}

	public double getE() {
		return E;
	}

	private double gamma() {
		double x0 = (dof + 1) / 2;
		double y = dof / 2;
		double z = Math.pow(dof * Math.PI, 0.5) * Gamma.gamma(y);
		return Gamma.gamma(x0) / z;
	} // donde se calcula el gamma de la formula, libreria apache.commons.math

	@Override
	public double Calculos() {
		double x0 = 0;
		double calcular_gamma = gamma(); // se calcula gamma una sola vez
		double[] operacion = new double[(int) num_seg + 1]; // arreglo
		double[] operacion2 = new double[operacion.length]; // arreglo2
		double equis = 0;
		double multiplicador;

		for (int i = 0; i < operacion.length; i++) {
			if (i == 0) {
				equis = 0;
				operacion[i] = Math.pow(1 + Math.pow(equis, 2) / dof, exponente); // formula
				operacion2[i] = operacion[i] * calcular_gamma; // formula
			} else {
				equis += w; // xi
				operacion[i] = Math.pow(1 + Math.pow(equis, 2) / dof, exponente); // formula
				operacion2[i] = operacion[i] * calcular_gamma; // formula
			}

			if (i % 2 == 0 && i > 0 && i < num_seg) {
				multiplicador = 2;
				x0 = w / 3 * multiplicador * operacion2[i] + x0; // formula
			} else if (i % 2 == 1 && i > 0 && i < num_seg) {
				multiplicador = 4;
				x0 = w / 3 * multiplicador * operacion2[i] + x0; // formula
			} else {
				multiplicador = 1;
				x0 = w / 3 * multiplicador * operacion2[i] + x0; // formula
			}
		}

		return x0;
	}

}
