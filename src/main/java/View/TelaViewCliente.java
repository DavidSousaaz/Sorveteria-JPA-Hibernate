package View;

import Model.*;

import javax.swing.*;
import java.awt.*;



public class TelaViewCliente extends TelaGenericaCliente{
	public TelaViewCliente(Cliente cliente) {
		super();
		super.setCliente(cliente);
		jtfNome.setText(cliente.getNome());
		jtfTelefone.setText(cliente.getTelefone());
		jtfEmail.setText(cliente.getEmail());
		jtfNome.setEnabled(false);
		jtfTelefone.setEnabled(false);
		jtfEmail.setEnabled(false);
		addJLabelTitulo();
	}

	private void addJLabelTitulo() {
		JLabel jbTitulo = new JLabel("Visualizar Cliente");
		jbTitulo.setBounds(0, 30, 380, 30);
		jbTitulo.setHorizontalAlignment(JLabel.CENTER);
		jbTitulo.setFont(new Font("Arial", Font.BOLD, 20));
		add(jbTitulo);
	}

}