class WinogradOriginal:
    @staticmethod
    def run(A, B, Result, N, P, M):
        upsilon = P % 2
        gamma = P - upsilon
        y = [0.0] * M  # Vector y de tamaño M
        z = [0.0] * N  # Vector z de tamaño N

        # Calcula el vector y
        for i in range(M):
            aux = 0.0
            for j in range(0, gamma, 2):
                aux += A[i][j] * A[i][j+1]
            y[i] = aux

        # Calcula el vector z
        for i in range(N):
            aux = 0.0
            for j in range(0, gamma, 2):
                aux += B[j][i] * B[j+1][i]
            z[i] = aux

        if upsilon == 1:
            """
            P es impar
            Falta el valor A[i][P]*B[P][k] en todas las sumas auxiliares.
            """
            PP = P - 1
            for i in range(M):
                for k in range(N):
                    aux = 0.0
                    for j in range(0, gamma, 2):
                        aux += (A[i][j] + B[j+1][k]) * (A[i][j+1] + B[j][k])
                    Result[i][k] = aux - y[i] - z[k] + A[i][PP] * B[PP][k]
        else:
            """
            P es par
            El resultado se puede calcular con las sumas auxiliares.
            """
            for i in range(M):
                for k in range(N):
                    aux = 0.0
                    for j in range(0, gamma, 2):
                        aux += (A[i][j] + B[j+1][k]) * (A[i][j+1] + B[j][k])
                    Result[i][k] = aux - y[i] - z[k]

        # Liberar memoria asignada dinámicamente
        y = None
        z = None
