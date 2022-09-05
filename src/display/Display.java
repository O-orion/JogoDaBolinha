package display;

import javax.swing.*;
import java.awt.*;

public class Display {

    private JFrame jframe;
    private Canvas canvas;

    public Display(String title, int width, int height){
        jframe = new JFrame(title);

        jframe.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE); // fechando a janela
        jframe.pack(); // tamanho da janela será o tamanho do componente
        jframe.setLocationRelativeTo(null); // não utiliza nenhuma janela como referência, inicia no meio
        jframe.setVisible(true); // tornando a janela visivel

        jframe.setResizable(false); // não deixar usuário expandi a janela com mouse

        // Criando a tela do jogo
        canvas = new Canvas();
        canvas.setPreferredSize(new Dimension(width, height));
        canvas.setMaximumSize(new Dimension(width, height));
        canvas.setMinimumSize(new Dimension(width, height));

        jframe.add(canvas); // adicionando o canvas a janela jframe










    }
}
