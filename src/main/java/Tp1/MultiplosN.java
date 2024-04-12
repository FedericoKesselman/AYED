
package Tp1;


public class MultiplosN {
    
    public static int[] obtenerMultiplos (int n) {
        int [] multiplos = new int[n];
        
        for (int i = 0; i < n; i++) {
            multiplos[i] = n * (i + 1);
        }
        
        return multiplos; 
    }
    
    
}
