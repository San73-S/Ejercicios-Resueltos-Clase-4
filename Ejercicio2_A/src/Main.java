import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;

public class Main {
    public static void main(String[] args) {

        String ruta = args[0];

        if (args[1].equalsIgnoreCase("S")){
            sumaDesdeArchivo(ruta);
        }else{
            multiplicacionDesdeArchivo(ruta);
        }
    }

    public static void sumaDesdeArchivo(String ruta){

        int sumaArchivo = 0;

        System.out.println("\nSuma de datos del archivo.");
        try {
            for (String line: Files.readAllLines(Paths.get(ruta))) {
                sumaArchivo += Integer.parseInt(line);
            }
        } catch (IOException e) {
            System.out.println("Ocurrio un error en la lectura del archivo.");
            throw new RuntimeException(e);
        }

        System.out.println("la suma de los datos que contiene el archivo es: " + sumaArchivo);
    }

    public static void multiplicacionDesdeArchivo(String ruta){

        int multArchivo = 1;

        System.out.println("\nMultiplicacion de datos del archivo");
        try {
            for (String line: Files.readAllLines(Paths.get(ruta))) {
                multArchivo *= Integer.parseInt(line);
            }
        } catch (IOException e) {
            System.out.println("Ocurrio un error en la lectura del archivo.");
            throw new RuntimeException(e);
        }

        System.out.println("la multiplicacion de los datos que contiene el archivo es: " + multArchivo);
    }
}