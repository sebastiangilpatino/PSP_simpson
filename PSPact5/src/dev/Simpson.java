package dev;

public class Simpson implements ICalc {

	private double data_x;
	private double data_dof;

	public Simpson(double data_x, double data_dof) {
		this.data_x = data_x;
		this.data_dof = data_dof;
	}

	@Override
	public double Calculos() {
		ICalc funcion_x = new FX(data_x, data_dof, 0.00001, 10); // instancia un objeto con las propiedades como error y
		ICalc funcion_y = new FX(data_x, data_dof, 0.00001, 2 * ((FX) funcion_x).getNum_seg());

		if (funcion_x.Calculos() - funcion_y.Calculos() < ((FX) funcion_x).getE()) { // las compara
			return funcion_y.Calculos();
		} else {
			System.out.print(funcion_x.Calculos());
			return 0; // cuando el error es muy grande
		}
	}
}
