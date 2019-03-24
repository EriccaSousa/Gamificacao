package CRUDs;

import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

import Menus.MenusAdm;
import Menus.MenusGamer;
import Menus.MenusLoja;
import Model.Gamer;
import Model.Itens;
import Model.Turma;

public class CRUDGamer {

	public static Scanner read = new Scanner(System.in);

	static Gamer gamer = new Gamer();
	static Turma turma = new Turma();
	static Itens itens = new Itens();

	static MenusAdm menuAdm = new MenusAdm();
	static MenusGamer menuGamer = new MenusGamer();
	static MenusLoja menuLoja = new MenusLoja();

	static CRUDTurma crudTurma = new CRUDTurma();
	static CRUDItens crudItens = new CRUDItens();
	static Validacoes validaGamer = new Validacoes();

	static Map<String, Gamer> mapGamer = new HashMap<String, Gamer>();

	static int cristaisPlayer = 0;
	static int diamantesPlayer = 0;
	static int cristaisItem = 0;
	static int diamantesItem = 0;

	static String key;
	static String pesquisaGamer;
	static int opcaoGamer = 0;

	public static Map<String, Gamer> cadastroGamer() {
		Gamer gamer = new Gamer();

		System.out.println("- Cadastro Gamer -");
		System.out.print("Nome : ");
		gamer.setNome(read.nextLine());
		System.out.print("Email : ");
		gamer.setEmail(read.nextLine());
		System.out.print("Senha : ");
		gamer.setSenha(read.nextLine());
		System.out.print("Matrícula : ");
		gamer.setMatricula(read.nextLine());
		System.out.print("Turma : ");
		gamer.setTurma(read.nextLine());
		gamer.setCristais(0);
		gamer.setDiamantes(0);

		validaGamer.validaNome(gamer);
		validaGamer.validaEmail(gamer);
		validaGamer.validaSenha(gamer);
		validaGamer.validaMatricula(gamer);
		validaGamer.validaTurma(gamer);

		key = gamer.getMatricula();
		mapGamer.put(key, gamer);

		System.out.print("Cadastrar outro Gamer?\n[ 1 ] Sim\n[ 2 ] Não\n-- ");
		opcaoGamer = read.nextInt();
		read.nextLine();

		if (opcaoGamer == 1) {
			cadastroGamer();
		} else if (opcaoGamer == 2) {
			menuAdm.menuTurma();
		} else {
			System.out.println("Opção inválida!");
		}
		return mapGamer;
	}

	public static void pesquisaGamer() {
		System.out.print("[ 1 ] Listar todos\n[ 2 ] Pesquisar Gamer específico\n[ 3 ] Voltar\n-- ");
		opcaoGamer = read.nextInt();
		read.nextLine();

		if (opcaoGamer == 1) {
			listarAllGamer();
		} else if (opcaoGamer == 2) {
			pesquisarGamer();
		} else if (opcaoGamer == 3) {
			menuGamer.menuPesquisa();
		} else {
			System.out.println("Opção inválida.");
		}
	}

	public static void pesquisaGamer(Gamer gamer) {
		System.out.print("[ 1 ] Listar todos\n[ 2 ] Pesquisar Gamer específico\n[ 3 ] Voltar\n-- ");
		opcaoGamer = read.nextInt();
		read.nextLine();

		if (opcaoGamer == 1) {
			listarAllGamer();
		} else if (opcaoGamer == 2) {
			pesquisarGamer();
		} else if (opcaoGamer == 3) {
			menuAdm.menuPesquisa();
		} else {
			System.out.println("Opção inválida.");
		}
	}

	public static void listarAllGamer() {
		mapGamer.forEach((key, gamer) -> System.out.println("Matrícula : " + key + gamer));
	}

	public static void pesquisarGamer() {
		System.out.println("\n- Pesquisar Gamer -");
		System.out.print("Informe a matrícula do gamer que deseja encontrar : ");
		pesquisaGamer = read.nextLine();

		if (mapGamer.containsKey(pesquisaGamer)) {
			System.out.println(mapGamer.get(pesquisaGamer));
		} else {
			System.out.println("O gamer pesquisado não existe.");
		}

	}

	public static void updateNome() {
		System.out.print("Informe sua matrícula  : ");
		pesquisaGamer = read.nextLine();

		if (mapGamer.containsKey(pesquisaGamer)) {
			System.out.println(mapGamer.get(pesquisaGamer));

			System.out.print("\nInforme o novo nome  : ");
			mapGamer.get(pesquisaGamer).setNome(read.nextLine());

			menuGamer.menuConfiguracoes();
		} else {
			System.out.println("A matrícula informada não existe.");
		}

	}

	public static void updateEmail() {
		System.out.print("Informe sua matrícula  : ");
		pesquisaGamer = read.nextLine();

		if (mapGamer.containsKey(pesquisaGamer)) {
			System.out.println(mapGamer.get(pesquisaGamer));

			System.out.print("\nInforme o novo email  : ");
			mapGamer.get(pesquisaGamer).setEmail(read.nextLine());

			menuGamer.menuConfiguracoes();
		} else {
			System.out.println("A matrícula informada não existe.");
		}
	}

