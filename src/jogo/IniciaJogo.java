package jogo;

import java.util.Scanner;

import model.exceptions.ConflitanteException;
import java.util.InputMismatchException;
import tabuleiro.BoardDecim;
import tabuleiro.BoardHexa;

public class IniciaJogo extends AtributosAux {
	

	public IniciaJogo() {
		
		Scanner sc = new Scanner(System.in);
		do {
			try {
		auxiliar=true;
		System.out.println("  Escolha o tipo de tabuleiro que deseja jogar:\n  TABULEIRO9X9<x>  TABULEIRO16x16 <y>");
		botao = sc.next().charAt(0);
		System.out.println("  Escolha o nivel de dificuldade do jogo:\n  FACIL<f>     MEDIO<m>     DIFICIL<d>");
		dificuldade = sc.next().charAt(0);
		
		if(botao == 'x') {
			
			board = new BoardDecim(linha,coluna,tabuleiroDeci,celula);
			boardFixo = new BoardDecim(linha, coluna, tabuleiroDeci,celula);

			 if(dificuldade == 'f') {
				 celulasZeradas = 20;
				 auxiliar=false;
			 }
			 
			 else if(dificuldade == 'm'){
				 celulasZeradas = 40;
				 auxiliar=false;
			 }
			 
			 else if(dificuldade == 'd') {
				 celulasZeradas = 60;
				 auxiliar=false;
			 }
			 
			 
			 board.setTabuleiro(board.geradorTabuleiro(celulasZeradas));
			 boardFixo.setTabuleiro(boardFixo.igualaMatriz(board.getTabuleiro(),boardFixo.getTabuleiro()));
		}
		
		
		else if(botao == 'y') {
			
			
			board = new BoardHexa(linha, coluna, tabuleiroHexa,celula);
			boardFixo = new BoardHexa(linha, coluna, tabuleiroHexa,celula);
			
			if(dificuldade == 'f') {
				 celulasZeradas = 40;
				 auxiliar=false;
			 }
			 else if(dificuldade == 'm'){
				 celulasZeradas = 80;
				 auxiliar=false;
			 }
			 else if(dificuldade == 'd') {
				 celulasZeradas = 160;
				 auxiliar=false;
			 }
			 
			
			 board.setTabuleiro(board.geradorTabuleiro(celulasZeradas));
			 boardFixo.setTabuleiro(board.igualaMatriz(board.getTabuleiro(), boardFixo.getTabuleiro()));
			 
		}
		if(auxiliar) {
			throw new ConflitanteException ("\n~~DIGITE UMA ENTRADA V�LIDA~~\n");
		}
			}
			catch(ConflitanteException e) {
				System.out.println(e.getMessage());
			}
		
		}while(auxiliar);
			
		do {
		
	        auxiliar = true;
	        System.out.println();
	        board.exibeMatriz();
		
			do {
	        	try {
	        System.out.println("Insira a linha e a coluna e em seguida o numero da jogada");            
	     
	        
	            System.out.print("Linha > ");
	            linha = sc.nextInt();
	        
	            System.out.print("Coluna > ");
	            coluna = sc.nextInt();
	        
	            System.out.print("N�mero > ");
	            numJogado = sc.nextInt();
	        	   
	            if(board.posicoesFixas(boardFixo.getTabuleiro(), linha, coluna))  {
					
	            	board.setCelula(linha,coluna,numJogado);
	            	
					board.conflitante(linha, coluna, numJogado);
					
					auxiliar = false;
					
	            } else {
					System.out.println("\nEsta celula nao pode ser modificada, tente novamente\n");
	            }
	     
        	    }
	        	catch(ArrayIndexOutOfBoundsException e) {
    		System.out.println("\n~~Digite apenas valores dentros dos limites de linha e coluna do tabuleiro~~\n");
	        	}
	        	catch(InputMismatchException e) {
        		System.out.println("\n~~Digite apenas n�meros referentes a linha coluna e valor jogado!!~~\n");
        		sc.next();
	        	}
	        	
	        } while (auxiliar);
	        
	        
	        auxiliar = true; //reuso
	        
	        
	        	
	        System.out.println("\nDeseja saber quais numeros s�o validos para determinada celula? SIM<s> NAO<n>");
	        botao = sc.next().charAt(0);
	       
	       if(botao == 's') {
	        	do {
	        		try {
	        		System.out.print("Linha > ");
					linha = sc.nextInt();
					System.out.print("Coluna > ");
					coluna = sc.nextInt();
	        		
		    
					if(!board.posicoesFixas(boardFixo.getTabuleiro(), linha, coluna)) {
						System.out.println("Esta celula nao pode ser modificada, teste outra para que o botao funcione");
					}
					
					else {
						board.botao(linha, coluna);
						auxiliar = false;
					}
	        }
	        		catch(ArrayIndexOutOfBoundsException e) {
	    	System.out.println("\n Digite apenas Valores dentro do tamanho do tabuleiro \n");
		    }
	        	catch(InputMismatchException e) {
       		System.out.println("\n~~Digite apenas n�meros referentes a linha coluna e valor jogado!!~~\n");
       		sc.next();
	        	}
	        		
	          }while(auxiliar);
	        
	       }else if(botao == 'n') {
	        	auxiliar=true;
	        }
	       
	        
	        	auxiliar = true; //reuso

	        
	        if(board.jogoCompleto()) { 
	        	auxiliar = false;
	        }
	        
			
			
	    } while (auxiliar);
	    System.out.println("Voce completou o sudoku, parabens");
		
	  

		sc.close();
	}
}
