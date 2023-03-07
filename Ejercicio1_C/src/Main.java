import java.util.Scanner;

public class Main {
    /*lo mismo, pero usando los parámetros si hay alguno (como en a) y haciendo (b)
si no detecta ninguno. Vea si con una función puede evitar repetir código*/

    public static Scanner sc = new Scanner(System.in).useDelimiter("\n");

    public static void main(String[] args) {

        String vecNumeros[] = new String[4];

        if(args.length > 0){
            ordenamientoPorParametros(args);
            mostrarVectorOrdenado(args);
        } else{
            ordenamientoPorConsola(vecNumeros);
            mostrarVectorOrdenado(vecNumeros);
        }

    }

    public static void ordenamientoPorConsola( String[] vecNumeros){

        String ascDesc;

        cargarVectorDeNumeros(vecNumeros);
        ascDesc = validacionYCargaDelOrden();

        System.out.print("Los valores ingresados son: ");
        mostrarVectorOrdenado(vecNumeros);

        if(ascDesc.equalsIgnoreCase("a")){
            ordenAscendente(vecNumeros);
        } else{
            ordenDescendente(vecNumeros);
        }
    }

    public static void ordenamientoPorParametros(String[] args){
        Boolean ascODesc = args[args.length-1].equalsIgnoreCase("a");

        System.out.print("El vector tiene los valores de: ");
        mostrarVectorOrdenado(args);

        if(ascODesc == true){
            ordenAscendente(args);
        } else{
            ordenDescendente(args);
        }
    }

    public static void cargarVectorDeNumeros(String[] N){

        System.out.println("Ingrese tres numeros enteros.");

        for(int i = 0; i < N.length-1; i++){
            System.out.print("Numero " + (i+1) + ": ");
            N[i] = sc.next();
        }
        N[N.length-1] = null;
        //Esta carga tiene como utilidad poder reutilizar las demas funciones.
        // ya que la carga como argumento tiene 4 datos.

    }

    public static String validacionYCargaDelOrden(){

        String S="";

        System.out.println("Ingrese A si quiere ordenar de forma Ascendente." +
                "\nIngrese D para ordenar de forma Descendente.");

        do {
            System.out.print("Opcion: ");
            S = sc.next();

            if (S.equalsIgnoreCase("A") || S.equalsIgnoreCase("D")) {
                return S;
            }

            System.out.println("Ingreso una opcion incorrecta. Vuelva a intentarlo.");

        }while(true);
    }

    public static void ordenAscendente(String[] a){

        String aux;

        System.out.println("\n\nOrdenamiento ascendente de datos.\n");

        for(int i = 0; i < a.length-2; i++){

            for(int j = 0; j < a.length-i-2; j++){

                if( Integer.parseInt(a[j]) > Integer.parseInt(a[j+1]) ){
                    aux = a[j];
                    a[j] = a[j+1];
                    a[j+1] = aux;
                }
            }

        }

    }

    public static void ordenDescendente(String[] a){
        String aux;

        System.out.println("\n\nOrdenamiento descendente de datos.\n");

        for(int i = 0; i < a.length-2; i++){

            for(int j = 0; j < a.length-i-2; j++){

                if( Integer.parseInt(a[j]) < Integer.parseInt(a[j+1]) ){
                    aux = a[j];
                    a[j] = a[j+1];
                    a[j+1] = aux;
                }
            }

        }
    }

    public static void mostrarVectorOrdenado(String[] a){

        for(int i = 0; i< a.length-1; i++){
            System.out.print(a[i] + " ");
        }

    }
}