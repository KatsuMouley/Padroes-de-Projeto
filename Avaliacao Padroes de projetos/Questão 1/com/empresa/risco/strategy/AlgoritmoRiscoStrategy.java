package com.empresa.risco.strategy;

import com.empresa.risco.data.ContextoRisco;

/**
 * DECISÃO DE DESIGN (Strategy):
 * A interface AlgoritmoRiscoStrategy é a abstração central do padrão Strategy.
 * Ela desacopla o cliente (ProcessadorRisco) da implementação concreta
 * dos algoritmos. O método 'calcular' recebe o 'ContextoRisco', permitindo
 * que as estratégias sejam "stateless" (sem estado) e facilmente
 * intercambiáveis,
 * atendendo ao requisito de compartilhar um contexto complexo.
 */
public interface AlgoritmoRiscoStrategy {
    /**
     * Executa um cálculo de risco com base no contexto fornecido.
     * * @param contexto Os dados financeiros necessários para o cálculo.
     * @return Um resultado dummy (mensagem de texto) do cálculo.
     */
    String calcular(ContextoRisco contexto);
}