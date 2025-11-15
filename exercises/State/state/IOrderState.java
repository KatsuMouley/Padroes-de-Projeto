package state;

import context.Order; // O estado precisa do Contexto para transicioná-lo

/**
 * A interface State.
 * Define todas as ações que podem mudar dependendo do estado.
 * Cada método recebe o Contexto (Order) para poder alterá-lo.
 */
public interface IOrderState {
    
    void pagar(Order order);
    void enviar(Order order);
    void entregar(Order order);
    void cancelar(Order order);
    
}