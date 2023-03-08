import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;

public class Main {
    public static void main(String[] args) throws IOException {
        /*char arroba = ('A');
        int valor = arroba;
        arroba += 1;

        System.out.println(valor + "  " + arroba);*/

        String rutaEntrada = args[0];
        String rutaSalida = args[1];
        int desplazamiento = Integer.parseInt(args[3]);

        System.out.println(rutaEntrada + "\n" +rutaSalida + " \n" + args[2] + "\n" + args[3]);

        try {
            for (String line: Files.readAllLines(Paths.get(rutaEntrada))) {
                codificar(line, desplazamiento);
                System.out.print(line + " ");
            }
        } catch (IOException e) {
            System.out.println("No se encontro el archivo.");
            throw new RuntimeException(e);
        }

    }

    public static void codificar (String s, int n){

        String vectorPalabra [] = s.split("");
        char aux[] = new char[vectorPalabra.length];
        int cont = 0;
        int valorChar = 0;

        for (String letra:vectorPalabra){
            aux[cont] = letra.charAt(0);
            cont++;
        }

        for(int i = 0; i < aux.length; i++){
            valorChar = aux[i];
            aux[i] += n;
            System.out.print(aux[i]);
        }

    }

}