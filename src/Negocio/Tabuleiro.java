package Negocio;
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Scanner;
import java.util.regex.Pattern;

public class Tabuleiro {

	private boolean temHospital;
	private ArrayList<Posicao> listaposicao = new ArrayList<>();

	public void criatabuleiro() {
		System.out.println("Criou");
		Integer posicao;
		Integer quantidadeposicoes;

		Scanner ler = new Scanner(System.in);

	
		
		try {
			FileReader arq = new FileReader("tabuleiro1.txt");
			BufferedReader lerArq = new BufferedReader(arq);

			String linha = lerArq.readLine(); // lê a primeira linha
			// a variável "linha" recebe o valor "null" quando o processo
			// de repetição atingir o final do arquivo texto
			Integer numerolinha = 1;
			while (linha != null) {
				Posicao pos;
				String quebra[] = linha.split(Pattern.quote(";"));
				if(numerolinha == 1){
				quantidadeposicoes =Integer.parseInt(linha);
				numerolinha++;
				}
				else if(Integer.parseInt(quebra[2]) == 1 || Integer.parseInt(quebra[2]) == 2 ){
					
					posicao = Integer.parseInt(quebra[1]);
					pos = new Posicao();
				    pos.setNumeropos(posicao);
				    getListaposicao().add(pos);
					numerolinha++;
				}
				
				else {
					
					switch (Integer.parseInt(quebra[3])) {
					case 1:
						posicao = Integer.parseInt(quebra[1]);
					    Residencia residencia = new Residencia();
					    residencia.setValor(Double.parseDouble(quebra[4]));
					    residencia.setTaxa(Double.parseDouble(quebra[5]));
					    System.out.println("Criou Residencia");
					    pos = new Posicao();
					    pos.setNumeropos(posicao);
					    getListaposicao().add(pos);
					    guardaposicao(posicao, residencia);
					    
						break;
						
					case 2:
						posicao = Integer.parseInt(quebra[1]);
					    Comercio comercio = new Comercio();
					    comercio.setValor(Double.parseDouble(quebra[4]));
					    comercio.setTaxa(Double.parseDouble(quebra[5]));
					    System.out.println("Criou Comercio");
					    pos = new Posicao();
					    pos.setNumeropos(posicao);
					    getListaposicao().add(pos);
					    guardaposicao(posicao, comercio);
					    
						break;
						
					case 3:
						posicao = Integer.parseInt(quebra[1]);
					    Industria industria = new Industria();
					    industria.setValor(Double.parseDouble(quebra[4]));
					    industria.setTaxa(Double.parseDouble(quebra[5]));
					    System.out.println("Criou Industria");
					    pos = new Posicao();
					    pos.setNumeropos(posicao);
					    getListaposicao().add(pos);
					    guardaposicao(posicao, industria);
					    
						break;
						
					case 4:
						posicao = Integer.parseInt(quebra[1]);
					    Hotel hotel = new Hotel();
					    hotel.setValor(Double.parseDouble(quebra[4]));
					    hotel.setTaxa(Double.parseDouble(quebra[5]));
					    System.out.println("Criou Hotel");
					    pos = new Posicao();
					    pos.setNumeropos(posicao);
					    getListaposicao().add(pos);
					    guardaposicao(posicao, hotel);
					    
						break;
						
					case 5:
						posicao = Integer.parseInt(quebra[1]);
					    Hospital hospital = new Hospital();
					    hospital.setValor(Double.parseDouble(quebra[4]));
					    hospital.setTaxa(Double.parseDouble(quebra[5]));
					    System.out.println("Criou Hospital");
					    pos = new Posicao();
					    pos.setNumeropos(posicao);
					    getListaposicao().add(pos);
					    guardaposicao(posicao, hospital);
					    
					    
						break;

					default:
						break;
					}
					numerolinha++;
				}

				linha = lerArq.readLine(); // lê da segunda até a última linha
			}

			arq.close();
		} catch (IOException e) {
			System.err.printf("Erro na abertura do arquivo: %s.\n", e.getMessage());
		}

		System.out.println();

			
	}



		
	



	public Integer quantidadedeposicoes() {
		return getListaposicao().size();
	}

	public void retornadados() {
		for (int i = 0; i < getListaposicao().size(); i++) {
			if(getListaposicao().get(i).getOcupado() == true){
			System.out.println(i + " " + getListaposicao().get(i).getImovel().getClass());
			}
		}
	}


	public void guardaposicao(Integer posicao, Imovel imovel) {
		for (int j = 0; j < getListaposicao().size(); j++) {
			if (getListaposicao().get(j).getNumeropos() == posicao) {

				getListaposicao().get(j).setImovel(imovel);
				getListaposicao().get(j).setOcupado(true);
				System.out.println("Posicao " + posicao + " " + getListaposicao().get(j).getImovel().getClass());

			}
		}
	}



	public Posicao retornaposicao(Integer posicaojogador) {
		Posicao pos = new Posicao();
		for (int i = 0; i < getListaposicao().size(); i++) {
			if (getListaposicao().get(i).getNumeropos() == posicaojogador) {
				pos = getListaposicao().get(i);
				return pos;
			}
		}

		return pos;
	}

	public ArrayList<Posicao> getListaposicao() {
		return listaposicao;
	}

	public void setListaposicao(ArrayList<Posicao> listaposicao) {
		this.listaposicao = listaposicao;
	}

}
