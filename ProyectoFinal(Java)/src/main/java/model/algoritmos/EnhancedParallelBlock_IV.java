package model.algoritmos;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;

public class EnhancedParallelBlock_IV{

    public static void run(double[][] A, double[][] B, double[][] C, int size) {
        int BSIZE = determineBlockSize(size);

        ExecutorService executor = Executors.newFixedThreadPool(2);

        Runnable task1 = () -> {
            for (int i1 = 0; i1 < size / 2; i1 += BSIZE) {
                for (int j1 = 0; j1 < size; j1 += BSIZE) {
                    for (int k1 = 0; k1 < size; k1 += BSIZE) {
                        for (int i = i1; i < i1 + BSIZE && i < size; i++) {
                            for (int j = j1; j < j1 + BSIZE && j < size; j++) {
                                for (int k = k1; k < k1 + BSIZE && k < size; k++) {
                                    A[i][k] += B[i][j] * C[j][k];
                                }
                            }
                        }
                    }
                }
            }
        };

        Runnable task2 = () -> {
            for (int i1 = size / 2; i1 < size; i1 += BSIZE) {
                for (int j1 = 0; j1 < size; j1 += BSIZE) {
                    for (int k1 = 0; k1 < size; k1 += BSIZE) {
                        for (int i = i1; i < i1 + BSIZE && i < size; i++) {
                            for (int j = j1; j < j1 + BSIZE && j < size; j++) {
                                for (int k = k1; k < k1 + BSIZE && k < size; k++) {
                                    A[i][k] += B[i][j] * C[j][k];
                                }
                            }
                        }
                    }
                }
            }
        };

        executor.execute(task1);
        executor.execute(task2);

        executor.shutdown();
        try {
            executor.awaitTermination(Long.MAX_VALUE, TimeUnit.NANOSECONDS);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    private static int determineBlockSize(int size) {
        return Math.max(1, size / 10); // ejemplo: ajustar el tamaño del bloque como una fracción del tamaño de la matriz
    }

    public static void main(String[] args) {
        double[][] A = {{2, 2, 2}, {2, 2, 2}, {2, 2, 2}};
        double[][] B = {{2, 2, 2}, {2, 2, 2}, {2, 2, 2}};
        double[][] C = new double[3][3]; // Initialize C to store the result

        run(C, A, B, A.length); // Pass matrix length as size

        System.out.println("Resultant matrix C:");
        for (double[] row : C) {
            for (double element : row) {
                System.out.print(element + " ");
            }
            System.out.println();
        }
    }
}
