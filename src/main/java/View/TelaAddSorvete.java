package View;

import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.List;

import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

public class TelaAddSorvete extends TelaGenericaSorvete{

	//List<Sorvete> listaDeSorvetes = SorveteDAO.getInstance().getContatos();

	public TelaAddSorvete() {
		super();
		addJLabelTitulo();
		addJButtonAdicionar();
	}

	private void addJLabelTitulo() {
		JLabel jbTitulo = new JLabel("Adicionar Gelado");
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
			if (jtfSabor == null || jtfSabor.getText().equals("") ) {
				JOptionPane.showMessageDialog(null, "Necessário informar o sabor!");
			} else if(jtfPreço == null || jtfPreço.getText().equals("")){ 
				JOptionPane.showMessageDialog(null, "Necessário informar o preço!");
			}else {
				//SorveteDTO c = new SorveteDTO(sabor, tipo, preço);
				//SorveteDAO.getInstance().cadastrarSorvete(c);
				JOptionPane.showMessageDialog(null, "Contato adicionado com sucesso!");
				dispose();
				//new TelaInicial("");
			}
		}
	}
}
