class NaivLoopUnrollingTwo:
    @staticmethod
    def run(A, B, result, N, P, M):
        for i in range(N):
            for j in range(M):
                aux = 0.0
                if P % 2 == 0:
                    for k in range(0, P, 2):
                        aux += A[i][k] * B[k][j] + A[i][k+1] * B[k+1][j]
                else:  # P es impar
                    PP = P - 1
                    for k in range(0, PP, 2):
                        aux += A[i][k] * B[k][j] + A[i][k+1] * B[k+1][j]
                    aux += A[i][PP] * B[PP][j]
                result[i][j] = aux
