package Modelo.algoritmos;

/**
 * Clase que implementa el algoritmo de multiplicación de matrices de Winograd original.
 */
public class WinogradOriginal 
{
    /**
     * Método para multiplicar dos matrices utilizando el algoritmo de Winograd original.
     * 
     * @param A La matriz de tamaño NxP.
     * @param B La matriz de tamaño PxM.
     * @param Result La matriz resultado de tamaño NxM.
     * @param N El número de filas de la matriz A.
     * @param P El número de columnas de la matriz A y filas de la matriz B.
     * @param M El número de columnas de la matriz B.
     */
    public static void run(double[][] A, double[][] B, double[][] Result, int N, int P, int M) {
        int i, j, k;
        double aux;
        int upsilon = P % 2;
        int gamma = P - upsilon;
        double[] y = new double[M]; // Vector y de tamaño M
        double[] z = new double[N]; // Vector z de tamaño N
        
        // Calcula el vector y
        for (i = 0; i < M; i++) {
            aux = 0.0;
            for (j = 0; j < gamma; j += 2) {
                aux += A[i][j]*A[i][j+1];
            }
            y[i] = aux;
        }
        
        // Calcula el vector z
        for (i = 0; i < N; i++) {
            aux = 0.0;
            for (j = 0; j < gamma; j += 2) {
                aux += B[j][i]*B[j+1][i];
            }
            z[i] = aux;
        }
        
        if (upsilon == 1) {
            /*
            * P es impar
            * Falta el valor A[i][P]*B[P][k] en todas las sumas auxiliares.
            */
            int PP = P-1;
            for (i = 0; i < M; i++) {
                for (k = 0; k < N; k++) {
                    aux = 0.0;
                    for (j = 0; j < gamma; j += 2) {
                        aux += ( A[i][j] + B[j+1][k] )*( A[i][j+1] + B[j][k] );
                    }
                    Result[i][k] = aux - y[i] - z[k] + A[i][PP]*B[PP][k];
                }
            }
        } else {
            /*
            * P es par
            * El resultado se puede calcular con las sumas auxiliares.
            */
            for (i = 0; i < M; i++) {
                for (k = 0; k < N; k++) {
                    aux = 0.0;
                    for (j = 0; j < gamma; j += 2) {
                        aux += ( A[i][j] + B[j+1][k] )*( A[i][j+1] + B[j][k] );
                    }
                    Result[i][k] = aux - y[i] - z[k];
                }
            }
        }
        // Liberar memoria asignada dinámicamente
        y = null;
        z = null;
    }
}
