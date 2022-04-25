package tabuleiro;

public class Board9x9 extends Board {

	public Board9x9(int coluna, int linha,char[][] tabuleiro) {
		super(coluna, linha,tabuleiro);
		
	}

	@Override
	public void exibeMatriz(char[][] tabuleiro) {		//Imprime tabuleiro 9x9
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

	@Override
	public void conflitantes(char tabuleiro[][], int linha, int coluna, char numJogado) {
		
		for (int i = 0; i < tabuleiro.length; i++) {
	           if(tabuleiro[linha][i] == numJogado && i!= coluna) { //verifica a linha e imprime as celulas conflitantes
	   				//System.out.println("Linha:"+ linha + " coluna:" + i + "---- conflitam com: linha:"+linha + "coluna:" + coluna  );
	   				System.out.println("jA PERTENCE A LINHA" );
	   				}
				}
			
		for (int j = 0; j < tabuleiro.length; j++) {
	        	 if(tabuleiro[j][coluna] == numJogado && j != linha) { //verifica a coluna e imprime as celulas conflitantes
		   			//System.out.println("Linha:"+ j + " coluna:" + coluna + "---- conflitam com: linha:"+linha + "coluna:" + coluna  );
		   			System.out.println("JA PERTENCE A COLUNA");

	   				}
	        	}
	         
	       					
	       		 
				int linhaQuadrante = linha - linha %3;
	       		int colunaQuadrante = coluna - coluna %3;
	       		
	       		for(int k= linhaQuadrante; k<linhaQuadrante + 3; k++) { //verifica o quadrante e imprime as celulas conflitantes
	       			for(int l= colunaQuadrante; l<colunaQuadrante + 3; l++) {
	       				if(tabuleiro[k][l] == numJogado && k!= linha && l!= coluna ) {
	       					//System.out.println("Linha:"+ k + " coluna:" + l + "---- conflitam com: linha:"+linha + "coluna:" + coluna  );
	       					System.out.println("JA PERTENCE AO QUADRANTE");
	       				}
	       			}
	       		}
			}
		}