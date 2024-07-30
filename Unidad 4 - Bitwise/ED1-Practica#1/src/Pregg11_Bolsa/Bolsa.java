
package Pregg11_Bolsa;
import java.util.Arrays;

public class Bolsa<TipoElemento>{
    Object elementos[];
    int dim;

    public Bolsa() {
        elementos = new Object[10];
        dim = 0;
    }
    /*
    public Bolsa(TipoElemento elemento){
        if(dim == elementos.length)
            redimensionar();
        elementos[dim++] = elemento;
    }*/
    
    public void Añadir(TipoElemento elemento){
        if(dim == elementos.length)
            redimencionar();
        elementos[dim++] = elemento;
    }
    
    public boolean BolsaVacia(){
        return dim == 0;
    }
    
    public boolean Dentro(TipoElemento elemento){
        for(int i=0 ; i < dim ; i++){
           if(elementos[i] == elemento)
               return true;
        }
        return false;
    }
    
    public int Cuantos(TipoElemento elemento){
        int cant = 0;
        for(int i=0 ; i < dim ; i++){
            if(elementos[i] == elemento)
                cant++;
        }
        return cant;
    }
    
    public Bolsa<TipoElemento> Union(Bolsa<TipoElemento> B2){
        Bolsa<TipoElemento> BU = new Bolsa<>();
        for(int i=0 ; i < dim ; i++){
            BU.Añadir((TipoElemento) elementos[i]);
        }
        for(int j=0 ; j < B2.dim ; j++){
            BU.Añadir((TipoElemento) B2.elementos[j]);
        }
        return BU;
    }
    
    public int Total(){
        return dim;
    }
    
    public void redimencionar(){
        int nuevoTamaño = elementos.length * 2;
        elementos = Arrays.copyOf(elementos, nuevoTamaño);
    }
    
    @Override
    public String toString(){
        String s = "{ ";
        
        for(int i=0 ; i < dim ; i++){
            s = s + elementos[i] ;
            if(i< dim-1)
                s = s + ", ";
            if (i == dim-1)
                s = s + " }";
        }
        return s;
    }
    
}
