package handler;

import model.LogMessage;
import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;

// 3. Handler de WARNING: Escreve em arquivo
public class WarningHandler extends LogHandler {

    private static final String NOME_ARQUIVO = "warnings.log";

    public WarningHandler() {
        super("WARNING");
    }

    @Override
    protected void executarAcao(LogMessage log) {
        System.out.println("ARQUIVO [WARNING]: Escrevendo em " + NOME_ARQUIVO);
        
        // Usa try-with-resources para garantir que o arquivo seja fechado
        // O 'true' no FileWriter habilita o modo "append" (adicionar ao fim)
        try (BufferedWriter writer = new BufferedWriter(new FileWriter(NOME_ARQUIVO, true))) {
            writer.write(log.toString());
            writer.newLine();
        } catch (IOException e) {
            System.err.println("Falha ao escrever log de WARNING no arquivo: " + e.getMessage());
        }
    }
}