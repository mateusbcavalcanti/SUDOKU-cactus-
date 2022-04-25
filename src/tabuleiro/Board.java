package tabuleiro;

public abstract class Board {
	
	protected int coluna;
	protected int linha;
	private char [][] tabuleiro; 

	public Board(int coluna, int linha, char tabuleiro[][]) {
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

	public char[][] getTabuleiro() {
		return tabuleiro;
	}

	public abstract void exibeMatriz(char[][] tabuleiro); 
	
	public abstract void conflitantes(char[][] tabuleiro, int linha, int coluna,char numJogado);
		
	public static void posicoesFixas(char[][]tabuleiro,int[][]posicaoFixa) {
		
	//posicaoFixa = tabuleiro.clone();
	
	}

}