package aulas.aula07.exececaopersonalizada;

public class Calculadora {

	public Double somar(Double a, Double b) {

		return a + b;
	}

	public Double subtrair(Double a, Double b) {

		return a - b;
	}

	public Double multiplicar(Double a, Double b) {

		return a * b;
	}

	public Double dividir(Double a, Double b) {

		return a / b;
	}

	public Double calcularPotencia(Double a, Double b) {

		return Math.pow(a, b);
	}

	public void calcularRaizQuadrada(Double a) {
		
		try {
			
			if (a < 0) {

				throw new NumeroNaoNaturalException();
			}

			Double resultado = Math.sqrt(a);
			System.out.println("Raiz quadrada de " + a + ": " + resultado);

		} catch (NumeroNaoNaturalException nnne) {

			System.out.println(nnne.getMessage());
		}
	}

	public Double inverso(Double a) {

		return 1 / a;
	}
}
