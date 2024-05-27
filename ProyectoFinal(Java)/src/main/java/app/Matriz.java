package app;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
//import java.util.Random;

public class Matriz 
{
   
    public static void main(String[] args) 
    {
//        int[] casos = {64, 128, 256, 512, 1024, 2048, 4096, 8192};
        int[] casos = {1024};

        for (int i : casos)
        {
            generar(i, "matriz_" + i);
        }
        
    }

    private static void generar (int size, String file)
    {
        // Random random = new Random();
        int[] matriz = new int[size * size];
        
        for (int i = 0, x = 100000; i < size * size; i++, x++) 
        {
            if (x >= 999999)
            {
                x = 100000;
            }
            matriz[i] = x;
            // matriz[i] = 100000 + random.nextInt(900000);
        }
        
        try (FileWriter fileWriter = new FileWriter(getPath("src/main/resources/matrices/" + file + ".txt"))) {
            System.out.println("Creando: " + size);
            for (int i = 0; i < size; i++) {
                StringBuilder rowBuilder = new StringBuilder();
                for (int j = 0; j < size; j++) {
                    rowBuilder.append(matriz[i * size + j]).append(" ");
                }
                fileWriter.write(rowBuilder.toString().trim() + "\n");
                // System.out.println("Creando: " + (i + 1) + "/" + size);
            }
            System.out.println("HECHO!\n");
        } catch (IOException e) {
            e.printStackTrace();
        }

    }

    public static double[][] cargar_matriz (String file)
    {
        List<String> lines = new ArrayList<>();
        
        try (BufferedReader reader = new BufferedReader(new FileReader(getPath("src/main/resources/matrices/" + file + ".txt")))) {
            
            String line;
            while ((line = reader.readLine()) != null) {
                lines.add(line);
            }
            
        } catch (IOException e) {
            e.printStackTrace();
        }
        
        double[][] matriz = new double[lines.size()][];
        for (int i = 0; i < lines.size(); i++) {
            String[] values = lines.get(i).trim().split("\\s+");
            matriz[i] = new double[values.length];
            for (int j = 0; j < values.length; j++) {
                matriz[i][j] = Integer.parseInt(values[j]);
            }
        }
        
        return matriz;
    }
    
    private static String getPath ( String ruta )
	{
		String raiz = System.getProperty("user.dir");
		String filePath = raiz + "/" + ruta;
		return filePath;
	}
}
