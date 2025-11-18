package com.empresa.risco.data;

import java.util.Map;

/**
 * Classe de dados (record) para carregar os parâmetros financeiros
 * que serão compartilhados entre os algoritmos.
 * Atende ao requisito de "compartilhar um contexto complexo".
 */
public record ContextoRisco(
        double valorPortifolio,
        double taxaVolatilidade,
        String cenarioEconomico,
        Map<String, Double> ativos) {
}