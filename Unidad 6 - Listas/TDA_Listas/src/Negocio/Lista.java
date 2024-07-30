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
        } else { //hay mas elementos
            Nodo aux = L;
            Nodo ant = null;
            while ((aux != null) && (aux.getDato() <= elemento)) {
                ant = aux;
                aux = aux.getEnlace();
            }
            if (ant == null) { //insertar en primera posicion
                Nodo p = new Nodo();
                p.setDato(elemento);
                p.setEnlace(L);
                L = p;
                cant++;
            } else {
                if (ant.getDato() != elemento) { //no se ingresan valores repetidos
                    Nodo p = new Nodo();
                    p.setDato(elemento);
                    ant.setEnlace(p);
                    p.setEnlace(aux);
                    cant++;
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

    public void invertir() {
        if (vacia()) {
        } else {
            if (cant == 1) {
            } else {
                Nodo ant = null;
                Nodo act = L;
                Nodo pos = act.getEnlace();
                while (act != null) {
                    act.setEnlace(ant);
                    ant = act;
                    act = pos;
                    if (pos != null) {
                        pos = pos.getEnlace();
                    }
                }
                L = ant;
            }
        }
    }

    public void invertirRecursivo() {
        invertirR(L);
    }

    private void invertirR(Nodo p) {
        if (p == null) {
            //nada
        } else {
            if (p.getEnlace() == null) {
                L = p;
            } else { //caso general
                invertirR(p.getEnlace());
                //uniendo
                p.getEnlace().setEnlace(p);
                p.setEnlace(null);
            }
        }
    }

    public void invertirDe2() {
        Nodo a ;
        Nodo b ;
        Nodo sig ;
        if (vacia()) {
            //nada
        } else {
            if (L.getEnlace() == null) {
                //nada
            } else {
                if (cant % 2 == 0) {  //si la cantidad es par 
                    a = L;
                    b = a.getEnlace();
                    sig = b.getEnlace();
                    L = b;
                } else {              //si la cantidad es impar
                    a = L.getEnlace();
                    b = a.getEnlace();
                    sig = b.getEnlace();
                    L.setEnlace(b);
                }
                for (int i = 1; i <= (cant / 2) - 1; i++) {
                        a.setEnlace(sig.getEnlace());
                        b.setEnlace(a);
                        a = sig;
                        b = a.getEnlace();
                        sig = b.getEnlace();
                    }
                b.setEnlace(a);
                a.setEnlace(sig);
            }
        }
    }
    
    public void invertirde2Atras(){
         Nodo ant = null;
         Nodo aux = L;
         Nodo sig = aux.getEnlace();
         while(sig != null){
             aux.setEnlace(sig.getEnlace());
             sig.setEnlace(aux);
             if(aux != L){
                 ant.setEnlace(sig);
             }else{
                 L = sig;
             }
             ant = aux;
             aux = aux.getEnlace();
             if(aux == null){
                 sig = aux;
             }else{
                 sig = aux.getEnlace();
             }
         }
    }
    
    public void invertirde3(){
        if(getcant() <= 2){
            //nada
        }else{ //invertir
            int i=1;
            Nodo aux = L;
            Nodo b = aux.getEnlace();
            Nodo c = b.getEnlace();
            Nodo sig = c.getEnlace();
            L = c;
            while(i <= (getcant()/3)-1){
                c.setEnlace(b);
                b.setEnlace(aux);
                aux.setEnlace(sig.getEnlace().getEnlace());
                aux = sig;
                b = aux.getEnlace();
                c = b.getEnlace();
                sig = c.getEnlace();
                i++;
            }
            c.setEnlace(b);
            b.setEnlace(aux);
            if(getcant()%3 != 0){
                aux.setEnlace(sig);
            }else{
                aux.setEnlace(null);
            }
            
        }
    }
    
    public void intercambiarmedios(){
        if(getcant() <= 2){
            //nada
        }else{ //invertir
            int i=1;
            Nodo aux = L;
            Nodo b = aux.getEnlace();
            Nodo c = b.getEnlace();
            Nodo sig = c.getEnlace();
            L = b;
            while(i <= (getcant()/3)-1){
                c.setEnlace(aux);
                aux.setEnlace(sig.getEnlace());
                aux = sig;
                b = aux.getEnlace();
                c = b.getEnlace();
                sig = c.getEnlace();
                i++;
            }
            c.setEnlace(aux);
            if(getcant()%3 != 0){
                aux.setEnlace(sig);
            }else{
                aux.setEnlace(null);
            }
            
        }
    }
    
    public void intercambiarExtremos(){
        Nodo ultimo = L;
        Nodo penultimo = ultimo;
        Nodo primero = L;
        
        while(ultimo.getEnlace() != null){
            penultimo = ultimo;
            ultimo = ultimo.getEnlace();
        }
        L = ultimo;
        ultimo.setEnlace(primero.getEnlace());
        primero.setEnlace(null);
        penultimo.setEnlace(primero);
        
    }
    
    public void invertirde4(){
        if(getcant() <= 3){
            //nada
        }else{ //invertir
            int i=1;
            Nodo aux = L;
            Nodo b = aux.getEnlace();
            Nodo c = b.getEnlace();
            Nodo d = c.getEnlace();
            Nodo sig = d.getEnlace();
            L = d;
            while(i <= (getcant()/4)-1){
                d.setEnlace(c);
                c.setEnlace(b);
                b.setEnlace(aux);
                aux.setEnlace(sig.getEnlace().getEnlace().getEnlace());
                aux = sig;
                b = aux.getEnlace();
                c = b.getEnlace();
                d = c.getEnlace();
                sig = d.getEnlace();
                i++;
            }
            d.setEnlace(c);
            c.setEnlace(b);
            b.setEnlace(aux);
            if(getcant()%4 != 0){
                aux.setEnlace(sig);
            }else{
                aux.setEnlace(null);
            }
            
        }
    }
    
    public void invertirExtremode4(){
        if(getcant() <= 3){
            //nada
        }else{ //invertir
            int i=1;
            Nodo aux = L;
            Nodo b = aux.getEnlace();
            Nodo c = b.getEnlace();
            Nodo d = c.getEnlace();
            Nodo sig = d.getEnlace();
            L = d;
            while(i <= (getcant()/4)-1){
                d.setEnlace(b);
                c.setEnlace(aux);
                aux.setEnlace(sig.getEnlace().getEnlace().getEnlace());
                aux = sig;
                b = aux.getEnlace();
                c = b.getEnlace();
                d = c.getEnlace();
                sig = d.getEnlace();
                i++;
            }
            d.setEnlace(b);
            c.setEnlace(aux);
            if(getcant()%4 != 0){
                aux.setEnlace(sig);
            }else{
                aux.setEnlace(null);
            }
            
        }
    }
    
    public void insertarRepetido(int elemento) {
        if (vacia()) {
            Nodo p = new Nodo();
            p.setDato(elemento);
            L = p;
            cant++;
        } else { //hay mas elementos
            Nodo aux = L;
            Nodo ant = null;
            while ((aux != null) && (aux.getDato() <= elemento)) {
                ant = aux;
                aux = aux.getEnlace();
            }
            if (ant == null) { //insertar en primera posicion
                Nodo p = new Nodo();
                p.setDato(elemento);
                p.setEnlace(L);
                L = p;
                cant++;
            } else {
                //if (ant.getDato() != elemento) { //no se ingresan valores repetidos
                    Nodo p = new Nodo();
                    p.setDato(elemento);
                    ant.setEnlace(p);
                    p.setEnlace(aux);
                    cant++;
                //}
            }
        }
    }
    
    public void eliminarElemUnicos(){
        if(!vacia()){
            if(L.getEnlace() == null){
                L = null;
                cant = 0 ;
            }
            Nodo ant = null;
            Nodo aux = L;
            while(aux.getEnlace() != null){
                if(ant == null){
                    if(aux.getDato() != aux.getEnlace().getDato()){
                        L = aux.getEnlace();
                        ant = null;
                        aux = L;
                        cant--;
                    }else{
                        ant = aux;
                        aux = aux.getEnlace();
                    }
                }else{
                    if((ant.getDato() != aux.getDato()) && (aux.getDato() != aux.getEnlace().getDato())){
                        ant.setEnlace(aux.getEnlace());
                        aux = ant.getEnlace();
                        cant--;
                    }else{
                        ant = aux;
                        aux = aux.getEnlace();
                    }
                }
            }
            if((ant != null) && (ant.getDato() != aux.getDato())){
                ant.setEnlace(null);
                cant--;
            }else{
                L = null;
                cant = 0;
            }
        }
    }
    
    public void eliminarElemRepetidos(){
        if(!vacia()){
            if(L.getEnlace() == null){
                //nada
            }
            Nodo ant = null;
            Nodo aux = L;
            while(aux.getEnlace() != null){
                if(ant == null){
                    if(aux.getDato() == aux.getEnlace().getDato()){
                        L = aux.getEnlace();
                        ant = null;
                        aux = L;
                        cant--;
                    }else{
                        ant = aux;
                        aux = aux.getEnlace();
                    }
                }else{
                    if((ant.getDato() == aux.getDato()) || (aux.getDato() == aux.getEnlace().getDato())){
                        ant.setEnlace(aux.getEnlace());
                        aux = ant.getEnlace();
                        cant--;
                    }else{
                        ant = aux;
                        aux = aux.getEnlace();
                    }
                }
            }
            if((ant != null) && (ant.getDato() == aux.getDato())){
                ant.setEnlace(null);
                cant--;
            }
        }
    }
    
    public void eliminarElemRepetidos(int elemento){
        if(!vacia()){
            if(L.getEnlace() == null){
                //nada
            }
            Nodo ant = null;
            Nodo aux = L;
            while(aux.getEnlace() != null){
                if(ant == null){
                    if((aux.getDato() == elemento) && (aux.getDato() == aux.getEnlace().getDato())){
                        L = aux.getEnlace();
                        ant = null;
                        aux = L;
                        cant--;
                    }else{
                        ant = aux;
                        aux = aux.getEnlace();
                    }
                }else{
                    if((ant.getDato() == elemento) && ((ant.getDato() == aux.getDato()) || (aux.getDato() == aux.getEnlace().getDato()))){
                        ant.setEnlace(aux.getEnlace());
                        aux = ant.getEnlace();
                        cant--;
                    }else{
                        ant = aux;
                        aux = aux.getEnlace();
                    }
                }
            }
            if((ant != null) && (ant.getDato() == aux.getDato())){
                ant.setEnlace(null);
                cant--;
            }
        }
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

    public static void main(String[] args) {
        Lista l = new Lista();
        l.insertarRepetido(1);
        l.insertarRepetido(2);
        l.insertarRepetido(3);
        l.insertarRepetido(4);
        l.insertarRepetido(5);
        l.insertarRepetido(6);
        l.insertarRepetido(7);
        l.insertarRepetido(8);
        l.insertarRepetido(9);

        System.out.println(l+ " cantidad: "+l.getcant());
        l.intercambiarExtremos();
        System.out.println(l+ " cantidad: "+l.getcant());
    }

}
