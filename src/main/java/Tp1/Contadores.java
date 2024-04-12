
package Tp1;


public class Contadores {
    
    public static void conFor(int a, int b) {
        for (int i = a; i <= b; i++) {
            System.out.println (i);
        }       
    }

    public static void conWhile(int a, int b) {
        int i = a;
        
        while (i <= b) {
            System.out.println (i);
            i++; 
        }
    }

    public static void conRecursion(int a, int b) {
        if (a <= b) {
            System.out.println (a);
            conRecursion (a+1, b);
        }
    }

}
