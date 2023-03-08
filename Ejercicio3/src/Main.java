import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.nio.file.StandardOpenOption;

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
                codificar(line, desplazamiento, rutaSalida);
            }
        } catch (IOException e) {
            System.out.println("No se encontro el archivo.");
            throw new RuntimeException(e);
        }

    }

    public static void codificar (String s, int n, String rutaSal) throws IOException {

        String vectorPalabra [] = s.split("");
        char aux[] = new char[vectorPalabra.length];
        int cont = 0, valorChar = 0, resto = 0;
        String palabraCompleta ="";

        Boolean flag = false;
        //El flag tiene como funcionalidad evitar que el segundo if del for
        // se ejecute cuando ya se ejecuto el primer for.

        for (String letra:vectorPalabra){
            aux[cont] = letra.charAt(0);
            cont++;
        }

        for(int i = 0; i < aux.length; i++){

            if(aux[i] != ' ' && aux[i] + n <= 122) {
                valorChar = aux[i];
                aux[i] += n;
                flag = true;
            }

            if(aux[i] + n > 122 && flag == false){
                resto = 96 + n - (122 - aux[i]);
                aux[i] = (char) resto;
            }
            flag = false;

            palabraCompleta = palabraCompleta.concat(String.valueOf(aux[i]));
            System.out.print(aux[i]);
        }

        Files.writeString(Paths.get(rutaSal), palabraCompleta);

    }

}