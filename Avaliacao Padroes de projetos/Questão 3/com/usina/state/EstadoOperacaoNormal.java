package com.usina.state;

import com.usina.context.UsinaNuclear;

public class EstadoOperacaoNormal implements EstadoUsina {
    private static final EstadoOperacaoNormal instance = new EstadoOperacaoNormal();

    private EstadoOperacaoNormal() {}

    public static EstadoOperacaoNormal getInstance() {
        return instance;
    }

    @Override
    public String getNome() {
        return "OPERACAO_NORMAL";
    }

    @Override
    public void verificarCondicoes(UsinaNuclear usina) {
        // REGRA: OPERACAO_NORMAL → ALERTA_AMARELO: se temperatura > 300°C
        if (usina.getTemperatura() > 300) {
            System.out.println("ALERTA: Temperatura > 300°C!");
            usina.setEstado(EstadoAlertaAmarelo.getInstance()); // Transição
        }
    }

    @Override
    public void desligar(UsinaNuclear usina) {
        System.out.println("Desligando a usina...");
        usina.setEstado(EstadoDesligada.getInstance()); // Transição
    }
    
    @Override
    public void entrarManutencao(UsinaNuclear usina) {
        System.out.println("Entrando em manutenção (pausando operação normal).");
        usina.setEstado(new EstadoManutencao(this)); // Transição
    }
    
    // Ações irrelevantes
    @Override
    public void ligar(UsinaNuclear usina) {
        System.out.println("Usina já está em operação normal.");
    }
    @Override
    public void sairManutencao(UsinaNuclear usina) {}
}