package aula07.service;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.Test;

class CalculadoraServiceTest {
	
	private CalculadoraService calc;
	
	@BeforeEach
	void montarCenarioCasosTestes() {
		
		// MONTAGEM DO CENÁRIO
		calc = new CalculadoraService();
	}
	
	@AfterEach
	void limparObjetosUtilizados() {
		
		calc = null;
	}

	@Test
	void ligarCalculadoraTest() {

		// EXECUÇÃO
		calc.ligar();

		// VERIFICAÇÃO
		assertTrue(calc.isStatus());
	}

	@Test
	void desligarCalculadoraTest() {

		// EXECUÇÃO
		calc.ligar();
		calc.desligar();

		// VERIFICAÇÃO
		assertFalse(calc.isStatus());
	}

	@Test
	void somarDoisPositivosTest() {

		// EXECUÇÃO
		double resultado = calc.somar(5, 10);

		// VERIFICAÇÃO
		assertEquals(15, resultado);
	}

	@Test
	void somarUmPositivoUmNegativoTest() {

		// EXECUÇÃO
		double resultado = calc.somar(5, -10);

		// VERIFICAÇÃO
		assertEquals(-5, resultado);
	}

	@Test
	void somarDoisNegativosTest() {

		// EXECUÇÃO
		double resultado = calc.somar(-5, -10);

		// VERIFICAÇÃO
		assertEquals(-15, resultado);
	}

	@Disabled
	void subtrairDoisPositivosTest() {

	}

	@Disabled
	void subtrairUmPositivoUmNegativoTest() {

	}

	@Disabled
	void subtrairDoisNegativosTest() {

	}

	@Disabled
	void multiplicarDoisPositivosTest() {

	}

	@Disabled
	void multiplicarUmPositivoUmNegativoTest() {

	}

	@Disabled
	void multiplicarDoisNegativosTest() {

	}

	@Test
	void dividirDoisPositivosTest() {

		try {

			double resultado = calc.dividir(10, 5);
			
			assertEquals(2, resultado);

		} catch (DivisaoImpossivelException ex) {

			// se uma NumeroNaoNatualException foi disparada, então o teste deve falhar
			fail();
		}
	}

	@Disabled
	void dividirUmPositivoUmNegativoTest() {

	}

	@Disabled
	void dividirDoisNegativosTest() {

	}

	@Test
	void dividirPorZeroTest() {

		try {

			double resultado = calc.dividir(10, 0);

			// se o bloco try executou sem disparar exceções, o teste deve falhar
			fail();

		} catch (DivisaoImpossivelException ex) {

			assertEquals("Impossível dividir por zero.", ex.getMessage());
		}
	}
}