/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Negocio;

/**
 *
 * @author sebas
 */
public class ColaL {
    
    Nodo Frente;
    Nodo Atras;
    int cant;
    
    public ColaL() {
        this.Frente = null;
        this.Atras = null;
        this.cant = 0;
    }
    
    public boolean Vacia(){
        return Frente==null;
    }
    
    public void Encolar(int ele){
        Nodo p=new Nodo();
        p.setDato(ele);
        if (Vacia()){
            Frente=p;
            Atras=p;
            cant++;
        }else{ 
            Atras.setEnlace(p);
            Atras=p;
            cant++;
        }
    }
    
    public int Decolar(){
        int x=Frente.getDato();
        if(Frente==Atras){
            Frente=null;
            Atras=null;
            cant--;
        }else{ Frente=Frente.getEnlace();
            cant--;
        }
        return(x);
    }
    
    public int Get(){
        return Atras.getDato();
    }
    
    public int cantidad(){
        return (cant);
    }
    
    public boolean identicas(ColaL cola){
        boolean identicas = false;
        if(!Vacia()){
            if(!cola.Vacia()){
                int tamaC1 = cantidad();
                int tamaC2 = cola.cantidad();
                if(tamaC1 == tamaC2){
                    int cont=0;
                    for(int i=0; i<tamaC1; i++){
                        Encolar(Decolar());
                        cola.Encolar(cola.Decolar());
                        if(Get() == cola.Get()){
                            cont++;
                        }
                    }
                    if(cont == tamaC1){
                        identicas = true;
                    }
                }
            }
        }
        return identicas;
    }
    
    public void invertirRecursivo(){
        if(Vacia()){
            //nada
        }else{
            if(cantidad()==1){
                //nada;
            }else{
                int elemento = Decolar();
                invertirRecursivo();
                
                Encolar(elemento);
            }
        } 
    }
    
    public void invertir(){
        if(!Vacia()){
            if(cantidad()==1){
                //nada
            }else{
                int dato,tamañoC;
                ColaL aux = new ColaL();
                tamañoC = cantidad();
                for(int i=0; i<tamañoC-1; i++){
                    dato = Decolar();
                    aux.Encolar(dato);
                }
                int tamAux = aux.cantidad()-1;
                for(int i=0; i<tamañoC-1; i++){
                    int j= i;
                    while (j<tamAux) {                        
                        aux.Encolar(aux.Decolar());
                        j++;
                    }
                    Encolar(aux.Decolar());
                    if(aux.cantidad()==1){
                        Encolar(aux.Decolar());
                        i=cantidad();
                    }
                }
            }
        }
    }
    
    public void eliminarRepetidos(){
        int tamC = cantidad();
        int cabeza;
        int c=0;
        for(int i=0; i<tamC;i++){
            int tam = cantidad();
            cabeza= Decolar();
            for(int j=0 ; j<tam-1; j++){
                int x=Decolar();
               if(x==cabeza){
                   //nada
               }else{
                   Encolar(x);
               } 
            }
            Encolar(cabeza);
            tamC=cantidad();
        }
    }
    
    public void intercambiar(){
        if(!Vacia()){
            int dato,tamañoP, tamañoC;
                tamañoC = cantidad();
                int cabezaCola = Decolar();
                for(int i=0; i<cantidad()-1; i++){
                    dato = Decolar();
                    Encolar(dato);
                }
                Encolar(cabezaCola);
        }
    }
    
    
    public void intercambiarMitades(ColaL q1, ColaL q2){
        if(!q1.Vacia()){
            if(!q2.Vacia()){
                if((q1.cantidad()%2 == 0) && (q2.cantidad()%2 == 0)){
                    int tamaq1 = q1.cantidad() / 2;
                    int tamaq2 = q2.cantidad() / 2;
                    for(int i=0; i<tamaq2; i++){
                        q1.Encolar(q2.Decolar());
                    }
                    for(int i=0; i<tamaq1; i++){
                        q2.Encolar(q1.Decolar());
                    }
                    for(int i=0; i<tamaq1; i++){
                        q1.Encolar(q1.Decolar());
                    }
                    for(int i=0; i<tamaq2; i++){
                        q2.Encolar(q2.Decolar());
                    }
                }else{
                    System.out.println("Error: CambiarMitad: La cola no es de dimension par");
                }
            }
        }
    }
    
    public void intercambiarContenido( ColaL q2){
        int tamaq1 = cantidad() ;
                int tamaq2 = q2.cantidad() ;
                for(int i=0; i<tamaq2; i++){
                    Encolar(q2.Decolar());
                }
                for(int i=0; i<tamaq1; i++){
                    q2.Encolar(Decolar());
                }
        
    }
    
    public void eliminarRepetidosYsimismo(){
        int cant = cantidad();
        int dato, cont, Ncant, num;
        boolean repe;
        for(int i=0;i < cant; i++){
            dato = Decolar();
            cont=0;
            Ncant = cantidad();
            repe = false;
            while(cont < Ncant){
                num = Decolar();
                if(dato == num){
                    repe = true;
                    cant--;
                }else{
                    Encolar(num);
                }
                cont++;
            }
            if(repe == false){
                Encolar(dato);
            }
        }
    }
    
    /*
    public void eliminarRepetidos2(){
        if (!Vacia()) {
            Nodo actual = Frente;
            while (actual != null) {
                Nodo anterior = actual;
                Nodo siguiente = actual.getEnlace();
                while (siguiente != null) {
                    if (actual.getDato() == siguiente.getDato()) {
                        anterior.setEnlace(siguiente.getEnlace());
                        this.cant--;
                    }else{
                        anterior = siguiente;
                    }
                    siguiente = siguiente.getEnlace();
                }

                actual = actual.getEnlace();
            }

            Atras = Frente;
            while(Atras != null && Atras.getEnlace() != null){
                Atras = Atras.getEnlace();
            }
        }
        
    }
    
    public void eliminarRepetidos3() {
        int tamC = cantidad();
        ColaL aux = new ColaL();
        ColaL temp = new ColaL();

        for (int i = 0; i < tamC; i++) {
            int cabeza = Decolar();
            boolean repetido = false;

            // Recorremos la cola auxiliar para verificar si el elemento ya está presente
            int auxTam = aux.cantidad();
            for (int j = 0; j < auxTam; j++) {
                int auxDato = aux.Decolar();
                if (auxDato == cabeza) {
                    repetido = true;
                }
                aux.Encolar(auxDato);
            }

            // Si el elemento no es repetido, lo encolamos en aux
            if (!repetido) {
                aux.Encolar(cabeza);
            }

            // Siempre encolamos el elemento en temp para mantener el orden original
            temp.Encolar(cabeza);
        }

        // Restauramos los elementos a la cola original desde temp
        int tempTam = temp.cantidad();
        for (int i = 0; i < tempTam; i++) {
            Encolar(temp.Decolar());
        }

        // Finalmente, transferimos los elementos únicos de aux a la cola original
        int auxTam = aux.cantidad();
        for (int i = 0; i < auxTam; i++) {
            Encolar(aux.Decolar());
        }
    }*/

    

    
    
    @Override
    public String toString() {
        String S="C-> ";
        Nodo aux=Frente;
        while (aux!=null){
            S=S+aux.getDato()+" -> ";
            aux=aux.getEnlace();
        }
        return S;
    }

}
