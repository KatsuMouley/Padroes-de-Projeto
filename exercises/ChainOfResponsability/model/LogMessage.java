package model;

import java.time.LocalDateTime;

/**
 * A solicitação (Request) que será passada pela cadeia.
 * Contém os dados do log.
 */
public class LogMessage {
    private final String nivel;
    private final String mensagem;
    private final LocalDateTime timestamp;

    public LogMessage(String nivel, String mensagem) {
        this.nivel = nivel;
        this.mensagem = mensagem;
        this.timestamp = LocalDateTime.now();
    }

    public String getNivel() {
        return nivel;
    }

    public String getMensagem() {
        return mensagem;
    }

    public LocalDateTime getTimestamp() {
        return timestamp;
    }

    @Override
    public String toString() {
        return String.format("[%s] (%s) %s", nivel, timestamp, mensagem);
    }
}