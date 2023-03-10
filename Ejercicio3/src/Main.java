import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;

public class Main {
    public static void main(String[] args) throws IOException {

        //String rutaEntrada = args[0];
        //String rutaSalida = args[1];
        String codiODeco = args[2];
        int desplazamiento = Integer.parseInt(args[3]);

        try {
            for (String line: Files.readAllLines(Paths.get("src\\Archivos\\","Entrada.txt"))) {
                codificarODecodificar(line, desplazamiento, codiODeco);
            }
        } catch (IOException e) {
            System.out.println("No se encontro el archivo.");
            throw new RuntimeException(e);
        }

    }

    public static void codificarODecodificar (String s, int n, String cd) throws IOException {

        String vectorPalabra [] = s.split("");
        char aux[] = new char[vectorPalabra.length];
        String palabraCompleta ="";

        cargarVectorAuxiliar(vectorPalabra, aux);

        if (cd.equalsIgnoreCase("c")){
            palabraCompleta = codificador(aux, n);
            System.out.println("El archivo se codifico correctamente.");
        } else{
            n = n*-1;
            palabraCompleta = decodificador(aux, n);
            System.out.println("El archivo se decodifico correctamente.");
        }

        Files.writeString(Paths.get("src\\Archivos\\","Salida.txt"), palabraCompleta);
    }

    public static void cargarVectorAuxiliar(String[] s, char[] c){
        int cont = 0;

        for (String letra:s){
            c[cont] = letra.charAt(0);
            cont++;
        }
    }

    public static String codificador(char[] aux, int n){

        String palabra="";
        int resto = 0;

        Boolean flag = false;
        //El flag tiene como funcionalidad evitar que el segundo if del for
        // se ejecute cuando ya se ejecuto el primer for.

        for(int i = 0; i < aux.length; i++){

            if(aux[i] != ' ' && aux[i] + n <= 122){
                aux[i] += n;
                flag = true;
            }

            if(aux[i] + n > 122 && flag == false){
                resto = 96 + n - (122 - aux[i]);
                aux[i] = (char) resto;
            }
            flag = false;

            palabra = palabra.concat(String.valueOf(aux[i]));
        }

        return palabra;
    }

    public static String decodificador(char[] aux, int n){

        String palabra="";
        int resto = 0;

        Boolean flag = false;
        //El flag tiene como funcionalidad evitar que el segundo if del for
        // se ejecute cuando ya se ejecuto el primer for.

        for(int i = 0; i < aux.length; i++){


            if(aux[i] != ' ' && aux[i] + n >= 97){
                aux[i] += n;
                flag = true;
            }

            if(aux[i] + n < 97 && flag == false && aux[i] != ' '){

                resto = 123 + n + (aux[i] - 97);
                aux[i] = (char) resto;
            }
            flag = false;

            palabra = palabra.concat(String.valueOf(aux[i]));
        }

        return palabra;
    }

}