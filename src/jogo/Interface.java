package jogo;

import javax.swing.*;
import java.awt.*;

public class Interface extends JFrame {
    
    public static char dificuldade; 
    public static char bt;
    public static boolean smaluco;

    JFrame frame = new JFrame();
    JPanel panel = new JPanel();
    JLabel label = new JLabel();
    JButton nove;
    JButton dezesseis;
    JButton facil;
    JButton medio;
    JButton dificil;
    JButton maluco;

    public void configs(){ //parte da interface que define o tipo de tabuleiro
        

        frame.setSize(615, 740);
        frame.setDefaultCloseOperation(EXIT_ON_CLOSE);
        frame.setLayout(null);
        frame.setVisible(true);
        frame.setResizable(false);
      
        
        panel.setSize(615, 740);
        panel.setLayout(null);
        panel.setLocation(0,0);
        frame.add(panel);

       
       label.setBounds(0,0,600,700);
       label.setLocation(0, 0);
       panel.add(label);
       label.setIcon(new ImageIcon(getClass().getResource("imagens/titulo.jpg")));
       
       nove = new JButton("");
       nove.setBounds(133,535,109,45);
       panel.add(nove);
       nove.addActionListener((java.awt.event.ActionEvent evt) -> {
        bt = 'x';
        dificuldade();
    });
     nove.setIcon(new ImageIcon(getClass().getResource("imagens/b9x9.jpg")));
       
      dezesseis = new JButton("");
       dezesseis.setBounds(354,535,109,45);
       panel.add(dezesseis);
       dezesseis.addActionListener((java.awt.event.ActionEvent evt) -> {
        bt = 'y';
        dificuldade();
    });
       dezesseis.setIcon(new ImageIcon(getClass().getResource("imagens/16x16.jpg")));

       maluco = new JButton("");
       maluco.setBounds(245,612,109,45);
       panel.add(maluco);
       maluco.addActionListener((java.awt.event.ActionEvent evt) -> {
        if (smaluco == true) {
            smaluco = false;
            System.out.println("Maluco: Falso");
        } else {
            smaluco = true;
            System.out.println("Maluco: Verdadeiro");
        }
    });
       maluco.setIcon(new ImageIcon(getClass().getResource("imagens/maluco.jpg")));
    }

    public void dificuldade(){ //de acordo com a dificuldade escolhida no painel, joga o tabuleiro no console com as celulas zeradas
       label.setIcon(new ImageIcon(getClass().getResource("imagens/dificuldade.jpg")));
       nove.setVisible(false);
       dezesseis.setVisible(false);
       maluco.setVisible(false);

       facil = new JButton("");
       facil.setBounds(70,535,109,45);
       panel.add(facil);
       facil.addActionListener((java.awt.event.ActionEvent evt) -> {
        System.out.println("Facil");
        dificuldade = 'f';
        frame.dispose();
        IniciaJogo jogo = new IniciaJogo(bt, dificuldade, smaluco);
    });
       facil.setIcon(new ImageIcon(getClass().getResource("imagens/facil.jpg")));

       medio = new JButton("");
       medio.setBounds(245,535,109,45);
       panel.add(medio);
       medio.addActionListener((java.awt.event.ActionEvent evt) -> {
        System.out.println("Medio");
        dificuldade = 'm';
        frame.dispose();
        IniciaJogo jogo = new IniciaJogo(bt, dificuldade,smaluco);
    });
       medio.setIcon(new ImageIcon(getClass().getResource("imagens/medio.jpg")));

       dificil = new JButton("");
       dificil.setBounds(419,535,109,45);
       panel.add(dificil);
       dificil.addActionListener((java.awt.event.ActionEvent evt) -> {
        System.out.println("Dificil");
        dificuldade = 'd';
        frame.dispose();
        IniciaJogo jogo = new IniciaJogo(bt, dificuldade, smaluco);
    });
       dificil.setIcon(new ImageIcon(getClass().getResource("imagens/dificil.jpg")));

       
    }
}

