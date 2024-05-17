package Modelo.algoritmos;

/**
 * Clase que implementa el algoritmo de multiplicación de matrices en secuencial utilizando bloques de tamaño fijo.
 */
public class SequentialBlock_V 
{
    /**
     * Método para multiplicar dos matrices en secuencial utilizando bloques de tamaño fijo.
     * 
     * @param A La matriz de tamaño NxN.
     * @param B La matriz de tamaño NxN.
     * @param C La matriz resultado de tamaño NxN.
     */
    public static void run (double[][] A, double[][] B, double[][] C)
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
                                C[k][i] += A[k][j] * B[j][i];
                            }
                        }
                    }
                }
            }
        }
    }
}
