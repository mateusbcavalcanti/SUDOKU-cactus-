package tabuleiro;

import java.util.ArrayList;

import model.exceptions.ConflitanteException;
import model.exceptions.InvalidCharException;

public class Board16x16 extends Board {
	
	

	public Board16x16(int coluna, int linha, int[][] tabuleiro) {
		super(coluna, linha, tabuleiro);
	}

	@Override
	public void exibeMatriz(int[][] tabuleiro) { //Imprime o tabuleiro 16x16
		for (int i = 0; i < tabuleiro.length; i++) {
	           for (int j = 0; j < tabuleiro.length; j++) {
	        	   if(tabuleiro[i][j] <10) {
	        		   System.out.print(tabuleiro[i][j] + "  ");
	        	   }
	        	   else {
	        		   System.out.print(tabuleiro[i][j] + " "); 
	        	   }
	                
	                if (j == 3 || j == 7 || j==11) System.out.print("|  ");
	            }
	            System.out.println();
	            if (i == 3 || i == 7 || i==11)
	                System.out.print("------------|--------------|--------------|-------------\n");
	        }
	        System.out.println();
		
	}

	@Override
	public void conflitantes(int tabuleiro[][], int linha, int coluna, int numJogado)throws ConflitanteException, InvalidCharException{
		for (int i = 0; i < tabuleiro.length; i++) {
			 if(tabuleiro[linha][i] == numJogado && i!= coluna ) { //verifica a linha e imprime as celulas conflitantes
	   			 throw new ConflitanteException("Linha:"+ linha + " coluna:" + i + " ---- conflitam com a celula modificada"  );	
				 //System.out.println("JA PERTENCE A LINHA");
	   				}
				}
	           
		for (int j = 0; j < tabuleiro.length; j++) {
	        	   if(tabuleiro[j][coluna] == numJogado && j != linha) { //verifica a coluna e imprime as celulas conflitantes
	        		   throw new ConflitanteException("Linha:"+ j + " coluna:" + coluna + " ---- conflitam com a celula modificada" );
	        		   //System.out.println("JA PERTENCE A COLUNA");
	        	   	}
	       		}
	      		
				int linhaQuadrante = linha - linha %4;
	       		int colunaQuadrante = coluna - coluna %4;
	       		
	       		for(int k= linhaQuadrante; k<linhaQuadrante + 4; k++) { //verifica o quadrante e imprime as celulas conflitantes
	       			for(int l= colunaQuadrante; l<colunaQuadrante + 4; l++) {
	       				if(tabuleiro[k][l] == numJogado && k!= linha && l!= coluna  ) {
	       					throw new ConflitanteException("Linha: "+ k + " coluna: " + l + " ---- conflitam com a celula modificada");
	       					//System.out.println("JA PERTENCE AO QUADRANTE");
	       				}
	       			}		
	       		}     
	}

	@Override
	public void botao(int linha, int coluna, int[][] tabuleiro) {
		int[]elementos = {1,2,3,4,5,6,7,8,9,10,11,12,13,14,15,16}; 
 	   
    	ArrayList<Integer> test = new ArrayList<Integer>();
       	ArrayList<Integer> testeColuna = new ArrayList<Integer>();
       	ArrayList<Integer> testeQuadrante = new ArrayList<Integer>();
       	ArrayList<Integer> testeLinha = new ArrayList<Integer>();
       	
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
	public boolean posicoesFixas(int[][] tabuleiro,int[][] posicoes, int linha, int coluna) {//Pega o tabuleiro incial e armazena as posicoes para comparar com o tabuleiro
																								//gerado pelas modificações do usuario a fim de saber se aquela celula é a fixa ou nao
		if(tabuleiro[linha][coluna] != posicoes[linha][coluna] || tabuleiro[linha][coluna] == 0 ) {
			return true;
		}
		
		else {
			return false;
		}
		
		
	}

	@Override
	public boolean jogoCompleto(int[][] tabuleiro) {
		 ArrayList<Integer> principal = new ArrayList<>();
         ArrayList<Integer> coluna = new ArrayList<>();
         ArrayList<Integer> linha = new ArrayList<>();

         if(tabuleiro.length != tabuleiro[0].length) return false;

         for(int i = 0; i < tabuleiro.length; i+=3){
             for(int j = 0; j < tabuleiro.length; j+=3){

                 for(int i1 = i; i1 < 3+i; i1++){
                     for(int j1 = j; j1 < 3+j; j1++){
                         if(principal.contains(tabuleiro[i1][j1]) || principal.contains(0)){
                             return false;
                         }
                         principal.add(tabuleiro[i1][j1]);
                     }
                 }
                 principal.clear();
             }

         }

         for(int i = 0; i < tabuleiro.length; i++){
             for(int i1 = 0; i1 < tabuleiro.length; i1++){
                 if(coluna.contains(tabuleiro[i][i1]) || coluna.contains(0) ){
                     return false;
                 }
                 coluna.add(tabuleiro[i][i1]);
             }

             for(int j = 0; j < tabuleiro.length; j++){

                 if(linha.contains(tabuleiro[j][i]) || linha.contains(0)){
                     return false;
                 }
                 linha.add(tabuleiro[j][i]);
             }
             linha.clear();
             coluna.clear();
         }

         return true;
	}

	
	}		

