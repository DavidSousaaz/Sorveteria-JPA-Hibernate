package View;

import Model.*;
import controller.*;

import javax.swing.*;
import javax.swing.table.*;
import java.awt.event.*;
import java.util.*;

public class TelaViewPedidos extends JFrame {

    private SorveteController sorveteController = new SorveteController();

    private PedidoController pedidoController = new PedidoController();

    private JTable tabelaPedidos;
    private DefaultTableModel modeloTabela;
    private JButton btnVisualizarProduto;
    private JButton btnVoltar;
    private JButton btnFinalizar;

    public TelaViewPedidos(List<Pedido> pedidos) {
        setTitle("Lista de Pedidos");
        setSize(500, 400);
        setLayout(null);
        setLocationRelativeTo(null);
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        setResizable(false);
        addComponents();
        popularTabela(pedidos);

        setVisible(true);
    }

    private void addComponents() {
        // Modelo e tabela para exibição de pedidos
        modeloTabela = new DefaultTableModel(
                new Object[]{"Nome do Cliente", "Preço (R$)"}, 0
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
                if (tabelaPedidos.getSelectedRow() == -1) {
                    JOptionPane.showMessageDialog(null, "Selecione um sorvete");
                } else {
                    Pedido pedidoLixo = pedidoController.listarTodosPedidos().get(tabelaPedidos.getSelectedRow());
                    pedidoController.deletarPedido(pedidoLixo.getId());
                    JOptionPane.showMessageDialog(null,"Pedido finalizado!");
                    dispose();
                    new TelaViewPedidos(pedidoController.listarTodosPedidos());
                }

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
                new TelaPedidos(sorveteController.listarTodosSorvetes());
            }
        });
        add(btnVoltar);
       
    }

    private void popularTabela(List<Pedido> pedidos) {

        for (Pedido a : pedidos) {
            adicionarLinhaTabela(a);
        }

    }

    public void adicionarLinhaTabela(Pedido pedido) {

        Object[] linha = new Object[3];
        linha[0] = pedido.getCliente().getNome();
        linha[1] = pedido.getTotal();

        modeloTabela.addRow(linha);

        DefaultTableCellRenderer centerRenderer = new DefaultTableCellRenderer();
        centerRenderer.setHorizontalAlignment(DefaultTableCellRenderer.CENTER);

        for (int i = 0; i < modeloTabela.getColumnCount(); i++) {
            tabelaPedidos.getColumnModel().getColumn(i).setCellRenderer(centerRenderer);
        }
    }

    // Método para visualizar os dados do pedido selecionado
    private void visualizarProduto() {
        int linhaSelecionada = tabelaPedidos.getSelectedRow();

        if (linhaSelecionada == -1) {
            JOptionPane.showMessageDialog(this, "Por favor, selecione um pedido para visualizar.");
            return;
        }

        Pedido pedidoTabela = pedidoController.listarTodosPedidos().get(linhaSelecionada);

        Pedido pedidoVisualizar = pedidoController.buscarPedidoPorId(pedidoTabela.getId());

        String nomeCliente = pedidoVisualizar.getCliente().getNome();
        String preco = pedidoVisualizar.getTotal().toString();
        Sorvete item = pedidoVisualizar.getItens().get(0).getSorvete();
        String nomeItem = item.getTipo() + " Sabor: " + item.getSabor();
        int quantidade = pedidoVisualizar.getItens().get(0).getQuantidade();

        JOptionPane.showMessageDialog(this, "Detalhes do Pedido:\n"
                + "Cliente: " + nomeCliente + "\n"
                + nomeItem +" \nQuantidade: " + quantidade + "\n"
                + "Preço: R$ " + preco);
    }


}
