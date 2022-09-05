package models;

public class Bolinha {
    private int x = 0;
    private int y = 0;
    private int w  = 10;
    private int h = 10;

    private boolean larguraTela = false;
    private boolean alturaTela = false;

    public Bolinha(int x, int y, int w, int h){
        this.x = x;
        this.y = y;
        this.w = w;
        this.h = h;
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

    public int getW() {
        return w;
    }

    public int getH() {
        return h;
    }

    public void setX(int x) {
        this.x = x;
    }

    public void setY(int y) {
        this.y = y;
    }
}
