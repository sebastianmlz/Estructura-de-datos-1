
package Preg7_Dupla;


public class Dupla {
    
     int primero;
     int segundo;
     
     public Dupla(){
         this.primero = 0;
         this.segundo = 0;
    }
     
    public Dupla(int primero, int segundo) {
        this.primero = primero;
        this.segundo = segundo;
    }

    public int getPrimero() {
        return primero;
    }

    public void setPrimero(int primero) {
        this.primero = primero;
    }

    public int getSegundo() {
        return segundo;
    }

    public void setSegundo(int segundo) {
        this.segundo = segundo;
    }
    
    public Dupla multiplicar( int multiplo){
        Dupla dupla;
        primero = getPrimero() * multiplo;
        segundo = getSegundo() * multiplo;
        return dupla = new Dupla(primero, segundo);
    }
    
    public Dupla adicionar( int adicion){
        Dupla dupla;
        primero = getPrimero() + adicion;
        segundo = getSegundo() + adicion;
        return dupla = new Dupla(primero, segundo);
    }
    
    public  Dupla sumar(Dupla d1, Dupla d2){
        Dupla dupla;
        primero = d1.getPrimero() + d2.getPrimero() ;
        segundo = d1.getSegundo() + d2.getSegundo() ;
        return dupla = new Dupla(primero, segundo);
    }
    
    public Dupla restar(Dupla d1, Dupla d2){
        Dupla dupla;
        primero = d1.getPrimero() - d2.getPrimero() ;
        segundo = d1.getSegundo() - d2.getSegundo() ;
        return dupla = new Dupla(primero, segundo);
    }
    
    public Dupla multiplicarD(Dupla d1, Dupla d2){
        Dupla dupla;
        primero = d1.getPrimero() * d2.getPrimero() ;
        segundo = d1.getSegundo() * d2.getSegundo() ;
        return dupla = new Dupla(primero, segundo);
    }
    
    @Override
    
    public String toString(){
        return "{ "+getPrimero()+", "+getSegundo()+" }";
    }
    
}