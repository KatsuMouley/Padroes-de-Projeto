package handler;

import model.LogMessage;

// 4. Handler de ERROR: Simula envio de e-mail
public class ErrorHandler extends LogHandler {

    public ErrorHandler() {
        super("ERROR");
    }

    @Override
    protected void executarAcao(LogMessage log) {
        System.out.println("==============================================");
        System.out.println("! ALERTA ! [E-MAIL SIMULADO ENVIADO] ! ALERTA !");
        System.out.println("Nível: " + log.getNivel());
        System.out.println("Mensagem: " + log.getMensagem());
        System.out.println("Timestamp: " + log.getTimestamp());
        System.out.println("==============================================");
    }
}