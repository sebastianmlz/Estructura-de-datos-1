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

    public void insertar(int elemento,int exponente) {
        if (vacia()) {
            Nodo p = new Nodo();
            p.setDato(elemento);
            p.setExp(exponente);
            L = p;
            cant++;
        } else { 
            Nodo aux = L;
            Nodo ant = null;
            Nodo ant2 = null;
            while ((aux != null) && (aux.getExp() >= exponente)) {
                ant2 = ant;
                ant = aux;
                aux = aux.getEnlace();
            }
            if (ant == null) { 
                if(aux.getExp() == exponente){
                    aux.setDato((aux.getDato()+elemento));
                    if(aux.getDato() == 0){
                        ant.setEnlace(aux.getEnlace());
                    }
                }else{
                    Nodo p = new Nodo();
                    p.setDato(elemento);
                    p.setExp(exponente);
                    p.setEnlace(L);
                    L = p;
                    cant++;
                }
            } else {
                if (ant.getExp() != exponente) { // si no existe ese exponente
                    Nodo p = new Nodo();
                    p.setDato(elemento);
                    p.setExp(exponente);
                    ant.setEnlace(p);
                    p.setEnlace(aux);
                    cant++;
                }else{ // si existe ese exponente
                    ant.setDato((ant.getDato()+elemento));
                    if(ant.getDato() == 0){
                        ant2.setEnlace(ant.getEnlace());
                        ant.setEnlace(null);
                    }
                }
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

    @Override
    public String toString() {
        String s = "L-> ";
        Nodo aux = L;
        while (aux != null) {
            s = s + "[ "+aux.getDato()+" | "+aux.getExp()+" ] -> ";
            //s = s + aux.getDato() + ",";
            aux = aux.getEnlace();
        }
        return s + "";
    }

   

}
