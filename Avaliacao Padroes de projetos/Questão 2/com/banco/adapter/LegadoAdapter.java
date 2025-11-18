package com.banco.adapter;

import com.banco.legado.SistemaBancarioLegado;
import com.banco.moderno.ProcessadorTransacoes;
import com.banco.moderno.RespostaAutorizacao;

import java.util.HashMap;

/**
 * DECISÃO DE DESIGN (Adapter):
 * Esta classe é o Adapter. Ela implementa a interface moderna (ProcessadorTransacoes)
 * e "envolve" (ou "contém") uma instância do sistema legado.
 * Sua responsabilidade é traduzir a chamada do método 'autorizar'
 * para o formato esperado pelo 'processarTransacao' do legado.
 */
public class LegadoAdapter implements ProcessadorTransacoes {

    private final SistemaBancarioLegado sistemaLegado;

    public LegadoAdapter(SistemaBancarioLegado sistemaLegado) {
        this.sistemaLegado = sistemaLegado;
    }

    @Override
    public RespostaAutorizacao autorizar(String cartao, double valor, String moeda) {
        System.out.println("[ADAPTER] Recebida requisição moderna. Traduzindo para o legado...");

        // 1. Traduzir os dados modernos para o HashMap legado
        HashMap<String, Object> parametrosLegados = new HashMap<>();
        parametrosLegados.put("numeroCartao", cartao);
        parametrosLegados.put("valorTotal", valor);

        // 2. Atender restrição: Converter código de moeda
        int codigoMoeda = converterMoedaParaCodigoLegado(moeda);
        parametrosLegados.put("moedaCodigo", codigoMoeda);

        // 3. Atender restrição: Adicionar campo obrigatório do legado
        // (Ex: um código de segurança que o sistema novo não conhece)
        parametrosLegados.put("codigoSegurancaLegado", "SEC-456-XYZ");

        System.out.println("[ADAPTER] Enviando para o legado: " + parametrosLegados);

        // 4. Chamar o sistema legado
        HashMap<String, Object> respostaLegada = sistemaLegado.processarTransacao(parametrosLegados);

        System.out.println("[ADAPTER] Resposta do legado recebida: " + respostaLegada);

        // 5. Atender requisito: Ser bidirecional
        // Traduzir a resposta legada (HashMap) de volta para o DTO moderno
        return converterRespostaLegadaParaModerna(respostaLegada);
    }

    /**
     * Método privado de ajuda para a tradução de dados.
     */
    private int converterMoedaParaCodigoLegado(String moeda) {
        return switch (moeda.toUpperCase()) {
            case "USD" -> 1;
            case "EUR" -> 2;
            case "BRL" -> 3;
            default -> 0; // Código para "indefinido" ou "erro"
        };
    }

    /**
     * Método privado de ajuda para a tradução de resposta (Bidirecional).
     */
    private RespostaAutorizacao converterRespostaLegadaParaModerna(HashMap<String, Object> respostaLegada) {
        boolean sucesso = false;
        String codigoAutorizacao = "N/A";

        if (respostaLegada != null && "APROVADA".equals(respostaLegada.get("status"))) {
            sucesso = true;
            codigoAutorizacao = (String) respostaLegada.get("codigoAuth");
        }

        return new RespostaAutorizacao(sucesso, codigoAutorizacao);
    }
}