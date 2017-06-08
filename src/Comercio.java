import java.util.ArrayList;

/**
 * 
 * @author Fred e Pedro
 * @since 08/06/2017
 * Classe que representa o Comercio e herda de Imovel.  
 */
public class Comercio extends Imovel {
	
	public Comercio(){
		setNome("Comercio");
		setTaxa(0.3);
		setValor(1000.00);
	}
}
