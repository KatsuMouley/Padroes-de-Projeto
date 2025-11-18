package com.empresa.risco.strategy;

import com.empresa.risco.data.ContextoRisco;

/**
 * Implementação 1: Value at Risk (VaR).
 * Calcula o risco com base no valor do portifólio e volatilidade.
 */
public class ValueAtRiskStrategy implements AlgoritmoRiscoStrategy {
    @Override
    public String calcular(ContextoRisco contexto) {
        // Cálculo dummy
        double var = contexto.valorPortifolio() * contexto.taxaVolatilidade() * 2.33;
        String resultado = String.format(
                "[Value at Risk (VaR)] Risco de perda máxima: R$ %.2f para o portifólio de R$ %.2f.",
                var, contexto.valorPortifolio());
        System.out.println(resultado);
        return resultado;
    }
}