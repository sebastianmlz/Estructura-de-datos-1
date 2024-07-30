
package Pregg10_Naturales;


public class Naturales {
    
       int natural ;
    
    public Naturales(){
        this.natural = 0;
    }
    
    public Naturales(int n){
        if(n >= 0){
           this.natural = n+1; 
        }else
            System.out.println("Error: Numero ingresado no es natural");
    }

    public int getNatural() {
        return natural;
    }
    
    public void setNatural(int natural) {
        this.natural = natural;
    }
    
    public int cero() {
        return this.natural = 0;
    }
    
    public static int Sucesor(int n){
        if(n >= 0){
            return n +1;
        }else{
            throw new IllegalStateException("El numero ingresado no es un numero natural");
               
        }
    }
    
    public boolean EsCero(){
        return natural == 0;
    }
    
    public  static boolean igual(Naturales n1, Naturales n2){
        return n1.natural == n2.natural;
    }
    
    public  void Suma(Naturales n1, Naturales n2){
        natural = n1.natural + n2.natural ;
    }
    public Naturales Antecesor(Naturales n){
        this.natural = n.natural -1;
        return this;
    }
    
    public void Diferencia(Naturales n1, Naturales n2){
        natural = n1.natural - n2.natural;
    }
    
    public void Menor(Naturales n1, Naturales n2){
       if(n1.natural == n2.natural)
            System.out.println("Ambos numeros son iguales");
       else{
           if(n1.natural < n2.natural)
               natural = n1.natural;
           else
               natural = n2.natural;
       }
    }
    
    @Override
    public String toString(){
        String s = "";
        if(this.natural < 0)
            return " (Resultado no es un numero natural) ";
        else
            return "N: "+ getNatural();
    }
    
}
