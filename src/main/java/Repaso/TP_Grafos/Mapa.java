package TP_Grafos;
import java.util.*;

public class Mapa {
	private Graph<String> mapaCiudades;

    public Mapa (Graph<String> mapaCiudades) {
        this.mapaCiudades = mapaCiudades;
    }

    /*-------------------------------------1-------------------------------------*/
    public List<String> devolverCamino(String ciudad1, String ciudad2) {
        List<String> lista = new ArrayList<>();

        if (!this.mapaCiudades.isEmpty()) {
            boolean[] visitados = new boolean[mapaCiudades.getSize()];    

            Vertex<String> origen = this.mapaCiudades.search(ciudad1);
            Vertex<String> destino = this.mapaCiudades.search(ciudad2);

            if (origen != null && destino != null) 
                devolverCaminoHelper (origen, visitados, lista, ciudad2);
        }

        return lista;
    }

    private boolean devolverCaminoHelper (Vertex<String> vertex, boolean[] visitados, List<String> lista, String ciudad2) { 
        visitados[vertex.getPosition()] = true;
        boolean OK = false;
        lista.add(vertex.getData()); // Podria ir adentro del if pero asi queda la ciudad2 en la lista 

        if (!vertex.getData().equals(ciudad2)) {
            for (Edge<String> edge: mapaCiudades.getEdges(vertex)) { 
                if (!visitados[edge.getTarget().getPosition()] && !OK)
                    OK = devolverCaminoHelper (edge.getTarget(), visitados, lista, ciudad2);
            }

            if (!OK) 
                lista.remove(lista.size()-1);
        }
        else
            OK = true;

        return OK;
    }
    
    
    /*-------------------------------------2-------------------------------------*/
    public List<String> devolverCaminoExceptuando(String ciudad1, String ciudad2, List<String> ciudades) {
        List<String> lista = new ArrayList<>();

        if (!this.mapaCiudades.isEmpty()) {
            boolean[] visitados = new boolean[mapaCiudades.getSize()];  

            Vertex<String> origen = this.mapaCiudades.search(ciudad1);
            Vertex<String> destino = this.mapaCiudades.search(ciudad2);

            if (origen != null && destino != null) 
                devolverCaminoExceptuandoHelper (origen, visitados, lista, ciudades, ciudad2);
        }

        return lista;
    }

    private boolean devolverCaminoExceptuandoHelper (Vertex<String> vertex, boolean[] visitados, List<String> lista, List<String> ciudades, String ciudad2) { 
        visitados[vertex.getPosition()] = true;
        boolean OK = false;
        lista.add(vertex.getData()); // Podria ir adentro del if pero asi queda la ciudad2 en la lista 

        int pos;
        String ciudad;

        if (!vertex.getData().equals(ciudad2)) {

            for (Edge<String> edge: mapaCiudades.getEdges(vertex)) { 
                pos = edge.getTarget().getPosition();
                ciudad = edge.getTarget().getData();

                if (ciudades.contains(ciudad))
                    visitados[pos] = true;
                // Se pone en true la ciudad para que no pueda entrar 
                // Tambien se podria hacer en el otro metodo pero no es lo que mas conviene(explicado en clase)

                if (!visitados[pos] && !OK) 
                    OK = devolverCaminoExceptuandoHelper (edge.getTarget(), visitados, lista, ciudades, ciudad2);
            }

            if (!OK) {
                lista.remove(lista.size()-1);
                visitados[vertex.getPosition()] = false;
            }
        }
        else
            OK = true;

        return OK;
    }
    
    
    /*-------------------------------------3-------------------------------------*/
    public List<String> caminoMasCorto(String ciudad1, String ciudad2) {
        List<String> camino = new ArrayList<>();

        if (!this.mapaCiudades.isEmpty()) {
            boolean[] visitados = new boolean[mapaCiudades.getSize()];  

            Vertex<String> origen = this.mapaCiudades.search(ciudad1);
            Vertex<String> destino = this.mapaCiudades.search(ciudad2);

            if (origen != null && destino != null) 
                caminoMasCortoHelper (origen, visitados, ciudad2, new ArrayList<String>(), camino, 0, Integer.MAX_VALUE);
        }

        return camino;
    }

