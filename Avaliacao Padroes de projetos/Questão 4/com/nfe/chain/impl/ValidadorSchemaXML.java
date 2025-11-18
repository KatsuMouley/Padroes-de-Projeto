package com.nfe.chain.impl;

import com.nfe.chain.ValidadorBase;
import com.nfe.context.DocumentoFiscal;

// 1. Validador de Schema XML (Crítico)
public class ValidadorSchemaXML extends ValidadorBase {
    public ValidadorSchemaXML() {
        super("ValidadorSchemaXML", 100); // Timeout de 100ms
    }

    @Override
    protected boolean executarValidacao(DocumentoFiscal documento) {
        if (!documento.getXmlContent().contains("<NFe>")) {
            documento.addErro("XML mal formatado. Tag <NFe> ausente.");
            documento.setValidacaoCriticaFalhou(true); // Flag para pular 3 e 5
            return false;
        }
        System.out.println("   XML Schema OK.");
        return true;
    }
}