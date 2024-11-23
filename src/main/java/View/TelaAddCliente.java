package View;

import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.List;

import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

public class TelaAddCliente extends TelaGenericaCliente{

	//List<Cliente> listaDeClientes = ClienteDAO.getInstance().getClientes();

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
				/*ClienteDTO c = new ClienteDTO(nome, telefone, email);
				ClienteDAO.getInstance().cadastrarCliente(c);
				JOptionPane.showMessageDialog(null, "Cliente adicionado com sucesso!");*/
				dispose();
				new TelaInicial();
			}
		}
	}
}
