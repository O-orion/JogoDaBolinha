package models;
/* Interface runnable */
public class MeuRunnable implements Runnable {

    @Override
    public void run() {
        String name = Thread.currentThread().getName();
        System.out.println(" JESUS ME AMA !! ");
        System.out.println("Nome da Thread: " + name);
    }
}
