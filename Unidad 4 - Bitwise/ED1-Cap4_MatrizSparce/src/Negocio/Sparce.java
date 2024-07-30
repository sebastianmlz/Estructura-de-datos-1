
package Negocio;

public class Sparce {
    float VD[] ;//vector de datos o elementos, para este caso son numeros reales
    int VFC[]; //vector de posiciones
    int dim;
    int m;
    int n;
    int e; //elementos dominantes
    
    public Sparce(int nf, int nc, int ele){ //constructor de la matriz esparcida
        VFC = new int[10];
        VD = new float[10];
        n = nc;
        m = nf;
        dim = -1;
        e = ele;
    }
    
    public void setDato(int f, int c, float dato){
        if((f>0) && (c>0) && (f<=m) && (c<=n)){
           int fc = (f-1) * n + c; 
           int pos = buscar(fc);
           if(pos != -1){
               if(dato == e){
                   dim--;
                   for(int i=pos ; i<dim ; i++){
                       VFC[i] = VFC[i+1];
                       VD[i] = VD[i+1];
                   }
               }else
                   VD[pos] = dato;
           }else{
               if(dato!=e){
                   Redimencionar();
                   dim++ ;
                   VD[dim] = dato;
                   VFC[dim] = (f-1) *n + c;
               }
           }
        }else
            System.out.println("Error: La fila o columna esta fuera de rango");
    }
    
    private int buscar(int fc){
        int i = 0;
        while((i<=dim) && (VFC[i] != fc)){
            i++;
        }
        if(i>dim)
            return -1;
        else
            return i;
    }
    
    private void Redimencionar(){
        if((dim%9 ==0) && (dim!=0)){
            float vaux[] = new float[dim + 10];
            System.arraycopy(VD, 0, vaux, 0, dim+1);
            VD = new float[dim+10];
            System.arraycopy(vaux, 0, VD, 0, dim+1);
            int vfc2[] = new int[dim+10];
            System.arraycopy(VFC, 0, vfc2, 0, dim+1);
            VFC = new int[dim+10];
            System.arraycopy(vfc2, 0, VFC, 0, dim+1);
        }
    }
    
    public float getDato(int f,int c){
        float valor = e;
        if((f>0) && (c>0) && (f<=m) && (c<=n)){
            int pos = buscar((f-1) * n + c);
            if(pos != -1)
                valor = VD[pos];
        }else
            System.out.println("Error: fila o columna fuera de rango");
        return valor;
    }
    
    public String toStringFila(int fila){
        String s = "";
        if((fila>0) && (fila<=m)){
            for(int i=0 ; i<n ; i++){
                s = s + " " + getDato(fila, i+1);
            }
        }
        return s;
    }
    
}
