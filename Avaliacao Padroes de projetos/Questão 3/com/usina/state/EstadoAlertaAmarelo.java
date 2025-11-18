package com.usina.state;

import com.usina.context.UsinaNuclear;

public class EstadoAlertaAmarelo implements EstadoUsina {
    private static final EstadoAlertaAmarelo instance = new EstadoAlertaAmarelo();

    private EstadoAlertaAmarelo() {}

    public static EstadoAlertaAmarelo getInstance() {
        return instance;
    }

    @Override
    public String getNome() {
        return "ALERTA_AMARELO";
    }

    @Override
    public void verificarCondicoes(UsinaNuclear usina) {
        // REGRA: ALERTA_AMARELO → ALERTA_VERMELHO: se temperatura > 400°C
        // (Simplificando a regra dos "30 segundos" para uma checagem imediata)
        if (usina.getTemperatura() > 400) {
            System.out.println("PERIGO: Temperatura > 400°C!");
            usina.setEstado(EstadoAlertaVermelho.getInstance()); // Transição
        } 
        // Transição bidirecional: pode voltar ao normal
        else if (usina.getTemperatura() <= 300) { 
            System.out.println("Temperatura normalizada.");
            usina.setEstado(EstadoOperacaoNormal.getInstance()); // Transição
        }
    }

    @Override
    public void desligar(UsinaNuclear usina) {
        System.out.println("Desligando a usina (a partir de Alerta Amarelo)...");
        usina.setEstado(EstadoDesligada.getInstance());
    }

    // Ações irrelevantes
    @Override
    public void ligar(UsinaNuclear usina) {}
    @Override
    public void entrarManutencao(UsinaNuclear usina) {
        System.out.println("Não é possível entrar em manutenção durante um alerta.");
    }
    @Override
    public void sairManutencao(UsinaNuclear usina) {}
}