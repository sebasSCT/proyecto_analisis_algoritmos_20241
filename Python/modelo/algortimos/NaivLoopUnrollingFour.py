class NaivLoopUnrollingFour:
    @staticmethod
    def run(A, B, result, N, M, P):
        for i in range(N):
            for j in range(M):
                aux = 0.0
                if P % 4 == 0:
                    for k in range(0, P, 4):
                        aux += A[i][k] * B[k][j] + A[i][k+1] * B[k+1][j] + A[i][k+2] * B[k+2][j] + A[i][k+3] * B[k+3][j]
                elif P % 4 == 1:
                    PP = P - 1
                    for k in range(0, PP, 4):
                        aux += A[i][k] * B[k][j] + A[i][k+1] * B[k+1][j] + A[i][k+2] * B[k+2][j] + A[i][k+3] * B[k+3][j]
                    aux += A[i][PP] * B[PP][j]
                elif P % 4 == 2:
                    PP = P - 2
                    PPP = P - 1
                    for k in range(0, PP, 4):
                        aux += A[i][k] * B[k][j] + A[i][k+1] * B[k+1][j] + A[i][k+2] * B[k+2][j] + A[i][k+3] * B[k+3][j]
                    aux += A[i][PP] * B[PP][j] + A[i][PPP] * B[PPP][j]
                else:  # P % 4 == 3
                    PP = P - 3
                    PPP = P - 2
                    PPPP = P - 1
                    for k in range(0, PP, 4):
                        aux += A[i][k] * B[k][j] + A[i][k+1] * B[k+1][j] + A[i][k+2] * B[k+2][j] + A[i][k+3] * B[k+3][j]
                    aux += A[i][PP] * B[PP][j] + A[i][PPP] * B[PPP][j] + A[i][PPPP] * B[PPPP][j]
                result[i][j] = aux
