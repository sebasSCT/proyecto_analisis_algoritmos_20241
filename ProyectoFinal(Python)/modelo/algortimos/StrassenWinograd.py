import math
from modelo.algortimos.Operaciones import Operaciones
from modelo.algortimos.NaivStandard import NaivStandard

class StrassenWinograd:
    @staticmethod
    def run(A, B, Result, N, P, M):
        # Se calcula el tamaño máximo entre N, P y M
        MaxSize = max(N, P, M)
        
        # Si el tamaño máximo es menor que 16, se ajusta a 16
        if MaxSize < 16:
            MaxSize = 16  # de lo contrario no es posible calcular k
        
        # Se calcula k y m para ajustar el tamaño de las matrices
        k = int((math.log(MaxSize) / math.log(2)) - 4)
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
        
        # Se realiza la multiplicación utilizando el algoritmo de Strassen optimizado con Winograd
        StrassenWinograd.strassen_winograd_step(NewA, NewB, AuxResult, NewSize, m)
        
        # Se extrae el resultado
        for i in range(N):
            for j in range(M):
                Result[i][j] = AuxResult[i][j]
    
    @staticmethod
    def strassen_winograd_step(A, B, Result, N, m):
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
            A1 = [[0.0] * NewSize for _ in range(NewSize)]
            A2 = [[0.0] * NewSize for _ in range(NewSize)]
            B1 = [[0.0] * NewSize for _ in range(NewSize)]
            B2 = [[0.0] * NewSize for _ in range(NewSize)]
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
            Aux8 = [[0.0] * NewSize for _ in range(NewSize)]
            Aux9 = [[0.0] * NewSize for _ in range(NewSize)]
            
            # Se inicializan las submatrices en 0
            for i in range(NewSize):
                for j in range(NewSize):
                    A11[i][j] = A[i][j]
                    A12[i][j] = A[i][NewSize + j]
                    A21[i][j] = A[NewSize + i][j]
                    A22[i][j] = A[NewSize + i][NewSize + j]
                    B11[i][j] = B[i][j]
                    B12[i][j] = B[i][NewSize + j]
                    B21[i][j] = B[NewSize + i][j]
                    B22[i][j] = B[NewSize + i][NewSize + j]
            
            # Se calculan las 4 + 9 variables auxiliares
            Operaciones.Minus(A11, A21, A1, NewSize, NewSize)
            Operaciones.Minus(A22, A1, A2, NewSize, NewSize)
            Operaciones.Minus(B22, B12, B1, NewSize, NewSize)
            Operaciones.Plus(B1, B11, B2, NewSize, NewSize)
            StrassenWinograd.strassen_winograd_step(A11, B11, Aux1, NewSize, m)
            StrassenWinograd.strassen_winograd_step(A12, B21, Aux2, NewSize, m)
            StrassenWinograd.strassen_winograd_step(A2, B2, Aux3, NewSize, m)
            Operaciones.Plus(A21, A22, Helper1, NewSize, NewSize)
            Operaciones.Minus(B12, B11, Helper2, NewSize, NewSize)
            StrassenWinograd.strassen_winograd_step(Helper1, Helper2, Aux4, NewSize, m)
            StrassenWinograd.strassen_winograd_step(A1, B1, Aux5, NewSize, m)
            Operaciones.Minus(A12, A2, Helper1, NewSize, NewSize)
            StrassenWinograd.strassen_winograd_step(Helper1, B22, Aux6, NewSize, m)
            Operaciones.Minus(B21, B2, Helper1, NewSize, NewSize)
            StrassenWinograd.strassen_winograd_step(A22, Helper1, Aux7, NewSize, m)
            Operaciones.Plus(Aux1, Aux3, Aux8, NewSize, NewSize)
            Operaciones.Plus(Aux8, Aux4, Aux9, NewSize, NewSize)
            Operaciones.Plus(Aux1, Aux2, ResultPart11, NewSize, NewSize)
            Operaciones.Plus(Aux9, Aux6, ResultPart12, NewSize, NewSize)
            Operaciones.Plus(Aux8, Aux5, Helper1, NewSize, NewSize)
            Operaciones.Plus(Helper1, Aux7, ResultPart21, NewSize, NewSize)
            Operaciones.Plus(Aux9, Aux5, ResultPart22, NewSize, NewSize)
            
            # Se almacenan los resultados en la matriz "Result"
            for i in range(NewSize):
                for j in range(NewSize):
                    Result[i][j] = ResultPart11[i][j]
                    Result[i][NewSize + j] = ResultPart12[i][j]
                    Result[NewSize + i][j] = ResultPart21[i][j]
                    Result[NewSize + i][NewSize + j] = ResultPart22[i][j]
        else:
            # Si N no cumple con las condiciones para el algoritmo de Strassen, se utiliza el algoritmo estándar
            NaivStandard.run(A, B, Result, N, N, N)
