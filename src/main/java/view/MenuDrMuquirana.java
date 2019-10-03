package view;

import java.awt.Dimension;
import java.awt.EventQueue;
import java.awt.Graphics;
import java.awt.Image;

import javax.swing.JFrame;
import java.awt.Toolkit;
import javax.swing.JMenuBar;
import javax.swing.JMenu;
import javax.swing.JMenuItem;
import javax.swing.JOptionPane;

import view.despesa.PainelDetalheDespesa;
import view.despesa.PainelListagemDespesas;

import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.JSplitPane;
import javax.swing.JTabbedPane;
import javax.swing.SwingUtilities;
import javax.swing.border.BevelBorder;
import javax.swing.JPanel;
import javax.swing.JButton;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

public class MenuDrMuquirana {

	public JFrame frmDrMuquirana;
	private JPanel painelEsquerdo;
	private JPanel painelDireito;
	
	private PainelListagemDespesas painelDespesas = null;
	private PainelDetalheDespesa painelCadastroDespesa = null;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					MenuDrMuquirana window = new MenuDrMuquirana();
					window.frmDrMuquirana.setExtendedState(JFrame.MAXIMIZED_BOTH);
					window.frmDrMuquirana.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 */
	public MenuDrMuquirana() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frmDrMuquirana = new JFrame();
		frmDrMuquirana.setTitle("Dr. Muquirana");
		frmDrMuquirana.setIconImage(Toolkit.getDefaultToolkit().getImage(MenuDrMuquirana.class.getResource("/icones/scrooge-McDuck-icon.png")));
		frmDrMuquirana.setBounds(100, 100, 450, 300);
		frmDrMuquirana.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		
		JMenuBar menubar = new JMenuBar();
		frmDrMuquirana.setJMenuBar(menubar);
		
		JMenu mnReceitas = new JMenu("Receitas");
		menubar.add(mnReceitas);
		
		JMenuItem mntmListar = new JMenuItem("Listar");
		mntmListar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				JOptionPane.showMessageDialog(null, "Olá");
			}
		});
		mnReceitas.add(mntmListar);
		
		JMenuItem mntmNova = new JMenuItem("Nova");
		mnReceitas.add(mntmNova);
		
		JMenu mnDespesas = new JMenu("Despesas");
		menubar.add(mnDespesas);
		
		JMenuItem mntmListarDespesas = new JMenuItem("Listar");
		mntmListarDespesas.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent evt) {
				if(painelDespesas == null) {
					painelDespesas = new PainelListagemDespesas();
					painelDireito.add(painelDespesas);
					frmDrMuquirana.revalidate();
					
					//Adiciona listener (ouvinte) para o clique em nova despesa, que abrirá uma outra tela
					painelDespesas.getBtnNovaDespesa().addActionListener(new ActionListener() {
						public void actionPerformed(ActionEvent evt) {
							mostrarPainelCadastroDespesa();
						}
					});
				}
			}
		});
		mnDespesas.add(mntmListarDespesas);
		
		JMenuItem mntmNovaDespesa = new JMenuItem("Nova");
		mntmNovaDespesa.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				mostrarPainelCadastroDespesa();
			}
		});
		mnDespesas.add(mntmNovaDespesa);
		
		JMenu mnUsuarios = new JMenu("Usuários");
		menubar.add(mnUsuarios);
		
		JMenuItem mntmListarUsuarios = new JMenuItem("Listar");
		mnUsuarios.add(mntmListarUsuarios);
		
		JMenu mnRelatorios = new JMenu("Relatórios");
		menubar.add(mnRelatorios);
		
		JMenu mnSobre = new JMenu("Sobre");
		menubar.add(mnSobre);
		frmDrMuquirana.getContentPane().setLayout(null);
		
		Dimension dimensoesTela = Toolkit.getDefaultToolkit().getScreenSize();
		int larguraDosPaineis = (int) ((dimensoesTela.getWidth() - 20) / 2);
		int alturaDaTela = (int) (dimensoesTela.getHeight() - 10);
		
		final Image planoDeFundo = Toolkit.getDefaultToolkit().getImage(MenuDrMuquirana.class.getResource("/icones/tio_patinhas.png"));
		painelEsquerdo = (new JPanel() {
	         @Override
	         public void paintComponent(Graphics g) {
	            super.paintComponent(g);
	            g.drawImage(planoDeFundo, 0, 0, null);
	         }
	      });
		painelEsquerdo.setVisible(true);
		
		painelEsquerdo.setBorder(new BevelBorder(BevelBorder.LOWERED, null, null, null, null));
		painelEsquerdo.setBounds(10, 10, larguraDosPaineis, alturaDaTela);
		frmDrMuquirana.getContentPane().add(painelEsquerdo);
		
		painelDireito = new JPanel();
		painelDireito.setBorder(new BevelBorder(BevelBorder.LOWERED, null, null, null, null));
		painelDireito.setBounds(larguraDosPaineis + 10, 10, larguraDosPaineis, alturaDaTela);
		frmDrMuquirana.getContentPane().add(painelDireito);
	}
	
	private void mostrarPainelCadastroDespesa() {
		if(painelCadastroDespesa == null) {
			painelCadastroDespesa = new PainelDetalheDespesa();
			painelEsquerdo.add(painelCadastroDespesa);
		}else {
			painelEsquerdo.setVisible(true);
		}
		frmDrMuquirana.revalidate();
	}
}

