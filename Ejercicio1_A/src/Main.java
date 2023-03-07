public class Main {
    public static void main(String[] args) {

        Boolean ascODesc = args[args.length-1].equalsIgnoreCase("a");

        System.out.print("El vector tiene los valores de: ");
        mostrarVectorOrdenado(args);

        if(ascODesc == true){
            ordenAscendente(args);
        } else{
            ordenDescendente(args);
        }

        mostrarVectorOrdenado(args);

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