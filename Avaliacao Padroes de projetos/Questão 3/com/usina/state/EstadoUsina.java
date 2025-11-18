package com.usina.state;

import com.usina.context.UsinaNuclear;

/**
 * DECISÃO DE DESIGN (State):
 * Esta é a interface State. Ela define os métodos que correspondem
 * às ações que podem ser executadas na usina.
 * Cada classe de estado concreta implementará esta interface e fornecerá
 * o comportamento *específico* para aquele estado, incluindo as regras
 * de transição.
 * Passamos o 'contexto' (a própria UsinaNuclear) para que os estados
 * possam consultar dados (sensores) e solicitar a mudança de estado.
 */
public interface EstadoUsina {

    String getNome();

    /**
     * O método principal que verifica os sensores e decide se deve
     * transicionar para outro estado.
     */
    void verificarCondicoes(UsinaNuclear usina);

    /**
     * Ação para tentar ligar a usina.
     */
    void ligar(UsinaNuclear usina);

    /**
     * Ação para tentar desligar a usina.
     */
    void desligar(UsinaNuclear usina);

    /**
     * Ação para entrar em modo de manutenção.
     */
    void entrarManutencao(UsinaNuclear usina);

    /**
     * Ação para sair do modo de manutenção.
     */
    void sairManutencao(UsinaNuclear usina);
}