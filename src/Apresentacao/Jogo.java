package Apresentacao;
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Scanner;
import java.util.regex.Pattern;

import Negocio.Comercio;
import Negocio.Hospital;
import Negocio.Hotel;
import Negocio.Imovel;
import Negocio.Industria;
import Negocio.Jogador;
import Negocio.Posicao;
import Negocio.Residencia;
import Negocio.Tabuleiro;

public class Jogo {

	public static void main(String[] args) {
		Scanner ler = new Scanner(System.in);
		Tabuleiro tabuleiro = new Tabuleiro();
		ArrayList<Posicao> listaposicaojogador = new ArrayList<>();
		Posicao posicaoatual = new Posicao();
		Imovel imoveldaposicao = new Imovel();
		listaposicaojogador = tabuleiro.getListaposicao();
		tabuleiro.criatabuleiro();
		tabuleiro.retornadados();
		Integer tamanhotabuleiro = tabuleiro.quantidadedeposicoes();
		ArrayList<Jogador> jogadores = new ArrayList<>();
		Jogador banco = new Jogador();
		Integer quantidadedejogadores;
		Integer faliu = 0;
		Integer jogadordavez = 0;
		Integer opcaodecompra = 0;
		Menu menu = new Menu();
		banco.setNome("Banco");
		for (int i = 0; i < tamanhotabuleiro; i++) {
			if(listaposicaojogador.get(i).getOcupado()){
			listaposicaojogador.get(i).getImovel().setProprietario(banco);
			}
		}
		
		try {
			FileReader arq = new FileReader("jogadas4.txt");
			BufferedReader lerArq = new BufferedReader(arq);

			String linha = lerArq.readLine(); // lê a primeira linha
			// a variável "linha" recebe o valor "null" quando o processo
			// de repetição atingir o final do arquivo texto
			Integer numerolinha = 1;
			while (linha != null) {
				String quebra[] = linha.split(Pattern.quote(";"));
				if(numerolinha == 1){
				String quebra1[] = linha.split(Pattern.quote("%"));
				System.out.printf("%s\n", quebra1[0]);
				quantidadedejogadores = Integer.parseInt(quebra1[1]);
				for (int i = 0; i < quantidadedejogadores; i++) {
					Jogador jogador = new Jogador();
					
					jogador.setNome("Jogador "+i);
					jogador.setSaldo(Double.parseDouble(quebra1[2]));
					jogador.setPosicao(1);
					jogadores.add(jogador);
				}

				numerolinha++;
				
				}
				else if(Integer.parseInt(quebra[2]) == 1 || Integer.parseInt(quebra[2]) == 2 ){
					System.out.println(quebra[0] + " " + quebra[1] + " " + quebra[2]);
				
				}
				
				else {
					System.out.println(quebra[0] + " " + quebra[1] + " " + quebra[2] + " " + quebra[3] + " " + quebra[4] + " " + quebra[5]);
					
					numerolinha++;
				}

				linha = lerArq.readLine(); // lê da segunda até a última linha
			}

			arq.close();
		} catch (IOException e) {
			System.err.printf("Erro na abertura do arquivo: %s.\n", e.getMessage());
		}

		System.out.println("----Banco Imobiliario----");
		
		
	
		/*do {
			Jogador jogadoratual = new Jogador();
			jogadoratual = jogadores.get(jogadordavez);
			System.out.println("----" + jogadoratual.getNome() + "----");

			menu.menuprejogada(jogadoratual, tabuleiro);

			posicaoatual = tabuleiro.retornaposicao(jogadoratual.getPosicao());
			imoveldaposicao = posicaoatual.getImovel();
			System.out.println("Imovel da Posicao: " + imoveldaposicao.getNome() + " Proprietario "
					+ imoveldaposicao.getProprietario().getNome());

			if (imoveldaposicao.getProprietario().getNome() == "Banco") {
				System.out.println(
						"Deseja adquirir " + imoveldaposicao.getNome() + " por " + imoveldaposicao.getValor() + " ?");
				System.out.println("Opcoes");
				System.out.println("1. Comprar");
				System.out.println("2. Não Comprar");
				opcaodecompra = ler.nextInt();
				if (opcaodecompra == 1) {
					if(jogadoratual.getSaldo() < imoveldaposicao.getValor())
						System.out.println("Voce nao tem saldo suficiente!!");{
							if (jogadordavez == quantidadedejogadores-1) {
								jogadordavez = 0;
							} else {
								jogadordavez++;
							}
						}
					jogadoratual.comprarimovel(imoveldaposicao, jogadoratual);
					menu.menuposjogada(jogadoratual, tabuleiro);
						if (jogadordavez == quantidadedejogadores-1) {
							jogadordavez = 0;
						} else {
							jogadordavez++;
						}
					}
					
				}
			


			else if (imoveldaposicao.getProprietario().getNome() == jogadoratual.getNome()) {
				System.out.println("Este imovel já é seu!!");

				menu.menuposjogada(jogadoratual, tabuleiro);
				if (jogadordavez == quantidadedejogadores) {
					jogadordavez = 0;
				} else {
					jogadordavez++;
				}
			}

			else {

				Jogador proprietario = new Jogador();
				for (int i = 0; i < quantidadedejogadores; i++) {
					if (jogadores.get(i).getNome() == imoveldaposicao.getProprietario().getNome())
						;
					proprietario = jogadores.get(i);
				}

				proprietario.cobraaluguel(imoveldaposicao, jogadoratual);
				System.out.println(jogadoratual.getNome() + " pagou R$"
						+ (imoveldaposicao.getValor() * imoveldaposicao.getTaxa()) + " para " + proprietario.getNome());
				jogadoratual.setAluguelpago(jogadoratual.getAluguelpago()+imoveldaposicao.getTaxa());
				proprietario.setAluguelrecebido(jogadoratual.getAluguelrecebido()+imoveldaposicao.getTaxa());
				
				
				if(jogadoratual.getSaldo() <= 0){
					System.out.println(jogadoratual.getNome() + " Faliu!!");
				}
				else{
				menu.menuposjogada(jogadoratual, tabuleiro);
				if (jogadordavez == quantidadedejogadores) {
					jogadordavez = 0;
				} else {
					jogadordavez++;
				}
				}
			}

		} while (faliu < quantidadedejogadores - 1);*/

	}
}
