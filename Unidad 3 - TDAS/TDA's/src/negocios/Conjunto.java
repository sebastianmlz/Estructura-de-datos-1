
package negocios;


public class Conjunto { int C[]; int dim;

    public Conjunto() {
        this.C = new int [10];
        this.dim = -1;
    }
    
    public boolean vacia() {
        return (dim == -1);
    }
    
    public void insertar(int ele){
        if(vacia()){
            dim++;
            C[dim] = ele;  
        }else{
            if(!pertenece(ele)){
                redimencionar();
                dim++;
                C[dim] = ele;
            }
        }
    }
    
    public void eliminar(int ele){
        if(!vacia()){
            int i=0;
            while((i <= dim) && (C[i]!=ele)){
                i++;
            }
            if(i <= dim){
                for(int j=i; j<dim; j++){
                    C[j] = C[j+1];
                }
                dim--;
            }    
        }
    }
    
    public boolean pertenece(int ele){
        int i = 0;
        while((i <= dim) && (C[i] != ele)){
            i++;
        }
        return (i <=dim);
    }
    
    public void redimencionar(){
        if(dim == C.length -1 ){
            int C1[] = new int[C.length];
            System.arraycopy(C, 0, C1, 0, C.length);
            C = new int[C1.length + 10];
            System.arraycopy(C1, 0, C, 0, C1.length);
        }
    }
    
    public void union(Conjunto A, Conjunto B){
        for(int i=0 ; i <= A.dim ; i++){
            insertar(A.C[i]);
        }
        for(int j=0 ; j <= B.dim ; j++){
            insertar(B.C[j]);
        }
    }
    
    public void interseccion(Conjunto A, Conjunto B){
        for(int i=0 ; i <= A.dim ; i++){
            if(B.pertenece(A.C[i])){
                insertar(A.C[i]);
            }
        }
    }
    
    @Override
    public String toString(){
        String s ="{ ";
        for(int i=0 ; i <= dim ; i++){
            if(i < dim)
                 s = s + C[i] + ", ";
            else
                s = s + C[i];
        }
        s = s + " )";
        return s;
    }
  
    
}
