package view;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.Scanner;
import controller.ControladoraReceita;
import controller.ControladoraUsuario;
import model.vo.ReceitaVO;
import model.vo.UsuarioVO;


public class MenuReceita {
	
	Scanner teclado = new Scanner(System.in);
	DateTimeFormatter dataFormatter = DateTimeFormatter.ofPattern("dd/MM/yyyy");
	
	private static final int OPCAO_MENU_CADASTRAR_RECEITA = 1;
	private static final int OPCAO_MENU_CONSULTAR_RECEITA = 2;
	private static final int OPCAO_MENU_ATUALIZAR_RECEITA = 3;
	private static final int OPCAO_MENU_EXCLUIR_RECEITA = 4;
	private static final int OPCAO_MENU_RECEITA_SAIR = 5;
	
	private static final int OPCAO_MENU_CONSULTAR_TODAS_RECEITAS = 1;
	private static final int OPCAO_MENU_CONSULTAR_UMA_RECEITA = 2;
	private static final int OPCAO_MENU_CONSULTAR_RECEITA_SAIR = 3;

	public void apresentarMenuReceita() {
		int opcao = apresentarOpcoesMenu();
		while (opcao != OPCAO_MENU_RECEITA_SAIR) {
			switch (opcao) {
				case OPCAO_MENU_CADASTRAR_RECEITA: {
					this.cadastrarReceita();
					break;
				}
				case OPCAO_MENU_CONSULTAR_RECEITA: {
					this.consultarReceita();
					break;
				}
				case OPCAO_MENU_ATUALIZAR_RECEITA: {
					this.atualizarReceita();
					break;
				}
				case OPCAO_MENU_EXCLUIR_RECEITA: {
					this.excluirReceita();
					break;
				}
				default: {
					System.out.println("\nOpção Inválida");
				}
			}
			opcao = apresentarOpcoesMenu();
		}
		
	}
	
	
	private int apresentarOpcoesMenu() {
		System.out.println("\nDr. Muquirana - Controle de Gastos \n-------- Menu Cadastro de Receitas --------");
		System.out.println("\nOpções:");
		System.out.println(OPCAO_MENU_CADASTRAR_RECEITA + " - Cadastrar Receita");
		System.out.println(OPCAO_MENU_CONSULTAR_RECEITA + " - Consultar Receita");
		System.out.println(OPCAO_MENU_ATUALIZAR_RECEITA + " - Atualizar Receita");
		System.out.println(OPCAO_MENU_EXCLUIR_RECEITA + " - Excluir Receita");
		System.out.println(OPCAO_MENU_RECEITA_SAIR + " - Voltar");
		System.out.print("\nDigite a Opção: ");
		return Integer.parseInt(teclado.nextLine());
	}

	
	private void cadastrarReceita() {
		ReceitaVO receitaVO = new ReceitaVO();
		System.out.print("\nDigite o código do usuário da Receita: ");
		receitaVO.setIdUsuario(Integer.parseInt(teclado.nextLine()));
		System.out.print("\nDigite a descrição da Receita: ");
		receitaVO.setDescricao(teclado.nextLine());
		System.out.print("Digite o valor da Receita: ");
		receitaVO.setValor(Double.parseDouble(teclado.nextLine()));
		System.out.print("Digite a data da Receita: ");
		receitaVO.setDataReceita(LocalDate.parse(teclado.nextLine(), dataFormatter));
		
		ControladoraReceita controladoraReceita = new ControladoraReceita();
		controladoraReceita.cadastrarReceitaController(receitaVO);

	}


	private void excluirReceita() {
		ReceitaVO receitaVO = new ReceitaVO();
		System.out.print("Digite o código da Receita: ");
		receitaVO.setId(Integer.parseInt(teclado.nextLine()));
		
		ControladoraReceita controladoraReceita = new ControladoraReceita();
		controladoraReceita.excluirReceitaController(receitaVO);
	}

	private void atualizarReceita() {
		ReceitaVO receitaVO = new ReceitaVO();
		System.out.print("\nInforme o código da Receita: ");
		receitaVO.setId(Integer.parseInt(teclado.nextLine()));
		System.out.print("\nDigite o código do usuário da Receita: ");
		receitaVO.setIdUsuario(Integer.parseInt(teclado.nextLine()));
		System.out.print("\nDigite a descrição da Receita: ");
		receitaVO.setDescricao(teclado.nextLine());
		System.out.print("Digite o valor da Receita: ");
		receitaVO.setValor(Double.parseDouble(teclado.nextLine()));
		System.out.print("Digite a data da Receita: ");
		receitaVO.setDataReceita(LocalDate.parse(teclado.nextLine(), dataFormatter));
		
		ControladoraReceita controladoraReceita = new ControladoraReceita();
		controladoraReceita.atualizarReceitaController(receitaVO);

	}

	private void consultarReceita() {
		int opcao = this.apresentarOpcoesConsulta();
		ControladoraReceita controladoraReceita = new ControladoraReceita();
		while (opcao != OPCAO_MENU_CONSULTAR_RECEITA_SAIR) {
			switch (opcao) {
				case 1: {
					opcao = OPCAO_MENU_CONSULTAR_RECEITA_SAIR;
					ArrayList<ReceitaVO> listaReceitasVO = controladoraReceita.consultarTodasReceitasController();
					System.out.print("\n--------- RESULTADO DA CONSULTA ---------");
					System.out.printf("\n%3s  %10s  %-30s  %-10s  %-12s\n", "ID", "IDUSUARIO", "DESCRIÇÃO", "VALOR", "DATA RECEITA");
					for (int i = 0; i < listaReceitasVO.size(); i++) {
						listaReceitasVO.get(i).imprimir();
					}
					break;
				}
				case 2: {
					opcao = OPCAO_MENU_CONSULTAR_RECEITA_SAIR;
					ReceitaVO receitaVO = new ReceitaVO();
					System.out.print("\nInforme o código da Receita: ");
					receitaVO.setId(Integer.parseInt(teclado.nextLine()));
	
					ReceitaVO receita = controladoraReceita.consultarReceitaController(receitaVO);
					System.out.print("\n--------- RESULTADO DA CONSULTA ---------");
					System.out.printf("\n%3s  %10s  %-30s  %-10s  %-12s\n", "ID", "IDUSUARIO", "DESCRIÇÃO", "VALOR", "DATA RECEITA");
					receita.imprimir();
					break;
				}
				default: {
					System.out.println("\nOpção Inválida");
					opcao = this.apresentarOpcoesConsulta();
				}
			}
		}
	}
	
	private int apresentarOpcoesConsulta() {
		System.out.println("\nInforme o tipo de consulta a ser realizada");
		System.out.println(OPCAO_MENU_CONSULTAR_TODAS_RECEITAS + " - Consultar todas as Receitas");
		System.out.println(OPCAO_MENU_CONSULTAR_UMA_RECEITA + " - Consultar uma Receita Específica");
		System.out.println(OPCAO_MENU_CONSULTAR_RECEITA_SAIR + " - Voltar");
		System.out.print("\nDigite a Opção: ");
		return Integer.parseInt(teclado.nextLine());
	}

}
