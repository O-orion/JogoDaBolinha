package display;

import eventos.MousePressed;
import models.Bolinha;
import runnables.RunnableTela;

import javax.swing.*;
import java.awt.*;

import java.awt.image.BufferStrategy;

import java.util.ArrayList;
import java.util.List;

public class Display  {

    // Configuração das libs
    private JFrame frame;
    private Canvas canvas;
    private DisplayBolinha displayBolinha;

    private RunnableTela runTela;

    // Variaveis de conf da thread
    static public boolean isRunning = true;
    public Thread thread;

    // Variaveis de conf da tela
    public  static int largura = 240;
    public static  int altura = 160;
    public static  int escala = 3;

    private List<Bolinha> listaDeBolinhas =  new ArrayList<Bolinha>();

    // Variaveis dos gráficos
    static Graphics graphics;

    public Display(){

        this.frame = new JFrame("Jogo da Bolinha"); // adicionando Frame
        this.canvas = new Canvas();

        this.displayBolinha = new DisplayBolinha();
        displayBolinha.criarNovaBolinha(10,10,10,10);

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

        this.listaDeBolinhas = displayBolinha.bolinhasNaTela();

        BufferStrategy bs =  this.canvas.getBufferStrategy();

        if(bs == null){
            this.canvas.createBufferStrategy(3);
            return;
        }

        canvas.requestFocus();

        graphics = bs.getDrawGraphics();

        graphics.fillRect(0,0,largura * escala, altura *escala);

        graphics.setColor(Color.WHITE);
        graphics.setFont(new Font("Arial", Font.BOLD, 20));
        graphics.drawString(" Alunos: Victor Duarte, Alessandro Barbosa, Lucas Viana, Antônio José ",10,30 );

        for (Bolinha bolinha : listaDeBolinhas) {

            graphics.setColor(bolinha.getColor());
            graphics.fillOval(bolinha.getX(), bolinha.getY(), 10, 10);
            bolinha.posicaoX(Display.largura, Display.escala);
            bolinha.posicaoY(Display.altura, Display.escala);

        }

        bs.show();
    }
}
