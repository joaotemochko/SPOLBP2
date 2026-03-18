import java.nio.file.Files;
import java.nio.file.Path;
import java.io.IOException;
import java.util.List;

public class leituraArquivo {
    public static void main(String[] args) {
        Path caminho = Path.of("dados.txt");

        try {
            // Lê todas as linhas do arquivo para uma lista de Strings
            List<String> linhas = Files.readAllLines(caminho);
            
            for (String linha : linhas) {
                System.out.println(linha);
            }
        } catch (IOException e) {
            System.err.println("Erro ao ler o arquivo: " + e.getMessage());
        }
    }
}
