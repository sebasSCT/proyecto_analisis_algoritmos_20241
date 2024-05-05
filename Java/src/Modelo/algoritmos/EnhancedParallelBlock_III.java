package Modelo.algoritmos;

public class EnhancedParallelBlock_III implements Runnable{

    private static final int BLOCK_SIZE = 128/* Choose an appropriate block size */;  // Adjust based on matrix size and hardware
    private double[][] A, B, C;
    private int size;

    public EnhancedParallelBlock_III (double[][] A, double[][] B, double[][] C, int size)
    {
        this.A = A;
        this.B = B;
        this.C = C;
        this.size = size;
    }

    @Override
    public void run() {
        for (int i1 = 0; i1 < size / 2; i1 += BLOCK_SIZE) {
            for (int j1 = 0; j1 < size; j1 += BLOCK_SIZE) {
                for (int k1 = 0; k1 < size; k1 += BLOCK_SIZE) {
                    for (int i = i1; i < i1 + BLOCK_SIZE && i < size; i++) {
                        for (int j = j1; j < j1 + BLOCK_SIZE && j < size; j++) {
                            for (int k = k1; k < k1 + BLOCK_SIZE && k < size; k++) {
                                A[i][j] += B[i][k] * C[k][j];
                            }
                        }
                    }
                }
            }
        }

        // Second half of the matrix (optional for parallelization with additional threads)
        for (int i1 = size / 2; i1 < size; i1 += BLOCK_SIZE) {
            for (int j1 = 0; j1 < size; j1 += BLOCK_SIZE) {
                for (int k1 = 0; k1 < size; k1 += BLOCK_SIZE) {
                    for (int i = i1; i < i1 + BLOCK_SIZE && i < size; i++) {
                        for (int j = j1; j < j1 + BLOCK_SIZE && j < size; j++) {
                            for (int k = k1; k < k1 + BLOCK_SIZE && k < size; k++) {
                                A[i][j] += B[i][k] * C[k][j];
                            }
                        }
                    }
                }
            }
        }
    }
}