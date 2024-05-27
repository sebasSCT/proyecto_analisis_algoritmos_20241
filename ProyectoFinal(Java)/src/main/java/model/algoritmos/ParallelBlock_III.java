package model.algoritmos;

/**
 * Clase que implementa el algoritmo de multiplicación de matrices en paralelo utilizando bloques de tamaño fijo.
 * Esta clase implementa la interfaz Runnable para permitir la ejecución en un hilo separado.
 */
public class ParallelBlock_III implements Runnable
{
    double[][] A, B, C;
    int size;

    /**
     * Constructor de la clase ParallelBlock_III.
     * 
     * @param A La matriz de tamaño NxN.
     * @param B La matriz de tamaño NxN.
     * @param C La matriz resultado de tamaño NxN.
     */
    public ParallelBlock_III (double[][] A, double[][] B, double[][] C)
    {
        this.A = A;
        this.B = B;
        this.C = C;
        this.size = A.length;
    }

    /**
     * Método run que contiene la lógica de multiplicación de matrices en paralelo.
     * Este método se ejecuta cuando se inicia un hilo con esta clase.
     */
    @Override
    public void run()
    {

        int bsize = determinarBlockSize(size);

        // Iterar sobre los bloques de la matriz C
        for ( int i1 = 0; i1 < size; i1 += bsize) {
            for (int j1 = 0; j1 < size; j1 += bsize) {
                for (int k1 = 0; k1 < size; k1 += bsize) {
                    for (int i = i1; i < i1 + bsize && i < size; i++) {
                        for (int j = j1; j < j1 + bsize && j < size; j++) {
                            for (int k = k1; k < k1 + bsize && k < size; k++) {
                                C[i][j] += A[i][k] * B[k][j];
                            }
                        }
                    }
                }
            }
        }

//        for (double[] a : C)
//        {
//            for (double b : a)
//            {
//                System.out.print(b + " ");
//            }
//            System.out.println();
//        }


    }

    private static int determinarBlockSize(int size) {
        return Math.max(1, size / 10);
    }
}
