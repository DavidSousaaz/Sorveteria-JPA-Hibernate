package View;

import javax.swing.*;
import javax.swing.table.*;
import java.awt.*;
import java.awt.event.*;

public class TelaPedidos extends JFrame {

    private JTable tabela;
    private DefaultTableModel modelo;
    private JScrollPane painelTabela;

    public TelaPedidos(String sorvetes) {
        setTitle("Lista de Sorvetes");
        setSize(480, 480);
        setLayout(null);
        setLocationRelativeTo(null);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setResizable(false);

        addJLabelTitulo();
        addTabelaSorvetes();
        addJButtonGerarPedido();
        addJButtonVisualizarPedidos();
        addJButtonVoltar();
        popularTabela(sorvetes);

        setVisible(true);
    }

    private void addTabelaSorvetes() {
        modelo = new DefaultTableModel();
        modelo.setColumnIdentifiers(new String[] { "Sabor", "Tipo", "Preço" });
        tabela = new JTable(modelo);
        tabela.setFont(new Font("Arial", Font.PLAIN, 17));
        painelTabela = new JScrollPane(tabela);
        painelTabela.setBounds(30, 80, 410, 290);
        add(painelTabela);
    }

    private void addJLabelTitulo() {
        JLabel jbTitulo = new JLabel("Lista de Gelados");
        jbTitulo.setBounds(0, 30, 480, 30);
        jbTitulo.setHorizontalAlignment(JLabel.CENTER);
        jbTitulo.setFont(new Font("Arial", Font.BOLD, 20));
        add(jbTitulo);
    }

    private void addJButtonGerarPedido() {
        JButton jbGerarPedido = new JButton("Gerar Pedido");
        jbGerarPedido.setBounds(20, 390, 130, 30);
        jbGerarPedido.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                gerarPedido();
            }
        });
        add(jbGerarPedido);
    }

    private void addJButtonVisualizarPedidos() {
        JButton jbVisualizarPedidos = new JButton("Visualizar Pedidos");
        jbVisualizarPedidos.setBounds(162, 390, 160, 30);
        jbVisualizarPedidos.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                dispose();
                new TelaViewPedidos(); // Supondo que você já tenha a classe TelaViewPedidos
            }
        });
        add(jbVisualizarPedidos);
    }

    private void addJButtonVoltar() {
        JButton jbVoltar = new JButton("Voltar");
        jbVoltar.setBounds(340, 390, 100, 30);
        jbVoltar.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                dispose(); // Fecha a tela atual
                new TelaInicial(); // Supondo que você já tenha a classe TelaInicial
            }
        });
        add(jbVoltar);
    }

    private void popularTabela(String sorvetes) {
      // logica para o populador tabela
      // modelo.addRow(new Object[] { "Chocolate", "Sundae", 10.50 });
      
    }

    private void gerarPedido() {
        int linhaSelecionada = tabela.getSelectedRow();

        if (linhaSelecionada == -1) {
            JOptionPane.showMessageDialog(this, "Por favor, selecione um item da tabela.");
            return;
        }

        String sabor = (String) modelo.getValueAt(linhaSelecionada, 0);
        String tipo = (String) modelo.getValueAt(linhaSelecionada, 1);
        double preco = (double) modelo.getValueAt(linhaSelecionada, 2);

        String nomeCliente = JOptionPane.showInputDialog(this, "Informe o nome do cliente:");
        if (nomeCliente == null || nomeCliente.trim().isEmpty()) {
            JOptionPane.showMessageDialog(this, "Nome do cliente não pode ser vazio!");
            return;
        }

        String quantidadeStr = JOptionPane.showInputDialog(this, "Informe a quantidade:");
        if (quantidadeStr == null || quantidadeStr.trim().isEmpty()) {
            JOptionPane.showMessageDialog(this, "Quantidade não pode ser vazia!");
            return;
        }

        int quantidade;
        try {
            quantidade = Integer.parseInt(quantidadeStr);
            if (quantidade <= 0) {
                throw new NumberFormatException();
            }
        } catch (NumberFormatException ex) {
            JOptionPane.showMessageDialog(this, "Quantidade inválida!");
            return;
        }

        double total = preco * quantidade;
        JOptionPane.showMessageDialog(this, "Pedido gerado com sucesso!\n"
                + "Cliente: " + nomeCliente + "\n"
                + "Sabor: " + sabor + "\n"
                + "Tipo: " + tipo + "\n"
                + "Quantidade: " + quantidade + "\n"
                + "Preço Total: R$ " + total);
    }

}
