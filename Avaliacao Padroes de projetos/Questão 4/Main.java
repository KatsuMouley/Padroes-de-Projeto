import com.nfe.chain.Validador;
import com.nfe.chain.impl.*;
import com.nfe.context.DocumentoFiscal;

public class Main {

    private static Validador montarCadeia() {
        // 1. Cria os elos
        Validador val1_xml = new ValidadorSchemaXML();
        Validador val2_cert = new ValidadorCertificadoDigital();
        Validador val3_fiscal = new ValidadorRegrasFiscais();
        Validador val4_db = new ValidadorBancoDados();
        Validador val5_sefaz = new ValidadorSefaz();

        // 2. Monta a cadeia
        val1_xml.setNext(val2_cert);
        val2_cert.setNext(val3_fiscal);
        val3_fiscal.setNext(val4_db);
        val4_db.setNext(val5_sefaz);

        // Retorna o primeiro elo
        return val1_xml;
    }

    public static void main(String[] args) {
        Validador cadeia = montarCadeia();

        System.out.println("--- 1. TESTE: Documento OK ---");
        DocumentoFiscal docOk = new DocumentoFiscal("<NFe>...<dados>...</NFe>");
        cadeia.validar(docOk);
        imprimirResultado(docOk);

        System.out.println("\n--- 2. TESTE: Falha Crítica (XML) ---");
        DocumentoFiscal docFalhaXml = new DocumentoFiscal("<XML_INVALIDO>");
        cadeia.validar(docFalhaXml);
        imprimirResultado(docFalhaXml);
        // (Deve pular os validadores 3 e 5)

        System.out.println("\n--- 3. TESTE: Falha no Rollback (SEFAZ falha) ---");
        DocumentoFiscal docFalhaSefaz = new DocumentoFiscal("<NFe>...<SEFAZ_OFFLINE>...</NFe>");
        cadeia.validar(docFalhaSefaz);
        imprimirResultado(docFalhaSefaz);
        // (Deve mostrar o ValidadorBancoDados fazendo rollback)

        System.out.println("\n--- 4. TESTE: Circuit Breaker ---");
        DocumentoFiscal docMuitosErros = new DocumentoFiscal(
            "<NFe><CERT_REVOGADO><IMPOSTO_ERRADO><DUPLICADA></NFe>"
        );
        cadeia.validar(docMuitosErros);
        imprimirResultado(docMuitosErros);
        // (Deve parar após 3 erros e pular o validador 5)
    }

    private static void imprimirResultado(DocumentoFiscal documento) {
        if (documento.isValido()) {
            System.out.println(">>> RESULTADO: Documento APROVADO.");
        } else {
            System.out.println(">>> RESULTADO: Documento REJEITADO.");
            documento.getErros().forEach(erro -> System.out.println("    - " + erro));
        }
    }
}