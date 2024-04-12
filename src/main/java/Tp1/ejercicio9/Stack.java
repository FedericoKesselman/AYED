
package Tp1.ejercicio9;
import java.util.*;

public class Stack <T>{
    private List<T> data;
    
    public Stack () {
        data = new ArrayList<T>();
    }
    
    public void push(T dato) {
        data.add(data.size(), dato);
    }
    
    public T pop() {
        return data.remove(data.size()-1);
    }
    
    public T top() {
        return data.get(data.size()-1);
    }
    
    public int size() {
        return data.size();
    }
    
    public boolean isEmpty() {
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
