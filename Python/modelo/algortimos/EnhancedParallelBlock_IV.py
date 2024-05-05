
class EnhancedParallelBlock_IV:

    BLOCK_SIZE = 128  # Define block size

    def run(self, A, B, C, size):
        for i1 in range(0, size // 2, self.BLOCK_SIZE):
            for j1 in range(0, size, self.BLOCK_SIZE):
                for k1 in range(0, size, self.BLOCK_SIZE):
                    for i in range(i1, min(i1 + self.BLOCK_SIZE, size)):
                        for j in range(j1, min(j1 + self.BLOCK_SIZE, size)):
                            for k in range(k1, min(k1 + self.BLOCK_SIZE, size)):
                                A[i][j] += B[i][k] * C[k][j]

        # Second half of the matrix (optional for parallelization with additional threads)
        for i1 in range(size // 2, size, self.BLOCK_SIZE):
            for j1 in range(0, size, self.BLOCK_SIZE):
                for k1 in range(0, size, self.BLOCK_SIZE):
                    for i in range(i1, min(i1 + self.BLOCK_SIZE, size)):
                        for j in range(j1, min(j1 + self.BLOCK_SIZE, size)):
                            for k in range(k1, min(k1 + self.BLOCK_SIZE, size)):
                                A[i][j] += B[i][k] * C[k][j]