import java.util.Scanner;

class Controller {
    public boolean isElementOf (int z, int[] X) {
        for (int i = 0; i < X.length; i++){
            if (X[i] == z) {
                return true;
            }
        }
        return false;
    }
}


public class App {
    static void fillArray (int[] X) {
        Scanner sc = new Scanner(System.in);
        for(int i = 0; i < X.length ; i++) {
            X[i] = sc.nextInt();
        }
    }

    public static void main(String[] args) throws Exception {
        Scanner sc = new Scanner(System.in);
        System.out.println("Ingrese la dimension del arreglo");
        int n = sc.nextInt();
        System.out.println("Ingrese los elementos del arreglo");
        int[] X = new int[n];
        fillArray(X);

        System.out.println("Que numero desea buscar: ");
        int z = sc.nextInt();
        
        Controller verificator = new Controller();

        //int[] X = {1, 14, 18, 93, 23, 54, 74, 17, 87, 84, 3};

        if (verificator.isElementOf(z, X)) {
            System.out.println("El numero " + z + " se encuentra en el arreglo");
        } else {
            System.out.println("El numero " + z + " no se encuentra en el arreglo");
        }
        

    }
}
