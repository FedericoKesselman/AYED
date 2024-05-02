package Tp3.Ej10;

import Tp3.Ej1235.GeneralTree;
import java.util.*;

public class ParcialArboles { 
    public static List<Integer> resolver(GeneralTree<Integer> arbol) {
        List<Integer> caminoMax = new ArrayList<>();
        List<Integer> caminoActual = new ArrayList<>();

        if (!arbol.isEmpty()) {
            int max = resolverHelper(arbol, caminoActual, caminoMax, 0, 1);
        }
        return caminoMax;
    }

    private static int resolverHelper(GeneralTree<Integer> arbol, List<Integer> caminoAct, List<Integer> caminoMax, int nivel, int sumaAct, int saumaMax) {
        if (arbol.getData() != 0)
            caminoAct.add(arbol.getData()); // el mismo hijo se agrega a la lista actual

        sumaAct += arbol.getData() * nivel; // variable que va guardando los valores

        // procesamiento
        if (!arbol.hasChildren()) {
            if (sumaAct > sumaMax) {
                sumaMax = sumaAct;
                caminoMax.removeAll(caminoMax);
                caminoMax.addAll(caminoAct);
            }
        }
        else {
            for(GeneralTree<Integer> child: arbol.getChildren()) 
                sumaMax = resolverHelper(child, caminoAct, caminoMax, nivel+1, sumaAct);
        }
        // fin procesamiento 
        
        caminoAct.remove(caminoAct.size()-1); // el mismo hijo se elimina antes de volver
        sumaAct -= arbol.getData() * nivel; // resta valor hijo
        return sumaMax; // obligatoriamente hay que devolverlo para que el nodo padre reciba el nuevo valor maximo
    }
}



