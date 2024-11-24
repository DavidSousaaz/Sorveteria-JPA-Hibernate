package View;

import javax.swing.*;
import java.awt.event.*;

public class TelaGenericaCliente extends JFrame {

	public TelaGenericaCliente() {
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
		addJTextFieldNome();
		addJTextFieldTelefone();
		addJTextFieldEmail();
		setVisible(true);
	}

	protected JTextField jtfNome;
	protected JTextField jtfTelefone;
	protected JTextField jtfEmail;
	protected String nome;
	protected String telefone;
	protected String email;

	private void addJLabelSabor() {
		JLabel jbSabor = new JLabel("Nome: ");
		jbSabor.setBounds(30, 90, 120, 30);
		add(jbSabor);
	}

	private void addJLabelTipo() {
		JLabel jbTipo = new JLabel("Telefone: ");
		jbTipo.setBounds(30, 160, 120, 30);
		add(jbTipo);
	}

	private void addJLabelPreço() {
		JLabel jbPreço = new JLabel("Email: ");
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

	private void addJTextFieldNome() {
		jtfNome = new JTextField();
		jtfNome.setBounds(30, 120, 310, 30);
		OuvinteJTFNome ouvinte = new OuvinteJTFNome();
		jtfNome.addFocusListener(ouvinte);
		add(jtfNome);
	}

	private class OuvinteJTFNome implements FocusListener {

		@Override
		public void focusGained(FocusEvent e) {
		}

		@Override
		public void focusLost(FocusEvent e) {
			nome = (String) jtfNome.getText();
		}

	}

	private void addJTextFieldTelefone() {
		jtfTelefone = new JTextField();
		jtfTelefone.setBounds(30, 190, 310, 30);
		OuvinteJTFTelefone ouvinte = new OuvinteJTFTelefone();
		jtfTelefone.addFocusListener(ouvinte);
		add(jtfTelefone);
	}

	private class OuvinteJTFTelefone implements FocusListener {

		@Override
		public void focusGained(FocusEvent e) {
		}

		@Override
		public void focusLost(FocusEvent e) {			
			telefone = (String) jtfTelefone.getText();
		
		}

	}

	private void addJTextFieldEmail() {
		jtfEmail = new JTextField();
		jtfEmail.setBounds(30, 260, 310, 30);
		OuvinteJTFEmail ouvinte = new OuvinteJTFEmail();
		jtfEmail.addFocusListener(ouvinte);
		add(jtfEmail);
	}

	private class OuvinteJTFEmail implements FocusListener {

		@Override
		public void focusGained(FocusEvent e) {
		}

		@Override
		public void focusLost(FocusEvent e) {
			email = jtfEmail.getText();
		}

	}
}
