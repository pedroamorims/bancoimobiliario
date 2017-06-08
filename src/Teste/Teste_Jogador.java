package Teste;

import static org.junit.Assert.*;

import java.util.ArrayList;

import org.junit.Test;

import Negocio.Jogador;

public class Teste_Jogador {
	
	@Test
	public void teste_Dinheiro(){
		Jogador j = new Jogador();
		j.setSaldo(3000.0);
		double Saldo;
		Saldo = j.getSaldo();
		assertTrue(Saldo==3000.0);		
	}
	
	@Test
	public void teste_AluguelRecebido(){
		Jogador j = new Jogador(); 
		j.setAluguelrecebido(100.0);
		j.setAluguelrecebido(100.0);
		double Recebido; 
		Recebido = j.getAluguelrecebido();
		assertFalse(Recebido==200.0);
	}
	
	@Test 
	public void teste_AluguelPago(){
	   Jogador j = new Jogador(); 
	   j.setAluguelpago(100.0);
	   j.setAluguelpago(100.0);
	   double Pago; 
	   Pago = j.getAluguelrecebido();
	   assertFalse(Pago==200.0);
	}
	
	@Test 
	public void teste_Jogador(){ 
		Jogador j = new Jogador();
		j.setPosicao(2);
		int posicao;
		posicao = j.getPosicao();
		assertEquals(posicao, 2);
	}
	
    @Test
	public void teste_Array(){
    ArrayList<Jogador> lista = new ArrayList<Jogador>();

    Jogador j = new Jogador();
    lista.add(j);
    lista.indexOf(j);
    lista.get(0).getNome(); 
    lista.size();
    lista.remove(j);
    }
}

