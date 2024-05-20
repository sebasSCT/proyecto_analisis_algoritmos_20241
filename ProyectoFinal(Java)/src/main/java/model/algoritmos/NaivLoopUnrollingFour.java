package model.algoritmos;

/**
 * Clase que implementa el algoritmo de multiplicación de matrices NaivLoopUnrollingFour.
 */
public class NaivLoopUnrollingFour 
{
    /**
     * Método para multiplicar dos matrices y almacenar el resultado en una tercera matriz,
     * utilizando desenrollado de bucles con un factor de 4.
     * 
     * @param A La primera matriz de tamaño NxP.
     * @param B La segunda matriz de tamaño PxM.
     * @param result La matriz resultado de tamaño NxM donde se almacenará el resultado de la multiplicación.
     * @param N El número de filas de la matriz A.
     * @param M El número de columnas de la matriz B.
     * @param P El número de columnas de la matriz A y el número de filas de la matriz B.
     */
    public static void run (double[][] A, double[][] B, double[][] result, int N, int M, int P)
    {
        int i, j, k;
        double aux;

        // Verificar si P es múltiplo de 4
        if (P % 4 == 0) 
        {
            for (i = 0; i < N; i++) 
            {
                for (j = 0; j < M; j++) 
                {
                    aux = 0.0;

                    // Desenrollado del bucle interior con un factor de 4
                    for (k = 0; k < P; k += 4) 
                    {
                        aux += A[i][k]*B[k][j] + A[i][k+1]*B[k+1][j] + A[i][k+2]*B[k+2][j] + A[i][k+3]*B[k+3][j];
                    }

                    result[i][j] = aux;
                }
            }
        }  
        // Si P no es múltiplo de 4
        else if (P % 4 == 1) 
        {
            int PP = P - 1;

            for (i = 0; i < N; i++) 
            {
                for (j = 0; j < M; j++) 
                {
                    aux = 0.0;

                    for (k = 0; k < PP; k += 4)     
                    {
                        aux += A[i][k]*B[k][j] + A[i][k+1]*B[k+1][j] + A[i][k+2]*B[k+2][j] + A[i][k+3]*B[k+3][j];
                    }

                     result[i][j] = aux + A[i][PP]*B[PP][j];
                }
            }
        } 
        else if (P % 4 == 2) 
        {
            int PP = P - 2;
            int PPP = P - 1;

            for (i = 0; i < N; i++) 
            {
                for (j = 0; j < M; j++) 
                {
                    aux = 0.0;

                    for (k = 0; k < PP; k += 4) 
                    {
                        aux += A[i][k]*B[k][j] + A[i][k+1]*B[k+1][j] + A[i][k+2]*B[k+2][j] + A[i][k+3]*B[k+3][j];
                    }

                    result[i][j] = aux + A[i][PP]*B[PP][j] + A[i][PPP]*B[PPP][j];
                }
            }
        }
        else // Si P % 4 == 3
        {
            int PP = P - 3;
            int PPP = P - 2;
            int PPPP = P - 1;

            for (i = 0; i < N; i++) 
            {
                for (j = 0; j < M; j++) 
                {
                    aux = 0.0;

                    for (k = 0; k < PP; k += 4) 
                    {
                        aux += A[i][k]*B[k][j] + A[i][k+1]*B[k+1][j] + A[i][k+2]*B[k+2][j] + A[i][k+3]*B[k+3][j];
                    }
                    result[i][j] = aux + A[i][PP]*B[PP][j] + A[i][PPP]*B[PPP][j] + A[i][PPPP]*B[PPPP][j];
                }
            }
        }
    }
}
