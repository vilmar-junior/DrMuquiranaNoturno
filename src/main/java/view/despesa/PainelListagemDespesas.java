package view.despesa;

import java.awt.Font;
import java.util.ArrayList;

import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTable;
import javax.swing.LayoutStyle.ComponentPlacement;

import controller.ControladoraDespesa;
import controller.ControladoraUsuario;
import model.vo.UsuarioVO;

public class PainelListagemDespesas extends JPanel {
	
	private ControladoraDespesa controller = new ControladoraDespesa(); 
	
	//Componentes da tela
	private JTable tblDespesas;
	private JComboBox cbUsuarios;
	private JComboBox cbCategorias;
	private JButton btnConsultar;
	private JButton btnLimpar;
	private JButton btnNovaDespesa;
	private JButton btnEditar;
	private JButton btnExcluir;

	/**
	 * Create the panel.
	 */
	public PainelListagemDespesas() {

		JLabel lblDespesas = new JLabel("Despesas");
		lblDespesas.setFont(new Font("Tahoma", Font.BOLD, 14));

		JLabel lblUsuario = new JLabel("Usuário:");

		ControladoraUsuario usuarioController = new ControladoraUsuario();
		ArrayList<UsuarioVO> usuarios = usuarioController.consultarTodosUsuariosController();
		cbUsuarios = new JComboBox(usuarios.toArray());

		JLabel lblCategoria = new JLabel("Categoria:");
		
		ArrayList<String> categorias = controller.consultarCategorias();
		cbCategorias = new JComboBox(categorias.toArray());

		tblDespesas = new JTable();
		btnConsultar = new JButton("Consultar");
		btnLimpar = new JButton("Limpar");
		btnNovaDespesa = new JButton("Nova despesa");

		btnEditar = new JButton("Editar");
		btnEditar.setEnabled(false);

		btnExcluir = new JButton("Excluir");
		btnExcluir.setEnabled(false);
		GroupLayout groupLayout = new GroupLayout(this);
		groupLayout.setHorizontalGroup(
				groupLayout.createParallelGroup(Alignment.LEADING)
				.addGroup(groupLayout.createSequentialGroup()
						.addGap(255)
						.addComponent(lblDespesas)
						.addContainerGap(265, Short.MAX_VALUE))
				.addGroup(groupLayout.createSequentialGroup()
						.addGap(200)
						.addComponent(btnConsultar)
						.addPreferredGap(ComponentPlacement.RELATED)
						.addComponent(btnLimpar, GroupLayout.PREFERRED_SIZE, 77, GroupLayout.PREFERRED_SIZE)
						.addContainerGap(237, Short.MAX_VALUE))
				.addGroup(groupLayout.createSequentialGroup()
						.addGap(141)
						.addComponent(btnNovaDespesa)
						.addGap(18)
						.addComponent(btnEditar, GroupLayout.PREFERRED_SIZE, 90, GroupLayout.PREFERRED_SIZE)
						.addGap(27)
						.addComponent(btnExcluir, GroupLayout.PREFERRED_SIZE, 97, GroupLayout.PREFERRED_SIZE)
						.addContainerGap(125, Short.MAX_VALUE))
				.addGroup(groupLayout.createSequentialGroup()
						.addGap(39)
						.addGroup(groupLayout.createParallelGroup(Alignment.LEADING)
								.addGroup(groupLayout.createSequentialGroup()
										.addComponent(tblDespesas, GroupLayout.PREFERRED_SIZE, 531, GroupLayout.PREFERRED_SIZE)
										.addContainerGap())
								.addGroup(groupLayout.createSequentialGroup()
										.addComponent(lblUsuario)
										.addPreferredGap(ComponentPlacement.RELATED)
										.addComponent(cbUsuarios, GroupLayout.PREFERRED_SIZE, 162, GroupLayout.PREFERRED_SIZE)
										.addGap(42)
										.addComponent(lblCategoria)
										.addPreferredGap(ComponentPlacement.UNRELATED)
										.addComponent(cbCategorias, 0, 168, Short.MAX_VALUE)
										.addGap(68))))
				);
		groupLayout.setVerticalGroup(
				groupLayout.createParallelGroup(Alignment.LEADING)
				.addGroup(groupLayout.createSequentialGroup()
						.addGap(27)
						.addComponent(lblDespesas)
						.addGap(18)
						.addGroup(groupLayout.createParallelGroup(Alignment.BASELINE)
								.addComponent(lblUsuario)
								.addComponent(cbUsuarios, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
								.addComponent(cbCategorias, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
								.addComponent(lblCategoria))
						.addGap(18)
						.addGroup(groupLayout.createParallelGroup(Alignment.BASELINE)
								.addComponent(btnConsultar)
								.addComponent(btnLimpar))
						.addGap(18)
						.addComponent(tblDespesas, GroupLayout.DEFAULT_SIZE, 268, Short.MAX_VALUE)
						.addGap(18)
						.addGroup(groupLayout.createParallelGroup(Alignment.BASELINE)
								.addComponent(btnNovaDespesa)
								.addComponent(btnEditar)
								.addComponent(btnExcluir))
						.addContainerGap())
				);
		setLayout(groupLayout);

	}
}
