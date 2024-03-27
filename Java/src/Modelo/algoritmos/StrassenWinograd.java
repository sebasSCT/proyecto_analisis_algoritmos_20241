package Modelo.algoritmos;

public class StrassenWinograd 
{
    public static void run(double[][] A, double[][] B, double[][] Result, int N, int P, int M) 
    {
        int MaxSize, k, m, NewSize, i, j;
        MaxSize = Math.max(N,P);
        MaxSize = Math.max(MaxSize,M);
        if ( MaxSize < 16){
            MaxSize = 16; // otherwise it is not possible to compute k
        }
        k = (int) Math.floor(Math.log(MaxSize)/Math.log(2)) - 4;
        m = (int) Math.floor(MaxSize * Math.pow(2,-k)) + 1;
        NewSize = m * (int) Math.pow(2,k);
    
        // add zero rows and columns to use Strassens algorithm
        double[][] NewA = new double[NewSize][NewSize];
        double[][] NewB = new double[NewSize][NewSize];
        double[][] AuxResult = new double[NewSize][NewSize];
    
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
    
        StrassenWinogradStep(NewA, NewB, AuxResult, NewSize, m);
    
        // extract the result
        for( i = 0; i < N; i++){
            for( j = 0; j < M; j++){
                Result[i][j] = AuxResult[i][j];
            }
        }
    }
    
    private static void StrassenWinogradStep(double[][] A,double[][] B,double[][] Result,int N,int m)
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
        double[][] A1 = new double[NewSize][NewSize];
        double[][] A2 = new double[NewSize][NewSize];
        double[][] B1 = new double[NewSize][NewSize];
        double[][] B2 = new double[NewSize][NewSize];
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
        double[][] Aux8 = new double[NewSize][NewSize];
        double[][] Aux9 = new double[NewSize][NewSize];
        for( i = 0; i < NewSize; i++){
        A11[i] = new double[NewSize];
        A12[i] = new double[NewSize];
        A21[i] = new double[NewSize];
        A22[i] = new double[NewSize];
        B11[i] = new double[NewSize];
        B12[i] = new double[NewSize];
        B21[i] = new double[NewSize];
        B22[i] = new double[NewSize];
        A1[i] = new double[NewSize];
        A2[i] = new double[NewSize];
        B1[i] = new double[NewSize];
        B2[i] = new double[NewSize];
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
        Aux8[i] = new double[NewSize];
        Aux9[i] = new double[NewSize];
        }
        // fill new matrices
        for( i = 0; i < NewSize; i++){
        for( j = 0; j < NewSize; j++){
        A11[i][j] = A[i][j];
        }
        }
        for( i = 0; i < NewSize; i++){
        for( j = 0; j < NewSize; j++){
        A12[i][j] = A[i][NewSize + j];
        }
        }
        for( i = 0; i < NewSize; i++){
        for( j = 0; j < NewSize; j++){
        A21[i][j] = A[NewSize + i][j];
        }
        }
        for( i = 0; i < NewSize; i++){
        for( j = 0; j < NewSize; j++){
        A22[i][j] = A[NewSize + i][NewSize + j];
        }
        }
        for( i = 0; i < NewSize; i++){
        for( j = 0; j < NewSize; j++){
        B11[i][j] = B[i][j];
        }
        }
        for( i = 0; i < NewSize; i++){
        for( j = 0; j < NewSize; j++){
        B12[i][j] = B[i][NewSize + j];
        }
        }
        for( i = 0; i < NewSize; i++){
        for( j = 0; j < NewSize; j++){
        B21[i][j] = B[NewSize + i][j];
        }
        }
        for( i = 0; i < NewSize; i++){
        for( j = 0; j < NewSize; j++){
        B22[i][j] = B[NewSize + i][NewSize + j];
        }
        }
        // computing the 4 + 9 aux. variables
        Operaciones.Minus(A11, A21, A1, NewSize, NewSize);
        Operaciones.Minus(A22, A1, A2, NewSize, NewSize);
        Operaciones.Minus(B22, B12, B1, NewSize, NewSize);
        Operaciones.Plus(B1, B11, B2, NewSize, NewSize);
        StrassenWinogradStep(A11, B11, Aux1, NewSize, m);
        StrassenWinogradStep(A12, B21, Aux2, NewSize, m);
        StrassenWinogradStep(A2, B2, Aux3, NewSize, m);
        Operaciones.Plus(A21, A22, Helper1, NewSize, NewSize);
        Operaciones.Minus(B12, B11, Helper2, NewSize, NewSize);
        StrassenWinogradStep(Helper1, Helper2, Aux4, NewSize, m);
        StrassenWinogradStep(A1, B1, Aux5, NewSize, m);
        Operaciones.Minus(A12, A2, Helper1, NewSize, NewSize);
        StrassenWinogradStep(Helper1, B22, Aux6, NewSize, m);
        Operaciones.Minus(B21, B2, Helper1, NewSize, NewSize);
        StrassenWinogradStep(A22, Helper1, Aux7, NewSize, m);
        Operaciones.Plus(Aux1, Aux3, Aux8, NewSize, NewSize);
        Operaciones.Plus(Aux8, Aux4, Aux9, NewSize, NewSize);
        Operaciones.Plus(Aux1, Aux2, ResultPart11, NewSize, NewSize);
        Operaciones.Plus(Aux9, Aux6, ResultPart12, NewSize, NewSize);
        Operaciones.Plus(Aux8, Aux5, Helper1, NewSize, NewSize);
        Operaciones.Plus(Helper1, Aux7, ResultPart21, NewSize, NewSize);
        Operaciones.Plus(Aux9, Aux5, ResultPart22, NewSize, NewSize);
        // store results in the "result matrix"
        for( i = 0; i < NewSize; i++){
        for( j = 0; j < NewSize; j++){
        Result[i][j] = ResultPart11[i][j];
        }
        }
        for( i = 0; i < NewSize; i++){
        for( j = 0; j < NewSize; j++){
        Result[i][NewSize + j] = ResultPart12[i][j];
        }
        }
        for( i = 0; i < NewSize; i++){
        for( j = 0; j < NewSize; j++){
        Result[NewSize + i][j] = ResultPart21[i][j];
        }
        }
        for( i = 0; i < NewSize; i++){
        for( j = 0; j < NewSize; j++){
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
