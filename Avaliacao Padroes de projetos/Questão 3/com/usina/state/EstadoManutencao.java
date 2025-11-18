package com.usina.state;

import com.usina.context.UsinaNuclear;

/**
 * REQUISITO: "Adicione um modo 'manutenção' que sobreescreva
 * temporariamente os estados normais"
 * *
 * DECISÃO DE DESIGN: Este estado não é um Singleton.
 * Ele precisa armazenar seu próprio estado: o "estadoAnterior"
 * para o qual a usina deve retornar.
 */
public class EstadoManutencao implements EstadoUsina {

    private final EstadoUsina estadoAnterior;

    public EstadoManutencao(EstadoUsina estadoAnterior) {
        this.estadoAnterior = estadoAnterior;
    }

    @Override
    public String getNome() {
        return "MANUTENCAO (Estado anterior: " + estadoAnterior.getNome() + ")";
    }

    @Override
    public void sairManutencao(UsinaNuclear usina) {
        System.out.println("Saindo da manutenção...");
        // Retorna ao estado que estava antes
        usina.setEstado(this.estadoAnterior); 
    }

    // Ações "sobrescritas" (bloqueadas)
    @Override
    public void verificarCondicoes(UsinaNuclear usina) {
        System.out.println("Em manutenção. Sensores ignorados.");
    }
    @Override
    public void ligar(UsinaNuclear usina) {
        System.out.println("Em manutenção. Não é possível ligar.");
    }
    @Override
    public void desligar(UsinaNuclear usina) {
        System.out.println("Em manutenção. Use 'sairManutencao' primeiro.");
    }
    @Override
    public void entrarManutencao(UsinaNuclear usina) {
        System.out.println("Já está em manutenção.");
    }
}