package dev;

import java.util.Scanner;

public class Cliente {

	public static void main(String[] args) {
		Scanner myObj = new Scanner(System.in); // Create a Scanner
		try {
			System.out.print("ingresa x:  ");
			Double data_x = Double.parseDouble(myObj.nextLine());
			System.out.print("ingresa dof:  ");
			int data_dof = Integer.parseInt(myObj.nextLine());
			myObj.close(); // cierra el scanner
			ICalc calculos = new Simpson(data_x, data_dof); // instancia a la clase
			System.out.print("ro =  " + calculos.Calculos()); // operacion de la clase.
		} catch (Exception e) {
			System.out.print("mal ingreso de datos");
		}

	}

}
