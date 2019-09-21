package executavel;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;

import model.dao.DespesaDAO;
import model.vo.DespesaVO;

/**
 * Classe principal da aplicação Dr Muquirana.
 * 
 * @author Adriano de Melo
 *
 */
public class Executavel {

	public static void main(String[] args) {

		DespesaDAO dao = new DespesaDAO();
		ArrayList<DespesaVO> todasAsDespesas = dao.consultarTodos();
		
		System.out.println("ID        IDUSUARIO    DESC                        VALOR         DTDESP        DTPGTO           CATEGORIA");
		for(DespesaVO desp: todasAsDespesas) {
			desp.imprimir();
		}
		
		//Menu menu = new Menu();
		//menu.apresentarMenu();
//		Menu menu = new Menu();
//		menu.apresentarMenu();

		mostrarDataAtualFormatada();

		DespesaDAO d = new DespesaDAO();
		ArrayList<DespesaVO> todas = d.consultarTodos();

		for (DespesaVO desp : todas) {
			System.out.println(desp.toString());
		}

	}

	public static void mostrarDataAtualFormatada() {
		DateTimeFormatter formatadorDeData = DateTimeFormatter.ofPattern("dd-MM-yy");
		LocalDate dataAtual = LocalDate.now();

		String dataFormatada = dataAtual.format(formatadorDeData);

		System.out.println(dataFormatada);
	}
}