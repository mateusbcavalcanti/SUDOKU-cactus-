package jogo;

import java.util.Locale;
import java.util.Scanner;

import tabuleiro.Board9x9;

public class Main {

	public static void main(String[] args) {
	Locale.setDefault(Locale.US);
	Scanner sc = new Scanner(System.in);
	int tabuleiro9x9[][] = {
			{0,8,0,5,7,6,2,0,0},
			{0,0,0,4,0,2,0,0,0},
			{0,0,0,0,3,9,5,4,8},
			{6,3,0,9,0,0,8,5,2},
			{0,9,0,2,0,0,3,7,0},
			{8,0,0,0,5,0,6,9,4},
			{2,5,7,6,0,3,4,8,9},
			{3,0,8,7,0,0,0,2,5},
			{0,4,0,0,0,0,0,0,6}
			}; 
	char tabuleiro16x16[][] = null; 
	int linha = 0;
	int coluna = 0;
	int numJogado = 0;
	int matrizPosicoesFixas[][] = new int[9][9];
	
	
	Board9x9 board9 = new Board9x9(coluna, linha, tabuleiro9x9, tabuleiro16x16);
	
	board9.exibeMatriz(tabuleiro9x9);
	
	System.out.println("Insira o número da linha e da coluna que deseja modificar");
	linha = sc.nextInt();
	coluna = sc.nextInt();
	
	if(tabuleiro9x9[linha][coluna] != 0 ) {
		System.out.println("Esse numero nao pode ser modificado,tente novamente\n");
		
	}
	else {
		System.out.println("Agora insira qual sera o novo numero:");
		numJogado = sc.nextInt();
		tabuleiro9x9[linha][coluna]=numJogado;
	}
	
	
	
	System.out.println();
	board9.exibeMatriz(tabuleiro9x9);
	
	board9.conflitantes(tabuleiro9x9, linha, coluna, numJogado);
	
	
	
	sc.close();
	}

}
