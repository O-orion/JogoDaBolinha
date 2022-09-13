package eventos;

import display.DisplayBolinha;

import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

public class MousePressed implements MouseListener {
    DisplayBolinha displayBolinha;

    public MousePressed() {
        this.displayBolinha = new DisplayBolinha();
    }

    @Override
    public void mouseClicked(MouseEvent e) {
        this.displayBolinha.criarNovaBolinha(e.getX(), e.getY(), 10 , 10);
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
