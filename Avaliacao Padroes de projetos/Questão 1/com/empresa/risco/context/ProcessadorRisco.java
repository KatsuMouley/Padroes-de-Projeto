package com.empresa.risco.context;

import com.empresa.risco.data.ContextoRisco;
import com.empresa.risco.strategy.AlgoritmoRiscoStrategy;

/**
 * O ProcessadorRisco é o "Contexto" do padrão Strategy.
 * Ele mantém uma referência para a estratégia *atual* e delega
 * a execução para ela.
 * * DECISÃO DE DESIGN (Strategy):
 * Esta classe atende ao requisito de que "O cliente deve poder mudar
 * de algoritmo sem conhecer os detalhes de implementação". O cliente
 * (ex: o método main) interage apenas com o ProcessadorRisco,
 * usando 'setAlgoritmo()' para trocar a estratégia dinamicamente.
 */
public class ProcessadorRisco {
    private AlgoritmoRiscoStrategy algoritmoAtual;

    /**
     * Construtor que define uma estratégia inicial (padrão).
     */
    public ProcessadorRisco(AlgoritmoRiscoStrategy algoritmoInicial) {
        this.algoritmoAtual = algoritmoInicial;
    }

    /**
     * Permite a troca do algoritmo em tempo de execução.
     * Este é o método central que atende ao requisito.
     */
    public void setAlgoritmo(AlgoritmoRiscoStrategy novoAlgoritmo) {
        System.out.println("\n--- [SISTEMA] Trocando estratégia de análise de risco... ---");
        this.algoritmoAtual = novoAlgoritmo;
    }

    /**
     * Executa o cálculo de risco usando a estratégia atualmente configurada.
     */
    public void executarAnalise(ContextoRisco contexto) {
        if (algoritmoAtual == null) {
            System.out.println("Erro: Nenhum algoritmo de risco foi definido.");
            return;
        }
        // Delega a chamada para o objeto da estratégia atual
        algoritmoAtual.calcular(contexto);
    }
}