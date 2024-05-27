import random

def generar_matriz(size, nombre):
  
  # matriz = [random.randint(100000, 999999) for _ in range(size * size)]

  matriz = [0] * size * size  # Initialize matrix with zeros

  for i in range(size * size):
      x = 100000 + i % 900000  # Generate values from 100000 to 999999 cyclically
      matriz[i] = x

  print(f"Creando: {size}")

  with open(f"matrices/{nombre}.txt", "w") as file:
    for i in range(size):
      row_data = " ".join(str(matriz[i * size + j]) for j in range(size))  
      file.write(row_data + " \n")
  print("DONE!\n")

def cargar_matriz(nombre):
 
  #print("Reading file...")
  with open(f"matrices/{nombre}.txt", "r") as file:
    lines = file.readlines()

  matriz = [[int(value) for value in line.strip().split()] for line in lines]
  #print("DONE!\n")
  return matriz


# Se generan las matrices n*n segun los casos de prueba
casos = [64, 128, 256, 512, 1024, 2048, 4096, 8192]

for i in casos:
    generar_matriz(i, "matriz_" + str(i))

""""
main
matriz = cargar_matriz("matriz_1")

for i in matriz:
    for j in matriz[0]:
        print(f"{j} ", end="")
    print()
"""

