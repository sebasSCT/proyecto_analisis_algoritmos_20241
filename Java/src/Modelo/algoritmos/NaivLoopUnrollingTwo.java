package Modelo.algoritmos;

/**
 * Clase que implementa el algoritmo de multiplicación de matrices NaivLoopUnrollingTwo.
 */
public class NaivLoopUnrollingTwo 
{
    /**
     * Método para multiplicar dos matrices y almacenar el resultado en una tercera matriz,
     * utilizando desenrollado de bucles con un factor de 2.
     * 
     * @param A La primera matriz de tamaño NxP.
     * @param B La segunda matriz de tamaño PxM.
     * @param result La matriz resultado de tamaño NxM donde se almacenará el resultado de la multiplicación.
     * @param N El número de filas de la matriz A.
     * @param P El número de columnas de la matriz A y el número de filas de la matriz B.
     * @param M El número de columnas de la matriz B.
     */
    public static void run (double[][] A, double[][] B, double[][] result, int N, int P, int M)
    {
        int i, j, k;
        double aux;

        // Verificar si P es par
        if (P % 2 == 0)
        {
            for (i = 0; i < N; i++)
            {
                for (j = 0; j < M; j++)
                {
                    aux = 0.0;

                    // Desenrollado del bucle interior con un factor de 2
                    for (k = 0; k < P; k += 2)
                    {
                        aux += A[i][k] * B[k][j] + A[i][k+1] * B[k+1][j];
                    }

                    result[i][j] = aux;
                }
            }
        }
        else // Si P es impar
        {
            int PP = P - 1;
            
            for (i = 0; i < N; i++)
            {
                for (j = 0; j < M; j++)
                {
                    aux = 0.0;

                    // Desenrollado del bucle interior con un factor de 2
                    for (k = 0; k < PP; k += 2)
                    {
                        aux += A[i][k] * B[k][j] + A[i][k+1] * B[k+1][j];
                    }

                    // Sumar el último elemento si P es impar
                    result[i][j] = aux + A[i][PP] * B[PP][j];
                }
            }
        }
    }
}
