package executavel;

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

		DespesaDAO dao = new DespesaDAO();
		ArrayList<DespesaVO> todasAsDespesas = dao.consultarTodasDespesas();
		
		System.out.println("ID        IDUSUARIO    DESC                        VALOR         DTDESP        DTPGTO           CATEGORIA");
		for(DespesaVO desp: todasAsDespesas) {
			desp.imprimir();
		}
		
		//Menu menu = new Menu();
		//menu.apresentarMenu();

//		HashMap<String, UsuarioVO> mapUsuarios = new HashMap<String, UsuarioVO>();
//		UsuarioVO joao = new UsuarioVO("João", "111");
//		UsuarioVO jose = new UsuarioVO("José", "222");
//		UsuarioVO maria = new UsuarioVO("Maria", "333");
//
//		mapUsuarios.put("555", jose);
//		mapUsuarios.put(maria.getCpf(), maria);
//		mapUsuarios.put(joao.getCpf(), joao);
//
//		Collection<UsuarioVO> valoresNoMap = mapUsuarios.values();
//		Iterator<UsuarioVO> iterador = valoresNoMap.iterator();
//
//		while (iterador.hasNext()) {
//			System.out.println(iterador.next());
//		}

	}
}