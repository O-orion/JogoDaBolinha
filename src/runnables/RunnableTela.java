package runnables;

import display.Display;

public class RunnableTela implements Runnable{
    public boolean isRunning = true;
    private Display display;

    public RunnableTela(Display display) {
        this.display = display;
    }

    @Override
    public void run() {
        long lasTime = System.nanoTime();
        double amountofTickts = 60.0;
        double ns = 1000000000 / amountofTickts;
        double delta = 0;
        int frames = 0;
        double timer = System.currentTimeMillis();

        while (isRunning){
            long now = System.nanoTime();
            delta+= (now - lasTime ) / ns;
            lasTime =  now;
            if(delta >= 1){
                this.display.render();
                frames ++;
                delta --;
            }

            if(System.currentTimeMillis() - timer >= 1000){
                System.out.println("FPS: " + frames);
                frames = 0;
                timer += 1000;
            }

        }

        // chamando pauser
        try {
            this.display.pausar();
            this.isRunning = false;
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
