

package Pregg14_ComplejoReal;


public class ComplejoReal {
    double parteR;
    double parteI;

    public ComplejoReal(double parteR, double parteI) {
        this.parteR = parteR;
        this.parteI = parteI;
    }
    
    public static ComplejoReal establecer(double real, double imag){
        return new ComplejoReal(real, imag);
    }
    
    public void agregar(double real, double imag){
        parteR =  parteR + real;
        parteI = parteI + imag;
    }
    
    public void agregar(ComplejoReal complejo){
        parteR = parteR + complejo.parteR;
        parteI = parteI + complejo.parteI;
    }
    
    public String imprimir(){
        String s = "( ";
        if(parteI > 0)
            return s + parteR + " + " + parteI + " i )";
        else
            return s + parteR +" " + parteI + " i )";
    }
    
}
