package Apresentacao;
import java.util.Scanner;

import Negocio.Jogador;
import Negocio.Tabuleiro;

public class Menu {
	
	public void menuprejogada(Jogador jogador, Tabuleiro tabuleiro){
		Scanner ler = new Scanner(System.in);
		Integer opcao;
		do {
			System.out.println("Opcoes");
			System.out.println("1. Ver Saldo");
			System.out.println("2. Jogador Dado");
			System.out.println("4. Ver Lista de Imoveis");
			System.out.println("5.Ver Rendimento dos Imoveis Alugados");
			System.out.println("6. Ver Qual a Posição do Tabuleiro");
			System.out.println("7. Passar a Vez");
			opcao = ler.nextInt();
			switch (opcao) {
			case 1:
				System.out.println(jogador.getSaldo());
				break;
				
			case 2: 
				Integer valordodado;
				jogador.jogardado();
				valordodado = jogador.jogardado();
				System.out.println(jogador.getNome() + " Jogou o dado e tirou " + valordodado);
				jogador.movejogador(valordodado, tabuleiro);
				System.out.println(jogador.getNome() + " foi para a posicao " + jogador.getPosicao());
				return;

			case 4:
				jogador.mostralista(jogador);
				break;

			case 5:
				// fazer
				break;

			case 6:
				System.out.println(jogador.getPosicao());
				break;

			default:
				break;
			}

		} while (opcao <= 7);

	}
	
	public boolean menuposjogada(Jogador jogador, Tabuleiro tabuleiro){
		Scanner ler = new Scanner(System.in);
		Integer opcao;
		do {
			System.out.println("Opcoes");
			System.out.println("1. Ver Saldo");
			System.out.println("4. Ver Lista de Imoveis");
			System.out.println("5.Ver Rendimento dos Imoveis Alugados");
			System.out.println("6. Ver Qual a Posição do Tabuleiro");
			System.out.println("7. Passar a Vez");
			opcao = ler.nextInt();
			switch (opcao) {
			case 1:
				System.out.println(jogador.getSaldo());
				break;
	
			case 4:
				jogador.mostralista(jogador);
				break;

			case 5:
				// fazer
				break;

			case 6:
				System.out.println(jogador.getPosicao());
				break;

			default:
				break;
			}

		} while (opcao < 7);
		
		return true;
	}
	

}
