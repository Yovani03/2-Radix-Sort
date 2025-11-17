import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class RadixSort {

    public List<Integer> leerDatos(String rutaArchivo) {
        List<Integer> numeros = new ArrayList<>();
        
        try (BufferedReader reader = new BufferedReader(new FileReader(rutaArchivo))) {
            
            String linea = reader.readLine();
            
            if (linea != null && !linea.isEmpty()) {
                String[] valores = linea.split(" ");
                
                for (String valor : valores) {
                    numeros.add(Integer.parseInt(valor.trim()));
                }
            } else {
                System.out.println("Datos no validos");
            }

        } catch (IOException e) {
            System.err.println("Error al leer el archivo: ");
            e.printStackTrace();
        } catch (NumberFormatException e) {
            System.err.println("Los datos deben de ser enteros");
            e.printStackTrace();
        }
        
        return numeros;
    }

    public void imprimirLista(List<Integer> lista) {
        System.out.println(lista);
    }

    public void sort(List<Integer> lista) {
        if (lista == null || lista.size() == 0) {
            return;
        }

        int[] arr = new int[lista.size()];
        for (int i = 0; i < lista.size(); i++) {
            arr[i] = lista.get(i);
        }

        int max = getMax(arr);

        for (int exp = 1; max / exp > 0; exp *= 10) {
            countingSort(arr, exp);
        }

        lista.clear();
        for (int val : arr) {
            lista.add(val);
        }
    }

    private int getMax(int[] arr) {
        int max = arr[0];
        for (int i = 1; i < arr.length; i++) {
            if (arr[i] > max) {
                max = arr[i];
            }
        }
        return max;
    }

    private void countingSort(int[] arr, int exp) {
        int n = arr.length;
        int[] output = new int[n];
        int[] count = new int[10];
        Arrays.fill(count, 0);

        for (int i = 0; i < n; i++) {
            int digit = (arr[i] / exp) % 10;
            count[digit]++;
        }

        for (int i = 1; i < 10; i++) {
            count[i] += count[i - 1];
        }

        for (int i = n - 1; i >= 0; i--) {
            int digit = (arr[i] / exp) % 10;
            output[count[digit] - 1] = arr[i];
            count[digit]--;
        }

        System.arraycopy(output, 0, arr, 0, n);
    }

    public void escribirDatos(String rutaArchivo, List<Integer> lista) {
        try (BufferedWriter writer = new BufferedWriter(new FileWriter(rutaArchivo))) {
            for (int i = 0; i < lista.size(); i++) {
                writer.write(Integer.toString(lista.get(i)));
                if (i < lista.size() - 1) {
                    writer.write(" ");
                }
            }
        } catch (IOException e) {
            System.err.println("Error ");
            e.printStackTrace();
        }
    }
}