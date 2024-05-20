class NaivStandard:
    @staticmethod
    def run(A, B, result, N, P, M):
        for i in range(N):
            for j in range(M):
                aux = 0.0
                for k in range(P):
                    aux += A[i][k] * B[k][j]
                result[i][j] = aux
