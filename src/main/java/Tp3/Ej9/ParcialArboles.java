package Tp3.Ej9;

import Tp3.Ej1235.GeneralTree;
import java.util.*;

public class ParcialArboles {
    public static boolean esDeSeleccion (GeneralTree<Integer> arbol) {
        if (!arbol.isEmpty())
            return esDeSeleccionHelper(arbol);
        else
            return false;
    }
    
    private static boolean esDeSeleccionHelper (GeneralTree<Integer> arbol) {
        if (!arbol.hasChildren())
            return true;

        int min = 9999;

        for (GeneralTree<Integer> child: arbol.getChildren()) {
            if (child.getData() < min) 
                min = child.getData(); // calcula minimo de los hijos
            if (!esDeS(child)) 
                return false; // si alguno de los sub-arboles no cumple corta
        }

        if (arbol.getData() == min) 
            return true;
        else
            return false;
    }
    
    public static void main(String[] args) {
        List <GeneralTree<Integer>> subChildren1 = new LinkedList <GeneralTree<Integer>>();
        subChildren1.add(new GeneralTree<Integer>(35));
        GeneralTree<Integer> subAb1 = new GeneralTree<Integer>(35, subChildren1);
        
        List <GeneralTree<Integer>> subChildren2 = new LinkedList <GeneralTree<Integer>>();
        subChildren2.add(subAb1);
        GeneralTree<Integer> subAb2 = new GeneralTree<Integer>(35, subChildren2);
        
        List <GeneralTree<Integer>> subChildren3 = new LinkedList <GeneralTree<Integer>>();
        subChildren3.add(new GeneralTree<Integer>(35));
        subChildren3.add(new GeneralTree<Integer>(83));
        subChildren3.add(new GeneralTree<Integer>(90));
        subChildren3.add(new GeneralTree<Integer>(33));
        GeneralTree<Integer> subAb3 = new GeneralTree<Integer>(33, subChildren3);
        
        List <GeneralTree<Integer>> subChildren4 = new LinkedList <GeneralTree<Integer>>();
        subChildren4.add(new GeneralTree<Integer>(14));
        subChildren4.add(new GeneralTree<Integer>(12));
        //subChildren4.add(new GeneralTree<Integer>(18));
        subChildren4.add(subAb3);
        GeneralTree<Integer> subAb4 = new GeneralTree<Integer>(12, subChildren4);
        //GeneralTree<Integer> subAb4 = new GeneralTree<Integer>(18, subChildren4);
        
        List <GeneralTree<Integer>> subArbIzq = new LinkedList <GeneralTree<Integer>>();
        subArbIzq.add(subAb2);
        subArbIzq.add(subAb4);
        GeneralTree<Integer> arbIzq = new GeneralTree<Integer>(12, subArbIzq);
        
        List <GeneralTree<Integer>> subArbDer = new LinkedList <GeneralTree<Integer>>();
        subArbDer.add(new GeneralTree<Integer>(25));
        GeneralTree<Integer> arbDer = new GeneralTree<Integer>(25, subArbDer);
        
        List <GeneralTree<Integer>> arbol = new LinkedList <GeneralTree<Integer>>();
        arbol.add(arbIzq);
        arbol.add(arbDer);
        GeneralTree<Integer> a = new GeneralTree<Integer>(12, arbol); 
        
        System.out.println("Es de seleccion el primer arbol: " + esDeSeleccion(a));
    }
}