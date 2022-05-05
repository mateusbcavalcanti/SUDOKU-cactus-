package tabuleiro;

public abstract class Board {
	
	protected int coluna;
	protected int linha;
	private int [][] tabuleiro; 

	public Board(int coluna, int linha, int tabuleiro[][]) {
		this.coluna = coluna;
		this.linha = linha;
		this.tabuleiro = tabuleiro;
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



	public abstract void exibeMatriz(int[][] tabuleiro); 
	
	public abstract void conflitantes(int[][] tabuleiro, int linha, int coluna,int numJogado);
		
	public abstract void botao(int linha, int coluna, int tabuleiro[][]);
	
	public abstract boolean posicoesFixas(int[][]tabuleiro, int[][]posicoes, int linha, int coluna);
	
	public abstract boolean jogoCompleto(int[][] tabuleiro);
	
}
