import java.nio.file.Files;
import java.nio.file.Path;
import java.io.IOException;

public class escritaArquivo {
    public static void main(String[] args) {
        Path caminho = Path.of("dados.txt");
        String conteudo = "Esta é a primeira linha.\nE esta é a segunda.";

        try {
            // Escreve a String diretamente no arquivo (Cria ou Sobrescreve)
            Files.writeString(caminho, conteudo);
            System.out.println("Arquivo gravado com sucesso!");
        } catch (IOException e) {
            System.err.println("Erro ao gravar: " + e.getMessage());
        }
    }
}

