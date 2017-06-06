package Negocio;
import java.util.ArrayList;

public class Imovel {
	
	private String nome;
	private Double valor;
	private Jogador proprietario;
	public double taxa;
	
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
