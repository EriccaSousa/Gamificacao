package Menus;

import java.util.Scanner;

import CRUDs.CRUDAdm;
import CRUDs.CRUDGamer;
import CRUDs.CRUDTurma;
import CRUDs.Validacoes;

public class MenusAdm {

	public static Scanner read = new Scanner(System.in);

	static CRUDAdm crudAdm = new CRUDAdm();
	static CRUDGamer crudGamer = new CRUDGamer();
	static CRUDTurma crudTurma = new CRUDTurma();
	static Validacoes validacoes = new Validacoes();

	static MenuInicial menuInicial = new MenuInicial();

	static MenusLoja menuLoja = new MenusLoja();

	static String pesquisa;
	static int opcao = 0;

	public static void menuPrincipalAdm() {
		System.out.println("- Menu principal -");
		System.out.print(
				"[ 1 ] Turmas\n[ 2 ] Gamer\n[ 3 ] Loja\n[ 4 ] Configurações\n[ 5 ] Pesquisar Usuários\n[ 6 ] Sair\n-- ");
		opcao = read.nextInt();
		read.nextLine();

		do {
			switch (opcao) {
			case 1:
				menuTurma();
				break;
			case 2:
				menuGamerByAdm();
				break;
			case 3:
				menuLoja.menuLojaByAdm();
				break;
			case 4:
				menuConfiguracoesAdm();
				break;
			case 5:
				menuPesquisa();
				break;
			case 6:
				menuInicial.menuInicial();
				break;
			default:
				System.out.println("Opção inválida!\nTente novamente.");
			}

		} while (true);
	}

	public static void menuGamerByAdm() {
		System.out.println("- Menu Gamer -");
		System.out.print("[ 1 ] Cadastrar Gamer\n[ 2 ] Atualizar pontuação\n[ 3 ] Deletar Gamer\n[ 4 ] Voltar\n-- ");
		opcao = read.nextInt();
		read.nextLine();

		do {
			switch (opcao) {
			case 1:
				crudGamer.cadastroGamer();
				break;
			case 2:
				crudGamer.updatePontuacao();
				break;
			case 3:
				crudGamer.deleteGamer();
				break;
			case 4:
				menuPrincipalAdm();
				break;
			default:
				System.out.println("Opção inválida!\nTente novamente.");
			}
		} while (true);
	}

	public static void menuConfiguracoesAdm() {
		validacoes.validaAdm();
		if (validacoes.validaAdm() == true) {
			System.out.println("- Configurações -");
			System.out.println(
					"[ 1 ] Trocar nome\n[ 2 ] Trocar email\n[ 3 ] Trocar Senha\n[ 4 ] Deletar conta\n[ 5 ] Voltar\n-- ");

			do {
				switch (opcao) {
				case 1:
					crudAdm.updateNome();
					break;
				case 2:
					crudAdm.updateEmail();
					break;
				case 3:
					crudAdm.updateSenha();
					break;
				case 4:
					crudAdm.deleteAdm();
					break;
				case 5:
					menuPrincipalAdm();
					break;
				default:
					System.out.println("Opção inválida!\nTente novamente.");
				}
			} while (true);
		} else {
			System.out.println("Login ou senha inválido.");
		}
	}

	public static void menuPesquisa() {
		System.out.print("[ 1 ] Pesquisar Administrador\n[ 2 ] Pesquisar Gamer\n[ 3 ] Voltar\n-- ");
		opcao = read.nextInt();
		read.nextLine();

		do {
			switch (opcao) {
			case 1:
				crudAdm.pesquisaAdm();
				menuPesquisa();
				break;
			case 2:
				crudGamer.pesquisaGamer();
				menuPesquisa();
				break;
			case 3:
				menuPrincipalAdm();
				break;
			default:
				System.out.println("Opção inválida!\nTente novamente.");
			}

		} while (true);
	}

	public static void menuTurma() {
		System.out.println("- Menu Turma -");
		System.out.print(
				"[ 1 ] Criar turma\n[ 2 ] Atualizar Senha\n[ 3 ] Adicionar Gamer a turma\n[ 4 ] Deletar turma\n[ 5 ] Pesquisar turma\n[ 6 ] Voltar\n-- ");
		opcao = read.nextInt();
		read.nextLine();

		do {
			switch (opcao) {
			case 1:
				crudTurma.cadastroTurma();
				break;
			case 2:
				crudTurma.updateSenha();
				menuTurma();
				break;
			case 3:
				// AddGamer;
				break;
			case 4:
				crudTurma.deleteTurma();
				break;
			case 5:
				crudTurma.pesquisaTurma();
				menuTurma();
				break;
			case 6:
				menuPrincipalAdm();
				break;
			default:
				System.out.println("Opção inválida!\nTente novamente.");
			}
		} while (true);
	}

}
