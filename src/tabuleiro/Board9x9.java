package tabuleiro;

public class Board9x9 extends Board {

	public Board9x9(int coluna, int linha, int[][] tabuleiro9x9, char[][] tabuleiro16x16) {
		super(coluna, linha, tabuleiro9x9,tabuleiro16x16);
		
	}

	@Override
	public void exibeMatriz(int[][] tabuleiro9x9) {		//Imprime tabuleiro 9x9
		for (int i = 0; i < tabuleiro9x9.length; i++) {
	           for (int j = 0; j < tabuleiro9x9.length; j++) {
	                System.out.print(tabuleiro9x9[i][j] + " ");
	                if (j == 2 || j == 5) System.out.print("| ");
	            }
	            System.out.println();
	            if (i == 2 || i == 5)
	                System.out.print("------|-------|------\n");
	        }
	        System.out.println();
		
	}

	@Override
	public void conflitantes(int tabuleiro9x9[][], int linha, int coluna, int numJogado) {
		
		for (int i = 0; i < tabuleiro9x9.length; i++) {
	           if(tabuleiro9x9[linha][i] == numJogado && i!= coluna) { //verifica a linha e imprime as celulas conflitantes
	   				//System.out.println("Linha:"+ linha + " coluna:" + i + "---- conflitam com: linha:"+linha + "coluna:" + coluna  );
	   				System.out.println("jA PERTENCE A LINHA" );
	   				}
				}
			
		for (int j = 0; j < tabuleiro9x9.length; j++) {
	        	 if(tabuleiro9x9[j][coluna] == numJogado && j != linha) { //verifica a coluna e imprime as celulas conflitantes
		   			//System.out.println("Linha:"+ j + " coluna:" + coluna + "---- conflitam com: linha:"+linha + "coluna:" + coluna  );
		   			System.out.println("JA PERTENCE A COLUNA");

	   				}
	        	}
	         
	       					
	       		 
				int linhaQuadrante = linha - linha %3;
	       		int colunaQuadrante = coluna - coluna %3;
	       		
	       		for(int k= linhaQuadrante; k<linhaQuadrante + 3; k++) { //verifica o quadrante e imprime as celulas conflitantes
	       			for(int l= colunaQuadrante; l<colunaQuadrante + 3; l++) {
	       				if(tabuleiro9x9[k][l] == numJogado && k!= linha && l!= coluna ) {
	       					//System.out.println("Linha:"+ k + " coluna:" + l + "---- conflitam com: linha:"+linha + "coluna:" + coluna  );
	       					System.out.println("JA PERTENCE AO QUADRANTE");
	       				}
	       			}
	       		}
			}
		}