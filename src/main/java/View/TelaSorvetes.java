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

public class TelaSorvetes extends JFrame {

	protected JTable tabela;
	private DefaultTableModel modelo;
	private JScrollPane painelTabela;

	//private SorveteDAO sorveteDAO = SorveteDAO.getInstance();

	public TelaSorvetes(String sorvetes) {
		setTitle("Menu Inicial");
		setSize(480, 480);
		setLayout(null);
		setLocationRelativeTo(null);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setResizable(false);
		addJLabelTitulo();
		addTabelaContatos();
		addJButtonAdicionar();
		addJButtonEditar();
		addJButtonDeletar();
		addJButtonVisualizar();
		popularTabela(sorvetes);
		setVisible(true);
	}

	private void addTabelaContatos() {
		modelo = new DefaultTableModel();
		modelo.setColumnIdentifiers(new String[] { "Sabor", "Tipo", "Preço" });
		tabela = new JTable(modelo);
		tabela.setFont(new Font("Arial", Font.PLAIN, 17));
		painelTabela = new JScrollPane(tabela);
		painelTabela.setBounds(30, 80, 410, 290);
		add(painelTabela);
	}

	private void addJLabelTitulo() {
		JLabel jbTitulo = new JLabel("Lista de sorvetes");
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
				JOptionPane.showMessageDialog(null, "Selecione um sorvete");
			} else {
				/*Sorvete sorveteSelecionado = sorveteDAO.getContatos().get(tabela.getSelectedRow());
				dispose();
				new TelaViewSorvete(sorveteSelecionado);*/

			}
		}

	}
	
	private void popularTabela(String sorvetes) {
		
		if(sorvetes.equalsIgnoreCase("")) {
			/*for (Sorvete a : sorveteDAO.getContatos()) {
				adicionarLinhaTabela(a);
			}*/
		}else if(sorvetes.equalsIgnoreCase("deletados")) {
			/*for (Sorvete a : sorveteDAO.getContatosDeletados()) {
				adicionarLinhaTabela(a);
			}*/
		}	

	}

	/*public void adicionarLinhaTabela(Sorvete sorvete) {

		Object[] linha = new Object[3];
		linha[0] = sorvete.getSabor();
		linha[1] = sorvete.getTipo();
		linha[2] = sorvete.getPreço();

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
				JOptionPane.showMessageDialog(null, "Selecione um sorvete");
			} /*else {
				Sorvete sorveteSelecionado = sorveteDAO.getContatos().get(tabela.getSelectedRow());
				dispose();
				new TelaEditSorvete(sorveteSelecionado, tabela);

			}*/
		}
	}

	
	private class OuvinteAdicionar implements ActionListener {

		public void actionPerformed(ActionEvent e) {
			dispose();
			new TelaAddSorvete();

		}
	}

	private class OuvinteDeletar implements ActionListener {

		public void actionPerformed(ActionEvent e) {
			if (tabela.getSelectedRow() == -1) {
				JOptionPane.showMessageDialog(null, "Selecione um sorvete");
			} /*else {
				sorveteDAO.deletarContato(tabela.getSelectedRow());
				repaint();
				dispose();
				new TelaInicial(""); //lembrar de pensar na tela inicial
			}*/
		}

	}

}
