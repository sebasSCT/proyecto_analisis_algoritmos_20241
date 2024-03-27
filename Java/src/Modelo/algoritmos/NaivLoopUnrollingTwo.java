package Modelo.algoritmos;

public class NaivLoopUnrollingTwo 
{
    public static void run (double[][] A, double[][] B, double[][] result, int N, int P, int M)
    {
        int i, j, k;
        double aux;

        if (P % 2 == 0)
        {
            for (i = 0; i < N; i++)
            {
                for (j = 0; j < M; j++)
                {
                    aux = 0.0;

                    for (k = 0; k < P; k += 2)
                    {
                        aux += A[i][k] * B[k][j] + A[i][k+1] * B[k+1][j];
                    }

                    result[i][j] = aux;
                }
            }
        }
        else
        {
            int PP = P - 1;
            
            for (i = 0; i < N; i++)
            {
                for (j = 0; j < M; j++)
                {
                    aux = 0.0;

                    for (k = 0; k < PP; k += 2)
                    {
                        aux += A[i][k] * B[k][j] + A[i][k+1] * B[k+1][j];
                    }

                    result[i][j] = aux + A[i][PP] * B[PP][j];
                }
            }
        }
    }
}
