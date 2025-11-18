package com.usina.context;

import com.usina.state.EstadoDesligada;
import com.usina.state.EstadoUsina;

/**
 * DECISÃO DE DESIGN (Context):
 * A UsinaNuclear é a classe de Contexto. Ela não conhece a lógica
 * de negócios dos estados. Ela apenas armazena seu estado atual
 * (estadoAtual) e os dados dos sensores.
 * Todas as ações são delegadas ao objeto de estado atual.
 */
public class UsinaNuclear {

    private EstadoUsina estadoAtual;

    // Dados dos sensores (o "contexto complexo" do problema)
    private double temperatura;
    private double pressao;
    private boolean sistemaResfriamentoFalhou;

    public UsinaNuclear() {
        // A usina começa desligada
        this.estadoAtual = EstadoDesligada.getInstance();
    }

    /**
     * O método central para o padrão State. Permite que os objetos
     * de estado alterem o estado do Contexto.
     */
    public void setEstado(EstadoUsina novoEstado) {
        this.estadoAtual = novoEstado;
        System.out.println("--- NOVO ESTADO: " + novoEstado.getNome() + " ---");
    }

    /**
     * Simula uma atualização dos sensores da usina.
     * Após atualizar, ele dispara a verificação de condições.
     */
    public void atualizarSensores(double temp, double press, boolean falhaResfriamento) {
        this.temperatura = temp;
        this.pressao = press;
        this.sistemaResfriamentoFalhou = falhaResfriamento;
        System.out.println("\n[SENSORES] Temp: " + temp + "°C, Pressão: " + press + "kPa, Resfriamento OK: " + !falhaResfriamento);
        // Delega a verificação para o estado atual
        this.estadoAtual.verificarCondicoes(this);
    }

    // Métodos públicos que delegam para o estado
    public void ligar() {
        this.estadoAtual.ligar(this);
    }

    public void desligar() {
        this.estadoAtual.desligar(this);
    }

    public void entrarManutencao() {
        this.estadoAtual.entrarManutencao(this);
    }

    public void sairManutencao() {
        this.estadoAtual.sairManutencao(this);
    }

    // Getters para os estados poderem ler os sensores
    public double getTemperatura() {
        return temperatura;
    }

    public boolean isSistemaResfriamentoFalhou() {
        return sistemaResfriamentoFalhou;
    }
}