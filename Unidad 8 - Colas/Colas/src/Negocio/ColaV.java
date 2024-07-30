/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Negocio;

/**
 *
 * @author sebas
 */
public class ColaV {
    int C[];
    int Frente; // Indice a la cabeza de la Cola
    int Atras; //Indice al final de la cola
    
    
    public ColaV(int cant) {
        this.C = new int[cant];
        this.Frente = -1;
        this.Atras = -1;
    }
    
    public boolean vacia(){
        return (Frente==-1);
    }
    
    public boolean Llena(){
        return((Atras+1)%C.length==Frente);
    }
    
    public void Encolar(int ele){
        if (vacia()){
            Frente=0;
            Atras=0;
            C[Atras]=ele;
        }else{
            if (Llena()){
                System.out.println("Error::Encolar:Cola Llena");
                System.exit(1);
            }else{
                Atras=(Atras+1)%C.length;
                C[Atras]=ele;
            }
        }
}
    
    public int Decolar(){
        int x=C[Frente];
        if (Frente==Atras){//SOLO HAY UN DATO
            Frente=-1;
            Atras=-1;
        }else
            Frente=(Frente+1)%C.length;
        return x;
    }
    
    public int Get(){
        return(C[Frente]);
    }
    
    public int longitud(){
        ColaV qaux = new ColaV(C.length);
        int i=0;
        while(!vacia()){
            qaux.Encolar(Decolar());
            i++;
        }
        while(!qaux.vacia()){
            Encolar(qaux.Decolar());
        }
        return i;
    }
    
    public void eliminarRepetidosYsimismo(){
        int cant = longitud();
        int dato, cont, Ncant, num;
        boolean repe;
        for(int i=0;i < cant; i++){
            dato = Decolar();
            cont=0;
            Ncant = longitud();
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
    
    int c=0;
    public void encolarBicola(int elem){
        if(vacia()){
            Frente++;
            Atras++;
            C[Atras] = elem;
        }else{
            if(Llena()){
                System.out.println("Error: Insertar Bicola: llena");
            }else{
                if(c==1){
                    if(Frente==0){
                        Frente = C.length-1;
                    }else{
                        Frente--;
                    }
                    C[Frente] = elem;
                    c= 0;
                }else{
                    Atras = (Atras+1) % C.length;
                    C[Atras] = elem;
                    c = 1;
                }
            }
            
        }
    }    
    
    public int getCant(){
        return C.length;
    }
    
    public String toStringBicola(){
        String S="Q=[";
        for(int i=0; i<getCant();i++){
            if(C[i] != 0){
                S = S + C[i] + ",";
            }
        }
        return S+"]";
    }
    
    
    @Override
    public String toString() {
        String S="Q=[";
        int Aux=Frente;
        if(Aux != -1){
            while (Aux!=Atras){
            S=S+C[Aux]+" , ";
            Aux=(Aux+1)%C.length;
            }
            S=S+C[Aux]+"]";
        }else{
            S=S+"]";
        }
        return S;
    }
   
}
