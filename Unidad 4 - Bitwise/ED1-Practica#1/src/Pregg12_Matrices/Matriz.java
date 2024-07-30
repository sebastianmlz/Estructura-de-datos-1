
package Pregg12_Matrices;


public class Matriz {
    int [][] matriz;
    int filas;
    int columnas;

    public Matriz( int filas, int columnas) {
        this.filas = filas;
        this.columnas = columnas;
        this.matriz = new int[filas][columnas];
    }
    
    public void Asignar(int elemento, int fila, int columna){
        matriz[fila-1][columna-1] = elemento;
    }
    
    public void AsignarS(int elemento, int fila, int columna){
        matriz[fila][columna] = elemento;
    }
    
    public int ObtenerElemento(int fila, int columna){
        return matriz[fila-1][columna-1];
    }
    
    public  void Sumar(Matriz m1, Matriz m2){
       if(m1.filas == m2.filas && m1.columnas ==m2.columnas){
            for(int i=0 ; i<m1.filas ; i++){
                for(int j=0 ; j<m1.columnas ; j++){
                     AsignarS(m1.matriz[i][j] + m2.matriz[i][j], i, j);
                }
            }
       }else
            System.out.println("Error al sumar: las matrices no tienen las mismas dimensiones");
    }
    
    public void ProductoEscalar(Matriz m, int valor){
        for(int i=0 ; i<filas ; i++){
            for(int j=0 ; j<columnas ; j++){
                Asignar(m.matriz[i][j] * valor, i, j);
            }
        }
    }
    
    @Override

    public String toString(){
        String s = "";
        for(int i=0 ; i<filas ; i++){
            for(int j=0 ; j<columnas ; j++){
                if(j == 0)
                    s = s+"|  "+matriz[i][j];
                    else
                        s = s +"  "+matriz[i][j];
                if(j == columnas-1)
                    s = s + " |\n";
            }
        }
        s = s + "------------------------";
        return s;
    }

    
    
}
