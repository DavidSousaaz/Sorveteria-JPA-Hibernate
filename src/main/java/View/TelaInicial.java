package View;

import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;


public class TelaInicial extends JFrame{
	public TelaInicial() {
		setTitle("Menu");
		setSize(360, 250);
		setLayout(null);
		setLocationRelativeTo(null);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setResizable(false);
		addJLabelTitulo();
		addJButtonClientes();
		addJButtonSorvetes();
		addJButtonPedidos();
		setVisible(true);
	}
	
	private void addJLabelTitulo() {
		JLabel jbTitulo = new JLabel("Menu Inicial");
		jbTitulo.setBounds(0, 30, 360, 30);
		jbTitulo.setHorizontalAlignment(JLabel.CENTER);
		jbTitulo.setFont(new Font("Arial", Font.BOLD, 20));

		add(jbTitulo);
	}
	
	
	private void addJButtonClientes() {
		JButton jbEdit = new JButton("Sorvetes");
		jbEdit.setBounds(20, 130, 90, 40);
		OuvinteSorvetes ouvinte = new OuvinteSorvetes();
		jbEdit.addActionListener(ouvinte);
		add(jbEdit);

	}
	private class OuvinteSorvetes implements ActionListener {

		public void actionPerformed(ActionEvent e) {
			new TelaSorvetes(""); //colocar o parametro de entrada certo
		}
	}
		
	
	private void addJButtonSorvetes() {
		JButton jbEdit = new JButton("Clientes");
		jbEdit.setBounds(240, 130, 90, 40);
		OuvinteClientes ouvinte = new OuvinteClientes();
		jbEdit.addActionListener(ouvinte);
		add(jbEdit);

	}
	
	private class OuvinteClientes implements ActionListener {

		public void actionPerformed(ActionEvent e) {
			new TelaClientes(""); //colocar o parametro de entrada certo
			
		}
	}
	
	private void addJButtonPedidos() {
		JButton jbEdit = new JButton("Pedidos");
		jbEdit.setBounds(130, 130, 90, 40);
		OuvintePedidos ouvinte = new OuvintePedidos();
		jbEdit.addActionListener(ouvinte);
		add(jbEdit);

	}
	
	private class OuvintePedidos implements ActionListener {

		public void actionPerformed(ActionEvent e) {
			new TelaPedidos(); //criar tela de pedidos e botar os parametros de entrada
		}
	}
}
