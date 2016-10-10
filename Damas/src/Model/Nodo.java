
package Model;

/**
 *
 * @author Denis Rodriguez, Sergio Vega
 */
public class Nodo<T> {
    
    private T dato;
    private Nodo anterior;
    private Nodo siguiente;

    public Nodo(T dato) {
        this.dato = dato;
        this.anterior = null;
        this.siguiente = null;
    }

    public T getDato() {
        return dato;
    }

    public void setDato(T dato) {
        this.dato = dato;
    }

    public Nodo getAnterior() {
        return anterior;
    }

    public void setAnterior(Nodo anterior) {
        this.anterior = anterior;
    }

    public Nodo getSiguiente() {
        return siguiente;
    }

    public void setSiguiente(Nodo siguiente) {
        this.siguiente = siguiente;
    }
        
}
