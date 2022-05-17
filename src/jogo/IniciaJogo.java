package jogo;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.InputMismatchException;
import java.util.Scanner;

import javax.swing.JOptionPane;

import model.exceptions.ConflitanteException;
import player.Jogador;
import tabuleiro.BoardDecim;
import tabuleiro.BoardHexa;

public class IniciaJogo extends AtributosAux {
	
	Scanner sc = new Scanner(System.in);
	
	Jogador jogador = new Jogador();
	
	 protected char botao;
	 protected char dificuldade;
	 public static int tempoDecorrido = 0;
	 public static int segundos =0;
	 public static int minutos =0;
	 public static int horas =0;
	 static String segundos_string = String.format("%02d", segundos);
	 static String minutos_string = String.format("%02d", minutos);
	 static String horas_string = String.format("%02d", horas);
	 static String tempoRanking1;

	public IniciaJogo(char bt, char d) {
		
		botao = bt;
		dificuldade = d;
		//jogador.printarRanking();
		setandoTabDif();
		
		long tempoInicial=System.currentTimeMillis();
		
		do {
		
	        auxiliar = true;
	        System.out.println();
	        board.exibeMatriz();
		
			jogada();
	        
	        
	        auxiliar = true; //reuso
	        
	        botaoAjuda();
	        
	        auxiliar = true; //reuso
	        
	        int numeroQualquer = sc.nextInt();	//numero qualquerpara testar o ranking        
	       
	        if(board.jogoCompleto()) { 
	        	auxiliar = false;
	        }
	        
			
	    } while (auxiliar);
		
		long tempoFinal=System.currentTimeMillis();//setando o tempo
	    tempoRanking = (tempoFinal-tempoInicial);//subtraindo o tempo para pegar os segundos certinhos
        JOptionPane.showMessageDialog(null,"~~> VOCÊ GANHOU O SUDOKU CACTUS!! PARABÉNS!!! <~~\n SEU TEMPO FOI : "+ temporizador() );
	    
        //System.out.println("Insira o seu nome");//setando nome
        //nome = sc.nextLine(); 
        
        jogador.gravarRanking();
       
        jogador.printarRanking();
        
     
		sc.close();
	}
	
	//FUNCOES ABAIXO SÃO PARA CONTROLE DO INCIA JOGO
	
	
	public String temporizador() { //Armazena o tempo de execução do jogo e coloca no estilo cronometro
		
		horas = (int) (tempoRanking/3600000);                                                                    
	    minutos = (int) ((tempoRanking/60000) % 60);
	    segundos = (int) ((tempoRanking/1000) % 60);
	    segundos_string = String.format("%02d", segundos);
	    minutos_string = String.format("%02d", minutos);
	    horas_string = String.format("%02d", horas);
	    tempoRanking1 = horas_string+":"+minutos_string+":"+segundos_string;
	    jogador.setTempo(tempoRanking1); 
	    return tempoRanking1;
	    
	    
	}
	
	public void setandoTabDif() { // Pega os dados da interface e fefine a dificuldade do tabuleiro e se eh 9x9 ou 16x16 e zera a quantidade de casas necessária 
		
		auxiliar=true;
		
		if(botao == 'x') {//tabuleiro 9x9
			
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
		
		
		else if(botao == 'y') {//tabuleiro16x16
			
			
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
		
}
	
	public void jogada() { //Faz o jogo acontecer definindo as jogadas do usuario
		do {
        	try {
        System.out.println("Insira a linha e a coluna e em seguida o numero da jogada");            
     
        
            System.out.print("Linha > ");
            linha = sc.nextInt();
        
            System.out.print("Coluna > ");
            coluna = sc.nextInt();
        
            System.out.print("Número > ");
            numJogado = sc.nextInt();
        	   
            if(board.posicoesFixas(boardFixo.getTabuleiro(), linha, coluna))  {
				
            	board.setCelula(linha,coluna,numJogado);
            	
				board.conflitante(linha, coluna, numJogado);
				
				auxiliar = false;
				
            } else {
            	JOptionPane.showMessageDialog(null,"~~Esta celula nao pode ser modificada, teste outra para que o botao funcione.~~","Alerta!!", 2);
            }
     
    	    }
        	catch(ArrayIndexOutOfBoundsException e) {
		
        		JOptionPane.showMessageDialog(null,"~~Digite apenas valores dentros dos limites de linha e coluna do tabuleiro~~","Alerta!", 2);
        	}
        	catch(InputMismatchException e) {
    		
    		JOptionPane.showMessageDialog(null,"~~Digite apenas números referentes a linha coluna e valor jogado!!~~","Alerta!", 2);
    		sc.next();
        	}
        	
        } while (auxiliar);
	}
	
	
	
	public void botaoAjuda() {//mostra os numero disponiveis para cada celula
		do {
        	try {
        System.out.println("\nDeseja saber quais numeros são validos para determinada celula? SIM<s> NAO<n>");
        botao = sc.next().charAt(0);
   	
       if(botao == 's') {
        	do {
        		 try {
        		System.out.print("Linha > ");
				linha = sc.nextInt();
				System.out.print("Coluna > ");
				coluna = sc.nextInt();
        		
	    
				if(!board.posicoesFixas(boardFixo.getTabuleiro(), linha, coluna)) {
					JOptionPane.showMessageDialog(null,"Esta celula nao pode ser modificada, teste outra para que o botao funcione","Alerta!!", 2);
				}
				
				else {
					limpartela();
					board.botao(linha, coluna);
					auxiliar = false;
				}
        		 }catch(ArrayIndexOutOfBoundsException e) {
      	    	
      	    	JOptionPane.showMessageDialog(null,e.getMessage(),"Alerta!", 2);
      	        	}
				
        
        		
          }while(auxiliar);
        
        	
       }else if(botao == 'n') {
    	   limpartela();
    	   auxiliar=false;
        }
       if(auxiliar){
    	   throw new ConflitanteException("\n~~Digite apenas números referentes a linha coluna e valor jogado!!~~\n");
    	   }
       
        	}catch(ConflitanteException e) {
        		
        		JOptionPane.showMessageDialog(null,e.getMessage(),"Alerta!", 2);
        	}
        
        }while(auxiliar);
	}
	
	public void limpartela(){// pula linhas para dar uma limpada no console
		 for (int i = 0; i < 20; ++i)  
		 System.out.println();  
		}
}
