package View;

import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.List;

import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTable;

public class TelaEditCliente extends TelaGenericaCliente {

	//private Cliente clienteEditar;

	//List<Cliente> listaDeClientes = ClienteDAO.getInstance().getCliente();

	private JTable tabela;

	/*public TelaEditCliente(Cliente clienteEditar, JTable tabela) {
		super();
		this.tabela = tabela;
		this.clienteEditar = clienteEditar;
		jtfNome.setText(clienteEditar.getNome());
		jtfTelefone.setText(clienteEditar.getTelefone());
		jtfEmail.setText(clienteEditar.getEmail());
		addJLabelTitulo();
		addJButtonEditar();
	}*/

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
				/*boolean edicao = ClienteDAO.getInstance().editarCliente(clienteEditar, new Cliente(nome, telefone, email));
				if (edicao == true) {
					JOptionPane.showMessageDialog(null, "Cliente editado com sucesso!");
				} else {
					JOptionPane.showMessageDialog(null, "Não foi possível editar o cliente!");
				}*/

				dispose();
				new TelaInicial();
			}
		}
	}
}
