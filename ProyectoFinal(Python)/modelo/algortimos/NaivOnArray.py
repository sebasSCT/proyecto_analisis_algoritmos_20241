class NaivOnArray:
    @staticmethod
    def run(A, B, result, N, P, M):
        for i in range(N):
            for j in range(M):
                result[i][j] = 0.0
                for k in range(P):
                    result[i][j] += A[i][k] * B[k][j]
