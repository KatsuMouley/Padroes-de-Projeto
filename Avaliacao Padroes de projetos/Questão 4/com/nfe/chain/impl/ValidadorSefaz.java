package com.nfe.chain.impl;

import com.nfe.chain.ValidadorBase;
import com.nfe.context.DocumentoFiscal;

// 5. Validador de Serviço SEFAZ (Online)
public class ValidadorSefaz extends ValidadorBase {
    public ValidadorSefaz() {
        super("ValidadorSefaz", 500); // Timeout longo (chamada web)
    }

    @Override
    protected boolean deveExecutar(DocumentoFiscal documento) {
        // REQUISITO: Só executa se 1 e 2 passarem.
        return !documento.isValidaoCriticaFalhou();
    }

    @Override
    protected boolean executarValidacao(DocumentoFiscal documento) throws InterruptedException {
        // Simula chamada de API
        // Thread.sleep(600); // Para testar o timeout
        
        if (documento.getXmlContent().contains("SEFAZ_OFFLINE")) {
            documento.addErro("Serviço da SEFAZ está offline.");
            return false;
        }
        System.out.println("   Consulta SEFAZ OK.");
        return true;
    }
}