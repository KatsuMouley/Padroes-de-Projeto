package com.usina.state;

import com.usina.context.UsinaNuclear;

public class EstadoDesligada implements EstadoUsina {
    private static final EstadoDesligada instance = new EstadoDesligada();

    private EstadoDesligada() {}

    public static EstadoDesligada getInstance() {
        return instance;
    }

    @Override
    public String getNome() {
        return "DESLIGADA";
    }

    @Override
    public void ligar(UsinaNuclear usina) {
        System.out.println("Ligando a usina...");
        usina.setEstado(EstadoOperacaoNormal.getInstance()); // Transição
    }

    @Override
    public void entrarManutencao(UsinaNuclear usina) {
        System.out.println("Entrando em manutenção (a partir de desligada).");
        // Armazena o estado anterior (Desligada) para poder voltar
        usina.setEstado(new EstadoManutencao(this)); // Transição
    }

    // Ações irrelevantes para este estado
    @Override
    public void verificarCondicoes(UsinaNuclear usina) {}
    @Override
    public void desligar(UsinaNuclear usina) {
        System.out.println("Usina já está desligada.");
    }
    @Override
    public void sairManutencao(UsinaNuclear usina) {}
}