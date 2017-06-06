import java.util.ArrayList;

public class Tabuleiro {

	private boolean temHospital;
	ArrayList<Posicao> listaposicao = new ArrayList<>();

	public void criatabuleiro(Integer quantidadedeposicoes) {
		System.out.println("Criou");
		Integer posicao;

		Integer quantidadeocupada = 0;
		Integer quantidadecasas = 0;
		Integer quantidadehotel = 0;
		for (int i = 0; i < quantidadedeposicoes; i++) {
			posicao = (int) (1 + Math.random() * (quantidadedeposicoes));

			if (verificaseposicaoexiste(posicao)) {
				i--;
			}

			else if (estaocupado(posicao)) {
				i--;
			} else if (!isTemHospital()) {
				System.out.println("Criou Hospital");
				Hospital hospital = new Hospital();
				Posicao pos = new Posicao();
				pos.setNumeropos(posicao);
				listaposicao.add(pos);
				guardaposicao(posicao, hospital);
				setTemHospital(true);
				quantidadeocupada++;
				

			}

			else if ((posicao < (listaposicao.size() / 2) && (quantidadehotel != 2))) {
				Hotel hotel = new Hotel();
				Posicao pos = new Posicao();
				pos.setNumeropos(posicao);
				listaposicao.add(pos);
				guardaposicao(posicao, hotel);
				quantidadeocupada++;
				quantidadehotel++;

			}
			
			else if ((posicao > (listaposicao.size() / 2) && (quantidadehotel != 2))) {
				Hotel hotel = new Hotel();
				Posicao pos = new Posicao();
				pos.setNumeropos(posicao);
				listaposicao.add(pos);
				guardaposicao(posicao, hotel);
				quantidadeocupada++;
				quantidadehotel++;

			}
			

			else if (i % 2 == 0 && quantidadecasas < 10) {
				System.out.println("Criou Residencia");
				Residencia residencia = new Residencia();
				Posicao pos = new Posicao();
				pos.setNumeropos(posicao);
				listaposicao.add(pos);
				guardaposicao(posicao, residencia);
				quantidadeocupada++;
			}

			else if (i % 2 != 0 && quantidadecasas < 10) {
				System.out.println("Criou Comercio");
				Comercio comercio = new Comercio();
				Posicao pos = new Posicao();
				pos.setNumeropos(posicao);
				listaposicao.add(pos);
				guardaposicao(posicao, comercio);
				quantidadeocupada++;
				quantidadecasas++;
			
			}

			else if (quantidadecasas == 10) {
				System.out.println("Criou Clubsocial");
				ClubeSocial clubesocial = new ClubeSocial();
				Posicao pos = new Posicao();
				pos.setNumeropos(posicao);
				listaposicao.add(pos);
				guardaposicao(posicao, clubesocial);
				quantidadecasas = 0;
				quantidadeocupada++;
			}
			posicao = (int) (1 + Math.random() * (quantidadedeposicoes));

		}
	}

	public boolean estaocupado(Integer posicao) {
		for (int j = 0; j < listaposicao.size(); j++) {
			if (listaposicao.get(j).getNumeropos() == posicao) {
				if (listaposicao.get(j).getOcupado()) {
					return true;
				} else {
					return false;
				}
			}
		}

		return false;
	}

	public Integer quantidadedeposicoes() {
		return listaposicao.size();
	}

	public void retornadados() {
		for (int i = 0; i < listaposicao.size(); i++) {
			System.out.println(i + " " + listaposicao.get(i).getImovel().getClass());
		}
	}

	public boolean isTemHospital() {
		return temHospital;
	}

	public void setTemHospital(boolean temHospital) {
		this.temHospital = temHospital;
	}

	public void guardaposicao(Integer posicao, Imovel imovel) {
		for (int j = 0; j < listaposicao.size(); j++) {
			if (listaposicao.get(j).getNumeropos() == posicao) {

				listaposicao.get(j).setImovel(imovel);
				listaposicao.get(j).setOcupado(true);
				System.out.println("Posicao " + posicao + " " + listaposicao.get(j).getImovel().getClass());

			}
		}
	}

	public boolean verificaseposicaoexiste(Integer posicao) {
		for (int i = 0; i < listaposicao.size(); i++) {
			if (listaposicao.get(i).getNumeropos() == posicao) {
				return true;
			}
		}

		return false;

	}

	public Posicao retornaposicao(Integer posicaojogador) {
		Posicao pos = new Posicao();
		for (int i = 0; i < listaposicao.size(); i++) {
			if (listaposicao.get(i).getNumeropos() == posicaojogador) {
				pos = listaposicao.get(i);
				return pos;
			}
		}

		return pos;
	}

}
