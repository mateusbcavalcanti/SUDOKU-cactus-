package jogo;

import java.util.Locale;
import java.util.Scanner;

import jogadas.Plays;
import tabuleiro.Board;

public class Main {

	public static void main(String[] args) {
	Locale.setDefault(Locale.US);
	Scanner sc = new Scanner(System.in);
	int tabuleiro[][] = {
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
	int linha = 0;
	int coluna = 0;
	int numJogado = 0;
	int matrizPosicoesFixas[][] = new int[9][9];
	
	Board.exibeMatriz(tabuleiro);
	Board.posicoesFixas(tabuleiro, matrizPosicoesFixas);
	
	System.out.println("Insira o número da linha e da coluna que deseja modificar");
	linha = sc.nextInt();
	coluna = sc.nextInt();
	
	if(tabuleiro[linha][coluna] != 0 ) {
		System.out.println("Esse numero nao pode ser modificado,tente novamente\n");
		
	}
	else {
		System.out.println("Agora insira qual sera o novo numero:");
		numJogado = sc.nextInt();
		if(Board.verificarColuna(tabuleiro, coluna, numJogado)) {
			System.out.println("O numero ja esta na coluna, tente novamente.");
		}
			if(Board.verificarLinha(tabuleiro, linha, numJogado)) {
				System.out.println("O numero ja esta na linha, tente novamente.");
			}
				else {
						tabuleiro[linha][coluna] = numJogado;
					}
		
	}
	
	System.out.println("\nAgora, vamos ver se o numero inserido esta se repetindo dentro do quadrante...\n");
	
	if(Board.verificarQuadrante(tabuleiro, linha, coluna, numJogado)) {
		System.out.println("Esta repetido dentro do quadrante, modifique sua jogada.");
	}
	else {
		System.out.println("Muito bem, este numero eh o unico no quadrante.");
	}
	
		
	System.out.println();
	Board.exibeMatriz(tabuleiro);
	

	
	
	
	sc.close();
	}

}
