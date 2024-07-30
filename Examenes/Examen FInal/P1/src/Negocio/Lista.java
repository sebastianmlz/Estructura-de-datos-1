package Negocio;

public class Lista {

    Nodo L;
    int cant;

    public Lista() {
        this.L = null;
        this.cant = 0;
    }

    public boolean vacia() {
        return cant == 0;
    }

    public int getcant() {
        return cant;
    }

    public void insertar(int elemento) {
        if (vacia()) {
            Nodo p = new Nodo();
            p.setDato(elemento);
            L = p;
            cant++;
        } else { 
            Nodo aux = L;
            Nodo ant = null;
            while ((aux != null) && (aux.getDato() <= elemento)) {
                ant = aux;
                aux = aux.getEnlace();
            }
            if (ant == null) { 
                Nodo p = new Nodo();
                p.setDato(elemento);
                p.setEnlace(L);
                L = p;
                cant++;
            } else {
                Nodo p = new Nodo();
                p.setDato(elemento);
                ant.setEnlace(p);
                p.setEnlace(aux);
                cant++;
            }
        }
    }

    public void eliminar(int elemento) {
        if (!vacia()) {
            Nodo aux = L;
            Nodo ant = null;
            while ((aux != null) && (aux.getDato() != elemento)) {
                ant = aux;
                aux = aux.getEnlace();
            }
            if (aux != null) {
                if (ant == null) {
                    L = L.getEnlace();
                    cant--;
                } else {
                    ant.setEnlace(aux.getEnlace());
                    cant--;
                }
            }
        }
    }

    public boolean existe(int elemento) {
        boolean x = false;
        if (!vacia()) {
            Nodo aux = L;
            while ((aux != null) && (aux.getDato() != elemento)) {
                aux = aux.getEnlace();
            }
            if (aux != null) {
                x = true;
            }
        }
        return x;
    }

    public int getDato(int pos) {
        Nodo aux = L;
        for (int i = 1; i < pos; i++) {
            aux = aux.getEnlace();
        }
        return (aux.getDato());
    }


    public void eliminarElemRepetidosySimismo(){
        if(getcant() > 1){
            Nodo ant = null;
            Nodo aux = L;
            Nodo aux2 = aux.getEnlace();
            int dato = aux.getDato()-1;
            while(aux2 != null){
                if(ant == null){
                    if(aux.getDato() == aux2.getDato()){
                        dato = aux.getDato();
                        if(aux2.getEnlace() != null){
                            L = aux2.getEnlace();
                            ant = null;
                            aux = L;
                            aux2 = aux.getEnlace();
                        }else{
                            L = null;
                            aux2 = null;
                        }
                        cant = cant-2;
                    }else{
                        if(aux.getDato() == dato){
                            L = aux2;
                            aux = L;
                            aux2 = aux.getEnlace();
                            cant--;
                        }else{
                            ant = aux;
                            aux = aux2;
                            aux2 = aux2.getEnlace();
                        }
                    }
                }else{
                    if((ant.getDato() == aux.getDato())){
                        L = aux2;
                        ant = aux2;
                        aux = ant.getEnlace();
                        aux2 = aux.getEnlace();
                        cant = cant-2;
                    }else{
                        if(aux.getDato() == aux2.getDato()){
                            dato = aux.getDato();
                            ant.setEnlace(aux2.getEnlace());
                            if(aux2.getEnlace() != null){
                                aux = ant.getEnlace();
                                aux2= aux.getEnlace();
                            }else
                                aux2 = null;
                            cant = cant-2;
                        }else{
                            if(aux.getDato() == dato){
                                ant.setEnlace(aux2);
                                aux = aux2;
                                aux2 = aux.getEnlace();
                                cant--;
                            }else{
                                ant = aux;
                                aux = aux2;
                                aux2 = aux2.getEnlace();
                            }
                        }
                    }
                }
            }
            if((ant != null) ){
                if((ant.getDato() == aux.getDato())){
                    L.setEnlace(null);
                    cant = cant-2;
                }else{
                    if(aux.getDato() == dato){
                        ant.setEnlace(null);
                        cant--;
                    }
                }
            }else{
                if(getcant()>0){
                    if(aux.getDato() == dato){
                        L = null;
                        cant--;
                    }
                }
                
            }
        }
    }

    @Override
    public String toString() {
        String s = "L-> < ";
        Nodo aux = L;
        while (aux != null) {
            s = s + aux.getDato() + ",";
            aux = aux.getEnlace();
        }
        return s + " >";
    }


}