    private int caminoMasCortoHelper(Vertex<String> vertex, boolean[] visitados, String ciudad2, List<String> caminoAct, List<String> caminoMin, int total, int min) {
        visitados[vertex.getPosition()] = true;
        caminoAct.add(vertex.getData());

        if (vertex.getData().equals(ciudad2) && total < min) { // se encontro un camino posible o un camino mas chico que el anterior
            caminoMin.removeAll(caminoMin);
            caminoMin.addAll(caminoAct);            
            min = total;
        }
        else {
            for (Edge<String> edge: mapaCiudades.getEdges(vertex)) { 
                int pos = edge.getTarget().getPosition();
                int aux = total + edge.getWeight();

                if (!visitados[pos] && aux < min) 
                    min = caminoMasCortoHelper(edge.getTarget(), visitados, ciudad2, caminoAct, caminoMin, aux, min);

            }
        }
        caminoAct.remove(caminoAct.size()-1);
        visitados[vertex.getPosition()] = false;
        return min;
    }
    
    
    /*-------------------------------------4-------------------------------------*/
    public List<String> caminoSinCargarCombustible(String ciudad1, String ciudad2, int tanqueAuto) {
        List<String> camino = new ArrayList<>();

        if (!this.mapaCiudades.isEmpty()) {
            boolean[] visitados = new boolean[mapaCiudades.getSize()];  

            Vertex<String> origen = this.mapaCiudades.search(ciudad1);
            Vertex<String> destino = this.mapaCiudades.search(ciudad2);

            if (origen != null && destino != null) 
                caminoSinCargarCombustibleHelper (origen, visitados, ciudad2, camino, tanqueAuto);
        }

        return camino;
    }

    public boolean caminoSinCargarCombustibleHelper (Vertex<String> vertex, boolean[] visitados, String ciudad2, List<String> camino, int tanqueAuto) {
        visitados[vertex.getPosition()] = true;
        camino.add(vertex.getData());
        boolean OK = false;

        if (vertex.getData().equals(ciudad2))
            return true;
        else {
            for (Edge<String> edge: mapaCiudades.getEdges(vertex)) { 
                int pos = edge.getTarget().getPosition();
                int combustibleNecesario = edge.getWeight();

                // chequeo por !OK para que si un camino ya lo encontro no siga recorriendo el resto de adyacentes del vertice
                if ((!visitados[pos]) && (!OK) && (tanqueAuto - combustibleNecesario >= 0))
                    OK = caminoSinCargarCombustibleHelper(edge.getTarget(), visitados, ciudad2, camino, (tanqueAuto - combustibleNecesario));
            }

        }
        
        if (!OK)
            camino.remove(camino.size()-1);

        visitados[vertex.getPosition()] = false;
        return OK;
    }
    
    
    /*-------------------------------------5-------------------------------------*/
    public List<String> caminoConMenorCargaDeCombustible(String ciudad1, String ciudad2, int tanqueAuto) {
        List<String> camino = new ArrayList<>();

        if (!this.mapaCiudades.isEmpty()) {
            boolean[] visitados = new boolean[mapaCiudades.getSize()];  

            Vertex<String> origen = this.mapaCiudades.search(ciudad1);
            Vertex<String> destino = this.mapaCiudades.search(ciudad2);

            if (origen != null && destino != null) 
                caminoConMenorCargaDeCombustibleHelper (origen, visitados, ciudad2, new ArrayList<String>(), camino, tanqueAuto, tanqueAuto, 0, Integer.MAX_VALUE);
        }

        return camino;
    }

