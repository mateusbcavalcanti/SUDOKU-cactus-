package jogo;

import java.util.Locale;
import java.util.Scanner;

import tabuleiro.Board16x16;
import tabuleiro.Board9x9;

public class Main {

	public static void main(String[] args) {
	Locale.setDefault(Locale.US);
	Scanner sc = new Scanner(System.in);
	char[][] tabuleiro9x9 = {
			{'0','8','0','5','7','6','2','0','0'},
			{'0','0','0','4','0','2','0','0','0'},
			{'0','0','0','0','3','9','5','4','8'},
			{'6','3','0','9','0','0','8','5','2'},
			{'0','9','0','2','0','0','3','7','0'},
			{'8','0','0','0','5','0','6','9','4'},
			{'2','5','7','6','0','3','4','8','9'},
			{'3','0','8','7','0','0','0','2','5'},
			{'0','4','0','0','0','0','0','0','6'}
			}; 
	char[][] tabuleiro16x16 = {
			{'1','5','8','0','c','f','0','e','0','2','b','0','6','0','0','7'},
			{'6','d','0','0','0','0','0','b','8','0','0','5','e','1','0','a'},
			{'0','2','0','0','8','0','a','0','1','f','0','d','c','0','0','0'},
			{'b','0','0','6','0','e','c','0','0','g','d','0','f','8','0','0'},
			{'8','0','0','0','4','0','6','f','9','1','2','0','0','c','0','3'},
			{'2','e','d','c','g','0','3','0','0','0','0','0','1','b','a','0'},
			{'0','f','3','0','0','2','b','0','4','0','0','0','7','0','5','6'},
			{'0','c','0','b','f','0','0','5','0','6','1','4','0','e','g','0'},
			{'e','g','a','0','6','0','0','5','b','0','c','0','0','2','0','8'},
			{'2','7','0','8','b','g','e','0','0','0','0','1','c','0','5','b'},
			{'c','b','0','0','f','2','a','7','0','0','9','0','d','0','0','3'},
			{'0','0','d','5','c','0','b','0','4','2','g','0','f','0','7','e'},
			{'0','f','0','3','0','b','9','0','0','0','a','0','0','g','6','0'},
			{'g','8','5','0','2','0','1','f','7','6','e','3','0','c','0','0'},
			{'7','4','0','0','a','c','0','0','0','0','1','d','5','0','0','f'},
			{'1','0','c','9','g','0','5','d','2','4','b','0','8','3','0','0'}
		}; 
	int linha = 0;
	int coluna = 0;
	char numJogado = 0;
	int matrizPosicoesFixas[][] = new int[9][9];
	char botao;
	boolean auxiliar;
	
	
	System.out.println("Escolha o tipo de tabuleiro que deseja jogar:\ntabuleiro 9x9 <x>   tabuleiro 16x16 <y>");
	botao = sc.next().charAt(0);
	
	if(botao == 'x') {
		char[][] posicoes = {
			{'0','8','0','5','7','6','2','0','0'},
			{'0','0','0','4','0','2','0','0','0'},
			{'0','0','0','0','3','9','5','4','8'},
			{'6','3','0','9','0','0','8','5','2'},
			{'0','9','0','2','0','0','3','7','0'},
			{'8','0','0','0','5','0','6','9','4'},
			{'2','5','7','6','0','3','4','8','9'},
			{'3','0','8','7','0','0','0','2','5'},
			{'0','4','0','0','0','0','0','0','6'}
			};
		
		char tabuleiro[][] = tabuleiro9x9;
		Board9x9 board = new Board9x9(linha, coluna, tabuleiro9x9);
		
		do {
            auxiliar = true;
            System.out.println();
            board.exibeMatriz(tabuleiro);
            
            
            System.out.println("Insira a linha e a coluna e em seguida o numero da jogada");            
            
            do {
                System.out.print("Linha > ");
                linha = sc.nextInt();
            
                System.out.print("Coluna > ");
                coluna = sc.nextInt();
            
                System.out.print("Número > ");
                numJogado = sc.next().charAt(0);
                
                if(board.posicoesFixas(tabuleiro, posicoes, linha, coluna))  {
    				tabuleiro[linha][coluna] = numJogado;
    				board.conflitantes(tabuleiro, linha, coluna, numJogado);
    				auxiliar = false;
    				
                } else {
    				System.out.println("Esta celula nao pode ser modificada, tente novamente");
                }
   
            } while (auxiliar);
            
            auxiliar = true; //alterando para ser usado novamente
            
            System.out.println("\nDeseja saber quais numeros são validos para determinada celula? SIM<s> NAO<n>");
            botao = sc.next().charAt(0);
            
            
             
            if(botao == 's') {
            	do {
            		System.out.print("Linha > ");
    				linha = sc.nextInt();
    				System.out.print("Coluna > ");
    				coluna = sc.nextInt();
            		
    				if(! board.posicoesFixas(tabuleiro, posicoes, linha, coluna)) {
    					System.out.println("Esta celula nao pode ser modificada, teste outra para que o botao funcione");
    				}
    				
    				else {
    					board.botao(linha, coluna, tabuleiro);
    					auxiliar = false;
    				}
              }while(auxiliar);
            }
            
            auxiliar = true; //alterando para ser usado novamente

            
            if(board.jogoCompleto(tabuleiro)) { 
            	auxiliar = false;
            }
           
        } while (auxiliar);
        System.out.println("Voce completou o sudoku, parabens");
		
	}
	
	
	else {
		char[][] posicoes = {
				{'1','5','8','0','c','f','0','e','0','2','b','0','6','0','0','7'},
				{'6','d','0','0','0','0','0','b','8','0','0','5','e','1','0','a'},
				{'0','2','0','0','8','0','a','0','1','f','0','d','c','0','0','0'},
				{'b','0','0','6','0','e','c','0','0','g','d','0','f','8','0','0'},
				{'8','0','0','0','4','0','6','f','9','1','2','0','0','c','0','3'},
				{'2','e','d','c','g','0','3','0','0','0','0','0','1','b','a','0'},
				{'0','f','3','0','0','2','b','0','4','0','0','0','7','0','5','6'},
				{'0','c','0','b','f','0','0','5','0','6','1','4','0','e','g','0'},
				{'e','g','a','0','6','0','0','5','b','0','c','0','0','2','0','8'},
				{'2','7','0','8','b','g','e','0','0','0','0','1','c','0','5','b'},
				{'c','b','0','0','f','2','a','7','0','0','9','0','d','0','0','3'},
				{'0','0','d','5','c','0','b','0','4','2','g','0','f','0','7','e'},
				{'0','f','0','3','0','b','9','0','0','0','a','0','0','g','6','0'},
				{'g','8','5','0','2','0','1','f','7','6','e','3','0','c','0','0'},
				{'7','4','0','0','a','c','0','0','0','0','1','d','5','0','0','f'},
				{'1','0','c','9','g','0','5','d','2','4','b','0','8','3','0','0'}
			};
		
		Board16x16 board = new Board16x16(linha, coluna, tabuleiro16x16);
		char tabuleiro[][] = tabuleiro16x16;
		
		do {
            auxiliar = true;
            System.out.println();
            board.exibeMatriz(tabuleiro);
            
            
            System.out.println("Insira a linha e a coluna e em seguida o numero da jogada");            
            
            do {
                System.out.print("Linha > ");
                linha = sc.nextInt();
            
                System.out.print("Coluna > ");
                coluna = sc.nextInt();
            
                System.out.print("Número > ");
                numJogado = sc.next().charAt(0);
                
                if(board.posicoesFixas(tabuleiro, posicoes, linha, coluna))  {
    				tabuleiro[linha][coluna] = numJogado;
    				board.conflitantes(tabuleiro, linha, coluna, numJogado);
    				auxiliar = false;
    				
                } else {
    				System.out.println("Esta celula nao pode ser modificada, tente novamente");
                }
   
            } while (auxiliar);
            
            auxiliar = true; //alterando para ser usado novamente
            
            System.out.println("\nDeseja saber quais numeros são validos para determinada celula? SIM<s> NAO<n>");
            botao = sc.next().charAt(0);
            
            
             
            if(botao == 's') {
            	do {
            		System.out.print("Linha > ");
    				linha = sc.nextInt();
    				System.out.print("Coluna > ");
    				coluna = sc.nextInt();
            		
    				if(! board.posicoesFixas(tabuleiro, posicoes, linha, coluna)) {
    					System.out.println("Esta celula nao pode ser modificada, teste outra para que o botao funcione");
    				}
    				
    				else {
    					board.botao(linha, coluna, tabuleiro);
    					auxiliar = false;
    				}
              }while(auxiliar);
            }
            
            auxiliar = true; //alterando para ser usado novamente

            
            if(board.jogoCompleto(tabuleiro)) { 
            	auxiliar = false;
            }
           
        } while (auxiliar);
        System.out.println("Voce completou o sudoku, parabens");
	}
	
	
	
  

	sc.close();
		}
	}
		
		
		
	
	


