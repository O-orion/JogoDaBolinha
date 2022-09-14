package models;

import runnables.RunnableBolinha;

import java.awt.*;
import java.util.Random;

public class Bolinha {
    private int x = 0;
    private int y = 0;
    private int w  = 10;
    private int h = 10;
    private Color cor = Color.LIGHT_GRAY;

    private boolean larguraTela = false;
    private boolean alturaTela = false;

    private Thread threadPosicaoBolinha;
    private RunnableBolinha runnablePosicaoBolinha;

    public Bolinha(){ }

    public Bolinha(int x, int y, int w, int h){
        this.x = x;
        this.y = y;
        this.w = w;
        this.h = h;
        this.cor = novaCor();

    }

    private void iniciarThread(){
        this.runnablePosicaoBolinha = new RunnableBolinha(this);
        this.threadPosicaoBolinha = new Thread(runnablePosicaoBolinha);

    }

    public void posicaoX(int largura, int escala){
        if((x > (largura * escala) - 10)){
            larguraTela = true;
        }

        if(x < 0){
            larguraTela = false;
        }

        if(larguraTela){
            this.x = this.x - 1;
        }else{
            this.x =  this.x + 1;
        }
    }

    public  void posicaoY(int altura, int escala){
        if(y >= (altura * escala) - 10){
            alturaTela = true;
        }

        if(y <= 0){
            alturaTela = false;
        }

        if(alturaTela){
            this.y = this.y - 1;
        }else{
            this.y = this.y + 1;
        }
    }

    public int getX() {
        return x;
    }

    public int getY() {
        return y;
    }

    public Color getColor(){
        return this.cor;
    }

    private Color novaCor() {

        int nCor =  new Random().nextInt(5);

        switch (nCor) {
            case 0:
                return Color.YELLOW;
            case 1:
                return Color.RED;
            case 2:
                return Color.GREEN;
            case 3:
                return Color.BLUE;
            case 4:
                return Color.PINK;
            default:
                return Color.WHITE;
        }

    }

}
