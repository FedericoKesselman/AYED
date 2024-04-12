
package Tp1.ejercicio8;
import java.util.*;

public class DoubleEndedQueue<T> extends Queue<T>{
    
    public DoubleEndedQueue() {
        super();
    }
    
    public void enqueueFirst(T dato) {
        data.add(data.size(), dato);
    }
    
    
}
