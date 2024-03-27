package Modelo.algoritmos;


public class Operaciones 
{
    public static void Plus(double[][] A,double[][] B,double[][] Result,int N,int M)
    {
        for (int i = 0; i < N; i++)
        {
            for (int j = 0; j < M; j++)
            {
                Result[i][j] = A[i][j] + B[i][j];
            }
        }
    }

    public static void Minus(double[][] A,double[][] B,double[][] Result,int N,int M)
    {
        for (int i = 0; i < N; i++) 
        {
            for (int j = 0; j < M; j++) 
            {
                Result[i][j] = A[i][j] - B[i][j];
            }
        }
    }

    public static int max(int x,int y )
    {
        if (x < y)
        {
            return y;
        } 
        else 
        {
            return x;
        }
    }

    public static double Max(double x,double y )
    {
        if (x < y)
        {
            return y;
        } 
        else 
        {
            return x;
        }
    }

    public static double Abs(double a)
    {
        if ( a < 0 ) 
        {
        return -a;
        }
        return a;
    }

    public static double NormInf(double[][] A,int N,int P)
    {
        double Norm = 0.0;
        double aux;
        int i, j;

        for (i = 0; i < N; i++) 
        {
            aux = 0.0;

            for (j = 0; j < P; j++) 
            {
                aux += Abs(A[i][j]);
            }

            Norm = Max(Norm, aux);
        }
        return Norm;
    }
    
    public static void MultiplyWithScalar(double[][] A,double[][] Result,int N,int M,double alpha)
    {
        for (int i = 0; i < N; i++) 
        {
            for (int j = 0; j < M; j++) 
            {
                Result [i][j] = alpha*A[i][j];
            }
        }
    }
}
