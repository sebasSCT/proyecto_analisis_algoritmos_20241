package Modelo.algoritmos;

/**
 * Clase que implementa el algoritmo de multiplicación de matrices en paralelo utilizando bloques de tamaño fijo.
 * Esta clase implementa la interfaz Runnable para permitir la ejecución en un hilo separado.
 */
public class ParallelBlock_III implements Runnable
{
    double[][] A, B, C;

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
    }

    /**
     * Método run que contiene la lógica de multiplicación de matrices en paralelo.
     * Este método se ejecuta cuando se inicia un hilo con esta clase.
     */
    @Override
    public void run() 
    {
        // Iterar sobre los bloques de la matriz C
        for (int i1 = 0; i1 < A.length; i1 += B.length)
        {
            for (int j1 = 0; j1 < A.length; j1 += B.length)
            {
                for (int k1 = 0; k1 < A.length; k1 += B.length)
                {
                    // Iterar sobre los elementos de cada bloque
                    for (int i = i1; i < i1 + B.length && i < A.length; i++)
                    {
                        for (int j = j1; j < j1 + B.length && j < A.length; j++)
                        {
                            for (int k = k1; k < k1 + B.length && k < A.length; k++)
                            {
                                // Calcular el producto de los elementos y acumular en el resultado
                                C[i][j] += A[i][k] * B[k][j];
                            }
                        }
                    }
                }
            }
        }
    }
}
