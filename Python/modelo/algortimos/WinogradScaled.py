from modelo.algortimos.Operaciones import Operaciones
from modelo.algortimos.WinogradOriginal import WinogradOriginal
import math

class WinogradScaled:
    @staticmethod
    def run(A, B, Result, N, P, M):
        # Crear copias escaladas de A y B
        CopyA = [[0.0] * P for _ in range(N)]
        CopyB = [[0.0] * M for _ in range(P)]
        
        # Factores de escalado
        a = Operaciones.NormInf(A, N, P)  # Norma infinito de A
        b = Operaciones.NormInf(B, P, M)  # Norma infinito de B
        lambda_val = int(round(0.5 + math.log(b/a) / math.log(4)))  # Factor de escala lambda
        
        # Escalado
        Operaciones.MultiplyWithScalar(A, CopyA, N, P, 2 ** lambda_val)
        Operaciones.MultiplyWithScalar(B, CopyB, P, M, 2 ** -lambda_val)
        
        # Utilizar Winograd con las matrices escaladas
        WinogradOriginal.run(CopyA, CopyB, Result, N, P, M)
