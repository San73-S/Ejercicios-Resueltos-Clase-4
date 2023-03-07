import java.util.Scanner;

public class Main {

    public static Scanner sc = new Scanner(System.in).useDelimiter("\n");
    public static void main(String[] args) {

        int vecNumeros[] = new int[3];
        String ascDesc;

        cargarVectorDeNumeros(vecNumeros);
        ascDesc = validacionYCargaDelOrden();

        mostrarVectorOrdenado(vecNumeros);

    }

    public static void cargarVectorDeNumeros(int[] N){

        System.out.println("Ingrese tres numeros enteros.");

        for(int i = 0; i < N.length; i++){
            System.out.print("Numero " + (i+1) + ": ");
            N[i] = sc.nextInt();
        }

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

    public static void mostrarVectorOrdenado(int[] a){

        for(int i = 0; i < a.length; i++){
            System.out.print(a[i] + " ");
        }

    }

}