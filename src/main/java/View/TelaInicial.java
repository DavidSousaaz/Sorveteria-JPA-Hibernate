package View;

import Model.*;
import controller.*;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.util.List;


public class TelaInicial extends JFrame{

	private List<Cliente> clienteList = new ClienteController().listarTodosClientes();
	private List<Sorvete> sorveteList = new SorveteController().listarTodosSorvetes();


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
			new TelaSorvetes(sorveteList); //colocar o parametro de entrada certo
			dispose();
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
			new TelaClientes(clienteList); //colocar o parametro de entrada certo
			dispose();
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
			new TelaPedidos(sorveteList); //criar tela de pedidos e botar os parametros de entrada
			dispose();
		}
	}
}
