package service;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.*;

public class CalculadoraServiceTest {
	
	private CalculadoraService calc;
	
	@BeforeEach
	public void montarCenario() {
		
		// Montagem do cenário
		calc = new CalculadoraService("ABC-321", "HP");		
	}
	
	@AfterEach
	public void limparCenario() {
		
		calc = null;
	}

	@Test
	public void ligarCalculadoraTest() {
		
		// Execução do método
		calc.ligar();
		
		// Veirificação
		assertTrue(calc.isStatus());
	}
	
	@Test
	public void desligarCalculadoraTest() {
		
		// Execução do método
		calc.ligar();
		calc.desligar();
		
		// Verificação
		assertFalse(calc.isStatus());
	}
	
	@Test
	public void somarDoisNumerosPositivosCalculadoraTest() {
		
		// Execução do método
		double resultado = calc.somar(10, 5);
		
		// Verificação
		assertEquals(15, resultado);
	}
	
	@Test
	public void somarDoisNumerosNegativosCalculadoraTest() {
		
		// Execução do método
		double resultado = calc.somar(-10, -5);
		
		// Verificação
		assertEquals(-15, resultado);
	}
	
	@Test
	public void somarUmNumeroPositivoUmNegativoCalculadoraTest() {
		
		// Execução do método
		double resultado = calc.somar(10, -5);
		
		// Verificação
		assertEquals(5, resultado);
	}
	
	@Test
	public void dividirDoisValoresNaturaisTest() {
		
		try {
			
			double resultado = calc.dividir(10.0, 5.0);
			
			assertEquals(2.0, resultado);
			
		} catch (ArithmeticException e) {
			
			fail();
		}
	}
	
	@Test
	public void dividirDenominadorZeroTest() {
		
		try {
			
			double resultado = calc.dividir(10.0, 0.0);
			
			fail();
			
		} catch (ArithmeticException e) {
			
			assertEquals("Impossível dividir por 0.", e.getMessage());
		}
	}
}
