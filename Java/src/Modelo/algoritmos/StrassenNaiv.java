package Modelo.algoritmos;

public class StrassenNaiv 
{

    public static void run (double[][] A, double[][] B, double[][] Result, int N, int P, int M) {
        int MaxSize, k, m, NewSize, i, j;
        MaxSize = Math.max(N,P);
        MaxSize = Math.max(MaxSize,M);

        if ( MaxSize < 16)
        {
            MaxSize = 16; 
        }

        k = (int) Math.floor(Math.log(MaxSize)/Math.log(2)) - 4;
        m = (int) Math.floor(MaxSize * Math.pow(2,-k)) + 1;
        NewSize = m * (int) Math.pow(2,k);

        double[][] NewA = new double[NewSize][NewSize];
        double[][] NewB = new double[NewSize][NewSize];
        double[][] AuxResult = new double[NewSize][NewSize];
    
        for( i = 0; i < NewSize; i++)
        {
            NewA[i] = new double[NewSize];
            NewB[i] = new double[NewSize];
            AuxResult[i] = new double[NewSize];
        }

        for( i = 0; i < NewSize; i++){
            for( j = 0; j < NewSize; j++){
                NewA[i][j] = 0.0;
                NewB[i][j] = 0.0;
            }
        }
        for( i = 0; i < N; i++){
            for( j = 0; j < P; j++){
                NewA[i][j] = A[i][j];
            }
        }
        for( i = 0; i < P; i++){
            for( j = 0; j < M; j++){
                NewB[i][j] = B[i][j];
            }
        }
        
        StrassenNaivStep(NewA, NewB, AuxResult, NewSize, m);
        
        for( i = 0; i < N; i++){
            for( j = 0; j < M; j++){
                Result[i][j] = AuxResult[i][j];
            }
        }
    }

