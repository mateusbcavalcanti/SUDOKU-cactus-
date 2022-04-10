package jogadas;

import java.util.Scanner;

public class Plays {
	
	private int[][] posicoesFixas;
	private int[][] tabuleiro;
	private int linha;
	private int coluna;
	private int numJogado;
	


	public int[][] getTabuleiro() {
		return tabuleiro;
	}

	public void setTabuleiro(int[][] tabuleiro) {
		this.tabuleiro = tabuleiro;
	}


	public void setLinha(int linha) {
		this.linha = linha;
	}


	public void setColuna(int coluna) {
		this.coluna = coluna;
	}

	
	public void setNumJogado(int numJogado) {
		this.numJogado = numJogado;
	}


	
}
