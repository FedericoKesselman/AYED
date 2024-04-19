package Tp3.Ej4;

import Tp3.Ej1235.GeneralTree;
import Tp1.ejercicio8.Queue;
import java.util.*;

public class AnalizadorArbol {

    public double devolverMaximoPromedio (GeneralTree<AreaEmpresa> arbol) { 
        if (!arbol.isEmpty()) 
            return devolverMaxPro (arbol);
        else
            return 0;
    }

	private double devolverMaxPro (GeneralTree<AreaEmpresa> arbol) {
        int cant = 0;
        double total = 0;
        double max = -1;
        double promedio;

        GeneralTree<AreaEmpresa> tree_aux;
        Queue<GeneralTree<AreaEmpresa>> queue = new Queue<GeneralTree<AreaEmpresa>>();

        queue.enqueue(arbol);
        queue.enqueue(null);

        while (!queue.isEmpty()) {
            tree_aux = queue.dequeue();

            if (tree_aux!= null) { // 
                List<GeneralTree<AreaEmpresa>> children = tree_aux.getChildren();

                for (GeneralTree<AreaEmpresa> child: children) 
                    queue.enqueue(child);

                total += tree_aux.getData().getTardanza();
                cant++;
            }
            else { 
            	if (!queue.isEmpty()) {
                    queue.enqueue(null);
            		promedio = (total/cant);
            		if (promedio > max) 
            			max = promedio;
            		cant = 0; total = 0;
            } }
        }
        
        return max;
    }

    public static void main(String[] args) {
        List<GeneralTree<AreaEmpresa>> children1 = new LinkedList<GeneralTree<AreaEmpresa>>();
        children1.add(new GeneralTree<AreaEmpresa>(new AreaEmpresa("A",4)));
        children1.add(new GeneralTree<AreaEmpresa>(new AreaEmpresa("B",7)));
        children1.add(new GeneralTree<AreaEmpresa>(new AreaEmpresa("C",5)));
        GeneralTree<AreaEmpresa> a1 = new GeneralTree<AreaEmpresa>(new AreaEmpresa("J",13), children1);
        
        List<GeneralTree<AreaEmpresa>> children2 = new LinkedList<GeneralTree<AreaEmpresa>>();
        children2.add(new GeneralTree<AreaEmpresa>(new AreaEmpresa("D",6)));
        children2.add(new GeneralTree<AreaEmpresa>(new AreaEmpresa("E",10)));
        children2.add(new GeneralTree<AreaEmpresa>(new AreaEmpresa("F",18)));
        GeneralTree<AreaEmpresa> a2 = new GeneralTree<AreaEmpresa>(new AreaEmpresa("K",25), children2);
        
        List<GeneralTree<AreaEmpresa>> children3 = new LinkedList<GeneralTree<AreaEmpresa>>();
        children3.add(new GeneralTree<AreaEmpresa>(new AreaEmpresa("G",9)));
        children3.add(new GeneralTree<AreaEmpresa>(new AreaEmpresa("H",12)));
        children3.add(new GeneralTree<AreaEmpresa>(new AreaEmpresa("I",19)));
        GeneralTree<AreaEmpresa> a3 = new GeneralTree<AreaEmpresa>(new AreaEmpresa("L",10), children3);
        
        List<GeneralTree<AreaEmpresa>> children4 = new LinkedList<GeneralTree<AreaEmpresa>>();
        children4.add(a1);
        children4.add(a2);
        children4.add(a3);
        GeneralTree<AreaEmpresa> a = new GeneralTree<AreaEmpresa>(new AreaEmpresa("M",14), children4);
        
        AnalizadorArbol arb = new AnalizadorArbol();
        System.out.println("MIO El mayor promedio entre todos los valores promedios de los niveles es: " + arb.devolverMaximoPromedio(a));
    }
    
    

}