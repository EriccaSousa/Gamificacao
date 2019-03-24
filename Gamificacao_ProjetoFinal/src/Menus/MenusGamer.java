package Menus;

import java.util.Scanner;

import CRUDs.CRUDAdm;
import CRUDs.CRUDGamer;
import CRUDs.Validacoes;

public class MenusGamer {
	public static Scanner read = new Scanner(System.in);

	static CRUDAdm crudAdm = new CRUDAdm();
	static CRUDGamer crudGamer = new CRUDGamer();

	static MenuInicial menuInicial = new MenuInicial();
	static MenusLoja menuLoja = new MenusLoja();

	static Validacoes validacoes = new Validacoes();

	static String pesquisa;
	static int opcao = 0;

	public static void menuPrincipalGamer() {
		System.out.println("- Menu Principal Gamer -");
		System.out.print(
				"[ 1 ] Informações Pessoais\n[ 2 ] Loja\n[ 3 ] Configurações\n[ 4 ] Pesquisar Usuários\n[ 5 ] Sair\n-- ");
		opcao = read.nextInt();
		read.nextLine();

		do {
			switch (opcao) {
			case 1:
				crudGamer.pesquisarGamer();
				menuPrincipalGamer();
				break;
			case 2:
				menuLoja.menuLojaByGamer();
				break;
			case 3:
				validacoes.validaGamer();
				break;
			case 4:
				menuPesquisa();
				break;
			case 5:
				menuInicial.menuInicial();
			default:
				System.out.println("Opção inválida!\nTente novamente.");
			}
		} while (true);
	}

	public static void menuConfiguracoes() {

		System.out.print("[ 1 ] Trocar nome\n[ 2 ] Trocar email\n[ 3 ] Trocar senha\n[ 4 ] Voltar\n-- ");
		opcao = read.nextInt();
		read.nextLine();

		do {
			switch (opcao) {
			case 1:
				crudGamer.updateNome();
				break;
			case 2:
				crudGamer.updateEmail();
				break;
			case 3:
				crudGamer.updateSenha();
				break;
			case 4:
				menuPrincipalGamer();
				break;
			default:
				System.out.println("Opção inválida!\nTente novamente.");
			}
		} while (true);

	}

	public static void menuPesquisa() {
		System.out.print("[ 1 ] Pesquisar Administrador\n[ 2 ] Pesquisar Gamer\n[ 3 ] Voltar\n-- ");
		opcao = read.nextInt();
		read.nextLine();

		do {
			switch (opcao) {
			case 1:
				crudAdm.pesquisaAdm();
				break;
			case 2:
				crudGamer.pesquisaGamer();
				break;
			case 3:
				menuPrincipalGamer();
				break;
			default:
				System.out.println("Opção inválida!\nTente novamente.");
			}

		} while (true);
	}
}
