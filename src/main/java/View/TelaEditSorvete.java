package View;

import Model.*;
import controller.*;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.math.*;

public class TelaEditSorvete extends TelaGenericaSorvete {

	private Sorvete sorveteEditar;

	private SorveteController sorveteController = new SorveteController();

	private JTable tabela;

	public TelaEditSorvete(Sorvete sorveteEditar, JTable tabela) {
		super();
		this.tabela = tabela;
		this.sorveteEditar = sorveteEditar;
		jtfSabor.setText(sorveteEditar.getSabor());
		cBTipo.setSelectedItem(sorveteEditar.getTipo());
		jtfPreço.setText(sorveteEditar.getPreco().toString());
		addJLabelTitulo();
		addJButtonEditar();
	}

	private void addJLabelTitulo() {
		JLabel jbTitulo = new JLabel("Editar Gelado");
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
			if (jtfSabor == null || jtfSabor.getText().equals("") ) {
				JOptionPane.showMessageDialog(null, "Necessário informar o sabor!");
			} else if(jtfPreço == null || jtfPreço.getText().equals("")){ 
				JOptionPane.showMessageDialog(null, "Necessário informar o preço!");
			}else {
				sorveteEditar.setSabor(jtfSabor.getText());
				sorveteEditar.setPreco(new BigDecimal(jtfPreço.getText()));
				sorveteEditar.setTipo((String) cBTipo.getSelectedItem());
				sorveteController.salvarSorvete(sorveteEditar);
				JOptionPane.showMessageDialog(null, " Sorvete editado com sucesso!");
				dispose();
				new TelaSorvetes(sorveteController.listarTodosSorvetes());
			}
		}
	}
}
