package Tp3.Ej6;

import Tp3.Ej1235.GeneralTree;
import java.util.*;

public class RedDeAguaPotable {
    private GeneralTree<Character> arbol;

    public RedDeAguaPotable(GeneralTree<Character> arbol) {
		this.arbol = arbol;
	}

    //
	public double minimoCaudal (double caudal) {
        if (!arbol.isEmpty()) {
            double min = calcularCaudal(caudal, arbol);
            return min;
        }
        else
            return 0;
    }

    private double calcularCaudal (double caudal, GeneralTree<Character> nodo) {
    	
    	if (!nodo.hasChildren()) {
            return caudal;
        } 
        else {
            double min = 9999;
            int cant = nodo.getChildren().size();
            
            for (GeneralTree<Character> child : nodo.getChildren()) {
                double caudalHijo = calcularCaudal(caudal/cant, child);
                if (caudalHijo < min)
                    min = caudalHijo;
            }

            return min;
        }
    }

    public static void main(String[] args) {
        List<GeneralTree<Character>> children1 = new LinkedList<GeneralTree<Character>>();
        children1.add(new GeneralTree<Character>('F'));
        GeneralTree<Character> a1 = new GeneralTree<Character>(('H'), children1);
        
        List<GeneralTree<Character>> children2 = new LinkedList<GeneralTree<Character>>();
        children2.add(new GeneralTree<Character>('C'));
        children2.add(new GeneralTree<Character>('P'));
        children2.add(new GeneralTree<Character>('A'));
        children2.add(new GeneralTree<Character>('D'));
        GeneralTree<Character> a2 = new GeneralTree<Character>(('O'), children2);
        
        List<GeneralTree<Character>> children3 = new LinkedList<GeneralTree<Character>>();
        children3.add(new GeneralTree<Character>('E'));
        children3.add(new GeneralTree<Character>('A'));
        children3.add(new GeneralTree<Character>('W'));
        GeneralTree<Character> a3 = new GeneralTree<Character>(('I'), children3);
        
        List<GeneralTree<Character>> children4 = new LinkedList<GeneralTree<Character>>();
        children4.add(a1);
        children4.add(a2);
        children4.add(a3);
        GeneralTree<Character> a = new GeneralTree<Character>(('Z'), children4);

        RedDeAguaPotable red = new RedDeAguaPotable(a);
        
        System.out.println("Caudal minimo: " + red.minimoCaudal(1000));
        
    }

}