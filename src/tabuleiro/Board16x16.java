package tabuleiro;

public class Board16x16 extends Board {
	
	

	public Board16x16(int coluna, int linha, char[][] tabuleiro) {
		super(coluna, linha, tabuleiro);
	}

	@Override
	public void exibeMatriz(char[][] tabuleiro16x16) { //Imprime o tabuleiro 16x16
		for (int i = 0; i < tabuleiro16x16.length; i++) {
	           for (int j = 0; j < tabuleiro16x16.length; j++) {
	                System.out.print(tabuleiro16x16[i][j] + " ");
	                if (j == 3 || j == 7 || j==11) System.out.print("| ");
	            }
	            System.out.println();
	            if (i == 3 || i == 7 || i==11)
	                System.out.print("--------|---------|---------|---------\n");
	        }
	        System.out.println();
		
	}

	@Override
	public void conflitantes(char tabuleiro16x16[][], int linha, int coluna, char numJogado) {
		for (int i = 0; i < tabuleiro16x16.length; i++) {
			 if(tabuleiro16x16[linha][i] == numJogado && i!= coluna ) { //verifica a linha e imprime as celulas conflitantes
	   				System.out.println("JA PERTENCE A LINHA");
	   				}
				}
	           
		for (int j = 0; j < tabuleiro16x16.length; j++) {
	        	   if(tabuleiro16x16[j][coluna] == numJogado && j != linha) { //verifica a coluna e imprime as celulas conflitantes
		   			System.out.println("JA PERTENCE A COLUNA");
	        	   	}
	       		}
	      		
				int linhaQuadrante = linha - linha %4;
	       		int colunaQuadrante = coluna - coluna %4;
	       		
	       		for(int i= linhaQuadrante; i<linhaQuadrante + 4; i++) { //verifica o quadrante e imprime as celulas conflitantes
	       			for(int j= colunaQuadrante; j<colunaQuadrante + 4; j++) {
	       				if(tabuleiro16x16[i][j] == numJogado && i!= linha && j!= coluna  ) {
	       					System.out.println("JA PERTENCE AO QUADRANTE");
	       				}
	       			}		
	       		}     
	}		
}
