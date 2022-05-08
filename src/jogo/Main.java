package jogo;

import java.util.Locale;
import java.util.Scanner;

import model.exceptions.ConflitanteException;
import model.exceptions.InvalidCharException;
import tabuleiro.Board;
import tabuleiro.BoardHexa;
import tabuleiro.BoardDecim;

public class Main {

	public static void main(String[] args) {
	Locale.setDefault(Locale.US);
	Scanner sc = new Scanner(System.in);
	
	int[][] tabuleiroDeci = new int[9][9];
	int[][] tabuleiroHexa = new int[16][16];
	int linha = 0;
	int coluna = 0;
	int numJogado = 0;
	char botao;
	char dificuldade;
	boolean auxiliar = false;
	Board board = null;
	Board boardFixo = null;
	int celulasZeradas = 0;
	int celula = 0;

	System.out.println("  Escolha o tipo de tabuleiro que deseja jogar:\n  TABULEIRO9X9<x>  TABULEIRO16x16 <y>");
	botao = sc.next().charAt(0);
	System.out.println("  Escolha o nivel de dificuldade do jogo:\n  FACIL<f>     MEDIO<m>     DIFICIL<d>");
	dificuldade = sc.next().charAt(0);
	
	if(botao == 'x') {
		
		board = new BoardDecim(linha,coluna,tabuleiroDeci,celula);
		boardFixo = new BoardDecim(linha, coluna, tabuleiroDeci,celula);

		 if(dificuldade == 'f') {
			 celulasZeradas = 20;
		 }
		 
		 else if(dificuldade == 'm'){
			 celulasZeradas = 40;		 
		 }
		 
		 else if(dificuldade == 'd') {
			 celulasZeradas = 60;
		 }
		 
		 
		 board.setTabuleiro(board.geradorTabuleiro(celulasZeradas));
		 boardFixo.setTabuleiro(board.getTabuleiro());
		 
	}
	
	
	else if(botao == 'y') {
		
		
		board = new BoardHexa(linha, coluna, tabuleiroHexa,celula);
		boardFixo = new BoardHexa(linha, coluna, tabuleiroHexa,celula);
		
		if(dificuldade == 'f') {
			 celulasZeradas = 40;
		 }
		 else if(dificuldade == 'm'){
			 celulasZeradas = 80;
		 }
		 else if(dificuldade == 'd') {
			 celulasZeradas = 160;
		 }
		
		 board.setTabuleiro(board.geradorTabuleiro(celulasZeradas));
		 boardFixo.setTabuleiro(board.getTabuleiro());
		 
		
		
	}

	do {
		try {
        auxiliar = true;
        System.out.println();
        board.exibeMatriz();
        
        
        System.out.println("Insira a linha e a coluna e em seguida o numero da jogada");            
        
        do {
            System.out.print("Linha > ");
            linha = sc.nextInt();
        
            System.out.print("Coluna > ");
            coluna = sc.nextInt();
        
            System.out.print("N�mero > ");
            numJogado = sc.nextInt();
            
            if(board.posicoesFixas(boardFixo.getTabuleiro(), linha, coluna))  {
				
            	board.setCelula(linha,coluna,numJogado);
            	
				board.conflitante(linha, coluna, numJogado);
				
				boardFixo.exibeMatriz();
				
				auxiliar = false;
				
            } else {
				System.out.println("Esta celula nao pode ser modificada, tente novamente");
            }

        } while (auxiliar);
        
        
        auxiliar = true; //reuso
        
        System.out.println("\nDeseja saber quais numeros s�o validos para determinada celula? SIM<s> NAO<n>");
        botao = sc.next().charAt(0);
        
       if(botao == 's') {
        	do {
        		System.out.print("Linha > ");
				linha = sc.nextInt();
				System.out.print("Coluna > ");
				coluna = sc.nextInt();
        		
				if(! board.posicoesFixas(boardFixo.getTabuleiro(), linha, coluna)) {
					System.out.println("Esta celula nao pode ser modificada, teste outra para que o botao funcione");
				}
				
				else {
					board.botao(linha, coluna);
					auxiliar = false;
				}
          }while(auxiliar);
        }
        
        auxiliar = true; //reuso

        
        if(board.jogoCompleto()) { 
        	auxiliar = false;
        }
        
		}catch(ConflitanteException e) {
        	System.out.println("Aten��o!!--> "+e.getMessage());
        		}
		catch(InvalidCharException e) {
    	System.out.println("Aten��o!!--> "+e.getMessage());
    		}
		
    } while (auxiliar);
    System.out.println("Voce completou o sudoku, parabens");
	
  

	sc.close();
		}
	}
		
		
		
	
	


