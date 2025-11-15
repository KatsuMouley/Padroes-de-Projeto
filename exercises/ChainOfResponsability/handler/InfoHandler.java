package handler;

import model.LogMessage;
import java.util.List;
import java.util.ArrayList;

// 2. Handler de INFO: Armazena em uma lista
public class InfoHandler extends LogHandler {
    
    // Lista em memória para guardar os logs
    private List<LogMessage> logsArmazenados = new ArrayList<>();

    public InfoHandler() {
        super("INFO");
    }

    @Override
    protected void executarAcao(LogMessage log) {
        System.out.println("MEMÓRIA [INFO]: Log armazenado.");
        logsArmazenados.add(log);
    }

    /**
     * Método auxiliar para verificar os logs armazenados (Requisito 5)
     */
    public void imprimirLogsArmazenados() {
        System.out.println("\n--- Logs de INFO Armazenados ---");
        if (logsArmazenados.isEmpty()) {
            System.out.println("(Nenhum log de INFO)");
        }
        for (LogMessage log : logsArmazenados) {
            System.out.println(" > " + log.toString());
        }
        System.out.println("--------------------------------");
    }
}