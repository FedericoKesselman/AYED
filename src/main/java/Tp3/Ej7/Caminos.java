package Tp3.Ej7;

import Tp3.Ej1235.GeneralTree;
import java.util.*;

public class Caminos {
    private GeneralTree<Integer> arbol;

    public Caminos (GeneralTree<Integer> arbol) {
		this.arbol = arbol;
	}

    public List<Integer> caminoAHojaMasLejana() {
        List<Integer> caminoMax = new ArrayList<>();
        List<Integer> caminoActual = new ArrayList<>();
        if (!arbol.isEmpty()) {
            camino(arbol, caminoActual, caminoMax);
        }
        return caminoMax;
    }

    private void camino(GeneralTree<Integer> arbol, List<Integer> caminoAct, List<Integer> caminoMax) {
        caminoAct.add(arbol.getData());

        if (arbol.hasChildren()) {
            for(GeneralTree<Integer> child: arbol.getChildren()) {
                camino(child, caminoAct, caminoMax);
                caminoAct.remove(caminoAct.size()-1); // va eliminado el ultimo de camino actual, xq ya se controlo ese camino
            }
        } 
        else if(caminoAct.size() > caminoMax.size()) {
            caminoMax.removeAll(caminoMax);
            caminoMax.addAll(caminoAct);
        }
    }

}