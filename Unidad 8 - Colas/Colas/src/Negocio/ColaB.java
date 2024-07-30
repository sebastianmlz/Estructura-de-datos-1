/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Negocio;

/**
 *
 * @author sebas
 */
public class ColaB {
    VectorNbit C;
    int Frente;
    int Atras;
    
    public ColaB(int cant, int nbits) {
        this.C = new VectorNbit(cant,nbits);
        this.Frente = 0;
        this.Atras = 0;
    }
    
    public boolean vacia(){
        return (Frente==0);
    }
    
    public boolean Llena(){
        return((Atras+1)%C.dim==Frente);
    }
    
    public void Encolar(int ele){
        if (vacia()){
        Frente=1;
        Atras=1;
        C.Insertar(ele,Atras);
        }else{
            if (Llena()){
            System.out.println("Error::Encolar:Cola Llena");
            System.exit(1);
            }else{
                Atras=(Atras+1)%C.dim;
                C.Insertar(ele,Atras);
            }
        }
    }
    
    public int Decolar(){
        int x=C.Sacar(Frente);
        if (Frente==Atras){
            Frente=0;
            Atras=0;
        }else
            Frente=(Frente+1)%C.dim;
        return x;
    }
    
    public int Get(){
        return(C.Sacar(Frente));
    }
    
    @Override
    public String toString() {
        String S="Q=[";
        int Aux=Frente;
        while (Aux!=Atras){
            S=S+C.Sacar(Aux)+" , ";
            Aux=(Aux+1)%C.dim;
        }
        S=S+C.Sacar(Aux)+"]";
        return S;
    }
}
