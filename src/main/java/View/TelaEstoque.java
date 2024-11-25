package View;

import Model.*;
import controller.*;

import javax.swing.*;
import javax.swing.table.*;
import java.awt.event.*;
import java.util.*;

public class TelaEstoque extends JFrame {

    private SorveteController sorveteController = new SorveteController();

    private DefaultTableModel modelo;
    private JTable tabela;

    public TelaEstoque() {
        setTitle("Estoque");
        setSize(400, 350); // Ajuste o tamanho da janela
        setLocationRelativeTo(null); // Centraliza a janela na tela
        setLayout(null); // Usando layout absoluto
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setResizable(false);

        addTabelaEstoque();
        addJButtonVoltar();

        setVisible(true);
    }

    private void addTabelaEstoque() {
        // Define os dados e colunas para a tabela
        String[] colunas = { "Produto", "Preço" };

        List<Sorvete> sorvetes = sorveteController.listarTodosSorvetes();


        // Cria o modelo da tabela
        modelo = new DefaultTableModel(colunas, 0) {
            @Override
            public boolean isCellEditable(int row, int column) {
                return false; // Impede edição nas células diretamente
            }
        };

        for(Sorvete sorvete : sorvetes){
            modelo.addRow(new Object[]{sorvete.getTipo() + " - " + sorvete.getSabor(), sorvete.getPreco()});
        }

        tabela = new JTable(modelo);
        tabela.setEnabled(false); // Permite interatividade (seleção de linha)

        // Envolve a tabela em um JScrollPane
        JScrollPane scrollPane = new JScrollPane(tabela);
        scrollPane.setBounds(30, 30, 340, 100); // Tamanho e posição da tabela
        add(scrollPane);
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
}
