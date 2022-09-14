package runnables;

import display.Display;
import display.DisplayBolinha;
import models.Bolinha;

public class RunnableBolinha implements  Runnable{
    private final Bolinha bolinha;

    public RunnableBolinha(Bolinha bolinha) {
        this.bolinha = bolinha;
    }

    @Override
    public void run() {
        while (Display.isRunning){
            bolinha.posicaoX(Display.largura, Display.escala);
            bolinha.posicaoY(Display.altura, Display.escala);
        }

    }

}
