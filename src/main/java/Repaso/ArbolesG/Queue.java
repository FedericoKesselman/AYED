package ArbolesG;

import java.util.LinkedList;
import java.util.List;

public class Queue<T> {
	List<T> data;
    
    public Queue() {
        this.data = new LinkedList<T>();
    }
    
    public void enqueue(T dato) {
        data.add(dato);
    }
    
    public T dequeue () {
        return data.remove(0);
    }
    
    public T head () {
        return data.get(0);
    }
    
    public int size() {
        return data.size();
    }
    
    public boolean isEmpty () {
        return data.size() == 0;
    }
    
    public String toString() {
        String aux = "[ ";
        
        for (T elto: data)
            aux += elto + " ";
        
        aux += "]";
        return aux;
    }
}
