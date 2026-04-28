package ExemplosJavaSwing;

import javax.swing.*;
import java.awt.*;

public class ExercicioLAB3 extends JFrame {

    public ExercicioLAB3() {
        setTitle("Sistema de Autenticação - Interativo");
        setSize(400, 200);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null);
        setLayout(new BorderLayout());

        // Criação dos componentes
        JPanel painelFormulario = new JPanel(new GridLayout(2, 2, 10, 10));
        painelFormulario.setBorder(BorderFactory.createEmptyBorder(20, 20, 20, 20)); 

        JLabel lblUtilizador = new JLabel("Utilizador:");
        JTextField txtUtilizador = new JTextField();
        
        JLabel lblPalavraPasse = new JLabel("Palavra-passe:");
        JPasswordField txtPalavraPasse = new JPasswordField();

        painelFormulario.add(lblUtilizador);
        painelFormulario.add(txtUtilizador);
        painelFormulario.add(lblPalavraPasse);
        painelFormulario.add(txtPalavraPasse);

        JPanel painelBotao = new JPanel(new FlowLayout(FlowLayout.CENTER));
        JButton btnEntrar = new JButton("Entrar");
        painelBotao.add(btnEntrar);

        add(painelFormulario, BorderLayout.CENTER);
        add(painelBotao, BorderLayout.SOUTH);

        // --- AULA 3: ADICIONANDO INTERATIVIDADE ---
        
        btnEntrar.addActionListener(e -> {
            // 1. Coletar os dados inseridos
            String utilizador = txtUtilizador.getText();
            // getPassword() retorna um char[], convertemos para String para o teste simples
            String palavraPasse = new String(txtPalavraPasse.getPassword());

            // 2. Lógica de validação
            if (utilizador.equals("admin") && palavraPasse.equals("1234")) {
                // Feedback de sucesso
                JOptionPane.showMessageDialog(
                    this, 
                    "Autenticação efetuada com sucesso!", 
                    "Acesso Permitido", 
                    JOptionPane.INFORMATION_MESSAGE
                );
            } else {
                // Feedback de erro
                JOptionPane.showMessageDialog(
                    this, 
                    "Utilizador ou palavra-passe incorretos.", 
                    "Erro de Autenticação", 
                    JOptionPane.ERROR_MESSAGE
                );
                
                // Desafio extra: limpar os campos para nova tentativa
                txtUtilizador.setText("");
                txtPalavraPasse.setText("");
                
                // Devolve o foco do teclado ao campo do utilizador
                txtUtilizador.requestFocus();
            }
        });
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> {
            new ExercicioLAB3().setVisible(true);
        });
    }
}
