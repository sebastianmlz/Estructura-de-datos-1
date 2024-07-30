
package Negocio;

public class ConjuntoDinamicoBtw {
    bitwise c[];
    public int cant;
    int inicio, fin ;
    
    public ConjuntoDinamicoBtw(){
        this.c = new bitwise[1];
        this.cant = 32;
        c[0] = new bitwise();
    }
    
    public int calcNBW(int ele){
        return ((ele-1) / 32);
    }
    
    public int calcNbit(int ele){
       return (((ele-1) % 32)+1); 
    }
    
    public boolean Pertenece(int ele){
        int nbw = calcNBW(ele);
        int nbit = calcNbit(ele);
        return c[nbw].getBit(nbit) == 1;
    }
    
    public void insertar(int ele){
        if(ele > cant){
            while(ele > cant){
                redimencionar();
            }
        }
        int nbw = calcNBW(ele);
        int nbit = calcNbit(ele);
        c[nbw].setbit1(nbit);

    }
    
    public void eliminar(int ele){
        if(ele <= cant){
            int nbw = calcNBW(ele);
            int nbit = calcNbit(ele);
            c[nbw].setbit0(nbit);
            if(vacio(c)){
                decrementar();
            }
        }
    }
    
    public void redimencionar(){
        bitwise c1[] = new bitwise[c.length];
        System.arraycopy(c, 0, c1, 0, c.length);
        c = new bitwise[c1.length + 1];
        for(int i=0 ; i <= c.length-1 ; i++){
            c[i] = new bitwise();
        }
        System.arraycopy(c1, 0, c, 0, c1.length);
        cant = cant+32;
    }
    
    public void decrementar(){
        bitwise c1[] = new bitwise[c.length];
        System.arraycopy(c, 0, c1, 0, c.length);
        c = new bitwise[c1.length - 1];
        for(int i=0 ; i <= c.length-1 ; i++){
            c[i] = new bitwise();
        }
        System.arraycopy(c1, 0, c, 0, c.length);
        cant = cant-32;
    }
    
    public  boolean vacio(bitwise b[]){
        boolean bol = true;
        for(int i=b.length-1; i<b.length; i++){
            for(int j=0; j<32; j++){
                if(b[i].getBit(j) == 1){
                    bol = false;
                    return bol; 
                }
            }
        }
        return bol;
    }
    
    public int cantBitwise(){
        return c.length;
    }
    
    public String toString(){
        String s = "C = { ";
        for(int i=1; i <= cant; i++){
            if(Pertenece(i))
                if(i < cant)
                    s = s + i + " , ";
                    else
                    s = s + i + " ";
        }
        s = s + "}";
        return s;
    }
    
}
