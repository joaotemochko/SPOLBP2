package FabricaLogs;

// 1. Interface
interface Logger {
    void log(String msg);
}

// 2. Classes Concretas
class ConsoleLogger implements Logger {
    public void log(String msg) { System.out.println("[CONSOLE] " + msg); }
}

class FileLogger implements Logger {
    public void log(String msg) { 
        // Simulação de escrita em arquivo
        System.out.println("[ESCREVENDO NO ARQUIVO log.txt] " + msg); 
    }
}

// 3. Factory
class LoggerFactory {
    public static Logger getLogger(String tipo) {
        if (tipo.equalsIgnoreCase("console")) return new ConsoleLogger();
        if (tipo.equalsIgnoreCase("file")) return new FileLogger();
        throw new IllegalArgumentException("Tipo de log inválido");
    }
}

// 4. Método Main
public class Main {
    public static void main(String[] args) {
        Logger loggerTela = LoggerFactory.getLogger("console");
        loggerTela.log("Erro de compilação na linha 42.");

        Logger loggerArquivo = LoggerFactory.getLogger("file");
        loggerArquivo.log("Usuário logado com sucesso.");
    }
}
