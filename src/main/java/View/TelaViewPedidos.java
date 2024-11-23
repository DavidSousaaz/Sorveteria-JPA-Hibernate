package View;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class TelaViewPedidos extends JFrame {

    private JTable tabelaPedidos;
    private DefaultTableModel modeloTabela;
    private JButton btnVisualizarProduto;
    private JButton btnVoltar;
    private JButton btnFinalizar;

    public TelaViewPedidos() {
        setTitle("Visualizar Pedidos");
        setSize(500, 400);
        setLayout(null);
        setLocationRelativeTo(null);
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        setResizable(false);

        addComponents();
        setVisible(true);
    }

    private void addComponents() {
        // Modelo e tabela para exibição de pedidos
        modeloTabela = new DefaultTableModel(
                new Object[]{"Nome do Cliente", "Quantidade", "Preço (R$)"}, 0
        );

        tabelaPedidos = new JTable(modeloTabela);
        JScrollPane scrollPane = new JScrollPane(tabelaPedidos);
        scrollPane.setBounds(20, 20, 450, 200);
        add(scrollPane);

        // Botão para visualizar os dados do pedido selecionado
        btnVisualizarProduto = new JButton("Visualizar Compra");
        btnVisualizarProduto.setBounds(30, 250, 160, 30);
        btnVisualizarProduto.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                visualizarProduto();
            }
        });
        add(btnVisualizarProduto);

        // Botão para finalizar o pedido selecionado
        btnFinalizar = new JButton("Finalizar Pedido");
        btnFinalizar.setBounds(200, 250, 130, 30);
        btnFinalizar.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                finalizarPedido();
            }
        });
        add(btnFinalizar);

        // Botão para voltar
        btnVoltar = new JButton("Voltar");
        btnVoltar.setBounds(350, 250, 100, 30);
        btnVoltar.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                dispose(); // Fecha a tela atual
                new TelaPedidos("");
            }
        });
        add(btnVoltar);

        // Dados de exemplo (remova ou substitua por dados reais)
      //  logica para receber o pedido
       // adicionarPedido("João Silva", 3, 45.50);
       
    }

    // Método para adicionar um pedido à tabela
    private void adicionarPedido(String nomeCliente, int quantidade, double preco) {
        modeloTabela.addRow(new Object[]{nomeCliente, quantidade, preco});
    }

    // Método para visualizar os dados do pedido selecionado
    private void visualizarProduto() {
        int linhaSelecionada = tabelaPedidos.getSelectedRow();

        if (linhaSelecionada == -1) {
            JOptionPane.showMessageDialog(this, "Por favor, selecione um pedido para visualizar.");
            return;
        }

        String nomeCliente = (String) modeloTabela.getValueAt(linhaSelecionada, 0);
        int quantidade = (int) modeloTabela.getValueAt(linhaSelecionada, 1);
        double preco = (double) modeloTabela.getValueAt(linhaSelecionada, 2);

        JOptionPane.showMessageDialog(this, "Detalhes do Pedido:\n"
                + "Cliente: " + nomeCliente + "\n"
                + "Quantidade: " + quantidade + "\n"
                + "Preço: R$ " + preco);
    }

    // Método para finalizar o pedido selecionado
    private void finalizarPedido() {
        int linhaSelecionada = tabelaPedidos.getSelectedRow();

        if (linhaSelecionada == -1) {
            JOptionPane.showMessageDialog(this, "Por favor, selecione um pedido para finalizar.");
            return;
        }

        String nomeCliente = (String) modeloTabela.getValueAt(linhaSelecionada, 0);

        // Remover a linha da tabela
        modeloTabela.removeRow(linhaSelecionada);

        JOptionPane.showMessageDialog(this, "Pedido do cliente " + nomeCliente + " finalizado com sucesso!");
    }


}
