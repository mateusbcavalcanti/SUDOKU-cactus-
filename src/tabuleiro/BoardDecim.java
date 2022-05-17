package tabuleiro;

import java.util.ArrayList;
import java.util.Random;

import model.exceptions.ConflitanteException;

public class BoardDecim extends Board {
	
	
	public BoardDecim(int coluna, int linha, int[][] tabuleiro, int celula) {
		super(coluna, linha, tabuleiro, celula);
	
	}


	@Override
	public void exibeMatriz() {		//Imprime tabuleiro 9x9
		for (int i = 0; i < this.tabuleiro.length; i++) {
	           for (int j = 0; j < this.tabuleiro.length; j++) {
	                System.out.print(this.tabuleiro[i][j] + " ");
	                if (j == 2 || j == 5) System.out.print("| ");
	            }
	            System.out.println();
	            if (i == 2 || i == 5)
	                System.out.print("------|-------|------\n");
	        }
	        System.out.println();
		
	}


	@Override
	public void botao(int linha, int coluna) { //mostra quais os valores disponiveis para a celula
		int[]elementos = {1,2,3,4,5,6,7,8,9}; 
 	   
    	ArrayList<Integer> test = new ArrayList<Integer>();
       	ArrayList<Integer> testeColuna = new ArrayList<Integer>();
       	ArrayList<Integer> testeQuadrante = new ArrayList<Integer>();
       	ArrayList<Integer> testeLinha = new ArrayList<Integer>();
       	
       	for(int i=0; i<elementos.length; i++) {//adicionando os valores de 1 a 9 ao list
       		test.add(elementos[i]);
       	}
    
       	
       	for (int i = 0; i < tabuleiro.length; i++) {//adicionando valores da linha ao list
   	           testeLinha.add(this.tabuleiro[linha][i]); 
   	   				}
       
       	
       	for(int j=0; j<tabuleiro.length; j++) {//adicionando valores da coluna ao list
       		testeColuna.add(this.tabuleiro[j][coluna]); 
       	}
       	
       	
       	int linhaQuadrante = linha - linha %3;
   		int colunaQuadrante = coluna - coluna %3;
   		
   		for(int k= linhaQuadrante; k<linhaQuadrante + 3; k++) { //adicionando os valores do quadrante ao list
   			for(int l= colunaQuadrante; l<colunaQuadrante + 3; l++) {
   				testeQuadrante.add(this.tabuleiro[k][l]);
   				}
   			}

   		 		
   		test.removeAll(testeLinha);
   		
   		test.removeAll(testeColuna);
   		
    	test.removeAll(testeQuadrante);
    	
    	System.out.println("\nEsses sao os valores disponiveis para a celula:"+ test);
		
	}

	@Override
	public boolean posicoesFixas(int[][] posicoes, int linha, int coluna) {
		//Pega o tabuleiro incial e armazena as posicoes para comparar com o tabuleiro
		//gerado pelas modifica��es do usuario a fim de saber se aquela celula � a fixa ou nao
		return this.tabuleiro[linha][coluna] != posicoes[linha][coluna] || this.tabuleiro[linha][coluna] == 0;
	}

	@Override
	public boolean jogoCompleto() { //verifica se o tabuleiro est� completo e correto
		 ArrayList<Integer> principal = new ArrayList<>();
         ArrayList<Integer> coluna = new ArrayList<>();
         ArrayList<Integer> linha = new ArrayList<>();

         if(this.tabuleiro.length != this.tabuleiro[0].length) return false;

         for(int i = 0; i < this.tabuleiro.length; i+=3){
             for(int j = 0; j < this.tabuleiro.length; j+=3){

                 for(int i1 = i; i1 < 3+i; i1++){
                     for(int j1 = j; j1 < 3+j; j1++){
                         if(principal.contains(this.tabuleiro[i1][j1]) || principal.contains(0)){
                             return false;
                         }
                         principal.add(this.tabuleiro[i1][j1]);
                     }
                 }
                 principal.clear();
             }

         }

         for(int i = 0; i < this.tabuleiro.length; i++){
             for(int i1 = 0; i1 < this.tabuleiro.length; i1++){
                 if(coluna.contains(this.tabuleiro[i][i1]) || coluna.contains(0) ){
                     return false;
                 }
                 coluna.add(this.tabuleiro[i][i1]);
             }

             for(int j = 0; j < this.tabuleiro.length; j++){

                 if(linha.contains(this.tabuleiro[j][i]) || linha.contains(0)){
                     return false;
                 }
                 linha.add(this.tabuleiro[j][i]);
             }
             linha.clear();
             coluna.clear();
         }

         return true;
	}





