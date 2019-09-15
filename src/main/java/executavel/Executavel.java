package executavel;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

/**
 * Classe principal da aplicação Dr Muquirana.
 * 
 * @author Adriano de Melo
 *
 */
public class Executavel {

	public static void main(String[] args) {

//		Menu menu = new Menu();
//		menu.apresentarMenu();

		mostrarDataAtualFormatada();

	}

	public static void mostrarDataAtualFormatada() {
		DateTimeFormatter formatadorDeData = DateTimeFormatter.ofPattern("dd-MM-yy");
		LocalDate dataAtual = LocalDate.now();

		String dataFormatada = dataAtual.format(formatadorDeData);

		System.out.println(dataFormatada);
	}
}