	public static void updateSenha() {
		System.out.print("Informe sua matrícula  : ");
		pesquisaGamer = read.nextLine();

		if (mapGamer.containsKey(pesquisaGamer)) {
			System.out.println(mapGamer.get(pesquisaGamer));

			System.out.print("\nInforme sua nova senha  : ");
			mapGamer.get(pesquisaGamer).setSenha(read.nextLine());

			menuGamer.menuConfiguracoes();
		} else {
			System.out.println("A matrícula informada não existe.");
		}
	}

	public static void updatePontuacao() {
		adicionaCristais();
		adicionaDiamantes();

		menuAdm.menuGamerByAdm();

	}

	public static void adicionaCristais() {
		System.out.println("- Atualizar Pontuação -");
		System.out.print("Informe a matrícula : ");
		pesquisaGamer = read.nextLine();

		if (mapGamer.containsKey(pesquisaGamer)) {
			System.out.print(
					"Quantos cristais deseja adicionar ao Gamer " + mapGamer.get(pesquisaGamer).getNome() + "?\n- ");
			int cristais = read.nextInt();
			read.nextLine();

			cristais = mapGamer.get(pesquisaGamer).getCristais() + cristais;
			mapGamer.get(pesquisaGamer).setCristais(cristais);
		}

	}

	public static void adicionaDiamantes() {
		int diamantes = mapGamer.get(pesquisaGamer).getCristais() / 10;

		mapGamer.get(pesquisaGamer).setDiamantes(diamantes);

		System.out.println("Pontuação atualizada! " + mapGamer.get(pesquisaGamer));
	}

	public static void deleteGamer() {
		System.out.println("Informe a matrícula do Gamer que deseja deletar : ");
		pesquisaGamer = read.nextLine();

		if (mapGamer.containsKey(pesquisaGamer)) {
			mapGamer.remove(pesquisaGamer);

			if (mapGamer.containsKey(pesquisaGamer) == false) {
				System.out.println("Gamer deletado com sucesso.");
			} else {
				System.out.println("Ocorreu um erro ao deletar gamer.");
			}

			menuAdm.menuGamerByAdm();
		} else {
			System.out.println("A matrícula informada não existe.");
			menuAdm.menuGamerByAdm();
		}
	}

	public static void comprarItens() {
		System.out.println("\nLOJA - ITENS\n");
		crudItens.listarAllItens();

		System.out.print("Nome do item que deseja comprar: ");
		String pesquisaItem = read.nextLine();

		if (crudItens.mapItens.containsKey(pesquisaItem)) {
			System.out.println("\n" + crudItens.mapItens.get(pesquisaItem) + "\n");

			System.out.print("Deseja confirmar a comprar deste item?\n[ 1 ] Sim\n[ 2 ] Não\n\n- ");
			opcaoGamer = read.nextInt();
			read.nextLine();

			if (opcaoGamer == 1) {
				System.out.print("Informe sua matrícula e senha para confirmar a compra.\nMatrícula: ");
				String pesquisaMatricula = read.nextLine();

				System.out.print("Senha: ");
				String pesquisaSenha = read.nextLine();

				if (mapGamer.containsKey(pesquisaMatricula)) {
					// Falta verificação de senha;

					cristaisPlayer = mapGamer.get(pesquisaMatricula).getCristais();

					diamantesPlayer = mapGamer.get(pesquisaMatricula).getDiamantes();

					cristaisItem = crudItens.mapItens.get(pesquisaItem).getValCristais();

					diamantesItem = crudItens.mapItens.get(pesquisaItem).getValDiamantes();

					if ((cristaisPlayer >= cristaisItem) && (diamantesPlayer >= diamantesItem)) {

						cristaisPlayer -= cristaisItem;
						diamantesPlayer -= diamantesItem;

						Itens compras = crudItens.mapItens.get(pesquisaItem);

						mapGamer.get(pesquisaMatricula).setCristais(cristaisPlayer);
						mapGamer.get(pesquisaMatricula).setDiamantes(diamantesPlayer);
						// mapGamer.get(pesquisaMatricula).setCompras(compras);

						System.out.println(mapGamer.get(pesquisaMatricula));

						menuLoja.menuLojaByGamer();

					} else {
						if (cristaisPlayer < cristaisItem) {
							System.out.println("Cristais insuficientes para realizar compra.");
						} else if (diamantesPlayer < diamantesItem) {
							System.out.println("Diamantes insuficientes para realizar compra.");
						} else if ((cristaisPlayer < cristaisItem) && (diamantesPlayer < diamantesItem)) {
							System.out.println("Cristais e Diamantes insuficientes para realizar compra.");
						}
					}
				}
			} else if (opcaoGamer == 2) {

			} else {
				System.out.println("Operação Finalizada!");
			}

		} else {
			System.out.println("O item " + pesquisaItem + " não existe na loja!");
		}

	}

	public static void loginGamer() {
		System.out.println("- Login Gamer -");
		System.out.print("Matrícula : ");
		String loginGamer = read.nextLine();
		System.out.print("Senha : ");
		String senhaGamer = read.nextLine();

		if (mapGamer.containsKey(loginGamer)) {
			if (mapGamer.get(loginGamer).getSenha().equals(senhaGamer)) {
				System.out.println("Bem vindo " + mapGamer.get(loginGamer).getNome());

				menuGamer.menuPrincipalGamer();
			} else {
				System.out.println("Senha incorreta.");
			}
		} else {
			System.out.println("Matrícula incorreta.");
		}

	}

}