	@Override
	public void conflitante(int linha, int coluna, int numJogado) throws ConflitanteException { 
		
		for (int i = 0; i < this.tabuleiro.length; i++) {
	           if(this.tabuleiro[linha][i] == numJogado && i!= coluna) { //verifica a linha e imprime as celulas conflitantes
	        	   System.out.println("Linha:"+ linha + " coluna:" + i + " ---- conflitam com a celula modificada"  );
	   			
	   				}
	          
				}
			
		for (int j = 0; j < this.tabuleiro.length; j++) {
	        	 if(this.tabuleiro[j][coluna] == numJogado && j != linha) { //verifica a coluna e imprime as celulas conflitantes
	        		 System.out.println("Linha:"+ j + " coluna:" + coluna + " ---- conflitam com a celula modificada" );
	   				}
	        	
	        	}
	         
	       					 
				int linhaQuadrante = linha - linha %3;
	       		int colunaQuadrante = coluna - coluna %3;
	       		
	       		for(int k= linhaQuadrante; k<linhaQuadrante + 3; k++) { //verifica o quadrante e imprime as celulas conflitantes
	       			for(int l= colunaQuadrante; l<colunaQuadrante + 3; l++) {
	       				if(this.tabuleiro[k][l] == numJogado && k!= linha && l!= coluna ) {
	       					System.out.println("Linha: "+ k + " coluna: " + l + " ---- conflitam com a celula modificada");     				
	       				}
	       			 
	       			}
	       		}
			}





	@Override
	public int[][] removeCelulas(int celulasZeradas) {// remove celulas, colocando-as para zero de acordo com a dificuldade
		Random random = new Random();
	 	
		  int numRandom = 2;
		  int aux = 0; 
		
		   do {
		   for (int i = 0; i < this.tabuleiro.length; i++) {
			   {
				   numRandom = random.nextInt(9);
				   this.tabuleiro[i][numRandom] = 0;
				  
				}
			   		
		   aux++;
			}
		   
		   }while(aux < celulasZeradas);
		  
		   return this.tabuleiro;
	}


	@Override
	public int[][] geradorTabuleiro(int celulasZeradas) { //gera o tabuleiro aleatorio do sudoku
		  Random random = new Random();
		  int matriz = 3;
		  this.tabuleiro = new int[matriz * matriz][matriz * matriz];//matriz onde ser� armazenado o sudoku
		  int x = random.nextInt(100);//semente aleat�ria para n�o gerar o mesmo sudoku
		  for (int number = 0; number < 1; number++){
			  
		  
	   	  for (int i = 0; i < matriz; i++, x++) {
	       for (int j = 0; j < matriz; j++, x += matriz)
	       {
	           for (int k = 0; k < matriz * matriz; k++, x++)
	           {
	        	   this.tabuleiro[matriz * i + j][k] = (x % (matriz * matriz)) + 1;
	           }
	       	}
	   	  }
	   	}
		  return removeCelulas(celulasZeradas);
	}


	@Override
	public int[][] igualaMatriz(int tabuleiro[][],int[][] posicoes) { //iguala as matrizes para armazenar a matriz original ser a matriz posicoes fixas
		for(int i=0; i< tabuleiro.length; i++) {
			 for(int j = 0; j < tabuleiro.length; j++) {
				 posicoes[i][j] = tabuleiro[i][j];
			 }
		 }
		return posicoes;
	}

	

}

	
	
	
