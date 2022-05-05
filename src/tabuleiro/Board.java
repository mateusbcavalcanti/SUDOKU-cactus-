package tabuleiro;

public abstract class Board {
	
	protected int coluna;
	protected int linha;
	protected int [][] tabuleiro; 

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
	
}
