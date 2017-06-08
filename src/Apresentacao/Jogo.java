package Apresentacao;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Scanner;
import java.util.regex.Pattern;

import Negocio.Imovel;
import Negocio.Jogador;
import Negocio.Posicao;
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
		Integer quantidadedejogadores = 0;
		Integer faliu = 0;
		Integer jogadordavez = 0;
		Integer opcaodecompra = 0;
		Menu menu = new Menu();
		banco.setNome("Banco");
		for (int i = 0; i < tamanhotabuleiro; i++) {
			if (listaposicaojogador.get(i).getOcupado()) {
				listaposicaojogador.get(i).getImovel().setProprietario(banco);
			}
		}

		// menu.menuprejogada(jogadoratual, tabuleiro);

		try {
			FileReader arq = new FileReader("jogadas4.txt");
			BufferedReader lerArq = new BufferedReader(arq);

			String linha = lerArq.readLine(); // lê a primeira linha
			// a variável "linha" recebe o valor "null" quando o processo
			// de repetição atingir o final do arquivo texto
			Integer numerolinha = 1;
			while (linha != null) {

				if (linha.contains("DUMP")) {

					linha = lerArq.readLine(); // lê da segunda até a última
												// linha

				}

				else {
					String quebra[] = linha.split(Pattern.quote(";"));

					if (numerolinha == 1) {
						String quebra1[] = linha.split(Pattern.quote("%"));
						System.out.printf("%s\n", quebra1[0]);
						quantidadedejogadores = Integer.parseInt(quebra1[1]);
						System.out.println(quantidadedejogadores);
						for (int i = 0; i < quantidadedejogadores; i++) {

							Jogador jogador = new Jogador();

							jogador.setNome("Jogador " + i);
							jogador.setSaldo(Double.parseDouble(quebra1[2]));
							jogador.setPosicao(1);
							jogadores.add(jogador);
						}

						numerolinha++;

					}

					else {
						Jogador jogadoratual = new Jogador();
						jogadoratual = jogadores.get(Integer.parseInt(quebra[1]) - 1);
						System.out.println("----" + jogadoratual.getNome() + "----");

						System.out.println(quebra[0] + " " + quebra[1] + " " + quebra[2]);
						menu.menuprejogada(jogadoratual, tabuleiro, Integer.parseInt(quebra[2]), 2);
						posicaoatual = tabuleiro.retornaposicao(jogadoratual.getPosicao());
						if (!posicaoatual.getOcupado()) {
							System.out.println("Posicao Vazia");
						}

						else {
							imoveldaposicao = posicaoatual.getImovel();
							System.out.println("Imovel da Posicao: " + imoveldaposicao.getNome() + " Proprietario "
									+ imoveldaposicao.getProprietario().getNome());

							if (imoveldaposicao.getProprietario().getNome() == "Banco") {
								System.out.println(jogadoratual.getNome() + " comprou " + imoveldaposicao.getNome()
										+ " por " + imoveldaposicao.getValor() + " !");
								jogadoratual.comprarimovel(imoveldaposicao, jogadoratual);
								if (jogadoratual.getSaldo() < 0) {
									faliu++;
								}

							}

							else if (imoveldaposicao.getProprietario().getNome() == jogadoratual.getNome()) {
								System.out.println("Este imovel já é seu!!");

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
										+ ((imoveldaposicao.getValor() * imoveldaposicao.getTaxa() / 100)) + " para "
										+ proprietario.getNome());
								jogadoratual.setAluguelpago(jogadoratual.getAluguelpago() + imoveldaposicao.getTaxa());
								proprietario.setAluguelrecebido(
										jogadoratual.getAluguelrecebido() + imoveldaposicao.getTaxa());

								if (jogadoratual.getSaldo() <= 0) {
									System.out.println(jogadoratual.getNome() + " Faliu!!");
									faliu++;
								}

							}
						}

						numerolinha++;
					}

					linha = lerArq.readLine(); // lê da segunda até a última
												// linha
				}

			}
			arq.close();
		} catch (IOException e) {
			System.err.printf("Erro na abertura do arquivo: %s.\n", e.getMessage());
		}

		System.out.println("----Acabou o Arquivo----");

	}
}
