package com.banco.legado;

import java.util.HashMap;

/**
 * A interface legada. Ela usa tipos de dados obsoletos (HashMap)
 * e possui uma assinatura de método incompatível.
 */
public interface SistemaBancarioLegado {

    /**
     * O método legado que processa a transação.
     * * @param parametros Um mapa com todos os dados da transação.
     * @return Um HashMap com a resposta (ex: "status" e "codigoAuth").
     */
    HashMap<String, Object> processarTransacao(HashMap<String, Object> parametros);
}