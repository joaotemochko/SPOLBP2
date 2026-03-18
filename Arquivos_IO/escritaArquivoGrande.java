import java.nio.file.*;
import java.io.BufferedWriter;
import java.io.IOException;

public class escritaArquivoGrande {
    
    public static void main(String[] args) {
        Path caminho = Path.of("arquivo_gigante.txt");

        // O "Try-with-Resources" garante que o arquivo será fechado ao final
        try (BufferedWriter bw = Files.newBufferedWriter(caminho)) {
            for (int i = 1; i <= 100000; i++) {
                bw.write("Esta é a linha número " + i);
                bw.newLine();
            }
        } catch (IOException e) {
            System.err.println("Erro de I/O: " + e.getMessage());
        }
    }
}
