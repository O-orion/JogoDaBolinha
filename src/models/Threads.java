package models;
/*  Thread e runnable */
public class Threads {

    public static void main(String[] args) {
        
        Thread t = Thread.currentThread(); // Capturando o  nome da thread em execução
        System.out.println(t.getName()); // Nome da thread em execução, thread principal do java se chama main

        // Criando uma nova Thread
        Thread t1 = new Thread(new MeuRunnable()); // Criei um objeto que representa uma nova thread
        ///t1.run(); // executando a thread, que vai chama método run do runnable, passado ali no parâmetro
        t1.start(); // Instruindo a jvm, chama o método run do runnable, quando ela quiser ou puder


        // Runnable como lambda
        Thread t2 = new Thread( () -> System.out.println("Olá"));

        t2.start();
    }
}
