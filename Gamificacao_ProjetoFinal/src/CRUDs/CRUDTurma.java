package CRUDs;

import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

import Menus.MenusAdm;
import Model.Gamer;
import Model.Turma;

public class CRUDTurma {

	public static Scanner read = new Scanner(System.in);

	static Map<String, Turma> mapTurma = new HashMap<String, Turma>();
	static Map<String, Gamer> newMapGamer = new HashMap<String, Gamer>();

	static Turma turma = new Turma();
	static Gamer gamer = new Gamer();
	static Validacoes validaTurma = new Validacoes();
	static CRUDGamer crudGamer = new CRUDGamer();

	static MenusAdm menuAdm = new MenusAdm();

	static String keyTurma;
	static String pesquisaTurma;
	static int opcaoTurma = 0;

	public static Map<String, Turma> cadastroTurma() {
		Turma turma = new Turma();

		System.out.println("- Cadastro Turma -");
		System.out.print("Nome : ");
		turma.setNome(read.nextLine());
		System.out.print("Senha : ");
		turma.setSenha(read.nextLine());

		validaTurma.validaNome(turma);
		validaTurma.validaSenha(turma);

		keyTurma = turma.getNome();
		mapTurma.put(keyTurma, turma);

		System.out.print("Deseja adicionar Gamer a sua turma agora?\n[ 1 ] Sim\n[ 2 ] Não\n-- ");
		opcaoTurma = read.nextInt();
		read.nextLine();

		if (opcaoTurma == 1) {
			crudGamer.cadastroGamer();
			newMapGamer.put(crudGamer.gamer.getMatricula(), gamer);

			System.out.println(newMapGamer);

			turma.setNewMapGamer(newMapGamer);

		} else if (opcaoTurma == 2) {
			menuAdm.menuTurma();
		} else {
			System.out.println("Opção inválida!");
		}
		return mapTurma;
	}

	public static void pesquisaTurma() {
		System.out.print("[ 1 ] Listar todas as Turmas\n[ 2 ] Pesquisar Turma específica\n-- ");
		opcaoTurma = read.nextInt();
		read.nextLine();

		if (opcaoTurma == 1) {
			listarAllTurma();
		} else if (opcaoTurma == 2) {
			pesquisarTurma();
		} else {
			System.out.println("Opção inválida.");
		}
	}

	public static void listarAllTurma() {
		mapTurma.forEach((keyTurma, turma) -> System.out.println("Turma : " + keyTurma + turma));
	}

	public static void pesquisarTurma() {
		System.out.print("Informe a turma que deseja encontrar : ");
		pesquisaTurma = read.nextLine();

		if (mapTurma.containsKey(pesquisaTurma)) {
			mapTurma.forEach((pesquisaTurma, turma) -> System.out.println("Turma: " + keyTurma + turma));
		}

	}

	public static void updateNome() {
		System.out.print("Informe a turma  : ");
		pesquisaTurma = read.nextLine();

		if (mapTurma.containsKey(pesquisaTurma)) {
			mapTurma.forEach((pesquisaGamer, gamer) -> System.out.println("Turma : " + keyTurma + gamer));

			System.out.print("\nInforme o novo nome da turma : ");
			mapTurma.get(pesquisaTurma).setNome(read.nextLine());
		} else {
			System.out.println("A Turma informada não existe.");
		}

	}

	public static void updateSenha() {
		System.out.print("Informe a turma  : ");
		pesquisaTurma = read.nextLine();

		if (mapTurma.containsKey(pesquisaTurma)) {
			mapTurma.forEach((pesquisaGamer, gamer) -> System.out.println("Turma : " + keyTurma + gamer));

			System.out.print("Nova senha: ");
			String novaSenha = read.nextLine();

			mapTurma.get(pesquisaTurma).setSenha(novaSenha);

			if (mapTurma.get(pesquisaTurma).getSenha().equals(novaSenha)) {
				System.out.println("Senha atualizada com sucesso.");
			} else {
				System.out.println("Ocorreu um erro ao atualizar a senha.");
			}
		} else {
			System.out.println("A Turma informada não existe.");
		}
	}

	public static void deleteTurma() {
		System.out.println("Informe a turma : ");
		pesquisaTurma = read.nextLine();

		if (mapTurma.containsKey(pesquisaTurma)) {
			mapTurma.forEach((pesquisaGamer, gamer) -> System.out.println("Turma : " + keyTurma + gamer));

			mapTurma.remove(pesquisaTurma);

			if (mapTurma.containsKey(pesquisaTurma)) {
				System.out.println("\nOcorreu um erro ao deletar a Turma.");
			} else {
				System.out.println("\nTurma deletada com sucesso!");
				menuAdm.menuTurma();
			}
		} else {
			System.out.println("\nA Turma informada não existe.");
		}
	}
}
