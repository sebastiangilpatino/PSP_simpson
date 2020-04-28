package Test;

import static org.testng.AssertJUnit.assertEquals;

import org.junit.jupiter.api.Test;

import dev.ICalc;
import dev.Simpson;

public class Test_Simpson {

	@Test
	public void TestCalculos0() {
		ICalc simpson = new Simpson(1.1, 9);
		double resultadoObservado = simpson.Calculos();
		double resultadoEsperado = 0.35006;
		assertEquals(resultadoEsperado, resultadoObservado, 0.001);
	}

	@Test
	public void TestCalculos1() {
		ICalc simpson = new Simpson(1.1812, 10);
		double resultadoObservado = simpson.Calculos();
		double resultadoEsperado = 0.36757;
		assertEquals(resultadoEsperado, resultadoObservado, 0.001);
	}

	@Test
	public void TestCalculos2() {
		ICalc simpson = new Simpson(2.750, 30);
		double resultadoObservado = simpson.Calculos();
		double resultadoEsperado = 0.49500;
		assertEquals(resultadoEsperado, resultadoObservado, 0.001);
	}
}