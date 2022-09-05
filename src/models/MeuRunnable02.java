package models;

public class MeuRunnable02 implements Runnable{

    static int i = -1;

    @Override
   // public synchronized void run() {
    public  void run() {
        Object lock1 = new Object();
        Object lock2 = new Object();
        // Synchronized faz com que cada thread seja executada uma de cada vez;
        /*synchronized (lock1){
            i++;
            String name = Thread.currentThread().getName();
            System.out.println("name lock 1 :  " + name + " : valor:  " + i);
        }

        synchronized (lock2){
            i++;
            String name = Thread.currentThread().getName();
            System.out.println("name lock 2 : " + name + " : valor:  " + i);
        }  */
        i++;
        String name = Thread.currentThread().getName();
        System.out.println("name :  " + name + " : valor:  " + i);

        /*
        *   OUTRO MÉTODO DE SINCRONIZAR
        *
        *  synchronized(this){
        *         i++;
                 String name = Thread.currentThread().getName();
                 System.out.println("name: " + name + " : valor:  " + i);
        *   }
        *
        *    Posso ter vários blocos sincronizados
        * */
    }

}
