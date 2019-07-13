package CRUDs;

import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

import Model.Itens;

public class CRUDItens {
	public static Scanner read = new Scanner(System.in);
	
	static Itens item = new Itens();
	static Validacoes validaItem = new Validacoes();

	static Map<String, Itens> mapItens = new HashMap<String, Itens>();

	static int opcaoItem = 0;
	static String pesquisaItens;

	public static void cadastroProdutos() {
		Itens item = new Itens();
		
		System.out.print("\nCADASTRO DE ITENS\nNome do produto: ");
		item.setNome(read.nextLine());
		System.out.print("Preço em Cristais: ");
		item.setValCristais(read.nextInt());
		read.nextLine();
		System.out.print("Preço em Diamantes: ");
		item.setValDiamantes(read.nextInt());
		read.nextLine();

		validaItem.validaCadastroProdutos(item);

		String key = item.getNome();
		mapItens.put(key, item);
	}
	
	public static void pesquisaItens() {
		System.out.println("- Pesquisar Itens -");
		System.out.print("[ 1 ] Listar todos\n[ 2 ] Pesquisar Iten específico\n-- ");
		opcaoItem = read.nextInt();
		read.nextLine();

		if (opcaoItem == 1) {
			listarAllItens();
		} else if (opcaoItem == 2) {
			listarItemEspecifico();
		} else {
			System.out.println("Opção inválida.");
		}
	}

	public static void listarAllItens() {
		System.out.println(mapItens);
	}

	public static void listarItemEspecifico() {
		System.out.print("Nome do item: ");
		pesquisaItens = read.nextLine();

		if (mapItens.containsKey(pesquisaItens)) {
			System.out.println(mapItens.get(pesquisaItens));
		} else {
			System.out.println("Item procurado não existe na loja.");
		}
	}
	
	public static void uptPrecoItem() {
		System.out.print("\n[ 1 ] Atualizar Cristais\n[ 2 ] Atualixar Diamantesr\n\n- ");
		opcaoItem = read.nextInt();
		read.nextLine();

		if (opcaoItem == 1) {
			uptValCristais();
		} else if (opcaoItem == 2) {
			uptValDiamantes();
		} else {
			System.out.println("Opção inválida!");
		}
	}

	public static void uptValCristais() {
		listarItemEspecifico();

		System.out.print("Cistais: ");

		mapItens.get(pesquisaItens).setValCristais(read.nextInt());
		read.nextLine();

		System.out.println(mapItens.get(pesquisaItens));
	}

	public static void uptValDiamantes() {
		listarItemEspecifico();

		System.out.print("Diamantes: ");

		mapItens.get(pesquisaItens).setValDiamantes(read.nextInt());
		read.nextLine();

		System.out.println(mapItens.get(pesquisaItens));
	}

	public static void deletarItem() {
		listarItemEspecifico();

		System.out.print("Deseja mesmo remover esse item da sua loja?\n[ 1 ] Sim\n[ 2 ] Não\n- ");
		opcaoItem = read.nextInt();
		read.nextLine();

		if (opcaoItem == 1) {
			mapItens.remove(pesquisaItens);
			if (mapItens.get(pesquisaItens) == null) {
				System.out.println("Item removido com sucesso!");
			} else {
				System.out.println("Opss!!\nFalha ao remover item.");
			}
		}
	}

}
