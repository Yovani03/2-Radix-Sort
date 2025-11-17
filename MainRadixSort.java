import java.util.List;

public class MainRadixSort {

    public static void main(String[] args) {
        System.out.println("Inicio del Programa Radix Sort");

        String ruta = "C:\\TrabajosGabriela\\2 Radix Sort\\resources\\datos.txt";
        
        RadixSort sorter = new RadixSort();

        System.out.println("Leyendo datos de '" + ruta + "'...");
        List<Integer> misNumeros = sorter.leerDatos(ruta);
        
        System.out.println("Datos leídos (sin ordenar):");
        sorter.imprimirLista(misNumeros);
        
        System.out.println("Ordenanding");
        sorter.sort(misNumeros);
        
        System.out.println("Datos ordenados:");
        sorter.imprimirLista(misNumeros);

        
    }
}