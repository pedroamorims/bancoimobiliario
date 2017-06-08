import java.util.ArrayList;

/**
 * 
 * @author Fred e Pedro
 * @since 08/06/2017
 * Classe que representa o Hospital e herda de imovel.   
 */

public class Hospital extends Imovel {
	public Hospital(){
		setNome("Hospital");
		setTaxa(0.04);
		setValor(10000.00);
	}
}
