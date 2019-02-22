package CRUDs;

import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

import Model.Itens;

public class CRUDItens {
	public static Scanner read = new Scanner(System.in);

	static Map<String, Itens> mapItens = new HashMap<String, Itens>();
	static Itens newItem = new Itens();

	static int opcaoItem = 0;
	static String pesquisaItens;

	public static void cadastroProdutos() {
		System.out.print("\nCADASTRO DE ITENS\nNome do produto: ");
		newItem.setNome(read.nextLine());
		System.out.print("Preço em Cristais: ");
		newItem.setValCristais(read.nextInt());
		read.nextLine();
		System.out.print("Preço em Diamantes: ");
		newItem.setValDiamantes(read.nextInt());
		read.nextLine();

		validaCadastroProdutos(newItem);

		String key = newItem.getNome();
		mapItens.put(key, newItem);
	}

	public static void validaCadastroProdutos(Itens newItem) {
		if (mapItens.containsKey(newItem.getNome())) {
			System.out.println("Produto já cadastrado.");
			cadastroProdutos();
		}
		if (newItem.getNome().equals("")) {
			System.out.print("O campo destinado ao NOME não pode ficar vazio.\nNome: ");
			newItem.setNome(read.nextLine());
		}
		if (newItem.getValCristais() < 0) {
			System.out.print("O campo destinado ao PREÇO EM CRISTAIS não pode ficar vazio.\nPreço em Cristais: ");
			newItem.setValCristais(read.nextInt());
			read.nextLine();
		}
		if (newItem.getValDiamantes() < 0) {
			System.out.println("O campo destinado ao PREÇO EM DIAMANTES não pode ficar vazio.\nPreço em Diamantes");
			newItem.setValDiamantes(read.nextInt());
			read.nextLine();
		}

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

	public static void uptNomeItem() {
		listarItemEspecifico();

		System.out.print("Novo nome: ");
		mapItens.get(pesquisaItens).setNome(read.nextLine());

		System.out.println(mapItens.get(pesquisaItens));
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
