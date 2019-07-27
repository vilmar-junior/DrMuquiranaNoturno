package view;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.Scanner;

import controller.ControladoraDespesa;
import model.vo.DespesaVO;

public class MenuDespesa {

	Scanner teclado = new Scanner(System.in);
	DateTimeFormatter dataFormatter = DateTimeFormatter.ofPattern("dd/MM/yyyy");

	private static final int OPCAO_MENU_CADASTRAR_DESPESA = 1;
	private static final int OPCAO_MENU_CONSULTAR_DESPESA = 2;
	private static final int OPCAO_MENU_ATUALIZAR_DESPESA = 3;
	private static final int OPCAO_MENU_EXCLUIR_DESPESA = 4;
	private static final int OPCAO_MENU_DESPESA_SAIR = 5;

	private static final int OPCAO_MENU_CONSULTAR_TODAS_DESPESAS = 1;
	private static final int OPCAO_MENU_CONSULTAR_UMA_DESPESA = 2;
	private static final int OPCAO_MENU_CONSULTAR_DESPESA_SAIR = 3;
	
	public void apresentarMenuDespesa() {
		int opcao = apresentarOpcoesMenu();
		while (opcao != OPCAO_MENU_DESPESA_SAIR) {
			switch (opcao) {
				case OPCAO_MENU_CADASTRAR_DESPESA: {
					this.cadastrarDespesa();
					break;
				}
				case OPCAO_MENU_CONSULTAR_DESPESA: {
					this.consultarDespesa();
					break;
				}
				case OPCAO_MENU_ATUALIZAR_DESPESA: {
					this.atualizarDespesa();
					break;
				}
				case OPCAO_MENU_EXCLUIR_DESPESA: {
					this.excluirDespesa();
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
		System.out.println("\nDr. Muquirana - Controle de Gastos \n-------- Menu Cadastro de Despesas --------");
		System.out.println("\nOpções:");
		System.out.println(OPCAO_MENU_CADASTRAR_DESPESA + " - Cadastrar Despesa");
		System.out.println(OPCAO_MENU_CONSULTAR_DESPESA + " - Consultar Despesa");
		System.out.println(OPCAO_MENU_ATUALIZAR_DESPESA + " - Atualizar Despesa");
		System.out.println(OPCAO_MENU_EXCLUIR_DESPESA + " - Excluir Despesa");
		System.out.println(OPCAO_MENU_DESPESA_SAIR + " - Voltar");
		System.out.print("\nDigite a Opção: ");
		return Integer.parseInt(teclado.nextLine());
	}

	private void cadastrarDespesa() {
		DespesaVO despesaVO = new DespesaVO();
		System.out.print("\nDigite o código do usuário da Despesa: ");
		despesaVO.setIdUsuario(Integer.parseInt(teclado.nextLine()));
		System.out.print("\nDigite a descrição da Despesa: ");
		despesaVO.setDescricao(teclado.nextLine());
		System.out.print("Digite o valor da Despesa: ");
		despesaVO.setValor(Double.parseDouble(teclado.nextLine()));
		System.out.print("Digite a data de vencimento da Despesa: ");
		despesaVO.setDataVencimento(LocalDate.parse(teclado.nextLine(), dataFormatter));
		System.out.print("Digite a data de pagamento da Despesa: ");
		despesaVO.setDataVencimento(LocalDate.parse(teclado.nextLine(), dataFormatter));
		System.out.print("\nDigite a categoria da Despesa: ");
		despesaVO.setCategoria(teclado.nextLine());

		ControladoraDespesa controladoraDespesa = new ControladoraDespesa();
		controladoraDespesa.cadastrarDespesaController(despesaVO);
	}

	private void consultarDespesa() {
		int opcao = this.apresentarOpcoesConsulta();
		ControladoraDespesa controladoraDespesa = new ControladoraDespesa();
		while (opcao != OPCAO_MENU_CONSULTAR_DESPESA_SAIR) {
			switch (opcao) {
				case 1: {
					opcao = OPCAO_MENU_CONSULTAR_DESPESA_SAIR;
					DespesaVO despesaVO = new DespesaVO();
					System.out.print("\nInforme o código do Usuário: ");
					despesaVO.setIdUsuario(Integer.parseInt(teclado.nextLine()));
					
					ArrayList<DespesaVO> listaDespesasVO = controladoraDespesa.consultarTodasDespesasController(despesaVO);
					System.out.print("\n--------- RESULTADO DA CONSULTA ---------");
					System.out.printf("\n%3s  %10s  %-30s  %-10s  %-15s  %-15s  %-15s \n", 
							"ID", "IDUSUARIO", "DESCRIÇÃO", "VALOR", "DATA VENCIMENTO", "DATA PAGAMENTO", "CATEGORIA");
					for (int i = 0; i < listaDespesasVO.size(); i++) {
						listaDespesasVO.get(i).imprimir();
					}
					break;
				}
				case 2: {
					opcao = OPCAO_MENU_CONSULTAR_DESPESA_SAIR;
					DespesaVO despesaVO = new DespesaVO();
					System.out.print("\nInforme o código da Despesa: ");
					despesaVO.setId(Integer.parseInt(teclado.nextLine()));
	
					DespesaVO despesa = controladoraDespesa.consultarDespesaoController(despesaVO);
					System.out.print("\n--------- RESULTADO DA CONSULTA ---------");
					System.out.printf("\n%3s  %10s  %-30s  %-10s  %-15s  %-15s  %-15s \n", 
							"ID", "IDUSUARIO", "DESCRIÇÃO", "VALOR", "DATA VENCIMENTO", "DATA PAGAMENTO", "CATEGORIA");
					despesa.imprimir();
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
		System.out.println(OPCAO_MENU_CONSULTAR_TODAS_DESPESAS + " - Consultar todas as Despesas");
		System.out.println(OPCAO_MENU_CONSULTAR_UMA_DESPESA + " - Consultar uma despesa Específica");
		System.out.println(OPCAO_MENU_CONSULTAR_DESPESA_SAIR + " - Voltar");
		System.out.print("\nDigite a Opção: ");
		return Integer.parseInt(teclado.nextLine());
	}

	private void atualizarDespesa() {
		DespesaVO despesaVO = new DespesaVO();
		System.out.print("\nInforme o código da Despesa: ");
		despesaVO.setId(Integer.parseInt(teclado.nextLine()));
		System.out.print("\nDigite o código do usuário da Despesa: ");
		despesaVO.setIdUsuario(Integer.parseInt(teclado.nextLine()));
		System.out.print("\nDigite a descrição da Despesa: ");
		despesaVO.setDescricao(teclado.nextLine());
		System.out.print("Digite o valor da Despesa: ");
		despesaVO.setValor(Double.parseDouble(teclado.nextLine()));
		System.out.print("Digite a data de vencimento da Despesa: ");
		despesaVO.setDataVencimento(LocalDate.parse(teclado.nextLine(), dataFormatter));
		System.out.print("Digite a data de pagamento da Despesa: ");
		despesaVO.setDataVencimento(LocalDate.parse(teclado.nextLine(), dataFormatter));
		System.out.print("\nDigite a categoria da Despesa: ");
		despesaVO.setCategoria(teclado.nextLine());

		ControladoraDespesa controladoraDespesa = new ControladoraDespesa();
		controladoraDespesa.atualizarDespesaController(despesaVO);
	}

	private void excluirDespesa() {
		DespesaVO despesaVO = new DespesaVO();
		System.out.print("Digite o código da Despesa: ");
		despesaVO.setId(Integer.parseInt(teclado.nextLine()));
		
		ControladoraDespesa controladoraDespesa = new ControladoraDespesa();
		controladoraDespesa.excluirDespesaController(despesaVO);
	}

}
