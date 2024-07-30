
package Negocio;

import javax.swing.JOptionPane;

public class PolinomioRealBits {

    MonomioRealBits p[];
    int dim;
    
    public PolinomioRealBits(int cant){ //constructor parametrizado
        dim = -1;
        p = new MonomioRealBits[cant]; // se define la dimension del arreglo
        for(int i=0 ; i<cant ; i++){ //se inicializa cada casilla del arreglo por ser un TDA compuesto
            p[i] = new MonomioRealBits('+', 0, 0,0,0);
            
        }
    }
    
    public PolinomioRealBits(){
        this.p = new MonomioRealBits[10];
        this.dim = -1;
    }
    
    public void insertar(MonomioRealBits A){
        if(vacia()){
            dim ++ ;
            p[dim] = A;
        }else{
            int aux = 0;
            while((aux <= dim)&& (A.getExponente().valor()< p[aux].getExponente().valor())){
                aux ++ ;
            }
            
            if(aux <= dim){
                if((p[aux].getExponente().getNumerador() == A.getExponente().getNumerador()) && (p[aux].getExponente().getDenominador()!= A.getExponente().getDenominador())){
                    Redimencionar();
                    for(int i=dim ; i >= aux ; i--){
                        p[i+1] = p[i];
                    }
                    p[aux] = A;
                    dim++ ;
                }else if((p[aux].getExponente().getNumerador() != A.getExponente().getNumerador()) && (p[aux].getExponente().getDenominador() == A.getExponente().getDenominador())){
                    Redimencionar();
                    for(int i=dim ; i >= aux ; i--){
                        p[i+1] = p[i];
                    }
                    p[aux] = A;
                    dim++ ;
                }else if((p[aux].getExponente().getNumerador() != A.getExponente().getNumerador()) && (p[aux].getExponente().getDenominador() != A.getExponente().getDenominador())){
                    Redimencionar();
                    for(int i=dim ; i >= aux ; i--){
                        p[i+1] = p[i];
                    }
                    p[aux] = A;
                    dim++ ;
                }else{
                    FraccionBits total = new FraccionBits();
                    total.Sumar(p[aux].getCoeficiente(), A.getCoeficiente());
                    
                    if((total.getNumerador() != 0) && (total.getDenominador()!= 0)){
                        p[aux].setCoeficiente(total.getNumerador(), total.getDenominador());
                        p[aux].setSigno(total.getSigno());
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
        MonomioRealBits copia[] = new MonomioRealBits[p.length];
        System.arraycopy(p, 0, copia, 0, p.length);
        p = new MonomioRealBits[p.length + 1];
        System.arraycopy(copia, 0, p, 0, copia.length);
    }
    
    public MonomioRealBits getMonomio(FraccionBits exp){
        int pos=-1;
        boolean encontrado = false;
        int j=0;
        while(encontrado==false && j<=dim){
            if((p[j].getExponente().getNumerador()== exp.getNumerador()) && (p[j].getExponente().getDenominador()== exp.getDenominador())){
                encontrado = true;
                pos = j;
                j = dim;
            }
            j++;
        }
        if(encontrado == true){
            return p[pos];
        }else{
            JOptionPane.showMessageDialog(null, "No existe monomio con este exponente en este polinomio");
            return null;
        }
     
    }
    
    private int posGrado(FraccionBits x){
        int i = 0;
        while(((p[i].getExponente().getNumerador()!= x.getNumerador()) || (p[i].getExponente().getDenominador()!= x.getDenominador())) && (i < dim)){
            i++ ;
        }
        if((p[i].getExponente().getNumerador()== x.getNumerador()) && (p[i].getExponente().getDenominador()== x.getDenominador()))
            return i;
        else
            return -1;
    }
    
    public boolean existeGrado( FraccionBits grado){
     return posGrado(grado)!= -1; 
    }
    
    public void eliminar(FraccionBits grado){
        if(existeGrado(grado)){
            int c = posGrado(grado);
            if(c == dim){
                dim-- ;
            }else{
                for(int i=c ; i < dim ; i++){
                    p[i]= p[i+1] ;
                }
                dim-- ;
            }
        }
    }
    
    public float valorX(int x){
        float aux = 0;
        for(int i=0 ; i<=dim ; i++){
            aux = aux + p[i].Evaluar(x);
        }
        return aux;
    }
    
    public FraccionBits grado(){
        FraccionBits expMax = p[1].getExponente();
        for(int i=0 ; i <= dim ; i++){
            if(p[i].getExponente().valor() > expMax.valor()){
                expMax = p[i].getExponente();
            }
        }
        return expMax;
    }
    
    public MonomioRealBits obtenerElemento(int pos){
        MonomioRealBits m;
        for(int i=0 ; i <= dim; i++){
           if(i+1 == pos){
               m = p[i];
               return m;
           }
        }
       return null;
    }
    
    public void insertarP(PolinomioRealBits A){
       for(int i=0; i<A.dim ; i++){
            insertar(A.obtenerElemento(i+1));
        } 
    }
    
    public void sumarP(PolinomioRealBits A, PolinomioRealBits B){
        insertarP(A);
        insertarP(B);
    }
    
    public void sumar(PolinomioRealBits A, PolinomioRealBits B){
        for(int i=0; i<=A.dim ; i++){
            insertar(A.obtenerElemento(i+1));
        }
        for(int j=0; j<=B.dim ; j++){
            insertar(B.obtenerElemento(j+1));
        }
    }
    
    public void restar(PolinomioRealBits A, PolinomioRealBits B){
        MonomioRealBits c,p ;
        for(int i=0; i<=A.dim ; i++){
            insertar(A.obtenerElemento(i+1));
        }
        for(int j=0; j<=B.dim ; j++){
            p = B.obtenerElemento(j+1);
            c = new MonomioRealBits(p.getSigno(), p.getCoeficiente().getNumerador(), p.getCoeficiente().getDenominador(),p.getExponente().getNumerador(), p.getExponente().getDenominador());
            if(B.obtenerElemento(j+1).getSigno() == '+'){
                c.setSigno('-');
                //B.obtenerElemento(j+1).setSigno('-');
            }else
                c.setSigno('+');
                //B.obtenerElemento(j+1).setSigno('+');
            insertar(c);
        }
    }
    
    public void multiplicar(PolinomioRealBits A, PolinomioRealBits B){
        MonomioRealBits m1 , m2 ;
        MonomioRealBits m3 ;
        for(int i=0 ; i<=A.dim ; i++){
            m1 = A.obtenerElemento(i+1);
            for(int j=0 ; j<=B.dim ; j++){
                m2 = B.obtenerElemento(j+1);
                m3 = new MonomioRealBits();
                m3.Multiplicar(m1, m2);
                insertar(m3);
            }
        }
    }
    
    @Override
    
    public String toString(){
        String s = "Q(x)= ";
        for(int i=0 ; i<=dim ; i++){
            s = s + p[i].toStringG();
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
