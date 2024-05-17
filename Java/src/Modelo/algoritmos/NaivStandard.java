package Modelo.algoritmos;

/**
 * Clase que implementa el algoritmo de multiplicación de matrices NaivStandard.
 */
public class NaivStandard 
{
    /**
     * Método para multiplicar dos matrices y almacenar el resultado en una tercera matriz.
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
        double aux;

        // Iterar sobre las filas de la matriz A
        for (int i = 0; i < N; i++)
        {
            // Iterar sobre las columnas de la matriz B
            for (int j = 0; j < M; j++)
            {
                aux = 0.0;

                // Iterar sobre las columnas de la matriz A y las filas de la matriz B
                for (int k = 0; k < P; k++)
                {
                    // Multiplicar los elementos correspondientes de A y B y acumularlos en 'aux'
                    aux += A[i][k] * B[k][j];
                }

                // Almacenar el resultado en la posición correspondiente de la matriz resultado
                result[i][j] = aux;
            }
        }
    }
}

