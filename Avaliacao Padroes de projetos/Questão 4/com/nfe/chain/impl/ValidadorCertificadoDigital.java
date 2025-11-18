package com.nfe.chain.impl;

import com.nfe.chain.ValidadorBase;
import com.nfe.context.DocumentoFiscal;

// 2. Validador de Certificado Digital (Crítico)
public class ValidadorCertificadoDigital extends ValidadorBase {
    public ValidadorCertificadoDigital() {
        super("ValidadorCertificadoDigital", 200); // Timeout de 200ms
    }

    @Override
    protected boolean executarValidacao(DocumentoFiscal documento) {
        if (documento.getXmlContent().contains("CERT_REVOGADO")) {
            documento.addErro("Certificado digital está revogado.");
            documento.setValidacaoCriticaFalhou(true); // Flag para pular 3 e 5
            return false;
        }
        System.out.println("   Certificado Digital OK.");
        return true;
    }
}