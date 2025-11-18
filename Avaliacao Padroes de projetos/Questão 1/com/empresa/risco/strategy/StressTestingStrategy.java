package com.empresa.risco.strategy;

import com.empresa.risco.data.ContextoRisco;

/**
 * Implementação 3: Stress Testing.
 * Simula o impacto de um cenário econômico adverso.
 */
public class StressTestingStrategy implements AlgoritmoRiscoStrategy {
    @Override
    public String calcular(ContextoRisco contexto) {
        // Cálculo dummy
        double perda = contexto.valorPortifolio() * 0.45; // Simula perda de 45%
        String resultado = String.format(
                "[Stress Testing] Simulação de cenário '%s': Perda potencial de R$ %.2f.",
                contexto.cenarioEconomico(), perda);
        System.out.println(resultado);
        return resultado;
    }
}