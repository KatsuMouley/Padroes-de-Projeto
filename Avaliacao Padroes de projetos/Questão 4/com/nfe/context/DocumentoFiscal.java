package com.nfe.context;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Objeto de Contexto que é passado ao longo da cadeia.
 * Ele armazena os dados do documento, a lista de erros e o
 * estado necessário para rollbacks e execução condicional.
 */
public class DocumentoFiscal {
    
    private static final int MAX_ERROS = 3;
    
    private final String xmlContent;
    private final List<String> erros = new ArrayList<>();
    
    // Armazena dados temporários para rollbacks (ex: ID de uma inserção no BD)
    private final Map<String, Object> estadoRollback = new HashMap<>();
    
    // Flag para validações condicionais (Validadores 3 e 5)
    private boolean validacaoCriticaFalhou = false;

    public DocumentoFiscal(String xmlContent) {
        this.xmlContent = xmlContent;
    }

    public void addErro(String erro) {
        this.erros.add(erro);
    }

    public List<String> getErros() {
        return erros;
    }

    public String getXmlContent() {
        return xmlContent;
    }

    public Map<String, Object> getEstadoRollback() {
        return estadoRollback;
    }

    public boolean isValido() {
        return erros.isEmpty();
    }

    // REQUISITO: "circuit breaker"
    public boolean circuitBreakerAberto() {
        return erros.size() >= MAX_ERROS;
    }

    public boolean isValidaoCriticaFalhou() {
        return validacaoCriticaFalhou;
    }

    public void setValidacaoCriticaFalhou(boolean validacaoCriticaFalhou) {
        this.validacaoCriticaFalhou = validacaoCriticaFalhou;
    }
}