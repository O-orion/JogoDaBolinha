package display;

import eventos.MousePressed;
import models.Bolinha;
import runnables.RunnableTela;

import javax.swing.*;
import java.awt.*;

import java.awt.event.MouseEvent;
import java.awt.image.BufferStrategy;

import java.util.ArrayList;
import java.util.List;

public class Display  {

    // Configuração das libs
    private JFrame frame;
    private Canvas canvas;

    private RunnableTela runTela;

    // Variaveis de conf da thread
    public boolean isRunning = true;
    public Thread thread;

    // Variaveis de conf da tela
    public  static int largura = 240;
    public static  int altura = 160;
    public static  int escala = 3;

    // Váriavel da bolinha
    private int x = 0;
    private int y = 0;

    private List<Bolinha> listaDeBolinhas =  new ArrayList<Bolinha>();

    // Variaveis dos gráficos
    Graphics graphics;

    public Display(){
        this.frame = new JFrame("Jogo da Bolinha"); // adicionando Frame
        this.canvas = new Canvas();
        this.canvas.addMouseListener(new MousePressed());
        this.canvas.setPreferredSize(new Dimension(largura * escala, altura * escala));

        this.runTela = new RunnableTela(this);

        initFrame();
    }

    // Criando a interface
    public void initFrame(){
        this.frame.add(this.canvas);
        this.frame.pack();

        this.frame.setResizable(false);

        this.frame.setLocationRelativeTo(null);
        this.frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE); // clico em fecha e fechou
        this.frame.setVisible(true);

        listaDeBolinhas.add(new Bolinha(x, y, 10, 10));

    }

    public synchronized  void iniciar() {

        thread = new Thread(runTela); // criando a thread
        isRunning = true; // inicinado programa
        thread.start(); // iniciando a thread

    }

    public synchronized  void pausar () throws InterruptedException {
        isRunning = false;
        thread.join();
    }

    public void render (){

        this.listaDeBolinhas = new DisplayBolinha().bolinhasNaTela();

        BufferStrategy bs =  this.canvas.getBufferStrategy();

        if(bs == null){
            this.canvas.createBufferStrategy(3);
            return;
        }

        canvas.requestFocus();

        graphics = bs.getDrawGraphics();

        graphics.fillRect(0,0,largura * escala, altura *escala);
        graphics.setColor(Color.cyan);

        for (Bolinha bolinha : listaDeBolinhas) {

            bolinha.posicaoX(largura, escala);
            bolinha.posicaoY(altura, escala);
            graphics.fillOval(bolinha.getX(), bolinha.getY(), 10, 10);
        }


        bs.show();
    }

    /* Capturando o click do Mouse
    @Override
    public void mouseClicked(MouseEvent e) {

        System.out.println(graphics == null ? "Sim" : "Não");
        System.out.println("Clicado: X = " + e.getX() + " Y: " + e.getY());
        listaDeBolinhas.add(new Bolinha(e.getX(), e.getY(), 10 , 10));
    } */

}
