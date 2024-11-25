package View;

import Model.*;
import controller.*;

import javax.swing.*;
import javax.swing.table.*;
import java.awt.*;
import java.awt.event.*;
import java.util.List;

public class TelaPedidos extends JFrame {

    private SorveteController sorveteController = new SorveteController();
    private ClienteController clienteController = new ClienteController();
    private  ItemPedidoController itemPedidoController = new ItemPedidoController();
    private PedidoController pedidoController = new PedidoController();

    private JTable tabela;
    private DefaultTableModel modelo;
    private JScrollPane painelTabela;

    public TelaPedidos(List<Sorvete> sorvetes) {
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
                dispose();
                new TelaPedidos(sorveteController.listarTodosSorvetes());

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
                new TelaViewPedidos(pedidoController.listarTodosPedidos());
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

    private void popularTabela(List<Sorvete> sorvetes) {

        for (Sorvete a : sorvetes) {
            adicionarLinhaTabela(a);
        }

    }

    public void adicionarLinhaTabela(Sorvete sorvete) {

        Object[] linha = new Object[3];
        linha[0] = sorvete.getSabor();
        linha[1] = sorvete.getTipo();
        linha[2] = sorvete.getPreco();

        modelo.addRow(linha);

        DefaultTableCellRenderer centerRenderer = new DefaultTableCellRenderer();
        centerRenderer.setHorizontalAlignment(DefaultTableCellRenderer.CENTER);

        for (int i = 0; i < modelo.getColumnCount(); i++) {
            tabela.getColumnModel().getColumn(i).setCellRenderer(centerRenderer);
        }
    }

    private void gerarPedido() {
        int linhaSelecionada = tabela.getSelectedRow();

        if (linhaSelecionada == -1) {
            JOptionPane.showMessageDialog(this, "Por favor, selecione um item da tabela.");
            return;
        }

        Sorvete sorveteSelecionado = sorveteController.listarTodosSorvetes().get(tabela.getSelectedRow());

        String nomeCliente = JOptionPane.showInputDialog(this, "Informe o nome do cliente:");
        if (nomeCliente == null || nomeCliente.trim().isEmpty()) {
            JOptionPane.showMessageDialog(this, "Nome do cliente não pode ser vazio!");
            return;
        }

        Cliente clientePedido = clienteController.buscarClientePorNome(nomeCliente);

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

        Pedido pedido = new Pedido();
        pedido.setDataHora(java.time.LocalDateTime.now());
        pedido.setCliente(clientePedido);

        ItemPedido itemPedido = new ItemPedido();
        itemPedido.setQuantidade(quantidade);
        itemPedido.setSorvete(sorveteSelecionado);
        itemPedido.setPrecoUnitario(sorveteSelecionado.getPreco());
        pedido.adicionarItem(itemPedido);

        itemPedidoController.salvarItemPedido(itemPedido);

        pedidoController.salvarPedido(pedido);

        JOptionPane.showMessageDialog(null, "Pedido foi gerado com sucesso!");

    }

}
