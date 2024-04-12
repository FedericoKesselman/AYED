
package Tp1;

public class ObjetoEj5 {
    private int maximo;
    private int minimo;
    private int promedio;

    @Override
    public String toString() {
        return "ObjetoEj5{" + "maximo=" + maximo + ", minimo=" + minimo + ", promedio=" + promedio + '}';
    }
    
    public int getMaximo() {
        return maximo;
    }

    public void setMaximo(int maximo) {
        this.maximo = maximo;
    }

    public int getMinimo() {
        return minimo;
    }

    public void setMinimo(int minimo) {
        this.minimo = minimo;
    }

    public int getPromedio() {
        return promedio;
    }

    public void setPromedio(int promedio) {
        this.promedio = promedio;
    }
}
