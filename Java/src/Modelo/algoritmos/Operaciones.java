package Modelo.algoritmos;

/**
 * Clase que contiene métodos para realizar operaciones matriciales y escalares.
 */
public class Operaciones 
{
    /**
     * Método para sumar dos matrices elemento por elemento.
     * 
     * @param A La primera matriz de tamaño NxM.
     * @param B La segunda matriz de tamaño NxM.
     * @param Result La matriz resultado de tamaño NxM donde se almacenará la suma.
     * @param N El número de filas de las matrices A, B y Result.
     * @param M El número de columnas de las matrices A, B y Result.
     */
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

    /**
     * Método para restar dos matrices elemento por elemento.
     * 
     * @param A La primera matriz de tamaño NxM.
     * @param B La segunda matriz de tamaño NxM.
     * @param Result La matriz resultado de tamaño NxM donde se almacenará la resta.
     * @param N El número de filas de las matrices A, B y Result.
     * @param M El número de columnas de las matrices A, B y Result.
     */
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

    /**
     * Método para obtener el máximo entre dos números enteros.
     * 
     * @param x El primer número entero.
     * @param y El segundo número entero.
     * @return El máximo entre x e y.
     */
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

    /**
     * Método para obtener el máximo entre dos números de punto flotante.
     * 
     * @param x El primer número de punto flotante.
     * @param y El segundo número de punto flotante.
     * @return El máximo entre x e y.
     */
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

    /**
     * Método para calcular el valor absoluto de un número de punto flotante.
     * 
     * @param a El número de punto flotante.
     * @return El valor absoluto de a.
     */
    public static double Abs(double a)
    {
        if ( a < 0 ) 
        {
        return -a;
        }
        return a;
    }

    /**
     * Método para calcular la norma infinito de una matriz.
     * 
     * @param A La matriz de tamaño NxP.
     * @param N El número de filas de la matriz A.
     * @param P El número de columnas de la matriz A.
     * @return La norma infinito de la matriz A.
     */
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
    
    /**
     * Método para multiplicar una matriz por un escalar.
     * 
     * @param A La matriz de tamaño NxM.
     * @param Result La matriz resultado de tamaño NxM donde se almacenará el resultado de la multiplicación.
     * @param N El número de filas de las matrices A y Result.
     * @param M El número de columnas de las matrices A y Result.
     * @param alpha El escalar por el que se multiplicará la matriz A.
     */
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
