
package Preg9_ConjuntoDinamico;

import java.util.BitSet;

public class ConjuntoDinamico {
    BitSet conjuntoD;

    public ConjuntoDinamico() {
        conjuntoD = new BitSet();
    }
    
    public void agregar(int elemento){
        conjuntoD.set(elemento);
    }
    
    public void eliminar(int elemento){
        conjuntoD.clear(elemento);
    }
    
    public boolean contieneElemtento(int elemento){
        return conjuntoD.get(elemento);
    }
    
    public int tamaño(){
        return conjuntoD.cardinality();
    }
    
    @Override
    public String toString(){
        return "Conjunto: "+ conjuntoD ;
    }
        
    
}
