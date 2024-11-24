package View;

import javax.swing.*;
import javax.swing.table.*;
import java.awt.event.*;

public class TelaEstoque extends JFrame {

    private DefaultTableModel modelo;
    private JTable tabela;
    private JTextField quantidadeField;
    private int linhaSelecionada = -1;

    public TelaEstoque() {
        setTitle("Estoque");
        setSize(400, 350); // Ajuste o tamanho da janela
        setLocationRelativeTo(null); // Centraliza a janela na tela
        setLayout(null); // Usando layout absoluto
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setResizable(false);

        addTabelaEstoque();
        addCampoQuantidade();
        addBotaoAdicionar();
        addJButtonVoltar();

        setVisible(true);
    }

    private void addTabelaEstoque() {
        // Define os dados e colunas para a tabela
        String[] colunas = { "Produto", "Quantidade" };
        Object[][] dados = {
            { "Picolé", 0 },
            { "Sorvete", 0 },
            { "Sundae", 0 }
        };

        // Cria o modelo da tabela
        modelo = new DefaultTableModel(dados, colunas) {
            @Override
            public boolean isCellEditable(int row, int column) {
                return false; // Impede edição nas células diretamente
            }
        };

        tabela = new JTable(modelo);
        tabela.setEnabled(true); // Permite interatividade (seleção de linha)
        
        // Adiciona o evento de clique na tabela
        tabela.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                // Quando uma linha for clicada, preenche o campo de quantidade com o valor da linha selecionada
                linhaSelecionada = tabela.getSelectedRow();
                if (linhaSelecionada != -1) {
                    int quantidadeAtual = (int) modelo.getValueAt(linhaSelecionada, 1);
                    quantidadeField.setText(String.valueOf(quantidadeAtual)); // Preenche o campo com a quantidade atual
                }
            }
        });

        // Envolve a tabela em um JScrollPane
        JScrollPane scrollPane = new JScrollPane(tabela);
        scrollPane.setBounds(30, 30, 340, 100); // Tamanho e posição da tabela
        add(scrollPane);
    }

    private void addCampoQuantidade() {
        // Adiciona o campo de texto para inserir a quantidade a ser adicionada
        JLabel lblQuantidade = new JLabel("Quantidade:");
        lblQuantidade.setBounds(30, 150, 100, 30);
        add(lblQuantidade);

        quantidadeField = new JTextField();
        quantidadeField.setBounds(130, 150, 100, 30);
        add(quantidadeField);
    }

    private void addBotaoAdicionar() {
        JButton jbAdicionar = new JButton("Adicionar");
        jbAdicionar.setBounds(250, 150, 100, 30); // Posição do botão de adicionar
        jbAdicionar.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                adicionarQuantidade();
            }
        });
        add(jbAdicionar);
    }

    private void adicionarQuantidade() {
        // Verifica se uma linha foi selecionada
        if (linhaSelecionada == -1) {
            JOptionPane.showMessageDialog(this, "Selecione um produto na tabela.");
            return;
        }

        // Tenta pegar a quantidade a ser adicionada
        try {
            int quantidadeAdicionar = Integer.parseInt(quantidadeField.getText());
            
            if (quantidadeAdicionar <= 0) {
                JOptionPane.showMessageDialog(this, "Por favor, insira uma quantidade válida maior que 0.");
                return;
            }

            // Atualiza a quantidade do produto
            int quantidadeAtual = (int) modelo.getValueAt(linhaSelecionada, 1);
            modelo.setValueAt(quantidadeAtual + quantidadeAdicionar, linhaSelecionada, 1);

            // Limpa o campo de quantidade
            quantidadeField.setText("");
            JOptionPane.showMessageDialog(this, "Quantidade adicionada com sucesso!");
        } catch (NumberFormatException e) {
            JOptionPane.showMessageDialog(this, "Por favor, insira um número válido.");
        }
    }

    private void addJButtonVoltar() {
        JButton jbVoltar = new JButton("Voltar");
        jbVoltar.setBounds(150, 200, 100, 30); // Posição do botão no centro inferior
        jbVoltar.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                dispose(); 
                new TelaAddSorvete();
            }
        });
        add(jbVoltar);
    }

    public static void main(String[] args) {
        new TelaEstoque();
    }
}
