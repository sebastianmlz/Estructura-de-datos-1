
package Negocio;

public class ConjuntoRangoBtw {
    bitwise c[];
    public int cant;
    int inicio, fin ;
    
    public ConjuntoRangoBtw(int inicio, int fin){
        this.inicio = inicio;
        this.fin = fin;
        int nbw = (fin - inicio +1) / 32;
        if((fin-inicio +1) % 32 !=0)
           nbw++ ;
        this.c = new bitwise[nbw] ;
        this.cant = fin - inicio +1;
        for(int i=0 ; i <= nbw-1 ; i++){
            c[i] = new bitwise();
        }
    }
    
    public void insertarRango(int ele){
        if(ele >= inicio && ele <= fin){
            int nbw = calcNBWRango(ele);
            int nbit = calcNbitRango(ele);
            c[nbw].setbit1(nbit);
        }else{
            System.out.println("Error: ConjuntoBit: Insertar:  fuera de rango");
            System.exit(1);
        }
    }
    
    public void eliminarRango(int ele){
        if(ele >= inicio && ele <= fin){
            int nbw = calcNBWRango(ele);
            int nbit = calcNbitRango(ele);
            c[nbw].setbit0(nbit);
        }else{
            System.out.println("Error: ConjuntoBit: Insertar:  fuera de rango");
            System.exit(1);
        }
    }
    
    
    public int calcNBWRango(int ele){
        return ((ele-inicio) / 32);
    }
    
    public int calcNbitRango(int ele){
       return (((ele-inicio) % 32)+1); 
    }
    
    public boolean Pertenece(int ele){
        int nbw = calcNBWRango(ele);
        int nbit = calcNbitRango(ele);
        return c[nbw].getBit(nbit) == 1;
    }
    
    @Override
    public String toString(){
        String s = "C = { ";
        for(int i=inicio; i <= fin; i++){
            if(Pertenece(i))
                if(i < fin)
                    s = s + (i) + " , ";
                    else
                    s = s + i + " ";
        }
        s = s + "}";
        return s;
    }
    
}
