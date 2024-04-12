
package Tp1.ejercicio7;
import java.util.ArrayList;
import java.util.Scanner;


public class TestArrayList {
    public static void main(String[] args) {
        Scanner s = new Scanner (System.in);
        ArrayList<Integer> lista_array = new ArrayList();
        
        System.out.println ("Ingrese numero (00 corta): ");
        int num = s.nextInt();
        
        while (num != 00) {
            lista_array.add(num);
            num = s.nextInt();
        }
        
        for (int elto: lista_array) {
            System.out.println (elto);  // accede directamente al valor
        }
        
        /* b. Si se hubiera implementado una LinkedList la unica variacion hubiera sido 
              a la hora de importar el paquete y declararla. El resto seria igual.  
       
        for (int i=0; i < lista_array.size(); i++){
            System.out.println (lista_array.get(i));
        }
        
        while (!lista_array.isEmpty()) {
            System.out.println (lista_array.get(0));
            lista_array.remove(0);
        }
        
        */
    }
}
