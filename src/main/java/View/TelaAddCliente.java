package View;

import Model.*;
import controller.*;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class TelaAddCliente extends TelaGenericaCliente{

	private ClienteController clienteController = new ClienteController();

	public TelaAddCliente() {
		super();
		addJLabelTitulo();
		addJButtonAdicionar();
	}

	private void addJLabelTitulo() {
		JLabel jbTitulo = new JLabel("Adicionar Cliente");
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

	private class OuvinteAdd implements ActionListener {

		public void actionPerformed(ActionEvent e) {
			if (jtfNome == null || jtfNome.getText().equals("")) {
				JOptionPane.showMessageDialog(null, "Necessário informar o nome!");
			} else {
				Cliente c = new Cliente();
				c.setNome(jtfNome.getText());
				c.setTelefone(jtfTelefone.getText());
				c.setEmail(jtfEmail.getText());

				clienteController.salvarCliente(c);
				JOptionPane.showMessageDialog(null, "Cliente adicionado com sucesso!");
				dispose();
				new TelaInicial();
			}
		}
	}
}
