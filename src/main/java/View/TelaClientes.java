package View;

import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableCellRenderer;
import javax.swing.table.DefaultTableModel;

public class TelaClientes extends JFrame {

	protected JTable tabela;
	private DefaultTableModel modelo;
	private JScrollPane painelTabela;

	//private ClienteDAO clienteDAO = ClienteDAO.getInstance();

	public TelaClientes(String clientes) {
		setTitle("Menu Inicial");
		setSize(480, 480);
		setLayout(null);
		setLocationRelativeTo(null);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setResizable(false);
		addJLabelTitulo();
		addTabelaClientes();
		addJButtonAdicionar();
		addJButtonEditar();
		addJButtonDeletar();
		addJButtonVisualizar();
		popularTabela(clientes);
		setVisible(true);
	}

	private void addTabelaClientes() {
		modelo = new DefaultTableModel();
		modelo.setColumnIdentifiers(new String[] { "Nome", "Telefone", "Email" });
		tabela = new JTable(modelo);
		tabela.setFont(new Font("Arial", Font.PLAIN, 17));
		painelTabela = new JScrollPane(tabela);
		painelTabela.setBounds(30, 80, 410, 290);
		add(painelTabela);
	}

	private void addJLabelTitulo() {
		JLabel jbTitulo = new JLabel("Lista de clientes");
		jbTitulo.setBounds(0, 30, 480, 30);
		jbTitulo.setHorizontalAlignment(JLabel.CENTER);
		jbTitulo.setFont(new Font("Arial", Font.BOLD, 20));

		add(jbTitulo);
	}

	private void addJButtonAdicionar() {
		JButton jbADD = new JButton("Adicionar");
		jbADD.setBounds(345, 380, 95, 50);
		OuvinteAdicionar ouvinte = new OuvinteAdicionar();
		jbADD.addActionListener(ouvinte);
		add(jbADD);

	}

	private void addJButtonEditar() {
		JButton jbEditar = new JButton("Editar");
		jbEditar.setBounds(240, 380, 95, 50);
		OuvinteEditar ouvinte = new OuvinteEditar();
		jbEditar.addActionListener(ouvinte);
		add(jbEditar);

	}

	private void addJButtonDeletar() {
		JButton jbDeletar = new JButton("Deletar");
		jbDeletar.setBounds(135, 380, 95, 50);
		OuvinteDeletar ouvinte = new OuvinteDeletar();
		jbDeletar.addActionListener(ouvinte);
		add(jbDeletar);

	}

	private void addJButtonVisualizar() {
		JButton jbView = new JButton("Visualizar");
		jbView.setBounds(30, 380, 95, 50);
		OuvinteVisualizar ouvinte = new OuvinteVisualizar();
		jbView.addActionListener(ouvinte);
		add(jbView);

	}

	private class OuvinteVisualizar implements ActionListener {

		public void actionPerformed(ActionEvent e) {
			if (tabela.getSelectedRow() == -1) {
				JOptionPane.showMessageDialog(null, "Selecione um cliente");
			} else {
				/*Cliente clienteSelecionado = clienteDAO.getClientes().get(tabela.getSelectedRow());
				dispose();
				new TelaViewCliente(clienteSelecionado);*/

			}
		}

	}
	
	private void popularTabela(String clientes) {
		
		if(clientes.equalsIgnoreCase("")) {
			/*for (Cliente a : clienteDAO.getClientes()) {
				adicionarLinhaTabela(a);
			}*/
		}else if(clientes.equalsIgnoreCase("deletados")) {
			/*for (Clientes a : clienteDAO.getClientesDeletados()) {
				adicionarLinhaTabela(a); nao sei pra que serve
			}*/
		}	

	}

	/*public void adicionarLinhaTabela(Cliente cliente) {

		Object[] linha = new Object[3];
		linha[0] = cliente.getNome();
		linha[1] = cliente.getTelefone();
		linha[2] = cliente.getEmail();

		modelo.addRow(linha);

		DefaultTableCellRenderer centerRenderer = new DefaultTableCellRenderer();
		centerRenderer.setHorizontalAlignment(DefaultTableCellRenderer.CENTER);

		for (int i = 0; i < modelo.getColumnCount(); i++) {
			tabela.getColumnModel().getColumn(i).setCellRenderer(centerRenderer);
		}
	}*/

	private class OuvinteEditar implements ActionListener {

		public void actionPerformed(ActionEvent e) {
			if (tabela.getSelectedRow() == -1) {
				JOptionPane.showMessageDialog(null, "Selecione um cliente");
			} /*else {
				Cliente clienteSelecionado = clienteDAO.getClientes().get(tabela.getSelectedRow());
				dispose();
				new TelaEditCliente(clienteSelecionado, tabela);

			}*/
		}
	}

	
	private class OuvinteAdicionar implements ActionListener {

		public void actionPerformed(ActionEvent e) {
			dispose();
			new TelaAddCliente();

		}
	}

	private class OuvinteDeletar implements ActionListener {

		public void actionPerformed(ActionEvent e) {
			if (tabela.getSelectedRow() == -1) {
				JOptionPane.showMessageDialog(null, "Selecione um cliente");
			} else {
				/*clienteDAO.deletarCliente(tabela.getSelectedRow());
				repaint();*/
				dispose();
				new TelaInicial();
			}
		}

	}

}
