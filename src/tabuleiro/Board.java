package tabuleiro;

import java.util.Random;

import model.exceptions.ConflitanteException;

public abstract class Board {
	
	protected int coluna;
	protected int linha;
	protected int[][] tabuleiro;
	protected int celula;

	public Board(int coluna, int linha, int[][] tabuleiro, int celula) {
		this.coluna = coluna;
		this.linha = linha;
		this.tabuleiro = tabuleiro;
		this.celula = celula;
		
	}
	
	public int getColuna() {
		return coluna;
	}

	public void setColuna(int coluna) {
		this.coluna = coluna;
	}

	public int getLinha() {
		return linha;
	}

	public void setLinha(int linha) {
		this.linha = linha;
	}

	
	public int[][] getTabuleiro() {
		return tabuleiro;
	}

	public void setTabuleiro(int[][] tabuleiro) {
		this.tabuleiro = tabuleiro;
	}
	
	
	public void setCelula(int linha, int coluna, int numeroJogado) {
		this.tabuleiro[linha][coluna] = numeroJogado;
	}

	
	public abstract void exibeMatriz(); 
	
	public abstract void conflitante(int linha, int coluna,int numJogado);
		
	public abstract void botao(int linha, int coluna);
	
	public abstract boolean posicoesFixas(int[][]posicoes, int linha, int coluna);
	
	public abstract boolean jogoCompleto();
	
	public abstract int[][] removeCelulas(int celulasZeradas);
	
	public abstract  int[][] geradorTabuleiro(int celulasZeradas);
	 
}
	
	
