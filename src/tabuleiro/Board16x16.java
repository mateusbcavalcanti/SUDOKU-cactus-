package tabuleiro;

public class Board16x16 extends Board {
	
	

	public Board16x16(int coluna, int linha, int[][] tabuleiro9x9, char[][] tabuleiro16x16) {
		super(coluna, linha, tabuleiro9x9, tabuleiro16x16);
	}

	@Override
	public void exibeMatriz(int[][] tabuleiro16x16) { //Imprime o tabuleiro 16x16
		for (int i = 0; i < tabuleiro16x16.length; i++) {
	           for (int j = 0; j < tabuleiro16x16.length; j++) {
	                System.out.print(tabuleiro16x16[i][j] + " ");
	                if (j == 3 || j == 7 || j==11) System.out.print("| ");
	            }
	            System.out.println();
	            if (i == 3 || i == 7 || i==11)
	                System.out.print("------|-------|------\n");
	        }
	        System.out.println();
		
	}

	@Override
	public void conflitantes(int tabuleiro16x16[][], int linha, int coluna, int numJogado) {
		for (int i = 0; i < tabuleiro16x16.length; i++) {
			 if(tabuleiro16x16[linha][i] == numJogado ) { //verifica a linha e imprime as celulas conflitantes
	   				System.out.println("Linha:"+ linha + "coluna:" + i + "---- conflitam com: linha:"+linha + "coluna:" + coluna  );
	   				}
				}
	           
		for (int j = 0; j < tabuleiro16x16.length; j++) {
	        	   if(tabuleiro16x16[j][coluna] == numJogado) { //verifica a coluna e imprime as celulas conflitantes
		   			System.out.println("Linha:"+ j + "coluna:" + coluna + "---- conflitam com: linha:"+linha + "coluna:" + coluna  );
	        	   	}
	       		}
	      int linhaQuadrante = linha - linha %3;
	       		int colunaQuadrante = coluna - coluna %3;
	       		
	       		for(int i= linhaQuadrante; i<linhaQuadrante + 3; i++) { //verifica o quadrante e imprime as celulas conflitantes
	       			for(int j= colunaQuadrante; j<colunaQuadrante + 3; j++) {
	       				if(tabuleiro16x16[i][j] == numJogado) {
	       					System.out.println("Linha:"+ i + "coluna:" + j + "---- conflitam com: linha:"+linha + "coluna:" + coluna  );
	       				}
	       			}		
	       		}     
	           
		
	}
	

}
