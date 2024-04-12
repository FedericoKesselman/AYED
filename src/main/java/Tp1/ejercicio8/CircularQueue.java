
package Tp1.ejercicio8;
import java.util.*;

public class CircularQueue<T> extends Queue<T> {
    
    public CircularQueue() {
        super();
    }
    
    public T shift() {
        T elementoRotado = dequeue();
        enqueue (elementoRotado);
  
        return elementoRotado;
    }
}
