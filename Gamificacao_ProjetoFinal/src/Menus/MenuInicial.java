package Menus;

import java.util.Scanner;

import CRUDs.CRUDAdm;
import CRUDs.CRUDGamer;

public class MenuInicial {

	public static Scanner read = new Scanner(System.in);

	static CRUDGamer crudGamer = new CRUDGamer();
	static CRUDAdm crudAdm = new CRUDAdm();

	static String pesquisa;
	static int opcao = 0;

	public static void main(String[] args) {
		menuInicial();
	}

	public static void menuInicial() {
		System.out.print("[ 1 ] Cadastre-se como Admnistrador\n[ 2 ] Login\n[ 3 ] Sair\n-- ");
		opcao = read.nextInt();
		read.nextLine();

		do {
			switch (opcao) {
			case 1:
				crudAdm.cadastroAdm();
				break;
			case 2:
				menuLogin();
				break;
			case 3:
				System.exit(0);
			default:
				System.out.println("Opção inválida!\nTente novamente.");
			}

		} while (true);
	}

	public static void menuLogin() {
		System.out.print("[ 1 ] Logar com Administrador\n[ 2 ] Logar como Gamer\n[ 3 ] Voltar\n-- ");
		opcao = read.nextInt();
		read.nextLine();

		do {
			switch (opcao) {
			case 1:
				crudAdm.loginAdm();
				break;
			case 2:
				crudGamer.loginGamer();
				break;
			case 3:
				menuInicial();
			default:
				System.out.println("Opção inválida!\nTente novamente.");
			}

		} while (true);
	}

}
