package Controlador;

import Modelo.algoritmos.*;

public interface AlgoritmosInt 
{
   
    void NaivOnArray(double[][] A, double[][] B, double[][] result, int N, int P, int M);
    void NaivLoopUnrollingTwo(double[][] A, double[][] B, double[][] result, int N, int P, int M);
    void NaivLoopUnrollingFour(double[][] A, double[][] B, double[][] result, int N, int M, int P);
    void WinogradOriginal(double[][] A, double[][] B, double[][] Result, int N, int P, int M);
    void WinogradScaled(double[][] A, double[][] B, double[][] Result, int N, int P, int M);
    void StrassenNaiv(double[][] A, double[][] B, double[][] Result, int N, int P, int M);
    void StrassenWinograd(double[][] A, double[][] B, double[][] Result, int N, int P, int M);
    void SequentialBlock_III(double[][] A, double[][] B, double[][] C);
    ParallelBlock_III ParallelBlock_III(double[][] A, double[][] B, double[][] C);
    EnhancedParallelBlock_III EnhancedParallelBlock_III(double[][] A, double[][] B, double[][] C, int size);
    void SequentialBlock_IV(double[][] A, double[][] B, double[][] C);
    ParallelBlock_IV ParallelBlock_IV(double[][] A, double[][] B, double[][] C);
    EnhancedParallelBlock_IV EnhancedParallelBlock_IV(double[][] A, double[][] B, double[][] C, int size);
    void SequentialBlock_V(double[][] A, double[][] B, double[][] C);
    ParallelBlock_V ParallelBlock_V(double[][] A, double[][] B, double[][] C);
        
}
