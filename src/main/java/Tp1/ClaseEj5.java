
package Tp1;

public class ClaseEj5 {
    
    public static ObjetoEj5 Metodo1 (int[] numeros) {
        int max = -1;
        int min = 9999999;
        int total = 0;
        
        for (int elto: numeros) {
            if (elto > max) 
                max = elto;
            if (elto < min) 
                min = elto;
            
            total += elto;
        }
        
        int promedio = total / (numeros.length);
        
        ObjetoEj5 Ob = new ObjetoEj5();
        Ob.setMaximo(max);
        Ob.setMinimo(min);
        Ob.setPromedio(promedio);
        
        return Ob;
    } 
    
    
}
