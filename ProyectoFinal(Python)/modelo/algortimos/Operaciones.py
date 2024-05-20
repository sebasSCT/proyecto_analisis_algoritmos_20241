class Operaciones:
    @staticmethod
    def Plus(A, B, Result, N, M):
        for i in range(N):
            for j in range(M):
                Result[i][j] = A[i][j] + B[i][j]

    @staticmethod
    def Minus(A, B, Result, N, M):
        for i in range(N):
            for j in range(M):
                Result[i][j] = A[i][j] - B[i][j]

    @staticmethod
    def max(x, y):
        if x < y:
            return y
        else:
            return x

    @staticmethod
    def Max(x, y):
        if x < y:
            return y
        else:
            return x

    @staticmethod
    def Abs(a):
        if a < 0:
            return -a
        return a

    @staticmethod
    def NormInf(A, N, P):
        Norm = 0.0
        for i in range(N):
            aux = 0.0
            for j in range(P):
                aux += Operaciones.Abs(A[i][j])
            Norm = Operaciones.Max(Norm, aux)
        return Norm

    @staticmethod
    def MultiplyWithScalar(A, Result, N, M, alpha):
        for i in range(N):
            for j in range(M):
                Result[i][j] = alpha * A[i][j]
