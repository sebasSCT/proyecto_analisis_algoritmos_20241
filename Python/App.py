import Matriz, Resultados, time

casos = [100, 200]
algoritmos = ["1. NaivStandard", "2. NaivOnArray", "3. NaivKahan", "4. NaivLoopUnrollingTwo", "5. NaivLoopUnrollingThree", "6. NaivLoopUnrollingFour", "7. WinogradOriginal", "8. WinogradScaled", "9. StrassenNaiv", "10. StrassenWinograd", "11. SequentialBlock_III", "12. ParallelBlock_III", "13. SequentialBlock_IV", "14. ParallelBlock_IV", "15. SequentialBlock_V", "16. ParallelBlock_V"]
ruta = "matrices/resultados.txt"

for caso in casos:

    matriz = Matriz.cargar_matriz("matriz_" + str(caso))
    
    print('caso: ' + str(caso) + " * " + str(caso))
    
    Resultados.guardar(str(caso) + ";", ruta)

    for i in range(16):

        inicio = time.time()

        #Algortimos

        final = time.time()

        total = final - inicio

        Resultados.guardar(algoritmos[i][3:].strip() + "," + str(total) + ";", ruta)
    
    Resultados.guardar(">", ruta)

    


    

