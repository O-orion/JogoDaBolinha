package runnables;

import display.DisplayBolinha;

public class RunnableCriaBolinha implements Runnable{

    private int posicaoInicialX;
    private int posicaoInicialY;


    public RunnableCriaBolinha(int posicaoInicialX, int posicaoInicialY) {
        this.posicaoInicialX = posicaoInicialX;
        this.posicaoInicialY = posicaoInicialY;
    }

    @Override
    public void run() {
        DisplayBolinha.criarNovaBolinha(posicaoInicialX, posicaoInicialY,10,10);
    }
}
