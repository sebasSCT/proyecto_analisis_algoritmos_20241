package Modelo.algoritmos;

/**
 * Clase que implementa el algoritmo de multiplicación de matrices de Winograd con escalado.
 */
public class WinogradScaled 
{
    /**
     * Método para multiplicar dos matrices utilizando el algoritmo de Winograd con escalado.
     * 
     * @param A La matriz de tamaño NxP.
     * @param B La matriz de tamaño PxM.
     * @param Result La matriz resultado de tamaño NxM.
     * @param N El número de filas de la matriz A.
     * @param P El número de columnas de la matriz A y filas de la matriz B.
     * @param M El número de columnas de la matriz B.
     */
    public static void run (double[][] A, double[][] B, double[][] Result, int N, int P, int M) {
        // Crear copias escaladas de A y B
        double[][] CopyA = new double[N][P];
        double[][] CopyB = new double[P][M];
        
        // Factores de escalado
        double a = Operaciones.NormInf(A, N, P); // Norma infinito de A
        double b = Operaciones.NormInf(B, P, M); // Norma infinito de B
        double lambda = Math.floor(0.5 + Math.log(b/a)/Math.log(4)); // Factor de escala lambda
        
        // Escalado
        Operaciones.MultiplyWithScalar(A, CopyA, N, P, Math.pow(2, lambda));
        Operaciones.MultiplyWithScalar(B, CopyB, P, M, Math.pow(2, -lambda));
        
        // Utilizar Winograd con las matrices escaladas
        WinogradOriginal.run(CopyA, CopyB, Result, N, P, M);
    }
}
