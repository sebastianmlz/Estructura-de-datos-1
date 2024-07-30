
package negocios;

import javax.swing.JOptionPane;

public class Polinomio {
    Monomio [] p;
    int dim ;
    
    public Polinomio(){
        this.p = new Monomio[10];
        this.dim = -1;
    }
    
    public Polinomio(int cant){ //constructor parametrizado
        dim = -1;
        p = new Monomio[cant]; // se define la dimension del arreglo
        for(int i=0 ; i<cant ; i++){ //se inicializa cada casilla del arreglo por ser un TDA compuesto
            p[i] = new Monomio('+', 0, 0);
            
        }
    }
    
    public void insertar(Monomio A){
        if(vacia()){
            dim ++ ;
            p[dim] = A;
        }else{
            int aux = 0;
            while((aux <= dim) && (A.getExp() < p[aux].getExp())){
                aux ++ ;
            }
            
            if(aux <= dim){
                if(p[aux].getExp() != A.getExp()){
                    Redimencionar();
                    for(int i=dim ; i >= aux ; i--){
                        p[i+1] = p[i];
                    }
                    p[aux] = A;
                    dim++ ;
                }else{
                    int suma = (int) p[aux].coef + A.coef;
                    if(suma != 0)
                        p[aux].coef = suma ;
                    else{
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
        for(int i=0 ;i< p.length ; i++){
            cant++ ;
        }
        return cant;
    }
    
    private void Redimencionar(){
        Monomio copia[] = new Monomio[p.length];
        System.arraycopy(p, 0, copia, 0, p.length);
        p = new Monomio[p.length + 10];
        System.arraycopy(copia, 0, p, 0, copia.length);
    }
    
    public Monomio getMonomio(int exp){
        int pos=-1;
        boolean encontrado = false;
        for(int j=0 ; j<=dim ; j++){
            if(p[j].getExp() == exp)
                encontrado = true;
                pos = j;
        }
        if(encontrado == true){
            return p[pos];
        }else{
            JOptionPane.showMessageDialog(null, "No existe monomio con este exponente en este polinomio");
            return null;
        }
     
    }
    
    private int posGrado(int x){
        int i = 0;
        while(p[i].getExp() != x && i < dim){
            i++ ;
        }
        if(p[i].getExp() == x)
            return i;
        else
            return -1;
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
            aux = (int) (aux + p[i].coef * Math.pow(x, p[i].exp));
        }
        return aux;
    }
    
    public int grado(){
        int expMax = p[1].getExp();
        for(int i = 0 ; i <= dim ; i++){
            if(p[i].getExp() > expMax)
                expMax = p[i].getExp();
        }
        return expMax;
    }
        
    public Monomio obtenerElemento(int pos){
        Monomio m;
        for(int i=0 ; i <= dim; i++){
           if(i+1 == pos){
               m = p[i];
               return m;
           }
        }
       return null;
    }
    
    public void insertarP(Polinomio A){
       for(int i=0; i<=A.dim ; i++){
            insertar(A.obtenerElemento(i+1));
        } 
    }
    
    public void sumarP(Polinomio A, Polinomio B){
        insertarP(A);
        insertarP(B);
    }
    
    public void sumar(Polinomio A, Polinomio B){
        for(int i=0; i<=A.dim ; i++){
            insertar(A.obtenerElemento(i+1));
        }
        for(int j=0; j<=B.dim ; j++){
            insertar(B.obtenerElemento(j+1));
        }
    }
    
    public void restar(Polinomio A, Polinomio B){
        for(int i=0; i<=A.dim ; i++){
            insertar(A.obtenerElemento(i+1));
        }
        for(int j=0; j<=B.dim ; j++){
            if(B.obtenerElemento(j+1).getSigno() == '+')
                B.obtenerElemento(j+1).setSigno('-');
            else
                B.obtenerElemento(j+1).setSigno('+');
            insertar(B.obtenerElemento(j+1));
        }
    }
    
    public void multiplicar(Polinomio A, Polinomio B){
        Polinomio F = new Polinomio();
        Monomio m1 , m2 ;
        Monomio m3 = new Monomio();
        for(int i=0 ; i<=A.dim ; i++){
            m1 = A.obtenerElemento(i+1);
            for(int j=0 ; j<=B.dim ; j++){
                m2 = B.obtenerElemento(j+1);
                insertar(m3.Multiplicar(m1, m2));
            }
        }
    }
    
    public boolean existeGrado( int grado){
     return posGrado(grado)!= -1; 
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
