import java.io.File;
import java.nio.file.Paths;
import java.util.List;
import java.util.Scanner; // <--- ¡NUEVO IMPORT!

public class MainRadixSort {

    public static void main(String[] args) {
        
        
        
        
        Scanner scanner = new Scanner(System.in);

        
        System.out.print("Nombre del archivo ordenando");
        
        
        String nombreArchivoSalida = scanner.nextLine();
        
        
        
        
        
        String rutaDirectorioSalida = "C:\\TrabajosGabriela\\2 Radix Sort\\datosOrdenados";
        
        File directorio = new File(rutaDirectorioSalida);
        if (!directorio.exists()) {
            boolean creado = directorio.mkdirs();
            if (creado) {
                System.out.println("Directorio creado: " + rutaDirectorioSalida);
            }
        }
        
        String rutaSalidaCompleta = Paths.get(rutaDirectorioSalida, nombreArchivoSalida).toString();
        
        System.out.println("Inicio");

        String ruta = "C:\\TrabajosGabriela\\2 Radix Sort\\resources\\datos.txt";
        
        RadixSort sorter = new RadixSort();

        System.out.println("Leyendo");
        List<Integer> misNumeros = sorter.leerDatos(ruta);
        
        System.out.println("Datos leídos (sin ordenar):");
        sorter.imprimirLista(misNumeros);
        
        System.out.println("Ordenanding");
        sorter.sort(misNumeros);
        
        System.out.println("Datos ordenados:");
        sorter.imprimirLista(misNumeros);
        
        System.out.println("Escribiendo datos ordenados en: ");
        sorter.escribirDatos(rutaSalidaCompleta, misNumeros);

        
        scanner.close();

        System.out.println("Fin");
    }
}