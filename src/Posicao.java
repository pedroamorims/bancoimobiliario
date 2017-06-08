import java.util.ArrayList;

/**
 * 
 * @author Fred e Pedro
 * @since 08/06/2017
 * Classe Posicao, vai guardar a posicao de cada imovel
 */

public class Posicao {
	
	
	private boolean ocupado;
	private Imovel imovel;
	private Integer numeropos;
	

	/**
	 * 
	 * @param Metodo que seta a posicao de cada imovel
	 */
	
	
	//Criar Posicoes passar quantidade como parametro
	
	
		
	
	
	public Integer getNumeropos() {
		return numeropos;
	}
	

	public void setNumeropos(Integer numeropos) {
		this.numeropos = numeropos;
	}


	public Imovel getImovel() {
		return imovel;
	}


	public void setImovel(Imovel imovel) {
		this.imovel = imovel;
	}


	public boolean getOcupado() {
		return ocupado;
	}
	public void setOcupado(boolean ocupado) {
		this.ocupado = ocupado;
	}

	

}
