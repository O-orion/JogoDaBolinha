package eventos;

import display.Display;

import java.awt.*;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;



public class KeyListeners  implements MouseListener {
    
    private Canvas dp;

    public KeyListeners(Display dp){


    }



    @Override
    public void mouseClicked(MouseEvent e) {
        System.out.println("Mouse clicado");
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
