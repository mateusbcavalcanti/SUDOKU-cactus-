package player;

import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Scanner;

import javax.swing.JOptionPane;



public class Jogador  {

	private String nome;
	private String aux;
	private String tempo;
	private String saida = "";
	private String objetos;
	private String dif;
	private String arquivo= "save.txt";
	int[][] tabuleiro;
	
	Scanner sc = new Scanner(System.in);

	public Jogador(String nome, String tempo, String dif, int[][] tabuleiro) {

		this.nome = nome;
		this.tempo = tempo;
		this.dif = dif;
		this.tabuleiro = tabuleiro;

	}

	public Jogador() {

	}

	public void gravarRanking() {

		nome = sc.nextLine();

		tempo = getTempo();
		if (jogo.AtributosAux.dificuldade == 'd') {
			dif = "Dificil";
		}
		if (jogo.AtributosAux.dificuldade == 'm') {
			dif = "Medio";
		}
		if (jogo.AtributosAux.dificuldade == 'f') {
			dif = "Facil";
		}

		try {
			FileWriter fileW = new FileWriter("jogadores.txt", true);//se não existir arquivo txt, ele cria 
			PrintWriter escritor = new PrintWriter(fileW); //printa o ranking no arquivo txt
			escritor.printf(nome + "\n" + tempo + "\n" + dif + "\n");

			escritor.flush();
			escritor.close();
			fileW.close();

		} catch (IOException e) {

			e.printStackTrace();
		}

	}

	public void printarRanking() {
		Path caminho = Paths.get("jogadores.txt");
		try {
			byte[] texto = Files.readAllBytes(caminho);
			String leitura = new String(texto);
			aux = leitura;

		} catch (Exception erro) {

		}

		String[] palavras = aux.split("\n");
		ArrayList<Jogador> ar = new ArrayList<Jogador>();

		for (int i = 0; i < palavras.length - 1; i++) {

			nome = palavras[i];
			tempo = palavras[i + 1];
			dif = palavras[i + 2];
			ar.add(new Jogador(nome, tempo, dif,tabuleiro));

			i+=2;
			

		}

		Collections.sort(ar, new ComparaTempo());

		if (ar.size() >= 10) { //controla o ranking para exibir apena 10 primeiros
			for (int i = 0; i < 10; i++) {

				objetos = ar.get(i).toString();

				saida += objetos + "\n";

			}
		} else {	//caso tenha menos que dez objetos, trabalha com eles
			for (int i = 0; i < ar.size(); i++) {
				objetos = ar.get(i).toString();

				saida += objetos + "\n";
			}
		}
		JOptionPane.showMessageDialog(null, saida, "Ranking", 3 );
		
	}


	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public String getTempo() {
		return tempo;
	}

	public void setTempo(String tempo) {
		this.tempo = tempo;
	}

	public String getAux() {
		return aux;
	}

	public void setAux(String aux) {
		this.aux = aux;
	}

	public String toString() {
		return "Nome: " + nome + "\n" + "Tempo: " + tempo + "\n" + "Modo: " + dif + "\n";
	}

	public String getArquivo() {
		return arquivo;
	}

	public void setArquivo(String arquivo) {
		this.arquivo = arquivo;
	}

	public String getDif() {
		return dif;
	}

	public int[][] getTabuleiro() {
		return tabuleiro;
	}

	public void setTabuleiro(int[][] tabuleiro) {
		this.tabuleiro = tabuleiro;
	}
	
	
	

}