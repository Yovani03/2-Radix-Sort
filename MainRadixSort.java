import java.util.List;

public class MainRadixSort {

    public static void main(String[] args) {
        System.out.println("Radix Sort");

        String ruta = "C:\\TrabajosGabriela\\2 Radix Sort\\resources\\datos.txt";
        
        RadixSort sorter = new RadixSort();

        System.out.println("Leyendo datos ");
        List<Integer> misNumeros = sorter.leerDatos(ruta);
        
        System.out.println("Datos leídos :");
        sorter.imprimirLista(misNumeros);
        
        System.out.println("Fin del Programa");
    }
}