package controller;
import model.algoritmos.*;

public class AlgoritmosImp implements AlgoritmosInt 
{

    @Override
    public void NaivOnArray(double[][] A, double[][] B, double[][] result, int N, int P, int M) {
        NaivOnArray.run(A, B, result, N, P, M);
    }

    @Override
    public void NaivLoopUnrollingTwo(double[][] A, double[][] B, double[][] result, int N, int P, int M) {
        NaivLoopUnrollingTwo.run(A, B, result, N, P, M);
    }

    @Override
    public void NaivLoopUnrollingFour(double[][] A, double[][] B, double[][] result, int N, int M, int P) {
        NaivLoopUnrollingFour.run(A, B, result, N, M, P);
    }

    @Override
    public void WinogradOriginal(double[][] A, double[][] B, double[][] Result, int N, int P, int M) {
        WinogradOriginal.run(A, B, Result, N, P, M);
    }

    @Override
    public void WinogradScaled(double[][] A, double[][] B, double[][] Result, int N, int P, int M) {
        WinogradScaled.run(A, B, Result, N, P, M);
    }

    @Override
    public void StrassenNaiv(double[][] A, double[][] B, double[][] Result, int N, int P, int M) {
        StrassenNaiv.run(A, B, Result, N, P, M);
    }

    @Override
    public void StrassenWinograd(double[][] A, double[][] B, double[][] Result, int N, int P, int M) {
        StrassenWinograd.run(A, B, Result, N, P, M);
    }

    @Override
    public void SequentialBlock_III(double[][] A, double[][] B, double[][] C) {
        SequentialBlock_III.run(A, B, C);
    }

    @Override
    public ParallelBlock_III ParallelBlock_III(double[][] A, double[][] B, double[][] C) {
        return new ParallelBlock_III(A, B, C);
    }

    @Override
    public void EnhancedParallelBlock_III(double[][] A, double[][] B, double[][] C, int size) {
        EnhancedParallelBlock_III.run(A, B, C, size);
    }

    @Override
    public void SequentialBlock_IV(double[][] A, double[][] B, double[][] C) {
        SequentialBlock_IV.run(A, B, C);
    }

    @Override
    public ParallelBlock_IV ParallelBlock_IV(double[][] A, double[][] B, double[][] C) {
        return new ParallelBlock_IV(A, B, C);
    }

    @Override
    public void EnhancedParallelBlock_IV(double[][] A, double[][] B, double[][] C, int size) {
        EnhancedParallelBlock_IV.run(A,B,C,size);
    }

    @Override
    public void SequentialBlock_V(double[][] A, double[][] B, double[][] C) {
        SequentialBlock_V.run(A, B, C);
    }

    @Override
    public ParallelBlock_V ParallelBlock_V(double[][] A, double[][] B, double[][] C) {
        return new ParallelBlock_V(A, B, C);
    }

}
