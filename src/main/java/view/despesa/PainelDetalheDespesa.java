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

public class PainelDetalheDespesa extends JPanel {

	/**
	 * Create the panel.
	 */
	public PainelDetalheDespesa() {
		JLabel lblDespesa = new JLabel("Despesa");
		lblDespesa.setFont(new Font("Tahoma", Font.BOLD, 14));

		GroupLayout groupLayout = new GroupLayout(this);
		groupLayout.setHorizontalGroup(
			groupLayout.createParallelGroup(Alignment.LEADING)
				.addGroup(groupLayout.createSequentialGroup()
					.addGap(255)
					.addComponent(lblDespesa)
					.addContainerGap(138, Short.MAX_VALUE))
		);
		groupLayout.setVerticalGroup(
			groupLayout.createParallelGroup(Alignment.LEADING)
				.addGroup(groupLayout.createSequentialGroup()
					.addGap(27)
					.addComponent(lblDespesa)
					.addContainerGap(543, Short.MAX_VALUE))
		);
		setLayout(groupLayout);
	}
}