package ExemplosJavaSwing;

import javax.swing.JFrame;
import javax.swing.SwingUtilities;

public class ExercicioLAB1 extends JFrame {

    // Construtor: onde configuramos as propriedades da janela
    public ExercicioLAB1() {
        // Define o título da janela
        setTitle("A Minha Primeira Janela - LP2");
        
        // Define o tamanho (Largura x Altura)
        setSize(800, 600);
        
        // Garante que o processo do Java termina ao fechar a janela
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        
        // Centraliza a janela no ecrã do utilizador
        setLocationRelativeTo(null);
    }

    public static void main(String[] args) {
        // Boa prática no Swing: executar a GUI na Event Dispatch Thread (EDT)
        SwingUtilities.invokeLater(() -> {
            ExercicioLAB1 janela = new ExercicioLAB1();
            
            // Tornar a janela visível (deve ser sempre a última instrução de configuração)
            janela.setVisible(true);
        });
    }
}