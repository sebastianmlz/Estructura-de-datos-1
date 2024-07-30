
package Negocio;

public class vectorNbits {
    
    int v[];
    int dim;
    int nbits;

    public vectorNbits(int cant, int nbits) {
        int nb = cant * nbits;
        int ne = nb / 32;
        if(nb % 32 != 0)
            ne++ ;
        v = new int [ne];
        this.dim = cant;
        this.nbits = nbits;
    }
    
        public int calcularE(int pos){
        return (((pos-1)*nbits)/32);
    }
    
    public int calcularB(int pos){
        return (((pos-1)*nbits)%32);
    }
    
    public void insertar(int valor, int posicion){
        int valor1 = valor;
        int mask = (int) Math.pow(2, nbits)-1;
        int NumE = calcularE(posicion);
        int NumB = calcularB(posicion);
        mask = mask<<NumB;
        mask = ~mask ;
        v[NumE] = v[NumE] & mask ;
        valor = valor<<NumB;
        v[NumE] = v[NumE] | valor ;
        if(NumB+nbits > 32){
           int mask1 = (int) Math.pow(2, nbits)-1;
           mask1 = mask1>>>(32-NumB);
           valor1 = valor1>>>(32-NumB);
           mask1 = ~mask1;
           v[NumE+1] = v[NumE+1] & mask1 ;
           v[NumE+1] = v[NumE+1] | mask1 ;
        }
        
        
    }
    
    public int get( int posicion){
        int mask = (int) Math.pow(2, nbits)-1;
        int NumE = calcularE(posicion);
        int NumB = calcularB(posicion);
        mask = mask<<NumB;
        mask = mask & v[NumE];
        mask = mask>>>NumB;
        if(NumB+nbits > 32){
           int mask1 = (int) Math.pow(2, nbits)-1;
           mask1 = mask1>>>(32-NumB);
           mask1 = mask1 & v[NumE+1];
           mask1 = mask1<<(32-NumB);
        }
        return mask;
    }
    
    
    @Override
    public String toString(){
        String s="V= {";
        for(int i=1 ; i <= dim; i++){
            s = s +get(i)+ " , " ;
        }
        s = s + " }";
        return s;
    }
   

}
