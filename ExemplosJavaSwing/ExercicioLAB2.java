package ExemplosJavaSwing;

import javax.swing.*;
import java.awt.*;

public class ExercicioLAB2 extends JFrame {

    public ExercicioLAB2() {
        setTitle("Sistema de Autenticação");
        setSize(400, 200);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null);
        
        // O JFrame usa BorderLayout por defeito, mas declaramos para ser explícito na aula
        setLayout(new BorderLayout());

        // --- PAINEL CENTRAL (Formulário) ---
        // GridLayout com 2 linhas, 2 colunas e espaçamento de 10px entre os elementos
        JPanel painelFormulario = new JPanel(new GridLayout(2, 2, 10, 10));
        // Adicionar margens (padding) ao redor do formulário
        painelFormulario.setBorder(BorderFactory.createEmptyBorder(20, 20, 20, 20)); 

        JLabel lblUtilizador = new JLabel("Utilizador:");
        JTextField txtUtilizador = new JTextField();
        
        JLabel lblPalavraPasse = new JLabel("Palavra-passe:");
        JPasswordField txtPalavraPasse = new JPasswordField();

        // A ordem de adição no GridLayout preenche da esquerda para a direita, de cima para baixo
        painelFormulario.add(lblUtilizador);
        painelFormulario.add(txtUtilizador);
        painelFormulario.add(lblPalavraPasse);
        painelFormulario.add(txtPalavraPasse);

        // --- PAINEL SUL (Botão) ---
        // FlowLayout centraliza os componentes por defeito
        JPanel painelBotao = new JPanel(new FlowLayout(FlowLayout.CENTER));
        JButton btnEntrar = new JButton("Entrar");
        painelBotao.add(btnEntrar);

        // --- MONTAGEM FINAL ---
        add(painelFormulario, BorderLayout.CENTER);
        add(painelBotao, BorderLayout.SOUTH);
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> {
            new ExercicioLAB2().setVisible(true);
        });
    }
}
