package Exception;

import Juego.Campo;
import Juego.Matriz;

public final class Enroque extends Exception {

    Campo from, to;
    Matriz m;
    
    public Enroque(Campo from, Campo to, Matriz m){
        this.from = from;
        this.to = to;
        this.m = m;
        
    }
    
    
}
