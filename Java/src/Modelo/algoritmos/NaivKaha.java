package Modelo.algoritmos;

public class NaivKaha 
{
    public static void run (double[][] A, double[][] B, double[][] result, int N, int P, int M)
    {
        double t, sum, err;

        for (int i = 0; i < N; i++)
        {
            for (int j = 0; j < M; j++)
            {
                sum = 0.0;
                err = 0.0;

                for (int k = 0; k < P; k++)
                {
                    err = err + A[i][k] * B[k][j];
                    t = sum + err;
                    err = (sum - t) + err;
                    sum = t;
                }

                result[i][j] = sum;
            }
        }
    }
}
