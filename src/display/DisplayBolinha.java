package display;

import models.Bolinha;

import java.util.ArrayList;
import java.util.List;

public class DisplayBolinha {

    static private List<Bolinha> listaDeBolinhas = new ArrayList<>();

    public DisplayBolinha() { }

    static public void criarNovaBolinha(int x, int y, int h, int w){
        listaDeBolinhas.add(new Bolinha(x,y,w,h));
    }

    public List<Bolinha> bolinhasNaTela(){
        List<Bolinha> listaBolinhasCopy = listaDeBolinhas;
        return listaBolinhasCopy;
    }

    synchronized public void atualizarBolinhas(){


        for (Bolinha bolinha : listaDeBolinhas){
            bolinha.posicaoX(Display.largura, Display.escala);
            bolinha.posicaoY(Display.altura, Display.escala);

        }
    }


}
