package Modelo.algoritmos;

public class NaivOnArray 
{
    public static void run (double[][] A, double[][] B, double[][] result, int N, int P, int M)
    {
        for (int i = 0; i < N; i++)
        {
            for (int j = 0; j < M; j++)
            {
                result[i][j] = 0.0;

                for (int k = 0; k < P; k++)
                {
                    result[i][j] += A[i][k] * B[k][j];
                }
            }
        }
    }
}
