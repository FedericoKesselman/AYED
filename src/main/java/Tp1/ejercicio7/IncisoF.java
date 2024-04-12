
package Tp1.ejercicio7;
import java.util.*;


public class IncisoF {

    public static void main(String[] args) {
        // INCISO F
        ArrayList<Integer> lista = new ArrayList(Arrays.asList(2,5,2));
        System.out.println(Metodos.esCapicua(lista));
        
        ArrayList<Integer> lista2 = new ArrayList(Arrays.asList(4,5,6,3,4));
        System.out.println(Metodos.esCapicua(lista2));
        
        // INCISO H
        ArrayList<Integer> lista3 = new ArrayList(Arrays.asList(1,2,3));
        Metodos.invertirArrayList(lista3);
        for (int elto: lista3)
            System.out.println (elto);
        
        // INCISO I
        LinkedList<Integer> lista4 = new LinkedList(Arrays.asList(1, 2, 3, 4));
        System.out.println ("Suma de los elementos: " + Metodos.sumarLinkedList(lista4));
        
        // INCISO J
        ArrayList<Integer> lista5 = new ArrayList(Arrays.asList(1,1,3,3,5,7));
        ArrayList<Integer> lista6 = new ArrayList(Arrays.asList(2,4,6,8,8));
        ArrayList<Integer> lista7 = Metodos.combinarOrdenado(lista5, lista6);
        for (int elto: lista7)
            System.out.println (elto);
        
        
        List<Integer> lista8 = new ArrayList();
        lista8 = Metodos.calcularSucesion(6);
        for (int elto: lista8)
            System.out.println (elto);
        
    }
}
