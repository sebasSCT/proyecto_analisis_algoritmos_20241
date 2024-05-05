class SequentialBlock_V:
    @staticmethod
    def run(A, B, C):
        # Iterar sobre los bloques de la matriz C
        for i1 in range(0, len(A), len(B)):
            for j1 in range(0, len(A), len(B)):
                for k1 in range(0, len(A), len(B)):
                    # Iterar sobre los elementos de cada bloque
                    for i in range(i1, min(i1 + len(B), len(A))):
                        for j in range(j1, min(j1 + len(B), len(A))):
                            for k in range(k1, min(k1 + len(B), len(A))):
                                # Calcular el producto de los elementos y acumular en el resultado
                                C[k][i] += A[k][j] * B[j][i]
