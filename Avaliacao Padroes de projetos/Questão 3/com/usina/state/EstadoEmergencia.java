package com.usina.state;

import com.usina.context.UsinaNuclear;

public class EstadoEmergencia implements EstadoUsina {
    private static final EstadoEmergencia instance = new EstadoEmergencia();

    private EstadoEmergencia() {}

    public static EstadoEmergencia getInstance() {
        return instance;
    }

    @Override
    public String getNome() {
        return "EMERGENCIA";
    }

    @Override
    public void desligar(UsinaNuclear usina) {
        System.out.println("Executando desligamento de emergência (SCRAM)...");
        usina.setEstado(EstadoDesligada.getInstance());
    }

    // Ações bloqueadas. Em emergência, nada mais importa.
    @Override
    public void verificarCondicoes(UsinaNuclear usina) {
        System.out.println("EM EMERGÊNCIA. Nenhuma outra verificação de sensor é permitida.");
    }
    @Override
    public void ligar(UsinaNuclear usina) {
        System.out.println("NÃO É POSSÍVEL LIGAR: Usina em estado de emergência.");
    }
    @Override
    public void entrarManutencao(UsinaNuclear usina) {
        System.out.println("NÃO É POSSÍVEL: Usina em estado de emergência.");
    }
    @Override
    public void sairManutencao(UsinaNuclear usina) {}
}