import Matriz, Resultados, time, threading

from modelo.algortimos.NaivOnArray import NaivOnArray
from modelo.algortimos.NaivLoopUnrollingTwo import NaivLoopUnrollingTwo
from modelo.algortimos.NaivLoopUnrollingFour import NaivLoopUnrollingFour
from modelo.algortimos.WinogradOriginal import WinogradOriginal
from modelo.algortimos.WinogradScaled import WinogradScaled
from modelo.algortimos.StrassenNaiv import StrassenNaiv
from modelo.algortimos.StrassenWinograd import StrassenWinograd
from modelo.algortimos.SequentialBlock_III import SequentialBlock_III
from modelo.algortimos.ParallelBlock_III import ParallelBlock_III
from modelo.algortimos.EnhancedParallelBlock_III import EnhancedParallelBlock_III
from modelo.algortimos.SequentialBlock_III import SequentialBlock_III
from modelo.algortimos.ParallelBlock_IV import ParallelBlock_IV
from modelo.algortimos.SequentialBlock_IV import SequentialBlock_IV
from modelo.algortimos.EnhancedParallelBlock_IV import EnhancedParallelBlock_IV
from modelo.algortimos.SequentialBlock_V import SequentialBlock_V
from modelo.algortimos.ParallelBlock_V import ParallelBlock_V

def ejecutar ():
    for caso in casos:

        matriz = Matriz.cargar_matriz("matriz_" + str(caso))
        
        print('caso: ' + str(caso) + " * " + str(caso))
        
        Resultados.guardar(str(caso) + ";", ruta)

        for i in range(15):

            inicio = time.time()

            ejecutar_algoritmos(i, matriz, matriz, result = [[0 for _ in range(caso)] for _ in range(caso)])

            final = time.time()

            total = final - inicio

            print(algoritmos[i][3:].strip() + ": " + str(total))

            Resultados.guardar(algoritmos[i][3:].strip() + "," + str(total) + ";", ruta)
        
        Resultados.guardar("\n", ruta)

def ejecutar_algoritmos (indice, m, m_, result):
    match indice:
        case 0:
            NaivOnArray.run(m, m_, result, len(m), len(m), len(m))
        case 1:
            NaivLoopUnrollingTwo.run(m, m_, result, len(m), len(m), len(m))
        case 2:
            NaivLoopUnrollingFour.run(m, m_, result, len(m), len(m), len(m))
        case 3:
            WinogradOriginal.run(m, m_, result, len(m), len(m), len(m))
        case 4:
            WinogradScaled.run(m, m_, result, len(m), len(m), len(m))
        case 5:
            StrassenNaiv.run(m, m_, result, len(m), len(m), len(m))
        case 6:
            StrassenWinograd.run(m, m_, result, len(m), len(m), len(m))
        case 7:
            SequentialBlock_III.run(m, m_, result)
        case 8:
            thread = threading.Thread(target=ParallelBlock_III.run, args=(m, m_, result))
            thread.start;
        case 9:
            thread = threading.Thread(target=EnhancedParallelBlock_III.run, args=(m, m_, result, len(m)))
            thread.start;
        case 10:
            SequentialBlock_IV.run(m, m_, result)
        case 11:
            thread = threading.Thread(target=ParallelBlock_IV.run, args=(m, m_, result))
            thread.start;
        case 12: 
            thread = threading.Thread(target=EnhancedParallelBlock_IV.run, args=(m, m_, result, len(m)))
            thread.start;
        case 13:
            SequentialBlock_V.run(m, m_, result)
        case 14:
            thread = threading.Thread(target=ParallelBlock_V.run, args=(m, m_, result))
            thread.start;
            
# main
casos = [64, 128, 256, 512, 1024, 2048, 4096, 8192]
algoritmos = ["1. NaivOnArray", "2. NaivLoopUnrollingTwo", "3. NaivLoopUnrollingFour", 
                "4. WinogradOriginal", "5. WinogradScaled", "6. StrassenNaiv", 
                "7. StrassenWinograd", "8. Sequential block_III", "9. Parallel block_III", "10. Enhanced Parallel Block_III", 
                "11. SequentialBlock_IV", "12. ParallelBlock_IV", "13. Enhanced Parallel Block_IV", 
                "15. SequentialBlock_V", "16. ParallelBlock_V"]
ruta = "matrices/resultados.txt"

ejecutar()
    

