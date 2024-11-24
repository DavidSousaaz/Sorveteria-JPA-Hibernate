package View;

import javax.swing.*;
import java.awt.event.*;

public class TelaGenericaSorvete extends JFrame {

	public TelaGenericaSorvete() {
		setTitle("");
		setSize(380, 420);
		setLayout(null);
		setLocationRelativeTo(null);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setResizable(false);
		addJButtonVoltar();
		addJLabelSabor();
		addJLabelTipo();
		addJLabelPreço();
		addJTextFieldSabor();
		addJTextFieldTipo();
		addJTextFieldPreço();
		setVisible(true);
	}

	protected JTextField jtfSabor;
	protected JComboBox<String> cBTipo;
	protected JTextField jtfPreço;
	protected String sabor;
	protected String tipo;
	protected String preço;

	private void addJLabelSabor() {
		JLabel jbSabor = new JLabel("Sabor: ");
		jbSabor.setBounds(30, 90, 120, 30);
		add(jbSabor);
	}

	private void addJLabelTipo() {
		JLabel jbTipo = new JLabel("Tipo: ");
		jbTipo.setBounds(30, 160, 120, 30);
		add(jbTipo);
	}

	private void addJLabelPreço() {
		JLabel jbPreço = new JLabel("Preço: ");
		jbPreço.setBounds(30, 230, 120, 30);
		add(jbPreço);
	}

	private void addJButtonVoltar() {
		JButton jbVoltar = new JButton("Voltar");
		jbVoltar.setBounds(240, 320, 100, 40);
		OuvinteVoltar ouvinte = new OuvinteVoltar();
		jbVoltar.addActionListener(ouvinte);
		add(jbVoltar);

	}

	private class OuvinteVoltar implements ActionListener {

		public void actionPerformed(ActionEvent e) {
			dispose();
			new TelaInicial();  
		}
	}

	private void addJTextFieldSabor() {
		jtfSabor = new JTextField();
		jtfSabor.setBounds(30, 120, 310, 30);
		OuvinteJTFSabor ouvinte = new OuvinteJTFSabor();
		jtfSabor.addFocusListener(ouvinte);
		add(jtfSabor);
	}

	private class OuvinteJTFSabor implements FocusListener {

		@Override
		public void focusGained(FocusEvent e) {
		}

		@Override
		public void focusLost(FocusEvent e) {
			sabor = (String) jtfSabor.getText();
		}

	}

	private void addJTextFieldTipo() {
		String[] tipos = {"Picolé", "Sorvete", "Sundae"};
		cBTipo = new JComboBox<>(tipos);
		cBTipo.setBounds(30, 190, 310, 30);
		OuvinteJTFTipo ouvinte = new OuvinteJTFTipo();
		cBTipo.addFocusListener(ouvinte);
		add(cBTipo);
	}

	private class OuvinteJTFTipo implements FocusListener {

		@Override
		public void focusGained(FocusEvent e) {
		}

		@Override
		public void focusLost(FocusEvent e) {			
			tipo = (String) cBTipo.getSelectedItem();
		
		}

	}

	private void addJTextFieldPreço() {
		jtfPreço = new JTextField();
		jtfPreço.setBounds(30, 260, 310, 30);
		OuvinteJTFPreço ouvinte = new OuvinteJTFPreço();
		jtfPreço.addFocusListener(ouvinte);
		add(jtfPreço);
	}

	private class OuvinteJTFPreço implements FocusListener {

		@Override
		public void focusGained(FocusEvent e) {
		}

		@Override
		public void focusLost(FocusEvent e) {
			preço = jtfPreço.getText();
		}

	}
}
