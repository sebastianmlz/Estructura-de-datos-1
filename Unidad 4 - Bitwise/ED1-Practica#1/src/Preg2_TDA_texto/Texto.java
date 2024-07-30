
package Preg2_TDA_texto;

import java.util.ArrayList;
import java.util.List;


public class Texto {
    char[] caracteres;
     int dim = 0 ;
    final int max = 128;

    public Texto() {
        caracteres = new char[max];
        dim = 0;
    }

    public char[] getCaracteres() {
        return caracteres;
    }

    public void setCaracteres(char[] caracteres) {
        this.caracteres = caracteres;
    }
    
    public  Texto crear(){
        return new Texto();
    }
    
    public void Destruir(){
        for(int i=0 ; i<= dim ; i++){
            caracteres[i]='\0';
        }
    }
    
    public int tamanio(){
        return dim;
    }
    
    public char caracterEn( int posicion){
        if((posicion >= 0) && (posicion <= dim)){
            return caracteres[posicion];
        }else{
            throw new
            IndexOutOfBoundsException("posicion fuera de rango");
        }
    }
    
    public void insertarEn(int pos, char caracter){
        if((pos >= 0) && (pos <= dim)){
            caracteres[pos] = caracter;
            dim++;
        }else
            System.out.println("Posicion fuera de rango");
    }
    
    public void agregarCaracter(char c) {
        if (dim < max) {
            caracteres[dim++] = c;
        } else {
            throw new IllegalStateException("Capacidad máxima alcanzada");
        }
    }

    
    public int caracterPos(char caracter){
        int pos=-1;
        for(int i=0 ; i <= caracteres.length ; i++){
            if(caracteres[i] == caracter)
                pos = i;
                i = caracteres.length +1;
        }
        return pos;
    }
    
    public List<Integer> PosicionesCaracteres(char caracter){
        List<Integer> posiciones = new ArrayList<>();
        for(int i=0 ; i <= caracteres.length ; i++){
            if(caracteres[i] == caracter)
                posiciones.add(i);
        }
        return posiciones;
    }
    
    public void eliminarCaracterEn(int pos){
       if((pos >= 0) && (pos <= caracteres.length)){
           for(int i=pos ; i < caracteres.length-1 ; i++){
              caracteres[i] = caracteres[i+1]; 
           }
       }else{
           System.out.println("Posicion fuera de rango");
       } 
    }
    
    public void concatenar(Texto t1, Texto t2){
        if((t1.dim + t2.dim) <= max){
            int fint1 = t1.dim ;
            System.out.println(t1.dim);
            System.out.println(t2.caracteres.length - t1.dim);
            for(int i=0 ; i < t2.caracteres.length - t1.dim ; i++){
                caracteres[fint1+i] = t2.caracteres[i];
            }
       }else
            System.out.println("No se puede concatenar, el tamaño es mayor qu el maximo");
    }
    
    public String toString(){
        String s ="[ ";
        for(int i=0 ; i < caracteres.length   ; i++){
            if(i < caracteres.length -1)
                s = s + caracteres[i] +", ";
            else
                s = s + caracteres[i] +"]";
        }
        return s;
    }
    
    public String toString2(){
        String s ="";
        for(int i=0 ; i < caracteres.length   ; i++){
                s = s + caracteres[i] ;
        }
        return s;
    }
    public void insertarPal(Texto t,String cadena){
        //System.out.println(dim);
        if(t.caracteres.length >= cadena.length() ){
            int j = 0;
           for(int i=t.dim ; i<=cadena.length() ; i++){
               t.insertarEn( i, cadena.charAt(j));
               //dim++;
               j++;
           } 
        }
    }
    
}
