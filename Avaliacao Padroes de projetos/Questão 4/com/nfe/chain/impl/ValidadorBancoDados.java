package com.nfe.chain.impl;

import com.nfe.chain.ValidadorBase;
import com.nfe.context.DocumentoFiscal;

// 4. Validador de Banco de dados (Duplicidade)
public class ValidadorBancoDados extends ValidadorBase {
    public ValidadorBancoDados() {
        super("ValidadorBancoDados", 150); // Timeout de 150ms
    }

    @Override
    protected boolean executarValidacao(DocumentoFiscal documento) {
        if (documento.getXmlContent().contains("DUPLICADA")) {
            documento.addErro("NF-e duplicada no banco de dados.");
            return false;
        }
        
        // Simula uma inserção "provisória" no BD
        System.out.println("   Inserindo ID 999 no BD (provisório)...");
        documento.getEstadoRollback().put("dbInsercaoId", 999);
        return true;
    }

@Override
    protected void rollback(DocumentoFiscal documento) {
        // REQUISITO: "deve fazer rollback da inserção se subsequentes falharem"
        if (documento.getEstadoRollback().containsKey("dbInsercaoId")) {
            int id = (int) documento.getEstadoRollback().get("dbInsercaoId");
            
            // O LOG VEM PARA CÁ!
            System.out.println("<- Acionando ROLLBACK para: ValidadorBancoDados");
            System.out.println("   ROLLBACK: Deletando ID " + id + " do BD.");
            
            documento.getEstadoRollback().remove("dbInsercaoId");
        }
    }
}