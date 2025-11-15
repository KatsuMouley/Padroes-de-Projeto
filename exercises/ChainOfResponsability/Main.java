import model.LogMessage;
import handler.*;

public class Main {

    private static LogHandler construirCadeia() {
        LogHandler debug = new DebugHandler();
        LogHandler info = new InfoHandler();
        LogHandler warning = new WarningHandler();
        LogHandler error = new ErrorHandler();

        debug.setNext(info);
        info.setNext(warning);
        warning.setNext(error);
 
        return debug;
    }

    public static void main(String[] args) {
        System.out.println("--- Iniciando Sistema de Logs (Chain of Responsibility) ---");

        LogHandler cadeia = construirCadeia();

        System.out.println("\n--- Processando Logs ---");
        
        cadeia.processarLog(new LogMessage("INFO", "Sistema iniciado com sucesso."));
        cadeia.processarLog(new LogMessage("DEBUG", "Valor da variável X = 10."));
        cadeia.processarLog(new LogMessage("WARNING", "Conexão com banco de dados demorando."));
        cadeia.processarLog(new LogMessage("INFO", "Usuário 'admin' fez login."));
        cadeia.processarLog(new LogMessage("ERROR", "Falha crítica! Não foi possível salvar o arquivo."));
        cadeia.processarLog(new LogMessage("FATAL", "Este log não será tratado.")); 

        System.out.println("\n--- Processamento Concluído ---");

        // Verificação do Requisito 5: Visualizar logs do InfoHandler
        
        // --- LINHA CORRIGIDA ---
        // Agora usamos o método público getNext()
        LogHandler infoHandler = cadeia.getNext(); // Sabemos que 'info' é o segundo (debug.getNext())
        // -------------------------

        if (infoHandler instanceof InfoHandler) {
            ((InfoHandler) infoHandler).imprimirLogsArmazenados();
        }

        System.out.println("\nVerifique o arquivo 'warnings.log' gerado no diretório.");
    }
}