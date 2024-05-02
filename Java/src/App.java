

import Modelo.algoritmos.*;
import Modelo.herramientas.Guardar;


public class App
{

    private static double start_time, stop_time;
    private static Thread t;

    public static void main(String[] args) 
    {
        // int[] casos = {100, 200, 400, 800, 1000, 2000, 3000, 4000};
            int[] casos = {100, 200};
            String[] algoritmos = {"1. NaivStandard", "2. NaivOnArray", "3. NaivKahan", "4. NaivLoopUnrollingTwo", "5. NaivLoopUnrollingThree", "6. NaivLoopUnrollingFour", "7. WinogradOriginal", "8. WinogradScaled", "9. StrassenNaiv", "10. StrassenWinograd", "11. SequentialBlock_III", "12. ParallelBlock_III", "13. SequentialBlock_IV", "14. ParallelBlock_IV", "15. SequentialBlock_V", "16. ParallelBlock_V"};
        
        for (int caso : casos)
        {
            double[][] m = Matriz.cargar_matriz("matriz_" + caso);

            System.out.println("Caso: " + caso + " * " + caso + "\n");
            Guardar.guardar(caso + ";" , "src/matrices/resultados.txt");

            for (int i = 0; i < 16; i++)
            {
                double[][] result = new double[m.length][m.length];

                System.out.println(algoritmos[i]);

                start_time = System.nanoTime();

                metodo(i + 1, m, m, result);

                stop_time = System.nanoTime();

                double total_time = stop_time - start_time;

                Guardar.guardar(algoritmos[i].substring(3).trim() + "," + (double)(total_time / 1000000000) + ";", "src/matrices/resultados.txt");

                System.out.println("\nTiempo: " + (double)(total_time / 1000000000) + "s\n\n");
            }

            Guardar.guardar(">" , "src/matrices/resultados.txt");

        }

        
    }
    
    private static void metodo (int opc, double[][] m, double[][] m_, double[][] result)
    {
        switch (opc)
        {
            case 1:
                NaivStandard.run(m, m_, result, m.length, m.length, m.length);
                break;

            case 2:
                NaivOnArray.run(m, m_, result, m.length, m.length, m.length);
                break;
            
            case 3:
                NaivKaha.run(m, m_, result, m.length, m.length, m.length);
                break;
            
            case 4:
                NaivLoopUnrollingTwo.run(m, m_, result, m.length, m.length, m.length);
                break;
            
            case 5:
                NaivLoopUnrollingThree.run(m, m_, result, m.length, m.length, m.length);
                break;
            
            case 6:
                NaivLoopUnrollingFour.run(m, m_, result, m.length, m.length, m.length);
                break;
            
            case 7:
                WinogradOriginal.run(m, m_, result, m.length, m.length, m.length);
                break;
            
            case 8:
                WinogradScaled.run(m, m_, result, m.length, m.length, m.length);
                break;
            
            case 9:
                StrassenNaiv.run(m, m_, result, m.length, m.length, m.length);
                break;
            
            case 10:
                StrassenWinograd.run(m, m_, result, m.length, m.length, m.length);
                break;
            
            case 11:
                SequentialBlock_III.run(m, m_, result);
                break;
            
            case 12:
                t = new Thread(new ParallelBlock_III(m,m_,result));
                t.start();
                break;
            
            case 13:
                SequentialBlock_IV.run(m, m_, result);
                break;
            
            case 14:
                t = new Thread(new ParallelBlock_IV(m,m_,result));
                t.start();
                break;
            
            case 15:
                SequentialBlock_V.run(m, m_, result);
                break;
            
            case 16:
                t = new Thread(new ParallelBlock_V(m,m_,result));
                t.start();
                break;           
        }

    }
}
