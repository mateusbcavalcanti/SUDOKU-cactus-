package tabuleiro;

public interface BoardInterface { 

	public  void exibeMatriz(int[][] tabuleiro); 
	
	public  void conflitantes(int[][] tabuleiro, int linha, int coluna,int numJogado);
		
	public  void botao(int linha, int coluna, int tabuleiro[][]);
	
	public  boolean posicoesFixas(int[][]tabuleiro, int[][]posicoes, int linha, int coluna);
	
	public  boolean jogoCompleto(int[][] tabuleiro);
	
}

