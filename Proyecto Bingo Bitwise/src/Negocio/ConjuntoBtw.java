
package Negocio;


public class ConjuntoBtw {
    bitwise c[];
    public int cant;
    int inicio, fin ;

    public ConjuntoBtw( int nele) {
        int nbw = nele / 32;
        if(nele%32 != 0 ){
            nbw++ ;
        }
        this.c = new bitwise[nbw] ;
        cant = nele;
        for(int i=0 ; i <= nbw-1 ; i++){
            c[i] = new bitwise();
        }
    } 
    
    public void insertar(int ele){
        if(ele <= cant){
            int nbw = calcNBW(ele);
            int nbit = calcNbit(ele);
            c[nbw].setbit1(nbit);
        }else{
            System.out.println("Error: ConjuntoBit: Insertar:  fuera de rango");
            System.exit(1);
        }
    }
    
    public void eliminar(int ele){
        if(ele <= cant){
            int nbw = calcNBW(ele);
            int nbit = calcNbit(ele);
            c[nbw].setbit0(nbit);
            if(nbw == c.length){
                
            }
        }else{
            System.out.println("Error: ConjuntoBit: Insertar:  fuera de rango");
            System.exit(1);
        }
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
    
    public void insertar2(int ele){
        if(ele > cant){
            while(ele > cant){
                redimencionar();
            }
        }
        int nbw = calcNBW(ele);
        int nbit = calcNbit(ele);
        c[nbw].setbit1(nbit);

    }
    
    public void eliminar2(int ele){
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
    
    public int[] getNumeros() {
        int count = 0;
        for (int i = 1; i <= cant; i++) {
            if (Pertenece(i)) {
                count++;
            }
        }

        int[] numeros = new int[count];
        int index = 0;
        for (int i = 1; i <= cant; i++) {
            if (Pertenece(i)) {
                numeros[index++] = i;
            }
        }
        return  numeros;
    }
    
    @Override
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
    
    public String toStringRango(){
        String s = "C = { ";
        int cantb = fin - inicio;
        for(int i=1; i <= cantb+1; i++){
            if(Pertenece(i))
                if(i < cant)
                    s = s + ((inicio+i)-1) + " , ";
                    else
                    s = s + ((inicio+i)-1) + " ";
        }
        s = s + "}";
        return s;
    }
    
    
}
