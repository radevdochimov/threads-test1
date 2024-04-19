package ex5;

import java.util.Arrays;

//Se da un tablou bidimensional cu m linii si n coloane cu component intregi. Ordonati crescator
//liniile tabloului. Apoi afisati tabloul.
class SortThread extends Thread {
    private int[] row;

    public SortThread(int[] row) {
        this.row = row;
    }

    @Override
    public void run() {
        Arrays.sort(row);
    }
}

public class SortMatrix {
    public static void main(String[] args) {
        int m = 3; // Numarul de linii
        int n = 4; // Numarul de coloane

        // Tabloul bidimensional cu m linii și n coloane
        int[][] matrix = {
                {9, 8, 7, 6},
                {5, 4, 3, 2},
                {1, 0, -1, -2}
        };

        // Vector de fire de execuție pentru a sorta fiecare linie
        Thread[] threads = new Thread[m];

        for (int i = 0; i < m; i++) {
            threads[i] = new SortThread(matrix[i]);
            threads[i].start();
        }

        // Așteptăm ca fiecare fir să se încheie, se utilizează metoda join()
        try {
            for (Thread thread : threads) {
                thread.join();
            }
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        // Afișăm tabloul sortat
        System.out.println("Tabloul sortat:");
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                System.out.print(matrix[i][j] + " ");
            }
            System.out.println();
        }
    }
}