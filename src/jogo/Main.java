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
	char tabuleiro16x16[][] = {
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
	
	
	Board9x9 board9 = new Board9x9(coluna, linha, tabuleiro9x9);
	
	board9.exibeMatriz(tabuleiro9x9);
	
	System.out.println("Insira o número da linha e da coluna que deseja modificar");
	linha = sc.nextInt();
	coluna = sc.nextInt();
	
	if(tabuleiro9x9[linha][coluna] != '0' ) {
		System.out.println("Esse numero nao pode ser modificado,tente novamente\n");
		
	}
	else {
		System.out.println("Agora insira qual sera o novo numero:");
		numJogado = sc.next().charAt(0);
		tabuleiro9x9[linha][coluna]=numJogado;
	}
	
	
	
	System.out.println();
	board9.exibeMatriz(tabuleiro9x9);
	
	board9.conflitantes(tabuleiro9x9, linha, coluna, numJogado);
	
	
	/*
	
	Board16x16 board16 = new Board16x16(coluna, linha, tabuleiro16x16);
	
	board16.exibeMatriz(tabuleiro16x16);
	
	System.out.println("Insira o número da linha e da coluna que deseja modificar");
	linha = sc.nextInt();
	coluna = sc.nextInt();
	
	if(tabuleiro16x16[linha][coluna] != '0' ) {
		System.out.println("Esse numero nao pode ser modificado,tente novamente\n");
		
	}
	else {
		System.out.println("Agora insira qual sera o novo numero:");
		numJogado = sc.next().charAt(0);
		tabuleiro16x16[linha][coluna]=numJogado;
	}
	
	System.out.println();
	board16.exibeMatriz(tabuleiro16x16);
	
	board16.conflitantes(tabuleiro16x16, linha, coluna, numJogado);*/
	sc.close();
	}

}
