package View;

import Model.*;

import javax.swing.*;
import java.awt.*;



public class TelaViewSorvete extends TelaGenericaSorvete {
	public TelaViewSorvete(Sorvete sorvete) {
		super();
		jtfSabor.setText(sorvete.getSabor());
		cBTipo.setEnabled(false);
		cBTipo.setSelectedItem(sorvete.getTipo());
		jtfPreço.setText( sorvete.getPreco().toString());
		jtfSabor.setEnabled(false);
		cBTipo.setEnabled(false);
		jtfPreço.setEnabled(false);
		addJLabelTitulo();
	}

	private void addJLabelTitulo() {
		JLabel jbTitulo = new JLabel("Visualizar Gelado");
		jbTitulo.setBounds(0, 30, 380, 30);
		jbTitulo.setHorizontalAlignment(JLabel.CENTER);
		jbTitulo.setFont(new Font("Arial", Font.BOLD, 20));
		add(jbTitulo);
	}

}
