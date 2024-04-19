package ex1;

public class Fir
{
    public static void main(String args[])
    {
        FirdeExecutie fir=new FirdeExecutie();
        fir.start();
        System.out.println("Revenim la main");
    }
}
class FirdeExecutie extends Thread{
    public void run()
    {
        for(int i=0;i<10;i++)
            System.out.println("Pasul "+i);
        System.out.println("Run s-a terminat");
    }
}