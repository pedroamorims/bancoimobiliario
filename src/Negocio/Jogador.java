package Negocio;
import java.util.ArrayList;

public class Jogador {
	private String nome;
	private String cor;
	private Double saldo;
	private ArrayList<Imovel> listadeimoveis = new ArrayList<>();
	private int posicao;
	private Double aluguelpago = 0.0;
	private Double aluguelrecebido = 0.0;
	
	
	
	
	
	
	public Double getAluguelpago() {
		return aluguelpago;
	}

	public void setAluguelpago(Double aluguelpago) {
		this.aluguelpago = aluguelpago;
	}

	public Double getAluguelrecebido() {
		return aluguelrecebido;
	}

	public void setAluguelrecebido(Double aluguelrecebido) {
		this.aluguelrecebido = aluguelrecebido;
	}

	public Integer jogardado(){
		
		Integer numero = (int) (1 + Math.random() * (6));
		return numero;
	}
	
	public void comprarimovel(Imovel imovel, Jogador jogador){
		saldo = saldo - imovel.getValor();
		listadeimoveis.add(imovel);
		imovel.setProprietario(jogador);
		
	}
	
	public void movejogador(Integer valordado, Tabuleiro tabuleiro){
		if (posicao + valordado > tabuleiro.quantidadedeposicoes()) {
			saldo = saldo + 200.00;
		    System.out.println("Ganhou R$200.00 por completar volta no tabuleiro");
			valordado = posicao + valordado - tabuleiro.quantidadedeposicoes();
			posicao = valordado;
		} else {
			posicao += valordado;
		}
		
	}
	
	public void mostralista(Jogador jogador){
		for (int i = 0 ; i<listadeimoveis.size(); i++){
			if(listadeimoveis.get(i).getProprietario().getNome() == jogador.getNome()){
			System.out.println(listadeimoveis.get(i).getNome() + " " + listadeimoveis.get(i).getValor() + " " + listadeimoveis.get(i).getProprietario().getNome());
			}
		}
	}
	
	public void cobraaluguel(Imovel imovel, Jogador devedor){
		double valorpago = 0.00;
		valorpago = (imovel.getValor() * imovel.getTaxa())/100;
		devedor.setSaldo(devedor.getSaldo() - valorpago);
		saldo += valorpago;
	}
	
	
	public String getNome() {
		return nome;
	}
	public void setNome(String nome) {
		this.nome = nome;
	}
	public String getCor() {
		return cor;
	}
	public void setCor(String cor) {
		this.cor = cor;
	}
	public Double getSaldo() {
		return saldo;
	}
	public void setSaldo(Double saldo) {
		this.saldo = saldo;
	}
	public ArrayList<Imovel> getListadeimoveis() {
		return listadeimoveis;
	}
	public void setListadeimoveis(ArrayList<Imovel> listadeimoveis) {
		this.listadeimoveis = listadeimoveis;
	}
	public int getPosicao() {
		return posicao;
	}
	public void setPosicao(int posicao) {
		this.posicao = posicao;
	}
	
	
	
	
	

}
