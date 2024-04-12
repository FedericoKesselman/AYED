
package Tp1;
import java.util.Scanner;

public class Ej2 {

    
    public static void main(String[] args) {
        Scanner s = new Scanner (System.in);
        
        System.out.println ("Ingrese valor de n: ");
        int n = s.nextInt();
        
        int [] multiplos = MultiplosN.obtenerMultiplos(n);
        System.out.println ("Los primeros " + n + " multiplos de " + n + " son: ");
        
        for (int elto: multiplos)
            System.out.println (elto + " ");
    }
    
}
