package View;

import Model.*;
import controller.*;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class TelaEditCliente extends TelaGenericaCliente {

	private ClienteController clienteController = new ClienteController();

	private Cliente clienteEditar;


	private JTable tabela;

	public TelaEditCliente(Cliente clienteEditar, JTable tabela) {
		super();
		this.tabela = tabela;
		this.clienteEditar = clienteEditar;
		jtfNome.setText(clienteEditar.getNome());
		jtfTelefone.setText(clienteEditar.getTelefone());
		jtfEmail.setText(clienteEditar.getEmail());
		addJLabelTitulo();
		addJButtonEditar();
	}

	private void addJLabelTitulo() {
		JLabel jbTitulo = new JLabel("Editar Cliente");
		jbTitulo.setBounds(0, 30, 380, 30);
		jbTitulo.setHorizontalAlignment(JLabel.CENTER);
		jbTitulo.setFont(new Font("Arial", Font.BOLD, 20));
		add(jbTitulo);
	}

	private void addJButtonEditar() {
		JButton jbEdit = new JButton("Editar");
		jbEdit.setBounds(120, 320, 100, 40);
		OuvinteEdit ouvinte = new OuvinteEdit();
		jbEdit.addActionListener(ouvinte);
		add(jbEdit);

	}

	private class OuvinteEdit implements ActionListener {

		public void actionPerformed(ActionEvent e) {
			if (jtfNome == null || jtfNome.getText().equals("")) {
				JOptionPane.showMessageDialog(null, "Necessário informar o nome!");
			} else {
				clienteEditar.setNome(jtfNome.getText());
				clienteEditar.setTelefone(jtfTelefone.getText());
				clienteEditar.setEmail(jtfEmail.getText());
				clienteController.salvarCliente(clienteEditar);
				JOptionPane.showMessageDialog(null, "Informações editadas com sucesso!");
				dispose();
				new TelaInicial();
			}
		}
	}
}
