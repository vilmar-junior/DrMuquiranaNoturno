package executavel;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;

import model.dao.DespesaDAO;
import model.vo.DespesaVO;
import view.Menu;

/**
 * Classe principal da aplicação Dr Muquirana.
 * 
 * @author Adriano de Melo
 *
 */
public class Executavel {

	public static void main(String[] args) {
		Menu menu = new Menu();
		menu.apresentarMenu();
	}

	public static void mostrarDataAtualFormatada() {
		DateTimeFormatter formatadorDeData = DateTimeFormatter.ofPattern("dd-MM-yy");
		LocalDate dataAtual = LocalDate.now();

		String dataFormatada = dataAtual.format(formatadorDeData);

		System.out.println(dataFormatada);
	}
}