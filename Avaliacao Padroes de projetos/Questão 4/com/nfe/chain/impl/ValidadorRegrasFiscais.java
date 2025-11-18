package com.nfe.chain.impl;

import com.nfe.chain.ValidadorBase;
import com.nfe.context.DocumentoFiscal;

// 3. Validador de Regras Fiscais (Condicional)
public class ValidadorRegrasFiscais extends ValidadorBase {
    public ValidadorRegrasFiscais() {
        super("ValidadorRegrasFiscais", 50); // Timeout de 50ms
    }

    @Override
    protected boolean deveExecutar(DocumentoFiscal documento) {
        // REQUISITO: Só executa se 1 e 2 passarem.
        return !documento.isValidaoCriticaFalhou();
    }

    @Override
    protected boolean executarValidacao(DocumentoFiscal documento) {
        if (documento.getXmlContent().contains("IMPOSTO_ERRADO")) {
            documento.addErro("Cálculo de imposto (ICMS) incorreto.");
            return false;
        }
        System.out.println("   Regras Fiscais (Impostos) OK.");
        return true;
    }
}