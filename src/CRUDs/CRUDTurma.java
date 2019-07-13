package CRUDs;

import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

import javax.management.openmbean.OpenMBeanConstructorInfoSupport;

import Menus.MenusAdm;
import Model.Gamer;
import Model.Turma;

public class CRUDTurma {

	public static Scanner read = new Scanner(System.in);

	public static Turma turma = new Turma();
	public static Gamer gamer = new Gamer();
	
	public static MenusAdm menuAdm = new MenusAdm();
	
	public static Validacoes validaTurma = new Validacoes();
	
	public static CRUDGamer crudGamer = new CRUDGamer();

	public static Map<String, Turma> mapTurma = new HashMap<String, Turma>();

	public static String key;
	public static String pesquisaTurma;
	public static int opcaoTurma = 0;

	public static Map<String, Turma> cadastroTurma() {
		Turma turma = new Turma();
		
		System.out.println("- Cadastro Turma -");
		System.out.print("Nome da turma: ");
		turma.setNome(read.nextLine());
		System.out.print("Senha: ");
		turma.setSenha(read.nextLine());
		
		key = turma.getNome();
		mapTurma.put(key, turma);
		
		System.out.println("Deseja adicionar Gamer a sua turma agora?\n[ 1 ] Sim [ 2 ] Não\n- ");
		opcaoTurma = read.nextInt();
		read.nextLine();
		
		if(opcaoTurma == 1) {
			crudGamer.cadastroGamer();
		} else if(opcaoTurma == 2){
			menuAdm.menuTurma();
		} else {
			System.out.println("Opção Inválida!");
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
		mapTurma.forEach((key, turma) -> System.out.println("Turma : " + key + turma));
	}

	public static void pesquisarTurma() {
		System.out.print("Informe a turma que deseja encontrar : ");
		pesquisaTurma = read.nextLine();

		if (mapTurma.containsKey(pesquisaTurma)) {
			System.out.println(mapTurma.get(pesquisaTurma));
		} else {
			System.out.println("a turma procurada não está cadastrada.");
		}

	}

	public static void updateNome() {
		System.out.print("Informe a turma  : ");
		pesquisaTurma = read.nextLine();

		if (mapTurma.containsKey(pesquisaTurma)) {
			mapTurma.forEach((pesquisaGamer, gamer) -> System.out.println("Turma : " + key + gamer));

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
			System.out.println(mapTurma.get(pesquisaTurma));

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
		System.out.print("Informe a turma : ");
		pesquisaTurma = read.nextLine();

		if (mapTurma.containsKey(pesquisaTurma)) {
			System.out.println(mapTurma.get(pesquisaTurma));

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
