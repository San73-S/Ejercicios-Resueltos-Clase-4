import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;

public class Main {
    public static void main(String[] args) throws IOException {

        int sumaArchivo = 0;
        String ruta = args[0];

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
}