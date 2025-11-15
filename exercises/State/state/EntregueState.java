package state;

// 4. Estado: Entregue (Estado Final)
// Este estado não permite mais nenhuma ação.
// Como herda de BaseState, todas as ações (pagar, enviar, etc.)
// já são tratadas como inválidas.
public class EntregueState extends BaseState {
    // Nenhum método sobrescrito = Nenhuma ação é válida.
} 