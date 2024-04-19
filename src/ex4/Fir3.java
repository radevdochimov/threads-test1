package ex4;

public class Fir3 {
    public static void main(String args[]) {
        FirdeExecutie fir = new FirdeExecutie();
        Thread thread = new Thread(fir);
        thread.start();
        System.out.println("Revenim la main");
    }
}

class A {
    public void afis() {
        System.out.println("Este un exemplu simplu");
    }
}

class FirdeExecutie extends A implements Runnable {
    public void run() {
        for (int i = 0; i < 5; i++)
            System.out.println("Pasul " + i);
        afis();
        System.out.println("Run s-a terminat");
    }
}
