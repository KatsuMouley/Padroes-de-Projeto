package com.banco.moderno;

/**
 * A interface moderna e limpa que nosso sistema cliente usa.
 * Esta é a interface "Target" do padrão Adapter.
 */
public interface ProcessadorTransacoes {

    /**
     * Autoriza uma transação usando parâmetros modernos e claros.
     * * @return Uma RespostaAutorizacao simples.
     */
    RespostaAutorizacao autorizar(String cartao, double valor, String moeda);
}