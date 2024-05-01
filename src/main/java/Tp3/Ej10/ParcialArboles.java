package Tp3.Ej10;

import Tp3.Ej1235.GeneralTree;
import java.util.*;

public class ParcialArboles { 
    public static List<Integer> resolver(GeneralTree<Integer> arbol) {
        List<Integer> caminoMax = new ArrayList<>();
        List<Integer> caminoActual = new ArrayList<>();
        List<Integer> caminoAux = new ArrayList<>();

        if (!arbol.isEmpty()) {
            resolverHelper(arbol, caminoActual, caminoMax, caminoAux, 1, -1);
        }
        return caminoMax;
    }

    private void resolverHelper(GeneralTree<Integer> arbol, List<Integer> caminoAct, List<Integer> caminoMax, List<Integer> caminoAux, int nivel, int max) {
        if (arbol.getData() != 0)
            caminoAct.add(arbol.getData()); // lista que va guardando el camino de 1/0

        caminoAux.add(arbol.getData() * nivel); // lista que va guardando los valores

        if (arbol.hasChildren()) {
            for(GeneralTree<Integer> child: arbol.getChildren()) {
                camino(child, caminoAct, caminoMax, caminoAux, nivel+1, max);
                caminoAct.remove(caminoAct.size()-1); // va eliminado el ultimo de camino actual, xq ya se controlo ese camino
                caminoAux.remove(caminoAux.size()-1); // " " de la lista aux
            }
        } 
        else {
            int cant = 0;

            for (int num: caminoAux)
                cant += num;

            if(cant > max) {
                caminoMax.removeAll(caminoMax);
                caminoMax.addAll(caminoAct);
            }
        }
    }

}


