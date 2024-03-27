package Modelo.algoritmos;

public class ParallelBlock_V implements Runnable
{

    double[][] A, B, C;

    public ParallelBlock_V (double[][] A, double[][] B, double[][] C)
    {
        this.A = A;
        this.B = B;
        this.C = C;
    }

    @Override
    public void run() 
    {
        for ( int i1 = 0; i1 < A.length; i1 += B.length)

            for ( int j1 = 0; j1 < A.length; j1 += B.length)

                for ( int k1 = 0; k1 < A.length; k1 += B.length)

                    for ( int i = i1; i < i1 + B.length && i < A.length; i++)

                        for ( int j = j1; j < j1 + B.length && j < A.length; j++)

                            for ( int k = k1; k < k1 + B.length && k < A.length; k++)
                            
                                C[k][i] += A[k][j] * B[j][i];
    }
    
}