    // variable tanque almacena la cantidad total de combustible que puede tener el auto
    private int caminoConMenorCargaDeCombustibleHelper (Vertex<String> vertex, boolean[] visitados, String ciudad2, List<String> caminoAct, List<String> caminoMin, int tanqueActual, int tanque, int recargas, int recargasMin) {
        visitados[vertex.getPosition()] = true;
        caminoAct.add(vertex.getData());

        if (vertex.getData().equals(ciudad2) && recargas < recargasMin) {
            caminoMin.removeAll(caminoMin);
            caminoMin.addAll(caminoAct);            
            recargasMin = recargas;
        }

        else {
            for (Edge<String> edge: mapaCiudades.getEdges(vertex)) { 
                int pos = edge.getTarget().getPosition();
                int combustibleNecesario = edge.getWeight();

                if (!visitados[pos]) {
                    // Si el combustible que se tiene en el auto alcanza (sin realizar una recarga en la ciudad) se visita la ciudad
                    if (tanqueActual >= combustibleNecesario)
                        recargasMin = caminoConMenorCargaDeCombustibleHelper(edge.getTarget(), visitados, ciudad2, caminoAct, caminoMin, (tanqueActual - combustibleNecesario), tanque, recargas, recargasMin);
                    
                    // Si el combustible que tiene el auto no alcanza, se chequea si con una recarga si. De ser posible se visita con recargas+1 
                    else if (tanque >= combustibleNecesario)
                        recargasMin = caminoConMenorCargaDeCombustibleHelper(edge.getTarget(), visitados, ciudad2, caminoAct, caminoMin, (tanque - combustibleNecesario), tanque, (recargas+1), recargasMin);
                }
            }
        }
        
        caminoAct.remove(caminoAct.size()-1);
        visitados[vertex.getPosition()] = false;
        return recargasMin;
    }
    
    
    public static void main(String[] args) {
        Graph<String> mapaCiudades = new AdjListGraph<String>();
        Vertex<String> v1 = mapaCiudades.createVertex("La Plata"); //Casa Caperucita
        Vertex<String> v2 = mapaCiudades.createVertex("Ensenada"); //Claro 3
        Vertex<String> v3 = mapaCiudades.createVertex("Berisso"); //Claro 1
        Vertex<String> v4 = mapaCiudades.createVertex("Berazategui"); //Claro 2
        Vertex<String> v5 = mapaCiudades.createVertex("Florencio Varela"); //Claro 5
        Vertex<String> v6 = mapaCiudades.createVertex("Presidente Peron"); //Claro 4
        Vertex<String> v7 = mapaCiudades.createVertex("San Vicente"); //Casa Abuelita
        mapaCiudades.connect(v1, v2, 4);
        mapaCiudades.connect(v2, v1, 4);
        mapaCiudades.connect(v1, v3, 3);
        mapaCiudades.connect(v3, v1, 3);
        mapaCiudades.connect(v1, v4, 4);
        mapaCiudades.connect(v4, v1, 4);
        mapaCiudades.connect(v2, v5, 15);
        mapaCiudades.connect(v5, v2, 15);
        mapaCiudades.connect(v3, v5, 3);
        mapaCiudades.connect(v5, v3, 3);
        mapaCiudades.connect(v4, v3, 4);
        mapaCiudades.connect(v3, v4, 4);
        mapaCiudades.connect(v4, v5, 11);
        mapaCiudades.connect(v5, v4, 11);
        mapaCiudades.connect(v4, v6, 10);
        mapaCiudades.connect(v6, v4, 10);
        mapaCiudades.connect(v4, v3, 4);
        mapaCiudades.connect(v3, v4, 4);
        mapaCiudades.connect(v5, v7, 4);
        mapaCiudades.connect(v7, v5, 4);
        mapaCiudades.connect(v6, v7, 9);
        mapaCiudades.connect(v7, v6, 9);
        
        Mapa mapa = new Mapa(mapaCiudades);
        
        System.out.print("LISTA DEVOLVER CAMINO: ");
        System.out.print(mapa.devolverCamino("La Plata", "San Vicente"));
        
        System.out.println("");
        
        System.out.print("LISTA DEVOLVER CAMINO EXCEPTUANDO LUGARES:");
        List<String> restringidos = new LinkedList<String>();
        restringidos.add("Berisso");
        System.out.print(mapa.devolverCaminoExceptuando("La Plata", "San Vicente", restringidos));
        
        System.out.println("");
        
        System.out.print("LISTA CAMINO MAS CORTO (SEGUN DISTANCIA): ");
        System.out.print(mapa.caminoMasCorto("La Plata", "San Vicente"));
        
        System.out.println("");
        
        System.out.print("LISTA CAMINO SIN CARGAR COMBUSTIBLE: ");
        System.out.print(mapa.caminoSinCargarCombustible("La Plata", "San Vicente", 10));
        
        System.out.println("");
        
        System.out.print("LISTA CAMINO CON MENOR CARGAS DE COMBUSTIBLE: ");
        System.out.print(mapa.caminoConMenorCargaDeCombustible("La Plata", "San Vicente", 10));
        
        System.out.println("");
    }
}
