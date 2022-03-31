package entidades;

public class Board {

	
	public static void exibeMatriz(int[][] tabuleiro) {
       
		for (int i = 0; i < tabuleiro.length; i++) {
           for (int j = 0; j < tabuleiro.length; j++) {
                System.out.print(tabuleiro[i][j] + " ");
                if (j == 2 || j == 5) System.out.print("| ");
            }
            System.out.println();
            if (i == 2 || i == 5)
                System.out.print("------|-------|------\n");
        }
        System.out.println();
    }
	
	
	
	public static void posicoesFixas(int[][]tabuleiro,int[][]posicaoFixa) {
		
	posicaoFixa = tabuleiro.clone();
	
	}
	
	public static boolean verificarLinha(int[][] tabuleiro, int linha, int numJogado) {
		
		for(int i=0; i<tabuleiro.length; i++) {
			if(tabuleiro[linha][i] == numJogado) {
				return true;
			}
		}
		return false;
	}
	
	public static boolean verificarColuna(int[][] tabuleiro, int coluna, int numJogado) {
		
		for(int j=0; j<tabuleiro.length; j++) {
			if(tabuleiro[j][coluna] == numJogado) {
				return true;
				}
			}
		return false;
	}

	public static boolean verificarQuadrante(int[][] tabuleiro, int linha, int coluna, int numJogado) {
		
		int linhaQuadrante = linha - linha %3;
		int colunaQuadrante = coluna - coluna %3;
		
		for(int i= linhaQuadrante; i<linhaQuadrante + 3; i++) {
			for(int j= colunaQuadrante; j<colunaQuadrante + 3; j++) {
				if(tabuleiro[i][j] == numJogado) {
					return true;
				}
			}		
		}
		return false;
	}



}