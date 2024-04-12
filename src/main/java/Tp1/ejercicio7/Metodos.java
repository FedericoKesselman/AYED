
package Tp1.ejercicio7;
import java.util.*;
import java.util.Collections;


public class Metodos {
    
    public static void ImprimirLista (ArrayList <Estudiante> lista) {
        for (Estudiante elto: lista) {
            System.out.println (elto.toString() + "\\n");
        }
    }
    
    public static void AgregarEstudiante (ArrayList <Estudiante> lista, Estudiante estudiante) {
        boolean esta = false;
        
        for (Estudiante elto: lista) {
            
            if (elto.getNombre() == estudiante.getNombre() && elto.getApellido()== estudiante.getApellido()) {
                System.out.println ("El alumno " + estudiante.getNombre() + " ya existe.");
                esta = true;
                break;
            }
        }
        
        if (!esta)
            lista.add(estudiante);
    } 
    
    public static boolean esCapicua(ArrayList<Integer> lista) {
        ArrayList<Integer> lista_invertida = new ArrayList(lista);
        Collections.reverse(lista_invertida);
        
        return lista.equals(lista_invertida);
    }
    
    public static void invertirArrayList(ArrayList<Integer> lista) {
        Collections.reverse(lista);
    }

    public static int sumarLinkedList(LinkedList<Integer> lista) {
        int suma = 0;
        
        for (int elto: lista)
            suma += elto;
        
        return suma;
    }
    
    public static ArrayList<Integer> combinarOrdenado(ArrayList<Integer> lista1, ArrayList<Integer> lista2) {
        
        ArrayList<Integer> lista_combinada = new ArrayList();
        int index1 = 0;
        int index2 = 0;
        int elemento1, elemento2;
        
        while ((index1 < lista1.size()) && (index2 < lista2.size())) {
            elemento1 = lista1.get(index1);
            elemento2 = lista2.get(index2);
            
            if (elemento1 < elemento2) {
                lista_combinada.add(elemento1);
                index1 ++;
            }
            else {
                lista_combinada.add(elemento2);
                index2 ++; 
            }
        }
        
        if (index1 < lista1.size()) {
            while (index1 < lista1.size()) {
                lista_combinada.add(lista1.get(index1));
                index1 ++;
            }
        }
        else {
            while (index2 < lista2.size()) {
                lista_combinada.add(lista2.get(index2));
                index2 ++;
            }
        }
        
        return lista_combinada;
    }
    
    public static ArrayList<Integer> calcularSucesion (int n) {
        ArrayList<Integer> lista = new ArrayList();
        lista.add(n);
        
        if (n != 1) {
            if ((n % 2) == 0)
                lista.addAll(calcularSucesion(n/2));
            else
                lista.addAll(calcularSucesion((3*n)+1)); 
        }
     
        return lista;
        
        /* 
        addAll agrega todos los números generados por las llamadas recursivas anteriores, 
            lo que permite mantener la sucesión completa en la lista final.
        */
    }
}
