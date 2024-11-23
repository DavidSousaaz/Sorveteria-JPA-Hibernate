package View;

import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.List;

import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTable;

public class TelaEditSorvete extends TelaGenericaSorvete {

	//private Sorvete sorveteEditar;

	//List<Sorvete> listaDeSorvetes = SorveteDAO.getInstance().getSorvetes();

	private JTable tabela;

	/*public TelaEditSorvete(Sorvete sorveteEditar, JTable tabela) {
		super();
		this.tabela = tabela;
		this.sorveteEditar = sorveteEditar;
		jtfSabor.setText(sorveteEditar.getSabor());
		cBTipo.setSelectedItem(sorveteEditar.getTipo());
		jtfPreço.setText(sorveteEditar.getPreço());
		addJLabelTitulo();
		addJButtonEditar();
	}*/

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
			/*if (jtfSabor == null || jtfSabor.getText().equals("") ) {
				JOptionPane.showMessageDialog(null, "Necessário informar o sabor!");
			} else if(jtfPreço == null || jtfPreço.getText().equals("")){ 
				JOptionPane.showMessageDialog(null, "Necessário informar o preço!");
			}else {
				boolean edicao = SorveteDAO.getInstance().editarSorvete(sorveteEditar, new Sorvete(sabor, tipo, preço));
				if (edicao == true) {
					JOptionPane.showMessageDialog(null, "Gelado editado com sucesso!");
				} else {
					JOptionPane.showMessageDialog(null, "Não foi possível editar o gelado!");
				}

				dispose();
				new TelaInicial();
			}*/
		}
	}
}
