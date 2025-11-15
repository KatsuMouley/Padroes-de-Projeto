package handler;

import model.LogMessage;

// 1. Handler de DEBUG: Apenas imprime no console
public class DebugHandler extends LogHandler {

    public DebugHandler() {
        // Informa à classe pai que este handler processa "DEBUG"
        super("DEBUG");
    }

    @Override
    protected void executarAcao(LogMessage log) {
        System.out.println("CONSOLE [DEBUG]: " + log.getMensagem());
    }
}