package tabuleiro;

import java.util.ArrayList;

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

	@Override
	public void botao(int linha, int coluna, char[][] tabuleiro) {
		char[]elementos = {'1','2','3','4','5','6','7','8','9','a','b','c','d','e','f','g'}; 
 	   
    	ArrayList<Character> test = new ArrayList<Character>();
       	ArrayList<Character> testeColuna = new ArrayList<Character>();
       	ArrayList<Character> testeQuadrante = new ArrayList<Character>();
       	ArrayList<Character> testeLinha = new ArrayList<Character>();
       	
       	for(int i=0; i<elementos.length; i++) {//adicionando os valores de 1 a 9 ao list
       		test.add(elementos[i]);
       	}
    
       	
       	for (int i = 0; i < tabuleiro.length; i++) {//adicionando valores da linha ao list
   	         testeLinha.add(tabuleiro[linha][i]); 
   	   				}

       	
       	for(int j=0; j<tabuleiro.length; j++) {//adicionando valores da coluna ao list
       		testeColuna.add(tabuleiro[j][coluna]); 
       	}

       	
       	int linhaQuadrante = linha - linha %4;
   		int colunaQuadrante = coluna - coluna %4;
   		
   		for(int k= linhaQuadrante; k<linhaQuadrante + 4; k++) { //adicionando os valores do quadrante ao list
   			for(int l= colunaQuadrante; l<colunaQuadrante + 4; l++) {
   				testeQuadrante.add(tabuleiro[k][l]);
   				}
   			}
     	
   		
   		test.removeAll(testeLinha);
   		
   		test.removeAll(testeColuna);
   		
    	test.removeAll(testeQuadrante);
    	
    	System.out.println("Esses soa os valores disponiveis para a celula:"+ test);
		
	}

	@Override
	public boolean posicoesFixas(char[][] tabuleiro, char[][] posicoes, int linha, int coluna) {
		posicoes = tabuleiro.clone();
		
		if(tabuleiro[linha][coluna] == posicoes[linha][coluna] && tabuleiro[linha][coluna] != '0' ) {
			return true;
		}
		
		else {
			return false;
		}
		
		
	}

	
	}		

