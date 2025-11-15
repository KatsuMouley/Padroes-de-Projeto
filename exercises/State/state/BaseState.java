package state;

import context.Order;

/**
 * Classe Abstrata (Helper) para comportamento padrão.
 * Implementa todas as ações como "operações inválidas".
 * Os estados concretos só precisarão sobrescrever as ações
 * que são VÁLIDAS para eles.
 */
public abstract class BaseState implements IOrderState {

    protected void operacaoInvalida(String acao) {
        System.out.println("ERRO: Ação '" + acao + "' é inválida para o estado atual.");
    }

    @Override
    public void pagar(Order order) {
        operacaoInvalida("Pagar");
    }

    @Override
    public void enviar(Order order) {
        operacaoInvalida("Enviar");
    }

    @Override
    public void entregar(Order order) {
        operacaoInvalida("Entregar");
    }

    @Override
    public void cancelar(Order order) {
        operacaoInvalida("Cancelar");
    }
}