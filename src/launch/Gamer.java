package launch;

import com.sun.tools.jconsole.JConsoleContext;
import display.Display;
import display.Display02;

import java.awt.*;
import java.awt.event.MouseEvent;

public class Gamer {

    private Display02 display;


    public Gamer(){
        this.display = new Display02();
        display.iniciar();
    }

    public void mouseClicked(MouseEvent e){
        System.out.println("Licado");
    }
}
