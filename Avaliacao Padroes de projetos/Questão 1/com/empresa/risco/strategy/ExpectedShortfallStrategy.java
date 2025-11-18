package com.empresa.risco.strategy;

import com.empresa.risco.data.ContextoRisco;

/**
 * Implementação 2: Expected Shortfall (ES).
 * Calcula o risco com base no cenário econômico.
 */
public class ExpectedShortfallStrategy implements AlgoritmoRiscoStrategy {
    @Override
    public String calcular(ContextoRisco contexto) {
        // Cálculo dummy
        double es = contexto.valorPortifolio() * contexto.taxaVolatilidade() * 2.81;
        String resultado = String.format(
                "[Expected Shortfall (ES)] Perda esperada no pior cenário (%s): R$ %.2f.",
                contexto.cenarioEconomico(), es);
        System.out.println(resultado);
        return resultado;
    }
}