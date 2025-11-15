package context;

import state.IOrderState;
import state.NovoState;

/**
 * A classe Contexto (Order).
 * Ela mantém uma referência ao seu estado atual e delega todas
 * as ações (pagar, enviar, etc.) para esse objeto de estado.
 */
public class Order {

    private String orderId;
    private IOrderState currentState;

    public Order(String orderId) {
        this.orderId = orderId;
        // Todo pedido começa no estado "Novo"
        this.currentState = new NovoState();
        System.out.println("Pedido " + orderId + " criado. Estado: " + currentState.getClass().getSimpleName());
    }

    // O "setter" de estado que os objetos State usarão para transicionar
    public void setState(IOrderState newState) {
        this.currentState = newState;
        System.out.println(">> Pedido " + orderId + " mudou. Novo estado: " + currentState.getClass().getSimpleName());
    }

    // --- Delegação de Ações para o Estado Atual ---

    public void pagar() {
        currentState.pagar(this);
    }

    public void enviar() {
        currentState.enviar(this);
    }

    public void entregar() {
        currentState.entregar(this);
    }

    public void cancelar() {
        currentState.cancelar(this);
    }
}