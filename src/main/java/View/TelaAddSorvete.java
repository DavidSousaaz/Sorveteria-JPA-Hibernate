package View;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class TelaAddSorvete extends TelaGenericaSorvete {

    public TelaAddSorvete() {
        super();
        addJLabelTitulo();
        addJButtonAdicionar();
        addJButtonEstoque(); // Adiciona o botão "Estoque"
         // Adiciona o botão "Voltar"
    }

    private void addJLabelTitulo() {
        JLabel jbTitulo = new JLabel("Adicionar Gelado");
        jbTitulo.setBounds(0, 30, 380, 30);
        jbTitulo.setHorizontalAlignment(JLabel.CENTER);
        jbTitulo.setFont(new Font("Arial", Font.BOLD, 20));
        add(jbTitulo);
    }

    private void addJButtonAdicionar() {
        JButton jbAdd = new JButton("Adicionar");
        jbAdd.setBounds(120, 320, 100, 40);
        OuvinteAdd ouvinte = new OuvinteAdd();
        jbAdd.addActionListener(ouvinte);
        add(jbAdd);
    }

    private void addJButtonEstoque() {
        JButton jbEstoque = new JButton("Estoque");
        jbEstoque.setBounds(10, 320, 100, 40); // Posição no canto inferior esquerdo
        jbEstoque.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                // Ação para abrir a tela de estoque
                JOptionPane.showMessageDialog(null, "Abrir tela de estoque!");
                dispose();
                new TelaEstoque();
            }
        });
        add(jbEstoque);
    }



    private class OuvinteAdd implements ActionListener {
        public void actionPerformed(ActionEvent e) {
            if (jtfSabor == null || jtfSabor.getText().equals("")) {
                JOptionPane.showMessageDialog(null, "Necessário informar o sabor!");
            } else if (jtfPreço == null || jtfPreço.getText().equals("")) {
                JOptionPane.showMessageDialog(null, "Necessário informar o preço!");
            } else {
                JOptionPane.showMessageDialog(null, "Sorvete adicionado com sucesso!");
                dispose();
                new TelaInicial();
            }
        }
    }
}
