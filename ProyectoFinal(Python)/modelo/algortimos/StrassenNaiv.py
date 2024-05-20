from modelo.algortimos.Operaciones import Operaciones
from modelo.algortimos.NaivStandard import NaivStandard
import math

class StrassenNaiv:
    @staticmethod
    def run(A, B, Result, N, P, M):
        # Se calcula el tamaño máximo entre N, P y M
        MaxSize = max(N, P, M)

        # Si el tamaño máximo es menor que 16, se ajusta a 16
        if MaxSize < 16:
            MaxSize = 16

        # Se calcula k y m para ajustar el tamaño de las matrices
        k = int((MaxSize.bit_length() - 4))
        m = int(MaxSize * (2 ** (-k)) + 1)
        NewSize = m * (2 ** k)

        # Se crean nuevas matrices de tamaño NewSize
        NewA = [[0.0] * NewSize for _ in range(NewSize)]
        NewB = [[0.0] * NewSize for _ in range(NewSize)]
        AuxResult = [[0.0] * NewSize for _ in range(NewSize)]

        # Se inicializan las nuevas matrices en 0
        for i in range(NewSize):
            for j in range(NewSize):
                NewA[i][j] = 0.0
                NewB[i][j] = 0.0

        # Se copian los elementos de A y B en las nuevas matrices
        for i in range(N):
            for j in range(P):
                NewA[i][j] = A[i][j]

        for i in range(P):
            for j in range(M):
                NewB[i][j] = B[i][j]

        # Se realiza la multiplicación utilizando el algoritmo de Strassen
        StrassenNaiv.strassen_naiv_step(NewA, NewB, AuxResult, NewSize, m)

        # Se copian los elementos del resultado a la matriz Result
        for i in range(N):
            for j in range(M):
                Result[i][j] = AuxResult[i][j]

    @staticmethod
    def strassen_naiv_step(A, B, Result, N, m):
        # Si N es par y mayor que m, se divide en bloques más pequeños
        if N % 2 == 0 and N > m:
            NewSize = N // 2

            # Se crean submatrices para dividir A, B y el resultado
            A11 = [[0.0] * NewSize for _ in range(NewSize)]
            A12 = [[0.0] * NewSize for _ in range(NewSize)]
            A21 = [[0.0] * NewSize for _ in range(NewSize)]
            A22 = [[0.0] * NewSize for _ in range(NewSize)]
            B11 = [[0.0] * NewSize for _ in range(NewSize)]
            B12 = [[0.0] * NewSize for _ in range(NewSize)]
            B21 = [[0.0] * NewSize for _ in range(NewSize)]
            B22 = [[0.0] * NewSize for _ in range(NewSize)]
            ResultPart11 = [[0.0] * NewSize for _ in range(NewSize)]
            ResultPart12 = [[0.0] * NewSize for _ in range(NewSize)]
            ResultPart21 = [[0.0] * NewSize for _ in range(NewSize)]
            ResultPart22 = [[0.0] * NewSize for _ in range(NewSize)]
            Helper1 = [[0.0] * NewSize for _ in range(NewSize)]
            Helper2 = [[0.0] * NewSize for _ in range(NewSize)]
            Aux1 = [[0.0] * NewSize for _ in range(NewSize)]
            Aux2 = [[0.0] * NewSize for _ in range(NewSize)]
            Aux3 = [[0.0] * NewSize for _ in range(NewSize)]
            Aux4 = [[0.0] * NewSize for _ in range(NewSize)]
            Aux5 = [[0.0] * NewSize for _ in range(NewSize)]
            Aux6 = [[0.0] * NewSize for _ in range(NewSize)]
            Aux7 = [[0.0] * NewSize for _ in range(NewSize)]

            # Se copian los elementos de A y B en las submatrices
            for i in range(NewSize):
                for j in range(NewSize):
                    A11[i][j] = A[i][j]

            for i in range(NewSize):
                for j in range(NewSize):
                    A12[i][j] = A[i][NewSize + j]

            for i in range(NewSize):
                for j in range(NewSize):
                    A21[i][j] = A[NewSize + i][j]

            for i in range(NewSize):
                for j in range(NewSize):
                    A22[i][j] = A[NewSize + i][NewSize + j]

            for i in range(NewSize):
                for j in range(NewSize):
                    B11[i][j] = B[i][j]

            for i in range(NewSize):
                for j in range(NewSize):
                    B12[i][j] = B[i][NewSize + j]

            for i in range(NewSize):
                for j in range(NewSize):
                    B21[i][j] = B[NewSize + i][j]

            for i in range(NewSize):
                for j in range(NewSize):
                    B22[i][j] = B[NewSize + i][NewSize + j]

            # Se realizan las operaciones necesarias para el algoritmo de Strassen
            Operaciones.Plus(A11, A22, Helper1, NewSize, NewSize);
            Operaciones.Plus(B11, B22, Helper2, NewSize, NewSize);
            StrassenNaiv.strassen_naiv_step(Helper1, Helper2, Aux1, NewSize, m);
            Operaciones.Plus(A21, A22, Helper1, NewSize, NewSize);
            StrassenNaiv.strassen_naiv_step(Helper1, B11, Aux2, NewSize, m);
            Operaciones.Minus(B12, B22, Helper1, NewSize, NewSize);
            StrassenNaiv.strassen_naiv_step(A11, Helper1, Aux3, NewSize, m);
            Operaciones.Minus(B21, B11, Helper1, NewSize, NewSize);
            StrassenNaiv.strassen_naiv_step(A22, Helper1, Aux4, NewSize, m);
            Operaciones.Plus(A11, A12, Helper1, NewSize, NewSize);
            StrassenNaiv.strassen_naiv_step(Helper1, B22, Aux5, NewSize, m);
            Operaciones.Minus(A21, A11, Helper1, NewSize, NewSize);
            Operaciones.Plus(B11, B12, Helper2, NewSize, NewSize);
            StrassenNaiv.strassen_naiv_step(Helper1, Helper2, Aux6, NewSize, m);
            Operaciones.Minus(A12, A22, Helper1, NewSize, NewSize);
            Operaciones.Plus(B21, B22, Helper2, NewSize, NewSize);
            StrassenNaiv.strassen_naiv_step(Helper1, Helper2, Aux7, NewSize, m);
            Operaciones.Plus(Aux1, Aux4, ResultPart11, NewSize, NewSize);
            Operaciones.Minus(ResultPart11, Aux5, ResultPart11, NewSize, NewSize);
            Operaciones.Plus(ResultPart11, Aux7, ResultPart11, NewSize, NewSize);
            Operaciones.Plus(Aux3, Aux5, ResultPart12, NewSize, NewSize);
            Operaciones.Plus(Aux2, Aux4, ResultPart21, NewSize, NewSize);
            Operaciones.Plus(Aux1, Aux3, ResultPart22, NewSize, NewSize);
            Operaciones.Minus(ResultPart22, Aux2, ResultPart22, NewSize, NewSize);
            Operaciones.Plus(ResultPart22, Aux6, ResultPart22, NewSize, NewSize);

            # Se copian los resultados a la matriz Result
            for i in range(NewSize):
                for j in range(NewSize):
                    Result[i][j] = ResultPart11[i][j]

            for i in range(NewSize):
                for j in range(NewSize):
                    Result[i][NewSize + j] = ResultPart12[i][j]

            for i in range(NewSize):
                for j in range(NewSize):
                    Result[NewSize + i][j] = ResultPart21[i][j]

            for i in range(NewSize):
                for j in range(NewSize):
                    Result[NewSize + i][NewSize + j] = ResultPart22[i][j]

        # Si N no cumple con las condiciones para el algoritmo de Strassen, se utiliza el algoritmo estándar
        else:
            NaivStandard.run(A, B, Result, N, N, N)
