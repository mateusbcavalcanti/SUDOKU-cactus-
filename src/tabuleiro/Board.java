package tabuleiro;

public abstract class Board {
	
	protected int coluna;
	protected int linha;
	private int [][] tabuleiro9x9 = {
			{0,8,0,5,7,6,2,0,0},
			{0,0,0,4,0,2,0,0,0},
			{0,0,0,0,3,9,5,4,8},
			{6,3,0,9,0,0,8,5,2},
			{0,9,0,2,0,0,3,7,0},
			{8,0,0,0,5,0,6,9,4},
			{2,5,7,6,0,3,4,8,9},
			{3,0,8,7,0,0,0,2,5},
			{0,4,0,0,0,0,0,0,6}
			};
	private char [][] tabuleiro16x16 = {
			{1,5,8,0,'c','f',0,'e',0,2,'b',0,6,0,0,7},
			{6,'d',0,0,0,0,0,'b',8,0,0,5,'e',1,0,'a'},
			{0,2,0,0,8,0,'a',0,1,'f',0,'d','c',0,0,0},
			{'b',0,0,6,0,'e','c',0,0,'o','d',0,'f',8,0,0},
			{8,0,0,0,4,0,6,'f',9,1,2,0,0,'c',0,3},
			{2,'e','d','c','o',0,3,0,0,0,0,0,1,'b','a',0},
			{0,'f',3,0,0,2,'b',0,4,0,0,0,7,0,5,6},
			{0,'c',0,'b','f',0,0,5,0,6,1,4,0,'e','o',0},
			{'e','o','a',0,6,0,0,5,'b',0,'c',0,0,2,0,8},
			{2,7,0,8,'b','o','e',0,0,0,0,1,'c',0,5,'b'},
			{'c','b',0,0,'f',2,'a',7,0,0,9,0,'d',0,0,3},
			{0,0,'d',5,'c',0,'b',0,4,2,'o',0,'f',0,7,'e'},
			{0,'f',0,3,0,'b',9,0,0,0,'a',0,0,'o',6,0},
			{'o',8,5,0,2,0,1,'f',7,6,'e',3,0,'c',0,0},
			{7,4,0,0,'a','c',0,0,0,0,1,'d',5,0,0,'f'},
			{1,0,'c',9,'o',0,5,'d',2,4,'b',0,8,3,0,0}
		};
	
	public Board(int coluna, int linha, int tabuleiro9x9[][], char tabuleiro16x16[][]) {
		this.coluna = coluna;
		this.linha = linha;
		this.tabuleiro9x9 = tabuleiro9x9;
		this.tabuleiro16x16 = tabuleiro16x16;
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

	public int[][] getTabuleiro9x9() {
		return tabuleiro9x9;
	}

	public char[][] getTabuleiro16x16() {
		return tabuleiro16x16;
	}


	public abstract void exibeMatriz(int[][] tabuleiro); 
	
	public abstract void conflitantes(int[][] tabuleiro, int linha, int coluna,int numJogado);
		
	public static void posicoesFixas(int[][]tabuleiro,int[][]posicaoFixa) {
		
	posicaoFixa = tabuleiro.clone();
	
	}
	
	
	


}