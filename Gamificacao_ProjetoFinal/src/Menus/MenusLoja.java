package Menus;

import java.util.Scanner;

import CRUDs.CRUDGamer;
import CRUDs.CRUDItens;

public class MenusLoja {
	public static Scanner read = new Scanner(System.in);

	static CRUDItens crudItens = new CRUDItens();
	static CRUDGamer crudGamer = new CRUDGamer();

	static MenusAdm menuAdm = new MenusAdm();
	static MenusGamer menuGamer = new MenusGamer();

	static int opcao = 0;

	public static void menuLojaByAdm() {
		do {
			System.out.print(
					"\nMENU LOJA\n[ 1 ] Cadastrar Itens\n[ 2 ] Pesquisar Itens\n[ 4 ] Atualizar Informações\n[ 5 ] Deletar itens da loja\n[ 6 ] Voltar\n\n- ");
			opcao = read.nextInt();
			read.nextLine();

			switch (opcao) {
			case 1:
				crudItens.cadastroProdutos();
				menuLojaByAdm();
				break;
			case 2:
				crudItens.pesquisaItens();
				menuLojaByAdm();
				break;
			case 4:
				atualizarItens();
				break;
			case 5:
				crudItens.deletarItem();
				break;
			case 6:
				menuAdm.menuPrincipalAdm();
				break;
			default:
				System.out.println("Opção inválida!\nTente novamente.");
			}
		} while (true);
	}

	public static void atualizarItens() {
		do {
			System.out.println("\nATUALIZAR ITENS\n[ 1 ] Atualizar nome\n[ 2 ] Atualizar preço\n[ 3 ] Voltar\n\n- ");
			opcao = read.nextInt();
			read.nextLine();

			switch (opcao) {
			case 1:
				crudItens.uptNomeItem();
				break;
			case 2:
				crudItens.uptPrecoItem();
				break;
			case 3:
				menuLojaByAdm();
				break;
			default:
				System.out.println("Opção inválida!\nTente novamente.");
			}
		} while (true);
	}

	public static void menuLojaByGamer() {
		do {
			System.out.println("\nMENU LOJA\n[ 1 ] Pesquisar itens\n[ 2 ] Comprar itens\n[ 3 ] Voltar\n\n- ");
			opcao = read.nextInt();
			read.nextLine();

			switch (opcao) {
			case 1:
				crudItens.pesquisaItens();
				menuLojaByGamer();
				break;
			case 2:
				crudGamer.comprarItens();
				break;
			case 3:
				menuGamer.menuPrincipalGamer();
				break;
			default:
				System.out.println("Opção inválida!\nTente novamente.");
			}
		} while (true);
	}

}
