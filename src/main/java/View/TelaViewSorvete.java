package View;

import java.awt.Font;

import javax.swing.JLabel;



public class TelaViewSorvete extends TelaGenericaSorvete {
	/*public TelaViewSorvete(Sorvete sorvete) {
		super();
		jtfSabor.setText(sorvete.getSabor());
		cBTipo.setText(sorvete.getTipo());
		jtfPreço.setText(sorvete.getPreço());
		jtfSabor.setEnabled(false);
		cBTipo.setEnabled(false);
		jtfPreço.setEnabled(false);
		addJLabelTitulo();
	}*/

	private void addJLabelTitulo() {
		JLabel jbTitulo = new JLabel("Visualizar Gelado");
		jbTitulo.setBounds(0, 30, 380, 30);
		jbTitulo.setHorizontalAlignment(JLabel.CENTER);
		jbTitulo.setFont(new Font("Arial", Font.BOLD, 20));
		add(jbTitulo);
	}

}