import java.util.ArrayList;

/**
 * 
 * @author Fred e Pedro
 * @since 08/06/2017
 * Classe Imovel  
 */

public class Imovel {
	
	private String nome;
	private Double valor;
	private Jogador proprietario;
	public double taxa;
	
	/**
	 * 
	 * @return Metodo que seta a posicao de cada imovel
	 */
	
	public boolean setPosicao(Imovel imovel, Integer posicao, ArrayList<Posicao> listaposicao,Tabuleiro tabuleiro ){
		return true;
	}
	
	
	
	
	
	public double getTaxa() {
		return taxa;
	}
	public void setTaxa(double taxa) {
		this.taxa = taxa;
	}
	public Double getValor() {
		return valor;
	}
	public void setValor(Double valor) {
		this.valor = valor;
	}

	public Jogador getProprietario() {
		return proprietario;
	}
	public void setProprietario(Jogador proprietario) {
		this.proprietario = proprietario;
	}
	
	public String getNome() {
		return nome;
	}
	public void setNome(String nome) {
		this.nome = nome;
	}
	
	
	

}
