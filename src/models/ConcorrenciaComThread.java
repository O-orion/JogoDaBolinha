package models;

public class ConcorrenciaComThread {
    static int i = -1;

    public static void main(String[] args) {

        // Chamando meu runnable
        MeuRunnable02 r2 = new MeuRunnable02();

        // Criando as Threads
        Thread t0 = new Thread(r2);
        Thread t1 = new Thread(r2);
        Thread t2 = new Thread(r2);
        Thread t3 = new Thread(r2);
        Thread t4 = new Thread(r2);

        // Executando as threads
        t0.start();
        t1.start();
        t2.start();
        t3.start();
        t4.start();
    }

}
