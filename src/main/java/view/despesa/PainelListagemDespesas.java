package view.despesa;


import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;

import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTable;
import javax.swing.LayoutStyle.ComponentPlacement;
import javax.swing.table.DefaultTableModel;

import controller.ControladoraDespesa;
import controller.ControladoraUsuario;
import model.seletor.DespesaSeletor;
import model.vo.DespesaVO;
import model.vo.UsuarioVO;
import javax.swing.SwingConstants;

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
	private String[] nomesColunas = {"#", "Id Usuário", "Categoria", "Data Vencimento", "Data Pagamento"};
	private DateTimeFormatter formatadorDeData = DateTimeFormatter.ofPattern("dd-MM-yy");
	private int paginaAtual = 1;
	private JLabel lblPaginaAtual;
	private JLabel lblTotalPaginas;
	private int totalPaginas;

	private JButton btnVoltarPagina;

	private JButton btnAvancarPagina;
	
	private static final int LIMITE_REGISTROS_CONSULTA_DESPESAS = 15;

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

		limparCamposConsulta();

		tblDespesas = new JTable();
		btnConsultar = new JButton("Consultar");
		btnConsultar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				consultarDespesas();
			}
		});
		btnLimpar = new JButton("Limpar");
		btnLimpar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				limparCamposConsulta();
			}
		});
		btnNovaDespesa = new JButton("Nova despesa");
		btnNovaDespesa.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}
		});

		btnEditar = new JButton("Editar");
		btnEditar.setEnabled(false);

		btnExcluir = new JButton("Excluir");
		btnExcluir.setEnabled(false);
		
		btnVoltarPagina = new JButton("<<");
		btnVoltarPagina.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if(paginaAtual > 1) {
					paginaAtual--;
					lblPaginaAtual.setText(paginaAtual + "");
					consultarDespesas();
				}
			}
		});
		btnVoltarPagina.setEnabled(false);
		
		btnAvancarPagina = new JButton(">>");
		btnAvancarPagina.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if(paginaAtual < totalPaginas) {
					paginaAtual++;
					lblPaginaAtual.setText(paginaAtual + "");
					consultarDespesas();
				}
			}
		});
		
		verificarBotoesPaginas();
		JLabel lblPagina = new JLabel("Página");
		
		lblPaginaAtual = new JLabel("1");
		lblPaginaAtual.setHorizontalAlignment(SwingConstants.RIGHT);
		
		JLabel labelBarra = new JLabel("/");
		
		lblTotalPaginas = new JLabel("");
		GroupLayout groupLayout = new GroupLayout(this);
		groupLayout.setHorizontalGroup(
			groupLayout.createParallelGroup(Alignment.LEADING)
				.addGroup(groupLayout.createSequentialGroup()
					.addGap(255)
					.addComponent(lblDespesas)
					.addContainerGap(280, Short.MAX_VALUE))
				.addGroup(groupLayout.createSequentialGroup()
					.addGap(200)
					.addComponent(btnConsultar, GroupLayout.DEFAULT_SIZE, 79, Short.MAX_VALUE)
					.addGap(34)
					.addComponent(btnLimpar, GroupLayout.DEFAULT_SIZE, 77, Short.MAX_VALUE)
					.addGap(209))
				.addGroup(groupLayout.createSequentialGroup()
					.addGap(39)
					.addGroup(groupLayout.createParallelGroup(Alignment.LEADING)
						.addComponent(tblDespesas, Alignment.TRAILING, GroupLayout.DEFAULT_SIZE, 531, Short.MAX_VALUE)
						.addGroup(groupLayout.createSequentialGroup()
							.addComponent(lblUsuario)
							.addPreferredGap(ComponentPlacement.RELATED)
							.addComponent(cbUsuarios, 0, 194, Short.MAX_VALUE)
							.addPreferredGap(ComponentPlacement.UNRELATED)
							.addComponent(lblCategoria)
							.addPreferredGap(ComponentPlacement.UNRELATED)
							.addComponent(cbCategorias, 0, 222, Short.MAX_VALUE)))
					.addGap(29))
				.addGroup(groupLayout.createSequentialGroup()
					.addGap(80)
					.addGroup(groupLayout.createParallelGroup(Alignment.LEADING, false)
						.addComponent(btnVoltarPagina, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
						.addComponent(btnNovaDespesa, GroupLayout.DEFAULT_SIZE, 122, Short.MAX_VALUE))
					.addPreferredGap(ComponentPlacement.RELATED)
					.addGroup(groupLayout.createParallelGroup(Alignment.LEADING)
						.addGroup(groupLayout.createSequentialGroup()
							.addGap(18)
							.addComponent(btnEditar, GroupLayout.DEFAULT_SIZE, 175, Short.MAX_VALUE)
							.addGap(27))
						.addGroup(groupLayout.createSequentialGroup()
							.addGap(35)
							.addComponent(lblPagina, GroupLayout.PREFERRED_SIZE, 40, GroupLayout.PREFERRED_SIZE)
							.addPreferredGap(ComponentPlacement.UNRELATED)
							.addComponent(lblPaginaAtual, GroupLayout.PREFERRED_SIZE, 26, GroupLayout.PREFERRED_SIZE)
							.addPreferredGap(ComponentPlacement.RELATED)
							.addComponent(labelBarra, GroupLayout.PREFERRED_SIZE, 25, GroupLayout.PREFERRED_SIZE)
							.addPreferredGap(ComponentPlacement.UNRELATED)
							.addComponent(lblTotalPaginas)
							.addGap(50)))
					.addGroup(groupLayout.createParallelGroup(Alignment.LEADING)
						.addComponent(btnAvancarPagina, GroupLayout.DEFAULT_SIZE, 127, Short.MAX_VALUE)
						.addComponent(btnExcluir, Alignment.TRAILING, GroupLayout.DEFAULT_SIZE, 127, Short.MAX_VALUE))
					.addGap(50))
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
					.addComponent(tblDespesas, GroupLayout.PREFERRED_SIZE, 285, GroupLayout.PREFERRED_SIZE)
					.addPreferredGap(ComponentPlacement.RELATED)
					.addGroup(groupLayout.createParallelGroup(Alignment.BASELINE)
						.addComponent(btnVoltarPagina)
						.addComponent(lblPagina)
						.addComponent(lblTotalPaginas)
						.addComponent(lblPaginaAtual)
						.addComponent(labelBarra)
						.addComponent(btnAvancarPagina))
					.addPreferredGap(ComponentPlacement.RELATED)
					.addGroup(groupLayout.createParallelGroup(Alignment.BASELINE)
						.addComponent(btnNovaDespesa)
						.addComponent(btnEditar)
						.addComponent(btnExcluir))
					.addContainerGap(GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
		);
		setLayout(groupLayout);

	}

	protected void verificarBotoesPaginas() {
		this.btnVoltarPagina.setEnabled(paginaAtual > 1);
		this.btnAvancarPagina.setEnabled(paginaAtual < totalPaginas);
	}

	protected void consultarDespesas() {
		DespesaSeletor seletor = new DespesaSeletor();
		seletor.setUsuario((UsuarioVO)cbUsuarios.getSelectedItem());
		seletor.setCategoria((String)cbCategorias.getSelectedItem());
		seletor.setPagina(paginaAtual);
		seletor.setLimite(LIMITE_REGISTROS_CONSULTA_DESPESAS);

		ControladoraDespesa controller = new ControladoraDespesa();
		ArrayList<DespesaVO> despesas = controller.consultarDespesas(seletor);
	
		totalPaginas = controller.consultarTotalPaginas(seletor);
		lblTotalPaginas.setText(totalPaginas + "");
		
		atualizarTabelaDespesas(despesas);
		verificarBotoesPaginas();
	}

	private void limparCamposConsulta() {
		cbCategorias.setSelectedIndex(-1);
		cbUsuarios.setSelectedIndex(-1);
	}

	private void limparTabelaDespesas() {
		tblDespesas.setModel(new DefaultTableModel(
				new Object[][] {nomesColunas,},nomesColunas));
	}

	protected void atualizarTabelaDespesas(ArrayList<DespesaVO> despesas) {
		limparTabelaDespesas();

		DefaultTableModel modeloTabelaDespesas = (DefaultTableModel) tblDespesas.getModel();
		for(DespesaVO desp: despesas) {
			String[] novaLinha = new String[5];
			novaLinha[0] = desp.getId() + "";
			novaLinha[1] = desp.getIdUsuario() + "";
			novaLinha[2] = desp.getCategoria();
			novaLinha[3] = desp.getDataVencimento().format(formatadorDeData);

			if(desp.getDataPagamento() != null) {
				novaLinha[4] = desp.getDataPagamento().format(formatadorDeData);
			}

			modeloTabelaDespesas.addRow(novaLinha);
		}
	}

	public JButton getBtnNovaDespesa() {
		return btnNovaDespesa;
	}
}
