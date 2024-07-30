
package Negocio;

import java.util.Optional;
import javax.swing.JOptionPane;

public class PolinomioBits {
    Monomio_NBits p[];
    int dim;
    
    public PolinomioBits(int cant){ //constructor parametrizado
        dim = -1;
        p = new Monomio_NBits[cant]; // se define la dimension del arreglo
        for(int i=0 ; i<cant ; i++){ //se inicializa cada casilla del arreglo por ser un TDA compuesto
            p[i] = new Monomio_NBits('+', 0, 0);
            
        }
    }
    
    public PolinomioBits(){
        this.p = new Monomio_NBits[10];
        this.dim = -1;
    }
    
    public void insertar(Monomio_NBits A){
        if(vacia()){
            dim ++ ;
            p[dim] = A;
        }else{
            int aux = 0;
            while((aux <= dim) && (A.getExponente()< p[aux].getExponente())){
                aux ++ ;
            }
            
            if(aux <= dim){
                if(p[aux].getExponente() != A.getExponente()){
                    Redimencionar();
                    for(int i=dim ; i >= aux ; i--){
                        p[i+1] = p[i];
                    }
                    p[aux] = A;
                    dim++ ;
                }else{
                    Monomio_NBits total = new Monomio_NBits();
                    total.Sumar(p[aux], A);
                    if(total.getCoeficiente() != 0){
                        p[aux] = total;
                       // p[aux].setCoeficiente(total.getCoeficiente());
                        //.setSigno(total.getSigno());
                    }else{
                        for(int j=aux ; j < dim ; j++){
                            p[j] = p[j+1] ;
                        }
                        dim-- ;
                    }
                }
            }else{
                Redimencionar();
                dim++ ;
                p[dim] = A;
            }
        }
    }
    
    private boolean vacia(){
        return dim == -1;
    }
    
    public int cantidad(){
        int cant = 0;
        for(int i=0 ;i<=dim ; i++){
            cant++ ;
        }
        return cant;
    }
    
    private void Redimencionar(){
        Monomio_NBits copia[] = new Monomio_NBits[p.length];
        System.arraycopy(p, 0, copia, 0, p.length);
        p = new Monomio_NBits[p.length + 1];
        System.arraycopy(copia, 0, p, 0, copia.length);
    }
    
    public Monomio_NBits getMonomio(int exp){
        int pos=-1;
        boolean encontrado = false;
        int j=0;
        while(encontrado==false && j<=dim){
            if(p[j].getExponente()== exp){
                encontrado = true;
                pos = j;
                j = dim;
            }
            j++;
        }
        if(encontrado == true){
            return p[pos];
        }else{
            return null;
        }
    }

    private int posGrado(int x){
        int i = 0;
        while(p[i].getExponente()!= x && i < dim){
            i++ ;
        }
        if(p[i].getExponente()== x)
            return i;
        else
            return -1;
    }
    
    public boolean existeGrado( int grado){
     return posGrado(grado)!= -1; 
    }
    
    public void eliminar(int grado){
        if(existeGrado(grado)){
            int c = posGrado(grado);
            if(c == dim){
                dim-- ;
            }else{
                for(int i=c ; i <= dim ; i++){
                    p[i]= p[i+1] ;
                }
                dim-- ;
            }
        }
    }
    
    public int valorX(int x){
        int aux = 0;
        for(int i=0 ; i<=dim ; i++){
            aux = aux + p[i].Evaluar(x);
        }
        return aux;
    }
    
    public int grado(){
        int expMax = p[1].getExponente();
        for(int i=0 ; i <= dim ; i++){
            if(p[i].getExponente()> expMax)
                expMax = p[i].getExponente();
        }
        return expMax;
    }
    
    public Monomio_NBits obtenerElemento(int pos){
        Monomio_NBits m ;
        for(int i=0 ; i <= dim; i++){
           if(i+1 == pos){
               m = p[i];
               return m;
           }
        }
       return null;
    }
    
    public void insertarP(PolinomioBits A){
       for(int i=0; i<=A.dim ; i++){
            insertar(A.obtenerElemento(i+1));
        } 
    }
    
    public void sumarP(PolinomioBits A, PolinomioBits B){
        insertarP(A);
        insertarP(B);
    }
    
    public void sumar(PolinomioBits A, PolinomioBits B){

        for(int i=0; i<=A.dim ; i++){
            insertar(A.obtenerElemento(i+1));
        }
        for(int j=0; j<=B.dim ; j++){
            insertar(B.obtenerElemento(j+1));
        }
    }
    
    public void restar(PolinomioBits A, PolinomioBits B){
        Monomio_NBits c ;
        for(int i=0; i<=A.dim ; i++){
            insertar(A.obtenerElemento(i+1));
        }
        for(int j=0; j<=B.dim ; j++){
            if(B.obtenerElemento(j+1).getSigno() == '+'){
                c = new Monomio_NBits(B.obtenerElemento(j+1).getSigno(), B.obtenerElemento(j+1).getCoeficiente(), B.obtenerElemento(j+1).getExponente());
                c.setSigno('-');
            }else{
                c = new Monomio_NBits(B.obtenerElemento(j+1).getSigno(), B.obtenerElemento(j+1).getCoeficiente(), B.obtenerElemento(j+1).getExponente());
                c.setSigno('+');
            }
            insertar(c);
        }
    }
    
    public void multiplicar(PolinomioBits A, PolinomioBits B){
        Monomio_NBits m1 , m2 ;
        Monomio_NBits m3 = new Monomio_NBits();
        for(int i=0 ; i<=A.dim ; i++){
            m1 = A.obtenerElemento(i+1);
            for(int j=0 ; j<=B.dim ; j++){
                m2 = B.obtenerElemento(j+1);
                insertar(m3.Multiplicar(m1, m2));
            }
        }
    }
    
    @Override
    
    public String toString(){
        String s = " ";
        for(int i=0 ; i<=dim ; i++){
            s = s + p[i];
        }
        return s;
    }
    
    public String toString2(){
        String s="Q(x)= ";
        for(int i=0 ; i<=dim ; i++){
            s = s + p[i];
        }
        return s;
    }    
}
