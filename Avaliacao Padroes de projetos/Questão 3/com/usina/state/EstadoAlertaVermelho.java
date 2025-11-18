package com.usina.state;

import com.usina.context.UsinaNuclear;

public class EstadoAlertaVermelho implements EstadoUsina {
    private static final EstadoAlertaVermelho instance = new EstadoAlertaVermelho();

    private EstadoAlertaVermelho() {}

    public static EstadoAlertaVermelho getInstance() {
        return instance;
    }

    @Override
    public String getNome() {
        return "ALERTA_VERMELHO";
    }

    @Override
    public void verificarCondicoes(UsinaNuclear usina) {
        // REGRA: ALERTA_VERMELHO → EMERGENCIA: se sistema de resfriamento falhar
        // REQUISITO: "EMERGENCIA só pode ser ativado após passar por ALERTA_VERMELHO"
        // Esta lógica garante isso.
        if (usina.isSistemaResfriamentoFalhou()) {
            System.out.println("EMERGÊNCIA: Sistema de resfriamento FALHOU!");
            usina.setEstado(EstadoEmergencia.getInstance()); // Transição unidirecional
        } 
        // Transição bidirecional: pode voltar ao amarelo
        else if (usina.getTemperatura() <= 400) {
            System.out.println("Temperatura estabilizada. Voltando para Alerta Amarelo.");
            usina.setEstado(EstadoAlertaAmarelo.getInstance()); // Transição
        }
    }
    
    // Ações irrelevantes ou bloqueadas
    @Override
    public void desligar(UsinaNuclear usina) {
        System.out.println("Desligamento manual bloqueado em Alerta Vermelho. Use procedimentos de emergência.");
    }
    @Override
    public void ligar(UsinaNuclear usina) {}
    @Override
    public void entrarManutencao(UsinaNuclear usina) {
        System.out.println("Não é possível entrar em manutenção durante um alerta.");
    }
    @Override
    public void sairManutencao(UsinaNuclear usina) {}
}