    private static void StrassenNaivStep(double[][] A,double[][] B,double[][] Result,int N,int m)
    {
        int i, j, NewSize;
        
        if( (N % 2 == 0) && (N > m) )
        { 
            NewSize = N / 2;
            
            double[][] A11 = new double[NewSize][NewSize];
            double[][] A12 = new double[NewSize][NewSize];
            double[][] A21 = new double[NewSize][NewSize];
            double[][] A22 = new double[NewSize][NewSize];
            double[][] B11 = new double[NewSize][NewSize];
            double[][] B12 = new double[NewSize][NewSize];
            double[][] B21 = new double[NewSize][NewSize];
            double[][] B22 = new double[NewSize][NewSize];
            double[][] ResultPart11 = new double[NewSize][NewSize];
            double[][] ResultPart12 = new double[NewSize][NewSize];
            double[][] ResultPart21 = new double[NewSize][NewSize];
            double[][] ResultPart22 = new double[NewSize][NewSize];
            double[][] Helper1 = new double[NewSize][NewSize];
            double[][] Helper2 = new double[NewSize][NewSize];
            double[][] Aux1 = new double[NewSize][NewSize];
            double[][] Aux2 = new double[NewSize][NewSize];
            double[][] Aux3 = new double[NewSize][NewSize];
            double[][] Aux4 = new double[NewSize][NewSize];
            double[][] Aux5 = new double[NewSize][NewSize];
            double[][] Aux6 = new double[NewSize][NewSize];
            double[][] Aux7 = new double[NewSize][NewSize];

            for( i = 0; i < NewSize; i++)
            {
                A11[i] = new double[NewSize];
                A12[i] = new double[NewSize];
                A21[i] = new double[NewSize];
                A22[i] = new double[NewSize];
                B11[i] = new double[NewSize];
                B12[i] = new double[NewSize];
                B21[i] = new double[NewSize];
                B22[i] = new double[NewSize];
                ResultPart11[i] = new double[NewSize];
                ResultPart12[i] = new double[NewSize];
                ResultPart21[i] = new double[NewSize];
                ResultPart22[i] = new double[NewSize];
                Helper1[i] = new double[NewSize];
                Helper2[i] = new double[NewSize];
                Aux1[i] = new double[NewSize];
                Aux2[i] = new double[NewSize];
                Aux3[i] = new double[NewSize];
                Aux4[i] = new double[NewSize];
                Aux5[i] = new double[NewSize];
                Aux6[i] = new double[NewSize];
                Aux7[i] = new double[NewSize];
            }
            
            for( i = 0; i < NewSize; i++)
            {
                for( j = 0; j < NewSize; j++)
                {
                    A11[i][j] = A[i][j];
                }
            }
            for( i = 0; i < NewSize; i++)
            {
            for( j = 0; j < NewSize; j++)
                {
                    A12[i][j] = A[i][NewSize + j];
                }
            }
            for( i = 0; i < NewSize; i++)
            {
                for( j = 0; j < NewSize; j++)
                {
                    A21[i][j] = A[NewSize + i][j];
                }
            }
            for( i = 0; i < NewSize; i++)
            {
                for( j = 0; j < NewSize; j++)
                {
                    A22[i][j] = A[NewSize + i][NewSize + j];
                }
            }
            for( i = 0; i < NewSize; i++)
            {
                for( j = 0; j < NewSize; j++)
                {
                    B11[i][j] = B[i][j];
                }
            }
            for( i = 0; i < NewSize; i++)
            {
                for( j = 0; j < NewSize; j++)
                {
                    B12[i][j] = B[i][NewSize + j];
                }
            }
            for( i = 0; i < NewSize; i++)
            {
                for( j = 0; j < NewSize; j++)
                {
                    B21[i][j] = B[NewSize + i][j];
                }
            }
            for( i = 0; i < NewSize; i++)
            {
                for( j = 0; j < NewSize; j++)
                {
                    B22[i][j] = B[NewSize + i][NewSize + j];
                }
            }
            
            Operaciones.Plus(A11, A22, Helper1, NewSize, NewSize);
            Operaciones.Plus(B11, B22, Helper2, NewSize, NewSize);
            StrassenNaivStep(Helper1, Helper2, Aux1, NewSize, m);
            Operaciones.Plus(A21, A22, Helper1, NewSize, NewSize);
            StrassenNaivStep(Helper1, B11, Aux2, NewSize, m);
            Operaciones.Minus(B12, B22, Helper1, NewSize, NewSize);
            StrassenNaivStep(A11, Helper1, Aux3, NewSize, m);
            Operaciones.Minus(B21, B11, Helper1, NewSize, NewSize);
            StrassenNaivStep(A22, Helper1, Aux4, NewSize, m);
            Operaciones.Plus(A11, A12, Helper1, NewSize, NewSize);
            StrassenNaivStep(Helper1, B22, Aux5, NewSize, m);
            Operaciones.Minus(A21, A11, Helper1, NewSize, NewSize);
            Operaciones.Plus(B11, B12, Helper2, NewSize, NewSize);
            StrassenNaivStep(Helper1, Helper2, Aux6, NewSize, m);
            Operaciones.Minus(A12, A22, Helper1, NewSize, NewSize);
            Operaciones.Plus(B21, B22, Helper2, NewSize, NewSize);
            StrassenNaivStep(Helper1, Helper2, Aux7, NewSize, m);
            Operaciones.Plus(Aux1, Aux4, ResultPart11, NewSize, NewSize);
            Operaciones.Minus(ResultPart11, Aux5, ResultPart11, NewSize, NewSize);
            Operaciones.Plus(ResultPart11, Aux7, ResultPart11, NewSize, NewSize);
            Operaciones.Plus(Aux3, Aux5, ResultPart12, NewSize, NewSize);
            Operaciones.Plus(Aux2, Aux4, ResultPart21, NewSize, NewSize);
            Operaciones.Plus(Aux1, Aux3, ResultPart22, NewSize, NewSize);
            Operaciones.Minus(ResultPart22, Aux2, ResultPart22, NewSize, NewSize);
            Operaciones.Plus(ResultPart22, Aux6, ResultPart22, NewSize, NewSize);
            
            for( i = 0; i < NewSize; i++)
            {
                for( j = 0; j < NewSize; j++)
                {
                    Result[i][j] = ResultPart11[i][j];
                }
            }
            for( i = 0; i < NewSize; i++)
            {
                for( j = 0; j < NewSize; j++)
                {
                    Result[i][NewSize + j] = ResultPart12[i][j];
                }
            }
            for( i = 0; i < NewSize; i++)
            {
                for( j = 0; j < NewSize; j++)
                {
                    Result[NewSize + i][j] = ResultPart21[i][j];
                }
            }
            for( i = 0; i < NewSize; i++)
            {
                for( j = 0; j < NewSize; j++)
                {
                    Result[NewSize + i][NewSize + j] = ResultPart22[i][j];
                }
            }
        }

        else 
        {
            NaivStandard.run(A, B, Result, N, N, N);
        }
        
    }

    
}
