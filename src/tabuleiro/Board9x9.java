package tabuleiro;

import java.util.ArrayList;

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
	   				System.out.println("Linha:"+ linha + " coluna:" + i + " ---- conflitam com a celula modificada"  );
	   				//System.out.println("jA PERTENCE A LINHA" );
	   				}
	          
				}
			
		for (int j = 0; j < tabuleiro.length; j++) {
	        	 if(tabuleiro[j][coluna] == numJogado && j != linha) { //verifica a coluna e imprime as celulas conflitantes
		   			System.out.println("Linha:"+ j + " coluna:" + coluna + " ---- conflitam com a celula modificada" );
		   			//System.out.println("JA PERTENCE A COLUNA");

	   				}
	        	
	        	}
	         
	       					 
				int linhaQuadrante = linha - linha %3;
	       		int colunaQuadrante = coluna - coluna %3;
	       		
	       		for(int k= linhaQuadrante; k<linhaQuadrante + 3; k++) { //verifica o quadrante e imprime as celulas conflitantes
	       			for(int l= colunaQuadrante; l<colunaQuadrante + 3; l++) {
	       				if(tabuleiro[k][l] == numJogado && k!= linha && l!= coluna ) {
	       					System.out.println("Linha: "+ k + " coluna: " + l + " ---- conflitam com a celula modificada");
	       					//System.out.println("JA PERTENCE AO QUADRANTE");
	       				}
	       			 
	       			}
	       		}
			}

	@Override
	public void botao(int linha, int coluna, char[][] tabuleiro) {
		char[]elementos = {'1','2','3','4','5','6','7','8','9'}; 
 	   
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
       	
       	
       	int linhaQuadrante = linha - linha %3;
   		int colunaQuadrante = coluna - coluna %3;
   		
   		for(int k= linhaQuadrante; k<linhaQuadrante + 3; k++) { //adicionando os valores do quadrante ao list
   			for(int l= colunaQuadrante; l<colunaQuadrante + 3; l++) {
   				testeQuadrante.add(tabuleiro[k][l]);
   				}
   			}

   		 		
   		test.removeAll(testeLinha);
   		
   		test.removeAll(testeColuna);
   		
    	test.removeAll(testeQuadrante);
    	
    	System.out.println("\nEsses sao os valores disponiveis para a celula:"+ test);
		
	}

	@Override
	public boolean posicoesFixas(char[][] tabuleiro, char[][] posicoes, int linha, int coluna) {
		
		if(tabuleiro[linha][coluna] != posicoes[linha][coluna] || tabuleiro[linha][coluna] == '0' ) { //Pega o tabuleiro incial e armazena as posicoes para comparar com o tabuleiro
																								      //gerado pelas modificações do usuario a fim de saber se aquela celula é a fixa ou nao
			return true;
		}
		
		else {
			return false;
		}
		
		
	}

	@Override
	public boolean jogoCompleto(char[][] tabuleiro) {
		 ArrayList<Character> principal = new ArrayList<>();
         ArrayList<Character> coluna = new ArrayList<>();
         ArrayList<Character> linha = new ArrayList<>();

         if(tabuleiro.length != tabuleiro[0].length) return false;

         for(int i = 0; i < tabuleiro.length; i+=3){
             for(int j = 0; j < tabuleiro.length; j+=3){

                 for(int i1 = i; i1 < 3+i; i1++){
                     for(int j1 = j; j1 < 3+j; j1++){
                         if(principal.contains(tabuleiro[i1][j1]) || principal.contains('0')){
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
                 if(coluna.contains(tabuleiro[i][i1]) || coluna.contains('0') ){
                     return false;
                 }
                 coluna.add(tabuleiro[i][i1]);
             }

             for(int j = 0; j < tabuleiro.length; j++){

                 if(linha.contains(tabuleiro[j][i]) || linha.contains('0')){
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