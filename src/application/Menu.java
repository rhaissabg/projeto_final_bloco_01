package application;

import java.util.Scanner;

public class Menu {

	public static void main(String[] args) {
		
		Scanner sc = new Scanner(System.in);
		
		int opcao;
		
		do {
			
			System.out.println("*****************************************************");
			System.out.println("                                                     ");
			System.out.println("                  LOJAS TECH BRASIL                  ");
			System.out.println("                                                     ");
			System.out.println("*****************************************************");
			System.out.println("                                                     ");
			System.out.println("          1 - Criar produto                          ");
			System.out.println("          2 - Listar todos os produtos               ");
			System.out.println("          3 - Buscar produto por código              ");
			System.out.println("          4 - Atualizar dados do produto             ");
			System.out.println("          5 - Apagar produto                         ");
			System.out.println("          0 - Sair                                   ");
			System.out.println("                                                     ");
			System.out.println("*****************************************************");
			System.out.println("Entre com a opção desejada:                          ");
			System.out.println("                                                     ");
			
			opcao = sc.nextInt();
			
			switch (opcao) {
			
			case 1:
				System.out.println("\nCriar produto: \n");
				break;
				
			case 2:
				System.out.println("\nListar todos os produtos: \n");
				break;
				
			case 3:
				System.out.println("\nBuscar produto por código: \n");
				break;
			
			case 4:
				System.out.println("\nAtualizar dados do produto: \n");
				break;
				
			case 5:
				System.out.println("\nApagar produto: \n");
				break;	
				
			default:
				if (opcao != 0 && opcao  > 5)
					System.out.println("Opção inválida!");
				break;
			
			}
			
		} while (opcao != 0);
		
		System.out.println("\nFim da execução");
		
		sc.close();

	}

}
