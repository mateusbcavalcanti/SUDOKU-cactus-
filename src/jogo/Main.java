package jogo;

import java.util.Locale;
import java.util.Scanner;

import model.exceptions.ConflitanteException;
import model.exceptions.InvalidCharException;
import tabuleiro.Board;
import tabuleiro.Board16x16;
import tabuleiro.Board9x9;

public class Main {

	public static void main(String[] args) {
	Locale.setDefault(Locale.US);
	Scanner sc = new Scanner(System.in);
	int[][] tabuleiro9x9 = {
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
	int[][] tabuleiro16x16 = {
				{1,5,8,0,12,15,0,14,0,2,11,0,6,0,0,7},
				{6,13,0,0,0,0,0,11,8,0,0,5,14,1,0,11},
				{0,2,0,0,8,0,11,0,1,15,0,13,12,0,0,0},
				{11,0,0,6,0,14,12,0,0,16,13,0,15,8,0,0},
				{8,0,0,0,4,0,6,15,9,1,2,0,0,12,0,3},
				{2,14,13,12,16,0,3,0,0,0,0,0,1,11,11,0},
				{0,15,3,0,0,2,11,0,4,0,0,0,7,0,5,6},
				{0,12,0,11,15,0,0,5,0,6,1,4,0,14,16,0},
				{14,16,11,0,6,0,0,5,11,0,12,0,0,2,0,8},
				{2,7,0,8,11,16,14,0,0,0,0,1,12,0,5,11},
				{12,11,0,0,15,2,11,7,0,0,9,0,13,0,0,3},
				{0,0,13,5,12,0,11,0,4,2,16,0,15,0,7,14},
				{0,15,0,3,0,11,9,0,0,0,11,0,0,16,6,0},
				{16,8,5,0,2,0,1,15,7,6,14,3,0,12,0,0},
				{7,4,0,0,11,12,0,0,0,0,1,13,5,0,0,15},
				{1,0,12,9,16,0,5,13,2,4,11,0,8,3,0,0}
			};
	int linha = 0;
	int coluna = 0;
	int numJogado = 0;
	int matrizPosicoesFixas[][] = new int[9][9];
	char botao;
	boolean auxiliar = false;
	
	

	System.out.println("Escolha o tipo de tabuleiro que deseja jogar:\ntabuleiro 9x9 <x>   tabuleiro 16x16 <y>");
	botao ='y';
	Object board = null;
	int[][] tabuleiroTeste = null;
	int[][] posicoesTeste;
	
	if(botao == 'x') {
		int[][] posicoes = {
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
		
		posicoesTeste = posicoes;
		int tabuleiro[][] = tabuleiro9x9;
		tabuleiroTeste = tabuleiro;
		 board = new Board9x9(linha, coluna, tabuleiro);
		
		
	}
	
	
	else {
		int[][] posicoes = {
				{1,5,8,0,12,15,0,14,0,2,11,0,6,0,0,7},
				{6,13,0,0,0,0,0,11,8,0,0,5,14,1,0,11},
				{0,2,0,0,8,0,11,0,1,15,0,13,12,0,0,0},
				{11,0,0,6,0,14,12,0,0,16,13,0,15,8,0,0},
				{8,0,0,0,4,0,6,15,9,1,2,0,0,12,0,3},
				{2,14,13,12,16,0,3,0,0,0,0,0,1,11,11,0},
				{0,15,3,0,0,2,11,0,4,0,0,0,7,0,5,6},
				{0,12,0,11,15,0,0,5,0,6,1,4,0,14,16,0},
				{14,16,11,0,6,0,0,5,11,0,12,0,0,2,0,8},
				{2,7,0,8,11,16,14,0,0,0,0,1,12,0,5,11},
				{12,11,0,0,15,2,11,7,0,0,9,0,13,0,0,3},
				{0,0,13,5,12,0,11,0,4,2,16,0,15,0,7,14},
				{0,15,0,3,0,11,9,0,0,0,11,0,0,16,6,0},
				{16,8,5,0,2,0,1,15,7,6,14,3,0,12,0,0},
				{7,4,0,0,11,12,0,0,0,0,1,13,5,0,0,15},
				{1,0,12,9,16,0,5,13,2,4,11,0,8,3,0,0}
			};
		
		
		posicoesTeste = posicoes;
		int tabuleiro[][] = tabuleiro16x16;
		tabuleiroTeste = tabuleiro;
		board = new Board16x16(linha, coluna, tabuleiro);
		
	}
	
	
	do {
		try {
        auxiliar = true;
        System.out.println();
        ((Board) board).exibeMatriz(tabuleiroTeste);
        
        
        System.out.println("Insira a linha e a coluna e em seguida o numero da jogada");            
        
        do {
            System.out.print("Linha > ");
            linha = sc.nextInt();
        
            System.out.print("Coluna > ");
            coluna = sc.nextInt();
        
            System.out.print("Número > ");
            numJogado = sc.nextInt();
            
            if(((Board) board).posicoesFixas(tabuleiroTeste, posicoesTeste, linha, coluna))  {
				tabuleiroTeste[linha][coluna] = numJogado;
				((Board) board).conflitantes(tabuleiroTeste, linha, coluna, numJogado);
				auxiliar = false;
				
            } else {
				System.out.println("Esta celula nao pode ser modificada, tente novamente");
            }

        } while (auxiliar);
        
        auxiliar = true; //reuso
        
        System.out.println("\nDeseja saber quais numeros são validos para determinada celula? SIM<s> NAO<n>");
        botao = sc.next().charAt(0);
        
        
         
        if(botao == 's') {
        	do {
        		System.out.print("Linha > ");
				linha = sc.nextInt();
				System.out.print("Coluna > ");
				coluna = sc.nextInt();
        		
				if(! ((Board) board).posicoesFixas(tabuleiroTeste, posicoesTeste, linha, coluna)) {
					System.out.println("Esta celula nao pode ser modificada, teste outra para que o botao funcione");
				}
				
				else {
					((Board) board).botao(linha, coluna, tabuleiroTeste);
					auxiliar = false;
				}
          }while(auxiliar);
        }
        
        auxiliar = true; //reuso

        
        if(((Board) board).jogoCompleto(tabuleiroTeste)) { 
        	auxiliar = false;
        }
        
		}catch(ConflitanteException e) {
        	System.out.println("Atenção!!--> "+e.getMessage());
        		}
		catch(InvalidCharException e) {
    	System.out.println("Atenção!!--> "+e.getMessage());
    		}
		
    } while (auxiliar);
    System.out.println("Voce completou o sudoku, parabens");
	
  

	sc.close();
		}
	}
		
		
		
	
	


