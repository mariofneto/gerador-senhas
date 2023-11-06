import javax.swing.*;
import java.awt.*;

public class Program {
    public static void main(String[] args) {
        JFrame frame = new JFrame("Gerador de Senhas - mariofneto");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(500, 500);
        frame.setLayout(new FlowLayout(FlowLayout.CENTER, 0, 200));

        String[] opcoes = { "Iniciante", "Básica", "Intermediária", "Avançada" };
        JComboBox<String> choiceBox = new JComboBox<>(opcoes);
        choiceBox.setBounds(20, 20, 200, 20);
        JButton generateButton = new JButton("Gerar Senha");
        generateButton.setBounds(100, 100, 120, 20);

        JTextArea senhaTextArea = new JTextArea();
        senhaTextArea.setLineWrap(true);
        senhaTextArea.setWrapStyleWord(true);
        senhaTextArea.setFont(new Font("Arial", Font.BOLD, 16));
        senhaTextArea.setEditable(false);

        generateButton.addActionListener(e -> {
            Senha senha = new Senha();
            String opcaoSelecionada = (String) choiceBox.getSelectedItem();
            String senhaGerada;
            switch (opcaoSelecionada) {
                case "Iniciante":
                    senhaGerada = senha.gerarSenha(8);
                    break;
                case "Básica":
                    senhaGerada = senha.gerarSenha(8, true);
                    break;
                case "Intermediária":
                    senhaGerada = senha.gerarSenha(8, true, true);
                    break;
                default:
                    senhaGerada = senha.gerarSenha(8, true, true, true);
                    break;
            }
            senhaTextArea.setText(senhaGerada);
        });
        frame.add(choiceBox);
        frame.add(generateButton);
        frame.add(senhaTextArea);

        frame.setVisible(true);
    }
}
