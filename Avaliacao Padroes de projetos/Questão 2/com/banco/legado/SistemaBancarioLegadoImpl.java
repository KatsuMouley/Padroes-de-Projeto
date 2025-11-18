package com.banco.legado;

import java.util.HashMap;
import java.util.UUID;

/**
 * Simulação do sistema legado. Não podemos alterar esta classe.
 */
public class SistemaBancarioLegadoImpl implements SistemaBancarioLegado {

    @Override
    public HashMap<String, Object> processarTransacao(HashMap<String, Object> parametros) {
        System.out.println("[LEGADO] Processando transação com parâmetros: " + parametros);

        // Validação de campos legados obrigatórios
        if (!parametros.containsKey("codigoSegurancaLegado") ||
                !parametros.containsKey("moedaCodigo")) {
            System.out.println("[LEGADO] ERRO: Campos obrigatórios ausentes.");
            return criarRespostaLegada("REJEITADA", null);
        }

        // Simulação de sucesso
        String codigoAuth = UUID.randomUUID().toString().substring(0, 8).toUpperCase();
        return criarRespostaLegada("APROVADA", codigoAuth);
    }

    private HashMap<String, Object> criarRespostaLegada(String status, String codigo) {
        HashMap<String, Object> resposta = new HashMap<>();
        resposta.put("status", status);
        resposta.put("codigoAuth", codigo);
        return resposta;
    }
}