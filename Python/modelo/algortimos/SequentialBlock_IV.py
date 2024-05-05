class SequentialBlock_IV:
    @staticmethod
    def run(A, B, C):
        for i1 in range(0, len(A), len(B)):
            for j1 in range(0, len(A), len(B)):
                for k1 in range(0, len(A), len(B)):
                    for i in range(i1, min(i1 + len(B), len(A))):
                        for j in range(j1, min(j1 + len(B), len(A))):
                            for k in range(k1, min(k1 + len(B), len(A))):
                                C[i][k] += A[i][j] * B[j][k]
