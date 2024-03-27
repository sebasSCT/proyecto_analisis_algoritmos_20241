package Modelo.algoritmos;

public class WinogradScaled 
{
    public static void run (double[][] A, double[][] B, double[][] Result, int N, int P, int M) {
        //int i, j, k;
        
        // Create scaled copies of A and B
        double[][] CopyA = new double[N][P];
        double[][] CopyB = new double[P][M];
        
        // Scaling factors
        double a = Operaciones.NormInf(A, N, P);
        double b = Operaciones.NormInf(B, P, M);
        double lambda = Math.floor(0.5 + Math.log(b/a)/Math.log(4));
        
        // Scaling
        Operaciones.MultiplyWithScalar(A, CopyA, N, P, Math.pow(2, lambda));
        Operaciones.MultiplyWithScalar(B, CopyB, P, M, Math.pow(2, -lambda));
        
        // Using Winograd with scaled matrices
        WinogradOriginal.run(CopyA, CopyB, Result, N, P, M);
    }
}
