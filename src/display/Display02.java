package display;

import eventos.KeyListeners;
import models.Bolinha;

import javax.swing.*;
import java.awt.*;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.image.BufferStrategy;
import java.awt.image.BufferedImage;
import java.util.ArrayList;
import java.util.List;

public class Display02  extends Canvas implements Runnable, MouseListener {

    // Configuração das libs
    public static JFrame frame;

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
    private boolean passouLargura = false;
    private boolean passouAltura = false;

    private List<Bolinha> listaDeBolinhas =  new ArrayList<Bolinha>();

    // Variaveis dos gráficos
    Graphics graphics;

    // Variaveis de config do stilo do jogo
    public  static BufferedImage image;

    public Display02(){
        addMouseListener(this);

        this.setPreferredSize(new Dimension(largura * escala, altura * escala));

        image = new BufferedImage(largura*escala, altura*escala, BufferedImage.TYPE_INT_RGB);

        initFrame();

    }

    // Criando a interface
    public void initFrame(){

        frame = new JFrame("Jogo da Bolinha"); // adicionando Frame

        frame.add(this);
        frame.pack();
        frame.setResizable(false);

        frame.setLocationRelativeTo(null);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE); // clico em fecha e fechou
        frame.setVisible(true);

        listaDeBolinhas.add(new Bolinha(x, y, 10, 10));

    }

    public synchronized  void iniciar() {

        thread = new Thread(this); // criando a thread
        isRunning = true; // inicinado programa
        thread.start(); // iniciando a thread

    }

    public synchronized  void pausar () throws InterruptedException {
        isRunning = false;
        thread.join();
    }

    public void tick(){

    }

    public void render (){

        BufferStrategy bs =  this.getBufferStrategy();

        if(bs == null){
            this.createBufferStrategy(3);
            return;
        }

        requestFocus();

        graphics = bs.getDrawGraphics();

        graphics.setColor(new Color(0,0,0,255));
        graphics.fillRect(0,0,largura * escala, altura *escala);

        graphics.setColor(Color.WHITE);
        graphics.setFont(new Font("Arial", Font.BOLD, 26));
        graphics.drawString("Ola", 50 , 50);

        graphics.setColor(Color.cyan);

        for (Bolinha bolinha : listaDeBolinhas) {

            bolinha.posicaoX(largura, escala);
            bolinha.posicaoY(altura, escala);
            graphics.fillOval(bolinha.getX(), bolinha.getY(), 10, 10);
        }

        bs.show();
    }


    @Override
    public void run() {
        long lasTime = System.nanoTime();
        double amountofTickts = 60.0;
        double ns = 1000000000 / amountofTickts;
        double delta = 0;
        int frames = 0;
        double timer = System.currentTimeMillis();

        while (isRunning){
            long now = System.nanoTime();
            delta+= (now - lasTime ) / ns;
            lasTime =  now;
            if(delta >= 1){
                tick();
                render();
                frames ++;
                delta --;
            }

            if(System.currentTimeMillis() - timer >= 1000){
                System.out.println("FPS: " + frames);
                frames = 0;
                timer += 1000;
            }



        }

        // chamando pauser
        try {
            pausar();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    // Capturando o click do Mouse
    @Override
    public void mouseClicked(MouseEvent e) {

        System.out.println(graphics == null ? "Sim" : "Não");
        System.out.println("Clicado: X = " + e.getX() + " Y: " + e.getY());
        listaDeBolinhas.add(new Bolinha(e.getX(), e.getY(), 10 , 10));
    }

    @Override
    public void mousePressed(MouseEvent e) {

    }

    @Override
    public void mouseReleased(MouseEvent e) {

    }

    @Override
    public void mouseEntered(MouseEvent e) {

    }

    @Override
    public void mouseExited(MouseEvent e) {

    }

}
