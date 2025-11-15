package handler;

import model.LogMessage;

/**
 * A classe base abstrata para todos os Handlers (Elo da Cadeia).
 */
public abstract class LogHandler {
    
    protected LogHandler nextHandler;
    protected String nivelParaProcessar;

    public LogHandler(String nivelParaProcessar) {
        this.nivelParaProcessar = nivelParaProcessar;
    }

    public void setNext(LogHandler nextHandler) {
        this.nextHandler = nextHandler;
    }
    
    // --- NOVO MÉTODO (A CORREÇÃO) ---
    /**
     * Retorna o próximo handler na cadeia.
     */
    public LogHandler getNext() {
        return this.nextHandler;
    }
    // ---------------------------------

    public void processarLog(LogMessage log) {
        if (this.nivelParaProcessar.equals(log.getNivel())) {
            executarAcao(log);
        }
        else if (nextHandler != null) {
            nextHandler.processarLog(log);
        }
        else {
            System.err.println("Nenhum handler configurado para o nível: " + log.getNivel());
        }
    }

    protected abstract void executarAcao(LogMessage log);
}