
package Negocio;

public class Nodo {
    
    int dato;
    int exp;
    Nodo enlace;
    
    public Nodo(){
        enlace = null;
    }
    
    public Nodo(int dato,int exp, Nodo enlace){
        this.dato = dato;
        this.exp = exp;
        this.enlace = enlace;
    }

    public int getDato() {
        return dato;
    }

    public void setDato(int dato) {
        this.dato = dato;
    }
    
    public int getExp() {
        return exp;
    }

    public void setExp(int exp) {
        this.exp = exp;
    }

    public Nodo getEnlace() {
        return enlace;
    }

    public void setEnlace(Nodo enlace) {
        this.enlace = enlace;
    }
    
    @Override
    public String toString(){
        String s="[";
        s = s + getDato() + " | "+getExp()+" | ]";
        return s;
    }
    
    /*public static void main(String[] args) {
        Nodo n = new Nodo();
        n.setDato(3);
        System.out.println(n);
        
        Nodo n2 = new Nodo(5,3, n);
        System.out.println(n2 + " -> "+ n2.getEnlace());
    }*/
    
}
