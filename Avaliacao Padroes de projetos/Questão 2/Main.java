

import com.banco.adapter.LegadoAdapter;
import com.banco.legado.SistemaBancarioLegado;
import com.banco.legado.SistemaBancarioLegadoImpl;
import com.banco.moderno.ProcessadorTransacoes;
import com.banco.moderno.RespostaAutorizacao;

public class Main {
    public static void main(String[] args) {

        // 1. Configuração da Injeção de Dependência (realidade)
        // Criamos o sistema legado
        SistemaBancarioLegado sistemaLegado = new SistemaBancarioLegadoImpl();
        // Criamos o Adapter e injetamos o sistema legado nele
        ProcessadorTransacoes processador = new LegadoAdapter(sistemaLegado);

        // 2. Uso pelo Cliente (o cliente só vê a interface moderna)
        System.out.println("--- Executando Transação 1 (BRL) ---");
        RespostaAutorizacao resp1 = processador.autorizar(
                "1234-5678-9012-3456",
                150.75,
                "BRL");

        System.out.println("\n[CLIENTE] Resposta da Transação 1: " + resp1);

        System.out.println("\n--- Executando Transação 2 (USD) ---");
        RespostaAutorizacao resp2 = processador.autorizar(
                "9876-5432-1098-7654",
                50.00,
                "USD");

        System.out.println("\n[CLIENTE] Resposta da Transação 2: " + resp2);
    }
}