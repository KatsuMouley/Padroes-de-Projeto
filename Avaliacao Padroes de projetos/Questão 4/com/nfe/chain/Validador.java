package com.nfe.chain;

import com.nfe.context.DocumentoFiscal;

/**
 * A interface Handler do padrão Chain of Responsibility.
 */
public interface Validador {
    
    /**
     * Define o próximo validador na cadeia.
     */
    void setNext(Validador next);

    /**
     * Executa a validação neste elo da cadeia.
     */
    void validar(DocumentoFiscal documento);
}