package view;

import java.awt.EventQueue;

import javax.swing.JFrame;
import java.awt.Toolkit;
import javax.swing.JMenuBar;
import javax.swing.JMenu;
import javax.swing.JMenuItem;

public class MenuDrMuquirana {

	private JFrame frmDrMuquirana;

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
		mnReceitas.add(mntmListar);
		
		JMenuItem mntmNova = new JMenuItem("Nova");
		mnReceitas.add(mntmNova);
		
		JMenu mnDespesas = new JMenu("Despesas");
		menubar.add(mnDespesas);
		
		JMenuItem mntmListar_1 = new JMenuItem("Listar");
		mnDespesas.add(mntmListar_1);
		
		JMenuItem mntmNova_1 = new JMenuItem("Nova");
		mnDespesas.add(mntmNova_1);
		
		JMenu mnUsurios = new JMenu("Usuários");
		menubar.add(mnUsurios);
		
		JMenuItem mntmListar_2 = new JMenuItem("Listar");
		mnUsurios.add(mntmListar_2);
		
		JMenu mnRelatrios = new JMenu("Relatórios");
		menubar.add(mnRelatrios);
		
		JMenu mnSobre = new JMenu("Sobre");
		menubar.add(mnSobre);
	}

}
