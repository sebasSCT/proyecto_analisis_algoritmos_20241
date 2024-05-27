package app;

import controller.AlgoritmosImp;
import model.herramientas.Archivo;


public class Ejecucion
{

    private static double start_time, stop_time;
    private static Thread t;
    private static AlgoritmosImp algoritmos = new AlgoritmosImp();

    public static void main(String[] args) 
    {

//            int[] casos = {64, 128, 256, 512, 1024, 2048, 4096, 8192};
            int[] casos = {3};

            String[] algoritmos = {"1. NaivOnArray", "2. NaivLoopUnrollingTwo", "3. NaivLoopUnrollingFour", 
                                    "4. WinogradOriginal", "5. WinogradScaled", "6. StrassenNaiv", 
                                    "7. StrassenWinograd", "8. Sequential block_III", "9. Parallel block_III", "10. Enhanced Parallel Block_III", 
                                    "11. SequentialBlock_IV", "12. ParallelBlock_IV", "13. Enhanced Parallel Block_IV", 
                                    "14. SequentialBlock_V", "15. ParallelBlock_V"};
        
        for (int caso : casos) {
            double[][] m = Matriz.cargar_matriz("matriz_" + caso);


            System.out.println("Caso: " + caso + " * " + caso + "\n");
            Archivo.guardar(caso + ";", "src/main/resources/resultados_Java.txt");

            for (int i = 8; i < 9; i++)
            {
                double[][] result = new double[m.length][m.length];

                System.out.println(algoritmos[i]);

                start_time = System.nanoTime();

                metodo(i + 1, m, m, result);

                stop_time = System.nanoTime();

                double total_time = stop_time - start_time;

                Archivo.guardar(algoritmos[i].substring(3).trim() + "," + (double) (total_time / 1000000000) + ";", "src/main/resources/resultados_Java.txt");

                System.out.println("\nTiempo: " + (double) (total_time / 1000000000) + "s\n\n");
            }

            Archivo.guardar("\n", "src/main/resources/resultados_Java.txt");

        }
    }
    
    private static void metodo (int opc, double[][] m, double[][] m_, double[][] result)
    {
        switch (opc)
        {
            case 1:
                algoritmos.NaivOnArray(m, m_, result, m.length, m.length, m.length);
                break;

            case 2:
                algoritmos.NaivLoopUnrollingTwo(m, m_, result, m.length, m.length, m.length);
                break;
            
            case 3:
                algoritmos.NaivLoopUnrollingFour(m, m_, result, m.length, m.length, m.length);
                break;
            
            case 4:
                algoritmos.WinogradOriginal(m, m_, result, m.length, m.length, m.length);
                break;
            
            case 5:
                algoritmos.WinogradScaled(m, m_, result, m.length, m.length, m.length);
                break;
            
            case 6:
                algoritmos.StrassenNaiv(m, m_, result, m.length, m.length, m.length);
                break;
            
            case 7:
                algoritmos.StrassenWinograd(m, m_, result, m.length, m.length, m.length);
                break;
            
            case 8:
                algoritmos.SequentialBlock_III(m, m_, result);
                break;
            
            case 9:
                t = new Thread(algoritmos.ParallelBlock_III(m, m_, result));
                t.start();
                break;
            
            case 10:
                algoritmos.EnhancedParallelBlock_III(result, m, m_, m.length);
                break;
            
            case 11:
                algoritmos.SequentialBlock_IV(m, m_, result);
                break;
            
            case 12:
                t = new Thread(algoritmos.ParallelBlock_IV(m, m_, result));
                t.start();
                break;
            
            case 13:
                algoritmos.EnhancedParallelBlock_IV(result, m, m_, m.length);
                break;
            
            case 14:
                algoritmos.SequentialBlock_V(m, m_, result);
                break;
            
            case 15:
                t = new Thread(algoritmos.ParallelBlock_V(m, m_, result));
                t.start();
                break;
        }

    }
}
