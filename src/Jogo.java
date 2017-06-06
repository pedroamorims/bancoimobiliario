import java.util.ArrayList;
import java.util.Scanner;

public class Jogo {

	public static void main(String[] args) {
		Scanner ler = new Scanner(System.in);
		Tabuleiro tabuleiro = new Tabuleiro();
		ArrayList<Posicao> listaposicaojogador = new ArrayList<>();
		Posicao posicaoatual = new Posicao();
		Imovel imoveldaposicao = new Imovel();
		Integer tamanhotabuleiro = 20;
		listaposicaojogador = tabuleiro.listaposicao;
		tabuleiro.criatabuleiro(tamanhotabuleiro);
		tabuleiro.retornadados();
		ArrayList<Jogador> jogadores = new ArrayList<>();
		Jogador banco = new Jogador();
		Integer quantidadedejogadores;
		Integer faliu = 0;
		Integer jogadordavez = 0;
		Integer opcaodecompra = 0;
		Menu menu = new Menu();

		banco.setNome("Banco");
		for (int i = 0; i < tamanhotabuleiro; i++) {
			listaposicaojogador.get(i).getImovel().setProprietario(banco);
		}

		System.out.println("----Banco Imobiliario----");
		System.out.println("Digite a Quantidade de Jogadores (Maximo 5)");
		quantidadedejogadores = ler.nextInt();
		for (int i = 0; i < quantidadedejogadores; i++) {
			Jogador jogador = new Jogador();
			System.out.println("Digite o Nome do Jogador:");
			jogador.setNome(ler.next());
			jogador.setSaldo(200000.00);
			jogador.setPosicao(1);
			jogadores.add(jogador);
		}

		do {
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

		} while (faliu < quantidadedejogadores - 1);

	}
}
