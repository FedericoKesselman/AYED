package Tp3.Ej4;

import Tp3.Ej1a3.GeneralTree;

public class AnalizadorArbol {
    private GeneralTree<AreaEmpresa> arbol;

	public AnalizadorArbol(GeneralTree<AreaEmpresa> arbol) {
		this.arbol = arbol;
	}

    public double devolverMaximoPromedio (); {
        if (!arbol.isEmpty()) 
            return devolverMaxPro (arbol);
        else
            return -1.0;
    }

	public double devolverMaxPro (GeneralTree<AreaEmpresa> arbol) {
        int cant = 0;
        int total = 0;
        int max = -1;
        double promedio;

        GeneralTree<AreaEmpresa> tree_aux;
        Queue<GeneralTree<AreaEmpresa>> queue = new Queue<GeneralTree<AreaEmpresa>>();

        queue.enqueue(this);
        queue.enqueue(null);

        while (!queue.isEmpty()) {
            tree_aux = queue.dequeue();

            if (tree_aux!= null) { // 
                List<GeneralTree<AreaEmpresa>> children = tree_aux.getChildren();

                for (GeneralTree<T> child: children) {
                    queue.enqueue(child);
                    total += child.getData().getTardanza();
                    cant++;
                }
                queue.enqueue(null);
            }
            else if (!queue.isEmpty() {
                promedio = (total/cant);
                if (promedio > max) 
                    max = promedio;
                cant = 0; total = 0;
            }
        }
        
        return max;

    }
    
    

}