

import java.util.Scanner;

import javax.swing.JOptionPane;

import Modelo.algoritmos.*;


public class App
{

    private static double start_time, stop_time;
    private static Thread t;
    private static Scanner s = new Scanner(System.in);

    public static void main(String[] args) 
    {
        JOptionPane.showMessageDialog(null, "hola", "null", 1   );
        // double[][] m = {{3,3,3},{3,3,3},{3,3,3}};
        // double[][] m_ = m;
        double[][] m = Matriz.cargar_matriz("matriz_100");
        double[][] m_ = m;
        
        int opc = 0, i = 1;
        String msg;

        while(i <= 16)
        {

            double[][] result = new double[m.length][m.length];

            // System.out.println("Metodo: ");
            // opc = s.nextInt();

            start_time = System.nanoTime();

            msg = metodo(i, m, m_, result);

            stop_time = System.nanoTime();

            double total_time = stop_time - start_time;
            System.out.println("\nTiempo: " + (double)(total_time / 1000000000) + "s\n\n");
            
            i++;
            //imprimir(result);

        }
    }
    
    private static void imprimir (double[][] m)

    {
        for (double[] a : m)
        {
            for (double b : a)
            {
                System.out.print(b + " ");
            }
            System.out.println();
        }
    }

    private static String metodo (int opc, double[][] m, double[][] m_, double[][] result)
    {
        switch (opc)
        {
            case 1:
                System.out.println("1. NaivStandard");
                NaivStandard.run(m, m_, result, m.length, m.length, m.length);
                return "";

            case 2:
                System.out.println("2. NaivOnArray");
                NaivOnArray.run(m, m_, result, m.length, m.length, m.length);
                return "";
            
            case 3:
                System.out.println("3. NaivKahan");  
                NaivKaha.run(m, m_, result, m.length, m.length, m.length);
                return "";
            
            case 4:
                System.out.println("4. NaivLoopUnrollingTwo");  
                NaivLoopUnrollingTwo.run(m, m_, result, m.length, m.length, m.length);
                return "";
            
            case 5:
                System.out.println("5. NaivLoopUnrollingThree");  
                NaivLoopUnrollingThree.run(m, m_, result, m.length, m.length, m.length);
                return "";
            
            case 6:
                System.out.println("6. NaivLoopUnrollingFour");  
                NaivLoopUnrollingFour.run(m, m_, result, m.length, m.length, m.length);
                return "";
            
            case 7:
                System.out.println("7. WinogradOriginal");  
                WinogradOriginal.run(m, m_, result, m.length, m.length, m.length);
                return "";
            
            case 8:
                System.out.println("8. WinogradScaled");  
                WinogradScaled.run(m, m_, result, m.length, m.length, m.length);
                return "";
            
            case 9:
                System.out.println("9. StrassenNaiv");  
                StrassenNaiv.run(m, m_, result, m.length, m.length, m.length);
                return "";
            
            case 10:
                System.out.println("10. StrassenWinograd");  
                StrassenWinograd.run(m, m_, result, m.length, m.length, m.length);
                return "";
            
            case 11:
                System.out.println("11. SequentialBlock_III");  
                SequentialBlock_III.run(m, m_, result);
                return "";
            
            case 12:
                System.out.println("12. ParallelBlock_III");   
                t = new Thread(new ParallelBlock_III(m,m_,result));
                t.start();
                return "";
            
            case 13:
                System.out.println("13. SequentialBlock_IV");  
                SequentialBlock_IV.run(m, m_, result);
                return "";
            
            case 14:
                System.out.println("14. ParallelBlock_IV");  
                t = new Thread(new ParallelBlock_IV(m,m_,result));
                t.start();
                return "";
            
            case 15:
                System.out.println("15. SequentialBlock_V");  
                SequentialBlock_V.run(m, m_, result);
                return "";
            
            case 16:
                System.out.println("16. ParallelBlock_V");  
                t = new Thread(new ParallelBlock_V(m,m_,result));
                t.start();
                return "";
            
        }

        return "no";
    }
}
