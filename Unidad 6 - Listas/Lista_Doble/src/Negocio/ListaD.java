/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Negocio;

/**
 *
 * @author sebas
 */
public class ListaD {

    NodoD Primero; // apunta a la primer Nodo
    NodoD Ultimo; // Apunta hacia el ultimo nodo
    int Cantidad;
    
    public ListaD() {
        this.Primero = null;
        this.Ultimo = null;
        this.Cantidad = 0;
    }
    
    private boolean vacia() {
        return (Cantidad == 0);
    }
    
    public void insertar(int ele) {
        NodoD Nuevo = new NodoD(ele);
        if (vacia()) {
            this.Primero = Nuevo;
            this.Ultimo = Nuevo;
            this.Cantidad++;
        }else{
            NodoD aux = this.Primero;
            while ((aux != null) && (aux.getData() < ele)) {
                aux = aux.getEnlaceD();
            }
            if (aux == this.Primero) {//Insertar en el inicio
                if (ele != aux.getData()) {
                    Nuevo.setEnlaceD(this.Primero);
                    this.Primero.setEnlaceI(Nuevo);
                    this.Primero = Nuevo;
                    this.Cantidad++;
                }
            }else{
                if (aux != null) {//Insertar en el cuerpo
                    if (aux.getData() != ele) {
                        Nuevo.setEnlaceD(aux);
                        Nuevo.setEnlaceI(aux.getEnlaceI());
                        aux.getEnlaceI().setEnlaceD(Nuevo);
                        aux.setEnlaceI(Nuevo);
                        this.Cantidad++;
                    }
                }else{
                    this.Ultimo.setEnlaceD(Nuevo);
                    Nuevo.setEnlaceI(this.Ultimo);
                    this.Ultimo = Nuevo;
                    this.Cantidad++;
                }
            }
        }
    }
    
    public void eliminar(int ele) {
        if (vacia()) {
            System.out.println("Error :: Eliminar : La lista esta vacia");
            System.exit(1);
        } else {
            NodoD aux = this.Primero;
            while ((aux != null) && (aux.getData() != ele)) {
                aux = aux.getEnlaceD();
            }
            if (aux != null) {//lo encontro
                if (this.Primero == this.Ultimo) {// existe un solo elemento
                    this.Primero = null;
                    this.Ultimo = null;
                }else{
                    if (aux == this.Primero) {// eliminamos el primero
                        this.Primero = this.Primero.getEnlaceD();
                        this.Primero.setEnlaceI(null);
                        this.Cantidad--;
                    }else{
                        if (aux == this.Ultimo) {//eliminmos el ultimo
                            this.Ultimo = this.Ultimo.getEnlaceI();
                            this.Ultimo.setEnlaceD(null);
                            this.Cantidad--;
                        }else{//Aqui Modificamos el cuerpo
                            aux.getEnlaceD().setEnlaceI(aux.getEnlaceI());
                            aux.getEnlaceI().setEnlaceD(aux.getEnlaceD());
                            aux.setEnlaceD(null);
                            aux.setEnlaceI(null);
                            this.Cantidad--;
                        }
                    }
                }
            }
        }
    }
    
    public int buscar(int pos) {
        NodoD N = this.Primero;
        if ((pos <= this.Cantidad) && (pos > 0)) {
            for (int i = 1; i < pos; i++) {
                N = N.getEnlaceD();
            }
            return N.getData();
        }else{
            return 0;
        }
    }
    
    /*function que devuelva
    el numero en dicha posicion*/
    public int buscarPos(int ele) {
        int p = 1;
        NodoD N = this.Primero;
        if (!vacia()) {
            while ((ele != N.getData()) && (N != this.Ultimo)) {
                N = N.getEnlaceD();
                p++;
            }
            if((N==Ultimo)&&(ele != N.getData())){
                p=0;
            }
        }
        return p;
    }
    
    public int cantNodos(){
        return this.Cantidad;
    }
    
    public void invertirDe2() {
        NodoD a ;
        NodoD b ;
        NodoD sig ;
        if (vacia()) {
            //nada
        } else {
            if (Primero.getEnlaceD() == null) {
                //nada
            } else {
                if (Cantidad % 2 == 0) {  //si la cantidad es par 
                    a = Primero;
                    b = a.getEnlaceD();
                    sig = b.getEnlaceD();
                    Primero = b;
                } else {              //si la cantidad es impar
                    a = Primero.getEnlaceD();
                    b = a.getEnlaceD();
                    sig = b.getEnlaceD();
                    Primero.setEnlaceD(b);
                }
                for (int i = 1; i <= (Cantidad / 2) - 1; i++) {
                        a.setEnlaceD(sig.getEnlaceD());
                        b.setEnlaceD(a);
                        a.setEnlaceI(b);
                        a = sig;
                        b = a.getEnlaceD();
                        sig = b.getEnlaceD();
                    }
                a.setEnlaceD(sig);
                b.setEnlaceD(a);
                b.setEnlaceI(Primero);
                a.setEnlaceI(b);
                //System.out.println(b.getEnlaceD());
            }
        }
    }
    
    
    @Override
    public String toString() {
        String cad = "P <=> ";
        NodoD N = this.Primero;
        for (int i = 1; i <= this.Cantidad; i++) {
            cad = cad + "[" + N.getData() + "] <=> ";
            N = N.getEnlaceD();
        }
        return cad + " U";
    }

}
