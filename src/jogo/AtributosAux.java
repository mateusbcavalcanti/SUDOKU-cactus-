package jogo;

import tabuleiro.Board;

public abstract class AtributosAux {

	protected int[][] tabuleiroDeci = new int[9][9];
	protected int[][] tabuleiroHexa = new int[16][16];
	protected int linha = 0;
	protected int coluna = 0;
	protected int numJogado = 0;
	protected char botao;
	public static char dificuldade;
	protected boolean auxiliar = false;
	protected Board board = null;
	protected Board boardFixo = null;
	protected int celulasZeradas = 0;
	protected int celula = 0;
	protected long tempoRanking;
	protected String nome;
}
