package aula07.service;

import org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.AfterEach;

class CalculadoraRegraNegocioTest {

    CalculadoraRegraNegocio calc = new CalculadoraRegraNegocio();

    @BeforeEach
    public void montarCenario() {

        // MONTAGEM DO CENÁRIO  
        calc = new CalculadoraRegraNegocio();
    }

    @AfterEach
    public void destruirCenario() {

        calc = null;
    }


    @Test
    public void ligarTrueTest() {

        // EXECUÇÃO DO MÉTODO A SER TESTADO
        calc.ligar();

        // VERIFICAÇÃO DO RESULTADO
        assertTrue(calc.isStatus());
    }

    @Test
    public void desligarCalculadoraTest() {

        // EXECUÇÃO DO MÉTODO A SER TESTADO
        calc.ligar();
        calc.desligar();

        // VERIFICAÇÃO DO RESULTADO
        assertFalse(calc.isStatus());
    }

    @Test
    public void somarDoisPositivos() {

        // EXECUÇÃO

        // VERIFICAÇÃO
    }

    @Test
    public void somarDoisNegativos() {

        // EXECUÇÃO

        // VERIFICAÇÃO
    }

    @Test
    public void somarUmPositivoUmNegativo() {

        // EXECUÇÃO

        // VERIFICAÇÃO
    }
}
