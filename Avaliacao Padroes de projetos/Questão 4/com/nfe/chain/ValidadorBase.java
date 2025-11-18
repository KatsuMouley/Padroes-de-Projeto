package com.nfe.chain;

import com.nfe.context.DocumentoFiscal;
import java.util.concurrent.TimeoutException;

public abstract class ValidadorBase implements Validador {

    protected Validador next;
    private final long timeoutMillis;
    private final String nomeValidador;

    public ValidadorBase(String nomeValidador, long timeoutMillis) {
        this.nomeValidador = nomeValidador;
        this.timeoutMillis = timeoutMillis;
    }

    @Override
    public void setNext(Validador next) {
        this.next = next;
    }

    @Override
    public final void validar(DocumentoFiscal documento) {
        // 1. Verificar Circuit Breaker (antes de executar)
        if (documento.circuitBreakerAberto()) {
            System.out.println("! CIRCUIT BREAKER ATIVADO. Pulando: " + nomeValidador);
            return; // Interrompe ESTE validador, mas a cadeia já parou antes
        }

        // 2. Verificar Condição de Execução
        if (!deveExecutar(documento)) {
            System.out.println("... Pulando validador condicional: " + nomeValidador);
            // Pula este, mas continua a cadeia
            passarParaProximo(documento); 
            return;
        }

        // 3. Executar a Validação
        long startTime = System.currentTimeMillis();
        try {
            System.out.println("-> Executando: " + nomeValidador);
            
            // A lógica de validação agora só precisa se preocupar consigo mesma
            if (!executarValidacao(documento)) {
                 // A validação falhou, mas não paramos a cadeia
            }

            // Simulação de Timeout
            long duration = System.currentTimeMillis() - startTime;
            if (duration > timeoutMillis) {
                throw new TimeoutException(nomeValidador + " excedeu o timeout de " + timeoutMillis + "ms.");
            }

        } catch (Exception e) {
            System.out.println("!! ERRO em " + nomeValidador + ": " + e.getMessage());
            documento.addErro("[" + nomeValidador + "] " + e.getMessage());
        }

        // 4. Passar para o próximo (SEMPRE, exceto se o circuit breaker abrir)
        int errosAntesDeChamarProximo = documento.getErros().size();
        
        // Verifica o circuit breaker *antes* de chamar o próximo
        if (next != null && !documento.circuitBreakerAberto()) {
            passarParaProximo(documento);
        } else if (documento.circuitBreakerAberto()) {
             System.out.println("! CIRCUIT BREAKER ATIVADO APÓS: " + nomeValidador + ". Interrompendo cadeia.");
        }

        // 5. Lógica de Rollback (após o próximo ter rodado)
        int errosDepoisDeChamarProximo = documento.getErros().size();
        if (errosDepoisDeChamarProximo > errosAntesDeChamarProximo) {
            // Se um validador *posterior* falhou, chama o rollback
            rollback(documento); // O log de rollback deve estar no método concreto
        }
    }

    private void passarParaProximo(DocumentoFiscal documento) {
        if (next != null) {
            next.validar(documento);
        }
    }

    // --- Métodos para classes concretas ---
    
    protected abstract boolean executarValidacao(DocumentoFiscal documento) throws Exception;

    protected boolean deveExecutar(DocumentoFiscal documento) {
        return true; 
    }

    protected void rollback(DocumentoFiscal documento) {
        // Padrão é não fazer nada
    }
}