import java.util.Scanner;

// Press Shift twice to open the Search Everywhere dialog and type `show whitespaces`,
// then press Enter. You can now see whitespace characters in your code.

public class Main {
    public static void main(String[] args) throws ExcepcionMatriz {
        Scanner in = new Scanner(System.in);
        String[] matriz= new String[36];
        //No mutante
        String[] matriz2 = {"A","T","C","G","G","A",
                            "A","T","A","A","T","C",
                            "A","G","C","T","A","G",
                            "A","C","G","A","A","T",
                            "T","C","C","C","G","T",
                            "A","G","C","T","A","G"};
        //No mutante
        String [] matriz3 = { "A","T","C","G","G","A",
                              "C","T","C","A","T","C",
                              "G","G","C","T","A","G",
                              "T","C","C","A","A","T",
                              "T","C","A","C","G","T",
                              "A","G","A","T","A","G"};
        //Mutante
        String [] matriz4 = { "A","T","C","G","G","A",
                              "C","A","C","A","G","C",
                              "G","G","A","T","G","G",
                              "T","C","C","A","G","T",
                              "T","C","C","C","T","T",
                              "A","G","C","T","A","G"};
        //invalida
        String [] matriz5 = { "A","T","C","G","G","A",
                              "C","F","C","A","G","C",
                              "G","G","M","T","G","G",
                              "T","C","C","A","G","T",
                              "T","C","C","C","T","T",
                              "A","G","C","T","A","G"};
        //Ingreso por teclado la matriz
        /*for(int i=0; i<matriz.length;i++){
            System.out.print("["+i+"]");
            matriz[i]= in.nextLine();
        }*/

        //Compruebo si la matriz es mutante
        boolean mutan = isMutant(matriz4);
        if(mutan){
            System.out.println("Es adn mutante");
        }else{
            System.out.println("No es adn mutante");
        }
    }
    public static boolean isMutant(String[] mat) throws ExcepcionMatriz {
        String[][] adn = modMatriz(mat);
        int cont=0;
        if(matValid(adn)){
            //Recorro de forma Horizontal
            for (int i = 0; i < adn.length; i++) {
                for (int j = 0; j < adn[i].length - 3; j++) {
                    if (adn[i][j].equals(adn[i][j+1]) && adn[i][j].equals(adn[i][j+2]) && adn[i][j].equals(adn[i][j+3])) {
                        cont++;
                    }
                }
            }
            //Recorro de forma vertical
            for (int i = 0; i < adn.length - 3; i++) {
                for (int j = 0; j < adn[i].length; j++) {
                    if (adn[i][j].equals(adn[i+1][j]) && adn[i][j].equals(adn[i+2][j]) && adn[i][j].equals(adn[i+3][j])) {
                        cont++;
                    }
                }
            }
            //Recorro el arreglo en la diagonal principal
            for (int i = 0; i < adn.length - 3; i++) {
                for (int j = 0; j < adn[i].length - 3; j++) {
                    if (adn[i][j].equals(adn[i+1][j+1]) && adn[i][j].equals(adn[i+2][j+2]) && adn[i][j].equals(adn[i+3][j+3])) {
                        cont++;
                    }
                }
            }
            //Recorro el arreglo en la diagonal inversa
            for (int i = 3; i < adn.length; i++) {
                for (int j = 0; j < adn[i].length - 3; j++) {
                    if (adn[i][j].equals(adn[i - 1][j + 1]) && adn[i][j].equals(adn[i - 2][j + 2]) && adn[i][j].equals(adn[i - 3][j + 3])) {
                        cont++;
                    }
                }
            }
        }
        return cont>=2;
    }

   private static boolean matValid(String[][]adn) throws ExcepcionMatriz {
       int n = adn.length;
       boolean valid=true;
       //Verifico si la matriz esta vacia
       if (n == 0) {
           throw new ExcepcionMatriz("Matriz vacia");
       }
       //Verifico si la matriz es cuadrada
       for (int i = 0; i < n; i++) {
           if (adn[i].length != n) {
               throw new ExcepcionMatriz("Matriz invalida");
           }
           //Compruebo que existan los caracteres validos
           for (int j = 0; j < n; j++) {
               if (!adn[i][j].matches("[ATCG]")) {
                   throw new ExcepcionMatriz("Caracteces invalidos");
               }
           }

       }
       return valid;
   }

    public static String[][] modMatriz(String[] mat){
        //convierto el arrelgo en matriz
        String[][] matriz = new String[6][6];
        int cont=0;
        for(int i=0; i<6;i++){
            for(int a=0;a<6;a++){
                matriz[i][a] = mat[cont];
                cont++;
            }
        }
        return matriz;
    }

}