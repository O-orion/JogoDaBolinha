package eventos;

import display.DisplayBolinha;
import runnables.RunnableCriaBolinha;

import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

public class MousePressed implements MouseListener {

    private RunnableCriaBolinha runnableCriaBolinha;
    private Thread threadCriarBolinha;

    @Override
    public void mouseClicked(MouseEvent e) {
        runnableCriaBolinha = new RunnableCriaBolinha(e.getX(), e.getY());
        threadCriarBolinha = new Thread(runnableCriaBolinha);
        threadCriarBolinha.start();
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
