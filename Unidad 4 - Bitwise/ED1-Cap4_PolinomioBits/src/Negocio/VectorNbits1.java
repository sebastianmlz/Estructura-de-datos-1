/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Negocio;

/**
 *
 * @author Estefany
 */
public class VectorNbits1 { int V[];
                            int dim;
                            int nbits;

    public VectorNbits1(int cant,int nbits) {
        int nb=cant*nbits;
        int NE=nb/32;
        if ((nb%32)!=0){
            NE++;
           }
        V=new int[NE];
        this.dim = cant;
        this.nbits=nbits;
    }
    
    public int calcularE (int pos) {
    return(((pos-1)*nbits)/32);
    }
    
    public int calcularB (int pos) {
    return(((pos-1)*nbits)%32);
    }
     
    public void insertar(int valor, int posicion){
    int valor1=valor;
    int mask=(int)Math.pow(2,nbits)-1;
    int NumE=calcularE(posicion);
    int NumB=calcularB(posicion);
    mask=mask<<NumB;
    mask=~mask;
    V[NumE]=V[NumE]&mask;
    valor=valor<<NumB;
     V[NumE]=V[NumE]|valor;
    if ((NumB+nbits)>32){ //falta bits
        int mask1=(int)Math.pow(2,nbits)-1;
        mask1=mask1>>>(32-NumB);
        valor1=valor1>>>(32-NumB);
        mask1=~mask1;
         V[NumE+1]=V[NumE+1]&mask1;
         V[NumE+1]=V[NumE+1]|valor1;
       }
    }
                            
  public int get(int posicion){
    int mask=(int)Math.pow(2,nbits)-1;
    int NumE=calcularE(posicion);
    int NumB=calcularB(posicion);
    mask=mask<<NumB;
    mask=mask&V[NumE];
    mask=mask>>>NumB;
    if ((NumB+nbits)>32){ //falta bits
        int mask1=(int)Math.pow(2,nbits)-1;
        mask1=mask1>>>(32-NumB);
        mask1=mask1&V[NumE+1];
        mask1=mask1<<(32-NumB);
        mask=mask|mask1;
       }
    return mask;  
}

    @Override
    public String toString() {
        String S="V={";
        for (int i = 1; i <= dim; i++) {
            S=S+get(i)+" , ";
            
        }
        S=S+"}";
        return S;
    }
  
  
  
}