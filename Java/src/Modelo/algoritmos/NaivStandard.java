package Modelo.algoritmos;

public class NaivStandard 
{
    public static void run (double[][] A, double[][] B, double[][] result, int N, int P, int M)
    {
        double aux;

        for (int i = 0; i < N; i++)
        {
            for (int j = 0; j < M; j++)
            {
                aux = 0.0;

                for (int k = 0; k < P; k++)
                {
                    aux += A[i][k] * B[k][j];
                }

                result[i][j] = aux;
            }
        }
    }
}
